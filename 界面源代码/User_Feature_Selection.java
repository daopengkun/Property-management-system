//�û�����������
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class User_Feature_Selection extends Log_In implements ActionListener {

	JFrame f = new JFrame("ְ��������Ϣ��ѯ");
	JButton b1 = new JButton("��ѯ������Ϣ");
	JButton b2 = new JButton("��ѯ��ҵ����");
	JButton b3 = new JButton("��ѯ������ҵ");
	JButton b4 = new JButton("��ѯ���˷�����Ϣ");
	JButton b5 = new JButton("��ѯ���ڲ�����Ϣ");
	JButton b6 = new JButton("ס������");
	JButton b7 = new JButton("�޸�����");
	JButton b8 = new JButton("����");
	ImageIcon im = new ImageIcon("D:\\4.jpg");
	JLabel a1 = new JLabel(im);
	void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(a1);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.setBackground(Color.cyan);
		p.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		f.setBounds(100, 100, 400, 400);
		f.setVisible(true);
	}
public void actionPerformed(ActionEvent e) {

		if (b8.equals(e.getSource())) {
			Log_In d = new Log_In();
			d.create();
			f.dispose();
		}

		if (b1.equals(e.getSource())) {
			User_Information_Worker yg = new User_Information_Worker();
			yg.create();
			f.dispose();
		}
		if (b2.equals(e.getSource())) {

			User_PriceStandard gz = new User_PriceStandard();
			gz.create();
			f.dispose();	
		}
		if (b3.equals(e.getSource())) {

			User_NowProperty gz1 = new User_NowProperty();
			gz1.create();
			f.dispose();	
		}
		if (b4.equals(e.getSource())) {

			User_Information_House gz2 = new User_Information_House();
			gz2.create();
			f.dispose();	
		}
		if (b5.equals(e.getSource())) {

			User_Department gz3 = new User_Department();
			gz3.create();
			f.dispose();	
		}
		if (b6.equals(e.getSource())) {

			User_HouseClass gz4 = new User_HouseClass();
			gz4.create();
			f.dispose();	
		}
		if (b7.equals(e.getSource())) {

			User_Secret gz5 = new User_Secret();
			gz5.create();
			f.dispose();
		}
	}
}
