import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Kelas yang merepresentasikan komunikasi dengan php file untuk diteruskan agar
 * dapat melakukan komunikasi dengan database mysql.
 * 
 * @author muhammadgilangjanuar at SEMAR Development
 *
 */
public class MySQLConnect {
	public String site;

	/**
	 * Konstruktor default yang akan mendefinisikan alamat situs tempat php file
	 * di upload.
	 * 
	 * @param site
	 *            String url situs dengan diakhiri "/". Misalnya
	 *            "http://semardev.com/".
	 */
	public MySQLConnect(String site) {
		this.site = site + "/php_files/";
	}

	/**
	 * Method utama yang akan mengeksekusi setiap perintah pada method-method
	 * yang lain.
	 * 
	 * @param url
	 *            Object URL yang mendefinisikan url dari file php.
	 */
	public void execute(URL url) {
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStreamReader read = new InputStreamReader(
					(InputStream) conn.getContent());
			Scanner in = new Scanner(read);
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				while (in.hasNextLine()) {
					System.out.println(in.nextLine());
				}
			} else {
				System.out.println("err");
			}
		} catch (Exception e) {

		}
	}

	/**
	 * Method yang akan menjalankan atau membuka file insert.php disertai id dan
	 * data. Method ini juga yang bertugas memasukkan query ke mysql.
	 * 
	 * @param id
	 *            Kode unik yang menjadi primary key dalam table.
	 * @param data
	 *            String data yang akan masuk ke kolom data di table.
	 */
	public void insert(String id, String data) {
		try {
			URL url = new URL(site + "insert.php?id=" + id + "&data=" + data);
			execute(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method yang akan melakukan komunikasi dengan file delete.php dengan id
	 * yang akan mendefinisikan baris mana yang akan dihapus di mysql.
	 * 
	 * @param id
	 *            Kode dari query yang akan dihapus.
	 */
	public void delete(String id) {
		try {
			URL url = new URL(site + "delete.php?id=" + id);
			execute(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method yang akan melakukan komunikasi dengan file select.php. Method ini
	 * juga berfungsi mendapatkan data dengan spesifikasi id-nya melalui tabel
	 * di mysql.
	 * 
	 * @param id
	 *            Kode dari query yang akan diambil datanya.
	 */
	public void getData(String id) {
		try {
			URL url = new URL(site + "select.php?id=" + id);
			execute(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method yang akan melakukan komunikasi dengan file select.php. Method ini
	 * juga berfungsi mendapatkan data seluruhnya yang ada di tabel.
	 */
	public void getData() {
		try {
			URL url = new URL(site + "select.php");
			execute(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}