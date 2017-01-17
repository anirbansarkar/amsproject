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


public class DeleteAlumni implements ActionListener{
	
	JFrame frame=null;
	JLabel label=null;
	JLabel alumLabel=null;
	JTextField alumField=null;
	JButton submit=null;
	JButton back=null;
	
	public DeleteAlumni() {
		// TODO Auto-generated constructor stub
		frame=new JFrame("DELETE ALUMNI");
		frame.setLayout(null);
		frame.setSize(1360, 725);
		
		label=new JLabel("Enter the following:");
		Font font=new Font("Serif", Font.ITALIC, 34);
		label.setFont(font);
		label.setBounds(500,50,320,70);
		
		alumLabel=new JLabel("Alumni id :");
		alumLabel.setBounds(400, 250, 100, 30);
		
		alumField=new JTextField();
		alumField.setBounds(500, 250, 250, 30);
		
		submit=new JButton("Submit");
		submit.setBounds(600,500,100,30);
		submit.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(50,600,100,30);
		back.addActionListener(this);
		
		frame.add(label);
		frame.add(alumField);
		frame.add(alumLabel);
		frame.add(submit);
		frame.add(back);
		
		frame.setVisible(true);;
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit){
			String aluid=alumField.getText();
			if(aluid.isEmpty()){
				JOptionPane.showMessageDialog(frame,"Please enter the details!");
				frame.dispose();
				new DeleteAlumni();
			}
			else{
				try{
					
					int count=0;
					Connection con=DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe","system","1234");
					Statement stmt=con.createStatement();

					ResultSet rs=stmt.executeQuery("select * from alumni where aluid='"+aluid+"'");
					while(rs.next())
					{
						count++;
					}
					con.close();
					if(count==0){
						JOptionPane.showMessageDialog(frame,"No such record found!");
						frame.dispose();
						new DeleteAlumni();
					}
					else{
						Connection con1=DriverManager.getConnection(
								"jdbc:oracle:thin:@localhost:1521:xe","system","1234");
						Statement stmt1=con1.createStatement();

						stmt1.executeQuery("delete from alumni where aluid='"+aluid+"'");
						JOptionPane.showMessageDialog(frame, "Successfully Deleted...!");
						frame.dispose();
						new DeleteAlumni();
					}				
				}
				catch(Exception e1){ 
					JOptionPane.showMessageDialog(frame,"No such record found!");
				}
				frame.dispose();
				new DeleteAlumni();
			}
		}
		if(e.getSource()==back)
		{
			new AdminAlumni();
			frame.dispose();
		}
	}

}

