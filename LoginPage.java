package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import alumni.Admin;
import alumni.Operator;

public class LoginPage implements ActionListener {
	
	JFrame frame=null;
	JLabel label=null;
	JLabel label1=null;
	JLabel u_name=null;
	JLabel u_pass=null;
	JLabel u_role=null;
	JTextField nameField=null;
	JPasswordField passField=null;
	JComboBox<String> roleField=null;
	JButton button=null;
	
	public LoginPage(){
		frame=new JFrame("LOGIN PAGE");
		frame.setLayout(null);
		frame.setSize(1360,725);
		
		label=new JLabel("Jalpaiguri Government Engineering College");
		Font font = new Font("Serif", Font.BOLD, 50);
		label.setFont(font);
		label.setBounds(200,50,1000,70);
		
		label1=new JLabel("Alumni Management System");
		Font font1 = new Font("Serif", Font.ITALIC, 32);
		label1.setFont(font1);
		label1.setBounds(500,130,500,70);
		
		u_name=new JLabel("Username:");
		u_pass=new JLabel("Password:");
		u_role=new JLabel("Role:");
		nameField=new JTextField();
		passField=new JPasswordField();
		String[] r={"-----select-----","Admin","Operator"};
		roleField=new JComboBox<String>(r);
		button=new JButton("LOGIN");
		
		
		u_name.setBounds(500, 250, 100, 30);
		nameField.setBounds(600, 250, 150, 30);
		
		u_pass.setBounds(500, 300, 100, 30);
		passField.setBounds(600,300 , 150, 30);
		
		u_role.setBounds(500, 350, 100, 30);
		roleField.setBounds(600,350,150,30);
		
		button.setBounds(600, 400, 80, 30);
		button.addActionListener(this);
		
		
		frame.add(label);
		frame.add(label1);
		frame.add(u_name);
		frame.add(nameField);
		frame.add(u_pass);
		frame.add(passField);
		frame.add(u_role);
		frame.add(roleField);
		frame.add(button);
		
		frame.getContentPane().setBackground(Color.WHITE);
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/hp lappy/Desktop/amsproject/1.jpg"));
		
		ImageImplement panel = new ImageImplement(new ImageIcon("C:/Users/hp lappy/Desktop/amsproject/1.jpg").getImage());
		panel.setBounds(0,0,1360,725);
		frame.add(panel);
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==button){
			String uname = nameField.getText();
			String password = passField.getText();
			String role = (String)roleField.getSelectedItem();
			
			User user=new User(uname,password,role);
			
			int a=user.login();
			
			if(a==1){
				new Admin();
				frame.dispose();
			}
			else if(a==2){
				new Operator();
				frame.dispose();
			}
			else{
				JOptionPane.showMessageDialog(frame, "Invalid User..!");
				frame.dispose();
				new LoginPage();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginPage();
	}

}
