package drawpic;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����7:20:39
 *
 * @description ���������棬����������
 *
 */

public class MyFrame {
	JFrame frame;
	public MyFrame() {
		frame = new JFrame();
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		AllPanel all = new AllPanel();
		c.add(all.westPanel,BorderLayout.WEST);
		c.add(all.northPanel,BorderLayout.NORTH);
		c.add(all.centerPanel,BorderLayout.CENTER);
		frame.setJMenuBar(all.menu);
		frame.setSize(1200,700);
		frame.setTitle("���׻�ͼ��");
		try {
			frame.setIconImage(ImageIO.read(new File("icon/peach.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//���Է���ر�
		/*
		 frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		 frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    //�˴��ж��ļ��Ƿ񱣴�,������������˳�,����ѯ���Ƿ񱣴�,��������ļ�������,Ȼ���˳�
                    int result = JOptionPane.showConfirmDialog(null, "�Ƿ񱣴��������ĸ���?","����", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if(result == JOptionPane.OK_OPTION){
                        
                    }
                    else{
                    	System.exit(0);
                    }
                }
            });
		 */
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}