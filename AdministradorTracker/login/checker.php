<?php
include 'library.php'; // include the library for database connection

function encrypt($string){
	return base64_encode(base64_encode(base64_encode($string)));
}

function decrypt($string){
	return base64_decode(base64_decode(base64_decode($string)));
}

if(isset($_POST['action']) && $_POST['action'] == 'login'){ // Check the action `login`
	$username 		= htmlentities($_POST['username']); // Get the username
	$password 		= htmlentities(encrypt($_POST['password'])); // Get the password and decrypt it
	$query			= mysql_query('SELECT * FROM users WHERE username = "'.$username.'" AND password = "'.$password.'" '); // Check the table with posted credentials
	$num_rows		= mysql_num_rows($query); // Get the number of rows
	if($num_rows <= 0){ // If no users exist with posted credentials print 0 like below.
		echo 0;
	} else {
		$fetch = mysql_fetch_array($query);
		// NOTE : We have already started the session in the library.php
		$_SESSION['userid'] 		= $fetch['id'];
		$_SESSION['username'] 	= $fetch['username'];
		echo 1;
	}
}
?>