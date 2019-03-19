package mainwindow;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainWindow{
	public JFrame frame;

	private int amountOfStrings = 1;
	
	public MainWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();

		frame.setBounds(new Rectangle(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel editorPanel = new JPanel(new FlowLayout());
		
		JLabel lineNumbers = new JLabel();

		lineNumbers.setText(String.valueOf(amountOfStrings));
		
		int rows = 1;
		int columns = frame.getWidth() / 5;
		JTextArea mainTextArea = new JTextArea(rows, columns);
//		mainTextArea.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent keyEvent) {
//				if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
//					amountOfStrings++;
//					lineNumbers.setText(lineNumbers.getText() + "\n" + String.valueOf(amountOfStrings));
//				}
//			}
//		});
		
		editorPanel.add(lineNumbers);
		editorPanel.add(mainTextArea);
		
		mainPanel.add(editorPanel, BorderLayout.WEST);
		frame.add(mainPanel);

		createMainMenuBar();
	}

	public void createMainMenuBar() {
		JMenuBar mainMenuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");

		JMenuItem newFileItem = new JMenuItem("New...");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem quitItem = new JMenuItem("Quit");

		newFileItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actEvent) {
				JFileChooser fileChooser = new JFileChooser("/home" + getUserName());
				fileChooser.showSaveDialog(null);
			}
		});

		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actEvent) {
				JFileChooser fileChooser = new JFileChooser("/home" + getUserName());
				fileChooser.showOpenDialog(null);
			}
		});

		saveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actEvent) {
				JFileChooser fileChooser = new JFileChooser("/home" + getUserName());
				fileChooser.showSaveDialog(null);
			}
		});

		quitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actEvent) {
				System.exit(0);
			}
		});

		fileMenu.add(newFileItem);
		fileMenu.addSeparator();
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(quitItem);

		JMenu editMenu = new JMenu("Edit");

		mainMenuBar.add(fileMenu);
		mainMenuBar.add(editMenu);

		frame.setJMenuBar(mainMenuBar);
	}
	
	private String getUserName() {
		return System.getProperty("user.name");
	}
}
