package drawpic;
//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午3:14:46
 *
 * @description 铅笔工具，无listener
 *
 */
public class PencilButton extends Button{
	public PencilButton() {
		button.setIcon(new ImageIcon("icon/pencil.png"));//构造铅笔属性
		button.setToolTipText("铅笔");
	}
	
	/*public static void main(String[] args) {
		//用来测试单个程序的代码段,不用时可注释
		// TODO Auto-generated method stub
		PencilButton button = new PencilButton();
		JFrame frame = new JFrame();
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		//JPanel p1 = new JPanel(new GridLayout(5,2,5,5));
		c.add(button.button);
		frame.setSize(1200,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}*/
}
