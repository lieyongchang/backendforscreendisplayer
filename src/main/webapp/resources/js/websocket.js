var ws;

console.log("js file called!");

function connect() {
    var username = document.getElementById("username").value;
    
    var host = document.location.host;
    var pathname = document.location.pathname;

	console.log("host name is : " + host);
	console.log("pathname is : "+ pathname);
    console.log("username is : "+ username);

    ws = new WebSocket("ws://" +host  + "/FRDisplayer/displayerData");

    ws.onmessage = function(event) {
    	var log = document.getElementById("log");
        console.log(event.data);
        var message = JSON.parse(event.data);
        log.innerHTML += message.from + " : " + message.content + "\n";
    };

}

function send() {
    var content = document.getElementById("msg").value;
    var json = JSON.stringify({
        "content":content
    });

    ws.send(json);
}