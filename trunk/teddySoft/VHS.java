package teddySoft;
import java.io.Serializable;

public class VHS implements Serializable {

		private String title, director, year, contentRated, runningTime;
		private int rating;
		//implement search key
	
		public VHS (String title, String director, String year, String contentRated, String runningTime, int rating){
			this.title = title;
			this.director = director;
			this.year = year;
			this.contentRated = contentRated;
			this.runningTime = runningTime;
			this.rating = rating;
			//implement search key
			
		}
		//Getters
		public String getTitle(){
			return title;}
		
		public String getdirector(){
			return director;}
		
		public String getyear(){
			return year;}
		
		public String getContentRated(){
			return contentRated;}
		
		public String getRunningTime(){
			return runningTime;}
		
		public int getRating(){
			return rating;}
		
		//Setters for editing feature
		public void setTitle(String title){
			this.title = title;}
		
		public void setDirector(String director){
			this.director = director;}
		
		public void setYear(String title){
			this.title = title;}
		
		public void setContedRated(String contentRated){
			this.contentRated = contentRated;}
		
		public void setRunningTime(String runningTime){
			this.runningTime = runningTime;}
		
		public void setRating(int rating){
			this.rating = rating;}
		
}
