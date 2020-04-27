
 function validateform()
{  
	console.log("in");
var name=document.getElementById("name");  
if (name==null || name=="")
{  
  alert("Name can't be blank");  
  return false;  
}
  
var num=document.getElementById("num");  
if (num.toString().length!=10)
alert("phone number should have ten digits");

}  
 
 
