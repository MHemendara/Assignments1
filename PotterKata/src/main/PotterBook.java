/**
 * 
 */
package main;

/**
 * @author hems
 *
 */
public enum PotterBook {
	BOOK1(0), BOOK2(1), BOOK3(2), BOOK4(3), BOOK5(4);
	
	private int idx;
	PotterBook(int id){
		this.idx = id;
	}
	
	public int getIndex(){
		return idx;
	}
}
