/**
 * Asynchronously submit email address.
 */
window.addEventListener("load", function () {
  function sendData() {
    var XHR = new XMLHttpRequest();

    // Bind the FormData object and the form element
    var FD = new FormData(form);

    // Define what happens on successful data submission
    XHR.addEventListener("load", function(event) {
      
      if (this.status == 200) {
    	document.getElementById("surveyUrl").value = event.target.responseText;
   	    // Note: .response instead of .responseText
   	    //var blob = new Blob([this.response], {type: 'image/png'});
      } else {
     	alert(event.target.responseText);
      }
    });

    // Define what happens in case of error
    XHR.addEventListener("error", function(event) {
      alert('Oups! Something goes wrong.');
    });

    // Set up our request
    XHR.open("POST", "validateEmail", true);

    // The data sent is what the user provided in the form
    XHR.send(FD);
  }

  // Access the form element...
  var form = document.getElementById("validateEmailForm");

  // ...and take over its submit event.
  form.addEventListener("submit", function (event) {
    event.preventDefault();

    sendData();
  });
});
