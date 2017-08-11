function Node(value) {
    this.value=value;
    this.next=null
}

function SinglyLinkedList(){
    this.head=null;
    this.length=0;
}
// function hoisting is depicted here
SinglyLinkedList.prototype.isEmpty=function(){
    if(!this.head) {
        console.log("List is empty");
        return true;
    } else {
        return false;
    }
}

SinglyLinkedList.prototype.add=function(value) {
    var newNode=new Node(value);
    var currentNode=this.head;
    if(!this.head) {
        this.head=newNode;
    } else {
        while(currentNode.next) {
            currentNode=currentNode.next;
        }
        currentNode.next=newNode;
    }
    this.length++;
}

SinglyLinkedList.prototype.display=function(){
    if(this.isEmpty()){
        return;
    }
    var currentNode=this.head;
    while(currentNode) {
        console.log(currentNode.value+"-->");
        currentNode=currentNode.next;
    }
}


SinglyLinkedList.prototype.removeByIndex=function(indexLocation){
    if(this.isEmpty()){
        return;
    }
    if(indexLocation<1 || indexLocation>this.length){
        console.log("Enter valid index to delete");
        return;
    }
    var currentNode=this.head;
    var count=1;
    if(indexLocation==1) {
        this.head=currentNode.next;
        currentNode=null;
        this.length--;
        return;
    }
    while(count<(indexLocation-1)) {              //stop at the node whose next node is our node to be removed
        currentNode=currentNode.next;
        count++;
    }
    if(count==this.length-1){
        currentNode.next=null;
        this.length--;
        return;
    }
    currentNode.next=currentNode.next.next;
    this.length--;
}
SinglyLinkedList.prototype.removeByValue=function(valueToRemove) {
    if(this.isEmpty()){
        return
    }
    var currentNode=this.head;
    var prevNode=null;
    if(currentNode.value===valueToRemove) {
        this.head=currentNode.next;
        currentNode=null;
        this.length--;
        return;
    }
    while(currentNode.value!==valueToRemove && currentNode.next) {
        prevNode=currentNode;
        currentNode=currentNode.next;
    }
    if(!currentNode.next && currentNode.value===valueToRemove ) {
        prevNode.next=null;
        currentNode=null;
        this.length--;
        return;
    } else if(!currentNode){
        console.log("element not in the list");
        return;
    }
    prevNode.next=currentNode.next;
    currentNode=null;
    this.length--;
}
SinglyLinkedList.prototype.searchByValue=function(valueToSearch){
    if(this.isEmpty()){
        return
    }
    var currentNode=this.head;
    var foundIndex=-1;
    var foundFlag=false;
    var count=0;
    while(currentNode){
        count++;
        if(currentNode.value===valueToSearch) {
            foundFlag=true;
            foundIndex=count;
            break;
        }
        currentNode=currentNode.next;
    }
    if(foundFlag){
        console.log("element found at : "+foundIndex);
    } else {
        console.log("element not in the list");
    }
}
