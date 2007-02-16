	/*
	 * 	User.java
	 * 	
	 * 	Written by David Wiebe and Jordan McMillan
	 * 	Edited by David Wiebe and Jordan McMillan
	 * 
	 * 	Team TeddySoft is:
	 * 	David Wiebe
	 *  Frankie Yan
	 * 	Jordan McMillan
	 * 	Lisa Chen
	 */

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
	
	//Getters
	public String getKey(){ 
		return key;}
	
	public String getName(){
		return name;}
	
	public MediaDatabase getDB(){
		return media;}
	
	public void setDB(MediaDatabase media){
		this.media = media;
	}
}
