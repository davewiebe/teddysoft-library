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
		
		String names = "";
		String[] multipleAuthors = author.split(";");
		names += citeAuthorHelper(multipleAuthors[0]);
		for (int i = 1; i < multipleAuthors.length; i++ ){
			if (i == multipleAuthors.length-1){
				names += "& ";
			}else{
				names = names.substring(0, names.length()-1) + ", ";
			}
			names += citeAuthorHelper(multipleAuthors[i]);
		}
		return names;
	}
	
	private static String citeAuthorHelper(String author){
		//if (author.compareToIgnoreCase("") == 1 || 
		//		author.compareToIgnoreCase(" ") == 1 ||
		///		author.compareToIgnoreCase("  ") == 1){
		//	return "";
		//}
		String[] splitString = author.split(" ");
		
		int h = 0;
		String fname = "";
		String mname = "";
		String lname = "";
		String name = "";
		boolean jr = false;
		
		
		for(int i = 0; i < splitString.length; i++){
			splitString[i] = splitString[i].trim();
			if(splitString[i].compareToIgnoreCase("Jr.") == 0 ||
					splitString[i].compareToIgnoreCase("Jr") == 0 ||
					splitString[i].compareToIgnoreCase("Jr,") == 0){
				jr = true;
			}
			//else if (splitString[i].endsWith(".")){splitString[i]=splitString[i].substring(0, splitString[i].length()-1);}
			else if(h==0 && splitString[i].compareTo("") != 0){
				fname = splitString[i];
				h++;
			}
			else if(h==1 && splitString[i].compareTo("") != 0){
				mname = splitString[i];
				h++;
			}
			else if(h==2 && splitString[i].compareTo("") != 0){
				lname = splitString[i];
				h++;
			}
		}
		
		if(fname.endsWith(",")){
			fname = fname.substring(0, fname.length()-1);
			String temp = lname;
			lname = fname;
			fname = mname;
			mname = temp;
			if(fname.endsWith(",")){
				fname = fname.substring(0, fname.length()-1);
				temp = fname;
				fname = mname;
				mname = temp;
			}
		}
		if(mname.endsWith(",") && lname.compareTo("") != 0){ // prevent cases where  Dave Wiebe, A. == A., D. W. 
			mname = mname.substring(0, mname.length()-1);
			String temp = mname;
			mname = lname;
			lname = temp;		
		}
		
		if(lname.compareTo("") == 0){
			String temp = lname;
			lname = mname;
			mname = temp;
		}
		if(lname.compareTo("") == 0 && mname.compareTo("") == 0){
			lname = fname;
			fname = "";
		}
		
		if(fname.length() > 1 && lname.length() == 1 && mname.length() < 2){
			String temp = fname;
			fname = mname;
			mname = lname;
			lname = temp;
		}
		
		if(fname.length() == 0){
			fname = mname;
			mname = "";
		}
		
		name = name + ""+lname;
		
		if (fname.compareTo("") != 0){
			name = name + ", "+fname.charAt(0)+".";
		}

		if (mname.compareTo("") != 0){
			name = name + " "+mname.charAt(0)+".";
		}
		if(jr == true){
			name = name + ", Jr.";
		}
		name = name+" ";
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

		citeAuthorTest("Fanna A. Williamson   Jr. ; David A Wiebe");
		citeAuthorTest("Williamson, Fanna A jr; Dave Wiebe, A.    ");
		citeAuthorTest("Fanna A JR. Williamson ; D Wiebe ; Mcmillan, Jordan");
		citeAuthorTest("F A Williamson Jr.        ");
		citeAuthorTest("Williamson, F A.  Jr.     ");
		citeAuthorTest(" D Wiebe    ");
		citeAuthorTest(" Dave Wiebe    ");
		citeAuthorTest(" Dave Wiebe, A.   ");
		citeAuthorTest(" Wiebe D A   ");
		citeAuthorTest(" Wiebe D   ");
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
