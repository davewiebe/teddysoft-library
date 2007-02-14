package teddySoft;

public class UserDatabase {
	
	private static User[] userList;
	private static int userListSize;
	
		public class User{
		
			private String name;
			private String key;
			//private MediaDatabase media;
			
			public User(String name, String password){
				this.name = name;
				this.key = Security.getKey(name, password);
			}
			
			public String getKey(){
				return key;
			}
			
			public void setName(String name){
				this.name = name;
			}
			
			public void setKey(String key){
				this.key = key;
			}
			
			public String getName(){
				return name;
			}
		}


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
	
	public boolean addUser(String username, String password){
		User user = new User(username, password);
		return addUser(user);
	}
	
	public static boolean addUser(User user){
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
