import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class register extends JFrame implements ActionListener{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JButton b1,b2;
	JRadioButton rb1,rb2,rb3;
	JPasswordField p1;
	register(){
		lb1=new JLabel("User ID:");
		lb1.setBounds(20,50,200,30);
		lb2=new JLabel("User Name:");
		lb2.setBounds(20,80,200,30);
		lb3=new JLabel("Enter Password:");
		lb3.setBounds(20,110,200,30);
		lb4=new JLabel("Email ID:");
		lb4.setBounds(20,140,200,30);
		lb5=new JLabel("Contact Number:");
		lb5.setBounds(20,170,200,30);
		lb6=new JLabel("Postal Address:");
		lb6.setBounds(20,200,200,30);
		lb7=new JLabel("Gender:");
		lb7.setBounds(20,230,200,30);
		lb8=new JLabel("Qualification:");
		lb8.setBounds(20,260,200,30);
		lb9=new JLabel("Nationality:");
		lb9.setBounds(20,290,200,30);
		lb10=new JLabel("already have an Acoount? Try loggin in!");
		lb10.setBounds(20,500,250,30);
		tf1=new JTextField();
		tf1.setBounds(140,50,200,25);
		tf2=new JTextField();
		tf2.setBounds(140,80,200,25);
		p1=new JPasswordField();
		p1.setBounds(140,110,200,25);
		tf3=new JTextField();
		tf3.setBounds(140,140,200,25);		
		tf4=new JTextField();
		tf4.setBounds(140,170,200,25);
		tf5=new JTextField();
		tf5.setBounds(140,200,200,25);
		rb1=new JRadioButton("Female");
		rb1.setBounds(140,230,80,25);
		rb2=new JRadioButton("Male");
		rb2.setBounds(220,230,80,25);
		rb3=new JRadioButton("Other");
		rb3.setBounds(300,230,80,25);
		tf6=new JTextField();
		tf6.setBounds(140,260,200,25);
		tf7=new JTextField();
		tf7.setBounds(140,290,200,25);
		b1=new JButton("REGISTER");
		b1.setBounds(190,350,100,40);
		b2=new JButton("LOGIN");		
		b2.setBounds(250,500,100,40);
		b1.addActionListener(this);
		b2.addActionListener(this);
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(rb1);
		bg1.add(rb2);
		bg1.add(rb3);
		add(lb1);
		add(lb2);
		add(lb3);
		add(lb4);
		add(lb5);
		add(lb6);
		add(lb7);
		add(lb8);
		add(lb9);
		add(lb10);
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);
		add(tf6);
		add(tf7);
		add(p1);
		add(b1);
		add(b2);
		add(rb1);
		add(rb2);
		add(rb3);
		setSize(700,600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Registration Form in Java"); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) 
		{
		    String pass = p1.getText();
			String s="";
			if(rb1.isSelected())
			{
				s="female";
			}
			if(rb2.isSelected())
			{
				s="male";
			}
			if(rb3.isSelected())
			{
				s="other";
			}
			if(((rb1.isSelected()==false)&&(rb2.isSelected()==false)&&(rb3.isSelected()==false))||(tf1.getText().isEmpty())||(tf2.getText().isEmpty())||(tf3.getText().isEmpty())||(tf4.getText().isEmpty())||(tf5.getText().isEmpty())||(tf6.getText().isEmpty())||(tf7.getText().isEmpty())||(pass.isEmpty()))
			{
		       JOptionPane.showMessageDialog(this, "please fill all the fields!");
	        }
			
			try
			{
			String name = tf1.getText();
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/registration_and_login/f12.accdb");
			PreparedStatement st=con.prepareStatement("insert into UserTb" + "(u_id,u_name,u_password,u_email,u_contact,u_address,u_gender,u_qualifications,u_nationality)" + "values(?,?,?,?,?,?,?,?,?)");
			st.setString(1, tf1.getText());
			st.setString(2,tf2.getText());
			st.setString(3,p1.getText());
			st.setString(4,tf3.getText());
			st.setString(5,tf4.getText());
			st.setString(6,tf5.getText());
			st.setString(7,s);
			st.setString(8,tf6.getText());
			st.setString(9,tf7.getText());
			st.execute();
			JOptionPane.showMessageDialog(this, "Registration Succesfull!");
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf7.setText("");
			p1.setText("");
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			con.close();
			}
			catch(Exception h)
			{
				System.out.println(h);
			}
		}
		if(e.getSource()==b2) {
			new Ex2();
			dispose();
		}
		
	}
	public static void main(String args[]) {
		new register();
	}
}

