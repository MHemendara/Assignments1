package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.BookCart;
import main.PotterBook;

public class BookCartTest {

	private BookCart bookCart;
	@Before
	public void setUp() throws Exception {
		this.bookCart = new BookCart();
	}

	@Test
	public void emptyCartZero() {
		assertTotalCostToBe(0.0);
	}

	
	@Test
	public void oneDistinctBook() {
		bookCart.addBook(PotterBook.BOOK1);
		assertTotalCostToBe(8.0);
	}
	
	@Test
	public void twoDistinctBook() {
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK3);
		assertTotalCostToBe(8.0*2*.95);
	}

	@Test
	public void threeDistinctBook() {
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK2);
		assertTotalCostToBe(8.0*3*.90);
	}

	@Test
	public void fourDistinctBook() {
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK2);
		assertTotalCostToBe(8.0*4*.80);
	}
	
	@Test
	public void fiveDistinctBook() {
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK2);
		bookCart.addBook(PotterBook.BOOK4);
		assertTotalCostToBe(8.0*5*.75);
	}
	
	@Test
	public void twoBookDuplicates() {
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK3);
		assertTotalCostToBe(8.0*2);
	}
	
	@Test
	public void threeBooks1Dup() {
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK5);
		assertTotalCostToBe(8.0*2*.95 + 8.0);
	}
	
	@Test
	public void fourbooks1dup() {
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK2);
		assertTotalCostToBe(8.0*3*.90+8.0);
	}

	@Test
	public void fourbooks2dup() {
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK1);
		assertTotalCostToBe(8.0*2*.95*2);
	}

	@Test
	public void fourbooks3dup() {
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK5);
		assertTotalCostToBe(8.0*2*.95+8.0*2);
	}

	@Test
	public void fourbooks4dup() {
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK5);
		assertTotalCostToBe(8.0*4);
	}
	
	@Test
	public void fivebooks1dup() {
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK2);
		bookCart.addBook(PotterBook.BOOK3);
		assertTotalCostToBe(8*4*.80+8);
	}
	
	@Test
	public void fivebooks2dup() {
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK3);
		assertTotalCostToBe(8*3*.90+8*2*.95);
	}
	
	@Test
	public void fivebooks3dup() {
		bookCart.addBook(PotterBook.BOOK5);
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK3);
		assertTotalCostToBe(8*3*.90+8*2);
	}

	@Test
	public void fivebooks4dup() {
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK3);
		assertTotalCostToBe(8*2*.95+8*3);
	}
	
	@Test
	public void randomBooks() {
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK2);
		bookCart.addBook(PotterBook.BOOK2);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK4);
		bookCart.addBook(PotterBook.BOOK5);
		//assertTotalCostToBe(8*5*.75+8*3*.90);
		assertTotalCostToBe(51.2);
	}
	
	@Test
	public void randomBooks1() {
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK4);
		bookCart.addBook(PotterBook.BOOK4);
		bookCart.addBook(PotterBook.BOOK5);
		assertTotalCostToBe(40.80);
	}
	
	@Test
	public void randomBooks2() {
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK2);
		bookCart.addBook(PotterBook.BOOK2);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK4);
		bookCart.addBook(PotterBook.BOOK4);
		bookCart.addBook(PotterBook.BOOK5);
		assertTotalCostToBe(30+25.6+15.2+8);
	}
	
	@Test
	public void randomBooks3() {
		bookCart.addBook(PotterBook.BOOK4);
		bookCart.addBook(PotterBook.BOOK4);
		bookCart.addBook(PotterBook.BOOK1);
		bookCart.addBook(PotterBook.BOOK2);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK3);
		bookCart.addBook(PotterBook.BOOK4);
		bookCart.addBook(PotterBook.BOOK4);
		bookCart.addBook(PotterBook.BOOK5);
		assertTotalCostToBe(30+15.2*2+8);
	}

	private void assertTotalCostToBe(double expected) {
		double cartCost = bookCart.getMinumuCost();
		Assert.assertEquals(expected, cartCost, 0.01);
	}
}
