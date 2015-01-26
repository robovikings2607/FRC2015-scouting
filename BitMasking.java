public class BitMasking {
	int stack = 0;

	public static void main(String[] args) {
		boolean[] mystack = {false,false,true,false,false,false,true,false};
		
		int x = encodeStack(mystack);
		
		boolean[] newStack = decodeStack(x);
		
		for (boolean i : newStack){
			System.out.print(i + " ");
		}
	}
	
	static int encodeStack(boolean[] stackValues){
		
		int thisStack = 0;
		
		for(int i = 0; i < 8; i++){
			thisStack = thisStack | (stackValues[i]?(int)Math.pow(2, i):0);
		}
		
		return thisStack;
	}
	
	static boolean[] decodeStack(int stackValues){
		boolean[] thisStack = new boolean[8];
		
		for (int i = 0; i < 8; i++){
			thisStack[i] = (stackValues & ((int)Math.pow(2, i))) > 0;
		}
		return thisStack;
	}

}
