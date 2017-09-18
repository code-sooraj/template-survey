<!DOCTYPE html>
<html>
  <head>
    <title>Survey Example</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
	    var webSocket = 
	      new WebSocket('ws://localhost:8080/byteslounge/websocket');

	    webSocket.onerror = function(event) {
	      onError(event)
	    };

	    webSocket.onopen = function(event) {
	      onOpen(event)
	    };

	    webSocket.onmessage = function(event) {
	      onMessage(event)
	    };

	    function onMessage(event) {
	      document.getElementById('messages').innerHTML 
	        += '<br />' + event.data;
	    }

	    function onOpen(event) {
	      document.getElementById('messages').innerHTML 
	        = 'Connection established';
	    }

	    function onError(event) {
	      alert(event.data);
	    }

	    function start() {
	      webSocket.send('hello');
	      return false;
	    }
    </script>
    <link rel="stylesheet" type="text/css" href="lnf/style.css">
  </head>
  <body>

    <div id="wrapper">
        <h1>Java Websocket Home</h1>
        <p>Welcome to the Java WebSocket Home. Click the Add a device button to start adding devices.</p>
        <br />
        <div id="addDevice">
            <div class="button"> <a href="#" OnClick="showForm()">Add a device</a> </div>
            <form id="addDeviceForm">
                <h3>Add a new device</h3>
                <span>Name: <input type="text" name="device_name" id="device_name"></span>
                <span>Type: 
                    <select id="device_type">
                        <option name="type" value="Appliance">Appliance</option>
                        <option name="type" value="Electronics">Electronics</option>
                        <option name="type" value="Lights">Lights</option>
                        <option name="type" value="Other">Other</option>
                    </select></span>

                <span>Description:<br />
                    <textarea name="description" id="device_description" rows="2" cols="50"></textarea>
                </span>

                <input type="button" class="button" value="Add" onclick=formSubmit()>
                <input type="reset" class="button" value="Cancel" onclick=hideForm()>
            </form>
        </div>
        <br />
        <h3>Currently connected devices:</h3>
        <div id="content">
        </div>
    </div>

    </body>
</html>