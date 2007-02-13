//package teddySoft;
import java.io.Serializable;

public class Books implements Serializable{
	private
		String title, author, edition, pubDate, pubLocation;
		int isbn;
		
	public Books (String title, String author, String edition, String pubDate, String pubLocation, int isbn){
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.pubDate = pubDate;
		this.pubLocation = pubLocation;
		this.isbn = isbn;
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
	
	public int getIsbn(){
		return isbn;}
	
	//Setters
	public void setTitle(String title){
		this.title = title;}
	
	public void setEditon(String edition){
		this.edition = edition;}
	
	public void setPubDate(String pubDate){
		this.pubDate = pubDate;}
	
	public void setPubLocation(String pubLocation){
		this.pubLocation = pubLocation;}
	
	public void setIsbn(int isbn){
		this.isbn = isbn;}
}
