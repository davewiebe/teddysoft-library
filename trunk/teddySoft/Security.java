/*
	Security.java
	Written by David Wiebe
	Edited by Jordan McMillan
	
	Software group: TeddySoft.
	
*/


package teddySoft;

public class Security{
	
	private UserDatabase users;
	
/*	public boolean validateUser(String username, String password){		
		return (users.findUser(username).getKey() == key.generateKey(username, password));
	}*/
/*	public Security(){
		users = new UserDatabase();
		users.addUser("JordanMc", "password"); //test
	}*/
	
/*	public static String getKey(String username, String password){
		key = new KeyGen();
		System.out.println(key.generateKey(username, password));
		return key.generateKey(username, password);
	}*/
	
	//PARAM: username and password
	//POST: returns generated key from keyGen class using username and password
	public static String createKey(String username, String password){
		KeyGen keyToCreate = new KeyGen();
		//System.out.println(keyToCreate.generateKey(username, password));
		return keyToCreate.generateKey(username, password);
	}
	
	//PRE:  must have users registered into userDatabase
	//PARAM: username, userPassword, userDatabase. 
	//POST: validates key from keygen with the key in the userDatabase, to see if the passwords match
	public boolean validateKey(String username, String password, UserDatabase userDB){
		User a = userDB.getUser(username);
		if (a == null){ return false;}
		else{
			return validateKeyHelper(username, password, (userDB.getUser(username)).getKey());
		}
	}
	
	//helper function to validateKey
	// compares key to generated key from username and password.
	private boolean validateKeyHelper(String username, String password, String key){
		if(createKey(username, password).equals(key))
			return true;
		else return false;
	}
	
	// Test function with a few keys.
	public void testKeys(){
		String g = createKey("dave", "jordan");
		String h = createKey("dave .", "dave .");
		String i = createKey("", "");
		String j = createKey("teskldjsklfjd29", "hello!.");
	}
}