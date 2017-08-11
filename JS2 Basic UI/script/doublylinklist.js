function Node(value) {
    this.value=value;
    this.prev=null;
    this.next=null
}

function DoublyLinkedList(){
    this.head=null;
    this.length=0;
}

DoublyLinkedList.prototype.add=function(value){
    if (value===""){
        console.log("empty value cant be added");
        return "empty value cant be added";
    }
    var newNode=new Node(value);
    var currentNode=this.head;

    if(!this.head) {
        this.head=newNode;
    } else {
        while(currentNode.next) {
            currentNode=currentNode.next;
        }
        newNode.prev=currentNode;
        currentNode.next=newNode;
    }
    this.length++;
    return "node added";
}

DoublyLinkedList.prototype.removeByIndex = function(indexLocation) {
    if (indexLocation===""){
        console.log("empty index Location:supply an index in textbox");
        return "empty indexLocation";
    }
    if(this.isEmpty()){
        return "EmptyList";
    }
    if(indexLocation<1 || indexLocation>this.length){
        console.log("Enter valid index to delete");
        return "Invalid Index";
    }
    var currentNode=this.head;
    var count=1;
    if(indexLocation==1) {
        this.head=currentNode.next;
        currentNode=null;
        this.length--;
        return "Node Removed successfully";
    }
    
    while(count<indexLocation) {
        currentNode=currentNode.next;
        count++;
    }

    if(indexLocation==this.length) {
        currentNode.prev.next=null;
        currentNode=null;
        this.length--;  
        return "Node Removed successfully";  
    }

    currentNode.prev.next=currentNode.next;
    currentNode.next.prev=currentNode.prev;
    currentNode=null;
    this.length--;
    return "Node Removed successfully";

}

// function hoisting is depicted here
DoublyLinkedList.prototype.isEmpty=function(){
    if(!this.head) {
        console.log("List is empty");
        return true;
    } else {
        return false;
    }
}

DoublyLinkedList.prototype.display=function() {
    var linkListNodes="";
    if(this.isEmpty()){
        return "List is empty";
    }
    var currentNode=this.head;
    while(currentNode) {
        linkListNodes+=currentNode.value+"<-->";
        console.log(currentNode.value+"<-->");
        currentNode=currentNode.next;
    }
    return linkListNodes;
}

DoublyLinkedList.prototype.removeByValue=function(valueToRemove) {
    if (valueToRemove===""){
        console.log("empty value: supply a value to remove in textbox");
        return "empty value: supply a value to remove in textbox";
    }
    if(this.isEmpty()){
        return "list is empty";
    }
    var currentNode=this.head;
    if(currentNode.value===valueToRemove) {
        this.head=currentNode.next;
        currentNode=null;
        this.length--;
        return "Node Removed successfully";
    }
    while(currentNode.value!==valueToRemove && currentNode.next) {      //til the last node
        currentNode=currentNode.next;
    }

    if(currentNode.value===valueToRemove && currentNode.next){
        currentNode.prev.next=currentNode.next;
        currentNode.next.prev=currentNode.prev;
        this.length--;
        return "Node Removed successfully";
    } else if(currentNode.value===valueToRemove) {
        currentNode.prev.next=null;
        currentnode=null;
        this.length--;
        return "Node Removed successfully";
    } else{
        console.log("element not in the list");
        return "Node Not Found";
    }
}

var doubleLinkList=new DoublyLinkedList();
function addToList(){
    document.getElementById("status").innerHTML=doubleLinkList.add(document.getElementById("inputtolist").value);
}
function removeByValueList(){
    document.getElementById("status").innerHTML=doubleLinkList.removeByValue(document.getElementById("inputtolist").value)
}
function removeByIndexList(){
    document.getElementById("status").innerHTML=doubleLinkList.removeByIndex(document.getElementById("inputtolist").value)
}
function displayList(){
    document.getElementById("status").innerHTML=doubleLinkList.display(document.getElementById("inputtolist").value)
}