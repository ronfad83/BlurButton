package buttonBlur;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class BlurButton extends JButton 
{
	public BlurButton(String txt)
	{
		super(txt);
	}
	
	public void paintComponent(Graphics graph)
	{
		if(isEnabled())
		{
			super.paintComponent(graph);
			return;
		}
		BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		super.paintComponent(bi.getGraphics());
		float kernel[] = {0.10f,0.10f,0.10f,
						   0.10f,0.20f,0.10f,
						   0.10f,0.10f,0.10f
						  };
		ConvolveOp cop = new ConvolveOp(new Kernel(3, 3, kernel));
		Image img = cop.filter(bi, null);
		graph.drawImage(img,0,0,null);
	}
}
