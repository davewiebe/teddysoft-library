package teddySoft;

public class User {
	private String name;
	private String password;
	
	private Database db;

	public String getName(){
		return name;
	}
	
	public void setPassword(String newPass){
		password = newPass;
	}
	
	public Database getDatabase(){
		return db;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public String getUserKey(String username){
		///find username, return key
		String key = "";
		return key;
	}
	
	
	public User(String newName, String newPassword){
			password = newPassword;
			name = newName;
			db = new Database();
	}
	
}
