import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����5:39:18
 *
 * @description ����������ɫ����
 *
 */

public class ColorTool {
	JLabel foreColorIcon;//ǰ��ɫͼ�����ʾ���������ͬ������
	JLabel backColorIcon;//����ɫͼ����ʾ���������ͬ��
	Button foreColor;//ǰ��ɫ��ť
	Button backColor;//����ɫ��ť
	JButton[] colorBox;//������ɫ��
	Button editColor;//�༭��ɫ��ť
	
	public ColorTool() {
		foreColor = new Button();
		backColor = new Button();
		editColor = new Button();
		foreColor.button.setPreferredSize(new Dimension(70,100));
		backColor.button.setPreferredSize(new Dimension(70,100));
		editColor.button.setPreferredSize(new Dimension(90,100));
		foreColor.button.setBackground(new Color(0,162,232));
		backColor.button.setBackground(new Color(220,220,220));
		editColor.button.setBackground(new Color(220,220,220));
		JPanel temp1 = new JPanel(new GridLayout(2,1));
		temp1.setOpaque(false);
		JPanel temp2 = new JPanel(new GridLayout(2,1));
		temp2.setOpaque(false);
		JPanel temp3 = new JPanel(new GridLayout(2,1));
		temp3.setOpaque(false);
		foreColorIcon = new JLabel("",JLabel.CENTER);
		foreColorIcon.setOpaque(true);//��������Ϊ��͸�����ſ������ñ���ɫ
		foreColorIcon.setBackground(Color.BLACK);//����ɫ����Ϊ�ڣ����Դ�����ǰѡ������ɫ
		foreColorIcon.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
		backColorIcon = new JLabel("",JLabel.CENTER);
		backColorIcon.setOpaque(true);//��������Ϊ��͸�����ſ������ñ���ɫ
		backColorIcon.setBackground(Color.WHITE);//����ɫ����Ϊ�ڣ����Դ�����ǰѡ������ɫ
		backColorIcon.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
		JLabel[] temp = new JLabel[4];
		for(int i=0;i<4;i++) {
			temp[i] = new JLabel("",JLabel.CENTER);
			temp[i].setOpaque(false);
		}
		temp[0].setText("��ɫ1");
		temp[1].setText("��ɫ2");
		temp[2].setIcon(new ImageIcon("icon/colorBox.png"));
		temp[3].setText("�༭��ɫ");
		temp1.add(foreColorIcon);
		temp1.add(temp[0]);
		foreColor.button.add(temp1);
		temp2.add(backColorIcon);
		temp2.add(temp[1]);
		backColor.button.add(temp2);
		temp3.add(temp[2]);
		temp3.add(temp[3]);
		editColor.button.add(temp3);
		colorBox = new JButton[20];
		for(int i=0;i<20;i++) {
			colorBox[i] = new JButton();
			colorBox[i].setPreferredSize(new Dimension(15,15));
			//colorBox[i].setBorderPainted(false);//���ò����Ʊ߿򣬴˴�Ӧ�����ã���JDialog�����ã���������
		}
		colorBox[0].setBackground(new Color(0,0,0));//���ݵ��Ի�ͼ��,������Щ������ɫ
		colorBox[1].setBackground(new Color(127,127,127));
		colorBox[2].setBackground(new Color(136,0,21));
		colorBox[3].setBackground(new Color(237,28,36));
		colorBox[4].setBackground(new Color(255,127,39));
		colorBox[5].setBackground(new Color(255,242,0));
		colorBox[6].setBackground(new Color(34,177,76));
		colorBox[7].setBackground(new Color(0,162,232));
		colorBox[8].setBackground(new Color(63,72,204));
		colorBox[9].setBackground(new Color(163,73,164));
		colorBox[10].setBackground(new Color(255,255,255));
		colorBox[11].setBackground(new Color(195,195,195));
		colorBox[12].setBackground(new Color(185,122,87));
		colorBox[13].setBackground(new Color(255,174,201));
		colorBox[14].setBackground(new Color(255,201,14));
		colorBox[15].setBackground(new Color(239,228,176));
		colorBox[16].setBackground(new Color(181,230,29));
		colorBox[17].setBackground(new Color(153,217,234));
		colorBox[18].setBackground(new Color(112,146,190));
		colorBox[19].setBackground(new Color(200,191,231));
	}
}