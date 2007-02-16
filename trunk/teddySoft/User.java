/*
	User.java
	Written by David Wiebe & Jordan McMillan
	Edited by David Wiebe & Jordan McMillan
	
	Software group: TeddySoft.
	
*/

package teddySoft;

import java.io.Serializable;

public class User implements Serializable{

	// Private Variables with increased scope to be used throughout class.
	private String name;
	private String key;
	private MediaDatabase media;
	
	// Constructor
	public User(String name, String password){
		this.name = name;
		// create key to be stored with the user (instead of a password).
		this.key = Security.createKey(name, password);
		// create individual media database for user.
		media = new MediaDatabase();
	}
	
	//Getters
	public String getKey(){ 
		return key;}
	
	public String getName(){
		return name;}
	
	public MediaDatabase getDB(){
		return media;}
}
