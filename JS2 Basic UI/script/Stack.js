function Stack() {
    this.top=-1;
    this.stack=[];
}
Stack.prototype.push=function(element){
    if (element===""){
        console.log("empty value cant be added");
        return "empty value cant be added";
    }
    this.top++;
    this.stack[this.top]=element;
    return (""+element+"  pushed");
}
Stack.prototype.pop=function(){
    var popElement;
    if(this.top<0){
        console.log("Stack underflow:Stack is empty");
        return "Stack underflow:Stack is empty";
    } else {
        popElement=(this.stack).splice(this.top,1);
        this.top--;
    }
    return popElement+" popped out";
}

Stack.prototype.displayStack=function(){
    if(this.isEmpty()){
        return " Stack Empty";
    }
    var stackString="";
    for(var i=this.top;i>-1;i--){
        stackString+=this.stack[i]+"<br>";
        console.log(this.stack[i]);
    }
    return stackString;
}
Stack.prototype.isEmpty=function(){
    if(this.top<0){
        console.log("Stack is empty");
        return true;
    } else {
        return false;
    }
}

var stack=new Stack();
function addToStack(){
    document.getElementById("status").innerHTML=stack.push(document.getElementById("inputtostack").value);
}
function display(){
    document.getElementById("status").innerHTML=stack.displayStack();
}
function removeFromStack(){
    document.getElementById("status").innerHTML=stack.pop();
}