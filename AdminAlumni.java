package alumni;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import alumni.Admin;

public class AdminAlumni implements ActionListener{

	JFrame frame=null;
	JLabel label=null;
	JButton viewall=null;
	JButton viewone=null;
	JButton delete=null;
	JButton back=null;
	
	public AdminAlumni() {
		// TODO Auto-generated constructor stub
		frame=new JFrame("Alumni");
		frame.setLayout(null);
		frame.setSize(1360, 725);
		
		label=new JLabel("Select an operation:");
		Font font=new Font("Serif", Font.ITALIC, 34);
		label.setFont(font);
		label.setBounds(500,50,320,70);
		
		viewall=new JButton("View all Alumni");
		viewall.setBounds(500,150,250,30);
		viewall.addActionListener(this);
		
		viewone=new JButton("View Alumni based on conditions");
		viewone.setBounds(500,190,250,30);
		viewone.addActionListener(this);
		
		delete=new JButton("Delete Particular Alumni");
		delete.setBounds(500,230,250,30);
		delete.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(50,600,100,30);
		back.addActionListener(this);
		
		frame.add(label);
		frame.add(viewall);
		frame.add(viewone);
		frame.add(delete);
		frame.add(back);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back){
			new Admin();
			frame.dispose();
		}
		if(e.getSource()==viewall){
			new ViewAllAlumni(1);
			frame.dispose();
		}
		if(e.getSource()==viewone){
			new ViewOneAlumni();
			frame.dispose();
		}
		if(e.getSource()==delete){
			new DeleteAlumni();
			frame.dispose();
		}
	}

}
