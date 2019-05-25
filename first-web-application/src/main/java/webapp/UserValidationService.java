package webapp;

public class UserValidationService {

	public boolean isValidUser(String username, String password) {
		if (username.equals("Kiran") && password.equals("Kiran")) {
			return true;
		} else {
			return false;
		}
	}
}
