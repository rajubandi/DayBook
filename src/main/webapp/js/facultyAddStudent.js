$(function(){
	// to avoid multiple changes
	$('#busroute').prop("disabled", true);
	$('#buspesility').prop("disabled", true);
	
	$('#busRouteDiv').hide();
	$('#divBuspesility').hide();
	//
	$("#dob1").datepicker({
		changeDate : true,
		changeMonth : true,
		changeYear : true,
		yearRange: "-50:+0",
		showButtonPanel : false,
// 		minDate: '-50Y',
	    maxDate: '0', 
		dateFormat : 'dd-MM-yy'
	});
	
	$("#totalFee").val("");
	$("#discountFee1").val("");
	 $("#admissionFee").val("");
	   $("#tutionFee").val("");
	   $("#transportationFee").val("");
	   $("#hostelFee").val("");
	   $("#stationaryFee").val("");
	/*$('input[type=file]').change(function () 
	{
		var val = $(this).val().toLowerCase();
		var regex = new RegExp("(.*?)\.(png|jpg)$");
 		if(!(regex.test(val))) 
 		{
			$(this).val('');
			$('#blah').attr('src','upload/default.png');
			alert(Select .png or .jpg format only..!');
		} 
 	});*/

	/*$('#student-form').submit(function()
			 {
			    $("input[type='submit']", this)
			      .val("Please Wait...")
			      .attr('disabled', 'disabled');
			 
			    return true;
			  });*/

	
	jQuery.validator.addMethod('lettersonly', function(value, element) {
	    return this.optional(element) || /^[a-z. áãâäàéêëèíîïìóõôöòúûüùçñ]+$/i.test(value);
	}, "Please Enter Valid Name");

	   jQuery.validator.addMethod("mobileNO", function(phone_number, element) {
	   phone_number = phone_number.replace(/\s+/g, ""); 
	 return this.optional(element) || phone_number.length > 9 &&
	   phone_number.match(/^[7-9]\d+$/);
	}, "Invalid Mobile Number");


	    $("#student-form").validate({
	    errorElement: 'span',
	    errorClass: 'has-error',
		rules:
		{
		    name:{required:	true, lettersonly: true},
		    boardName:{required: true},
		    medium:{required: true},
		    className:{required: true},  
		    section:{required: true},
		    totalFee: {required: true, number: true},
		    discountFee1: {number: true},
		    acomitation:{required: true},
		    buspesility:{required: true},
//	 	    rollNum:{required: true},
		    admissionNum:{required: true},
		    fatherName:{required: true, lettersonly: true},
		    adharNumber:{required: true, number: true},
		    mobile:{required: true, number: true, mobileNO: true, minlength: 10, maxlength: 10},
		    altmobile:{number: true, mobileNO: true, minlength: 10, maxlength: 10},
		    email:{email: true},
		    gender:{required: true},
		    dob1:{required: true},
		    address:{required: true},
		    fee:{required: true},
		    previousInstitue:{lettersonly: true},
//		    fileImage:{extension: "png|jpg"},
		    email:{email: true},
		    admissionFee: {required: true, number: true},
		    tutionFee: {required: true, number: true},
		    transportationFee: {required: true, number: true},
		    hostelFee: {required: true, number: true},
		    stationaryFee: {required: true, number: true},
	/*	    bgroup:{required: true},
		    religion:{required: true},
		    caste:{required: true},
		    acomitation:{required: true},
		    buspesility:{required: true},
		    busroute:{required: true}, */
	    },
		messages:
		{
		    name:{required: 'Name'},
		    boardName:{required: 'Choose Board'},
		    medium:{required: 'Choose Medium'},
		    className:{required: 'Choose Class'},
		    section:{required: 'Choose Section'},
		    totalFee: {required: 'Choose Fees'},
		    acomitation:{required:  'Choose Accommodation'},
		    buspesility:{required:  'Choose Bus facility'},
		    discountFee1: {number: 'Discount Fee Amount (Eg: 1000,1500 etc.,)'},
//	 	    rollNum:{required: 'Please Enter Roll Number'},
		    admissionNum:{required: 'Admission Number'},
		    fatherName:{required: 'Father Name'},
		    adharNumber:{required: 'Adhar Name'},
		    gender:{required: 'Choose Gender'},
		    dob1:{required: 'Date Of Birth'},
		    mobile:{required: 'Mobile Number', number: '10 digit mobile number'},
		    address:{required: 'Address'},
		    fee:{required: 'Fee Amount'},
		    altmobile:{number: 'only numbers'},
		    email:{email: 'Valid Email'},
		    previousInstitue:{lettersonly: 'Previous Institute Name'},
		    admissionFee: {required: 'Admission Fee', number: 'Numeric Characters'},
			tutionFee: {required: 'Tuition Fee', number: 'Numeric Characters'},
			transportationFee: {required: 'Transportation Fee', number: 'Numeric Characters'},
			hostelFee: {required: 'Hostel Fee', number: 'Numeric Characters'},
			stationaryFee: {required: 'Stationary Fee', number: 'Numeric Characters'},
//		    fileImage:{extension: 'Please Choose Only .png or .jpg'},
	/* 		bgroup:{required: 'Please Enter Blood Group'},
		    religion:{required: ' Choose Religion'},
		    caste:{required: 'Please Choose Caste'},
		    acomitation:{required: 'Please Choose Accomodation'},
		    buspesility:{required: 'Please Choose Bus Facility'},  
		    busroute:{required: 'Please Enter Bus route'}, */        
	    },
	    errorPlacement: function(error, element){
	      if(element.attr("name") == "gender")
	        error.insertAfter(".gender_error").css("color", "red");
	      else if(element.attr("name") == "accomodation")
	        error.insertAfter(".accomodation_error").css("color", "red"); 
	      else if(element.attr("name") == "dob1")
	        error.insertAfter(".dob1_error").css("color","red");   
	      else if(element.attr("name") == "busroute")
	        error.insertAfter(".busroute_error").css("color","red");
	      else if(element.attr("name") == "busfacility")
	        error.insertAfter(".busfacility_error").css("color","red"); 
	      else if(element.attr("name") == "fileImaged")
	        error.insertAfter(".fileImaged_error").css("color","red");          
	       else if(element.attr("name") == "fileImage")
	        error.insertAfter(".fileImage-error").css("color","red");  
	    
	      else
	        error.insertAfter(element);
	      }
    	
	});
	    
	    $('#submitId').click(function(){
	    	var admissionFee = $('#admissionFee').val();
	    	var tutionFee   = $('#tutionFee').val();
	    	var transportationFee = $('#transportationFee').val();
	    	var hostelFee = $('#hostelFee').val();
	    	var stationaryFee = $('#stationaryFee').val();
	    		
	    	if(admissionFee1 < admissionFee){
	    		alert("Maximum AdmissionFee is : "+admissionFee1);
		     return false;
		     }else if(tutionFee1 < tutionFee){
		    	 alert("Maximum TutionFee is : "+tutionFee1);
			     return false;
		     }else if(transportationFee1 < transportationFee){
		    	 alert("Maximum TransportationFee is : "+transportationFee1);
			     return false;
		     }else if(hostelFee1 < hostelFee){
		    	 alert("Maximum HostelFee is : "+hostelFee1);
			     return false;
		     }else if(stationaryFee1 < stationaryFee){
		    	 alert("Maximum StationaryFee is : "+stationaryFee1);
			     return false;
		     }else {
		    	 return true;
		     }
	    	
	    });
	  

	$('#cancel').click(function () {
	   	$('#fileImage').val("");      //image will be cleared if selected
	   	$('#blah').attr("src","upload/default.png");
	  	$("#student-form").validate().resetForm();
	    $("#student-form").removeClass("has-error");
	    $("#id").val(0);
	    $('#name').val("");
	    $('#boardName').val("");
	    $('#medium').val("");
	    $('#className').val("");
	    $('#section').val("");
	    $('#dob1').val("");
	    $('#rollNum').val("");
	    $('#admissionNum').val("");
	    $('#fatherName').val("");
	    $('#mobile').val("");
	    $('#altmobile').val("");
	    $('#email').val("");
	    $('#blodgroup').val("");
	    $('#gender').val("");
	    $('#religion').val("");
	    $('#address').val("");
	    $('#previousInstitue').val("");
	    $('#caste').val("");
	    $('#acomitation').val("");
	    $('#buspesility').val("");
	    $('#busroute').val("");
	    $("#totalFee").val("");
		$("#discountFee1").val("");
		$("#admissionFee").val('');
		$("#tutionFee").val('');
		$("#transportationFee").val('');
		$("#hostelFee").val('');
		$("#stationaryFee").val('');
	    $("#student-form").addClass('form-horizontal');
	    $("#submitId").val("Register");
	    $("#headId").text("Add Student");
	    
	});
	
	
	//$('#hostleDiv').hide();
	//$('#hostelFee').prop("disabled",false);
			 $('#acomitation').on('change', function() {
				 
					/* if( $('#acomitation').val() == "Hostel" && $('#acomitation').val() == ""){
							
							$('#buspesility').val('No');
							$('#buspesility').attr("readonly", true);
							$('#divBuspesility').hide();
							
							$('#transportationFee').prop("disabled", true);
							$('#busroute').prop("disabled", true);
							
							$('#transportationDiv').hide();
							$('#busRouteDiv').hide();
						}else if( ){
								}*/
					// if($('#buspesility').val() !== "" && $(this).val() !== ""){
						 if($(this).val() !== "" && $(this).val() != "Hostel"  ){//accomitation= day-scholor
						 

								//if ($(this).val() !== "Hostel" && $('#buspesility').val() !== "Yes") {
									
									
									$('#buspesility').val('');
									$('#buspesility').attr("readonly", false);
									$('#buspesility').prop("disabled", false);
									$('#divBuspesility').show();
						
									var fee = totalFee - $('#hostelFee').val() ;
						
									$('#totalFee').val(fee);
						
									$('#hostelFee').prop("disabled", true);
									$('#hostleDiv').hide();
									
									$('#transportationFee').prop("disabled", false);
									$('#busroute').prop("disabled", false);
									
									$('#transportationDiv').show();
									$('#busRouteDiv').show();
									
									
								} else if($(this).val() != "" ) {//accomitation= Hostel
					
										$('#buspesility').val('');
										$('#busroute').val('');
										$('#buspesility').attr("readonly", true);
										$('#divBuspesility').show();
										
										//if( $('#buspesility').val() !== "Yes"){
											
										//if( $('#buspesility').val() !== "Yes"){
										var removetransport= $('#totalFee').val();
											//var fee = removetransport  - $('#transportationFee').val() 
											var fee = parseInt($('#admissionFee').val())
													+ parseInt($('#tutionFee').val())
													+ parseInt($('#hostelFee').val()) 
													+ parseInt($('#stationaryFee').val());
											$('#totalFee').val(fee);
											
											$('#transportationFee').val('');
											$('#transportationFee').prop("disabled", true);
											//$('#busroute').prop("disabled", true);
											
											$('#transportationDiv').hide();
											//$('#busRouteDiv').hide();
											
											$('#hostelFee').prop("disabled", false);
											$('#hostleDiv').show();
											
										//}else{
											
											/*if($(this).val() !== "Hostel"){
												
												
												var fee = totalFee - $('#hostelFee').val();
							
												$('#totalFee').val(fee);
							
												$('#hostelFee').prop("disabled", true);
												$('#hostleDiv').hide();
												
												$('#transportationFee').prop("disabled", false);
												$('#busroute').prop("disabled", false);
												
												$('#transportationDiv').show();
												$('#busRouteDiv').show();
												
											}*//*else{
										
												$('#buspesility').val("No");
										var fee =  totalFee - $('#transportationFee').val(); ;
							
										$('#totalFee').val(fee);
							
							
										$('#hostelFee').prop("disabled", false);
										$('#hostleDiv').show();
										
										$('#transportationFee').prop("disabled", true);
										$('#busroute').prop("disabled", true);
										
										$('#transportationDiv').hide();
										$('#busRouteDiv').hide();
											}*/
										//}
										
													
								}else{//accomitation= nothing
									$('#transportationFee').prop("disabled", false);
									$('#transportationFee').val();
									$('#transportationDiv').show();
									
								}
						 		/*}else{
						 		// to avoid multiple changes
						 			$('#busroute').prop("disabled", true);
						 			$('#buspesility').prop("disabled", true);
						 			
						 			$('#busRouteDiv').hide();
						 			$('#divBuspesility').hide();
						 			//
						 			
						 		} *//*if ($(this).val() !== "" && $(this).val() !== "Hostel" ){
						 

							//$('#buspesility').val('No');
							$('#buspesility').attr("readonly", false);
							$('#buspesility').prop("disabled", false);
							$('#divBuspesility').show();
							 
							 
							 var fee = totalFee - $('#hostelFee').val();

								$('#totalFee').val(fee);

								$('#hostelFee').prop("disabled", true);
								$('#hostleDiv').hide();
								
								$('#transportationFee').prop("disabled", false);
								$('#busroute').prop("disabled", false);
								
								$('#transportationDiv').show();
								$('#busRouteDiv').show();
							 
						 }else{
							 
							 
							 var fee =  totalFee -  $('#transportationFee').val(); ;

								$('#totalFee').val(fee);
								
								//$('#busroute').prop("disabled", true);
								$('#buspesility').prop("disabled", true);
								

								$('#hostelFee').prop("disabled", false);
								$('#hostleDiv').show();
								
								//$('#buspesility').val('No');
								$('#buspesility').attr("readonly", true);
								$('#divBuspesility').hide();
								
								$('#transportationFee').prop("disabled", true);
								$('#busroute').prop("disabled", true);
								
								$('#transportationDiv').hide();
								$('#busRouteDiv').hide();
							 
							 
						 }*/
						
				// alert("You have Selected :: "+$(this).val());
			});

	    
		 $('#buspesility').on('change', function() {
			 	console.log( parseInt(totalFee));
			 	
				if ($(this).val() !== "Yes" && $('#acomitation').val() !== "" && $(this).val() != "") {
					//Bus=NO
					console.log($('#acomitation').val())	;				
					
						
						if($('#acomitation').val() !== "Hostel" ){
							//Bus=No && acomitation = Day-Scholor
							//var fee =  parseInt(totalFee) - $('#transportationFee').val() -  $('#hostelFee').val();
							var fee =  parseInt($('#totalFee').val()) - $('#transportationFee').val() ;
							$('#totalFee').val(fee);
							
							$('#transportationFee').prop("disabled", true);
							$('#busroute').prop("disabled", true);
							
							$('#transportationDiv').hide();
							$('#busRouteDiv').hide();
							
						}else{
							//Bus=No && acomitation = Hostel
							
						var fee = totalFee - $('#transportationFee').val();

						$('#totalFee').val(fee);
							
						$('#transportationFee').prop("disabled", true);
						$('#busroute').prop("disabled", true);
						
						$('#transportationDiv').hide();
						$('#busRouteDiv').hide();
						}
						
						
					}else{//Bus=YES 
						/*
							if($(this).val() !== "Yes"){
								
								var fee = totalFee - $('#transportationFee').val();

								$('#totalFee').val(fee);
									
								$('#transportationFee').prop("disabled", true);
								$('#busroute').prop("disabled", true);
								
								$('#transportationDiv').hide();
								$('#busRouteDiv').hide();
								
							}else*/ if($('#acomitation').val() !== "Hostel" && $('#acomitation').val() !== ""){//Bus=YES && acomitation = Day-Scholor
						
						$('#transportationFee').prop("disabled", false);
						$('#transportationDiv').show();
						$('#busroute').prop("disabled", false);
						$('#busRouteDiv').show();
						var fee = totalFee - $('#hostelFee').val();

						$('#totalFee').val(fee);
						$('#hostelFee').prop("disabled", true);
						$('#hostleDiv').hide();
						
						
					}else{//Bus=Yes && acomitation = Hostel...	/* */
						
						/*$('#transportationFee').prop("disabled", false);
						$('#transportationDiv').show();
						
						
						
						$('#busroute').prop("disabled", false);
						$('#busRouteDiv').show();
					
					var fee = totalFee ;

					$('#totalFee').val(fee);*/

					/*$('#hostelFee').prop("disabled", false);
					$('#hostleDiv').hide();
					$('#transportationDiv').show();
					$('#busRouteDiv').show();

					var fee = totalfee;

					$('#totalFee').val(fee);*/
					}
				}
				// alert("You have Selected :: "+$(this).val());
			});		


});
	 	function displayTable(listOrders) {
			if (listOrders != null) {
				$("#basicExample tr td").remove();
				$("#basicExample td").remove();
				serviceUnitArray = {};
				$.each(listOrders,function(i, orderObj) {
									if(orderObj.imagePath == null){
										orderObj.imagePath="img/default.png"
									}
//	 								contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
									serviceUnitArray[orderObj.studentId] = orderObj;
									var id = '"' + orderObj.studentId + '"';
									var sno = i+1;
									var tblRow = "<tr  role='row' class='odd'>" 
											+ "<td'><a id='"
											+ orderObj.studentId
											+ orderObj.studentId
											+ ")' style='font-color:red'>"
											+ "' href='javascript:forOrderDetails("
											+ orderObj.studentId
											+ "</a></td>"
											+ "<td title='"+ sno +"'>"
											+ sno
											+ "</td>"
//	 										+"<td><input class='checkall' type='checkbox' name='checkboxName' id='"+orderObj.studentId+"' value='"+orderObj.studentId+"'/></td>"
											+ "<td title='"+orderObj.studentName+"'>"
											+ orderObj.studentName
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.fatherName+"' >"
											+ orderObj.fatherName
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mobile+"' >"
											+ orderObj.mobile
											+ "</td>"
											
											+ "<td class='hidden-sm hidden-xs'><img style='width: 25px;height: 25px;' src='"+baseUrl2+"/"+orderObj.imagePath+"'/>"
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.admissionNum+"'>"
											+ orderObj.admissionNum
											+ "</td>"
											/*+ "<td class='hidden-sm hidden-xs' title='"+orderObj.boardName+"' >"
											+ orderObj.boardName
											+ "</td>"*/
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.className+"' >"
											+ orderObj.className
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mediumName+"'>"
											+ orderObj.mediumName
											+ "</td>"
											
											+ "<td>"
//	 										+ '<a onclick=getApplicant('
//	 										+ orderObj.studentId + ')'
//	 										+ '  ><i style="color: blue;" class="fa fa-file-text"></i></a>' + '&nbsp; | &nbsp;'
											+ '<a href="javascript:void(0)" onclick=editPack('
											+ orderObj.studentId + ')'
											+ '  ><i style="color: green;" class="fa fa-edit"></i></a>' + '&nbsp; | &nbsp;'
											+ '<a style="color: red;" href="javascript:void(0)" onclick=deleteStudent('
											+ orderObj.studentId + ')'
											+ '  ><i class="fa fa-trash-o"></i></a>' + '</td>'
											+ '</tr>';
									$(tblRow).appendTo("#basicExample");
									
									//$("#imageId1").attr('src', "@Url.Content("~/Content/images/ajax_activity.gif)")
								});
			} else {
				//alert('no data to display..');
			}
		}  
	 	function editPack(id) {
			var transactionId = serviceUnitArray[id].studentId;
			$("#student-form").validate().resetForm();
			$("#id").val(serviceUnitArray[id].studentId);
			$('#name').val(serviceUnitArray[id].studentName);
			$('#gender').val(serviceUnitArray[id].gender);
			$('#gender').trigger("chosen:updated");
			$('#boardName').val(serviceUnitArray[id].boardId);
			$('#boardName').trigger("chosen:updated");
			classNameFilter();
			$('#className').val(serviceUnitArray[id].classId);
			$('#className').trigger("chosen:updated");
			sectionFilter();
			$('#section').val(serviceUnitArray[id].sectionId);
			$('#section').trigger("chosen:updated");
			mediumFilter();
			$('#medium').val(serviceUnitArray[id].mediumId);
			$('#medium').trigger("chosen:updated");
			$("#acomitation").val(serviceUnitArray[id].acomitation);
			$("#acomitation").trigger("change");
			$('#address').val(serviceUnitArray[id].address);
			$('#admissionNum').val(serviceUnitArray[id].admissionNum);
			$('#medium').trigger("chosen:updated");
			$('#alternativeMobile').val(serviceUnitArray[id].alternativeMobile);
			$('#blodgroup').val(serviceUnitArray[id].blodgroup);
			$('#blodgroup').trigger("chosen:updated");
			$('#buspesility').val(serviceUnitArray[id].buspesility);
			$('#buspesility').trigger("change");
			$('#busroute').val(serviceUnitArray[id].busroute);
			$('#caste').val(serviceUnitArray[id].caste);
			$('#caste').trigger("chosen:updated");
			$('#email').val(serviceUnitArray[id].email);
			$('#fatherName').val(serviceUnitArray[id].fatherName);
			$('#fatherOccupation').val(serviceUnitArray[id].fatherOccupation);
			$('#motherName').val(serviceUnitArray[id].motherName);
			$('#motherOccupation').val(serviceUnitArray[id].motherOccupation);
			$('#adharNumber').val(serviceUnitArray[id].adharNumber);
			$('#fee').val(serviceUnitArray[id].fee);
			
			
			$('#dob1').val(serviceUnitArray[id].dob);
			$('#admissionDate').val(serviceUnitArray[id].admissionDate);
			
			$('#previousInstitue').val(serviceUnitArray[id].previousInstitue);
			$('#religion').val(serviceUnitArray[id].religion);
			$('#religion').trigger("chosen:updated");
			$('#rollNum').val(serviceUnitArray[id].rollNum);
			
			
			$("#mobile").val(serviceUnitArray[id].mobile);
			totalFee = serviceUnitArray[id].totalFee;
			$("#totalFee").val(serviceUnitArray[id].totalFee);
			$("#discountFee1").val(serviceUnitArray[id].discountFee);
			$('#blah').attr('src',''+serviceUnitArray[id].imagePath+'');
			$('#admissionFee').val(serviceUnitArray[id].admissionFee);
			$('#admissionFee').trigger("chosen:updated");
			$('#tutionFee').val(serviceUnitArray[id].tutionFee);
			$('#tutionFee').trigger("chosen:updated");
			$('#transportationFee').val(serviceUnitArray[id].transportationFee);
			$('#transportationFee').trigger("chosen:updated");
			$('#hostelFee').val(serviceUnitArray[id].hostelFee);
			$('#hostelFee').trigger("chosen:updated");
			$('#stationaryFee').val(serviceUnitArray[id].stationaryFee);
			$('#stationaryFee').trigger("chosen:updated");
			getFee1();
			
			$("#submitId").val("Update");
			$("#headId").text("Edit Student");
			$(window).scrollTop($('#name').offset().top);
		} 
	 	
	 	function getBusFee(){
	 		var boardId = $('#boardName').val();
			var classId = $('#className').val();
			var sectionId = $('#section').val();
			var mediumId = $('#medium').val();
			var routeId = $('#busroute').val();
			
	 		if($('#acomitation').val() != "Hostel" ){
				var busroute = $('#busroute').val();
				//$('#loadAjax').show();
				 $("#transportationFee").val('');
						if(busroute != "" && boardId != ""  && classId != "" && sectionId != "" && mediumId != "" && routeId != ""){
							 $.ajax({
									type : "POST",
									url : "getBusFee.json",
									data :  "boardId="+boardId+"&classId="+classId+"&sectionId="+sectionId+"&mediumId="+mediumId+"&routeId="+routeId,
									success : function(response) {
										/* alert(response); */
										if(response!=null){
											 $("#transportationFee").val(response);
											 var fee42 = parseInt($('#admissionFee').val())
												+ parseInt($('#tutionFee').val())
												+ parseInt($('#stationaryFee').val());
											//var total34 =parseInt($("#totalFee").val());
											 fee42 +=parseInt(response);
											$("#totalFee").val(fee42);
											
										}
									}
							 });
						}else{
							
							$("#submitId").click();
						}
				}else{
					
					
					
				}
	 	}
			
		function serviceFilter(id){
			var borderId = $("#boardName").val();
			$('#loadAjax').show();
			$.ajax({
				type : "POST",
				url : "getBordName.json",
				data : "borderId=" + borderId,
				dataType : "json",
				success : function(response) {
					/* alert(response); */ 
					var optionsForClass = "";
					optionsForClass = $("#medium").empty();
					optionsForClass.append(new Option("--Select--", ""));
					$.each(response, function(i, tests) {
						var id=tests.id;
						var name=tests.name;
						optionsForClass.append(new Option(name, id));
					});
					$('#loadAjax').hide();
					$('#medium').trigger("chosen:updated");
				},
				error : function(e) {
					$('#loadAjax').hide();
				},
				statusCode : {
					406 : function() {
						$('#loadAjax').hide();
				
					}
				}
			});
			$('#loadAjax').hide();
		}

		function deleteStudent(id){
			
			var studentId = id;
			/* $('input[name=checkboxName]:checked').map(function() {
				studentId.push($(this).val());
			}); */
			var count = 0;
			var checkstr =  confirm('are you sure you want to delete this?');
			if(checkstr == true){
			  // do your code
				$('#loadAjax').show();
			  
			  $.ajax({
						type : "POST",
						url : "deleteStudent.json",
						data : "studentId=" + studentId ,
						success : function(response) {
							displayTable(response);
							$('#loadAjax').hide();
							window.location.href='studentHome';
						},
						error : function(e) {
							$('#loadAjax').hide();
						},
						statusCode : {
							406 : function() {
								$('#loadAjax').hide();
						
							}
						}
					});
			  $('#loadAjax').hide();
				
			}else{
			return false;
			}
		}
	function multipledeleteStudent(){
			
			var studentId = [];
			$('input[name=checkboxName]:checked').map(function() {
				studentId.push($(this).val());
			});
			var count = 0;
			var checkstr =  confirm('are you sure you want to delete this?');
			if(checkstr == true){
			  // do your code
				$('#loadAjax').show();
			  
			  $.ajax({
						type : "POST",
						url : "deleteStudent.json",
						data : "studentId=" + studentId ,
						success : function(response) {
							displayTable(response);
							$('#loadAjax').hide();
						},
						error : function(e) {
							$('#loadAjax').hide();
						},
						statusCode : {
							406 : function() {
								$('#loadAjax').hide();
						
							}
						}
					});
			  $('#loadAjax').hide();
				
			}else{
			return false;
			}
		}
	$("#checkAll").change(function () {
		$("input:checkbox").prop('checked', $(this).prop("checked"));
		var len=$("[name='checkboxName']:checked").length;
		if(len!=0)
		{
			$('#delbtn').show();
		}
		else
		{
			$('#delbtn').hide();
		}
	});
	$(".checkall").change(function () {
		var len=$("[name='checkboxName']:checked").length;
		if(len!=0)
		{
			$('#delbtn').show();
		}
		else
		{
			$('#delbtn').hide();
		}
	});
