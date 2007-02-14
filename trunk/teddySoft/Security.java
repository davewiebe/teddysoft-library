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
	
	public static String createKey(String username, String password){
		KeyGen keyToCreate = new KeyGen();
		System.out.println(keyToCreate.generateKey(username, password));
		return keyToCreate.generateKey(username, password);
	}
	
	public boolean validateKey(String username, String password, UserDatabase userDB){
		return validateKeyHelper(username, password, (userDB.findUser(username)).getKey());
	}
	
	public boolean validateKeyHelper(String username, String password, String key){
		if(createKey(username, password).equals(key))
			return true;
		else return false;
	}
	
	
	public void testKeys(){
		String d = createKey("dave", "jordan");
		String h = createKey("dave", "joddan");
	}
}