package drawpic;
//import java.awt.*;
import javax.swing.*;

public class SizeTool {
	JLabel sizeLabel;
	JComboBox<String> sizeTool;
	public SizeTool() {
		sizeTool = new JComboBox<String>();//设置一个简陋的选择大小的下拉框
		sizeTool.addItem("最小");
		sizeTool.addItem("小");
		sizeTool.addItem("大");
		sizeTool.addItem("最大");
		sizeTool.setSelectedIndex(1);
		sizeLabel = new JLabel("画笔大小:",JLabel.CENTER);
		sizeLabel.setOpaque(true);
	}
}
