//function to add hyperlink functionality
function changePage(page){
            window.location.href=page;
}

//function to validate form before submission
function validateForm() {
    if(validateName() && validateEmail() && validateOrganisation() && validateContact() && validateMessage() ){ 
        document.getElementById("contactForm").submit();
    } else {
        document.getElementById("formValidationMessage").innerHTML="Kindly correctly fill the red marked fields";
    }
}

//to allow only numeric keypress
function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}

//to validate a text that contains only alphabets and spaces
function validateAlphabeticText(alphatext){
   var letters = /^[A-Za-z ]*$/;  
   if(alphatext.match(letters)) {  
      return true;  
     } else {    
     return false;  
     } 
}

//to validate the name of user as directed in problem statement
function validateName(){
    var name=document.getElementById("username");
    if(name.value.length<=20 && validateAlphabeticText(name.value) && name.value!=="") { 
        name.style.border="2px solid green";
        return true; 
    } else {
        name.style.border="2px solid red";
        return false;
    }
}

//to validate organisation name
function validateOrganisation(){
    var organisation=document.getElementById("userorg");
    if(validateAlphabeticText(organisation.value)) {
        organisation.style.border="2px solid green";
        return true;
    } else {
        organisation.style.border="2px solid red";
        return false;
    }
}

//validation of the correct email address using regex
function validateEmail() {
    var emailid=document.getElementById("useremail");
    if (emailid.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/) && emailid.value!=="" ) {  
        emailid.style.border="2px solid green";
        return (true) ; 
    } else {  
        emailid.style.border="2px solid red";
        return (false);
    }
}

//check if the message length is within the described limits
function validateMessage() {
    var message=document.getElementById("usermessage");
    if(message.value.length<=250) {
        message.style.border="2px solid green";
        return true;
    } else {
        message.style.border="2px solid red";
        return false;
    }
}

//validate a mobile no. ; 10 digit no. starting with 7 or 8 or 9
function validateContact() {
    var contact=document.getElementById("usercontact");
    if (contact.value.match(/[789][0-9]{9}/) && contact.value.length==10 && contact.value!=="") { 
        contact.style.border="2px solid green"; 
        return (true) ; 
    } else { 
        contact.style.border="2px solid red";
        return (false);
    }
}

//function to autopopulate city description based on city option selected
function viewCityDescription(){
    document.getElementById("citydescription").style.visibility="visible";
    if(document.getElementById("usercity").value == "default"){
        document.getElementById("usercity").style.border="2px solid red";
        document.getElementById("citydescription").value="No option chosen";
    }else{
        document.getElementById("citydescription").value="You have selected :"+usercity.value;
    }
}

