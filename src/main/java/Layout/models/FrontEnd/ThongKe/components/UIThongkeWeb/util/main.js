google.charts.load('current', { packages: ['corechart'] });
google.charts.setOnLoadCallback(drawChart);

var chart;
var data;
var options;

function drawChart() {
	data = google.visualization.arrayToDataTable([
		[
			'Brand',
			'Market Share',
			{ role: 'tooltip', type: 'string', p: { html: true } },
		],
		['Samsung', 31.2, 'Samsung: 31.2%'],
		['Apple', 29.0, 'Apple: 29.0%'],
		['Huawei', 12.4, 'Huawei: 12.4%'],
		['Xiaomi', 10.3, 'Xiaomi: 10.3%'],
		['Oppo', 8.6, 'Oppo: 8.6%'],
		['Other', 8.5, 'Other: 8.5%'],
	]);

	options = {
		title: 'Smartphone Market Share - 2025',
		pieHole: 0.4,
		pieSliceText: 'label',
		slices: {
			0: { offset: 0.1, color: '#3366CC' },
			1: { color: '#DC3912' },
			2: { color: '#FF9900' },
			3: { color: '#109618' },
			4: { color: '#990099' },
			5: { color: '#3B3EAC' },
		},
		tooltip: { isHtml: true },
		legend: { position: 'labeled' },
		is3D: true,
	};

	chart = new google.visualization.PieChart(
		document.getElementById('piechart'),
	);
	chart.draw(data, options);
}

// Add an event listener to redraw the chart when the window is resized
window.addEventListener('resize', drawChart);
