function loadGetMsg() {
    const name = document.getElementById("name").value;
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("getResponse").innerHTML = this.responseText;
    }
    xhttp.open("GET", "/hello?name=" + name);
    xhttp.send();
}

function loadPostMsg() {
    const name = document.getElementById("postname").value;
    fetch("/hellopost?name=" + name, {method: 'POST'})
        .then(response => response.text())
        .then(data => {
            document.getElementById("postResponse").innerHTML = data;
        });
}