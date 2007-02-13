import java.io.Serializable;

public class VideoGame implements Serializable  {

	private String title, developer, year, contentRated, platform;
	private int rating, maxPlayers;
	//implement search key

	public VideoGame (String title, String developer, String year, String contentRated, String platform, int rating, int maxPlayers){
		this.title = title;
		this.developer = developer;
		this.year = year;
		this.contentRated = contentRated;
		this.platform = platform;
		this.rating = rating;
		this.maxPlayers = maxPlayers;
		//implement search key
		
	}
	//Getters
	public String getTitle(){
		return title;}
	
	public String getdeveloper(){
		return developer;}
	
	public String getyear(){
		return year;}
	
	public String getContentRated(){
		return contentRated;}
	
	public String getPlatform(){
		return platform;}
	
	public int getRating(){
		return rating;}
	
	public int getMaxPlayers(){
		return maxPlayers;}
	
	//Setters for editing feature
	public void setTitle(String title){
		this.title = title;}
	
	public void setDeveloper(String developer){
		this.developer = developer;}
	
	public void setYear(String title){
		this.title = title;}
	
	public void setContedRated(String contentRated){
		this.contentRated = contentRated;}
	
	public void setPlatform(String platform){
		this.platform = platform;}
	
	public void setRating(int rating){
		this.rating = rating;}
	
	public void setMaxPlayers(int maxPlayers){
		this.maxPlayers = maxPlayers;}
}
