/**
 * 
 */
//User Registration Form validation
function validationUserRegistrstion(){
	
	var UID = document.forms["form2"]["uid"].value;
    var UNAME = document.forms["form2"]["uName"].value;
    var PASSWORD = document.forms["form2"]["password"].value;
    var EMAIL = document.forms["form2"]["email"].value;
    var TYPE = document.forms["form2"]["type"].value;
   
    if(UserIDValidation(UID))
    	if(userNameValidation(UNAME))
            if(passwordValidation(PASSWORD))
                if(emailValidation(EMAIL))
                    if(typeValidation(TYPE))
                        return true;
                    else
                        return false;
                else
                    return false;
            else
                return false;
        else
            return false;
    else
        return false;
    
}

//Login validation
function validationLogin(){

	var UNAME = document.forms["form1"]["uName"].value;
    var PASSWORD = document.forms["form1"]["password"].value;
    
    if(userNameValidation(UNAME))
        if(passwordValidation(PASSWORD))
        	 return true;
        else
            return false;
    else
        return false;
}

//report search validation
function validationReportSearch(){
	
	var YEAR = document.forms["form3"]["year"].value;
    var MONTH = document.forms["form3"]["month"].value;
    var DAY = document.forms["form3"]["day"].value;
    
    if(yearValidation(YEAR))
        if(monthValidation(MONTH))
        	if(dayValidation(DAY))
        		return true;
        	else
            	return false;
        else
    		return false;
    else
    	return false;
}

function validationSearch2(){
	
	var SEARCH = document.forms["form44"]["search"].value;
	
	if(searchValidation(SEARCH))
		return true;
	else
    	return false;
}

function isEmpty(elemValue, field) {
    if(elemValue=="" || elemValue == null){
        alert("Please Enter The "+ field);
        return true;
    }
    else
        return false;

}

function searchValidation(elemValue){
	
	  if(!isEmpty(elemValue,"Search For Somthing"))
	  {
		 return true;
	  }
	  else
		  false;
}

function UserIDValidation(elemValue) {
    var exp = /U[0-9]/;
    if(!isEmpty(elemValue,"User ID"))
    {
        if(elemValue.match(exp))
        {
            return true;
        }
        else
        {
            alert("Enter valid user ID");
            return false;
        }
    }
    else
        return false;
}
function userNameValidation(elemValue) {
    var exp = /[0-9A-Za-z]/;
    if(!isEmpty(elemValue,"User Name"))
    {
        if(elemValue.match(exp))
        {
            return true;
        }
        else
        {
            alert("Enter valid user name");
            return false;
        }
    }
    else
        return false;
}

function passwordValidation(elemValue) {
    var exp = /[0-9A-Za-z]/;
    if(!isEmpty(elemValue,"Password"))
    {
        if(elemValue.match(exp))
        {
            return true;
        }
        else
        {
            alert("Enter valid password");
            return false;
        }
    }
    else
        return false;
}

function emailValidation(elemValue){
    if(!isEmpty(elemValue, "Email")){
        var atops = elemValue.indexOf("@");
        var dotop = elemValue.indexOf(".");
        if(atops < 1 || dotop + 2 >= elemValue.length || atops + 2 >dotop){
            alert("Enter a valid email address");
            return false;
        }
        else
            return true;
    }
    else
        return true;
}
function typeValidation(elemValue) {
    var exp1 = /Admin|User/;
 
    if(!isEmpty(elemValue,"Type"))
    {
        if(elemValue.match(exp1))
        {
            return true;
        }
        else
        {
            alert("Enter a Type");
            return false;
        }
    }
    else
        return false;
}

function yearValidation(elemValue) {
    var exp = /[0-9]{4}/;
    if(!isEmpty(elemValue,"Year"))
    {
        if(elemValue.match(exp) && elemValue <= 2500 && elemValue >= 2000)
        {
            return true;
        }
        else
        {
            alert("Enter valid Year");
            return false;
        }
    }
    else
        return false;
}

function monthValidation(elemValue) {
    var exp = /[0-9]/;
    if(!isEmpty(elemValue,"Month"))
    {
        if(elemValue.match(exp) && elemValue <= 12 && elemValue >= 1)
        {
            return true;
        }
        else
        {
            alert("Enter valid month");
            return false;
        }
    }
    else
        return false;
}

function dayValidation(elemValue) {
    var exp = /[0-9]/;
    if(!isEmpty(elemValue,"Day"))
    {
        if(elemValue.match(exp) && elemValue <= 31 && elemValue >= 1)
        {
            return true;
        }
        else
        {
            alert("Enter valid day");
            return false;
        }
    }
    else
        return false;
}
