package teddySoft;

public class Security{
	
	private static KeyGen key;
	private UserDatabase users;
	
	public boolean validateUser(String username, String password){		
		return (users.findUser(username).getKey() == key.generateKey(username, password));
	}
	public Security(){
		users = new UserDatabase();
	}
	public static String getKey(String username, String password){
		key = new KeyGen();
		System.out.println(key.generateKey(username, password));
		return key.generateKey(username, password);
	}
	
	
	public static boolean validateKey(String username, String password, String key){
		return(getKey(username, password) == key);
	}
	
	public static void testKeys(){
		String d = getKey("dave", "jordan");
		String h = getKey("dave", "joddan");
	}
}