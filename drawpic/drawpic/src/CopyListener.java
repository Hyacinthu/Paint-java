import java.awt.event.*;

public class CopyListener implements ActionListener{
	MyFrame frame;
	CanPaintLabel a;
	AllMenu b;
	public CopyListener(MyFrame frame,CanPaintLabel a,AllMenu b) {
		this.frame = frame;
		this.a = a;
		this.b = b;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		frame.cutboard = a.teImage;
		b.allMenuItem[9].setEnabled(true);
	}
}
