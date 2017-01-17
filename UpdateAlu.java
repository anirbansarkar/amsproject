package alumni;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class UpdateAlu implements ActionListener{
	
	JFrame frame=null;
	JLabel label=null;
	JLabel idLabel=null;
	JLabel yearLabel=null;
	JLabel nameLabel=null;
	JLabel contactLabel=null;
	JLabel workLabel=null;
	JLabel wnameLabel=null;
	JLabel location=null;
	JLabel designationLabel=null;
	JLabel emailidLabel=null;
	JTextField idField=null;
	JTextField yearField=null;
	JTextField nameField=null;
	JTextField contactField=null;
	JTextField workField=null;
	JTextField wnameField=null;
	JTextField worklocationField=null;
	JTextField designationField=null;
	JTextField emailidField=null;
	
	JButton submit=null;
	JButton back=null;
	String alumid=null;

	public UpdateAlu(String aluid, String year, String name, String contact, String worksin, String wname,String worklocation, String designation, String emailid) {
		// TODO Auto-generated constructor stub
		frame=new JFrame("UPDATE ALUMNI");
		frame.setLayout(null);
		frame.setSize(1360, 725);
		
		label=new JLabel("Update if required:");
		Font font=new Font("Serif", Font.ITALIC, 22);
		label.setFont(font);
		label.setBounds(140,30,320,70);
		
		idLabel=new JLabel("Alumni id :");
		idLabel.setBounds(50,100, 100, 30);
				
		idField=new JTextField();
		idField.setBounds(200,100, 250, 30);
		idField.setText(aluid);
		
		yearLabel=new JLabel("Year Of Passing :");
		yearLabel.setBounds(50, 140, 150, 30);
		
		yearField=new JTextField();
		yearField.setBounds(200, 140, 250, 30);
		yearField.setText(year);
		
		nameLabel=new JLabel("Name :");
		nameLabel.setBounds(50, 180, 100, 30);
		
		nameField=new JTextField();
		nameField.setBounds(200, 180, 250, 30);
		nameField.setText(name);
		
		contactLabel=new JLabel("Contact :");
		contactLabel.setBounds(50, 220, 100, 30);
		
		contactField=new JTextField();
		contactField.setBounds(200, 220, 250, 30);
		contactField.setText(contact);
		
		workLabel=new JLabel("Works in:");
		workLabel.setBounds(50,260,100,30);

		workField=new JTextField();
		workField.setBounds(200,260,250,30);
		workField.setText(worksin);
		
		wnameField=new JTextField();
		wnameField.setBounds(500, 260, 250, 30);
		wnameField.setText(wname);
				
		
		location=new JLabel("Work Location :");
		location.setBounds(50,300,100,30);
		
		
		worklocationField=new JTextField();
		worklocationField.setBounds(200, 300, 250, 30);
		worklocationField.setText(worklocation);
		
		
		designationLabel=new JLabel("Designation :");
		designationLabel.setBounds(50,340,150,30);
		
		designationField=new JTextField();
		designationField.setBounds(200,340,250,30);
		designationField.setText(designation);
		
		emailidLabel=new JLabel("Email id :");
		emailidLabel.setBounds(50,380,150,30);
		
		emailidField=new JTextField();
		emailidField.setBounds(200,380,250,30);
		emailidField.setText(emailid);
				
		
		submit=new JButton("Submit");
		submit.setBounds(200,500,100,30);
		submit.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(50,600,100,30);
		back.addActionListener(this);
		
		frame.add(label);
		frame.add(idField);
		frame.add(idLabel);
		frame.add(yearLabel);
		frame.add(yearField);
		frame.add(nameLabel);
		frame.add(nameField);
		frame.add(contactLabel);
		frame.add(contactField);
		frame.add(workLabel);
		frame.add(workField);
		frame.add(wnameField);
		frame.add(location);
		frame.add(worklocationField);
		frame.add(designationLabel);
		frame.add(designationField);
		frame.add(emailidLabel);
		frame.add(emailidField);
		frame.add(submit);
		frame.add(back);
		
		alumid=aluid;
		
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
			String aluid=idField.getText();
			String year=yearField.getText();
			String name=nameField.getText();
			String contact=contactField.getText();
			String worksin=workField.getText();
			String wname=wnameField.getText();
			String designation=designationField.getText();
			String emailid=emailidField.getText();
			if(aluid.isEmpty() || year.isEmpty() || name.isEmpty() || 
					contact.isEmpty() || worksin.isEmpty() || wname.isEmpty() || designation.isEmpty() || emailid.isEmpty()){
				JOptionPane.showMessageDialog(frame,"Enter the details correctly!");
			}
			else{
				try{
					Connection con=DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					Statement stmt=con.createStatement();

					stmt.executeQuery("update alumni set aluid='"+aluid+"',year='"+
							year+"',name='"+name+"',contact='"+contact+"',worksin='"+worksin+"',"
									+ "wname='"+wname+"',designation='"+designation+"',emailid='"+emailid+"' where aluid='"+alumid+"'");
					JOptionPane.showMessageDialog(frame,"Updated successfully!");
					frame.dispose();
					new OperatorAlumni();
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(frame,"Some error has occcured!");
					System.out.println(e1);
				}
			}
		}
	}
	
}

