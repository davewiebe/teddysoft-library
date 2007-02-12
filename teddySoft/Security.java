package teddySoft;

public class Security{
	KeyGen key = new KeyGen();
	
	public String returnPass(String username, String password){
		return this.key.generateKey(username, password);
	}
}