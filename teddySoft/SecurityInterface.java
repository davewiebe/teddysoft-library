package teddySoft;

public interface SecurityInterface {
	void changePassword(String newPass);
	boolean changeUserName(String newName);
	boolean addUser(String name, String password);
	
}
