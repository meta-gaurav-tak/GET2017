var nameValidityFlag=false;
var emailValidityFlag=false;
var organisationValidityFlag=true;
var contactValidityFlag=false;
var messageValidityFlag=true;
function changePage(page){
            window.location.href=page;
}

function validateForm() {
    validateName();
    validateEmail();
    validateContact();
    if(nameValidityFlag && emailValidityFlag && organisationValidityFlag && contactValidityFlag && messageValidityFlag) { 
        document.getElementById("contactForm").submit();
    } else {
        document.getElementById("formValidationMessage").innerHTML="Kindly correctly fill the red marked fields";
    }
}

//to allow only numeric keypress
function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

function isCharacterKey(evt){
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123) || charCode < 32)
        return true;
     else
        return false;
}

function validateAlphabeticText(alphatext){
   var letters = /^[A-Za-z ]*$/;  
   if(alphatext.match(letters)) {  
      return true;  
     } else {    
     return false;  
     } 
}

function validateName(){
    var name=document.getElementById("username");
    if(name.value.length<=20 && validateAlphabeticText(name.value) && name.value!=="") { 
        nameValidityFlag=true;
        name.style.border="2px solid green";
        return true; 
    } else {
        name.style.border="2px solid red";
        return false;
    }
}

function validateOrganisation(){
    var organisation=document.getElementById("userorg");
    if(validateAlphabeticText(organisation.value)){
        organisationValidityFlag=true;
        organisation.style.border="2px solid green";
        return true;
    } else {
        organisationValidityFlag=false;
        organisation.style.border="2px solid red";
        return false;
    }
}

function validateEmail() {
    var emailid=document.getElementById("useremail");
    if (emailid.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/) && emailid.value!=="" ) {
        emailValidityFlag=true;  
        emailid.style.border="2px solid green";
        return (true) ; 
    } else {  
        emailid.style.border="2px solid red";
        return (false);
    }
}

function validateMessage() {
    var message=document.getElementById("usermessage");
    if(message.value.length<=250) {
        messageValidityFlag=true;
        message.style.border="2px solid green";
        return true;
    } else {
        messageValidityFlag=false;
        message.style.border="2px solid red";
        return false;
    }
}

function validateContact(){
    var contact=document.getElementById("usercontact");
    if (contact.value.match(/[789][0-9]{9}/) && contact.value.length==10 && contact.value!=="") { 
        contactValidityFlag=true;
        contact.style.border="2px solid green"; 
        return (true) ; 
    } else { 
        contact.style.border="2px solid red";
        return (false);
    }
}
function viewCityDescription(){
	var element = document.getElementById("usercity");
	if(document.getElementById("usercity").value !== "default" && document.getElementById("usercity").value !== "" ) {
        document.getElementById("citydescription").style.visibility="visible";
	    document.getElementById("citydescription").value="You have selected :"+usercity.value;
	}
}

function saveToStore(){
        localStorage.setItem("contactform-username",document.getElementById("username").value);
        localStorage.setItem("contactform-useremail",document.getElementById("useremail").value);
        localStorage.setItem("contactform-userorg",document.getElementById("userorg").value);
        localStorage.setItem("contactform-usercity",document.getElementById("usercity").value);
        localStorage.setItem("contactform-citydescription",document.getElementById("citydescription").value);
        localStorage.setItem("contactform-usermessage",document.getElementById("usermessage").value);
        localStorage.setItem("contactform-usercontact",document.getElementById("usercontact").value);
    }

function getFromStorage(){
    document.getElementById("username").value=localStorage.getItem("contactform-username");
    document.getElementById("useremail").value=localStorage.getItem("contactform-useremail");
    document.getElementById("userorg").value=localStorage.getItem("contactform-userorg");
    document.getElementById("usercity").value=localStorage.getItem("contactform-usercity");
    document.getElementById("citydescription").value=localStorage.getItem("contactform-citydescription");
    viewCityDescription();
    document.getElementById("usermessage").value=localStorage.getItem("contactform-usermessage");
    document.getElementById("usercontact").value=localStorage.getItem("contactform-usercontact");
}
function localStorageContactReset(){
    localStorage.removeItem("contactform-username");
    localStorage.removeItem("contactform-useremail");
    localStorage.removeItem("contactform-userorg");
    localStorage.removeItem("contactform-usercity");
    localStorage.removeItem("contactform-citydescription");
    localStorage.removeItem("contactform-usermessage");
    localStorage.removeItem("contactform-usercontact");
}
window.onload=getFromStorage;