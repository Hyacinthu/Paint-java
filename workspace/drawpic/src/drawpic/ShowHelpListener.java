package drawpic;

import java.awt.event.*;

import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午11:59:35
 *
 * @description 监听帮助按钮事件，调用frame
 *
 */

public class ShowHelpListener implements ActionListener {
	JFrame frame;
	
	public ShowHelpListener(JFrame a) {
		frame = a;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		HelpDialog a = new HelpDialog(frame);
		a.setVisible(true);
	}
}
