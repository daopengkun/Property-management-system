//
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
class User_Secret extends Log_In implements ActionListener 
{
	JFrame frame = new JFrame("�����޸�");
	JLabel label1 = new JLabel("ԭ����");
	JLabel label2 = new JLabel("������");
	JButton Button1 = new JButton("ȷ��");
	JButton cancelButton = new JButton("����");
	JPasswordField password = new JPasswordField(9);
	JPasswordField newpassword = new JPasswordField(9);
	void create() 
	{
		JPanel p = (JPanel) frame.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(label1);
		p.setSize(5, 5);
		p.setLocation(4, 8);
		p.add(password);
		p.setSize(100, 200);
		p.setLocation(600, 600);
		p.add(label2);
		p.setSize(50, 20);
		p.setLocation(40, 80);
		p.add(newpassword);
		p.setSize(100, 20);
		p.setLocation(80, 120);
		p.add(Button1);
		p.add(cancelButton);
		p.setBackground(Color.cyan);
		p.setVisible(true);
		Button1.addActionListener(this);
		cancelButton.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setBounds(100,100, 200,200);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==Button1)
		{   Connection con;
		    Statement sql;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "�������ݿ�ʧ�ܣ�");
			}
			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=��λ��������ϵͳ","sa","zhj15717333380");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				sql.executeUpdate("UPDATE  Secret  SET secret='"+newpassword.getText()+"' where Wno='"+t1+"';");
				JOptionPane.showMessageDialog(this, "�޸ĳɹ���");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "ԭ�������������ԭ����������룡");
			}
		}
		if (e.getSource()==cancelButton) // ����
		{
			Log_In dl=new Log_In();
			dl.create();
			frame.dispose();
		}
	}
}