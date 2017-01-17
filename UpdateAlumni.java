package alumni;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class UpdateAlumni implements ActionListener{
	
	JFrame frame=null;
	JLabel label=null;
	JLabel idLabel=null;
	JTextField idField=null;
	JButton submit=null;
	JButton back=null;
	
	public UpdateAlumni() {
		// TODO Auto-generated constructor stub
		frame=new JFrame("UPDATE ALUMNI");
		frame.setLayout(null);
		frame.setSize(1360, 725);
		
		label=new JLabel("Enter the following:");
		Font font=new Font("Serif", Font.ITALIC, 34);
		label.setFont(font);
		label.setBounds(540,50,320,70);
		
		idLabel=new JLabel("Alumni Id :");
		idLabel.setBounds(450, 150, 100, 30);
		
		idField=new JTextField();
		idField.setBounds(550, 150, 250, 30);
		
		submit=new JButton("Submit");
		submit.setBounds(500,550,100,30);
		submit.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(50,600,100,30);
		back.addActionListener(this);
		
		frame.add(label);
		frame.add(idLabel);
		frame.add(idField);
		frame.add(submit);
		frame.add(back);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back)
		{
			new OperatorAlumni();
			frame.dispose();
		}
		if(e.getSource()==submit){
			
			if(!(idField.getText().isEmpty())){
				try{
					String aluid=idField.getText();
					String year="",name="",contact="",company="",worksin="",wname="",worklocation="",designation="",emailid="";
					int count=0;
					Connection con=DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					Statement stmt=con.createStatement();
				
					ResultSet rs=stmt.executeQuery("select * from alumni where aluid='"+aluid+"'");
					while(rs.next())
					{
						count++;
						year=rs.getString(2);
						name=rs.getString(3);
						contact=rs.getString(4);
						worksin=rs.getString(5);
						wname=rs.getString(6);
						worklocation=rs.getString(7);
						designation=rs.getString(8);
						emailid=rs.getString(9);
					}
					con.close();
					if(count==0){
						JOptionPane.showMessageDialog(frame,"No such record found!");
						frame.dispose();
						new UpdateAlumni();
					}
					else{
						new UpdateAlu(aluid,year,name,contact,worksin,wname,worklocation,designation,emailid);
						frame.dispose();
					}
				}
				catch(Exception e1){
					System.out.println(e1);
				}
			}
			else{
				JOptionPane.showMessageDialog(frame,"Please enter the details!");
				frame.dispose();
				new UpdateAlumni();
			}
		}
		

		
	}

}
