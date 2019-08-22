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
 * @time ����12:34:07
 *
 * @description ��ʾ���ڽ���
 *
 */

@SuppressWarnings("serial")
public class AboutDialog extends JDialog{
	public AboutDialog(JFrame frame) {
		super(frame,"����",true);
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
		String str = "���ڼ��׻�ͼ��";
		String des = "<html><br><br>������<br>" + 
				"����ͼ����ʹ�õ�����ͼ�����Դ�����磬�󾭹��ӹ�������<br>" + 
				"������Ȩ������ϵԭ����ɾ������ϵ���䣺1070985939@qq.com<br>" + 
				"ԭ���߻ᾡ��������Ӧ������лл��<br><br>" + 
				"˵����<br>" + 
				"�����߰汾��ԭ���߱�������Ȩ����<br><br>" + 
				"�û�ͼ��������ּ�ֵ�����໥������<br>" + 
				"���������Դ˻�ȡ�κ���ʽ�����棬���ֱؾ���</html>";
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