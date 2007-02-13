package teddySoft;
public class VHS_R extends VHS {

	private String timeStamp;
	private int index;
	
	public VHS_R (String title, String director, String year, String contentRated, String runningTime, String timeStamp, int index,  int rating){
		super(title, director, year, contentRated, runningTime, rating);
		this.timeStamp = timeStamp;
		this.index = index;
		//implement search key
	}
	
	public String getTimeStamp(){
		return timeStamp;}
	
	public int getIndex(){
		return index;}
	
	public void setTimeStamp(String timeStamp){
		this.timeStamp = timeStamp;}
	
	public void setIndex(int index){
		this.index = index;} 
}
