<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
<script type="text/javascript" src="js/importStudent.js"></script>
	<!-- Dashboard Wrapper starts -->
	<div class="dashboard-wrapper">
	
		<!-- Top Bar starts -->
		<div class="top-bar">
			<div class="page-title">Import Students</div>
	
		</div>
		<!-- Top Bar ends -->
	
		<!-- Main Container starts -->
		<div class="main-container">
	
			<!-- Container fluid Starts -->
			<div class="container-fluid">
			<ol class="breadcrumb">
    	<li><a href="dashBoard">Home</a></li>
    	<li><a href="#">Student Details</a></li>
		<li><a href="#">Import Student</a></li>
	    </ol>
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Import Students</h4>
					</div>
					<div class="panel-body collapse in">
					<!-- Spacer starts -->
					
						<!-- Row Starts -->
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:form id="mform" action="processExcel.htm" method="post" class="form-horizontal" enctype="multipart/form-data">
											<div class="form-group">
												<label for="inputPassword3" class="col-sm-2 col-xs-12 control-label"><h5>Select File: <span style="color: red;">*</span></h5></label>
												<div class="col-sm-4 col-xs-12">
													<input class="form-control" name="excelfile2007" type="file" tabindex="1" required="required" style="margin-top:5px; border:none;">
													<span class="excelfile2007-error" id="excelfile2007-error"></span>		
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-2 col-sm-offset-2 col-xs-12">
													<input type="submit" class="btn btn-success" tabindex="2" value="Upload">
													<input type="reset" class="btn btn-danger" id="cancel" value="Reset" tabindex="3"/>
												</div>
											</div>
											<p style="font-size:14px;">Sample File   <a href ="${url}/Excel.xls" style="color:#006699;">   Download</a></p>
										</form:form>
									</div>
								</div>
							</div>
						</div>
						<!-- Row Ends -->
						
					</div>
					<!-- Spacer ends -->

				</div>
				<!-- Container fluid ends -->

			</div>
			<!-- Main Container ends -->

		</div>
		<!-- Dashboard Wrapper ends -->

<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script> -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">

var getTabName = window.location.pathname.split('/')[2];
$("#stu_li").addClass('active');
$("#stu_li ul").css('display','block');
$("#stu_li ul li a[href='"+ getTabName +"']").addClass('subactive');
</script>
