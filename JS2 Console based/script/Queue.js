function Queue() {
    this.front=0;
    this.rear=-1;
    this.queue=[];
}
Queue.prototype.enqueue=function(value) {
    this.rear++;
    this.queue[this.rear]=value;
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
        return;
    } else {
        deletedElement=(this.queue).splice(this.front,1);        // using splice: front remains at 0 and array is shifted after removing the front element
        this.rear--;
    }
    return deletedElement;
}
Queue.prototype.displayQueue=function(){
    if(this.isEmpty()){
        return;
    }
    for(var i=this.front;i<=this.rear;i++) {
        console.log(this.queue[i]);
    }
}
Queue.prototype.isEmpty=function(){
    if(this.front>this.rear) {
        console.log("Queue is empty");
        return true;
    } else {
        return false;
    }
}