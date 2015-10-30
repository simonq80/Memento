
public class UndoStack {
	private Memento[] undoStack = new Memento[20];
	
	public UndoStack(){}
	
	//updates originator with new values while storing memento in the stack.
	public void update(Originator org, String data, int xloc, int yloc){
			for(int i=undoStack.length-2; i>=0; i--){
				undoStack[i+1] = undoStack[i];	//move values down stack
			}
			org.update(data, xloc, yloc);
			undoStack[0] = org.create_mem();//put new memento in stack
			
		}
	
	//restores orginator from a selected memento in stack and updates stack
	public void undo(Originator org, int stepsback){
		
			org.restore_memento(undoStack[stepsback-1]);//restore originator to memento from stack
			for(int i=0; i<undoStack.length-stepsback; i++ ){
				undoStack[i] = undoStack[i+stepsback]; //update stack
			}
		
	}
	//return top memento without altering stack
	public Memento currentValue(){
		return undoStack[0];
	}
}
