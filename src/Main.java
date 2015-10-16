import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main {
	
	public static void initializeJFrame(Originator org, JFrame mainframe, UndoStack stack){
		String values = "null";
		
		mainframe.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		
		JLabel dataLabel = new JLabel(values);
		dataLabel.setPreferredSize(new Dimension(200, 20));
		mainframe.getContentPane().add(dataLabel);
		JTextField field1 = new JTextField("Word Int Int (Space seperated)");
		field1.setPreferredSize(new Dimension(200, 20));
		field1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				field1.setText("");
			}
		});
		mainframe.getContentPane().add(field1);
		JButton okButton = new JButton("Enter Data");
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Scanner s = new Scanner(field1.getText());
				stack.update(org, s.next(), s.nextInt(), s.nextInt());
				dataLabel.setText(stack.currentValue().data + ", " + stack.currentValue().xloc + ", " + stack.currentValue().yloc);
			}
		});
		mainframe.getContentPane().add(okButton);
		
		JButton undoButton = new JButton("Undo");
		undoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				stack.undo(org, 1);
				dataLabel.setText(stack.currentValue().data + ", " + stack.currentValue().xloc + ", " + stack.currentValue().yloc);
			}
		});
		mainframe.getContentPane().add(undoButton);
		
		mainframe.pack();
		mainframe.setVisible(true);
	}
	
	

	
	public static void main(String[] args) {
		
		final JFrame mainframe= new JFrame("Memento");
		Originator org = new Originator();
		UndoStack stack = new UndoStack();
		initializeJFrame(org, mainframe, stack);
		
		
	}

}
