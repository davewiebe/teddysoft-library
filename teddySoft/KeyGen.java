/*
	KeyGen.java
	Written by David Wiebe
	
	Software group: TeddySoft.

*/
package teddySoft;

public class KeyGen {
	
	//PARAM: takes in username and password
	//POST: outputs generated Key based on username and password
	public String generateKey(String username, String password){

		String key = "";// current key
		int u = 0; // username letters count
		int p = 0;// password letters count
		for (int i = 0; i < (username.length() + password.length()-2); i++){
			if (u<username.length() && p<password.length()){
				if(i%2==1){
					key+= (char)(password.charAt(p)+i+(p+1%u+1)); // randomize the key
					p++;
				}else{
					key+= (char)(username.charAt(u)+i+((u+1)%(p+1))); // randomize key
					
					u++;
				}
			}
			if(p>=password.length()){
				key+= (char)(username.charAt(u)+i+((p+1)%(u+1)));
				
				u++;
			}
			if(u>=username.length()){
				key+= (char)(password.charAt(p)+i+((u+1)%(p+1)));
				
				p++;
			}
		}
		//System.out.println(key);
		return key;
	}
		
	
}
