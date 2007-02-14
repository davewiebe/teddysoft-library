package teddySoft;
//newer

public class UserDatabase {

	private User[] userList;
	private int userListSize;
	
	public UserDatabase(User[] newList){
		userList = newList;
		userListSize = newList.length;
	}
	
	public UserDatabase(){
		userList = new User[10];
		userListSize = 0;
	}
	
	public User findUser(String name){//, User[] userList){
		for (int i = 0; i < this.getUserListSize(); i++){
			if ((userList[i].getName()).equals(name)){
				return userList[i];
			}
		}
		return null;
	}
	
	public boolean addUser(String username, String password){
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
	
	public User[] getUserList(){
		return userList;
	}
	
	public void setUserList(User[] newList){
		userList = newList;
	}
	
	public int getUserListSize(){
		return userListSize;
	}	
}

