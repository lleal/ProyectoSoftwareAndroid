<?php
/*
Simple ajax live login script by asif18.com
*/
include 'library.php';
if(isset($_SESSION['userid']) && $_SESSION['userid'] != ''){ // Redirect to secured user page if user logged in
	echo '<script type="text/javascript">window.location = "http://localhost/AdministradorTracker/vista/index.php"; </script>';
}
?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Ajax login form using jQuery PHP MySql</title>
<script type="text/javascript" src="jquery-1.9.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#username').focus(); // Focus to the username field on body loads
	$('#login').click(function(){ // Create `click` event function for login
		var username = $('#username'); // Get the username field
		var password = $('#password'); // Get the password field
		var login_result = $('.login_result'); // Get the login result div
		login_result.html('loading..'); // Set the pre-loader can be an animation
		if(username.val() == ''){ // Check the username values is empty or not
			username.focus(); // focus to the filed
			login_result.html('<span class="error">Enter the username</span>');
			return false;
		}
		if(password.val() == ''){ // Check the password values is empty or not
			password.focus();
			login_result.html('<span class="error">Enter the password</span>');
			return false;
		}
		if(username.val() != '' && password.val() != ''){ // Check the username and password values is not empty and make the ajax request
			var UrlToPass = 'action=login&username='+username.val()+'&password='+password.val();
			$.ajax({ // Send the credential values to another checker.php using Ajax in POST menthod
			type : 'POST',
			data : UrlToPass,
			url  : 'checker.php',
			success: function(responseText){ // Get the result and asign to each cases
				if(responseText == 0){
					login_result.html('<span class="error">Username or Password Incorrect!</span>');
				}
				else if(responseText == 1){
					window.location = 'http://localhost/AdministradorTracker/vista/index.php';
				}
				else{
					alert('Problem with sql query');
				}
			}
			});
		}
		return false;
	});
});
</script>
<style type="text/css">
body{
	margin: 0;
	padding: 0;
	font-family: arial;
	color: #2C2C2C;
	font-size: 14px;
}
h1 a{
	color:#2C2C2C;
	text-decoration:none;
}
h1 a:hover{
	text-decoration:underline;
}
.as_wrapper{
	margin: 0 auto;
	width: 1000px;
}
.mytable{
	margin: 0 auto;
	padding: 20px;
	border:2px dashed #17A3F7;
}
.as_login_heading{
	margin:0;
	padding:0;
	font-weight:bold;
	text-align:left;
	font-size:18px;
}
.success{
	color:#009900;
}
.error{
	color:#F33C21;
}
.talign_left{
	text-align:left;
}
.as_input{
	border:0;
	outline:0;
	margin:0;
	padding:0;
	padding:5px;
	width:180px;
	border:#0081b5 solid 1px;
}
.as_input:hover{
	border:#321363 solid 1px;
}
.as_input.error{
	border:#ed1846 solid 1px;
}
.as_button{
	background:#ed1846;
	border:none;
	outline:none;
	margin:0;
	padding:0;
	color:#FFF;
	padding:5px 10px;
	font-weight:300;
	cursor:pointer;
}
.as_button:hover{
	background:#fe0238;
}
.as_button:active{
	background:#a1147d;
}
.login_result{
	display:block;
	width:100%;
	text-align:center;
	height:25px;
}
</style>
</head>

<body>
<div class="as_wrapper">
<h1><a href="">Ajax login form using PHP MySql</a></h1>
<p>Simple ready to use ajax login form using PHP Mysql. Easy to customize and use. Try login with below mentioned credentials,</p>
<table>
<tr>
	<th>Username</th>
    <th>Password</th>
</tr>
<tr>
	<td>superuser</td>
    <td>superpassword</td>
</tr>
<tr>
	<td></td>
</tr>
<tr>
	<td>metauser</td>
    <td>metapassword</td>
</tr>
<tr>
	<td></td>
</tr>
<tr>
	<td>googler</td>
    <td>googlepassword</td>
</tr>
<tr>
	<td></td>
</tr>
<tr>
	<td>asif18</td>
    <td>password</td>
</tr>
</table>
<br/>
<form>
<table class="mytable">
<tr>
	<td colspan="2"><h3 class="as_login_heading">Login</h3></td>
</tr>
<tr>
	<td colspan="2"><div class="login_result" id="login_result"></div></td>
</tr>
<tr>
	<td>Username</td>
    <td><input type="text" name="username" id="username" class="as_input" /></td>
</tr>
<tr>
	<td>Password</td>
    <td><input type="password" name="password" id="password" class="as_input" /></td>
</tr>
<tr>
	<td></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" name="login" id="login" class="as_button" value="Login &raquo;" /></td>
</tr>
</table>
</form>
</div>
</body>
</html>