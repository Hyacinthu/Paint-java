package drawpic;
import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author MengFanhua
 *
 * @time ����4:28:16
 *
 * @description ��������������һ����ʽ��button�࣬���������ж�Ӧλ�õ�button
 *
 */

public class Button {
	JButton button;
	public Button() {
		//�½�һ��button
		button = new JButton();
		//���ð�ť��С,����ò��û����
		button.setPreferredSize(new Dimension(30,30));
		//�����������
		button.setContentAreaFilled(false);
		//���ñ���ɫΪ��ɫ,֮��Ҫ�Ա�����ɫ�ж�ѡ��
		button.setBackground(new Color(127,127,127));
	}
	public static void main(String[] args) {//�������Ե�������Ĵ����,����ʱ��ע��
		// TODO Auto-generated method stub
		Button button = new Button();
		JFrame frame = new JFrame();
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		//JPanel p1 = new JPanel(new GridLayout(5,2,5,5));
		c.add(button.button);
		frame.setSize(1200,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}