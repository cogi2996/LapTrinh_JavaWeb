package firebase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.google.firebase.database.FirebaseDatabase;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class FireBaseService {

	FirebaseDatabase db;

	public FireBaseService() throws IOException {
		File file = new File(getClass().getClassLoader().getResource("key.json").getFile());

		FileInputStream serviceAccount = new FileInputStream(file);

		FirebaseOptions options = FirebaseOptions.builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://strange-song-394808-default-rtdb.firebaseio.com").build();

		FirebaseApp.initializeApp(options);

	}

	public FirebaseDatabase getDb() {
		return db;
	}
	  public static void main(String[] args) throws IOException {
	        // Khởi tạo FireBaseService
	        FireBaseService fireBaseService = new FireBaseService();

	        // Lấy đối tượng FirebaseDatabase
	        FirebaseDatabase db = fireBaseService.getDb();

	        // Kiểm tra xem đối tượng FirebaseDatabase có null hay không
	        if (db != null) {
	            System.out.println("Kết nối thành công");
	        } else {
	            System.out.println("Kết nối thất bại");
	        }
	    }
}
