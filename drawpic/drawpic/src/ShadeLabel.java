import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午5:49:24
 *
 * @description 重写过的label，用以根据颜色color生成渐变颜色板
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
    protected void paintComponent(Graphics g1) {// 重写绘制组件外观
        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);// 执行超类方法
        int width = getWidth();// 获取组件大小
        int height = getHeight();
        // 创建填充模式对象
        GradientPaint paint1 = new GradientPaint(0, 0, Color.WHITE, 0, height/2,
                b);//此处为渐变模式
        GradientPaint paint2 = new GradientPaint(0, height/2, b, 0, height,
                Color.BLACK);
        g.setPaint(paint1);// 设置绘图对象的填充模式
        g.fillRect(0, 0, width, height/2);// 绘制矩形填充控件界面
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