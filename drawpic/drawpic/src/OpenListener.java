import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

/**
 * 
 * @author ASUS
 *
 * @time ����10:55:08
 *
 * @description ���ļ�������
 *
 */

public class OpenListener implements ActionListener{
	MyFrame frame;
	CanPaintLabel a;
	AllMenu b;
	public OpenListener(MyFrame frame,CanPaintLabel a,AllMenu b) {
		this.frame = frame;
		this.a = a;
		this.b = b;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(frame.name != null) {
			int result = JOptionPane.showConfirmDialog(frame.frame, "�Ƿ񱣴��������ĸ���?","����",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(result == JOptionPane.OK_OPTION){
            	String[] tem = frame.name.split("\\.");
            	String tee = tem[tem.length-1];
            	try {
					ImageIO.write(a.image,tee,new File(frame.name));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
		}
		JFileChooser fileChooser = new JFileChooser();// �����ļ�ѡ��Ի���
		FileFilter filter = new FileNameExtensionFilter("ͼ���ļ���JPG/JPEG/PNG��", "JPG", "JPEG","PNG");// �����ļ���������ֻ�г�JPG��PNG��ʽ��ͼƬ
		fileChooser.setFileFilter(filter);
		while(true) {
			int j = fileChooser.showOpenDialog(frame.frame);// ��ʾ�ļ�ѡ��Ի���
			// �ж��û��������Ƿ�Ϊ���򿪡���ť
			if (j == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();// ���ѡ�е�ͼƬ����
				if(!(new File(selectedFile.getAbsolutePath()).exists())) {
					JOptionPane.showMessageDialog(fileChooser, 
							selectedFile.getAbsolutePath()+" �����ڣ�������ѡ��");
				}
				else {
					try {
						a.image = ImageIO.read(new File(selectedFile.getAbsolutePath()));
						a.bg = (Graphics2D)a.image.getGraphics();//�õ�����
						a.setPreferredSize(new Dimension(a.image.getWidth(),a.image.getHeight()));
						a.teImage = null;
						a.gg = null;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						a.image = new BufferedImage(1000,500,BufferedImage.TYPE_INT_RGB);//����RGB��ʽ��ͼ��
						a.bg = (Graphics2D)a.image.getGraphics();//�õ�����
						a.bg.setColor(Color.WHITE);
						a.bg.fillRect(0, 0, a.image.getWidth(), a.image.getHeight());//����ʼ����Ϊ��ɫ
						a.setPreferredSize(new Dimension(1000,500));
						a.teImage = null;
						a.gg = null;
					}
					frame.name = selectedFile.getAbsolutePath();
					frame.undo.clear();
					frame.undo.addElement(a.image);
					frame.redo.clear();
					frame.cutboard = null;
					for(int i=5;i<=9;i++) {
						b.allMenuItem[i].setEnabled(false);
					}
					a.updateUI();
					break;
				}
			}
			else {
				break;
			}
		}
	}
}