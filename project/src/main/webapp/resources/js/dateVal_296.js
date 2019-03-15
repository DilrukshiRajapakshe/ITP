function dateValidate() {

    var sDate = document.forms["myForm1"]["startDate"].value;
    var eDate = document.forms["myForm1"]["endDate"].value;
    

    if(isValid(sDate,eDate))
    	return true;
    else
    	return false;
   
  
}
function isEmpty(startDate,startDate){
	if(startDate=="" || startDate == null){
		alert("You cannot have " + startDate +"field empty")
	}
}  
function isEmpty1(endDate,endDate ){
	if(endDate=="" || endDate == null){
		alert("You cannot have " + endDate +"field empty")
	}
}  


function isValid(sDate,eDate){
	if(sDate<eDate){
		return true;
	}
	else{
		alert("Enter valid Date for Start and End");
		return false;
	}
}



   
