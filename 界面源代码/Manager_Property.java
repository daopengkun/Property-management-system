//
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class Manager_Property extends JFrame implements ActionListener {
    float A,B,C;
	JFrame f = new JFrame("��ҵģ��");
	ImageIcon im = new ImageIcon("D:\\3.jpg");
	JLabel a1 = new JLabel(im);
	JButton b1 = new JButton("������ҵ����");
	JButton b2 = new JButton("��ʷ��ҵ��ѯ");
	JButton b3 = new JButton("��ҵ��������");
	JButton b4 = new JButton("����");
		void create() {
			JPanel p = (JPanel) f.getContentPane();
			p.setLayout(new FlowLayout());
			p.add(a1);
			p.add(b1);
			p.add(b2);
			p.add(b3);
			p.add(b4);
			p.setBackground(Color.CYAN);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			f.setBounds(100, 100, 450, 450);
			f.setResizable(true);// ���Ե��������С
			f.setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {

			if (b4.equals(e.getSource())) {
				Manager_Feature_Selection d = new Manager_Feature_Selection();
				d.create();
				f.dispose();
			}

			if (b1.equals(e.getSource())) {
				Manager_Property_Count yg = new Manager_Property_Count();
				yg.create();
				f.dispose();
			}
			if (b2.equals(e.getSource())) {

				Manager_Property_Selection gz = new Manager_Property_Selection();
				gz.create();
				f.dispose();	
			}
			if (b3.equals(e.getSource())) {

				Manager_Property_Price gz = new Manager_Property_Price();
				gz.create();
				f.dispose();	
			}
		}
	}
