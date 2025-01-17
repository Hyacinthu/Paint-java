import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午8:21:55
 *
 * @description 专门用于绘图而设立的监听器，并承担部分画布功能，减少画布文件的代码量
 *
 */

public class BorderListener implements MouseMotionListener,MouseListener{;
	AllButton b;
	AllMenu m;
	AllTool t;
	CanPaintLabel a;
	MyFrame fram;
	int x,y;
	int x1,y1;
	JTextArea text;
	public BorderListener(AllButton b,AllMenu m,AllTool t,CanPaintLabel c,MyFrame fram) {
		this.b = b;
		this.m = m;
		this.t = t;
		this.a = c;
		this.fram = fram;
		text = new JTextArea();
		text.setOpaque(false);//文本框透明
		text.setBorder(BorderFactory.createLineBorder(new Color(238,238,238)));
		text.setBounds(-101, -101, 201, 101);//便于寻找中心点
		fram.frame.add(text);//在主界面添加该文本框，以便于接受监听器信号，局部变量
	}
	@Override
	public void mouseDragged(MouseEvent e) {//当鼠标按下并拖动
		// TODO Auto-generated method stub
		int m = x+(e.getX()-a.x1);//画布大小+按下的点与当前点的坐标差
		int n = y+(e.getY()-a.y1);
		
		if(a.getCursor() == Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)) {//当teImage存在并且移动到该范围
			a.temx += (e.getX()-a.x1);//移动的新位置坐标
			a.temy += (e.getY()-a.y1);
			a.updateUI();//更新界面使其移动
			a.x1 = e.getX();//并更改保存的按下之前的位置
			a.y1 = e.getY();
		}
		else if(a.getCursor() == Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR)) {
			//当鼠标移动到右下边界并拖动
			if(m>100&&n>50&&m<3000&&n<1500){
				a.setPreferredSize(new Dimension(m,n));//判断最大与最小边界条件
			}
			else if(m>100&&n<=50&&m<3000) {
				a.setPreferredSize(new Dimension(m,50));
			}
			else if(m<=100&&n>50&&n<1500) {
				a.setPreferredSize(new Dimension(100,n));
			}
			else if(m<=100&&n<=50) {
				a.setPreferredSize(new Dimension(100,50));
			}
			else if(m>=3000&&n>50&&n<1500) {
				a.setPreferredSize(new Dimension(3000,n));
			}
			else if(m>100&&m<3000&&n>=1500) {
				a.setPreferredSize(new Dimension(m,1500));
			}
			else if(m>=3000&&n>=1500) {
				a.setPreferredSize(new Dimension(3000,1500));
			}
			else if(m<=100&&n>=1500) {
				a.setPreferredSize(new Dimension(100,1500));
			}
			else {
				a.setPreferredSize(new Dimension(3000,50));
			}
			a.updateUI();//更新界面
			
		}
		else if(a.getCursor() == Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR)) {//右侧拖动区
			if(m<=100) {
				a.setPreferredSize(new Dimension(100,y));//判断最大与最小边界条件
			}
			else if(m>100&&m<3000) {
				a.setPreferredSize(new Dimension(m,y));
			}
			else {
				a.setPreferredSize(new Dimension(3000,y));
			}
			a.updateUI();
		}
		else if(a.getCursor() == Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR)) {//下侧边界区
			if(n<=50) {
				a.setPreferredSize(new Dimension(x,50));//判断最大与最小边界条件
			}
			else if(n>50&&n<1500) {
				a.setPreferredSize(new Dimension(x,n));
			}
			else {
				a.setPreferredSize(new Dimension(x,1500));
			}
			a.updateUI();
		}
		else {//功能产生区
			if(text.getBounds().x != -101) {//判断文本框是否被移动过，移动过则要还原
				a.teImage = new BufferedImage(206,106,
						BufferedImage.TYPE_INT_ARGB);
				a.gg = (Graphics2D)a.teImage.getGraphics();//临时的图像缓存
				a.gg.setFont(text.getFont());//设置字体
				a.gg.setColor(a.fore);//设置颜色
				FontMetrics metrics = a.gg.getFontMetrics();//获得字体绘制位置的比例
				a.gg.drawString(text.getText(), 5, metrics.getAscent()+3);//绘制文字
				a.temx = x1-2;a.temy = y1-2;a.temw = a.teImage.getWidth();a.temh = a.teImage.getHeight();//保存临时位置以备拖动
				text.setLocation(-101, -101);//还原文本框位置
				text.setText("");//清空文本框中的文字
				a.gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {//绘出临时图像缓存的边框
					a.gg.drawLine(a.teImage.getWidth()*(i-1)/5, 0, a.teImage.getWidth()*i/5, 0);
					a.gg.drawLine(a.teImage.getWidth()*(i-1)/5,a.teImage.getHeight()-1,
							a.teImage.getWidth()*i/5, a.teImage.getHeight()-1);
					a.gg.drawLine(0, a.teImage.getHeight()*(i-1)/5, 0, a.teImage.getHeight()*i/5);
					a.gg.drawLine(a.teImage.getWidth()-1, a.teImage.getHeight()*(i-1)/5, 
							a.teImage.getWidth()-1, a.teImage.getHeight()*i/5);
				}
				a.bg.drawImage(a.teImage.getSubimage(2, 2, a.teImage.getWidth()-4, 
						a.teImage.getHeight()-4), a.temx+2, a.temy+2,a.teImage.getWidth()-4, 
						a.teImage.getHeight()-4, null);//将临时图像绘制到原图像中
				a.teImage = null;//清除临时图像
				a.gg = null;//清除临时图像的画笔
				a.updateUI();
			}
			else if(a.teImage!=null&&a.flag == 0) {//判断是否有临时图像存在
				if(a.getCursor() != Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)) {
					a.bg.drawImage(a.teImage.getSubimage(2, 2, a.teImage.getWidth()-4, 
							a.teImage.getHeight()-4), a.temx+2, a.temy+2,a.teImage.getWidth()-4, 
							a.teImage.getHeight()-4, null);//绘制临时图像到原图像
					a.teImage = null;//清除临时图像
					a.gg = null;//清除临时图像的画笔
					a.updateUI();
				}
			}
			a.flag = 1;//设置绘制信号,否则会跳过绘制部分
			if(a.selectButton != 3&&a.selectButton != 6&&a.selectButton != 7&&
					a.selectButton != 13) {//去除点击响应的组件索引
				a.x = e.getX();//保留当前坐标值
				a.y = e.getY();
				a.updateUI();
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {//鼠标移动但无点击事件
		// TODO Auto-generated method stub
		x = a.getPreferredSize().width;//记录当前画布的大小
		y = a.getPreferredSize().height;
		if(a.teImage !=null) {//当有临时图像存在时
			if(e.getX()>a.temx+1&&e.getX()<a.temx+a.temw-1&&
					e.getY()>a.temy+1&&e.getY()<a.temy+a.temh-1) {
				a.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			}//如果鼠标移动到临时图像区，将鼠标变成十字箭头，以供上方的dragged调用
			else {//其他情况
				if(e.getX()<=a.getWidth()&&e.getX()+3>=a.getWidth()&&
					e.getY()<=a.getHeight()&&e.getY()+3>=a.getHeight()) {
					a.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));//鼠标移动到右下边界处，调用同上
				}
				else if(e.getX()<=a.getWidth()&&e.getX()+3>=a.getWidth()) {
					a.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));//鼠标移动到右边界处，调用同上
				}
				else if(e.getY()<=a.getHeight()&&e.getY()+3>=a.getHeight()) {
					a.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));//鼠标移动到下边界处，调用同上
				}
				else {
					a.setCursor(Cursor.getDefaultCursor());//放置默认的鼠标图标
				}
			}
		}
		else {//无临时图像
			if(e.getX()<=a.getWidth()&&e.getX()+3>=a.getWidth()&&
				e.getY()<=a.getHeight()&&e.getY()+3>=a.getHeight()) {
				a.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));//功能同上
			}
			else if(e.getX()<=a.getWidth()&&e.getX()+3>=a.getWidth()) {
				a.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
			}
			else if(e.getY()<=a.getHeight()&&e.getY()+3>=a.getHeight()) {
				a.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
			}
			else {
				a.setCursor(Cursor.getDefaultCursor());
			}
		}
		
		a.x1 = e.getX();//移动时保留位置，以便于功能调用
		a.y1 = e.getY();
		text.updateUI();//实时刷新文本框，否则其他组件会将其盖住
	}
	@SuppressWarnings("static-access")
	@Override
	public void mouseClicked(MouseEvent e) {//鼠标点击事件
		// TODO Auto-generated method stub
		if(text.getBounds().x != -101) {//判断文本框是否被调用，如果鼠标没有脱离文本框是不会触发点击事件的
			//将文本框中的文字变成图片并放置到临时图像中
			a.teImage = new BufferedImage(206,106,
					BufferedImage.TYPE_INT_ARGB);
			a.gg = (Graphics2D)a.teImage.getGraphics();
			a.gg.setFont(text.getFont());
			a.gg.setColor(a.fore);
			FontMetrics metrics = a.gg.getFontMetrics();
			a.gg.drawString(text.getText(), 5, metrics.getAscent()+3);
			a.temx = x1-2;a.temy = y1-2;a.temw = a.teImage.getWidth();a.temh = a.teImage.getHeight();
			text.setLocation(-101, -101);
			text.setText("");
			a.gg.setColor(Color.BLACK);
			for(int i=1;i<=5;i=i+2) {//绘制临时图像边框
				a.gg.drawLine(a.teImage.getWidth()*(i-1)/5, 0, a.teImage.getWidth()*i/5, 0);
				a.gg.drawLine(a.teImage.getWidth()*(i-1)/5,a.teImage.getHeight()-1,
						a.teImage.getWidth()*i/5, a.teImage.getHeight()-1);
				a.gg.drawLine(0, a.teImage.getHeight()*(i-1)/5, 0, a.teImage.getHeight()*i/5);
				a.gg.drawLine(a.teImage.getWidth()-1, a.teImage.getHeight()*(i-1)/5, 
						a.teImage.getWidth()-1, a.teImage.getHeight()*i/5);
			}
			a.updateUI();//更新组件
		}
		else if(a.teImage!=null) {//临时图像和有更改的文本框不会同时触发
			if(a.getCursor() != Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)) {//不是移动标志
				a.bg.drawImage(a.teImage.getSubimage(2, 2, a.teImage.getWidth()-4, 
						a.teImage.getHeight()-4), a.temx+2, a.temy+2,a.teImage.getWidth()-4, 
						a.teImage.getHeight()-4, null);//讲临时图像添加到原图像
				a.teImage = null;//清除临时图像
				a.gg = null;//清除临时图像画笔
				a.updateUI();
			}
		}
		else {
			if(a.selectButton == 13) {//选择的组件为文本框
				text.setLocation(e.getXOnScreen()-fram.frame.getBounds().x-105, 
					e.getYOnScreen()-fram.frame.getBounds().y-115);//放置文本框，使鼠标位置在中间
				x1 = e.getX()-100;//记录当前位置，便于转换图像时确定位置
				y1 = e.getY()-50;
			}
			else if(a.selectButton == 6) {//组件为填色桶
				a.x1 = e.getX();
				a.y1 = e.getY();
				a.flag = 1;//触发绘图
				a.updateUI();
			}
			else if(a.selectButton == 3) {//组件为取色笔
				int[] rgb = new int[3];
				int pixel = a.image.getRGB(e.getX(), e.getY());//得到点击的点的RGB值
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				if(t.allButton[0].button.getBackground().equals(new Color(0,162,232))) {
					//判断当前选定的颜色是前景还是后景
					t.allLabel[0].setBackground(new Color(rgb[0],rgb[1],rgb[2]));//更改颜色
					t.allLabel[0].updateUI();
				}
				else {
					t.allLabel[1].setBackground(new Color(rgb[0],rgb[1],rgb[2]));
					t.allLabel[1].updateUI();
				}
			}
			else if(a.selectButton == 7) {//组件为放大镜
				if(e.getButton()==e.BUTTON1) {//鼠标左键被点击
					if(a.image.getWidth()*(a.times+1)/a.oldtimes<=5000&&
							a.image.getHeight()*(a.times+1)/a.oldtimes<=2500) {//如果不超过最大限制5000x2500
						a.times += 1;//放大标志
						a.setPreferredSize(new Dimension(a.getPreferredSize().width*a.times/a.oldtimes,
								a.getPreferredSize().height*a.times/a.oldtimes));//更改画布大小以适应图像大小改变
						a.flag = 1;//触发事件
						a.updateUI();
					}
					
				}
				else if(e.getButton()==e.BUTTON3) {//右键被点击
					if(a.times != 1) {
						a.times -= 1;//放大倍数不为基础倍数则缩小
						a.setPreferredSize(new Dimension(a.getPreferredSize().width*a.times/a.oldtimes,
								a.getPreferredSize().height*a.times/a.oldtimes));//更改画布大小以适应图像大小改变
						a.flag = 1;//触发事件
						a.updateUI();
					}
				}
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {//当鼠标移动到画布区时
		// TODO Auto-generated method stub
		//此处根据其他工具的情况设定画布的初始值
		int se=0;int ti=a.times;
		String fo;
		int bl=0;int un=0;;int le=0;
		int fs;int si=3;
		Color fore;Color ba;
		for(int i=0;i<b.allButton.length;i++) {
			if(b.allButton[i].button.getBackground().equals(new Color(175,175,175))){
				se = i;
				break;
			}
			else {
				continue;
			}
		}
		fo = (String)t.fontBox.getSelectedItem();
		if(t.allButton[3].button.getBackground().equals(new Color(175,175,175))) {
			bl=1;
		}
		if(t.allButton[4].button.getBackground().equals(new Color(175,175,175))) {
			un=1;
		}
		if(t.allButton[5].button.getBackground().equals(new Color(175,175,175))) {
			le=1;
		}
		fs = Integer.parseInt((String)t.fontSizeBox.getSelectedItem());
		if(((String)t.sizeBox.getSelectedItem()).equals("最小")) {
			si=1;
		}
		else if(((String)t.sizeBox.getSelectedItem()).equals("小")) {
			si=3;
		}
		else if(((String)t.sizeBox.getSelectedItem()).equals("大")) {
			si=5;
		}
		else {
			si=7;
		}
		fore = t.allLabel[0].getBackground();
		ba = t.allLabel[1].getBackground();
		a.setProperty(se, ti, si, fore, ba);//设置初始参数
		a.updateUI();
		HashMap<TextAttribute, Object> hm = new HashMap<TextAttribute, Object>();//在此处设置文本框字体备用
		if(un == 1) {
			hm.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON); // 定义有下划线
		}
		if(le == 1) {
			hm.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);//设置倾斜
		}
		if(bl == 1) {
			hm.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);//设置加粗
		}
		hm.put(TextAttribute.SIZE, fs); // 定义字号
		hm.put(TextAttribute.FAMILY, fo); // 定义字体名
		text.setFont(new Font(hm));
		text.setForeground(fore);
		a.flag = 0;//非触发事件
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(a.selectButton == 11&&a.teImage != null&&a.flag==1) {//当为选定框，且选定完成后
			a.gg.drawImage(a.image.getSubimage(a.temx+2, a.temy+2, a.temw-5, a.temh-5),
					2, 2, a.temw-5, a.temh-5, null);//截取选定部分图像放入临时区，并将截取原部分填充背景色
			a.bg.setColor(a.back);
			a.bg.fillRect(a.temx+2, a.temy+2, a.temw-5, a.temh-5);
			a.flag = 0;
			a.updateUI();
			m.allMenuItem[7].setEnabled(true);
			m.allMenuItem[8].setEnabled(true);
		}
		else {
			m.allMenuItem[7].setEnabled(false);
			m.allMenuItem[8].setEnabled(false);
		}
		a.flag = 0;//此处是当除选定框外的所有其他组件结束时调用，用以控制绘图频率
		fram.undo.addElement(a.image);
		fram.redo.clear();
		if(!fram.undo.isEmpty()) {
			m.allMenuItem[5].setEnabled(true);
		}
		else {
			m.allMenuItem[5].setEnabled(false);
		}
	}
}
