/*
	UserDatabase.java
	Written by David Wiebe & Jordan McMillan
	Edited by David Wiebe & Jordan McMillan
	
	Software group: TeddySoft.
	
*/

package teddySoft;

public class UserDatabase {

	// contain list of users in Dynamic Array.
	private User[] userList;
	private int userListSize;
	
	// Constructors
	public UserDatabase(User[] newList){
		userList = newList;
		userListSize = newList.length;
	}
	
	public UserDatabase(){
		userList = new User[10];
		userListSize = 0;
	}
	
	public User getUser(String name){//, User[] userList){
		for (int i = 0; i < this.getUserListSize(); i++){
			if (userList[i] != null && (userList[i].getName()).equals(name)){
				return userList[i];
			}
		}
		return null;
	}
	
	
	public boolean addUser(String username, String password){
		if (getUser(username) != null){
			return false;  //the user already exists in the system.
		}
		
		// if the dynamic array is full, bump up all the users.
		if (userListSize == userList.length){
			User[] temp = new User[userListSize*2];
			for (int i =0; i>userListSize; i++){
				temp[i] = userList[i];
			}
			userList = temp;
		}
		userList[userListSize] = new User(username, password);
		userListSize++;
		return true;
	}
	
	// getters
	public User[] getUserList(){
		return userList;
	}
	
	public int getUserListSize(){
		return userListSize;
	}	
	
	// setters
	public void setUserList(User[] newList){
		userList = newList;
	}
}

