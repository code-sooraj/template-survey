<!DOCTYPE html>
<html>
  <head>
    <title>Survey Example</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="script/emailValidation.js"></script>
    <link rel="stylesheet" type="text/css" href="lnf/style.css">
  </head>
  <body>
    <div id="wrapper">
      <h1>Survey Name</h1>
      <p>This survey is for testing purposes.</p>
      <br />
      <div id="survey-container">
        <h3>Identify Yourself</h3>
        <form id="validateEmailForm">
          <label for="myName">Email address: </label>
          <input type="text" name="corpMail"/> <br/>
          <input type="submit" class="button" value="Validate" />
        </form>
      </div>
      <br />
      <div id="content">
        <form id="survey-question-container">
          <h3>Test Question</h3>
          <p>This question is for testing purposes.</p>
          <span>
            <select id="survey-question">
              <option name="type" value="Appliance">Appliance</option>
              <option name="type" value="Electronics">Electronics</option>
              <option name="type" value="Lights">Lights</option>
              <option name="type" value="Other">Other</option>
            </select>
          </span>
          <input type="hidden" id="surveyUrl" name="surveyUrl" />
          <input type="button" class="button" value="Next" />
          <input type="button" class="button" value="Back" />
        </form>
      </div>
    </div>
  </body>
</html>