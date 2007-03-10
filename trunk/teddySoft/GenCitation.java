	/*
	 * 	GenCitation.java
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

public class GenCitation {

	
	public String genAPA(String author, String year, String title, String place, String publisher, String edition){
		String apa = citeAuthor(author) + citeYear(year) + 
			citeTitle(title) + citePlace(place) + citePublisher(publisher) + citeEdition(edition);
		return apa;
	}

	
	private static String citeAuthor(String author){
		//if (author.compareToIgnoreCase("") == 1 || 
		//		author.compareToIgnoreCase(" ") == 1 ||
		///		author.compareToIgnoreCase("  ") == 1){
		//	return "";
		//}
		String[] splitString = author.split(" ");
		
		/*run through name.
		if jr. exists, remove it, and add 1 to junior.

		set first real value to be first name, unless followed by a comma.
		set second real value to be last name, unless its one letter long, or one letter followed by a period.
		if the second value was 1 letter long or followed by a period, set it to be the middle name, and set the third value 

		to be the last name.


		if first real value was followed by a comma, set the second value to be the first name, and the first value to be 

		last name.
		if the second value was 1 letter long or followed by a period, set it to be the middle name, and set the third value 

		to be the last name.
		*/
		int h = 0;
		String fname = "";
		String mname = "";
		String lname = "";
		boolean jr = false;
		for(int i = 0; i < splitString.length; i++){
			splitString[i] = splitString[i].trim();
			
			if(splitString[i].compareToIgnoreCase("Jr.") == 0 ||
					splitString[i].compareToIgnoreCase("Jr") == 0){
				jr = true;
			}
			
			else if(h==0 && splitString[i].compareTo("") != 0){
				if(splitString[i].endsWith(",") == true){
					lname = splitString[i].substring(0, splitString[i].length()-1);
					//System.out.println("1lname = "+lname);
					h++;
				}else{
					fname = splitString[i];
					//System.out.println("2fname = "+fname);
					h++;
				}
			}
			
			else if(h==1 && fname.compareTo("") != 0){ // we already have a first name
				if(splitString[i].compareTo("") != 0){
					if(splitString[i].length() == 1 || 
							(splitString[i].length() == 2 && splitString[i].endsWith("."))){
						mname = (""+splitString[i].charAt(0));
						//System.out.println("3mname = "+mname);
						h++;
					}
					else{
						lname = splitString[i];
						//System.out.println("4lname = "+lname);
						h++;
					}
				}
			}else{ // we need a first name
				if(splitString[i].compareTo("") !=0){
					if(splitString[i].length() == 1 || 
							(splitString[i].length() == 2 && splitString[i].endsWith("."))){
						mname = (""+splitString[i].charAt(0));
						//System.out.println("5mname = "+mname);
						h++;
					}
					else{
						fname = splitString[i];
						//System.out.println("6fname = "+fname);
						h++;
					}
				}
			}
			
		}
		
		if (lname.compareTo("") == 0){ // fixes bug where Williamson F  Jr. == , W. F., Jr.
			lname = fname;
			fname = mname;
			mname = "";
		}
		String name = "";
		int period = 0;

		name = name + lname;
		if (fname.compareTo("") != 0){
			name = name + ", "+fname.charAt(0)+".";
			period++;
		}

		if (mname.compareTo("") != 0){
			name = name + ", "+mname.charAt(0)+".";
			period++;
		}
		if(jr = true){
			name = name + ", Jr.";
			period++;
		}
		if (period == 0){ name = name+".";}
		return name;
	}
	
	private static void citeAuthorTest(String author){
		System.out.println(author + " == " + citeAuthor(author));
	}
	
	public static void main(String[] args){
		citeAuthorTest("Fanna  Williamson   Jr.");
		citeAuthorTest("Williamson, Fanna  jr");
		citeAuthorTest("Fanna JR. Williamson ");
		citeAuthorTest("Williamson F  Jr.");
		citeAuthorTest("Williamson, F  Jr.");
		citeAuthorTest("Williamson, jr F");
	}
	
	private String citeYear(String year){
		if (year.compareTo("") == 0 || year.compareTo(" ")==0){
			return "";
		}
		else {
			return ("("+year+").");
		}
	}
	
	private String citeTitle(String title){		
		if(title.endsWith("."))
			return title;
		else
			return (title+".");
	}
	
	private String citePlace(String place){
		return place+".";
	}
	
	private String citePublisher(String publisher){
		return publisher+".";
	}

	private String citeEdition(String edition){
		return edition+".";
	}
	
}
