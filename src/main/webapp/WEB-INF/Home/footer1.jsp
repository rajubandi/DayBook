<!-- 		<footer class="navbar-fixed-bottom">Copyright Akshara Bharathi Vidyalayam, Mangalagiri.</footer> -->
		<!-- Footer ends -->
		<!-- custom validations -->
		<script src="js/custemValidation.js"></script>
		
		
		<!-- custom validations -->
<!-- 		<script src="js/jquery.js"></script> -->
<!-- 		<script src="js/jquery-ui-v1.10.3.js"></script> -->
		<script src="js/bootstrap.min.js"></script>
		<script src="js/sparkline.js"></script>
		<script src="js/scrollup/jquery.scrollUp.js"></script>
		<script src="js/bootstrap-datetimepicker.min.js"></script> <!-- Date picker -->

		  <!-- Data Tables -->
		<script src="js/datatables/dataTables.min.js"></script>
		<script src="js/datatables/dataTables.bootstrap.min.js"></script>
		<script src="js/datatables/dataTables.tableTools.js"></script>
		<script src="js/datatables/autoFill.min.js"></script>
		<script src="js/datatables/autoFill.bootstrap.min.js"></script>
		<script src="js/datatables/fixedHeader.min.js"></script> 
	 
		<!-- Download / CSV / Copy / Print -->
	<!-- 	<script src="js/datatables/buttons.min.js"></script>
		<script src="js/datatables/flash.min.js"></script>
		<script src="js/datatables/jszip.min.js"></script>
		<script src="js/datatables/pdfmake.min.js"></script>
		<script src="js/datatables/vfs_fonts.js"></script>
		<script src="js/datatables/html5.min.js"></script>
		<script src="js/datatables/buttons.print.min.js"></script>
		
		Custom Data tables
		<script src="js/datatables/custom-datatables.js"></script> -->
		
		
		
		
		
		
<script src="datatable/jquery.dataTables.min.js"></script>
<script src="datatable/dataTables.buttons.min.js"></script>
<script src="datatable/buttons.flash.min.js"></script>
<script src="datatable/jszip.min.js"></script>
<script src="datatable/pdfmake.min.js"></script>
<script src="datatable/vfs_fonts.js"></script>
<script src="datatable/buttons.html5.min.js"></script>
<script src="datatable/buttons.print.min.js"></script>
		
		
<script type="text/javascript">
var isClick = 'Yes'; 
var activeAcademicYearId = '<%= session.getAttribute("activeAcademicYearId") %>';
function activateAcademicYear(){
	
	var id12 = $("#academicYearList").val(); 
	
	  $.ajax({
				type : "POST",
				url : "activateAcademicYear.json",
				data : "id="+id12,
				success : function(response) {
					/* var jsonobj = $.parseJSON(response);
					var alldata = jsonobj.allOrders1;
					displayTable(alldata); */
					window.location.href='?';
					activeAcademicYearId = id12;
				},
				error : function(e) {
				}
			});
	
}

	$.fn.dataTableExt.sErrMode = 'console';
	var oTable = null ;
	$(function(){
		 oTable =  $('#basicExample,#dayWiseExpenses,#basicExampleDFC').dataTable( {
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
	                columns: "thead th:not(.noExport)"
	            },
	            {
	            	 extend: 'pdfHtml5',
		                orientation: 'landscape',
		                pageSize: 'LEGAL',
		                	footer: true,
		                	 columns: "thead th:not(.noExport)"
	            },
	            {
	                extend: 'print',
	                footer: true,
	                columns: "thead th:not(.noExport)"
	               
	            }
	        ]
	    
	    } );
		
		//console.log(oTable);
	} );
	/* $('#basicExample').dataTable({
        "order": []
    }); */

</script>

	<!-- Flot Charts -->
    <script src="js/flot/jquery.flot.min.js"></script>
    <script src="js/flot/jquery.flot.orderBar.min.js"></script>
    <script src="js/flot/jquery.flot.pie.min.js"></script>
    <script src="js/flot/jquery.flot.stack.min.js"></script>
    <script src="js/flot/jquery.flot.tooltip.min.js"></script>
    <script src="js/flot/jquery.flot.resize.min.js"></script>
    <script src="js/flot/jquery.flot.time.min.js"></script>

    <script src="js/flot/custom/vertical.js"></script>

		<!-- Custom Index -->
		<script src="js/custom.js"></script>
<!-- 		<script src="js/custom-index.js"></script> -->
		
	</body>
</html>