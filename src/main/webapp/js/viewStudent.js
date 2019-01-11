var searchbtn='';
$(function(){
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
			    name:{lettersonly: true},
			    mobile:{number: true, mobileNO: true, minlength: 10, maxlength: 10},
			    email:{email: true},
			},
		    messages:
			{
			    name:{lettersonly: 'Valid Name'},
			    mobile:{number: '10 digit mobile number'},
			    email:{email: 'Valid Email'},
			},
			errorPlacement: function(error, element){
				if(element.attr("name") == "name")
			        error.insertAfter(".name_error").css("color", "red");
				else if(element.attr("name") == "mobile")
			        error.insertAfter(".mobile_error").css("color", "red");
				else if(element.attr("name") == "email")
			        error.insertAfter(".email_error").css("color", "red");
				else
			    	error.insertAfter(element);
			}
	   });   
	   
	$('#cancel').click(function () {
	  	$("#student-form").validate().resetForm();
	    $("#student-form").removeClass("has-error");
	    $('#name').val("");
	    $('#mobile').val("");
	    $('#email').val("");
	    $("#student-form").addClass('form-horizontal');
	});
	
$("#passOutStudentsCheckBoxs").change(function() {
		
	    if(this.checked) {
	    	$.ajax({
				type : "POST",
				url : "passOutStudents.json",
				//data : ,
				success : function(response) {
					displayTable(response);
					
				}
				
			});
	    	
	    	
	    }else{
	    	window.location.href='viewStudent';
	    }
	});
	
});
	    
	
	 	function displayTable(listOrders) {
	 		$('#basicTable').html('');
				serviceUnitArray = {};
				var tableHead = '<table id="basicExample" class="table table-striped table-condensed table-bordered no-margin dataTable" role="grid" aria-describedby="basicExample_info">'
								+ '<thead>'
								+'<tr role="row">'
								+'<th class="sorting noExport" style="width: 10px;" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">S.No</th>'
								+'<th class="sorting" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">Student Name</th>'
								+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Father Name</th>'
								+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending">Mobile Number</th>'
								+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Image</th>'
								+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Admission No.</th>'
//								+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Board</th>'
								+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Class</th>'
								+'<th class="sorting hidden-sm hidden-xs" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending">Medium</th>'
								+'<th class="sorting noExport" tabindex="0" aria-controls="basicExample" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending">Action</th>'
							+'</tr>'
						+'</thead>'
						+'<tbody></tbody></table>';
				$('#basicTable').html(tableHead);
				$.each(listOrders,function(i, orderObj) {
									
									if(orderObj.imagePath == null){
										orderObj.imagePath="img/default.png"
									}
//	 								contactNumber":"wertewrt","mediumId":"16","subjectId":"","name":"0","boardid":"1","gender":null,"className":"","qualifaction":"ewrt","section":""
									serviceUnitArray[orderObj.studentId] = orderObj;
									var id = '"' + orderObj.studentId + '"';
									var sno = i+1;
									var tblRow = "<tr  role='row' class='odd'>" + "<td'><a id='"
											+ orderObj.studentId
											+ "' href='javascript:forOrderDetails("
											+ orderObj.studentId
											+ ")' style='font-color:red'>"
											+ orderObj.studentId
											+ "</a></td>"
											+ "<td title='"+ sno +"'>"
											+ sno
											+ "</td>"
											+ "<td title='"+orderObj.studentName+"'>"
											+ orderObj.studentName
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.fatherName+"' >"
											+ orderObj.fatherName
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mobile+"' >"
											+ orderObj.mobile
											+ "</td>"
											+ "<td  class='hidden-sm hidden-xs'><img style='width: 25px;height: 25px;' src='"+baseUrl2+"/"+orderObj.imagePath+"'/>"
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.admissionNum+"'>"
											+ orderObj.admissionNum
											+ "</td>"
//											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.boardName+"' >"
//											+ orderObj.boardName
//											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.className+"' >"
											+ orderObj.className
											+ "</td>"
											+ "<td class='hidden-sm hidden-xs' title='"+orderObj.mediumName+"'>"
											+ orderObj.mediumName
											+ "</td>"
											
											+ "<td align='center'>"
											+ '<a title="Admission Form" onclick=getApplicant('+orderObj.studentId+')>'
											+ '<i style="cursor: pointer;" class="fa fa-address-book-o fa-2x"></i></a>'  + '&nbsp; | &nbsp;'
											+ '<a title="Pass Out Student" style="color: red;" href="javascript:void(0)" onclick=passOutStudent('
											+ orderObj.studentId + ')'
											+ '  ><i class="fa fa-trash-o"></i></a>' 
											+ '</td>'
											+ '</tr>';
									$(tblRow).appendTo("#basicExample tbody");
									
									//$("#imageId1").attr('src', "@Url.Content("~/Content/images/ajax_activity.gif)")
								});
				if(isClick == 'Yes'){
					
					 oTable =   $('#basicExample').dataTable( {
				    	 "order": [],
				    	 "defaultContent": "",
				    	 "defaultContent": "",
				    	 aLengthMenu: [
				    	         [25, 50, 100, 200, -1],
				    	         [25, 50, 100, 200, "All"]
				    	     ],
				    	     iDisplayLength: -1,	
				        dom: 'lBfrtip',
				      
				        buttons: [
				            'copy',
				            {
				                extend: 'excel',
				                footer: true,
				                exportOptions: {
			                        columns: "thead th:not(.noExport)"
			                    }
				               
				            },
				            {
				            	 extend: 'pdfHtml5',
					                orientation: 'landscape',
					                pageSize: 'LEGAL',
					                	footer: true,
					                	 exportOptions: {
						                        columns: "thead th:not(.noExport)"
						                    }
							               
				            },
				            {
				                extend: 'print',
				                footer: true,
				                exportOptions: {
			                        columns: "thead th:not(.noExport)"
			                    }
				               
				            }
				        ]
				    
				    } );
				}
//$('#basicExample').dataTable();
		}  
		function passOutStudent(id){
			
			var studentId = id;
			/* $('input[name=checkboxName]:checked').map(function() {
				studentId.push($(this).val());
			}); */
			var count = 0;
			var checkstr =  confirm('are you sure you want to Pass Out  the student?');
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
							window.location.href='viewStudent';
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
		
			
		function searchStudent(){
			searchbtn=123;
			var studentName = $("#name").val();
			var boardName = $("#boardName").val();
			var admissionNum = $('#admissionNum').val();
			var medium = $('#medium').val();
			var caste = $('#caste').val();
			var email = $('#email').val();
			var studentName = $('#name').val();
			var className = $('#className').val();
			var section = $('#section').val();
			var mobile = $("#mobile").val();
			$('#loadAjax').show();
			$.ajax({
				type : "POST",
				url : "getStudetnDetails.json",
				dataType : "json",
				data : "boardName=" + boardName+"&admissionNum="+admissionNum +"&rollNum="+rollNum +"&medium="+medium+"&caste="+caste+"&email="+email+"&studentName="+studentName+"&className="+className+"&section="+section+"&mobile="+mobile+"&studentName="+studentName,
				success : function(response) {
//	 				 alert(response); 
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
		}
	/* 	function mediumFilter(id){
			var mediumId = $("#medium").val();
			$.ajax({
				type : "POST",
				url : "getMedium.json",
				data : "mediumId=" + mediumId,
				dataType : "json",
				success : function(response) {
					 alert(response);  
					var optionsForClass = "";
					optionsForClass = $("#medium").empty();
					optionsForClass.append(new Option("--Select--", ""));
					$.each(response, function(i, tests) {
						var id=tests.id;
						var name=tests.name;
						optionsForClass.append(new Option(name, id));
					});
					$('#medium').trigger("chosen:updated");
				},
				error : function(e) {
				},
				statusCode : {
					406 : function() {
				
					}
				}
			});
		} */
		


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
		
		var mname = null; mname = serviceUnitArray[id].motherName;
		if(mname == null || mname == ""){mname = "---";}
		
		var mob = null; mob = serviceUnitArray[id].mobile;
		if(mob == null || mob == ""){mob = "---";}
		
		var alt = null; alt = serviceUnitArray[id].alternativeMobile;
		if(alt == null || alt == ""){alt = "---";}
		var adharNumber = null; adharNumber = serviceUnitArray[id].adharNumber;
		if(adharNumber == null || adharNumber == ""){adharNumber = "---";}
		
		var email = null; email = serviceUnitArray[id].email;
		if(email == null || email == ""){email = "---";}
		
		var bg = null; bg = serviceUnitArray[id].blodgroup;
		if(bg == null || bg == ""){bg = "---";}
		
		var gender = null; gender = serviceUnitArray[id].gender;
		if(gender == null || gender == ""){gender = "---";}
		
	 	var dob = null; dob = serviceUnitArray[id].dob;
	 	if(dob == null || dob == ""){dob = "---";}
		
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
		
		var tblRow = "<table class='table table-bordered table-striped' style='width: 100%;'>"
				+"<tr>"
				+	"<td style='border: none;'><input id='printbtn' style='float: left;' class='btn btn-default' type='button' value='Print' onclick=PrintElem('#showData') /></td>"
				+	"<td style='border: none;'></td>"
				+	"<td style='border: none;'></td>"
				+	"<td style='border: none;'>"
				+		"<a style='cursor: pointer;float: right;' onclick='getBack()'><i class='fa fa-2x fa-times'></i></a>&nbsp;&nbsp;"
				+	"</td>"
				+"</tr>"
				
/*				+"<tr><td align='center' colspan='4' style='border: none;'><img src='img/ABV-header.png' style='width: 70%;height: 50px;' alt='AKSHARA BHARATHI VIDYALAYAM'></td></tr>"*/
				+"<tr><td align='center' colspan='4' style='border: none;'><img src='img/logoprint.png' style='' alt='Vivekananda Vidhyalayam'></td></tr>"
				+ "<tr><td colspan='4' style='border: none;'>"
				+ "<h2 style='text-align: center;color: black;'>Application for Admission</h2>"
//	 			+	"<h2 style='text-align: center;'><span style='text-align: center;border: 1px solid;border-radius: 5px;padding: 0.3em;background-color: black;color: white;'>Application for Admission</span></h2>"
				+ "</td></tr>"
				
				+ "<tr>"
				+ 	"<th align='left' >Name</th>"
				+ 	"<td >"+name+"</td>"
				+ 	"<td rowspan='5' style='border: none; width:100px;'>"
				+ 		"<img style='float: right;width: 100px;height: 120px;' src='"+image+"'/>"
				+ 	"</td>"
				+ "</tr>"
				
				+ "<tr><th align='left' >Type of Board</th><td >"+board+"</td></tr>"
				
				+ "<tr><th align='left' >Medium</th><td >"+medium+"</td></tr>"
				
				+ "<tr><th align='left' >Class</th><td >"+clas+"</td></tr>"
				
				+ "<tr><th align='left' >Section</th><td >"+section+"</td></tr>"
				
				+ "<tr><th align='left' >Roll No</th><td >"+rno+"</td></tr>"
				
				+ "<tr><th align='left' >Admission No</th><td >"+adno+"</td></tr>"
				
				+ "<tr><th align='left' >Father Name</th><td >"+fname+"</td></tr>"
				+ "<tr><th align='left' >Mother Name</th><td >"+mname +"</td></tr>"
				
				+ "<tr><th align='left' >Mobile No</th><td >"+mob+"</td></tr>"
				
				+ "<tr><th align='left' >Alternative No</th><td >"+alt+"</td></tr>"
				+ "<tr><th align='left' >Aadhar Number</th><td >"+adharNumber+"</td></tr>"
				
				+ "<tr><th align='left' >Email</th><td >"+email+"</td></tr>"
				
				+ "<tr><th align='left' >Blood Group</th><td >"+bg+"</td></tr>"
				
				+ "<tr><th align='left' >Gender</th><td >"+gender+"</td></tr>"
				
				+ "<tr><th align='left' >Date Of Birth</th><td >"+dob+"</td></tr>"
				
				+ "<tr><th align='left' >Religion</th><td >"+rel+"</td></tr>"
				
				+ "<tr><th align='left' >Address</th><td >"+add+"</td></tr>"
				
				+ "<tr><th align='left' >Previous Institute</th><td >"+pre+"</td></tr>"
				
				+ "<tr><th align='left' >Caste</th><td >"+caste+"</td></tr>"
				
				+ "<tr><th align='left' >Accommodation</th><td >"+acc+"</td></tr>"
				
				+ "<tr><th align='left' >Bus facility</th><td >"+bus+"</td></tr>"
				
				+ "<tr><th align='left' >Bus Route</th><td >"+busrt+"</td></tr>"
				
				+ "<tr><th colspan='2' align='left' ></th></tr>"
				
				+ "<tr><th style='text-align:left;'> Parent Signature  with date: ________________________</th><th  style='text-align:right;'>Principal Signature:________________________</th></tr>"
				
				
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

	function PrintElem(elem)
	{
		$("#printbtn").hide();
	    Popup($(elem).html());
	}

	function Popup(data)
	{
	    var mywindow = window.open('', 'new div');
	    mywindow.document.write('<html><head><title>Student Application</title></head>');
	    mywindow.document.write(data);
	    mywindow.print();
	    mywindow.close();
	    $("#printbtn").show();
	    return true;
	}
	function classNameFilter(id){
		var boardId = $("#boardName").val();
		if(boardId.length !=0){
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
				$('#className').trigger("chosen:updated");
			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {
			
				}
			}
		});
		}
	} 
		function sectionFilter(){
		var boardId = $("#boardName").val();
		var classId = $("#className").val();
		if(boardId.length !=0 && classId.length != 0){
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
				$('#section').trigger("chosen:updated");
			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {
			
				}
			}
		});
		}
	} 
		function mediumFilter(){
		var boardId = $("#boardName").val();
		var classId = $("#className").val();
		var sectionId = $("#section").val();
		if(boardId.length !=0 && classId.length != 0 &&  sectionId.length != 0){
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
				$('#section').trigger("chosen:updated");
			},
			error : function(e) {
			},
			statusCode : {
				406 : function() {
			
				}
			}
		});
		}
	}

