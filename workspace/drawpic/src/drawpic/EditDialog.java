package drawpic;
import java.awt.*;
import javax.swing.*;
import java.math.*;

@SuppressWarnings("serial")
public class EditDialog extends JDialog{
	public EditDialog(JFrame frame,JButton f,JButton b,JLabel[] a) {
		super(frame,"�༭��ɫ",true);
		Container c = getContentPane();
		JPanel total = new JPanel(new BorderLayout());
		JPanel center = new JPanel(new GridLayout(1,2));
		JPanel left = new JPanel(new FlowLayout());
		left.setPreferredSize(new Dimension(241,240));
		JPanel right = new JPanel(new GridLayout(4,1));
		JPanel[] righter = new JPanel[4];
		for(int i=0;i<4;i++) {
			righter[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
		}
		/*JButton[][] colorbox = new JButton[241][240];
		for(int i=0;i<240;i++) {
			long maxsum = 255-Math.round(i*127/240.0);
			long minsum = Math.round(i*127/240.0);
			for(int j=0;j<40;j++) {
				colorbox[i][j] = new JButton();
				colorbox[i][j].setBackground(new Color(maxsum,
						minsum+Math.round(j*(maxsum-minsum)/40.0),minsum));
				colorbox[i][40+j] = new JButton();
				colorbox[i][40+j].setBackground(new Color(maxsum-Math.round(j*(maxsum-minsum)/40.0),
						maxsum,minsum));
				colorbox[i][80+j] = new JButton();
				colorbox[i][80+j].setBackground(new Color(minsum,
						maxsum,minsum+Math.round(j*(maxsum-minsum)/40.0)));
				colorbox[i][120+j] = new JButton();
				colorbox[i][120+j].setBackground(new Color(minsum,
						maxsum-Math.round(j*(maxsum-minsum)/40.0),maxsum));
				colorbox[i][160+j] = new JButton();
				colorbox[i][160+j].setBackground(new Color(minsum+Math.round(j*(maxsum-minsum)/40.0),
						minsum,maxsum));
				colorbox[i][200+j] = new JButton();
				colorbox[i][200+j].setBackground(new Color(maxsum,
						minsum,maxsum-Math.round(j*(maxsum-minsum)/40.0)));
			}
		}
		for(int i=0;i<240;i++) {
			colorbox[240][i] = new JButton();
			colorbox[240][i].setBackground(new Color(127,127,127));
		}
		for(int i=0;i<241;i++) {
			for(int j=0;j<240;j++) {
				left.add(colorbox[i][j]);
			}
		}
		JLabel x = new JLabel();
		x.*/
	}
	
}