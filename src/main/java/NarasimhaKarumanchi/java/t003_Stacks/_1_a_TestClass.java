package main.java.NarasimhaKarumanchi.java.t003_Stacks;

public class _1_a_TestClass<T>  {
	
	public boolean checkPairwiseConsecutive(LinkedStack<Integer> iStk) {
		LinkedStack<Integer> aux = new LinkedStack<>();
		
		while(!iStk.isEmpty()) {
			aux.push(iStk.pop());
		}
		
		boolean result = true;
		
		while(aux.size() > 1) {
			int v1 = aux.pop();
			int v2 = aux.pop();
			
			if(Math.abs(v2-v1) != 1) {
				return false;
			}
			
			iStk.push(v1);
			iStk.push(v2);
			
			if(aux.size() == 1) {
				iStk.push(aux.pop());
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		_1_a_TestClass<String> mainClass = new _1_a_TestClass<>();
		
		LinkedStack<Integer> iStk = new LinkedStack<>();
		
		iStk.push(7);
		iStk.push(6);
		iStk.push(2);
		iStk.push(3);
		iStk.push(34);
		iStk.push(33);
		iStk.push(98);
		System.out.println("Input stack: " + iStk.toString());
		
		boolean isPairwiseConsecutive = mainClass.checkPairwiseConsecutive(iStk);
		
		System.out.println("Is stack pairwise consecutive?: " + isPairwiseConsecutive);
	}
}
