/*
	MediaDatabase.java
	Written by Jordan McMillan
	Edited a little by David Wiebe
	
	Software group: TeddySoft.
	
*/

package teddySoft;

import java.io.Serializable;

public class MediaDatabase implements Serializable {
	
	// redblack tree variables of all media types
	private RBTree BooksTree;
	private RBTree VHSTree;
	private RBTree VHS_RTree;
	private RBTree DVDTree;
	private RBTree VideoGameTree;
	
	// Constructor:
	public MediaDatabase(){
		BooksTree = new RBTree();
		VHSTree = new RBTree();
		VHS_RTree = new RBTree();
		DVDTree = new RBTree();
		VideoGameTree = new RBTree();
	}
	
	// Add media functions
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
	
	
	// Getters
	public Books getBook(String title){
		// convert title to object, then search and retrieve it
		Books b = (Books) BooksTree.getObj(title);
		return b;
	}
}
