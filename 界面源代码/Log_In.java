//��½����
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
class Log_In extends JFrame implements ActionListener 
{
	ImageIcon im = new ImageIcon("D:\\2.png");
	JLabel a2 = new JLabel(im);
	JFrame frame = new JFrame("ְ��/����Ա��½");
	JLabel label1 = new JLabel("�û���");
	JLabel label2 = new JLabel("����");
	JButton logonButton1 = new JButton("����Ա��¼");
	JButton logonButton2 = new JButton("ְ����¼");
	JButton cancelButton = new JButton("�˳�");
	JTextField username = new JTextField(10);
	JPasswordField password = new JPasswordField(20);
	static String t1;
	static String t2;
	void create() 
	{
		JPanel p = (JPanel) frame.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(a2);
		p.add(label1);
		p.setSize(5, 5);
		p.setLocation(4, 8);
		p.add(username);
		p.setSize(100, 200);
		p.setLocation(800,800);
		p.add(label2);
		p.setSize(50, 20);
		p.setLocation(40, 80);
		p.add(password);
		p.setSize(100, 20);
		p.setLocation(80,120);
		p.add(logonButton1);
		p.add(logonButton2);
		p.add(cancelButton);
		p.setBackground(Color.cyan);
		p.setVisible(true);
		logonButton1.addActionListener(this);
		logonButton2.addActionListener(this);
		cancelButton.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setBounds(200, 100, 600, 300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		t1 = username.getText();
		t2 = password.getText();
		if(e.getSource()==logonButton1)
		{  try{ Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=��λ��������ϵͳ",t1,t2);
				JOptionPane.showMessageDialog(this, "��¼�ɹ���");
				Manager_Feature_Selection gz = new Manager_Feature_Selection ();
				gz.create();
				frame.dispose();
			  } 
			catch(Exception e1){
				JOptionPane.showMessageDialog(null, "�����û������������");
			                }

		}
		if (e.getSource()==logonButton2)
		{
			try {
				Connection con;
				Statement ps;
				ResultSet rs;
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=��λ��������ϵͳ","sa","zhj15717333380"); 
				ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery("select Wno,secret from Secret where Wno='"+t1+"';");
				if(rs.next())
				{   
				
					if(rs.getString("secret").trim().equals(t2) && rs.getString("Wno").trim().equals(t1))
					{
						
						User_Feature_Selection yg= new User_Feature_Selection();
						yg.create();
						frame.dispose();
						JOptionPane.showMessageDialog(this, "��¼�ɹ���");
						this.dispose();
					}
					else JOptionPane.showMessageDialog(this, "�������");
				
				}
				else {

					JOptionPane.showMessageDialog(this, "�û��������ڣ�");
				      }
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (cancelButton.equals(e.getSource())) // �˳�

		{
			System.exit(0);
		}
	}
}
