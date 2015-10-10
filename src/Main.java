import java.util.Scanner;

public class Main {
	//updates originator with new values while storing memento in the stack.
	public static void update(Originator org, Memento[] stack, String data, int xloc, int yloc){
		for(int i=stack.length-2; i>=0; i--){
			stack[i+1] = stack[i];	//move values down stack
		}
		stack[0] = org.create_mem();//put new memento in stack
		org.update(data, xloc, yloc);
	}
	
	//restores orginator from a selected memento in stack
	public static void undo(Originator org, Memento[] stack, int stepsback){
		org.restore_memento(stack[stepsback-1]);//restore originator to memento from stack
		for(int i=0; i<stack.length-stepsback; i++ ){
			stack[i] = stack[i+stepsback]; //update stack
		}
	}
	
	public static void main(String[] args) {
		
		Memento[] memstack = new Memento[5];
		Originator org = new Originator();
		boolean loop = true;
		
		Scanner input = new Scanner(System.in);
		while(loop){
			System.out.println("Please enter a string and 2 numbers(space seperated) or "
					+ "undo followed by the number of actions to undo or exit");
			String s = input.next();
			if(s.equals("undo")){
				int stepsback = input.nextInt();
				undo(org, memstack, stepsback);
			}
			else if(s.equals("exit")){
				loop = false;
			}
			else{
				int xloc = input.nextInt();
				int yloc = input.nextInt();
				update(org, memstack, s, xloc, yloc);
			}
			org.print_data();
		}
		
	}

}
