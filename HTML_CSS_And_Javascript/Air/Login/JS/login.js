
var generate = function(){
	 var mobile=document.getElementById("mobile").value; 
 	if(mobile.toString().length!=10) alert("Only 10 digit number is allowed");
 	let gotp = Math.floor(Math.random()*1000000);
 	console.log(gotp);
}

var submit_otp = function() {
	 var mobile=document.getElementById("mobile").value; 
 	if(mobile.toString().length!=10) alert("Only 10 digit number is allowed");
}
