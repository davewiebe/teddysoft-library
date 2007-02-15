package teddySoft;
import java.io.Serializable;

public class MediaDatabase implements Serializable {
	
	private RBTree Books;
	private RBTree VHS;
	private RBTree VHS_R;
	private RBTree DVD;
	private RBTree VideoGame;
	
	public MediaDatabase(){
		Books = new RBTree();
		VHS = new RBTree();
		VHS_R = new RBTree();
		DVD = new RBTree();
		VideoGame = new RBTree();
	}
	
	public void addBooks(Books b){
		Books.RBTreeInsert(b);}
	
	public void addVHS(VHS v){
		VHS.RBTreeInsert(v);}
	
	public void addVHS_R(VHS_R vhsr){
		VHS_R.RBTreeInsert(vhsr);}
	
	public void addDVD(DVD dvd){
		DVD.RBTreeInsert(dvd);}
	
	public void addVideoGame(VideoGame vg){
		VideoGame.RBTreeInsert(vg);}
	
	
	

}
