package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class ImageCarousel extends JPanel implements ActionListener {

	private ImageIcon images[];
	private JLabel imageSpace;
	private JButton backwards,forwards;
	private int index;
	private JPanel panel;
	
	
	public ImageCarousel() {
//	   setLayout(new BorderLayout( ));
//	   setSize(800, 700);
//	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   JPanel panel = new JPanel();
	   backwards=new JButton("<<");
	   forwards=new JButton(">>");
	   panel.add(backwards);
	   panel.add(forwards);
	   add(panel,BorderLayout.SOUTH);
	   backwards.addActionListener(this);
	   forwards.addActionListener(this);
	   images = new ImageIcon[3]; 
	   images[0] = new ImageIcon(ImageCarousel.class.getResource("/images/skeleton.png"));
	   images[1] = new ImageIcon(ImageCarousel.class.getResource("/images/index2.jpeg"));
	   images[2] = new ImageIcon(ImageCarousel.class.getResource("/images/index1.png"));
	   imageSpace = new JLabel("",JLabel.CENTER); 
	   add(imageSpace,BorderLayout.CENTER);
	   imageSpace.setIcon(images[0]);
	   setVisible(true);
	   
//	   imageSpace.setIcon(new ImageIcon(images[1]));
//	   String[] images = {
//	   "/images/skeleton.png",
//	   "/images/index2.jpeg",
//	   "/images/index1.png"
//     };
//length = images.length;
//System.out.println(images.length);
	   
	}


	public void actionPerformed(ActionEvent e) {
		
	   if (e.getSource() == backwards) {
		   
	       if (index == 0) {
	    	   index = images.length - 1;    	   
	       } else {
	    	   index = index-1;
	       }
	       
	   } else if (e.getSource() == forwards) {
		   
	       if (index == images.length - 1) {
	    	   index = 0;
	       } else {
	    	   index = index+1;
	       }
	   }
//	   imageSpace.setIcon(new ImageIcon(images[index]));
	   imageSpace.setIcon(images[index]);
	}
	

}
