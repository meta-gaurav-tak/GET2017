function Stack() {
    this.top=-1;
    this.stack=[];
}

Stack.prototype.push=function(element){
    this.top++;
    this.stack[this.top]=element;
}
Stack.prototype.pop=function(){
    var popElement;
    if(this.top<0){
        console.log("Stack underflow:Stack is empty");
        return;
    } else {
        popElement=(this.stack).splice(this.top,1);
        this.top--;
    }
    return popElement;
}
Stack.prototype.displayStack=function(){
    if(this.isEmpty()){
        return;
    }
    for(var i=this.top;i>-1;i--){
        console.log(this.stack[i]);
    }
}
Stack.prototype.isEmpty=function(){
    if(this.top<0){
        console.log("Stack is empty");
        return true;
    } else {
        return false;
    }
}