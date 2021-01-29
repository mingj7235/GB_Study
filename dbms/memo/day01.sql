CREATE TABLE student (
	ID NUMBER(8),
	NAME VARCHAR2(100),
	MAJOR VARCHAR2(200),
	GENDER CHAR(1) DEFAULT 'W' NOT NULL CONSTRAINT BAN_CHAR CHECK(GENDER IN('M', 'W')),
	BIRTH DATE CONSTRAINT BAN_DATE CHECK(BIRTH >= TO_DATE('1980-01-01', 'YYYY-MM-DD')),
	CONSTRAINT STD_PK PRIMARY KEY(ID)
);

SELECT * FROM STUDENT;

INSERT INTO STUDENT (ID, NAME, MAJOR, BIRTH)
VALUES (1, '한동석', '경영학과', TO_DATE('1981-12-04', 'YYYY-MM-DD'));


-- DML


--PLAYER테이블에서 TEAM_ID가 'K01'인 선수 검색

SELECT * FROM PLAYER WHERE TEAM_ID = 'K01';

--PLAYER 테이블에서 TEAM_ID가 'K01'이 아닌 선수 검색
SELECT * FROM PLAYER WHERE TEAM_ID != 'K01';
SELECT * FROM PLAYER WHERE TEAM_ID <> 'K01';

--PLAYER 테이블에서 WEIGHT가 70 이상이고 80 이하인 선수 검색
SELECT * FROM PLAYER WHERE WEIGHT >= 70 AND WEIGHT <=80;
SELECT * FROM PLAYER WHERE WEIGHT BETWEEN 70 AND 80;

--PLAYER 테이블에서 TEAM_ID가 'K06'이고 NICKNAME이 '제리'인 선수 검색

SELECT * FROM PLAYER WHERE TEAM_ID = 'K06' AND NICKNAME = '제리';

--PLAYER테이블에서 HEIGHT가 170 이상이고 WEIGHT가 80이상인 선수 이름 검색
SELECT PLAYER_NAME FROM PLAYER WHERE HEIGHT >=170 AND WEIGHT >= 80;

--STADIUM 테이블에서 SEAT_COUNT가 30000초과이고 41000이하인 경기장 검색
SELECT * FROM STADIUM WHERE SEAT_COUNT > 30000 AND SEAT_COUNT <= 41000;
SELECT * FROM STADIUM WHERE SEAT_COUNT BETWEEN 30001 AND 41000;

--PLAYER 테이블에서 TEAM_ID가 'K02'이거나 'K07'이고 포지션은 'MF'인 선수 검색
-- AND는 OR보다 우선순위가 높으므로 먼저 하기위해서 괄호로 묶어줘야한다. 
SELECT * FROM PLAYER
WHERE (TEAM_ID = 'K02' OR TEAM_ID = 'K07') AND "POSITION" = 'MF'; --AND가 먼저 되므로 괄호로 묶어줘야한다.

SELECT * FROM PLAYER
WHERE TEAM_ID IN('K02', 'K07') AND "POSITION" = 'MF';



--CASE문 사용
--STADIUM 테이블에서 SEAT_COUNT가 0 이상 30000이하면 'S' 30001이상 50000이하면 'M' 다 아니면 'L'
SELECT STADIUM_ID,
CASE 
	WHEN (S.SEAT_COUNT BETWEEN 0 AND 30000) THEN 'S'
	WHEN (S.SEAT_COUNT BETWEEN 30001 AND 50000) THEN 'M'
	ELSE 'L'
END AS STADIUM_SIZE
FROM STADIUM S;

SELECT STADIUM_NAME 경기장, SEAT_COUNT "좌석 수",
	CASE 
		WHEN SEAT_COUNT BETWEEN 0 AND 30000 THEN 'S'
		ELSE (
			CASE WHEN SEAT_COUNT BETWEEN 30001 AND 50000 THEN 'M'
			ELSE 'L'
		END
		)
	END AS 규모
FROM STADIUM;



SELECT S.*,
	CASE 
		WHEN SEAT_COUNT BETWEEN 0 AND 30000 THEN 'S'
		ELSE (
			CASE WHEN SEAT_COUNT BETWEEN 30001 AND 50000 THEN 'M'
			ELSE 'L'
		END
		)
	END AS 규모
FROM STADIUM S;

--CASE문은 COST가 많이들어간다. 즉 많은 메모리를 활용한다. 그렇기때문에 CASE문을 잘 활용하지 않는다. 



--EMPLOYEES 테이블에서 평균보다 낮은 사람들의 급여 10% 인상하기
SELECT * FROM EMPLOYEES;

UPDATE EMPLOYEES
SET SALARY = SALARY * 1.5
WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEES);

SELECT * FROM EMPLOYEES
WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEES);


--EMP 테이블에서 사원의 이름과 사원의 매니저 이름 조회
SELECT E1.ENAME 사원, E2.ENAME 매니저 FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO;




--EMP 테이블 사원번호로 DEPT 테이블의 지역 검색하기

SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT E.DEPTNO, E.ENAME, D.LOC FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;












