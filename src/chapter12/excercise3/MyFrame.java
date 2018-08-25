package chapter12.excercise3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MyFrame extends JFrame implements ActionListener {
	private final JTextField textfield = new JTextField("word", 10);
	private final JButton button = new JButton("Search");
	private final JTextArea textarea = new JTextArea(20, 30);
	
	private final ExecutorService service = Executors.newSingleThreadExecutor();

	public MyFrame() {
		super("Active Object Sample");
		this.getContentPane().setLayout(new BorderLayout());
		
		var north = new JPanel();
		north.add(new JLabel("Search:"));
		north.add(textfield);
		north.add(button);
		
		button.addActionListener(this);
		
		var center = new JScrollPane(textarea);
		this.getContentPane().add(north, BorderLayout.NORTH);
		this.getContentPane().add(center, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var word = textfield.getText();
		println(String.format("Searching %s ...", word));
		var future = service.submit(() -> {
			Thread.sleep(3 * 1000);
			return String.format("http://somewhere/%s.html", word);
		});
		service.submit(() -> {
			try {
				var url = future.get();
				SwingUtilities.invokeLater(() -> println(String.format("word = %s, URL = %s", word, url)));
			} catch (InterruptedException | ExecutionException e1) {
				throw new RuntimeException(e1);
			}
		});
	}
	
	private void println(String line) {
		textarea.append(line);
		textarea.append(System.lineSeparator());
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
