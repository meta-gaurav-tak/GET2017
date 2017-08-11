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
        currentNode.next=newNode;
    }
    this.length++;
    return "node added";
}

SinglyLinkedList.prototype.display=function(){
    if(this.isEmpty()){
        return "List is Empty";
    }
    var linkListNodes="";
    var currentNode=this.head;
    while(currentNode) {
        linkListNodes+=currentNode.value+"-->";
        console.log(currentNode.value+"-->");
        currentNode=currentNode.next;
    }
    return linkListNodes;
}


SinglyLinkedList.prototype.removeByIndex=function(indexLocation){
    if (indexLocation===""){
        console.log("empty index Location:supply an index in textbox");
        return "empty indexLocation";
    }
    if(this.isEmpty()){
        return "list is empty";
    }
    if(indexLocation<1 || indexLocation>this.length){
        console.log("Enter valid index to delete");
        return "inavalid Index Location: Enter Valid index in textbox ";
    }
    var currentNode=this.head;
    var count=1;
    if(indexLocation==1) {
        this.head=currentNode.next;
        currentNode=null;
        this.length--;
        return "Node Removed successfully";
    }
    while(count<(indexLocation-1)) {              //stop at the node whose next node is our node to be removed
        currentNode=currentNode.next;
        count++;
    }
    if(count==this.length-1){
        currentNode.next=null;
        this.length--;
        return "Node Removed successfully";
    }
    currentNode.next=currentNode.next.next;
    this.length--;
    return "Node Removed successfully";
}
SinglyLinkedList.prototype.removeByValue=function(valueToRemove) {
    if (valueToRemove===""){
        console.log("empty value: supply a value to remove in textbox");
        return "empty value: supply a value to remove in textbox";
    }
    if(this.isEmpty()){
        return "list is empty";
    }
    var currentNode=this.head;
    var prevNode=null;
    if(currentNode.value===valueToRemove) {
        this.head=currentNode.next;
        currentNode=null;
        this.length--;
        return "Node Removed successfully";
    }
    while(currentNode.value!==valueToRemove && currentNode.next) {
        prevNode=currentNode;
        currentNode=currentNode.next;
    }
    if(currentNode.value===valueToRemove) {
        prevNode.next=currentNode.next;
        currentNode=null;
        this.length--;
        return "Node Removed successfully";
    } else {
        console.log("element not in the list");
        return "Node not in list";
    }
}

SinglyLinkedList.prototype.searchByValue=function(valueToSearch){
    var foundString="";
    if (valueToRemove==="") {
        console.log("empty value: supply a value to search in textbox");
        return "empty value: supply a value to search in textbox";
    }
    if(this.isEmpty()){
        return "Cant Search in an Empty List";
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
        foundString+="element found at : "+foundIndex;
        console.log("element found at : "+foundIndex);
    } else {
        foundString+="element not found in list";
        console.log("element not in the list");
    }
    return foundString;
}
var singleLinkList=new SinglyLinkedList();
function addToList(){
    document.getElementById("status").innerHTML=singleLinkList.add(document.getElementById("inputtolist").value);
}
function removeByValueList(){
    document.getElementById("status").innerHTML=singleLinkList.removeByValue(document.getElementById("inputtolist").value)
}
function removeByIndexList(){
    document.getElementById("status").innerHTML=singleLinkList.removeByIndex(document.getElementById("inputtolist").value)
}
function displayList(){
    document.getElementById("status").innerHTML=singleLinkList.display(document.getElementById("inputtolist").value)
}
function searchValueInList(){
    document.getElementById("status").innerHTML=singleLinkList.searchByValue(document.getElementById("inputtolist").value)
}