var admissionFee1 =0.00;
var tutionFee1 = 0.00;
var transportationFee1 = 0.00;
var hostelFee1 = 0.00;
var stationaryFee1 = 0.00;
var totalFee = 0.00 ;
console.log(totalFee);
	function getFee(){
		var boardId = $('#boardName').val();
		var className = $('#className').val();
		var mediumId = $('#medium').val();
		var section = $('#section').val();
		$('#loadAjax').show();
		if(boardId  != "" && className != "" && mediumId!= "" && section != ""){
		 $.ajax({
				type : "POST",
				url : "getClassFee.json",
				data : "boardId=" + boardId+"&className="+className+"&section="+section+"&mediumId="+mediumId,
				success : function(response) {
					/* alert(response); */
					if(response!=""){
						totalFee = response.fee;
					$("#totalFee").val(response.fee);
					$("#admissionFee").val(response.admissionFee);  
					$("#tutionFee").val(response.tutionFee);
					$("#transportationFee").val(response.transportationFee);
					$("#hostelFee").val(response.hostelFee);
					$("#stationaryFee").val(response.stationaryFee);
					
					admissionFee1 = response.admissionFee;
					tutionFee1 = response.tutionFee;
					transportationFee1 = response.transportationFee;
					hostelFee1 = response.hostelFee;
					stationaryFee1 = response.stationaryFee;
					}
				},
				error : function(e) {
					$('#loadAjax').hide();
				},
				statusCode : {
					406 : function() {
						$('#loadAjax').hide();
				
					}
				}
			});
		 $('#loadAjax').hide();
		}else{
			 $('#loadAjax').hide();
			$("#totalFee").val('');
		}
	}

	function getFee1(){
		var boardId = $('#boardName').val();
		var className = $('#className').val();
		var mediumId = $('#medium').val();
		var section = $('#section').val();
		$('#loadAjax').show();
		 $.ajax({
				type : "POST",
				url : "getClassFee.json",
				data : "boardId=" + boardId+"&className="+className+"&section="+section+"&mediumId="+mediumId,
				success : function(response) {
					/* alert(response); */
					if(response!=""){
					admissionFee1 = response.admissionFee;
					tutionFee1 = response.tutionFee;
					transportationFee1 = response.transportationFee;
					hostelFee1 = response.hostelFee;
					stationaryFee1 = response.stationaryFee;
					}
				},
				error : function(e) {
					$('#loadAjax').hide();
				},
				statusCode : {
					406 : function() {
						$('#loadAjax').hide();
				
					}
				}
			});
		 $('#loadAjax').hide();
	}
