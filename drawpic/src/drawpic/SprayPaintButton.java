package drawpic;

//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午3:15:52
 *
 * @description 喷漆工具，无listener
 *
 */
public class SprayPaintButton extends Button{
	public SprayPaintButton() {
		button.setIcon(new ImageIcon("icon/spraypaint.png"));//构造喷漆属性
		button.setToolTipText("喷漆");
	}
}