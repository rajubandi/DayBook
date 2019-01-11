$(function(){
	
	
	var YearChanged = false;
	$("#startYear,#endYear").datepicker({
		changeDate : false,
		changeMonth : false,
		changeYear : true,
		showButtonPanel : false,
		dateFormat : 'yy',
		 minDate: +0,
	     //maxDate: +10,
	     //yearRange: minDate.getFullYear() + ':' + maxDate.getFullYear(),
		onChangeMonthYear: function(year, inst) {
	        YearChanged = true;
	    },
		 onClose: function(dateText, inst) { 
			
             //$(this).datepicker('setDate',inst.selectedYear);
             $('#'+inst.id).val(inst.selectedYear);
            
			 
       },
		}).focus(function () {
            $(".ui-datepicker-month").hide();
            $(".ui-datepicker-calendar").hide();
        });
	$("#cls-form").validate(
			{
				errorElement: 'span',
			    errorClass: 'has-error',
				rules:
				{
					startYear: {required: true},
					endYear: {required: true},
				},
				messages:
				{
					startYear: {required: 'Academic start year'},
					endYear: {required: 'Academic end year'},
				},
				errorPlacement: function(error, element)
				{
				      if(element.attr("name") == "name")
				        error.insertAfter(".name_error").css("color", "red");
				      else
				        error.insertAfter(element);
				}	
			});

				  $('#cancel').click(function () {
				    $("#cls-form").validate().resetForm();
				    $("#cls-form").removeClass("has-error");
				    $("#id").val(0);
				    $("#startYear").val('');
				    $("#endYear").val('');
				    $("#submitId").val("Submit");
				    $("#headId").text("Academic Year Creation");
				    $("#cls-form").addClass('form-horizontal');
				  });
				  
				  $('#submitId').click(function(){
						 
						 if($("#cls-form").valid()==true) {
							 
							if($('#startYear').val() == $('#endYear').val() ){ 
								
								alert("Academic Start Year and End Year Shouldn't be same");
								$('#startYear').val('');
								$('#endYear').val('');
								return false;
								
							 }else {
						    	 //$('#forFormValidation').val(1);
						    	 //$( "#submitId" ).prop( "disabled", true );
						    	 $("#submitId").attr("disabled",true);
								 $("#submitId").val("Please wait...");
								 $("form").submit();		
						    	 return true;
						     }
							 
						 }
					});

});
//remove borders
function removeBorder(el){	
	  $("#"+el).css("border", "");
	  $("#"+el).css('color','black');
	  $('#'+el).addClass('default-class');
	  if ($("#" + el+"_chosen").length)
		{
			$("#" +el+"_chosen").children('a').css('border-color','black');
		}
}

		function displayTable(listOrders) {
				$("#basicExample tr td").remove();
				$("#basicExample td").remove();
				serviceUnitArray = {};
				$
						.each(
								listOrders,
								function(i, orderObj) {
									if(orderObj.status == "1"){
										var deleterow = "<a class='deactivate' title='Active' onclick='deleteAcademicYear("+ orderObj.id+ ",0)'><i class='fa fa-eye' style=' color:blue ;'></i></a>";
										var cls="activecss";
									}else{  
										var deleterow = "<a class='activate'  title='Deactive' onclick='deleteAcademicYear("+ orderObj.id+ ",1)'><i class='fa fa-eye-slash' style=' color:red ;'></i></a>";
										var cls="inactivecss";
									}
									
									serviceUnitArray[orderObj.id] = orderObj;
									var tblRow = "<tr align='center' role='row' class='odd'>"  

											+ "<td class='' title='"+orderObj.name+"' >"
											+ orderObj.name
											+ "</td>"
											+ "<td>"
											+ '<a href="javascript:void(0)" onclick=editPack('
											+ orderObj.id + ')'
											+ '  ><i style="color: green;" class="fa fa-edit"></i></a>'+'</tr>'// + '&nbsp; | &nbsp;'+ deleterow +'</tr>';
											+ /*'<a style="color: red;" href="javascript:void(0)" onclick=deleteAcademicYear('
											+ orderObj.boardId + ')'
											+ '  ><i class="fa fa-trash-o"></i></a>' */+ '</td>';
										
											
									$(tblRow).appendTo("#basicExample");
								});
		}
		function editPack(id1) {
			var ids= id1;
			$("#cls-form").validate().resetForm();
			$("#id").val(serviceUnitArray[ids].id);
			var academicName = serviceUnitArray[ids].name;
			var academicNameArr = academicName.split('-');
			
			$('#startYear').datepicker();
			$('#startYear').datepicker("setDate",new Date(academicNameArr[0],0,1));

			/*$("#startYear").text(serviceUnitArray[0]);
			$("#endYear").val(serviceUnitArray[1]);*/
			$('#endYear').datepicker();
			$('#endYear').datepicker("setDate",new Date(academicNameArr[1],0,1));
			$("#submitId").val("Update");
			$("#headId").text("Edit Academic Year");
		}
		
		
		/*function deleteAcademicYear(id){
			var id = id;
			var count = 0;
			var checkstr =  confirm('Are you sure you want to delete this?');
			if(checkstr == true){
			  // do your code
			  
			  $.ajax({
						type : "POST",
						url : "deleteBoard.json",
						data : "id=" + id ,
						success : function(response) {
							displayTable(response);
							window.location.href='boardHome';
						},
						error : function(e) {
						}
					});
			
			$.ajax({
					type : "POST",
					url : "deleteClass.htm",
					data : "classId=" + classId ,
					dataType : "json",
					success : function(response) {
						alert(response);
						if (response != "") {
							displayTable(response);
						}
					
					},
					error : function(e) {
					}
				});
				
			}else{
			return false;
			}
		} */
		/*function deleteAcademicYear(id,status){
			var checkstr=null;
			if(status == 0){
				 checkstr = confirm('Are you sure you want to Deactivate?');
			}else{
				 checkstr = confirm('Are you sure you want to Activate?');
			}
			if(checkstr == true){
				var formData = new FormData();
			    formData.append('id', id);
			    formData.append('status', status);
			  
			  $.ajax({
						type : "POST",
						url : "deleteAcdemicYear.json",
						data : formData ,
						success : function(response) {
							var jsonobj = $.parseJSON(response);
							var alldata = jsonobj.allOrders1;
							displayTable(alldata);
							window.location.href='academicYearHome';
						},
						error : function(e) {
						}
					});
			
			}else{
			return false;
			}
		}*/
		