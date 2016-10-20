<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Simple Chat</title>
    </head>
    <body>
        <g:form controller="chat" action="join" >
            <label for="nickname">Please enter your name</label>
            <g:textField name="nickname"/>
            <g:submitButton name="Join Chat"/>
        </g:form>
    </body>
</html>
