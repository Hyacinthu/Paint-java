import java.awt.*;

import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����11:58:58
 *
 * @description ��ʾ��������
 *
 */

@SuppressWarnings("serial")
public class HelpDialog extends JDialog{
	public HelpDialog(JFrame frame) {
		super(frame,"����",true);
		Container c = getContentPane();
		JLabel[] sep = new JLabel[13];
		for(int i=0;i<13;i++) {
			sep[i] = new JLabel("----------------------------------------------------------------------------",JLabel.CENTER);
		}
		
		JLabel[] show = new JLabel[14];
		show[0] = new JLabel("<html>  ˢ�ӣ��϶���������ϸ��Ǧ�ʵĴ�һЩ����ɫΪǰ��ɫ</html>");
		show[1] = new JLabel("<html>  Բ�Σ��϶����������Ե���λ�ã���ɫΪǰ��ɫ</html>");
		show[2] = new JLabel("<html>  Բ�Ǿ��Σ��϶����������Ե���λ�ã���ɫΪǰ��ɫ</html>");
		show[3] = new JLabel("<html>  ȡɫ�ʣ�������������ȡ������ֵ���ɫ</html>");
		show[4] = new JLabel("<html>  ���ߣ��϶����������Ե���λ�ã���ɫΪǰ��ɫ</html>");
		show[5] = new JLabel("<html>  ��Ƥ���϶����������Ե���λ�ã���ɫΪ����ɫ</html>");
		show[6] = new JLabel("<html>  ��ɫͰ��������������ǰ��ɫ���÷�����������㷨ԭ��<br>���ܻ����ӳ�</html>");
		show[7] = new JLabel("<html>  �Ŵ󾵣���������������Ŵ��Ҽ���С�������ֵ����Сֵ</html>");
		show[8] = new JLabel("<html>  ֱ�ߣ��϶����������Ե���λ�ã���ɫΪǰ��ɫ</html>");
		show[9] = new JLabel("<html>  Ǧ�ʣ��϶���������ϸ��Ǧ�ʵĴ�һЩ����ɫΪǰ��ɫ</html>");
		show[10] = new JLabel("<html>  ���Σ��϶����������Ե���λ�ã���ɫΪǰ��ɫ</html>");
		show[11] = new JLabel("<html>  ѡ�����϶����������Ե���λ�ã��϶������Ὣ��λ�õ�ͼ��<br>��ȡ�������Ա���ɫ�����λ��</html>");
		show[12] = new JLabel("<html>  ��ǹ���϶���������ϸ��Ǧ�ʵĴ�һЩ����ɫΪǰ��ɫ</html>");
		show[13] = new JLabel("<html>  �ı��򣺵����������Ե��λ��Ϊ���ķ���һ���ı��򣬿���<br>��������</html>");
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