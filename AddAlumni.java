package alumni;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddAlumni implements ActionListener{

	JFrame frame=null;
	JLabel label=null;
	JLabel yearLabel=null;
	JLabel nameLabel=null;
	JLabel contactLabel=null;
	JLabel workLabel=null;
	JLabel worklocation=null;
	JLabel designation=null;
	JLabel emailid=null;
	JTextField yearField=null;
	JTextField nameField=null;
	JTextField contactField=null;
	JComboBox<String> workbox=null;
	JTextField wnameField=null;
	JTextField worklocationField=null;
	JTextField designationField=null;
	JTextField emailidField=null;
	
	JButton submit=null;
	JButton back=null;
	//private JLabel worklocationJLabel;
	int c=0;
	
	public AddAlumni() {
		// TODO Auto-generated constructor stub
		frame=new JFrame("ADD ALUMNI");
		frame.setLayout(null);
		frame.setSize(1360, 725);
		
		label=new JLabel("Enter the following:");
		Font font=new Font("Serif", Font.ITALIC, 22);
		label.setFont(font);
		label.setBounds(300,30,320,70);
		
		yearLabel=new JLabel("Year Of Passing :");
		yearLabel.setBounds(250, 140, 100, 30);
		
		yearField=new JTextField();
		yearField.setBounds(350, 140, 250, 30);
		
		nameLabel=new JLabel("Name :");
		nameLabel.setBounds(250, 180, 100, 30);
		
		nameField=new JTextField();
		nameField.setBounds(350, 180, 250, 30);
		
		contactLabel=new JLabel("Contact :");
		contactLabel.setBounds(250, 220, 100, 30);
		
		contactField=new JTextField();
		contactField.setBounds(350, 220, 250, 30);
		
		workLabel=new JLabel("Works in:");
		workLabel.setBounds(250,260,100,30);
		
		worklocation=new JLabel("Work Location :");
		worklocation.setBounds(250, 300, 150, 30);
		
		worklocationField=new JTextField();
		worklocationField.setBounds(350, 300, 250, 30);
		
		designation=new JLabel("Designation :");
		designation.setBounds(250,340,150,30);
		
		designationField=new JTextField();
		designationField.setBounds(350,340,250,30);
		
		emailid=new JLabel("Email id :");
		emailid.setBounds(250,380,150,30);
		
		emailidField=new JTextField();
		emailidField.setBounds(350,380,250,30);
		
		String[] r={"-----select-----","Company","Institute","Others"};
		workbox=new JComboBox<String>(r);
		workbox.setBounds(350, 260, 250, 30);
		wnameField=new JTextField();
		wnameField.setBounds(630, 260, 250, 30);
					
		frame.add(wnameField);
					
		submit=new JButton("Submit");
		submit.setBounds(350,600,100,30);
		submit.addActionListener(this);
				
		back=new JButton("Back");
		back.setBounds(50,650,100,30);
		back.addActionListener(this);
		
		frame.add(label);
		frame.add(yearLabel);
		frame.add(yearField);
		frame.add(nameLabel);
		frame.add(contactLabel);
		frame.add(contactField);
		frame.add(nameField);
		frame.add(workLabel);
		frame.add(workbox);
		frame.add(worklocation);
		frame.add(worklocationField);
		frame.add(designation);
		frame.add(designationField);
		frame.add(emailid);
		frame.add(emailidField);
		submit=new JButton("Submit");
		submit.setBounds(350,600,100,30);
		submit.addActionListener(this);
		frame.add(submit);
		frame.add(back);
		
		frame.setVisible(true);;
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back){
			new OperatorAlumni();
			frame.dispose();
		}
		if(e.getSource()==submit){
			String year=yearField.getText();
			String name=nameField.getText();
			String contact=contactField.getText();
			String worksin=(String)workbox.getSelectedItem();
			String wname=wnameField.getText();
			String worklocation=worklocationField.getText();
			String designation=designationField.getText();
			String emailid=emailidField.getText();
			if(year.isEmpty() || name.isEmpty() || 
					contact.isEmpty() || worksin.equals("-----select-----") || wname.isEmpty() || worklocation.isEmpty() || designation.isEmpty() || emailid.isEmpty() ){
				JOptionPane.showMessageDialog(frame,"Enter the details correctly!");
			}
			else{
				try{
					Connection con=DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					Statement stmt=con.createStatement();

					ResultSet rs=stmt.executeQuery("select aluid from alumni");
					while(rs.next())
					{
						String yr=rs.getString(1).substring(0,4);
						if(yr.equals(year))
							c++;
						
					}
					c++;
					String aluid;
					if(c<=9)
						aluid=year+"0"+c;
					else
						aluid=year+c;
					stmt.executeQuery("insert into alumni values('"+aluid+"','"+year+"','"+name+"','"+contact+"','"+worksin+"','"+wname+"','"+
						worklocation+"','"+designation+"','"+emailid+"')");
					JOptionPane.showMessageDialog(frame,"Alumni added successfully!");
					System.out.println("1");
					frame.dispose();
					new OperatorAlumni();
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(frame,"Some error has occcured!");
					new AddAlumni();
				}
			}
		}
	}

}

