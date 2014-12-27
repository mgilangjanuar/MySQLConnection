<?php
include 'connect.php';
$id = $_GET['id'];

if ($id == null) {

	$sql = "SELECT id, data FROM $table";
	$result = $conn->query($sql);
	if ($result->num_rows > 0) {
		while($row = $result->fetch_assoc()) {
			echo "[id=" . $row["id"]. ", data=" . $row["data"] . "]\n";
		}
	} else {
		echo "0 results";
	}

} else {

	$sql = "SELECT id, data FROM $table WHERE id = $id";
	$result = $conn->query($sql);
	if ($result->num_rows > 0) {
		while($row = $result->fetch_assoc()) {
			echo $row["data"];
		}
	} else {
		echo "0 results";
	}

}

$conn->close();
?>