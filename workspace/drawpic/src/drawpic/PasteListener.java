package drawpic;

import java.awt.*;
import java.awt.event.*;

public class PasteListener implements ActionListener{
	MyFrame frame;
	CanPaintLabel a;
	public PasteListener(MyFrame frame,CanPaintLabel a){
		this.frame = frame;
		this.a = a;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(a.teImage!=null) {//�ж��Ƿ�����ʱͼ�����
			a.bg.drawImage(a.teImage.getSubimage(2, 2, a.teImage.getWidth()-4, 
					a.teImage.getHeight()-4), a.temx+2, a.temy+2,a.teImage.getWidth()-4, 
					a.teImage.getHeight()-4, null);//������ʱͼ��ԭͼ��
			a.teImage = null;//�����ʱͼ��
			a.gg = null;//�����ʱͼ��Ļ���
		}
		a.teImage = frame.cutboard;
		a.gg = (Graphics2D)a.teImage.getGraphics();
		a.temx = 0;a.temy = 0;
		a.temw = a.teImage.getWidth();a.temh = a.teImage.getHeight();
		a.updateUI();
	}

}
