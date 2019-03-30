package mainwindow;

import mainwindow.MainWindow;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class EditorTextArea extends JTextArea {
	private int columns;
	
	private String currentLine;
	
	private String[] textAreaContainment;
	
	private JTextArea textArea = new JTextArea();
	
	public EditorTextArea(int strings) {
		columns = MainWindow.frame.getWidth() / 5;
	}
	
	public void bufferTextToArray() {
		textAreaContainment[getCaretPosition() - 1] = currentLine;
	}
	
	public void addNewLine() {
		textAreaContainment[textAreaContainment.length] = "";
	}
	
	public void wordWrap() {
//		String cutPart = currentLine.substring(MainWindow.frame.getWidth() / 5);
//		textArea.append("\n" + cutPart);
		textArea.insert("\n", getCaretPosition());
	}
	
	public boolean isLineOverlength() {
		if (getLineLength() >= columns) return true;
		else return false;
	}
	
	public int getLineLength() {
		return currentLine.length();
	}
}
