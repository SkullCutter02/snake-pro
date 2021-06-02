package View;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
// DO NOT MODIFY
/**
 * View.SnakeProImagePanel - implements low-level graphics work.
 * 
 * @author CS60 instructors
 */
public class SnakeProImagePanel extends JPanel{

	//The image that this panel draws
	Image myImage;
	
	// constructor
	public SnakeProImagePanel(Image inputImage)
	{
		// Store the image 
		this.myImage = inputImage;

		// Calculate the dimensions of the panel:
		int height = inputImage.getHeight(null);
		int width = inputImage.getWidth(null);
		Dimension dimensions = new java.awt.Dimension(width, height);
		super.setPreferredSize(dimensions);
	}

	//override the paint method to draw the image on the panel
	public void paint(Graphics graphicsObj)
	{
		graphicsObj.drawImage(this.myImage, 0, 0, null);
	}
	// added to avoid a warning - Not used!
	private static final long serialVersionUID = 1L;
}
