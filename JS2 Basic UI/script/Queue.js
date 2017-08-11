function Queue() {
    this.front=0;
    this.rear=-1;
    this.queue=[];
}
Queue.prototype.enqueue=function(value) {
    if (value===""){
        console.log("empty value cant be added");
        return "empty value cant be added";
    }
    this.rear++;
    this.queue[this.rear]=value;
    return "enqueued Successfully"
}
/*Queue.prototype.deque=function(){
    var deletedElement;
    if(this.front>this.rear) {
        console.log("Queue UnderFlow:Queue is empty");
        return;
    } else {
        deletedElement=this.queue[this.front];
        delete this.queue[this.front];
        this.front++;
    }
    return deletedElement;
}*/


/**
 * this method uses splice method of arrays which reduces the array length on deletion of an element
 * front remains constant here
 * rear is decreased at each deletion
 * more memory efficient than above deque code 
 */
Queue.prototype.dequeue=function(){
    var deletedElement;
    if(this.front>this.rear) {
        console.log("Queue UnderFlow:Queue is empty");
        return "Queue underflow:Queue empty";
    } else {
        deletedElement=(this.queue).splice(this.front,1);        // using splice: front remains at 0 and array is shifted after removing the front element
        this.rear--;
    }
    return deletedElement+" removed";
}
Queue.prototype.displayQueue=function(){
    if(this.isEmpty()){
        return "Queue empty";
    }
    var queueString="";
    for(var i=this.front;i<=this.rear;i++) {
        queueString+=this.queue[i]+"<--";
        console.log(this.queue[i]);
    }
    return queueString;
}
Queue.prototype.isEmpty=function(){
    if(this.front>this.rear) {
        console.log("Queue is empty");
        return true;
    } else {
        return false;
    }
}

var queue=new Queue();
function addToQueue(){
    document.getElementById("status").innerHTML=queue.enqueue(document.getElementById("inputtoqueue").value);
}
function display(){
    document.getElementById("status").innerHTML=queue.displayQueue();
}
function removeFromQueue(){
    document.getElementById("status").innerHTML=queue.dequeue();
}