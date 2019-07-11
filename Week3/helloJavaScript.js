window.onload = function() {
    //select the element with the id "fizzBuzzButton"
    //apply an event listener to it
    //define an anonymous function to be invoked when it is clicked. 
    document.getElementById("fizzBuzzButton").addEventListener("click", function() {
        let num1 = document.getElementById("num1").value;
        let num2 = document.getElementById("num2").value;
        let phrase1 = document.getElementById("phrase1").value;
        let phrase2 = document.getElementById("phrase2").value;
        fizzBuzzOrSimilar(num1, num2, phrase1, phrase2);
    });
}

function fizzBuzzOrSimilar(num1, num2, phrase1, phrase2) {
    //console.log fizzBuzz from 1-100 with all multiples of num1 replaced with phrase1
    //all multiples of num2 replaced with phrase2
    //all multiples of both replaced with phrase1phrase2
    //validation is good!!! 
}