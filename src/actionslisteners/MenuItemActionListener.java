package actionslisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemActionListener {
	
	public static class QuitItemActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
	public static class FileItemActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
}
