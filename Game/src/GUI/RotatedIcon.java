package GUI;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;
import javax.swing.Icon;

public class RotatedIcon implements Icon
{
	public enum Rotate{
		DOWN,
		UP,
		UPSIDE_DOWN,
		ABOUT_CENTER;
	}

	private Icon icon;

	private Rotate rotate;

	private double degrees;
	private boolean circularIcon;

	public RotatedIcon(Icon icon){
		this(icon, Rotate.UP);
	}

	public RotatedIcon(Icon icon, Rotate rotate){
		this.icon = icon;
		this.rotate = rotate;
	}

	
	public RotatedIcon(Icon icon, double degrees){
		this(icon, degrees, false);
	}

	public RotatedIcon(Icon icon, double degrees, boolean circularIcon){
		this(icon, Rotate.ABOUT_CENTER);
		setDegrees( degrees );
		setCircularIcon( circularIcon );
	}

	
	public Icon getIcon(){
		return icon;
	}

	
	public Rotate getRotate(){
		return rotate;
	}

	public double getDegrees(){
		return degrees;
	}

	
	public void setDegrees(double degrees){
		this.degrees = degrees;
	}

	public boolean isCircularIcon(){
		return circularIcon;
	}


	public void setCircularIcon(boolean circularIcon){
		this.circularIcon = circularIcon;
	}


	@Override
	public int getIconWidth(){
		if (rotate == Rotate.ABOUT_CENTER)
		{
			if (circularIcon)
				return icon.getIconWidth();
			else
			{
				double radians = Math.toRadians( degrees );
				double sin = Math.abs( Math.sin( radians ) );
				double cos = Math.abs( Math.cos( radians ) );
				int width = (int)Math.floor(icon.getIconWidth() * cos + icon.getIconHeight() * sin);
				return width;
			}
		}
		else if (rotate == Rotate.UPSIDE_DOWN)
			return icon.getIconWidth();
		else
			return icon.getIconHeight();
	}


	@Override
	public int getIconHeight(){
		if (rotate == Rotate.ABOUT_CENTER)
		{
			if (circularIcon)
				return icon.getIconHeight();
			else
			{
				double radians = Math.toRadians( degrees );
				double sin = Math.abs( Math.sin( radians ) );
				double cos = Math.abs( Math.cos( radians ) );
				int height = (int)Math.floor(icon.getIconHeight() * cos + icon.getIconWidth() * sin);
				return height;
			}
		}
		else if (rotate == Rotate.UPSIDE_DOWN)
			return icon.getIconHeight();
		else
			return icon.getIconWidth();
	}


	@Override
	public void paintIcon(Component c, Graphics g, int x, int y){
		Graphics2D g2 = (Graphics2D)g.create();

		int cWidth = icon.getIconWidth() / 2;
		int cHeight = icon.getIconHeight() / 2;
		int xAdjustment = (icon.getIconWidth() % 2) == 0 ? 0 : -1;
		int yAdjustment = (icon.getIconHeight() % 2) == 0 ? 0 : -1;

		if (rotate == Rotate.DOWN)
		{
			g2.translate(x + cHeight, y + cWidth);
			g2.rotate( Math.toRadians( 90 ) );
			icon.paintIcon(c, g2,  -cWidth, yAdjustment - cHeight);
		}
		else if (rotate == Rotate.UP)
		{
			g2.translate(x + cHeight, y + cWidth);
			g2.rotate( Math.toRadians( -90 ) );
			icon.paintIcon(c, g2,  xAdjustment - cWidth, -cHeight);
		}
		else if (rotate == Rotate.UPSIDE_DOWN)
		{
			g2.translate(x + cWidth, y + cHeight);
			g2.rotate( Math.toRadians( 180 ) );
			icon.paintIcon(c, g2, xAdjustment - cWidth, yAdjustment - cHeight);
		}
		else if (rotate == Rotate.ABOUT_CENTER)
		{
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setClip(x, y, getIconWidth(), getIconHeight());
			g2.translate((getIconWidth() - icon.getIconWidth()) / 2, (getIconHeight() - icon.getIconHeight()) / 2);
			g2.rotate(Math.toRadians(degrees), x + cWidth, y + cHeight);
			icon.paintIcon(c, g2, x, y);
		}

		g2.dispose();
	}
}