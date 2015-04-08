public class BitMasking {
	

	/*public static void main(String[] args) {
		boolean[] mystack = {false,false,true,false,false,false,true,false};
		boolean[] stack2 = {true,true,false,false,false,false,false,false};
		
		int x = encodeStack(mystack);
		int g = encodeStack(stack2);
		
		boolean[] newStack = decodeStack(x);
		
		for (boolean i : newStack){
			System.out.print(i + " ");
		}
		System.out.println(g);
	}*/
	
	static int encodeStack(boolean[] stackValues){
		
		int thisStack = 0;
		
		for(int i = 0; i < 6; i++){
			thisStack = thisStack | (stackValues[i]?(int)Math.pow(2, i):0);
		}
		
		return thisStack;
	}
	
	static boolean[] decodeStack(long stackValues){
		boolean[] thisStack = new boolean[42];
		
		for (int i = 0; i < 42; i++){
			thisStack[i] = (stackValues & ((long)Math.pow(2, i))) > 0;
		}
		return thisStack;
	}

}