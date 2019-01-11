$(function () {

	$("#visits").sparkline([280,320,220,385,450,320,250,400,280,320,220,385,450,320], {
		type: 'bar',
		barWidth: 8,
		height: 60,
		width: 120,
		barSpacing: 3,
		barColor: '#177bbb',
		negBarColor: '#ffffaa'
	});
	$('#comments').sparkline([320,250,400,380,280,320,220,385,450], {
		type: 'line',
		lineWidth: 3,
		fillColor: false,
		lineColor: '#E24B46',
		spotColor: '#e13f3d',
		minSpotColor: '#50B432',
		maxSpotColor: '#f7b53c',
		highlightSpotColor: '#',
		height: 60,
		width: 120,
		spotRadius: 6,
	});

	$("#posts").sparkline([380,420,320,300,385,680,320,250,290,400,450], {
		type: 'bar',
		barWidth: 8,
		height: 60,
		width: 120,    
		barSpacing: 5,
		barColor: '#177bbb',
		negBarColor: '#ffffaa'
	});

	$("#emails").sparkline([3,2,4,3,5,4,3,5,2,4,7,9,12,15,12,11,12,11], {
		type: 'line',
		width: 120,
		height: 60,
		lineColor: '#177bbb',
		fillColor: '#e5f3fc',
		lineWidth: 3,
		spotRadius: 6
	});


	$("#likes").sparkline([320,290], {
    type: 'pie',
    width: 90,
    height: 90,
    sliceColors: ['#5B90BF', '#FF7043','#109618','#66aa00','#dd4477','#0099c6','#990099 ']
  });

  $("#balance").sparkline([175,240], {
    type: 'pie',
    width: 90,
    height: 90,
    sliceColors: ['#109618','#66aa00','#dd4477']
  });

});

// Flot Donut Charts
$(function(){
	// Donut 1
	$(function () {
		var data, chartOptions;
		data = [
			{ label: "", data: Math.floor (Math.random() * 100 + 130) }, 
			{ label: "", data: Math.floor (Math.random() * 100 + 520) }, 
		];
		chartOptions = {
			series: {
				pie: {
					show: true,  
					innerRadius: .85,
					stroke: {
						width: 1,
					}
				}
			}, 
			shadowSize: 0,
			legend: {
				position: 'sw'
			},
			tooltip: true,
			tooltipOpts: {
				content: '%s: %y'
			},
			grid:{
				hoverable: true,
				clickable: false,
				borderWidth: 0,
			},
			shadowSize: 0,
			colors: ["#E24B46", "#cccccc"],
		};
		var holder = $('#views');
		if (holder.length) {
			$.plot(holder, data, chartOptions );
		} 
	});

});
