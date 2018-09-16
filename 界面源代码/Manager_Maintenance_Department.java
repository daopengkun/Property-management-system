//
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
public class Manager_Maintenance_Department extends JFrame implements ActionListener {

	JFrame f = new JFrame("����ά��");
	JButton b1 = new JButton("��ѯ���в�����Ϣ");
	JButton b2 = new JButton("��ѯĳһ������Ϣ");
	JButton b3 = new JButton("������");
	JButton b4 = new JButton("ɾ��ĳһ����");
	JButton b5 = new JButton("����");
	JTextField tf1 = new JTextField(6);
	JTextField tf2 = new JTextField(8);
	String[] cloum = { "���ű��", "��������", "��������"};
	Object[][] row = new Object[50][3];
	JTable table = new JTable(row, cloum);
	JScrollPane scrollpane = new JScrollPane(table);
	JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(scrollpane);
		p.add(splitpane);
		JPanel p1 = new JPanel();
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.cyan);
		p2.add(scrollpane);
		p.setLayout(new FlowLayout());
		p.add(new JLabel(""));
		p.add(new JLabel("���ź�"));
		p.add(tf1);
		p.add(new JLabel("��������"));
		p.add(tf2);
		splitpane.add(p1, splitpane.TOP);
		splitpane.add(p2, splitpane.BOTTOM);
		splitpane.setDividerLocation(50);
		p.setBackground(Color.CYAN);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		f.setBounds(100, 100, 500, 600);
		f.setResizable(true);// ���Ե��������С
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (b3.equals(e.getSource())) { // ¼��
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
				String insertStr = "INSERT INTO Department(Dno,Dname) VALUES('"+tf1.getText()+"','"+tf2.getText()+"');";
				sql.executeUpdate(insertStr);
				con.close();
				JOptionPane.showMessageDialog(this, "��¼�ɹ���");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "��¼ʧ�ܣ�");
			}
		}
		

		if (b4.equals(e.getSource())) {// ɾ��
			Connection con;
			Statement sql;
			ResultSet rs;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=��λ��������ϵͳ","sa","zhj15717333380");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				sql.executeUpdate("DELETE FROM Department  where  Dno='"+tf1.getText()+"';");
				JOptionPane.showMessageDialog(this, "ɾ���ɹ���");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "ɾ��ʧ�ܣ�");
			}

		}
		if (b2.equals(e.getSource())) {
			Connection con;
			Statement sql,sql1;
			ResultSet rs,rs1;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "�������ݿ�ʧ�ܣ�");
			}
			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=��λ��������ϵͳ","sa","zhj15717333380");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				sql1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				if (b2.equals(e.getSource())) {

					for (int i = 0; i < 50; i++)
						for (int j = 0; j < 3; j++)
							table.setValueAt("", i, j);
					rs = sql.executeQuery("select Dno,Dname  from Department  where Department.Dno='"+tf1.getText()+"';");
					rs1 = sql1.executeQuery("select count(*) from Department,Worker  where   Department.Dno=Worker.Dno and  Department.Dno='"+tf1.getText()+"';");
					int k = -1;
					while (rs.next()&&rs1.next()) {

						++k;
					for(int i=1;i<3;i++)
						{
							String get_String=rs.getString(i);
							table.setValueAt(get_String, k, i-1);
						}
					float get_Float=rs1.getFloat(1);
					table.setValueAt(String.valueOf(get_Float), k, 2);
					}
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "��ѯʧ�ܣ�");
			}
		}

		if (b1.equals(e.getSource())) {// ��ѯȫ��
			Connection con;
			Statement sql,sql1;
			ResultSet rs,rs1;
			//Vector vector = new Vector();
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "�������ݿ�ʧ�ܣ�");
			}
			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=��λ��������ϵͳ","sa","zhj15717333380");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				sql1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				if (b1.equals(e.getSource())) {

					for (int i = 0; i < 50; i++)
						for (int j = 0; j < 3; j++)
							table.setValueAt("", i, j);
					rs = sql.executeQuery("select Dno,Dname from Department;");
					rs1 = sql1.executeQuery("select count(*) from Department,Worker  where   Department.Dno=Worker.Dno group by Worker.Dno;");
					int k = -1;
					while (rs.next() && rs1.next()) {

						++k;
					for(int i=1;i<3;i++)
						{
							String get_String=rs.getString(i);
							table.setValueAt(get_String, k, i-1);
						}
					float get_Float=rs1.getFloat(1);
					table.setValueAt(String.valueOf(get_Float), k, 2);
					}
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "��ѯʧ�ܣ�");
			}
		}

		if (b5.equals(e.getSource())) {
			Manager_WorkInformation gl=new Manager_WorkInformation();
			gl.create();
			f.dispose();

		}
	}
}