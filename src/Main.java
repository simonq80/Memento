import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main {
	
	//display class
	public static void initializeJFrame(Originator org, JFrame mainframe, UndoStack stack){
		String values = "null";
		
		mainframe.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		
		JLabel dataLabel = new JLabel(values);
		dataLabel.setPreferredSize(new Dimension(200, 20));
		mainframe.getContentPane().add(dataLabel);
		JTextField field1 = new JTextField("Word Int Int (Space seperated)");
		field1.setPreferredSize(new Dimension(200, 20));
		field1.addMouseListener(new MouseAdapter(){//clear textfield on click
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
				stack.update(org, s.next(), s.nextInt(), s.nextInt());//update originator and put memento onto stack
				dataLabel.setText(org.print_data());
			}
		});
		mainframe.getContentPane().add(okButton);
		
		JButton undoButton = new JButton("Undo");
		undoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				stack.undo(org, 1);
				dataLabel.setText(org.print_data());
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
