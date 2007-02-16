/*
	DVD.java
	Written by Jordan McMillan
	Edited slightly by David Wiebe
	
	Software group: TeddySoft.
	
*/

package teddySoft;

public class DVD extends VHS {
	
	private boolean isWideScreen;
	private String format;

	public DVD (String title, String director, String year, String contentRated, String runningTime, String format, boolean isWideScreen,  int rating){
		super(title, director, year, contentRated, runningTime, rating);
		this.isWideScreen = isWideScreen;
		this.format = format;
		//implement search key
	}
	
	// Constructor for only title, to create DVD object for use with Comparable class;
	public DVD (String title){
		super(title, "", "", "", "", 1);
	}
	
	//Getters
	public boolean getIsWideScreen(){
		return isWideScreen;}
	
	public String getFormat(){
		return format;}
	
	//Setters
	public void setIsWideScreen(boolean isWideScreen){
		this.isWideScreen = isWideScreen;}
	
	public void setFormat(String format){
		this.format = format;}
	
	//Comparable interface
	public int compareTo(Object dvd) throws ClassCastException{
		if (!(dvd instanceof DVD))
			throw new ClassCastException("A DVD object expected.");
		
		int x;
		DVD dvdToTest = ((DVD) dvd);
		if ((this.getTitle()).equals(dvdToTest.getTitle())){
			x = 0;}
		else if (this.getTitle().compareTo(dvdToTest.getTitle()) > 0){
			x = 1;}
		else{
			x=-1;}
		return x;
	}
	
}
