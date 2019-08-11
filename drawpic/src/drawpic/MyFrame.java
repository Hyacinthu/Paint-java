package drawpic;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午7:20:39
 *
 * @description 创建主界面，程序的主入口
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
		frame.setTitle("简易绘图板");
		try {
			frame.setIconImage(ImageIO.read(new File("icon/peach.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//测试方便关闭
		/*
		 frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		 frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    //此处判断文件是否保存,如果保存了则退出,否则询问是否保存,是则调出文件管理器,然后退出
                    int result = JOptionPane.showConfirmDialog(null, "是否保存您所作的更改?","保存", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
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
