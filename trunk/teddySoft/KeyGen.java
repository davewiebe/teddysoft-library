	/*
	 * 	KeyGen.java
	 * 	
	 * 	Written by David Wiebe
	 * 	
	 * 
	 * 	Team TeddySoft is:
	 * 	David Wiebe
	 *  Frankie Yan
	 * 	Jordan McMillan
	 * 	Lisa Chen
	 */

package teddySoft;

public class KeyGen {
	public String generateKey(String username, String password){

		String key = "";
		int u = 0;
		int p = 0;
		for (int i = 0; i < (username.length() + password.length()-2); i++){
			if (u<username.length() && p<password.length()){
				if(i%2==1){
					key+= (char)(password.charAt(p)+i+(p+1%u+1));
					p++;
				}else{
					key+= (char)(username.charAt(u)+i+((u+1)%(p+1)));
					
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
