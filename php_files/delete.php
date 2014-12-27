<?php 
include 'connect.php';
$id = $_GET['id'];

$sql = "DELETE FROM $table WHERE id=$id";

if ($conn->query($sql) === TRUE) {
	echo "id=" . $id . " deleted successfully";
} else {
	echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>