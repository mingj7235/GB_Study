package day04_review;

public interface Cafe {
	String [] getMenu ();
	int [] getPrice();
	void sell (String menu) throws Exception;
}
