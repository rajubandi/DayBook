$(function(){
	
	$("#cp-form").validate({
	    errorElement: 'span',
	    errorClass: 'has-error',
		rules:
		{
			oldPassword:{required: true},
			password:{required: true},
	        retypePassword:{required: true},
		},
		messages:
	   	{
			oldPassword:{required: 'Current Password'},
			password:{required:'New Password'},
	        retypePassword:{required:'Confirm Password'},
		},
		errorPlacement: function(error, element){
		      if(element.attr("name") == "oldPassword")
		        error.insertAfter(".oldPassword_error").css("color", "red");
		      else
		          error.insertAfter(element);
		}
	  });

	  $('#cancel').click(function () {
	    $("#cp-form").validate().resetForm();
	    $("#cp-form").removeClass("has-error");
	    $("#oldPassword").val('');
	    $("#password").val('');
	    $("#retypePassword").val('');
	    $("#cp-form").addClass('form-horizontal');
	  });
});