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

	
	public static String genAPA(String author, String year, String title, String place, String publisher, String edition){
		String apa = "";
		String citeAuthor = citeAuthor(author).trim();
		if (citeAuthor.equalsIgnoreCase("")){
			if(!citeTitle(title).equalsIgnoreCase("")){
				apa += citeTitle(title);
				if(!citeEdition(edition).equalsIgnoreCase("")){
					apa += " (" + citeEdition(edition) + " ed.)";
				}	
				apa += ". ";
			}
			if (!citeYear(year).equalsIgnoreCase("")){
				apa += "(" + citeYear(year) + "). ";
			}
		}
		else {
			apa += citeAuthor + " ";
			if (!citeYear(year).equalsIgnoreCase("")){
				apa += "(" + citeYear(year) + "). ";
			}
			if (!citeTitle(title).equalsIgnoreCase("")){
				apa += citeTitle(title);
				if(!citeEdition(edition).equalsIgnoreCase("")){
					apa += " (" + citeEdition(edition) + " ed.)";
				}	
				apa += ". ";
			}
		}
		
		if (!citePlace(place).equalsIgnoreCase("")){
			apa += citePlace(place);
			if (!citePublisher(publisher).equalsIgnoreCase("")){
				apa += ": " + citePublisher(publisher);
			}
			apa += ". ";
		}
		else{
			if (!citePublisher(publisher).equalsIgnoreCase("")){
				apa += citePublisher(publisher) + ". ";
			}
		}// return citation without author
		return apa;
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
	
	private static void testCiteAuthorHelper(String author){
		System.out.println(author + " == " + citeAuthor(author));
	}
	
	public static void main(String []args){
		//testCiteAuthor();
		//testCiteEdition();
		//testGenAPA();
		
	}
	
	private static void testCiteEdition(){
		testCiteEdtionHelper("3");
		testCiteEdtionHelper("3rd");
		testCiteEdtionHelper("third");
		testCiteEdtionHelper("36th");
		testCiteEdtionHelper("34");
		testCiteEdtionHelper("33");
		testCiteEdtionHelper("35478587854857841");
		testCiteEdtionHelper("1");
		testCiteEdtionHelper("0");
		testCiteEdtionHelper(" ");
		testCiteEdtionHelper("Twenty Fifth");
		testCiteEdtionHelper("dsfdagsgdsffdgshtrgyhtd");
		testCiteEdtionHelper("David Wiebe");
		testCiteEdtionHelper("-3");
		testCiteEdtionHelper("fourteenth");
		testCiteEdtionHelper("Fourteen");
		
	}
	
	private static void testCiteEdtionHelper(String edition){
		System.out.println(edition + " == " + citeEdition(edition));
	}
	
	private static void testGenAPA(){
		//genAPA(String author, String year, String title, String place, String publisher, String edition)
		testGenAPAHelper("Dave Wiebe", "1996", "Title of the book here.", "New Jersey", "Apple Books Publishing Ltd", "ThIRD edition");
		testGenAPAHelper("", "1996", "Title of the book here.", "New Jersey", "Apple Books Publishing Ltd", "ThIRD edition");
		testGenAPAHelper("Dave Wiebe", "", "Title of the book here.", "New Jersey", "Apple Books Publishing Ltd", "ThIRD edition");
		testGenAPAHelper("Dave Wiebe", "1996", "", "New Jersey", "Apple Books Publishing Ltd", "ThIRD edition");
		testGenAPAHelper("Dave Wiebe", "1996", "Title of the book here.", "", "Apple Books Publishing Ltd", "ThIRD edition");
		testGenAPAHelper("Dave Wiebe", "1996", "Title of the book here.", "New Jersey", "", "ThIRD edition");
		testGenAPAHelper("Dave Wiebe", "1996", "Title of the book here.", "New Jersey", "Apple Books Publishing Ltd", "");
		testGenAPAHelper("", "", "", "", "", "");
		testGenAPAHelper("Dave Wiebe; Jordan McMillan; Chen, Lisa A.", "1996", "Title of the book here.", "New Jersey", "Apple Books Publishing Ltd", "ThIRD edition");
		
		}
	
	private static void testGenAPAHelper(String author, String year, String title, String place, String publisher, String edition){
		System.out.println(author +" - "+ year +" - "+ title +" - "+ place +" - "+ publisher +" - "+ edition);
		System.out.println(genAPA(author, year, title, place, publisher, edition));
		System.out.println();		
	}
	
	
	private static void testCiteAuthor(){
		testCiteAuthorHelper("Fanna  Williamson   Jr.");
		testCiteAuthorHelper("Williamson, Fanna  jr  ");
		testCiteAuthorHelper("Fanna JR. Williamson   ");
		testCiteAuthorHelper("Williamson F  Jr.      ");
		testCiteAuthorHelper("Williamson, F  Jr.     ");
		testCiteAuthorHelper("Williamson, jr F       ");
		
		testCiteAuthorHelper("");
		testCiteAuthorHelper("Fds sfds fds fsdf dsf df");
		testCiteAuthorHelper("David Andrew Wiebe");
		testCiteAuthorHelper("04593 9305 39053943");
		
		testCiteAuthorHelper("Fanna A. Williamson   Jr. ");
		testCiteAuthorHelper("Williamson, Fanna A jr    ");
		testCiteAuthorHelper("Fanna A JR. Williamson    ");
		testCiteAuthorHelper("F A Williamson Jr.        ");
		testCiteAuthorHelper("Williamson, F A.  Jr.     ");
		testCiteAuthorHelper("Williamson, A, jr F       ");

		testCiteAuthorHelper("Fanna A. Williamson   Jr. ; David A Wiebe");
		testCiteAuthorHelper("Williamson, Fanna A jr; Dave Wiebe, A.    ");
		testCiteAuthorHelper("Fanna A JR. Williamson ; D Wiebe ; Mcmillan, Jordan");
		testCiteAuthorHelper("F A Williamson Jr.        ");
		testCiteAuthorHelper("Williamson, F A.  Jr.     ");
		testCiteAuthorHelper(" D Wiebe    ");
		testCiteAuthorHelper(" Dave Wiebe    ");
		testCiteAuthorHelper(" Dave Wiebe, A.   ");
		testCiteAuthorHelper(" Wiebe D A   ");
		testCiteAuthorHelper(" Wiebe D   ");
	}
	
	private static String citeYear(String year){
		year = year.trim();
		if(year.endsWith(",") || year.endsWith(".")){
			year = year.substring(0, year.length()-1);
		}
		return year;
	}
	
	private static String citeTitle(String title){		
		title = title.trim();
		if(title.endsWith(",") || title.endsWith(".")){
			title = title.substring(0, title.length()-1);
		}
		return title;
	}
	
	private static String citePlace(String place){
		place = place.trim();
		if(place.endsWith(",") || place.endsWith(".")){
			place = place.substring(0, place.length()-1);
		}
		return place;
	}
	
	private static String citePublisher(String publisher){
		publisher = publisher.trim();
		if(publisher.endsWith(",") || publisher.endsWith(".")){
			publisher = publisher.substring(0, publisher.length()-1);
		}
		return publisher;
	}

	private static String citeEdition(String edition){
		edition = edition.trim();
		if(edition.endsWith(",") || edition.endsWith(".")){
			edition = edition.substring(0, edition.length()-1);
		}
		if(edition.equalsIgnoreCase(""))
		{
			return "";
		}
		else if(edition.startsWith("1st") || edition.startsWith("1ST") || edition.equalsIgnoreCase("1") || edition.equalsIgnoreCase("first")){
			return "1st";
		}
		else if(edition.startsWith("2nd") || edition.startsWith("2ND") || edition.equalsIgnoreCase("2") || edition.equalsIgnoreCase("second")){
			return "2nd";
		}
		else if(edition.startsWith("3rd") || edition.startsWith("3RD") || edition.equalsIgnoreCase("3") || edition.equalsIgnoreCase("third")){
			return "3rd";
		}
		else{
			String[] editionSplit = edition.split(" ");
			
			if(editionSplit[0].equalsIgnoreCase("first")){
				return "1st";
			}
			else if(editionSplit[0].equalsIgnoreCase("second")){
				return "2nd";
			}
			else if(editionSplit[0].equalsIgnoreCase("third")){
				return "3rd";
			}
			else if(editionSplit[0].equalsIgnoreCase("fourth")){
				return "4th";
			}
			else if(editionSplit[0].equalsIgnoreCase("fifth")){
				return "5th";
			}
			else if(editionSplit[0].equalsIgnoreCase("sixth")){
				return "6th";
			}
			else if(editionSplit[0].equalsIgnoreCase("seventh")){
				return "7th";
			}
			else if(editionSplit[0].equalsIgnoreCase("eighth")){
				return "8th";
			}
			else if(editionSplit[0].equalsIgnoreCase("ninth")){
				return "9th";
			}
			else if(editionSplit[0].equalsIgnoreCase("tenth")){
				return "10th";
			}
			else if(editionSplit[0].equalsIgnoreCase("eleventh")){
				return "11th";
			}
			else if(editionSplit[0].equalsIgnoreCase("twelveth")){
				return "12th";
			}
			else if(editionSplit[0].equalsIgnoreCase("thirteenth")){
				return "13th";
			}
			else if(editionSplit[0].equalsIgnoreCase("fourteenth")){
				return "14th";
			}
			else if(editionSplit[0].endsWith("st") || editionSplit[0].endsWith("ST") || editionSplit[0].endsWith("St")){
				return editionSplit[0].substring(0, editionSplit[0].length()-2) + "st";
			}
			else if(editionSplit[0].endsWith("ND") || editionSplit[0].endsWith("nd")|| editionSplit[0].endsWith("nD")){
				return editionSplit[0].substring(0, editionSplit[0].length()-2) + "nd";
			}
			else if(editionSplit[0].endsWith("rd") || editionSplit[0].endsWith("RD")|| editionSplit[0].endsWith("Rd")){
				return editionSplit[0].substring(0, editionSplit[0].length()-2) + "rd";
			}
			else if(editionSplit[0].endsWith("th") || editionSplit[0].endsWith("TH") || editionSplit[0].endsWith("Th")){
				return editionSplit[0].substring(0, editionSplit[0].length()-2) + "th";
			}
			else if(editionSplit[0].endsWith("1")){
				return editionSplit[0] + "st";
			}
			else if(editionSplit[0].endsWith("2")){
				return editionSplit[0] + "nd";
			}
			else if(editionSplit[0].endsWith("3")){
				return editionSplit[0] + "rd";
			}
			else if(editionSplit[0].endsWith("4") || editionSplit[0].endsWith("5") ||
					editionSplit[0].endsWith("6") || editionSplit[0].endsWith("7") || 
					editionSplit[0].endsWith("8") || editionSplit[0].endsWith("9") || 
					editionSplit[0].endsWith("0")){
				return editionSplit[0] + "th";
			}			
			else{
				return edition;
			}
		}
	}
	
}
