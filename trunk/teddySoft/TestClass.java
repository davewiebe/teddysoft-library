package teddySoft;
import java.io.*;

public class TestClass {
	public static void main(String[] args) throws Exception{
		String Username = "Jordan Mcmillan";
		FileOutputStream file = new FileOutputStream(Username+"-"+"DataBase.ser");
		ObjectOutputStream outStream = new ObjectOutputStream (file);
		
		DatabaseTest db = new DatabaseTest();
			
		Books vs = new Books("Vanilla Sky", "Don't know", "2", "2001", "hollywood", "5575");
		Books lotr = new Books("LOTR", "JRR", "1", "1990", "hollywood", "12345");
		db.insert(vs);
		db.insert(lotr);
		
		outStream.writeObject(db);
		
		
		FileInputStream filein = new FileInputStream (Username+"-"+"DataBase.ser");
		ObjectInputStream inStream = new ObjectInputStream (filein);
		
		DatabaseTest db2 = (DatabaseTest) inStream.readObject();
		
		db2.print();
		
		
	}

}
