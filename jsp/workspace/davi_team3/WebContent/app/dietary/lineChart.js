//차트 로딩
google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawWeight);

//데이터, 옵션 입력
function drawWeight() {

      var data = new google.visualization.DataTable();
      data.addColumn('number', '날짜');
      data.addColumn('number', '몸무게');
      //DB에서 데이터 가져오기 ['날짜',몸무게]
      data.addRows([
    	  [0, 0],   [1, 10],  [2, 23],  [3, 17],  [4, 18],  [5, 9],
          [6, 11],  [7, 27],  [8, 33],  [9, 40],  [10, 32], [11, 35],
          [12, 30], [13, 40], [14, 42], [15, 47], [16, 44], [17, 48],
          [18, 52], [19, 54], [20, 42], [21, 55], [22, 56], [23, 57],
          [24, 60], [25, 50], [26, 52], [27, 51], [28, 49], [29, 53],
          [30, 55], [31, 60]        
      ]);

      var options = {
    	//x축
        hAxis: {        	
          title: '날짜'
        },
        //y축
        vAxis: {
          title: '몸무게'
        },  
      //라인의 색상
        series: {
        	0: {color: '#ffaec9'}        	
        }
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
      chart.draw(data, options);
      
      //반응형 크기 조절
      window.addEventListener('resize', drawWeight, false);
    }