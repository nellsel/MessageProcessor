google.load('visualization', '1', {
	'packages' : [ 'geochart' ]
});
google.setOnLoadCallback(drawMarkersMap);

function drawMarkersMap() {

	var jsonData = $.ajax({
        url: "list-json",
        dataType:"json",
        async: false
        }).responseText;

	var data = new google.visualization.DataTable(jsonData);

	var options = {
		sizeAxis : {
			minValue : 0,
			maxValue : 10
		},
		magnifyingGlass : {
			enable : true,
			zoomFactor : 5.0
		},
		legend : {
			textStyle : {
				color : 'blue',
				fontSize : 16
			}
		},
		displayMode : 'markers',
		colorAxis : {
			colors : [ '#e7711c', '#4374e0' ]
		}
	// orange to blue
	};

	var chart = new google.visualization.GeoChart(document
			.getElementById('chart_div'));
	chart.draw(data, options);
};