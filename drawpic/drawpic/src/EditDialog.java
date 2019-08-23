import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����8:18:35
 *
 * @description ���ڵ���༭��ɫ��ť�����Ľ���
 *
 */


@SuppressWarnings("serial")
public class EditDialog extends JDialog{
	public EditDialog(JFrame frame,JButton f,JButton b,JLabel[] a) {
		super(frame,"�༭��ɫ",true);
		Container c = getContentPane();
		JPanel center = new JPanel(new GridLayout(1,2));
		JPanel left = new JPanel(new FlowLayout());
		JPanel right = new JPanel(new GridLayout(4,2));
		right.setPreferredSize(new Dimension(260,241));
		JPanel[] righter = new JPanel[4];
		JPanel[] lefter = new JPanel[4];
		for(int i=0;i<4;i++) {
			righter[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
			lefter[i] = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		}
		/*�����ǽ���contain�ķ������ֻ��ֺã��Ա���֮���������ӣ����濪ʼ�������������ѡ�����*/
		JLabel select;
		if(f.getBackground().equals(new Color(0,162,232))) {
			select = a[0];
		}
		else {
			select = a[1];
		}
		JLabel x =new JLabel("",new ImageIcon("icon/color.png"),JLabel.CENTER);
		x.setOpaque(true);
		x.setPreferredSize(new Dimension(240,241));
		//��ɫ��
		left.add(x);
		ShadeLabel p = new ShadeLabel();//��дJLabel��Ľ��䱳��ɫ��label
		p.setPreferredSize(new Dimension(20,240));
		left.add(p);
		//������
		JLabel[] label = new JLabel[8];
		for(int i=0;i<8;i++) {
			label[i] = new JLabel("",JLabel.CENTER);
			label[i].setPreferredSize(new Dimension(60,40));
		}
		label[0].setText("Ԥ����");
		label[1].setText("red:");
		label[2].setText("green:");
		label[3].setText("blue:");
		for(int i=0;i<4;i++) {
			label[i+4].setOpaque(true);
		}
		label[4].setBackground(select.getBackground());
		label[4].setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
		label[4].setPreferredSize(new Dimension(50,40));
		for(int i=0;i<3;i++) {
			label[i+5].setBackground(Color.WHITE);
		}
		label[5].setText(String.valueOf(select.getBackground().getRed()));
		label[6].setText(String.valueOf(select.getBackground().getGreen()));
		label[7].setText(String.valueOf(select.getBackground().getBlue()));
		for(int i=0;i<4;i++) {
			lefter[i].add(label[i]);
		}
		for(int i=0;i<4;i++) {
			righter[i].add(label[i+4]);
		}
		for(int i=0;i<4;i++) {
			right.add(lefter[i]);
			right.add(righter[i]);
		}
		center.add(left);
		center.add(right);
		//dialog�в�����listener�������ӵ�AllListener��
		SelectColorBoxListener as = new SelectColorBoxListener(x,this,p,label);
		ThinColorBoxListener as1 = new ThinColorBoxListener(this,p,label);
		x.addMouseListener(as);
		p.addMouseListener(as1);
		JButton con = new JButton("ȷ��");
		con.setBackground(new Color(200,200,200));
		OKListener as2 = new OKListener(select,label[4],this);
		con.addActionListener(as2);
		c.add(center,BorderLayout.CENTER);
		JPanel south = new JPanel(new FlowLayout());
		south.setPreferredSize(new Dimension(400,50));
		south.add(con);
		c.add(south,BorderLayout.SOUTH);
		this.setBounds(100, 100, 570, 350);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
}