package main.java.NarasimhaKarumanchi.java.t004_Queues;

public class c01_TestClass<T> {

	public void printAllPrimesFrom1To100() {
		
		int count = 0;
		int i = 100;
		while(i >= 2) {
			if(isPrime(i)) {
				count++;
				
				if(count == 5)
					break;
			}
			
			i--;
		}
		
		System.out.println("5th largest prime: " + i);

		
		
	}
	
	public boolean isPrime(int n) {
		
		if(n % 2 == 0) {
			return false;
		}
		
		for(int i = 3; i < Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		c01_TestClass<String> mainClass = new c01_TestClass<>();

		int n = 19;
		System.out.println("Is " + n + " prime? " + mainClass.isPrime(n));
		mainClass.printAllPrimesFrom1To100();
		
	}

}
