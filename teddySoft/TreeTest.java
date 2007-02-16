package teddySoft;

public class TreeTest {

	public static void main(String[] args) {
		
		RBTree tree = new RBTree();
		
			String[] st = {"Fred", "Wilma", "Pebbles", "4", "5", "7", "8", "9"};
			for(int t=0;t<st.length;t++){
				tree.RBTreeInsert(new Books(st[t] , "Tolken", "1st", "Today", "middle earth", "12345", "SciFi", 5, "", ""));
			}
			
			tree.printTree();
			
			Books temp = new Books("Fred");
			temp = (Books)tree.getObj(temp);
			System.out.println("Found " + temp.getTitle() + " " + temp.getAuthor());
	}

}
