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
	
	public boolean getIsWideScreen(){
		return isWideScreen;}
	
	public String getFormat(){
		return format;}
	
	public void setIsWideScreen(boolean isWideScreen){
		this.isWideScreen = isWideScreen;}
	
	public void setFormat(String format){
		this.format = format;}
	
	
	
}