//		var admissionFee=$('#admissionFee').val(response.admissionFee);
//		var actuvalAdmissionFee=$('#actuvalAdmissionFee').val(response.admissionFee);
//	
//	function admissionFee1(){
//		
//		 if(admissionFee <= actuvalAdmissionFee){
//		        alert("The paragraph was clicked.");
//	     return false;   
//		 }
//		
//	}	
		
//		 $("#admFee").on('change',function(){
//			 if(admissionFee <= actuvalAdmissionFee){
//		        alert("The paragraph was clicked.");
//		     return false;   
//			 }
//		    });
		
	
	function getApplicant(id)
	{
		var image = null; image = serviceUnitArray[id].imagePath;
		if(image == null || image == ""){image= 'upload/default.png';}
		
		var name = null; name = serviceUnitArray[id].studentName;
		if(name == null || name == ""){name = "---";}
//	 	alert(serviceUnitArray[id].studentName);
		
		var board = null; board = serviceUnitArray[id].boardName;
		if(board == null || board == ""){board = "---";}
		
		var medium = null; medium = serviceUnitArray[id].mediumName;
		if(medium == null || medium == ""){medium = "---";}
		
		var clas = null; clas = serviceUnitArray[id].className;
		if(clas == null || clas == ""){clas = "---";}
		
		var section = null; section = serviceUnitArray[id].sectionName;
		if(section == null || section == ""){section = "---";}
		
		var rno = null; rno = serviceUnitArray[id].rollNum;
		if(rno == null || rno == ""){rno = "---";}
		
		var adno = null; adno = serviceUnitArray[id].admissionNum;
		if(adno == null || adno == ""){adno = "---";}
		
		var fname = null; fname = serviceUnitArray[id].fatherName;
		if(fname == null || fname == ""){fname = "---";}
		
		var mob = null; mob = serviceUnitArray[id].mobile;
		if(mob == null || mob == ""){mob = "---";}
		
		var alt = null; alt = serviceUnitArray[id].alternativeMobile;
		if(alt == null || alt == ""){alt = "---";}
		
		var email = null; email = serviceUnitArray[id].email;
		if(email == null || email == ""){email = "---";}
		
		var bg = null; bg = serviceUnitArray[id].blodgroup;
		if(bg == null || bg == ""){bg = "---";}
		
		var gender = null; gender = serviceUnitArray[id].gender;
		if(gender == null || gender == ""){gender = "---";}
		
//	 	var dob = null; dob = rs.getvar(15);
//	 	if(dob == null || dob == ""){dob = "---";}
		
		var rel = null; rel = serviceUnitArray[id].religion;
		if(rel == null || rel == ""){rel = "---";}
		
		var add = null; add = serviceUnitArray[id].address;
		if(add == null || add == ""){add = "---";}
		
		var pre = null; pre = serviceUnitArray[id].previousInstitue;
		if(pre == null || pre == ""){pre = "---";}
		
		var caste = null; caste = serviceUnitArray[id].caste;
		if(caste == null || caste == ""){caste = "---";}
		
		var acc = null; acc = serviceUnitArray[id].acomitation;
		if(acc == null || acc == ""){acc = "---";}
		
		var bus = null; bus = serviceUnitArray[id].buspesility;
		if(bus == null || bus == ""){bus = "---";}
		
		var busrt = null; busrt = serviceUnitArray[id].busroute;
		if(busrt == null || busrt == ""){busrt = "---";}
		
		var tblRow = "<table class='table no-margin' style='width: 50%;'>"
				+"<tr><td style='border: none;'><a style='cursor: pointer;' onclick='getBack()'><i class='fa fa-2x fa-reorder'></i></a></td><td style='border: none;'></td><td style='border: none;'><img style='width: 65px;height: 65px;' src='"+image+"'/></td></tr>"
				
				+"<tr><th>Name</th><td>:</td><td>"+name+"</td></tr>"
				
				+ "<tr><th>Type of Board</th><td>:</td><td>"+board+"</td></tr>"
				
				+ "<tr><th>Medium</th><td>:</td><td>"+medium+"</td></tr>"
				
				+ "<tr><th>Class</th><td>:</td><td>"+clas+"</td></tr>"
				
				+ "<tr><th>Section</th><td>:</td><td>"+section+"</td></tr>"
				
				+ "<tr><th>Roll No</th><td>:</td><td>"+rno+"</td></tr>"
				
				+ "<tr><th>Admission No</th><td>:</td><td>"+adno+"</td></tr>"
				
				+ "<tr><th>Father Name</th><td>:</td><td>"+fname+"</td></tr>"
				
				+ "<tr><th>Mobile No</th><td>:</td><td>"+mob+"</td></tr>"
				
				+ "<tr><th>Alternative No</th><td>:</td><td>"+alt+"</td></tr>"
				
				+ "<tr><th>Email</th><td>:</td><td>"+email+"</td></tr>"
				
				+ "<tr><th>Blood Group</th><td>:</td><td>"+bg+"</td></tr>"
				
				+ "<tr><th>Gender</th><td>:</td><td>"+gender+"</td></tr>"
				
//	 			+ "<tr><th>Date Of Birth</th><td>:</td><td>"+dob+"</td></tr>"
				
				+ "<tr><th>Religion</th><td>:</td><td>"+rel+"</td></tr>"
				
				+ "<tr><th>Address</th><td>:</td><td>"+add+"</td></tr>"
				
				+ "<tr><th>Previous Institute</th><td>:</td><td>"+pre+"</td></tr>"
				
				+ "<tr><th>Caste</th><td>:</td><td>"+caste+"</td></tr>"
				
				+ "<tr><th>Accommodation</th><td>:</td><td>"+acc+"</td></tr>"
				
				+ "<tr><th>Bus facility</th><td>:</td><td>"+bus+"</td></tr>"
				
				+ "<tr><th>Bus Route</th><td>:</td><td>"+busrt+"</td></tr>"
				
				+"</table>";
		$(tblRow).appendTo("#showData");
		$("#view_list").hide();
		$('#view_list1').hide();
	}

	function getBack()
	{
		$('#showData').html('');
		$('#view_list').show();
		$('#view_list1').show();
	}

	function classNameFilter(id){
		var boardId = $("#boardName").val();
		if(boardId.length !=0){
			$('#loadAjax').show();
		$.ajax({
			type : "POST",
			url : "getClassNameFilter.json",
			data : "boardId=" + boardId,
			dataType : "json",
			async:false,
			success : function(response) {
				 /* alert(response); */  
				var optionsForClass = "";
				optionsForClass = $("#className").empty();
				optionsForClass.append(new Option("-- Choose Class --", ""));
				$.each(response, function(i, tests) {
					var id=tests.id;
					var className=tests.className;
					optionsForClass.append(new Option(className, id));
				});
				$('#loadAjax').hide();
				$('#className').trigger("chosen:updated");
			},
			error : function(e) {
				$('#loadAjax').hide();
			},
			statusCode : {
				406 : function() {
					$('#loadAjax').hide();
			
				}
			}
		});
		$('#loadAjax').hide();

		}
	} 
		function sectionFilter(){
		var boardId = $("#boardName").val();
		var classId = $("#className").val();
		if(boardId.length !=0 && classId.length != 0){
			$('#loadAjax').show();
		$.ajax({
			type : "POST",
			url : "getSectionFilter.json",
			data : "boardId=" + boardId+"&classId="+classId,
			dataType : "json",
			async:false,
			success : function(response) {
				 /* alert(response); */  
				var optionsForClass = "";
				optionsForClass = $("#section").empty();
				optionsForClass.append(new Option("-- Choose Section --", ""));
				$.each(response, function(i, tests) {
					var id=tests.id;
					var sectionName=tests.sectionName;
					optionsForClass.append(new Option(sectionName, id));
				});
				$('#loadAjax').hide();
				$('#section').trigger("chosen:updated");
			},
			error : function(e) {
				$('#loadAjax').hide();
			},
			statusCode : {
				406 : function() {
					$('#loadAjax').hide();
			
				}
			}
		});
		$('#loadAjax').hide();
		}
	} 
		function mediumFilter(){
		var boardId = $("#boardName").val();
		var classId = $("#className").val();
		var sectionId = $("#section").val();
		if(boardId.length !=0 && classId.length != 0 &&  sectionId.length != 0){
			$('#loadAjax').show();
		$.ajax({
			type : "POST",
			url : "getMediumFilter.json",
			data : "boardId=" + boardId+"&classId="+classId+"&sectionId="+sectionId,
			dataType : "json",
			async:false,
			success : function(response) {
				 /* alert(response); */  
				var optionsForClass = "";
				optionsForClass = $("#medium").empty();
				optionsForClass.append(new Option("-- Choose Medium --", ""));
				$.each(response, function(i, tests) {
					var id=tests.id;
					var mediumName=tests.mediumName;
					optionsForClass.append(new Option(mediumName, id));
				});
				$('#loadAjax').hide();
				$('#section').trigger("chosen:updated");
			},
			error : function(e) {
				$('#loadAjax').hide();
			},
			statusCode : {
				406 : function() {
					$('#loadAjax').hide();
			
				}
			}
		});
		$('#loadAjax').hide();
		}
	} 
		
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
		 /* $(document).ready(function(){
		 		$("select").chosen({allow_single_deselect:true});
		 }); */

		
		
		
		
		
		