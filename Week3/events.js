window.onload = function() {
    let myDivs = document.getElementsByTagName("div");
    for (let i=0; i<myDivs.length; i++) {
        myDivs[i].addEventListener("click",function() {
            console.log("target: "+event.target.id+" and the current element is: "+this.id);
        }, true); // useCapture is false by default
    }

    // how to cancel events?????
    // can use event.stopPropagation to stop propagation

}