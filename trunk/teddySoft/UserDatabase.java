package teddySoft;

public class UserDatabase {
		public class User{
		
			private String name;
			private String key;
			
			public User(String name, String password){
				this.name = name;
				this.key = Security.createKey(name, password);
			}
			
			public String getKey(){
				return key;
			}
			
			public String getName(){
				return name;
			}
		}

	private User[] userList;
	private int userListSize;

	public UserDatabase(){
		userList = new User[10];
		userListSize = 0;
		
	}
	
	public User findUser(String name){
		for (int i = 0; i < userListSize; i++){
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
	
	public int getUserListSize(){
		return userListSize;
	}

	
}
