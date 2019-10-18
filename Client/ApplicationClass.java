import javax.swing.JFrame;

public class ApplicationClass {
	public static void main(String[] args) {
		GameKeyListener listener = new GameKeyListener();
		JFrame frame = new JFrame("Frame");
		frame.addKeyListener(listener);
		frame.setVisible(true);
    }
}
