package drawpic;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����3:14:46
 *
 * @description Ǧ�ʹ��ߣ���listener
 *
 */
public class PencilButton extends Button{
	public PencilButton() {
		button.setIcon(new ImageIcon("icon/pencil.png"));//����Ǧ������
		button.setBackground(new Color(175,175,175));
		button.setToolTipText("Ǧ��");
	}
	
	/*public static void main(String[] args) {
		//�������Ե�������Ĵ����,����ʱ��ע��
		// TODO Auto-generated method stub
		PencilButton button = new PencilButton();
		JFrame frame = new JFrame();
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		//JPanel p1 = new JPanel(new GridLayout(5,2,5,5));
		c.add(button.button);
		frame.setSize(1200,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}*/
}