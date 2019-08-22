package drawpic;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 上午12:34:07
 *
 * @description 显示关于界面
 *
 */

@SuppressWarnings("serial")
public class AboutDialog extends JDialog{
	public AboutDialog(JFrame frame) {
		super(frame,"关于",true);
		Container c = getContentPane();
		JLabel sep = new JLabel("----------------------------------------------------------------------------",JLabel.CENTER);
		BufferedImage bimg;
		try {
			bimg = ImageIO.read(new File("icon/peach.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			bimg = null;
		}
		BufferedImage bim = new BufferedImage(bimg.getWidth()/4+1,bimg.getHeight()/4+1,BufferedImage.TYPE_INT_ARGB);
		Graphics2D gg = (Graphics2D)bim.getGraphics();
		gg.scale(0.25, 0.25);
		gg.drawImage(bimg, 0, 0, null);
		JLabel icon = new JLabel(new ImageIcon(bim));
		String str = "关于简易绘图板";
		String des = "<html><br><br>声明：<br>" + 
				"本绘图板中使用的所有图标均来源于网络，后经过加工处理。<br>" + 
				"如有侵权，请联系原作者删除，联系邮箱：1070985939@qq.com<br>" + 
				"原作者会尽快做出相应处理，谢谢！<br><br>" + 
				"说明：<br>" + 
				"非上线版本，原作者保留所有权利。<br><br>" + 
				"该绘图板仅供娱乐价值，可相互传播。<br>" + 
				"但不允许以此获取任何形式的利益，发现必究！</html>";
		JPanel t = new JPanel(new FlowLayout());
		t.add(new JLabel(str));
		t.add(icon);
		t.add(sep);
		t.add(new JLabel(des));
		c.add(t);
		this.setBounds(300, 100, 400, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
