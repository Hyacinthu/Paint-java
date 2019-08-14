package drawpic;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����5:49:24
 *
 * @description ��д����label�����Ը�����ɫcolor���ɽ�����ɫ��
 *
 */


@SuppressWarnings("serial")
public class ShadeLabel extends JLabel {
	Color b;
	public ShadeLabel() {
		super();
		setLayout(null);
		b=Color.GRAY;
	}
    @Override
    protected void paintComponent(Graphics g1) {// ��д����������
        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);// ִ�г��෽��
        int width = getWidth();// ��ȡ�����С
        int height = getHeight();
        // �������ģʽ����
        GradientPaint paint1 = new GradientPaint(0, 0, Color.WHITE, 0, height/2,
                b);//�˴�Ϊ����ģʽ
        GradientPaint paint2 = new GradientPaint(0, height/2, b, 0, height,
                Color.BLACK);
        g.setPaint(paint1);// ���û�ͼ��������ģʽ
        g.fillRect(0, 0, width, height/2);// ���ƾ������ؼ�����
        g.setPaint(paint2);
        g.fillRect(0, height/2, width, height/2);
    }
    @Override
    public void setBackground(Color bg) {
    	b=bg;
    	super.setBackground(bg);
    }
    @Override
    public Color getBackground() {
    	return b;
    }
}