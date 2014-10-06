<?php
session_start();
mysql_connect("localhost", "root", "") or die ("Oops! Server not connected"); // Connect to the host
mysql_select_db("login") or die ("Oops! DB not connected"); // select the database
?>