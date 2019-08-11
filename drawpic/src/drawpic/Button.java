package drawpic;
import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author MengFanhua
 *
 * @time 下午4:28:16
 *
 * @description 该类用来创建有一定格式的button类，创建画板中对应位置的button
 *
 */

public class Button {
	JButton button;
	public Button() {
		//新建一个button
		button = new JButton();
		//设置按钮大小,但是貌似没有用
		button.setPreferredSize(new Dimension(30,30));
		//区域内无填充
		button.setContentAreaFilled(false);
		//设置背景色为灰色,之后要以背景颜色判定选定
		button.setBackground(new Color(127,127,127));
	}
	public static void main(String[] args) {//用来测试单个程序的代码段,不用时可注释
		// TODO Auto-generated method stub
		Button button = new Button();
		JFrame frame = new JFrame();
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		//JPanel p1 = new JPanel(new GridLayout(5,2,5,5));
		c.add(button.button);
		frame.setSize(1200,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
