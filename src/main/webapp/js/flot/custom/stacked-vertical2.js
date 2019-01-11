var $border_color = "#efefef";
var $grid_color = "#ddd";
var $default_black = "#666";
var $red = "#FF6464";
var $blue = "#177bbb";
var $green = "#abd14f";
var $yellow = "#ffaa3a";
var $grey = "#999999";
var $blue_one = "#74b1d4";
var $blue_two = "#84bad9";
var $blue_three = "#9bc7e0";
var $blue_four = "#afd2e6";
var $blue_five = "#badff2";

$(function () {

	var d1, d2, data, chartOptions;

	d1 = [
			[1325376000000, 1200], [1328054400000, 700], [1330560000000, 1000], [1333238400000, 600],
			[1335830400000, 350]
		];
 
		d2 = [
			[1325376000000, 800], [1328054400000, 600], [1330560000000, 300], [1333238400000, 350],
			[1335830400000, 300]
		];

		data = [{
			label: 'Referral',
			data: d1
		}, {
			label: 'Direct',
			data: d2
		}];

		chartOptions = {
			xaxis: {
				min: (new Date(2011, 11, 15)).getTime(),
				max: (new Date(2012, 04, 18)).getTime(),
				mode: "time",
				tickSize: [2, "month"],
				monthNames: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
				tickLength: 0
			},
			grid:{
        hoverable: true,
        clickable: false,
        borderWidth: 1,
        tickColor: '#eee',
        borderColor: '#eee',
      },
			series: {
				stack: true
			},
			bars: {
			show: true,
			barWidth: 36*24*60*60*300,
				fill: true,
				align: 'center',
				lineWidth: 1,
				lineWidth: 0,
				fillColor: { colors: [ { opacity: 1 }, { opacity: 1 } ] }
			},
			shadowSize: 0,
			tooltip: true,
			tooltipOpts: {
				content: '%s: %y'
			},
			colors: [$red, $blue, $green, $yellow, $grey],
		}

		var holder = $('#stacked-v-chart');

		if (holder.length) {
				$.plot(holder, data, chartOptions );
		}



});