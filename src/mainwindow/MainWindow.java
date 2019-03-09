package mainwindow;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class MainWindow {
	public JFrame frame;

	public MainWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();

		frame.setBounds(new Rectangle(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

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
				JFileChooser fileChooser = new JFileChooser("/");
				fileChooser.showSaveDialog(null);
			}
		});

		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actEvent) {
				JFileChooser fileChooser = new JFileChooser("/");
				fileChooser.showOpenDialog(null);
			}
		});

		saveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actEvent) {
				JFileChooser fileChooser = new JFileChooser("/");
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
}
