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
		//设置背景色为灰色,之后要以背景颜色判定选定
		button.setBackground(new Color(255,255,255));
	}
}
