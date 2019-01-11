$(document).ready(function() {
	  $('#board').change(function(event) {
	  	var board = $("select#board").val();
	  	$.get('JsonServlet', {
	  		boardName : board
	  	}, function(jsonResponse) {

	  	var select = $('#medium');
	  	select.find('option').remove();
	   	  $.each(jsonResponse, function(index, value) {
	  	  $('<option>').val(value).text(value).appendTo(select);
	  	  $('select#medium').find('option:first-child').val('').attr('disabled',true);
	        });
	  	});
	  	});
});

$(document).ready(function() {
	  $('#medium').change(function(event) {
	  	var medium = $("select#medium").val();
	  	$.get('JsonServlet1', {
	  		mediumName : medium
	  	}, function(jsonResponse) {

	  	var select = $('#clas');
	  	select.find('option').remove();
	   	  $.each(jsonResponse, function(index, value) {
	  	  $('<option>').val(value).text(value).appendTo(select);
	  	  $('select#clas').find('option:first-child').val('').attr('disabled',true);
	        });
	  	});
	  	});
});

$(document).ready(function() {
	  $('#clas').change(function(event) {
	  	var className = $("select#clas").val();
	  	$.get('JsonServlet2', {
	  		className : className
	  	}, function(jsonResponse) {

	  	var select = $('#section');
	  	select.find('option').remove();
	   	  $.each(jsonResponse, function(index, value) {
	  	  $('<option>').val(value).text(value).appendTo(select);
	  	  $('select#section').find('option:first-child').val('').attr('disabled',true);
	        });
	  	});
	  	});
});