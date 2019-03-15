function formValidate() {

    var type = document.forms["myForm"]["cost_type"].value;
    var cost = document.forms["myForm"]["amount"].value;
    

    if(isAlphebatic(type))
    	if(isNumeric(cost))
    		return true;
    	else
    		return false;
    else return false;
  
}
function isEmpty(etype,cost_type){
	if(etype=="" || etype == null){
		alert("You cannot have " + cost_type +"field empty")
	}
}  
function isEmpty1(ecost,amount ){
	if(ecost=="" || ecost == null){
		alert("You cannot have " + amount +"field empty")
	}
}  

function isAlphebatic(type) {
        var exp = /^[a-zA-Z]+$/;

        if (!isEmpty(type, "Expenses Type")) {
            if (type.match(exp)) {
                return true;
            }
            else {
                alert("Expenses Type must be alphabet");
                return false;
            }
        }
        else
            return false;
}

function isNumeric(cost) {
    	var exp = /^[0-9]+$/;

        if (!isEmpty(cost, "Cost")) {
            if (cost.match(exp)) {
            	return true;
            }
            else {
                alert("Amount must be numeric");
                return false;
            }
        }
        else
            return false;
}

   
