	/*
	 * 	Security.java
	 * 	
	 * 	Written by David Wiebe
	 * 	Edited by Jordan McMillan
	 * 
	 * 	Team TeddySoft is:
	 * 	David Wiebe
	 *  Frankie Yan
	 * 	Jordan McMillan
	 * 	Lisa Chen
	 */

package teddySoft;

public class Security{
	
	//private KeyGen key;
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
	
	// PARAM: username and password
	// POST: Returns string of key generated from param.
	public static String createKey(String username, String password){
		KeyGen keyToCreate = new KeyGen();
		//System.out.println(keyToCreate.generateKey(username, password));
		return keyToCreate.generateKey(username, password);
	}
	
	// PRE: must have users in database
	// PARAM: username, password, and userdatabase
	// POST: checks to make sure password is valid with key in userdatabase.  returns true
	public boolean validateKey(String username, String password, UserDatabase userDB){
		User a = userDB.getUser(username);
		if (a == null){ return false;}
		else{
			return validateKeyHelper(username, password, (userDB.getUser(username)).getKey());
		}
	}
	
	
	//Helper function of validateKey
	private boolean validateKeyHelper(String username, String password, String key){
		if(createKey(username, password).equals(key))
			return true;
		else return false;
	}
	
	// Test functions
	public void testKeys(){
		String d = createKey("dave", "jordan");
		String h = createKey("dave", "joddan");
	}
}