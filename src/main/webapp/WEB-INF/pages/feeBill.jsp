<%@ page language='java' contentType='text/html; charset=ISO-8859-1' pageEncoding='ISO-8859-1'%>
<!DOCTYPE html>
<html lang='en'>
<head>
  <title>Bootstrap Example</title>
  <meta charset='utf-8'>
  <meta name='viewport' content='width=device-width, initial-scale=1'>
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>
  <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
  <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
<style type='text/css'>
table
{
	border: 2px solid blue;
	width: 100%;
}
</style>
</head>
<body>

<div class='container'>
  <h2>Modal Example</h2>
  <!-- Trigger the modal with a button -->
  <a data-toggle='modal' data-target='#myModal'>Open Modal</a>

  <!-- Modal -->
  <div class='modal fade' id='myModal' role='dialog'>
    <div class='modal-dialog'>
    
      <!-- Modal content-->
      <div class='modal-content'>
        <div class='modal-header'>
          <button type='button' class='close' data-dismiss='modal'>&times;</button>
          <h4 class='modal-title'>Fee Payment</h4>
        </div>
        <div class='modal-body'>
          <h4>Akshara Vidyaniketan.</h4>
          <table class='' style='' border='3'>
          	<thead>
          		<tr><th>Fee Particulars</th><th>Amount</th></tr>
          	</thead>
          	<tbody>
          		<tr><td>Student Name: Nitun</td><td></td></tr>
          		<tr><td>Board: SSC</td><td></td></tr>
          		<tr><td>Medium: English</td><td></td></tr>
          		<tr><td>Class: 1st</td><td></td></tr>
          		<tr><td>Section: A</td><td></td></tr>
          		<tr><td>School Fee</td><td>15000/-</td></tr>
          		<tr><td>Paid Amount</td><td>5000/-</td></tr>
          		<tr><td>Due Amount</td><td>10000/-</td></tr>
          		<tr><td align='right'><b>Closing Amount</b></td><td align='center'>5000/-</td></tr>
          	</tbody>
          </table>
        </div>
        <div class='modal-footer'>
          <button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>

</body>
</html>
