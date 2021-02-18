package DCL;

public class User {
	protected long _iD_User;
	protected String _username;
	protected String _password;
	protected String _email;

	public User() {
		throw new UnsupportedOperationException();
	}

	public User(Object aParameter) {
		throw new UnsupportedOperationException();
	}

	public String getUsername() {
		return this._username;
	}

	public void setUsername(String aUsername) {
		this._username = aUsername;
	}

	public String getPassword() {
		return this._password;
	}

	public void setPassword(String aPassword) {
		this._password = aPassword;
	}

	public String getEmail() {
		return this._email;
	}

	public void setEmail(String aEmail) {
		this._email = aEmail;
	}

	public static void createUser() {
		throw new UnsupportedOperationException();
	}

	public static User getUser() {
		throw new UnsupportedOperationException();
	}

	public static Array<User> filterUser() {
		throw new UnsupportedOperationException();
	}

	public static void updateUser() {
		throw new UnsupportedOperationException();
	}

	public static void deleteUser() {
		throw new UnsupportedOperationException();
	}
}