package chapter10.excercise5;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener {
	private JButton executeButton = new JButton("Execute");
	private JButton cancelButton = new JButton("Cancel");

	public MyFrame() {
		super("MyFrame");
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(new JLabel("Two-Phase Termination Sample"));
		getContentPane().add(executeButton);
		getContentPane().add(cancelButton);
		
		executeButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == executeButton) {
			Service.service();
		}
		
		if (e.getSource() == cancelButton) {
			Service.cancel();
		}
	}
	
}