class Ex2 extends JFrame implements ActionListener{
	JLabel lb1,lb2,lb3;
	JTextField tf1;
	JButton b1,b2,b3;
	JPasswordField p1;
	String name;
	Ex2(){
		lb1=new JLabel("User Name:");
		lb1.setBounds(20,50,200,20);
		lb2=new JLabel("Enter Password:");
		lb2.setBounds(20,100,200,20);
		lb3=new JLabel("Doesn't have an Acoount? Try Signing up!");
		lb3.setBounds(20,500,250,30);
		tf1=new JTextField();
		tf1.setBounds(140,50,200,30);
		p1=new JPasswordField();
		// p1=new JTextField();
		p1.setBounds(140,100,200,30);
		b1=new JButton("REGISTER");
		b1.setBounds(280,500,100,40);
		b2=new JButton("LOGIN");		
		b2.setBounds(200,163,100,40);
		b3=new JButton("FORGOT PASSWORD");		
		b3.setBounds(400,163,171,40);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		add(lb1);
		add(lb2);
		add(lb3);
		add(tf1);
		add(p1);
		add(b1);
		add(b3);

		add(b2);
		setSize(700,600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login Form in Java"); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			new register();
			dispose();
		}
		if(e.getSource()==b3) {
			new forgotPassword();
			dispose();
		}
		if(e.getSource()==b2) {
			String pass = p1.getText();
			// String pass = p1.getText();

			boolean a=tf1.getText().isEmpty();
			boolean b= p1.getText().isEmpty();
				if(a==true || b==true){
					JOptionPane.showMessageDialog(this, "please fill all the feilds!");
					System.out.println("inside if block of login page");
					// new Ex2();
					// dispose();
				}
			else{
				try
				{
				// System.out.println("inside else block of login page");
				// System.out.println("inside else try block of login page");
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/registration_and_login/f12.accdb");
				PreparedStatement st= con.prepareStatement("select * from UserTb where u_id=? and u_password=?");
				st.setString(1,tf1.getText());
				st.setString(2,pass);
				System.out.println(tf1.getText());
				System.out.println(pass);

				int f=0;
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					f=1;
				}
				if(f==1){
					System.out.println("Login Succesfull");
					new afterLogin(tf1.getText());
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(this, "Invalid User");

				}
				
				}
				catch(Exception h)
				{
				JOptionPane.showMessageDialog(this, "login Unsuccesfull!");
				System.out.println(h);
				}
			}
						
		}
		
	}
	
}
class forgotPassword extends JFrame implements ActionListener{
	JLabel lb1,lb2,lb3;
	JTextField tf1;
	JButton b1,b2;
	JPasswordField p1,p2;
	forgotPassword(){
		lb1=new JLabel("User Id:");
		lb1.setBounds(20,50,200,20);
		lb2=new JLabel("Enter Password:");
		lb2.setBounds(20,100,200,20);
		lb3=new JLabel("Confirm Password:");
		lb3.setBounds(20,150,200,20);
		tf1=new JTextField();
		tf1.setBounds(140,50,200,30);
		p1=new JPasswordField();
		p1.setBounds(140,100,200,30);
		p2=new JPasswordField();
		p2.setBounds(140,150,200,30);
		b1=new JButton("UPDATE");		
		b1.setBounds(200,200,100,40);
		b2=new JButton("BACK");		
		b2.setBounds(200,250,100,40);
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(lb1);
		add(lb2);
		add(lb3);
		add(tf1);
		add(p1);
		add(p2);
		add(b1);
		add(b2);

		setSize(700,600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Update Password Form in Java"); 
	}
@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2) {
			System.out.println("inside b2 block");
			new Ex2();
			dispose();
		}
		if(e.getSource()==b1) {
			String a=p1.getText();
			String b=p2.getText();
			// boolean c=stringCompare(a, b);
			if(a.equals(b)){
				try
				{					
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/registration_and_login/f12.accdb");
				PreparedStatement st1= con.prepareStatement("update UserTb set u_password=? where u_id=?");
				st1.setString(1,p1.getText());
				st1.setString(2,tf1.getText());
				st1.executeUpdate();
				// System.out.println(s);
					JOptionPane.showMessageDialog(this, "Password Updated");
					new Ex2();
					dispose();
				}
				catch(Exception h)
				{
					System.out.println(h);
				}
			}
			else{
					JOptionPane.showMessageDialog(this, "Password Didn't Match");
				}
		}
	}
}
class afterLogin extends JFrame implements ActionListener{
	JLabel lb1a ,lb2a;
	JButton b1a;
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb11,lb22,lb33,lb44,lb55,lb66,lb77,lbExtra;
	JButton b1,b2,b3,b4;
	afterLogin(String uId){
		
		lb1a=new JLabel("WELCOME");
		lb1a.setBounds(120,50,200,20);
		lb1a.setFont(new Font("Tahoma",Font.BOLD,14));
		lb2a=new JLabel();
		lb2a.setText(uId);
		lb2a.setBounds(120,70,200,20);
		b1a=new JButton("View Profile:");
		b1a.setBounds(280,100,150,40);
		b1a.addActionListener(this);
		lb1=new JLabel("Name:");
		lb1.setBounds(20,50,200,30);
		lb11=new JLabel("~~~~");
		lb11.setBounds(150,50,200,30);
		lb2=new JLabel("Email:");
		lb2.setBounds(20,80,200,30);
		lb22=new JLabel("~~~~");
		lb22.setBounds(150,80,200,30);
		lb3=new JLabel("Contact Number:");
		lb3.setBounds(20,110,200,30);
		lb33=new JLabel("~~~~");
		lb33.setBounds(150,110,200,30);
		lb4=new JLabel("Postal Address:");
		lb4.setBounds(20,140,200,30);
		lb44=new JLabel("~~~~");
		lb44.setBounds(150,140,200,30);
		lb5=new JLabel("Gender:");
		lb5.setBounds(20,170,200,30);
		lb55=new JLabel("~~~~");
		lb55.setBounds(150,170,200,30);
		lb6=new JLabel("Qualification:");
		lb6.setBounds(20,200,200,30);
		lb66=new JLabel("~~~~");
		lb66.setBounds(150,200,200,30);
		lb7=new JLabel("Nationality:");
		lb7.setBounds(20,230,200,30);
		lb77=new JLabel("~~~~");
		lb77.setBounds(150,230,200,30);
		b1=new JButton("Previous FeedBack");
		b1.setBounds(70,350,180,40);
		b2=new JButton("Give FeedBack");
		b2.setBounds(250,350,200,40);
		b3=new JButton("Update Profile");
		b3.setBounds(430,350,200,40);
		b4=new JButton("LogOut!");
		b4.setBounds(250,400,200,40);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		add(lb1a);
		add(lb2a);
		add(b1a);
		add(lb1);
		add(lb2);
		add(lb3);
		add(lb4);
		add(lb5);
		add(lb6);
		add(lb7);
		add(lb11);
		add(lb22);
		add(lb33);
		add(lb44);
		add(lb55);
		add(lb66);
		add(lb77);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		lb1.setVisible(false);
		lb2.setVisible(false);
		lb3.setVisible(false);
		lb4.setVisible(false);
		lb5.setVisible(false);
		lb6.setVisible(false);
		lb7.setVisible(false);
		lb11.setVisible(false);
		lb22.setVisible(false);
		lb33.setVisible(false);
		lb44.setVisible(false);
		lb55.setVisible(false);
		lb66.setVisible(false);
		lb77.setVisible(false);
		b1.setVisible(false);
		b2.setVisible(false);
		b3.setVisible(false);
		b4.setVisible(false);
		
		setSize(700,600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Welcome!"); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b3) {
			new updateProfile(lb2a.getText());
			dispose();
		}
		if(e.getSource()==b2) {
			new giveFeedBack(lb2a.getText());
			dispose();
		}
		if(e.getSource()==b1) {
			// -------------------------------------------------------------------------------------------------------
		// 	try{
		// 		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		// 		Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/registration_and_login/f12.accdb");
		// 		PreparedStatement st= con.prepareStatement("select * from FeedbackTb where u_id=?");
		// 		st.setString(1,lbExtra.getText());
		// 		int f=0;
		// 		ResultSet rs=st.executeQuery();
		// 		while(rs.next()){
		// 			f=1;
		// 		}
		// 		if(f==0){
		// 			JOptionPane.showMessageDialog(this, "NO FEEDBACK SUBMITTED YET");
		// 			new afterLogin(lbExtra.getText());
		// 			dispose();
		// 			// lb2.setText("NO FEEDBACK SUBMITTED YET")
		// 		}
		// 		if(f==1){
		// 			new viewFeedBack(lb2a.getText());
		// 			// lb2.setText(rs.getString(2));
		// 		}
		// 		// System.out.println("view feedback Succesfull");
				
		// }catch(Exception h)
		// 	{
		// 		System.out.println(h);
		// 	}
		new viewFeedBack(lb2a.getText());
			dispose();
		}
		if(e.getSource()==b4) {
			new Ex2();
			dispose();
		}
	
		if(e.getSource()==b1a) {
		lb1a.setVisible(false);
		lb2a.setVisible(false);
		b1a.setVisible(false);
		lb1.setVisible(true);
		lb2.setVisible(true);
		lb3.setVisible(true);
		lb4.setVisible(true);
		lb5.setVisible(true);
		lb6.setVisible(true);
		lb7.setVisible(true);
		lb11.setVisible(true);
		lb22.setVisible(true);
		lb33.setVisible(true);
		lb44.setVisible(true);
		lb55.setVisible(true);
		lb66.setVisible(true);
		lb77.setVisible(true);
		b1.setVisible(true);
		b2.setVisible(true);
		b3.setVisible(true);
		b4.setVisible(true);
		
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/registration_and_login/f12.accdb");
				PreparedStatement st= con.prepareStatement("select * from UserTb where u_id=?");
				st.setString(1,lb2a.getText());
				ResultSet rs=st.executeQuery();
				while(rs.next()){
				lb11.setText(rs.getString(1));
				lb22.setText(rs.getString(3));
				lb33.setText(rs.getString(9));
				lb44.setText(rs.getString(4));
				lb55.setText(rs.getString(5));
				lb66.setText(rs.getString(6));
				lb77.setText(rs.getString(7));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(8));
				}
				System.out.println("view Succesfull");
		}
		catch(Exception h)
			{
				System.out.println(h);
			}
		
		
			
		}
		
		
	}
	
}

