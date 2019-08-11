package drawpic;

//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午3:15:31
 *
 * @description 矩形选定框工具，无listener
 *
 */
public class SelectBoxButton extends Button{
	public SelectBoxButton() {
		button.setIcon(new ImageIcon("icon/selectbox.png"));//构造选定框属性
		button.setToolTipText("矩形选择框");
	}
}
