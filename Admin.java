package alumni;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import alumni.AdminAlumni;

public class Admin implements ActionListener{
	
	JFrame frame=null;
	JLabel label=null;
	JButton alumni=null;
	
	public Admin()
	{
		frame=new JFrame("Admin's Page");
		frame.setLayout(null);
		frame.setSize(1360, 725);
		
		label=new JLabel("Welcome...Admin!");
		Font font = new Font("Serif", Font.ITALIC, 34);
		label.setFont(font);
		label.setBounds(500,150,320,70);
		
		alumni=new JButton("Alumni Database");
		alumni.setBounds(500, 380, 250, 60);
		alumni.addActionListener(this);
		
		frame.add(label);
		frame.add(alumni);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==alumni){
			new AdminAlumni();
			frame.dispose();
		}
	}
	
}
