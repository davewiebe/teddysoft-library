package teddySoft;

public class Security implements SecurityInterface{

	public void changePassword(String newPass){
		return;
	}
	public boolean changeUserName(String newName){
		return true;
	}
	public boolean addUser(String name, String password){
		return true;
	}
}
