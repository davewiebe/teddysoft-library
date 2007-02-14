package teddySoft;
import java.io.Serializable;

public class User implements Serializable{
	
	private String name;
	private String key;
	private MediaDatabase media;
	
	public User(String name, String password){
		this.name = name;
		this.key = Security.createKey(name, password);
		media = new MediaDatabase();
	}
	
	public String getKey(){
		return key;
	}
	
	public String getName(){
		return name;
	}
}
