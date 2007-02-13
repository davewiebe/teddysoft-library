import java.io.*;

public class TestClass {
	public static void main(String[] args) throws IOException{
		String Username = "Jordan Mcmillan";
		FileOutputStream file = new FileOutputStream(Username+"-"+"VHS.ser");
		ObjectOutputStream outStream = new ObjectOutputStream (file);
		
		VHS sky = new VHS("Vanilla Sky", "Don't know", "2001", "R", "2 hours", 5);
		
		outStream.writeObject(sky);
	}

}
