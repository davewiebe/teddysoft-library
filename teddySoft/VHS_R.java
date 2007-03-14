	/*
	 * 	VHS_R.java
	 * 	
	 * 	Written by Jordan McMillan
	 * 	
	 * 
	 * 	Team TeddySoft is:
	 * 	David Wiebe
	 *  Frankie Yan
	 * 	Jordan McMillan
	 * 	Lisa Chen
	 */

package teddySoft;
public class VHS_R extends VHS {

	private String timeStamp;
	private int index;
	
	public VHS_R (String title, String director, String year, String contentRated, String review, String description, String runningTime, String timeStamp, int index,  int rating){
		super(title, director, year, contentRated, runningTime, review, description, rating);
		this.timeStamp = timeStamp;
		this.index = index;
		//implement search key
	}
	
	//Getters
	public String getTimeStamp(){
		return timeStamp;}
	
	public int getIndex(){
		return index;}
	
	//Setters
	public void setTimeStamp(String timeStamp){
		this.timeStamp = timeStamp;}
	
	public void setIndex(int index){
		this.index = index;} 
	
	//Comparable interface
	public int compareTo(Object vr) throws ClassCastException{
		if (!(vr instanceof Books))
			throw new ClassCastException("A VHS_R object expected.");
		
		int x;
		VHS_R vhsrToTest = ((VHS_R) vr);
		if ((this.getTitle()).equals(vhsrToTest.getTitle())){
			x = 0;}
		else if (this.getTitle().compareTo(vhsrToTest.getTitle()) > 0){
			x = 1;}
		else{
			x=-1;}
		return x;
	}
}