package alumni;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import alumni.Operator;

public class OperatorAlumni implements ActionListener{

	JFrame frame=null;
	JLabel label=null;
	JButton viewall=null;
	JButton add=null;
	JButton update=null;
	JButton back=null;
	
	public OperatorAlumni() {
		// TODO Auto-generated constructor stub
		frame=new JFrame("ALUMNI");
		frame.setLayout(null);
		frame.setSize(1360, 725);
		
		label=new JLabel("Select an operation:");
		Font font=new Font("Serif", Font.ITALIC, 34);
		label.setFont(font);
		label.setBounds(500,50,320,70);
		
		viewall=new JButton("View all Alumni");
		viewall.setBounds(500,150,250,30);
		viewall.addActionListener(this);
		
		add=new JButton("Add New Alumni");
		add.setBounds(500,190,250,30);
		add.addActionListener(this);
		
		update=new JButton("Update existing Alumni");
		update.setBounds(500,230,250,30);
		update.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(50,600,100,30);
		back.addActionListener(this);
		
		frame.add(label);
		frame.add(viewall);
		frame.add(add);
		frame.add(update);
		frame.add(back);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==viewall){
			new ViewAllAlumni(2);
			frame.dispose();
		}
		if(e.getSource()==add){
			new AddAlumni();
			frame.dispose();
		}
		if(e.getSource()==update){
			new UpdateAlumni();
			frame.dispose();
		}
		if(e.getSource()==back)
		{
			new Operator();
			frame.dispose();
		}
		
	}

}
