//defining a worker
var w;
function startWorker() {
    if(typeof(Worker) !== "undefined") {
        if(typeof(w) == "undefined") {
            w = new Worker("script/timeStampWorker.js");
        }
    } else {
        document.getElementById("result").innerHTML = "Sorry! No Web Worker support.";
    }
    w.onmessage = function(event) {
            document.getElementById("time-from-worker").innerHTML += event.data;
        };
    w = undefined;
}

//animation
var imgObj = null;
var animate ;
    
function init(){
    imgObj = document.getElementById('myImage');
    imgObj.style.position= 'relative'; 
    imgObj.style.left = '0px'; 
}
function moveRight(){
    imgObj.style.left = parseInt(imgObj.style.left) + 400 + 'px';
    animate = setTimeout(moveLeft,1000); 
}
function moveLeft(){
    imgObj.style.left = parseInt(imgObj.style.left) - 400 + 'px';
    animate = setTimeout(moveRight,1000);
}
function stop(){
    clearTimeout(animate);
    imgObj.style.left = '0px'; 
}
window.onload =init;