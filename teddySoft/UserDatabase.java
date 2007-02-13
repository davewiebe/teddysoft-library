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
		return userList[0];
	}
	
	public boolean addUser(User user){
		
		return true;
	}

	
}
