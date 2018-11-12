package intro_to_array_lists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {
	JFrame frame = new JFrame("Guest Book");
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	JButton button = new JButton("Add Name");
	JButton button2 = new JButton("View Names");
	ArrayList<String> names = new ArrayList<String>();
	
	void GUI(){
		button.addActionListener(this);
		button2.addActionListener(this);
		frame.setVisible(true);
		panel.add(button);
		panel.add(button2);
		frame.add(panel);
	}
	public static void main(String[] args) {
		GuestBook book = new GuestBook();
		book.GUI();
		
		
	}
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(button == e.getSource()) {
			String name = JOptionPane.showInputDialog("Enter a name below:");
			names.add(name);
		}
		if(button2 == e.getSource()) {
			for (int i = 0; i < names.size(); i++) {
					String guests = names.get(i);
					System.out.println("Guest #" + (i + 1) + ": " + guests+"\n");
			}
					
				
			}
			
			
		}
	
}
