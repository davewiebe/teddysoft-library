package teddySoft;

public class TreeTest {

	public static void main(String[] args) {
		
		RBTree tree = new RBTree();
		
			String[] st = {"1", "2", "3", "4", "5", "7", "8", "9"};
			for(int t=0;t<st.length;t++){
				tree.RBTreeInsert(new Books(st[t] , "Tolken", "1st", "Today", "middle earth", "12345", "SciFi", 5, "", ""));
			}
			
			tree.printTree();
			
			Books temp = new Books("1");
			temp = (Books)tree.getObj(temp);
			System.out.println("Found " + temp.getTitle() + " " + temp.getAuthor());
			
			Comparable List[] = new Comparable[tree.getSize()];
			List = tree.getTreeElements();
			for (int i=0;i<List.length;i++){
				Books temp2 = (Books)List[i];
				System.out.println(temp2.getTitle() + " " + temp2.getAuthor());
			}
			
	}
}
