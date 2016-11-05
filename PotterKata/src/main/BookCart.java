/**
 * 
 */
package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hems
 *
 */
public class BookCart {

	private int[] books;
	private Map<Integer, Double> discounts;
	public static final double BOOK_PRICE = 8.00;
	public final int totalParts = PotterBook.values().length;
	private int totalBookCount = 0;

	public BookCart() {
		super();
		init();
	}

	public void addBook(PotterBook book) {
		books[book.getIndex()]++;
		this.totalBookCount++;
	}

	public double getMinumuCost(){
		double minCost = Double.MAX_VALUE;
		for(int splitFactor=2; splitFactor<=this.totalParts; splitFactor++){
			int[] countOfBooks = Arrays.copyOf(books, this.totalParts);
			double cost = this.getTotalCost(countOfBooks, splitFactor);
			if(cost<minCost){
				minCost = cost;
			}
		}
		return minCost;
	}

	private double getTotalCost(int[] countOfBooks, int splitFactor) {
		double totalCost = 0;
		int bcount = new Integer(this.totalBookCount);
		while(bcount>0){
			int count = 0;
			for(int i=0;i<this.totalParts && count<splitFactor;i++){
				if(countOfBooks[i]>0){
					countOfBooks[i] = countOfBooks[i]-1;
					count++;bcount--;
				}
			}
			if(count>0){
				totalCost += count*BOOK_PRICE*discounts.get(count);
			}
		}
		return totalCost;
	}

	private void init() {
		// Initialize discounts lookup
		this.discounts = new HashMap<Integer, Double>();
		this.discounts.put(5, 0.75);
		this.discounts.put(4, 0.80);
		this.discounts.put(3, 0.90);
		this.discounts.put(2, 0.95);
		this.discounts.put(1, 1.00);

		// initialize the data structure
		this.books = new int[this.totalParts];
	}
}
