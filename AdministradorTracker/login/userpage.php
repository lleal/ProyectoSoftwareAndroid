<?php
include 'library.php';
if(!isset($_SESSION['userid']) || $_SESSION['userid'] == ''){
	echo '<script type="text/javascript">window.location = "login.php"; </script>';
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Hi <?php echo ucfirst($_SESSION['username']); ?>, good to see you again</title>
<style type="text/css">
body{
	margin: 0;
	padding: 0;
	font-family: arial;
	color: #2C2C2C;
	font-size: 14px;
}
.a{
	color:#0033FF;
}
h1{
	margin:0;
	padding:0;
	color:#2C2C2C;
	text-decoration:none;
}
.as_wrapper{
	margin: 0 auto;
	width: 1000px;
	padding:20px;
	border:2px dashed #17A3F7;
	margin-top:20px;
}

</style>
</head>

<body>
<div class="as_wrapper">
	<h1>Hi <b><?php echo ucfirst($_SESSION['username']); ?></b>, good to see you again. This is your secured page. Click here for <a href="logout.php" class="a">logout</a></h1>
</div>
</body>
</html>