class updateProfile extends JFrame implements ActionListener{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lbExtra;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JButton b1,b2;
	updateProfile(String uId){
		lb1=new JLabel("Name:");
		lb1.setBounds(20,50,200,30);
		lbExtra=new JLabel();
		lbExtra.setText(uId);
		tf1=new JTextField("");
		tf1.setBounds(150,50,200,30);
		lb2=new JLabel("Email:");
		lb2.setBounds(20,80,200,30);
		tf2=new JTextField("");
		tf2.setBounds(150,80,200,30);
		lb3=new JLabel("Contact Number:");
		lb3.setBounds(20,110,200,30);
		tf3=new JTextField("");
		tf3.setBounds(150,110,200,30);
		lb4=new JLabel("Postal Address");
		lb4.setBounds(20,140,200,30);
		tf4=new JTextField("");
		tf4.setBounds(150,140,200,30);
		lb5=new JLabel("Gender");
		lb5.setBounds(20,170,200,30);
		tf5=new JTextField("");
		tf5.setBounds(150,170,200,30);
		lb6=new JLabel("Qualification");
		lb6.setBounds(20,200,200,30);
		tf6=new JTextField("");
		tf6.setBounds(150,200,200,30);
		lb7=new JLabel("Nationality");
		lb7.setBounds(20,230,200,30);
		tf7=new JTextField("");
		tf7.setBounds(150,230,200,30);
		b1=new JButton("Done");
		b1.setBounds(70,350,180,40);
		b1.addActionListener(this);
		b2=new JButton("Get Previous Data");
		b2.setBounds(70,400,180,40);
		b2.addActionListener(this);
		add(lb1);
		add(lb2);
		add(lb3);
		add(lb4);
		add(lb5);
		add(lb6);
		add(lb7);
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);
		add(tf6);
		add(tf7);
		add(b1);
		add(b2);
		setSize(700,600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Update Profile");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			if((tf1.getText().isEmpty())||(tf2.getText().isEmpty())||(tf3.getText().isEmpty())||(tf4.getText().isEmpty())||(tf5.getText().isEmpty())||(tf6.getText().isEmpty())||(tf7.getText().isEmpty()))
			{
		       JOptionPane.showMessageDialog(this, "please fill all the feilds!");
	        }
			else{
				try
				{					
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/registration_and_login/f12.accdb");
				PreparedStatement st1= con.prepareStatement("update UserTb set u_name=?,u_email=?,u_contact=?, u_address=?,u_gender=?,u_qualifications=?, u_nationality=? where u_id=?");
				st1.setString(1,tf1.getText());
				st1.setString(2,tf2.getText());
				st1.setString(3,tf3.getText());
				st1.setString(4,tf4.getText());
				st1.setString(5,tf5.getText());
				st1.setString(6,tf6.getText());
				st1.setString(7,tf7.getText());
				st1.setString(8,lbExtra.getText());
				st1.executeUpdate();
				// System.out.println(s);
				}
				catch(Exception h)
				{
					System.out.println(h);
				}
				new afterLogin(lbExtra.getText());
				dispose();
			}
		}
		if(e.getSource()==b2){
		
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/registration_and_login/f12.accdb");
				PreparedStatement st= con.prepareStatement("select * from UserTb where u_id=?");
				st.setString(1,lbExtra.getText());
				ResultSet rs=st.executeQuery();
				while(rs.next()){
				tf1.setText(rs.getString(1));
				tf2.setText(rs.getString(3));
				tf3.setText(rs.getString(9));
				tf4.setText(rs.getString(4));
				tf5.setText(rs.getString(5));
				tf6.setText(rs.getString(6));
				tf7.setText(rs.getString(7));
				}
				//JOptionPane.showMessageDialog(this, "login Succesfull!");
				System.out.println("view Succesfull");
				//new afterLogin(tf1.getText(),pass);
				//dispose();
		}
		catch(Exception h)
			{
				System.out.println(h);
			}
			
		}
		
	}
}
class giveFeedBack extends JFrame implements ActionListener{
	JTextArea ta;
	JButton b1,b2;
	JLabel lb1,lbExtra;
	giveFeedBack(String uId){
		lb1=new JLabel("Enter FeedBack:");
		lb1.setBounds(150,30,200,30);
		lbExtra=new JLabel();
		lbExtra.setText(uId);
		ta=new JTextArea();
		ta.setBounds(150,65,300,300);
		b1=new JButton("Submit");
		b1.setBounds(200,365,180,40);
		b2=new JButton("Back");
		b2.setBounds(200,410,180,40);
		b1.addActionListener(this);	
		b2.addActionListener(this);
		add(ta);
		add(b1);
		add(b2);
		add(lb1);
		setSize(700,600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Submit FeedBack");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			if(ta.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "please fill the fields!");
			}
			else
			{
			try
			{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/registration_and_login/f12.accdb");
			PreparedStatement st=con.prepareStatement("insert into FeedbackTb" + "(u_id,f_message,f_datetime,f_flagbit)" + "values(?,?,?,?)");
			// st.setString(1,"");
			st.setString(1, lbExtra.getText());
			st.setString(2,ta.getText());
			st.setString(3,"date");
			st.setString(4,"flagbit");
			st.execute();
			JOptionPane.showMessageDialog(this, "FeedBackSubmitted");
			con.close();
			}
			catch(Exception h)
			{
				System.out.println(h);
			}
			new afterLogin(lbExtra.getText());
			dispose();
			}
		}
		if(e.getSource()==b2) {
			new afterLogin(lbExtra.getText());
			dispose();
		}
		
	}
	
}
class viewFeedBack extends JFrame implements ActionListener{
	JButton b1,b2;
	JLabel lb1,lb2,lbExtra;
	viewFeedBack(String uId){
		lb1=new JLabel("Your Previous FeedBack:");
		lb1.setBounds(150,30,200,30);
		lbExtra= new JLabel();
		lbExtra.setText(uId);
		lb2=new JLabel();
		lb2.setBounds(150,65,300,300);
		b1=new JButton("Back");
		b1.setBounds(200,365,180,40);
		b1.addActionListener(this);
		b2=new JButton("Tap Here To View Previous FeedBack ");
		b2.setBounds(200,315,180,40);
		b2.addActionListener(this);
		add(b1);
		add(b2);
		add(lb1);
		add(lb2);
		setSize(700,600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Submit FeedBack");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			new afterLogin(lbExtra.getText());
			dispose();
		}	
		if(e.getSource()==b2){
			try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/registration_and_login/f12.accdb");
				PreparedStatement st= con.prepareStatement("select f_message from FeedbackTb where u_id=?");
				st.setString(1,lbExtra.getText());
				int f=0;
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					f=1;
					lb2.setText(rs.getString(1));
				}
				if(f==0){
					JOptionPane.showMessageDialog(this, "NO FEEDBACK SUBMITTED YET");
					new afterLogin(lbExtra.getText());
					dispose();
				}
				
				System.out.println("view feedback Succesfull");
				
		}
		catch(Exception h)
			{
				System.out.println(h);
			}
		}
	}	
}