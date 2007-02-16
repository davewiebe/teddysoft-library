package teddySoft;
import java.io.Serializable;

public class MediaDatabase implements Serializable {
	
	private RBTree BooksTree;
	private RBTree VHSTree;
	private RBTree VHS_RTree;
	private RBTree DVDTree;
	private RBTree VideoGameTree;
	
	public MediaDatabase(){
		BooksTree = new RBTree();
		VHSTree = new RBTree();
		VHS_RTree = new RBTree();
		DVDTree = new RBTree();
		VideoGameTree = new RBTree();
	}
	
	public void addBook(Books b){
		System.out.println(b.getTitle() + " added!");
		BooksTree.RBTreeInsert(b);}
	
	public void addVHS(VHS v){
		VHSTree.RBTreeInsert(v);}
	
	public void addVHS_R(VHS_R vhsr){
		VHS_RTree.RBTreeInsert(vhsr);}
	
	public void addDVD(DVD dvd){
		DVDTree.RBTreeInsert(dvd);}
	
	public void addVideoGame(VideoGame vg){
		VideoGameTree.RBTreeInsert(vg);}
	
	
	//getters
	public Books getBook(String title){
		Books b = (Books) BooksTree.getObj(title);
		return b;
	}
}
