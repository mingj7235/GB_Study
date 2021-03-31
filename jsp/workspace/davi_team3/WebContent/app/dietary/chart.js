//차트 로딩
google.charts.load('current', {packages: ['corechart']});
google.charts.setOnLoadCallback(drawWeight);
google.charts.setOnLoadCallback(drawBMI);

//데이터, 옵션 입력
function drawWeight() {

      var data = new google.visualization.DataTable();
      data.addColumn('number', '날짜');
      data.addColumn('number', '나');
      //DB에서 데이터 가져오기 ['날짜',몸무게]
      data.addRows([
    	  [1, 40],  [2, 43],  [3, 47],  [4, 48],  [5, 50],
          [6, 41],  [7, 57],  [8, 33],  [9, 40],  [10, 32], [11, 35],
          [12, 30], [13, 40], [14, 42], [15, 47], [16, 44], [17, 48],
          [18, 52], [19, 54], [20, 42], [21, 55], [22, 56], [23, 57],
          [24, 60], [25, 50], [26, 52], [27, 51], [28, 49], [29, 53],
          [30, 55], [31, 60]        
      ]);

      var options = {
    	//x축
    	title : '몸무게',
        hAxis: {        	
          title: '날짜',
          minValue: 1, 
          maxValue: 31, 
          ticks: [5,10,15,20,25,30]          
        },
        //y축
        vAxis: {
          
          minValue: 30, 
          direction: -1
        },  
        height: 300,
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

function drawBMI() {
	
	var data = new google.visualization.DataTable();
    data.addColumn('number', '날짜');
    data.addColumn('number', '나');
    data.addColumn('number', '정상');

    data.addRows([
      [1,23, 21], [2, 22, 21], [3, 21, 21],
      [4, 20, 21], [5, 19, 21], [6, 18, 21],
      [7, 25, 21], [10, 19, 21], [11, 19, 21],
      [15, 22, 21], [16, 20, 21], [17, 18, 21]      
    ]);

	    var options = {
		title : 'BMI지수',
		hAxis : {
		title : '날짜',
		ticks: [5,10,15,20,25,30],
		maxValue: 31
		},		
		vAxis : {
			
			value : 4,
			height: 300,
			ticks: [15, 20, 25, 30]
		}
	};
	var chart = new google.visualization.LineChart(document.getElementById('chart_div2'));
	chart.draw(data, options);

	//반응형 크기 조절
	window.addEventListener('resize', drawBMI, false);
}