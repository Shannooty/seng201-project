package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Creates a slide show of the images passed to the constructor that the user can click through/
 * @param 
 */
class ImageCarousel extends JPanel implements ActionListener {
	
	/**
	 * Attribute images of type ImageIcon[]. Contains the images that are displayed to the user in a slide show.
	 */
	private ImageIcon images[];
	
	/**
	 * Attribute imageSpace of type JLabel. Displays the current image to the user, is updated when either of the JButtons forwards or backwards are clicked.
	 */
	private JLabel imageSpace;
	
	/**
	 * Attribute backwards of type JButton. A button that the user can click to display the previous image in the slide show.
	 */
	static JButton backwards;
	
	/**
	 * Attribute forwards of type JButton. A button that the user can click to display the next image in the slide show.
	 */
	static JButton forwards;
	
	/**
	 * Attribute index of type integer. An integer from 0 - (length of images - 1). The index of the currently displayed image in the list images.
	 */
	private int index;
	
	/**
	 * Attribute currDescription of type string. Textual description of the currently displayed image.
	 */
	private String currDescription;
	
	
	
	/**
	 * Constructor for the class ImageCarousel. Creates a slide show of images that the user can click through. 
	 * @param givenImages type ImageIcon[], the list of images that the constructor displays to the user. Private variable images is set to the value of givenImages. 
	 */
	public ImageCarousel(ImageIcon[] givenImages) {
		
//		givenImages[0] = new ImageIcon(ImageCarousel.class.getResource("/images/skeleton.png"), "skeleton");
		JPanel imagePanel = new JPanel();

		images = givenImages;
		imageSpace = new JLabel("",JLabel.CENTER); 
		add(imageSpace,BorderLayout.CENTER);

		if (givenImages.length > 0) {
		  
		   
		   ImageIcon imageIcon = scaleImage(images[0]);

		   imageSpace.setIcon(imageIcon);
		   currDescription = images[0].getDescription();
		   
		   backwards=new JButton("<<");
		   forwards=new JButton(">>");
		   imagePanel.add(backwards);
		   imagePanel.add(forwards);
		   
		   if (givenImages.length == 1) {
			   backwards.setEnabled(false);
			   forwards.setEnabled(false);
		   }
		   
		   add(imagePanel,BorderLayout.SOUTH);
		   backwards.addActionListener(this);
		   forwards.addActionListener(this);
		   setVisible(true);
	   } else {
		   ImageIcon imageIcon = scaleImage(new ImageIcon(ImageCarousel.class.getResource("/images/NA.png"), "N/A"));
		   imageSpace.setIcon(imageIcon);
		   currDescription = "N/A";
	   }

	      
	}

	
	/**
	 * Method actionPerformed is triggered when a button is clicked. Its purpose is to check which button was pressed (forwards or backwards), and updates and scales the image displayed to the user depending on the answer (iterating through the list of images). It also updates the variable currDescription to match the description of the currently displayed image.
	 * 
	 * @param e the action that was performed, type ActionEvent.
	 */
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
	   currDescription = images[index].getDescription();
//	   System.out.println(currDescription);
	   if (currDescription != "skeleton" && currDescription != "slime" && currDescription != "zombie" && currDescription != "undeadGuard") {
		   MainScreen.setTxtrDescription(currDescription);
	   }
	   
	   ImageIcon imageIcon = scaleImage(images[index]);
	   imageSpace.setIcon(imageIcon);
	   
	}
	
	
	/**
	 * Returns the string description of the currently displayed image.
	 * @return type String, the description of the currently displayed image.
	 */
	
	public String getImg() {
		return currDescription;
	}

	/**
	 * Takes an ImageIcon, transforms it to type Image, scales it, and transforms it back to type ImageIcon and returns it.
	 * @param imageToScale type ImageIcon, the image that needs to be scaled.
	 * @return type ImageIcon, the scaled image to display.
	 */
	public ImageIcon scaleImage(ImageIcon imageToScale) {
		Image image = imageToScale.getImage(); // transform the imageIcon
		Image scaledImg = image.getScaledInstance(210, 150,  java.awt.Image.SCALE_SMOOTH); // scale the image smoothly
		ImageIcon imageIcon = new ImageIcon(scaledImg); // transform the image back to an ImageIcon
		return imageIcon;
	}


	

}
