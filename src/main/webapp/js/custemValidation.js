/*  $('.nospecialCharacter').bind('keypress', function(e) {
	    console.log( e.which );
	        var k = e.which;
	        var ok = k >= 65 && k <= 90 || // A-Z
	            k >= 97 && k <= 123 || // a-z
	            k >= 48 && k <= 57; // 0-9
	        
	        if (!ok){
	            e.preventDefault();
	        }
	});*/
  
 /* if(!(inputValue >= 65 && inputValue <= 123) && (inputValue != 32 && inputValue != 0)) { 
      event.preventDefault(); 
  }
 function changetext(){
$(".capsOnly").val(function () {
	    return this.value.toUpperCase();
	}); 
}*/


$(".capsOnly").keyup(function () {
this.value= this.value.toUpperCase();
}); 

/*$(".capsOnly").keypress(function (e) {
 if (String.fromCharCode(e.keyCode).match(/[^A-Z]/g)) return false;
});*/


/*$(".numericOnly").keypress(function (e) {
	
 if (String.fromCharCode(e.keyCode).match(/[^0-9]/g)) return false;
});*/

jQuery('.numericOnly').keyup(function () {  
    this.value = this.value.replace(/[^0-9\.]/g,''); 
});

/*$('.numericOnly').keydown(function (event) {

    var keycode = event.which;   

    if (!/[\d\t\b+]/.test(String.fromCharCode(event.which)) || event.shiftKey ) {
        return false;
    } else {
        return true;
    }
});*/

$(".numericOnly").keydown(function (e) {
    // Allow: backspace, delete, tab, escape, enter and .
    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
         // Allow: Ctrl+A, Command+A
        (e.keyCode === 65 && (e.ctrlKey === true || e.metaKey === true)) || 
         // Allow: home, end, left, right, down, up
        (e.keyCode >= 35 && e.keyCode <= 40)) {
             // let it happen, don't do anything
             return;
    }
    // Ensure that it is a number and stop the keypress
    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
        e.preventDefault();
    }
});



//$('.onlyCharacters').keypress(function (e) {
//	var keyCode = event.keyCode || event.which
////Don't validate the input if below arrow, delete and backspace keys were pressed 
//	if (keyCode == 8 || (keyCode >= 35 && keyCode <= 40)) { // Left / Up / Right / Down Arrow, Backspace, Delete keys
//		return;
//	}
/*var regex = new RegExp("^[A-Z, ,a-z\b]+$");
var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
if (regex.test(str)) {
  return true;
}
else
{
e.preventDefault();
return false;
}*/
//});





$('.nospecialCharacter').bind('keypress', function validate(e) {
    var regex = new RegExp("[a-zA-Z0-9]");
    var key = e.keyCode || e.which;
    key = String.fromCharCode(key);

    if(!regex.test(key) && key.charCodeAt(0) > 32) {
        e.returnValue = false;
        if(e.preventDefault) {
            e.preventDefault();
        }
    }
});

$(".onlyCharacters").on("keypress", function(event) {

    // Disallow anything not matching the regex pattern (A to Z uppercase, a to z lowercase and white space)
    var englishAlphabetAndWhiteSpace = /[A-Za-z. ]/g;
   
    // Retrieving the key from the char code passed in event.which
    var key = String.fromCharCode(event.which);
    
    //alert(event.keyCode);
    
    if (event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39 || englishAlphabetAndWhiteSpace.test(key)) {
        return true;
    }

    // If we got this far, just return false because a disallowed key was typed.
    return false;
});

$('.onlyCharacters').on("paste",function(e)
{
    e.preventDefault();
});