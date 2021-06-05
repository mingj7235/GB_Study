package inheritencePractice;

public class Driver {
	public static void main(String[] args) {
		
		Penguin pororo = new Penguin();
		
		pororo.name = "뽀로로";
		pororo.habitat = "남극";
		
		pororo.showName();
		pororo.showHabitat();
		
		Animal pingu = new Penguin();
		
		pingu.name = "핑구";
		//pingu.habitat 선언 불가. 
		
		pingu.showName();
		//pingu.showHabitat 선언불가
		
		//Penguin happy = new Animal (); 불가 
		
	}
}
