package alumni;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.TextField;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewOneAlumni implements ActionListener{
	
	JFrame frame=null;
	JLabel label=null;
	JLabel companyLabel=null;
	JLabel instituteLabel=null;
	
	JLabel yearLabel=null;
	JLabel workLabel=null;
	JLabel worklocationLabel=null;
	JComboBox<String> wnameField=null;
	
	JComboBox<String> yearField=null;
	JTextField workField=null;
	JComboBox<String> workbox=null;
	JComboBox<String> worklocationField=null;
	JButton submit=null;
	JButton back=null;
	String name="";
	public ViewOneAlumni() {
		// TODO Auto-generated constructor stub
		initialize();
	}
	public void initialize(){
		frame=new JFrame("VIEW ALUMNI");
		frame.setLayout(null);
		frame.setSize(1360, 725);
		
		label=new JLabel("Enter the following:");
		Font font=new Font("Serif", Font.ITALIC, 34);
		label.setFont(font);
		label.setBounds(540,50,320,70);
		
		yearLabel=new JLabel("Year Of Passing :");
		yearLabel.setBounds(200,150,150,30); 
		
		int k1=0;
		try{
			Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select distinct year from alumni");
				while(rs.next())
				{
					k1++;		
					
				}
		}
		
		catch(Exception e1){
			JOptionPane.showMessageDialog(frame, "Some Problem Ocurred!");
			System.out.println(e1);
		}
		String r1[]=new String[k1+1];
		r1[0]="-----select-----";
		int c1=1;
		try{
			Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select distinct year from alumni order by year");
				while(rs.next())
				{
					r1[c1++]=rs.getString(1);		
					
				}
			}
		
		catch(Exception e1){
			JOptionPane.showMessageDialog(frame, "Some Problem Ocurred!");
			System.out.println(e1);
		}
		yearField=new JComboBox<String>(r1); 
		yearField.setBounds(350,150,250,30);
		

		workLabel=new JLabel("Works in :");
		workLabel.setBounds(200,200,150,30);
		

		String[] r={"-----select-----","Company","Institute","Others"};
		workbox=new JComboBox<String>(r);
		workbox.setBounds(350, 200, 250, 30);
		workbox.addActionListener(this);
		
		worklocationLabel= new JLabel("Work Location :");
		worklocationLabel.setBounds(200,250,150,30);
		
		int k2=0;
		try{
			Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select distinct worklocation from alumni");
				while(rs.next())
				{
					k2++;		
					
				}
		}
		
		catch(Exception e1){
			JOptionPane.showMessageDialog(frame, "Some Problem Ocurred!");
			System.out.println(e1);
		}
		String r2[]=new String[k2+1];
		r2[0]="-----select-----";
		int c2=1;
		try{
			Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select distinct worklocation from alumni order by worklocation");
				while(rs.next())
				{
					r2[c2++]=rs.getString(1);		
					
				}
			}
		
		catch(Exception e1){
			JOptionPane.showMessageDialog(frame, "Some Problem Ocurred!");
			System.out.println(e1);
		}
		worklocationField= new JComboBox<String>(r2);
		worklocationField.setBounds(350,250,250,30);
		
		submit=new JButton("Submit");
		submit.setBounds(600,600,150,30);
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String year=(String)yearField.getSelectedItem();
				String worksin=(String)workbox.getSelectedItem();
				String wname="";
				if(worksin!="-----select-----"){
					wname=(String)wnameField.getSelectedItem();
				}
				String worklocation=(String)worklocationField.getSelectedItem();
				if(year.isEmpty() && worklocation.isEmpty()){
					if( worksin.equals("-----select-----")){
					JOptionPane.showMessageDialog(frame, "Please enter the details!");
					new ViewOneAlumni();
					}
				}
				else{
					
					new ViewAlum(year,worksin,wname,worklocation);
				}
				frame.dispose();
			}
		});
		
		back=new JButton("Back");
		back.setBounds(50,650,150,30);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminAlumni();
				frame.dispose();
			}
		});
		
		frame.add(label);
		
		frame.add(yearLabel);
		frame.add(yearField);
		frame.add(workLabel);
		frame.add(workbox);
		frame.add(worklocationLabel);
		frame.add(worklocationField);
	    frame.add(submit);
		frame.add(back);
		
		frame.setVisible(true);;
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
	}
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	int k=0;
	JComboBox<String> cb=(JComboBox<String>)e.getSource();
	name=(String)cb.getSelectedItem();
	try{
		Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		Statement stmt=con.createStatement();

		ResultSet rs=stmt.executeQuery("select wname from alumni where worksin='"+name+"'");
			while(rs.next())
			{
				k++;		
				
			}
	}
	
	catch(Exception e1){
		JOptionPane.showMessageDialog(frame, "Some Problem Ocurred!");
		System.out.println(e1);
	}
	String w[]=new String[k];
	int c=0;
	try{
		Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		Statement stmt=con.createStatement();

		ResultSet rs=stmt.executeQuery("select wname from alumni where worksin='"+name+"'");
			while(rs.next())
			{
				w[c++]=rs.getString(1);		
				
			}
			}
	
	catch(Exception e1){
		JOptionPane.showMessageDialog(frame, "Some Problem Ocurred!");
		System.out.println(e1);
	}
	wnameField=new JComboBox<String>(w);
	wnameField.setBounds(650, 200, 250, 30);		
	frame.add(wnameField);
	return;
}
	
	
}

