package teddySoft;
import java.io.Serializable;

public class UserDatabase implements Serializable {

	private static User[] userList = new User[10];
	private static int userListSize = 0;
	
	public static User findUser(String name){//, User[] userList){
		for (int i = 0; i < userListSize; i++){
			if ((userList[i].getName()).equals(name)){
				return userList[i];
			}
		}
		return null;
	}
	
	public static boolean addUser(String username, String password){
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
	
	public int getUserListSize(){
		return userListSize;
	}

	
}
