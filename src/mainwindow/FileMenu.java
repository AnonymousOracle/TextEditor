package mainwindow;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

JMenuItem newFileItem = new JMenuItem("New...");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem quitItem = new JMenuItem("Quit");



public class FileMenu extends JMenu {
    private JMenu fileMenu;

    private String[] menuItemsNames = {
        "New...",
        "Open",
        "Save",
        "Quit"
    };

    public FileMenu() {
        for (int i = 0; i < menuItemNames.length(); i++) {
            fileMenu.add(new JMenuItem(menuItemsNames[i]));
        }
    }
}