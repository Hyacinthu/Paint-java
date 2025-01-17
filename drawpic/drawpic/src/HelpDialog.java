import java.awt.*;

import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午11:58:58
 *
 * @description 显示帮助界面
 *
 */

@SuppressWarnings("serial")
public class HelpDialog extends JDialog{
	public HelpDialog(JFrame frame) {
		super(frame,"帮助",true);
		Container c = getContentPane();
		JLabel[] sep = new JLabel[13];
		for(int i=0;i<13;i++) {
			sep[i] = new JLabel("----------------------------------------------------------------------------",JLabel.CENTER);
		}
		
		JLabel[] show = new JLabel[14];
		show[0] = new JLabel("<html>  刷子：拖动触发，粗细比铅笔的大一些，颜色为前景色</html>");
		show[1] = new JLabel("<html>  圆形：拖动触发，可以调节位置，颜色为前景色</html>");
		show[2] = new JLabel("<html>  圆角矩形：拖动触发，可以调节位置，颜色为前景色</html>");
		show[3] = new JLabel("<html>  取色笔：单击触发，获取点击部分的颜色</html>");
		show[4] = new JLabel("<html>  曲线：拖动触发，可以调节位置，颜色为前景色</html>");
		show[5] = new JLabel("<html>  橡皮：拖动触发，可以调节位置，颜色为背景色</html>");
		show[6] = new JLabel("<html>  填色桶：单击触发，用前景色填充该封闭区域，由于算法原因，<br>可能会有延迟</html>");
		show[7] = new JLabel("<html>  放大镜：单击触发，左键放大，右键缩小，有最大值和最小值</html>");
		show[8] = new JLabel("<html>  直线：拖动触发，可以调节位置，颜色为前景色</html>");
		show[9] = new JLabel("<html>  铅笔：拖动触发，粗细比铅笔的大一些，颜色为前景色</html>");
		show[10] = new JLabel("<html>  矩形：拖动触发，可以调节位置，颜色为前景色</html>");
		show[11] = new JLabel("<html>  选定框：拖动触发，可以调节位置，拖动结束会将该位置的图像<br>截取出来，以背景色填补空余位置</html>");
		show[12] = new JLabel("<html>  喷枪：拖动触发，粗细比铅笔的大一些，颜色为前景色</html>");
		show[13] = new JLabel("<html>  文本框：单击触发，以点击位置为中心放置一个文本框，可以<br>进行输入</html>");
		for(int i=0;i<14;i++) {
			show[i].setSize(400, 0);
		}
		JPanel t = new JPanel(new FlowLayout(FlowLayout.LEFT));
		for(int i=0;i<13;i++) {
			t.add(show[i]);
			t.add(sep[i]);
		}
		t.add(show[13]);
		c.add(t);
		this.setBounds(300, 10, 400, 750);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
