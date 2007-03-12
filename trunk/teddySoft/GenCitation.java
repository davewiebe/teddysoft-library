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
	
		
		String apa = "";
		String citeauthor = citeAuthor(author);
		if (citeauthor.compareTo("") == 0){
			apa = apa +
				citeTitle(title) +
				citeEdition(edition) +
				citeYear(year) +
				citePlace(place) +
				citePublisher(publisher);
			// return citation without author
			return apa;
		}
		else {
			apa = apa +
				citeAuthor(author) + 
				citeYear(year) + 
				citeTitle(title) + " " + 
				citeEdition(edition) +
				citePlace(place) + 
				citePublisher(publisher);
			return apa;
		}
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

		else set first value to be first name, unless followed by a comma.
		
		if first value was first name:
			set second value to be last name
				if there is another value
			 		set the middle to be the last name
			 		set the third value to be the last name.
			 		
		if first value was followed by a comma,
			set last name to be first value
			remove the comma
			set second value to be first name, unless followed by comma
					
		
			*/		int h = 0;
		String fname = "";
		String mname = "";
		String lname = "";
		boolean jr = false;
		for(int i = 0; i < splitString.length; i++){
			splitString[i] = splitString[i].trim();
			
			if(splitString[i].compareToIgnoreCase("Jr.") == 0 ||
					splitString[i].compareToIgnoreCase("Jr") == 0 ||
					splitString[i].compareToIgnoreCase("Jr,") == 0){
				jr = true;
			}
			
			else if(h==0 && splitString[i].compareTo("") != 0){
				if(splitString[i].endsWith(",") == true){ // if firt value ends with comma
					lname = splitString[i].substring(0, splitString[i].length()-1);
					//System.out.println("1lname = "+lname);
					h++;
				}else{
					fname = splitString[i];
					//System.out.println("2fname = "+fname);
					h++;
				}
			}
			
			else if(h==1 && fname.compareTo("") != 0 &&
					splitString[i].compareTo("") != 0){ // we already have a first name
				if(splitString[i].endsWith(",") == false){
					mname = splitString[i];
					//System.out.println("3mname = "+mname);
					h++;
				}
				else{
					lname = splitString[i];
					//System.out.println("4lname = "+lname);
					h++;
				}
			}else if (h==2 && fname.compareTo("") != 0 &&
					mname.compareTo("") != 0 && splitString[i].compareTo("") != 0){ // if we have a middle and first name
				if (mname.endsWith(",") == false){ // if the middle really is the middle, and we have another value
					lname = splitString[i];
					h++;
				}else {
					mname = lname;
					lname = splitString[i];
				}
				h++;
				
			}else if (h==2 && fname.compareTo("") != 0 &&
					lname.compareTo("") != 0 && splitString[i].compareTo("") != 0){ // if we have a middle and first name
				
				mname = splitString[i];
				h++;
				
			}else if (h==1 && lname.compareTo("") != 0 && // we have a last name, need a first name
					splitString[i].compareTo("") !=0){
				if((splitString[i].length() == 2 && splitString[i].endsWith(",")) ||
						(splitString[i].length() == 2 && splitString[i].endsWith("."))){
					mname = splitString[i];
					//System.out.println("5mname = "+mname);
					h++;
				}
				else{
					fname = splitString[i];
					//System.out.println("6fname = "+fname);
					h++;
				}				
			}else if (h==2 && lname.compareTo("") != 0 &&
					mname.compareTo("") != 0 && splitString[i].compareTo("") != 0){ // if we have a middle and first name
				fname = splitString[i];
				h++;
				
			}else if (h==2 && fname.compareTo("") != 0 &&
					lname.compareTo("") != 0 && splitString[i].compareTo("") != 0){ // if we have a middle and first name
				mname = splitString[i];
				h++;
			}
			
		}
		if (mname.compareTo("") != 0 && fname.compareTo("") == 0){
			fname = mname;
			mname = "";
		}
		if (lname.compareTo("") == 0){ // fixes bug where Williamson F  Jr. == , W. F., Jr.
			lname = fname;
			fname = mname;
			mname = "";
		}
		String name = "";
		int period = 0;

		name = name + ""+lname;
		if (fname.compareTo("") != 0){
			name = name + ", "+fname.charAt(0)+".";
			period++;
		}

		if (mname.compareTo("") != 0){
			name = name + " "+mname.charAt(0)+".";
			period++;
		}
		if(jr == true){
			name = name + ", Jr.";
			period++;
		}
		if (period == 0){ name = name+".";}
		name = name + " ";
		return name;
	}
	
	private static void citeAuthorTest(String author){
		System.out.println(author + " == " + citeAuthor(author));
	}
	
	public static void main(String []args){
		testCiteAuthor();
		
	}
	
	private static void testCiteAuthor(){
		citeAuthorTest("Fanna  Williamson   Jr.");
		citeAuthorTest("Williamson, Fanna  jr  ");
		citeAuthorTest("Fanna JR. Williamson   ");
		citeAuthorTest("Williamson F  Jr.      ");
		citeAuthorTest("Williamson, F  Jr.     ");
		citeAuthorTest("Williamson, jr F       ");
		
		citeAuthorTest("");
		citeAuthorTest("Fds sfds fds fsdf dsf df");
		citeAuthorTest("David Andrew Wiebe");
		citeAuthorTest("04593 9305 39053943");
		
		citeAuthorTest("Fanna A. Williamson   Jr. ");
		citeAuthorTest("Williamson, Fanna A jr    ");
		citeAuthorTest("Fanna A JR. Williamson    ");
		citeAuthorTest("F A Williamson Jr.        ");
		citeAuthorTest("Williamson, F A.  Jr.     ");
		citeAuthorTest("Williamson, A, jr F       ");
	}
	
	private String citeYear(String year){
		if (year.compareTo("") == 0 || year.compareTo(" ")==0){
			return "";
		}
		else {
			return ("("+year+"). ");
		}
	}
	
	private String citeTitle(String title){		
		if(title.endsWith(". "))
			return title;
		else
			return (title);
	}
	
	private String citePlace(String place){
		return place;
	}
	
	private String citePublisher(String publisher){
		
		if (publisher.compareTo("") != 0 || publisher.compareTo(" ") != 0){
			return ": " + publisher;
		}
		else{
			return "";
		}
	}

	private String citeEdition(String edition){
		if (edition.compareTo("") != 0 || edition.compareTo(" ") != 0){
			return "("+edition+"). ";
		}
		else{
			return "";
		}
	}
	
}
