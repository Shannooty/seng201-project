package interfaces;

import javax.swing.ImageIcon;

/**
 * The HasImage interface guarantees that the GUI can display classes as an image in different frames
 * @author Bede Nathan
 * @author Celia Allen
 *
 */

public interface HasImage {
	
	/**
	 * Getter for the ImageIcon for a given instance of a class
	 * @return The ImageIcon
	 */
	public ImageIcon getImg();
	
	/**
	 * Sets and creates the ImageIcon for a class
	 */
	public void setImg();
	
	/**
	 * Sets the image path for an instance of a class
	 * @param imgPath the file location String
	 */
	public void setImgPath(String imgPath);
	
	/**
	 * Getter for the classes internal ID
	 * @return the instance ID
	 */
	public int getID();
	
}
