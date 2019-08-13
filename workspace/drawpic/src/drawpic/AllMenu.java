package drawpic;
//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����5:24:58
 *
 * @description ����menu����ļ��ϣ����㴫����
 * allMenu�ֱ���������˵����ļ����༭������
 * allMenuItemǰ���Ϊ�ļ���ѡ��½����򿪡����桢����Ϊ���˳�
 * ֮�����Ϊ�༭��ѡ����������������ơ����С�ճ��
 * �������Ϊ������ѡ���ʾ����������
 * �����е����ļ��������ģ��е����µ�dialog�ģ����в���Ч����
 *
 */

public class AllMenu {
	JMenu[] allMenu;
	JMenuItem[] allMenuItem;
	public AllMenu() {
		FileMenu fileMenu = new FileMenu();
		EditMenu editMenu = new EditMenu();
		HelpMenu helpMenu = new HelpMenu();
		allMenu = new JMenu[3];
		allMenuItem = new JMenuItem[12];
		allMenu[0] = fileMenu.fileMenu;
		allMenu[1] = editMenu.editMenu;
		allMenu[2] = helpMenu.helpMenu;
		allMenuItem[0] = fileMenu.newMenu;
		allMenuItem[1] = fileMenu.openMenu;
		allMenuItem[2] = fileMenu.saveMenu;
		allMenuItem[3] = fileMenu.saveAsMenu;
		allMenuItem[4] = fileMenu.exitMenu;
		allMenuItem[5] = editMenu.undoMenu;
		allMenuItem[6] = editMenu.redoMenu;
		allMenuItem[7] = editMenu.copyMenu;
		allMenuItem[8] = editMenu.cutMenu;
		allMenuItem[9] = editMenu.pasteMenu;
		allMenuItem[10] = helpMenu.showHelpMenu;
		allMenuItem[11] = helpMenu.aboutMenu;
	}
}