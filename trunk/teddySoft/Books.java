	/*
	 * 	Books.java
	 * 	
	 * 	Written by Jordan McMillan
	 * 	Edited by David Wiebe
	 * 
	 * 	Team TeddySoft is:
	 * 	David Wiebe
	 *  Frankie Yan
	 * 	Jordan McMillan
	 * 	Lisa Chen
	 */

package teddySoft;
import java.io.Serializable;

public class Books implements Comparable, Serializable{
	private
		String title, author, edition, pubDate, pubLocation, isbn, genre, description, review;
		int rating;
		
	public Books (String title, String author, String edition, 
			String pubDate, String pubLocation, String isbn, String genre, 
			int rating, String description, String review){
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.pubDate = pubDate;
		this.pubLocation = pubLocation;
		this.isbn = isbn;
		this.genre = genre;
		this.rating = rating;
		this.description = description;
		this.review = review;
		if (rating > 5){ this.rating = 5;}
		if (rating < 1){ this.rating = 1;}
	}
	
	public Books (String title){
		this.title = title;
	}
	
	//Getters
	public String getTitle(){
		return title;}
	
	public String getAuthor(){
		return author;}
	
	public String getEdition(){
		return edition;}
	
	public String getPubDate(){
		return pubDate;}
	
	public String getPubLocation(){
		return pubLocation;}
	
	public String getIsbn(){
		return isbn;}
	
	public int getRating(){
		return rating;
	}
	public String getType(){
		return "Book";
	}
	
	public String getGenre(){
		return genre;}
	
	public String getReview(){
		return review;}
	
	public String getDescription(){
		return description;}
	
	//Setters
	public void setTitle(String title){
		this.title = title;}
	
	public void setEditon(String edition){
		this.edition = edition;}
	
	public void setPubDate(String pubDate){
		this.pubDate = pubDate;}
	
	public void setPubLocation(String pubLocation){
		this.pubLocation = pubLocation;}
	
	public void setIsbn(String isbn){
		this.isbn = isbn;}
	
	//Comparable interface
	public int compareTo(Object b) throws ClassCastException{
		if (!(b instanceof Books))
			throw new ClassCastException("A Books object expected.");
		
		int x;
		Books bookToTest = ((Books) b);
		if ((this.getTitle()).equals(bookToTest.getTitle())){
			x = 0;}
		else if (this.getTitle().compareTo(bookToTest.getTitle()) > 0){
			x = 1;}
		else{
			x=-1;}
		return x;
	}
}
