<!DOCTYPE html>
<html>
    
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A fully featured admin theme for HRMS">
        <meta name="author" content="CHARVIKENT">

        <link rel="shortcut icon" href="assets/images/favicon.ico"> 

        <title>GST | Admin</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css" />
        <link href="css/animate.min.css" rel="stylesheet" type="text/css" />

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
table {
	width: 100%;
	counter-reset: rowNumber;
}

table tbody tr {
	counter-increment: rowNumber;
}

table tbody tr td:first-child::before {
	content: counter(rowNumber);
	min-width: 1em;
	margin-right: 0.5em;
}
/* tr{
height: 15px;
} */
th{
text-align: center;
}
.your-class::-webkit-input-placeholder {color: red !important;}
.your-class::-moz-placeholder {color: red !important;}

.default-class::-webkit-input-placeholder {color: red !important;}
.default-class::-moz-placeholder {color: red !important;}

.labelCss{
background-color: #3366cc;
padding: 0px !important;
text-align: center;
color: white;
}
.inputCss{
background-color: #b3ccff;
padding: 0px !important;
text-align: center;
color: black;
}
.form-control {
padding: 0px !important;
height: 20px;
border-radius: 0px;
text-align: center;
}
.red-tooltip + .tooltip > .tooltip-inner {background-color: #f00;}
.red-tooltip + .tooltip > .tooltip-arrow { border-bottom-color:#f00; }
.digit4{
width: 35px !important;
}
.digit5{
width: 46px !important;
}
.digit6{
width: 60px !important;
}
.digit7{
width: 72px !important;
}
.digit8{
width: 90px !important;
}
</style>

</head>

<body>
<script>

$( document ).ready(function() {
	
	$('[data-toggle="tooltip"]').tooltip();   
	
	var testId = $("#testId").text();
	$.ajax({
		type : "POST",
		url : "securityCheck.json",
		data : "testId=" + testId ,
		success : function(response) {
		},
		error : function(e) {
		}
	});
});

var dependentRowCount = 1;
var validates = true;
var rowvalidate = false;

function addMoreRowsForDependent() {
	rowvalidate =false;
	var rowid =$('#dependent_table tbody tr:last').attr('id');
	console.log(rowid);
	if(dependentRowCount != 1 && rowid !=undefined)
	{
		var rowid =$('#dependent_table tbody tr:last').attr('id');  //$('#dependent_table tr').children().last().attr('id');
	//	 	    alert(rowid);
	    var number = parseInt(rowid.match(/[0-9]+/)[0], 10);
	    var qty = $('#'+number+'qty').val();

	    if(qty == "" || qty == null || qty == "undefined")
	    {
	//	        	alert("Please Enter Name");
	    	$('#'+number+'qty').css('color','red');
	    	$('#'+number+'qty').css("border-color","#e73d4a");
	    	$('#'+number+'qty').attr("placeholder","Enter Quantity");
	    	$('#'+number+'qty').addClass('your-class');
	    	$('#'+number+'qty').focus();
	    	rowvalidate = true;
	    	return false;
	    }
	}
	else
	{
		var qty = $('#1qty').val();
		if(qty == "" || qty == null || qty == "undefined")
	    {
	//				alert("Please Enter Name");
			$('#1qty').css('color','red');
			$('#1qty').css("border-color","#e73d4a");
			$('#1qty').attr("placeholder","Enter Quantity");
			$('#1qty').addClass('your-class');
			$('#1qty').focus();
	    	rowvalidate = true;
	    	return false;
	    }
	}
	if(validates)
	{
		dependentRowCount++;
		var dependentRow1 = '<tr role="row" id="'+dependentRowCount+'">'
			+ '<td class="labelCss" ><span><a id="delete'+dependentRowCount+'" href="javascript:void(0);" style="color: red;" onclick="removeDependentRow(this.id);"><i class="fa fa-trash" style="padding-top: 5px;color: red;text-decoration: none;cursor: pointer;"></i></a></span></td>'
			+ '<td class="inputCss"><input name="pdescription" id="'
			+ dependentRowCount
			+ 'pdescription" style="background-color: #b3ccff;color: black !important;border: none;width: 150px !important;" type="text" class="form-control" onkeydown="removeBorder(this.id);"/></td>'
			+ '<td class="inputCss"><input name="code" id="'
			+ dependentRowCount
			+ 'code" type="text" style="background-color: #b3ccff;color: black !important;border: none;" class="form-control" onkeydown="removeBorder(this.id);"/></td>'
			+ '<td class="inputCss"><input name="qty" id="'
			+ dependentRowCount
			+ 'qty" type="text" style="background-color: #b3ccff;color: black !important;border: none;" class="form-control numericOnly digit5 red-tooltip" data-toggle="tooltip" title="Please Enter Quantity" data-placement="bottom" onkeydown="removeBorder(this.id);" onblur="allcalculate(this.id)" required="required"/></td>'
			+ '<td class="inputCss"><input name="unit" id="'
			+ dependentRowCount
			+ 'unit" type="text" style="background-color: #b3ccff;color: black !important;border: none;" class="form-control digit5" value="Pcs" onkeydown="removeBorder(this.id);"/></td>'
			+ '<td class="inputCss"><input name="rate" id="'
			+ dependentRowCount
			+ 'rate" value="0.00" style="background-color: #b3ccff;color: black !important;border: none;" type="text" class="form-control numericOnly red-tooltip" data-toggle="tooltip" title="Please Enter Rate" data-placement="bottom" onkeydown="removeBorder(this.id);" onkeyup="totalValue(this.id)" onblur="allcalculate(this.id)" required="required"/></td>'
			+ '<td class="labelCss"><input name="totalvalue" id="'
			+ dependentRowCount
			+ 'totalvalue" value="0.00" type="text" style="background-color: #3366cc;color: white !important;border: none;" class="form-control" onkeydown="removeBorder(this.id);" readonly="readonly"/></td>'
			+ '<td class="inputCss"><input name="discount" id="'
			+ dependentRowCount
			+ 'discount" value="0.00" style="background-color: #b3ccff;color: black !important;border: none;" type="text"  class="form-control numericOnly digit5" onkeydown="removeBorder(this.id);" onkeyup="discountValue(this.id)" onblur="allcalculate(this.id)"/></td>'
			+ '<td class="labelCss"><input name="taxable" id="'
			+ dependentRowCount
			+ 'taxable" value="0.00" type="text" style="background-color: #3366cc;color: white !important;border: none;" class="form-control numericOnly" onkeydown="removeBorder(this.id);" readonly="readonly"/></td>'
			+ '<td class="inputCss"><input name="CGSTp" id="'
			+ dependentRowCount
			+ 'CGSTp" type="text" style="background-color: #b3ccff;color: black !important;border: none;" class="form-control numericOnly digit5 red-tooltip" data-toggle="tooltip" title="Please Enter CGST Rate(%)" data-placement="bottom" onkeydown="removeBorder(this.id);" onkeyup="CGSTp(this.id)" onblur="allcalculate(this.id)" required="required"/></td>'
			+ '<td class="labelCss"><input name="CGSTa" id="'
			+ dependentRowCount
			+ 'CGSTa" value="0.00" type="text" style="background-color: #3366cc;color: white !important;border: none;" class="form-control numericOnly digit5" onkeydown="removeBorder(this.id);" readonly="readonly"/></td>'
			+ '<td class="inputCss"><input name="SGSTp" id="'
			+ dependentRowCount
			+ 'SGSTp" type="text" style="background-color: #b3ccff;color: black !important;border: none;" class="form-control numericOnly digit5 red-tooltip" data-toggle="tooltip" title="Please Enter SGST Rate(%)" data-placement="bottom" onkeydown="removeBorder(this.id);" onkeyup="SGSTp(this.id)"onblur="allcalculate(this.id)" required="required"/></td>'
			+ '<td class="labelCss"><input name="SGSTa" id="'
			+ dependentRowCount
			+ 'SGSTa" value="0.00" type="text" style="background-color: #3366cc;color: white !important;border: none;" class="form-control numericOnly digit5" onkeydown="removeBorder(this.id);" readonly="readonly"/></td>'
			+ '<td class="inputCss"><input name="IGSTp" id="'
			+ dependentRowCount
			+ 'IGSTp" type="text" style="background-color: #b3ccff;color: black !important;border: none;" class="form-control numericOnly digit5 red-tooltip" data-toggle="tooltip" title="Please Enter IGST Rate(%)" data-placement="bottom" onkeydown="removeBorder(this.id);" onkeyup="IGSTp(this.id)" onblur="allcalculate(this.id)" required="required"/></td>'
			+ '<td class="labelCss"><input name="IGSTa" id="'
			+ dependentRowCount
			+ 'IGSTa" value="0.00" type="text" style="background-color: #3366cc;color: white !important;border: none;" class="form-control numericOnly digit5" onkeydown="removeBorder(this.id);" readonly="readonly"/></td>'
// 			+ "<td class='labelCss'><a href='javascript:void(0);' style='color: red;' onclick='removeDependentRow("
// 			+ dependentRowCount + ");'><i class='fa fa-trash' style='padding-top: 5px;color: red;text-decoration: none;cursor: pointer;'></i></a></td>" 
			+ "</tr>";
		$(dependentRow1).appendTo("#dependent_table");
	}
}

function removeDependentRow(id) {
	var number = parseInt(id.match(/[0-9]+/)[0], 10);
	jQuery('#'+number).remove();
	priceCalculator();
}
function removeBorder(el) {
	$("#" + el).css("border", "");
	$("#" + el).css('color', 'black');
	$('#' + el).addClass('default-class');
}

function allcalculate(id){
	
	var total = 0;
	var number = parseInt(id.match(/[0-9]+/)[0], 10);
	var qty = $('#' + number + 'qty').val();
	var rate = $('#' + number + 'rate').val();
	total = qty * rate;

	$('#' + number + 'totalvalue').val(total);
	
	var total = $('#' + number + 'totalvalue').val();
	var discount = $('#' + number + 'discount').val();
	var result = total - discount;
	$('#' + number + 'taxable').val(result);
	
	var CGSTp = $('#' + number + 'CGSTp').val();
	var taxable = $('#' + number + 'taxable').val();
	var result = taxable * (CGSTp / 100);
	$('#' + number + 'CGSTa').val(result);
	
	var SGSTp = $('#' + number + 'SGSTp').val();
	var taxable = $('#' + number + 'taxable').val();
	var result = taxable * (SGSTp / 100);
	$('#' + number + 'SGSTa').val(result);
	
	var IGSTp = $('#' + number + 'IGSTp').val();
	var taxable = $('#' + number + 'taxable').val();
	var result = taxable * (IGSTp / 100);
	$('#' + number + 'IGSTa').val(result);
	
	priceCalculator();
}
function totalValue(id) {
	var total = 0;
	var number = parseInt(id.match(/[0-9]+/)[0], 10);
	var qty = $('#' + number + 'qty').val();
	var rate = $('#' + number + 'rate').val();
	total = qty * rate;
	$('#' + number + 'totalvalue').val(total);
}
function discountValue(id) {
	var number = parseInt(id.match(/[0-9]+/)[0], 10);
	var total = $('#' + number + 'totalvalue').val();
	var discount = $('#' + number + 'discount').val();
	var result = total - discount;
	$('#' + number + 'taxable').val(result);
}
function CGSTp(id) {
	var number = parseInt(id.match(/[0-9]+/)[0], 10);
	var CGSTp = $('#' + number + 'CGSTp').val();
	var taxable = $('#' + number + 'taxable').val();
	var result = taxable * (CGSTp / 100);
	$('#' + number + 'CGSTa').val(result);
}
function SGSTp(id) {
	var number = parseInt(id.match(/[0-9]+/)[0], 10);
	var SGSTp = $('#' + number + 'SGSTp').val();
	var taxable = $('#' + number + 'taxable').val();
	var result = taxable * (SGSTp / 100);
	$('#' + number + 'SGSTa').val(result);
}
function IGSTp(id) {
	var number = parseInt(id.match(/[0-9]+/)[0], 10);
	var IGSTp = $('#' + number + 'IGSTp').val();
	var taxable = $('#' + number + 'taxable').val();
	var result = taxable * (IGSTp / 100);
	$('#' + number + 'IGSTa').val(result);
}
function priceCalculator(){
	var globelTotalValue = 0.00;
	var globalDiscount = 0.00;
	var globalTaxable = 0.00;
	var globalTotalCGST = 0.00;
	var globalTotalSGST = 0.00;
	var globalTotalIGST = 0.00;
	var grandTotal = 0.00;
	var array = $.makeArray($('tbody tr[id]').map(function() {
		  return this.id;
		}));
		console.log(array);
	 for(var i=0;i<array.length;i++){
	
		$(".totalInvoiceValue").text('');
		$(".totalDiscounts").text('');
		$(".totalTaxableValue").text('');
		$(".totalCGST").text('');
		$(".totalSGST").text("");
		$(".totalIGST").text("");
		var discount = 0;
		var total = 0;
		var taxable = 0;
		var CGST =0;
		var SGST = 0;
		var IGST = 0;
		 total = $('#' + array[i] + 'totalvalue').val();
		globelTotalValue = globelTotalValue + parseFloat(total);
		
		 discount = $('#' + array[i] + 'discount').val();
		 if(discount == ""){
			 discount = 0;
		 }
		globalDiscount = globalDiscount + parseFloat(discount);
		
		taxable = $('#' + array[i] + 'taxable').val();
		globalTaxable = globalTaxable+parseFloat(taxable);
		
		CGST = $('#' + array[i] + 'CGSTa').val();
		globalTotalCGST = globalTotalCGST+parseFloat(CGST);
		
		SGST= $('#' + array[i] + 'SGSTa').val();
		globalTotalSGST = globalTotalSGST+parseFloat(SGST);
		
		IGST= $('#' + array[i] + 'IGSTa').val();
		globalTotalIGST = globalTotalIGST+parseFloat(IGST);
		
		$(".totalInvoiceValue").text(globelTotalValue.toFixed(2));
		$(".totalDiscounts").text(globalDiscount.toFixed(2));
		$(".totalTaxableValue").text(globalTaxable.toFixed(2));
		$(".totalCGST").text(globalTotalCGST.toFixed(2));
		$(".totalSGST").text(globalTotalSGST.toFixed(2));
		$(".totalIGST").text(globalTotalIGST.toFixed(2));
		
	 }
	 grandTotal = globalTaxable+globalTotalCGST+globalTotalSGST+globalTotalIGST;
	 $(".grandTotal").text(grandTotal.toFixed(2));
}

</script>


<div class="container">
    <div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<form id="gstForm" method="post">
            <table id="dependent_table" class="table table-responsive table-condensed table-bordered" style="color: white;border: 8px solid grey;">
            	<thead>
                    <tr>
                        <th colspan="13" class="labelCss"><a href="" style="color: yellow;text-decoration: underline;">www.ExcelDataPro.com</a></th>
                        <th rowspan="2" colspan="2"><img style="height: 30px;" alt="Image/Logo" src="img/char.jpg"></th>
                    </tr>
                    <tr>
                        <th colspan="13" class="labelCss">GST Invoice Template</th>
                    </tr>
                    <tr>
                    	<th colspan="10" class="labelCss">Street Address, Phone 1234567890, Fax 1234567890, Email: abc@abc.com</th>
                    	<th colspan="2" class="labelCss">GSTIN: </th>
                    	<th colspan="3" class="inputCss">22-AAAAA0000A-1-Z-5</th>
                    </tr>
                    <tr>
                    	<th colspan="15" class="labelCss" style="text-align: left;">Customer Details:</th>
                    </tr>
                    <tr>
                    	<th rowspan="4" class="labelCss"></th>
                    	<th class="labelCss" style="text-align: right;">Name:</th>
                    	<th colspan="10" class="inputCss" id="testId">Raj Enterprise</th>
                    	<th colspan="2" class="labelCss">POS</th>
                    	<th class="labelCss">Invoice#</th>
                    </tr>
                    <tr>
                    	<th class="labelCss" rowspan="3" style="text-align: right;"><span>Address:</span></th>
                    	<th colspan="10" class="inputCss">ABC, DEF building, HIJ Street</th>
                    	<th colspan="2" class="inputCss">Chennai</th>
                    	<th class="inputCss">2017/GST/17</th>
                    </tr>
                    <tr>
                    	<th colspan="9" class="inputCss">ABC, DEF building, HIJ Street</th>
                    	<th colspan="3" class="labelCss">GSTIN:</th>
                    	<th class="labelCss">Date</th>
                    </tr>
                    <tr>
                    	<th colspan="9" class="labelCss"></th>
                    	<th colspan="3" class="inputCss">22-AAAAA0000A-1-V-6</th>
                    	<th class="inputCss">30-Aug-2017</th>
                    </tr>
                    <tr>
                    	<th colspan="15" class="labelCss" style="text-align: left;">Product-wise Details:</th>
                    </tr>
                    <tr>
						<th rowspan="2" class="labelCss" style="">
<span style="cursor: pointer;" title="Add Row" onclick="addMoreRowsForDependent(this.form);">
	<i class="fa fa-plus" style="color: red;"></i>
</span>
							Sr.No
						</th>
						<th rowspan="2" class="labelCss" style="">Product Description</th>
						<th rowspan="2" class="labelCss" style="">HSE/SAC Code</th>
						<th rowspan="2" class="labelCss" style="">Qty</th>
						<th rowspan="2" class="labelCss" style="">Unit</th>
						<th rowspan="2" class="labelCss" style="">Rate</th>
						<th rowspan="2" class="labelCss" style="">Total Sale</th>
						<th rowspan="2" class="labelCss" style="">Disc.</th>
						<th rowspan="2" class="labelCss" style="padding-bottom: 12px;">Taxable Value</th>
						<th colspan="2" class="labelCss">CGST</th>
						<th colspan="2" colspan="2" class="labelCss">SGST</th>
						<th colspan="2" class="labelCss">IGST</th>
					</tr>
					<tr>
						<th class="labelCss">Rate%</th><th class="labelCss">Amount</th>
						<th class="labelCss">Rate%</th><th class="labelCss">Amount</th>
						<th class="labelCss">Rate%</th><th class="labelCss">Amount</th>
					</tr>
                </thead>
				<tbody>
					<tr id="1">
						<td class="labelCss"></td>
						<td class="inputCss"><input name="pdescription" style="background-color: #b3ccff;color: black !important;border: none;width: 150px !important;" id="1pdescription" style="background-color: #b3ccff;color: black !important;border: none;" type="text" onkeydown="removeBorder(this.id);" class="form-control " /></td>
						<td class="inputCss"><input name="code" id="1code" type="text" style="background-color: #b3ccff;color: black !important;border: none;" onkeydown="removeBorder(this.id);" class="form-control digit8" /></td>
						<td class="inputCss"><input name="qty" style="background-color: #b3ccff;color: black !important;border: none;" data-toggle="tooltip" data-placement="bottom" title="Please Enter Quantity" style="" id="1qty" type="text" onkeydown="removeBorder(this.id);" class="form-control numericOnly digit5 red-tooltip" onblur="allcalculate(this.id)" required="required"/></td>
						<td class="inputCss"><input name="unit" style="background-color: #b3ccff;color: black !important;border: none;" id="1unit" type="text" value="Pcs" onkeydown="removeBorder(this.id);" class="form-control digit4" /></td>
						<td class="inputCss"><input name="rate" style="background-color: #b3ccff;color: black !important;border: none;" value="0.00" data-toggle="tooltip" title="Please Enter Rate" data-placement="bottom" id="1rate" type="text" onkeydown="removeBorder(this.id);" onkeyup="totalValue(this.id)" onblur="allcalculate(this.id)" class="form-control numericOnly red-tooltip" required="required"/></td>
						<td class='labelCss'><input name="totalvalue" value="0.00" id="1totalvalue" style="background-color: #3366cc;color: white !important;border: none;" type="text" onkeydown="removeBorder(this.id);" class="form-control digit8" readonly="readonly"/></td>
						<td class="inputCss"><input name="discount" style="background-color: #b3ccff;color: black !important;border: none;" value="0.00" id="1discount" type="text" onkeydown="removeBorder(this.id);" onkeyup="discountValue(this.id)" onblur="allcalculate(this.id)" class="form-control numericOnly digit5" /></td>
						<td class="labelCss"><input name="taxable" value="0.00" id="1taxable" style="background-color: #3366cc;color: white !important;border: none;" type="text" onkeydown="removeBorder(this.id);" class="form-control digit6" readonly="readonly"/></td>
						<td class="inputCss"><input name="CGSTp" style="background-color: #b3ccff;color: black !important;border: none;" data-toggle="tooltip" title="Please Enter CGST Rate(%)" data-placement="bottom" id="1CGSTp" type="text" onkeydown="removeBorder(this.id);" class="form-control numericOnly digit5 red-tooltip" onkeyup="CGSTp(this.id)" onblur="allcalculate(this.id)" required="required"/></td>
						<td class="labelCss"><input name="CGSTa" value="0.00" id="1CGSTa" type="text" style="background-color: #3366cc;color: white !important;border: none;" onkeydown="removeBorder(this.id);" class="form-control numericOnly digit5" readonly="readonly"/></td>
						<td class="inputCss"><input name="SGSTp" style="background-color: #b3ccff;color: black !important;border: none;" data-toggle="tooltip" title="Please Enter SGST Rate(%)" data-placement="bottom" id="1SGSTp" type="text" onkeydown="removeBorder(this.id);" class="form-control numericOnly digit5 red-tooltip" onkeyup="SGSTp(this.id)" onblur="allcalculate(this.id)" required="required"/></td>
						<td class="labelCss"><input name="SGSTa" value="0.00" id="1SGSTa" type="text" style="background-color: #3366cc;color: white !important;border: none;" onkeydown="removeBorder(this.id);" class="form-control numericOnly digit5" readonly="readonly"/></td>
						<td class="inputCss"><input name="IGSTp" style="background-color: #b3ccff;color: black !important;border: none;" data-toggle="tooltip" title="Please Enter IGST Rate(%)" data-placement="bottom" id="1IGSTp" type="text" onkeydown="removeBorder(this.id);" class="form-control numericOnly digit5 red-tooltip" onkeyup="IGSTp(this.id)" onblur="allcalculate(this.id)" required="required"/></td>
						<td class="labelCss"><input name="IGSTa" value="0.00"  id="1IGSTa" type="text" style="background-color: #3366cc;color: white !important;border: none;" onkeydown="removeBorder(this.id);" class="form-control numericOnly digit7" readonly="readonly"/></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th colspan="6" class="labelCss" style="text-align: right;">Total:</th>
						<th class="labelCss"><span class="totalInvoiceValue"></span></th>
						<th class="labelCss"><span class="totalDiscounts"></span></th>
						<th class="labelCss"><span class="totalTaxableValue"></span></th>
						<th class="labelCss"></th>
						<th class="labelCss"><span class="totalCGST"></span></th>
						<th class="labelCss"></th>
						<th class="labelCss"><span class="totalSGST"></span></th>
						<th class="labelCss"></th>
						<th class="labelCss"><span class="totalIGST"></span></th>
					</tr>
					<tr>
						<th colspan="8" class="labelCss" style="text-align: left;">Remarks</th>
						<th colspan="5" class="labelCss">Summary</th>
						<th colspan="2" class="labelCss">Amount</th>
					</tr>
					<tr>
						<th colspan="8" class="inputCss"></th>
						<th colspan="5" class="labelCss" style="text-align: right;">Total Invoice value</th>
						<th colspan="2" class="labelCss" style="text-align: right;"><span class="totalInvoiceValue"></span></th>
					</tr>
					<tr>
						<th colspan="8" class="labelCss"></th>
						<th colspan="5" class="labelCss" style="text-align: right;">Total Discounts</th>
						<th colspan="2" class="labelCss" style="text-align: right;"><span class="totalDiscounts"></span></th>
					</tr>
					<tr>
						<th rowspan="2" colspan="2" class="inputCss"></th>
						<th rowspan="3" class="labelCss"></th>
						<th rowspan="2" colspan="4" class="inputCss"></th>
						<th rowspan="3" class="labelCss"></th>
						<th colspan="5" class="labelCss" style="text-align: right;">Total Taxable value</th>
						<th colspan="2" class="labelCss" style="text-align: right;"><span class="totalTaxableValue"></span></th>
					</tr>
					<tr>
						<th colspan="5" class="labelCss" style="text-align: right;">Total CGST</th>
						<th colspan="2" class="labelCss" style="text-align: right;"><span class="totalCGST"></span></th>
					</tr>
					<tr>
						<th colspan="2" class="labelCss">Receiver's Signature</th>
						<th colspan="4" class="labelCss">Senior Accounts Manager</th>
						<th colspan="5" class="labelCss" style="text-align: right;">Total SGST</th>
						<th colspan="2" class="labelCss" style="text-align: right;"><span class="totalSGST"></span></th>
					</tr>
					<tr>
						<th colspan="8" class="labelCss">Note: Make all cheques payable to Company Name</th>
						<th colspan="5" class="labelCss" style="text-align: right;">Total IGST</th>
						<th colspan="2" class="labelCss" style="text-align: right;"><span class="totalIGST"></span></th>
					</tr>
					<tr>
						<th colspan="8" class="labelCss">Thank you for your Business</th>
						<th colspan="5" class="labelCss" style="text-align: right;">Grand Total</th>
						<th colspan="2" class="labelCss" style="text-align: right;"><span class="grandTotal"></span></th>
					</tr>
				</tfoot>
			</table>
			<input type="submit" class="btn btn-success" id="submitGSTForm" value="Submit"/>
			<input type="button" class="btn btn-danger" id="cancel" onclick="resetGSTForm()" value="Reset"/>
		</form>
		</div>
    </div>
</div>

<script type="text/javascript">

//GST Form Validation Starts here
$('#submitGSTForm').click(function(e){
	if( $('#1qty').val().length == 0 || $('#1qty').val() ==" " || $('#1qty').val() =="0.00" || $('#1qty').val()=="undefined")
	{												   
		if($('#1qty').val().length == 0 || $('#1qty').val() =="" || $('#1qty').val() =="0.00" || $('#1qty').val()=="undefined") {
		    $('#1qty').css('color','red');
		    $("#1qty").css("border-color","#e73d4a");
		    $("#1qty").attr("placeholder","Enter Quantity");
		    $('#1qty').addClass('your-class');
		    $('#1qty').focus();
	    }
		return false;												  
	} 
	    
	$('#gstForm').attr('action',"submitGST");
	$("#gstForm").submit();											
	event.preventDefault();
});

function resetGSTForm()
{
	removeBorder('1qty');
	$('#1qty').val("");
	$('#1qty').removeClass('your-class default-class');
	
}
//GST Form Validation Ends here

</script>

</body>
</html>
