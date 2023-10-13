import { initializeApp } from "https://www.gstatic.com/firebasejs/10.4.0/firebase-app.js";
import {
	getAuth,
	createUserWithEmailAndPassword,
	signInWithEmailAndPassword,
} from "https://www.gstatic.com/firebasejs/10.4.0/firebase-auth.js";

// Your web app's Firebase configuration
const firebaseConfig = {
	apiKey: "AIzaSyAjQ-EW74NHNWM18cww2D5A28ED3_AaKyo",
	authDomain: "strange-song-394808.firebaseapp.com",
	projectId: "strange-song-394808",
	storageBucket: "strange-song-394808.appspot.com",
	messagingSenderId: "1023545526596",
	appId: "1:1023545526596:web:fac90eccaeaa4bdfb16f11",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
// Initialize Firebase Authentication and get a reference to the service
const auth = getAuth(app);

const emailInput = document.getElementById("email");
const passwordInput = document.getElementById("password");
const loginButton = document.getElementById("login-button");
const messageDiv = document.getElementById("message");


loginButton.addEventListener("click", () => {
	const email = emailInput.value;
	const password = passwordInput.value;

	signInWithEmailAndPassword(auth, email, password)
		.then((userCredential) => {
			const user =  userCredential.user;
			// Lấy idToken từ cookie
			const idToken = user.getIdToken();
			localStorage.setItem("idToken", idToken);
			console.log("idToken:", idToken);
			console.log("Đăng nhập thành công!", user);
			messageDiv.textContent = "Đăng nhập thành công!";
			/*window.location.href = "http://localhost:8080/POST/home.jsp";
			window.location.method = "POST";*/
		})
		.catch((error) => {

			const errorMessage = error.message;
			console.error("Lỗi đăng nhập:", errorMessage);
			messageDiv.textContent = "Lỗi đăng nhập: " + errorMessage;
		});
});