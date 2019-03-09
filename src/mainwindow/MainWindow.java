package mainwindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class MainWindow {
	public JFrame frame;

	private String[] fileMenuItemNames = { "New...", "Open...", "Quit" };
	private String[] editMenuItemNames = { "Copy", "Paste" };

	public MainWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();

		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JMenuBar mainMenuBar = createMenuBar();

		JMenu fileMenu = createMenu("File");
		
		JMenuItem openItem = createMenuItem("Open");
		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actEvent) {
				JFileChooser fileChooser = new JFileChooser("/");
				fileChooser.showOpenDialog(null);
			}
		});
		
		JMenuItem quitItem = createMenuItem("Quit");
		quitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actEvent) {
				System.exit(0);
			}
		});

		fileMenu.add(openItem);
		fileMenu.add(quitItem);

		JMenu editMenu = createMenu("Edit");
		for (int nameId = 0; nameId < editMenuItemNames.length; nameId++) {
			editMenu.add(createMenuItem(editMenuItemNames[nameId]));
		}

		mainMenuBar.add(fileMenu);
		mainMenuBar.add(editMenu);

		frame.setJMenuBar(mainMenuBar);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		return menuBar;
	}

	private JMenu createMenu(String menuName) {
		JMenu menu = new JMenu(menuName);
		return menu;
	}

	private JMenuItem createMenuItem(String itemName) {
		JMenuItem menuItem = new JMenuItem(itemName);
		return menuItem;
	}
}
