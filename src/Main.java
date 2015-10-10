import java.util.Scanner;

public class Main {

	public static void update(Originator org, Memento[] stack, int size, String data, int xloc, int yloc){
		for(int i=size-2; i>=0; i--){
			stack[i+1] = stack[i];
		}
		stack[0] = org.create_mem();
		org.update(data, xloc, yloc);
	}
	public static void undo(Originator org, Memento[] stack, int stepsback){
		org.restore_memento(stack[stepsback-1]);
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
				update(org, memstack, 5, s, xloc, yloc);
			}
			org.print_data();
		}
		
	}

}
