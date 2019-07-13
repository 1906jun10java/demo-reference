window.onload = function(){
    document.getElementById("weather").onclick = function() {
        sendAjaxGet('http://api.openweathermap.org/data/2.5/weather?q=Tampa,us&units=imperial&APPID=859d47520ac736ebe8bbce1fef74269c', showWeather);
    };
}

// perform Ajax call
// url represents the resource being requested
// func represents the callback function to be invoked when request is complete
function sendAjaxGet(url, func) {
    // step 1: obtain xhr object (Internet Explorer 5,6 don't have it...)
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    // step 2: define onreadystatechange
    xhr.onreadystatechange = function() {
        // readyState of 4 means request is complete
        // status of 200 means ok
        if (this.readyState == 4 && this.status == 200) {
            func(this);
        }
    }
    // step 3: prepare the request
    xhr.open("GET", url, true);
    // step 4: send the request
    xhr.send(); 
    // IF WE WERE SENDING A POST REQUEST OR ANYTHING THAT USED THE BODY
    // IT WOULD GO AS AN ARGUMENT TO SEND()
}

function showWeather(xhr) {
    let weatherObj = JSON.parse(xhr.responseText);
    console.log(weatherObj);
    document.getElementById("temperature").innerText = "Current temperature: "+weatherObj.main.temp;
    document.getElementById("humidity").innerText = "Current humidity: "+weatherObj.main.humidity;
    document.getElementById("description").innerText = weatherObj.weather[0].description;
}