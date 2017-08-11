function RemoveConsecutiveDuplicate() {
    this.currentString="";
}
RemoveConsecutiveDuplicate.prototype.removeConsecutiveDuplicate=function(string) {
    if(this.currentString===string){
        return;
    } else {
        this.currentString=string;
        console.log(this.currentString+"---->")
        string=string.replace(/(.)\1{1,}/,"");
        this.removeConsecutiveDuplicate(string);
    }
    return this.currentString;
}
var removeConsecutiveObject=new RemoveConsecutiveDuplicate();

function removeDuplicate(){
    document.getElementById("status").innerHTML=removeConsecutiveObject.removeConsecutiveDuplicate(document.getElementById("inputtext").value);
}