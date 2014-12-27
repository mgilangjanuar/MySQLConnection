<?php 
include 'connect.php';
$id = $_GET['id'];
$data = $_GET['data'];

$sql = "INSERT INTO $table (id, data)
VALUES ('$id', '$data')
ON DUPLICATE KEY UPDATE data='$data'";

if ($conn->query($sql) === TRUE) {
	echo "id=" . $id . " created successfully";
} else {
	echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>