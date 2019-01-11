$(function(){
	$("#mform").validate({
	    errorElement: 'span',
	    errorClass: 'has-error',
		rules:
		{
			excelfile2007:{required: true, extension: "xls"}
		},
		messages:
	   	{
			excelfile2007:{required: 'Upload Excel File', extension: 'Choose Only .xls'}
		},
		errorPlacement: function(error, element){
		      if(element.attr("name") == "excelfile2007")
		        error.insertAfter(".excelfile2007-error").css("color", "red");
		      else
		          error.insertAfter(element);
		}
	  });

	  $('#cancel').click(function () {
	    $("#mform").validate().resetForm();
	    $("#mform").removeClass("has-error");
	    $("#excelfile2007").val('');
	    $("#mform").addClass('form-horizontal');
	     });

});