package teddySoft;

public class UserDatabase {
		public class User{
		
			private String name;
			private String key;
			
			public User(String name, String password){
				this.name = name;
				this.key = Security.getKey(name, password);
			}
			
			public String getKey(){
				return key;
			}
			
			public String getName(){
				return name;
			}
		}

	User[] userList;
	int userListSize;


	public UserDatabase(){
		userList = new User[10];
		userListSize = 0;
	}
	
	public User findUser(String name){
		for (int i = 0; i < userListSize; i++){
			if (userList[i].getName() == name){
				return userList[i];
			}
		}
		return null;
	}
	
	public boolean addUser(User user){
		if (userListSize == userList.length){
			User[] temp = new User[userListSize*2];
			for (int i =0; i>userListSize; i++){
				temp[i] = userList[i];
			}
			userList = temp;
		}
		userList[userListSize] = user;
		userListSize++;
		return true;
	}

	
}
