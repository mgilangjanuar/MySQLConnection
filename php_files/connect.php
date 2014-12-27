<?php

// Define this variable !
$servername = "";
$username = "";
$password = "";
$dbname = "";
$table = "";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
	die("Connection failed: " . $conn->connect_error);
}
?>
