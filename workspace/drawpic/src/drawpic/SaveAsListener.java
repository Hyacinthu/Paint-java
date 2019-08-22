package drawpic;

//import java.awt.*;
import java.awt.event.*;
//import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

/**
 * 
 * @author ASUS
 *
 * @time ����10:54:34
 *
 * @description ����Ϊ������
 *
 */

public class SaveAsListener implements ActionListener {
	MyFrame frame;
	CanPaintLabel a;

	public SaveAsListener(MyFrame frame,CanPaintLabel a) {
		this.frame = frame;
		this.a = a;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser fileChooser = new JFileChooser();// �����ļ�ѡ��Ի���
		FileFilter filter = new FileNameExtensionFilter("ͼ���ļ���JPG/GIF��", "JPG", "JPEG","PNG");// �����ļ���������ֻ�г�JPG��PNG��ʽ��ͼƬ
		fileChooser.setFileFilter(filter);
		while(true) {
			int j = fileChooser.showSaveDialog(frame.frame);// ��ʾ�ļ�ѡ��Ի���
			// �ж��û��������Ƿ�Ϊ�����桱��ť
			if (j == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();// ���ѡ�е�ͼƬ����
				if(new File(selectedFile.getAbsolutePath()).exists()) {
					int res = JOptionPane.showConfirmDialog(fileChooser, 
							selectedFile.getAbsolutePath()+" �Ѵ��ڣ��Ƿ񸲸���?","ȷ��",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(res == JOptionPane.OK_OPTION){
						frame.name = selectedFile.getAbsolutePath();
						break;
					}
				}
				else {
					frame.name = selectedFile.getAbsolutePath();
					break;
				}
			}
			else {
				break;
			}
		}
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