import java.awt.image.*;
import java.io.*;
import java.util.*;

import javax.imageio.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����7:20:39
 *
 * @description ����������
 *
 */

public class MyFrame {
	JFrame frame;
	Vector<BufferedImage> undo;
	Vector<BufferedImage> redo;
	BufferedImage cutboard;
	String name;
	public MyFrame() {
		frame = new JFrame();
		frame.setBounds(80,10,1200,750);
		frame.setTitle("���׻�ͼ��");
		try {
			frame.setIconImage(ImageIO.read(new File("icon/peach.png")));
		} catch (IOException e) {
			//�����ϲ��ᴥ���������û���ɾ�ļ�
			e.printStackTrace();
		}
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//���Է���ر�
		undo = new Vector<BufferedImage>();
		redo = new Vector<BufferedImage>();
		cutboard = null;
		name = null;
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}
}