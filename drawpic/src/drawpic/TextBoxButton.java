package drawpic;

//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午3:16:10
 *
 * @description 文本框工具，无listener
 *
 */
public class TextBoxButton extends Button{
	public TextBoxButton() {
		button.setIcon(new ImageIcon("icon/textbox.png"));//构造文本框属性
		button.setToolTipText("文本框");
	}
}
