package app;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

class ImageImplement extends JPanel 
{ 
	private Image img; 
	public ImageImplement(Image img) 
	{ 
		this.img = img;
		Dimension size = new Dimension(1360, 725); 
		setPreferredSize(size);
		setMinimumSize(size); 
		setMaximumSize(size); 
		setSize(size); 
		setLayout(null); 
		
	}
	public void paintComponent(Graphics g) 
	{ 
		g.drawImage(img, 0, 0, null); 
	}
}



