//
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
public class Manager_Property_Count extends JFrame implements ActionListener {
	JPanel jp,jp1,jp2,jp3;
	Container ct;
	JFrame f = new JFrame("��ҵ����");
	JButton b1 = new JButton("ȷ��");
	JButton b2 = new JButton("����");  
	JTextField tf1 = new JTextField(20);
	JTextField tf2 = new JTextField(20);
	JTextField tf3 = new JTextField(20);
	JTextField tf4 = new JTextField(20);
	JTextField tf5 = new JTextField(20);
	JTextField tf6 = new JTextField(20);
	JTextField tf7 = new JTextField(20);
	JTextField tf8 = new JTextField(20);
	JTextField tf9 = new JTextField(20);
	void create() {
		ct=f.getContentPane();
		jp=new JPanel();
		jp1=new JPanel(new GridLayout(9,1));
		jp2=new JPanel(new GridLayout(9,1));
		jp3=new JPanel();
		jp.add(new JLabel("��ҵ��������"));
		ct.add(jp,"North");
		jp1.add(new JLabel("����",SwingConstants.CENTER));
		jp2.add(tf1);
		jp1.add(new JLabel("ˮ����",SwingConstants.CENTER));
		jp2.add(tf2);
		jp1.add(new JLabel("ˮ����ֵ",SwingConstants.CENTER));
		jp2.add(tf3);
		jp1.add(new JLabel("�����",SwingConstants.CENTER));
		jp2.add(tf4);
		jp1.add(new JLabel("������ֵ",SwingConstants.CENTER));
		jp2.add(tf5);
		jp1.add(new JLabel("ȼ������",SwingConstants.CENTER));
		jp2.add(tf6);
		jp1.add(new JLabel("ȼ������ֵ",SwingConstants.CENTER));
		jp2.add(tf7);
		jp1.add(new JLabel("���",SwingConstants.CENTER));
		jp2.add(tf8);
		jp1.add(new JLabel("�·�",SwingConstants.CENTER));
		jp2.add(tf9);
		jp3.add(b1);
		jp3.add(b2);
		ct.add(jp1,"West");
		ct.add(jp2,"East");
		ct.add(jp3,"South");
		f.setSize(350,300);
		f.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.setResizable(true);// ���Ե��������С
	}
	public void actionPerformed(ActionEvent e) {
		if (b1.equals(e.getSource())) { 
			Connection con;
			Statement sql;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=��λ��������ϵͳ","sa","zhj15717333380");
				sql = con.createStatement();
				String insertStr = "INSERT INTO Property (Hno,WaterBaseValue,NowWaterValue,ElectricityBaseValue,NowElectricityValue,NuturalGasBaseValue,NowNuturalValue,NowYears,NowMonths) VALUES('"+tf1.getText()+"',"+tf2.getText()+","+tf3.getText()+","+tf4.getText()+","+tf5.getText()+","+tf6.getText()+","+tf7.getText()+",'"+tf8.getText()+"','"+tf9.getText()+"');";
				sql.executeUpdate(insertStr);
				con.close();
				JOptionPane.showMessageDialog(this, "��¼�ɹ���");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "��¼ʧ�ܣ�");
			}
		}
		
		
		if (b2.equals(e.getSource())) {// ����
			Manager_Property gl=new Manager_Property();
			gl.create();
			f.dispose();

		}
	}
}

 