package drawpic;

//import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author ASUS
 *
 * @time 下午3:12:24
 *
 * @description 圆形工具，无listener
 *
 */

public class CircleButton extends Button{
	public CircleButton() {
		button.setIcon(new ImageIcon("icon/circle.png"));//构造圆形属性
		button.setToolTipText("圆形");
	}
}
