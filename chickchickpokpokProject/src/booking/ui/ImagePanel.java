package booking.ui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private Image bgImg;
	private String imgPath;
	private int w; //Æø
	private int h; //³ôÀÌ
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if( this.bgImg != null ) {
			g.drawImage(this.bgImg, 0, 0, this);
		}
		
	}
	
	//
	public Image getBgImg() {
		return bgImg;
	}
	public void setBgImg(Image bgImg) {
		this.bgImg = bgImg;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	
	// 
	public ImagePanel(Image img) {
		bgImg = img;
	}
	public ImagePanel(Image img, String imgPath) {
		bgImg = img; // img not null
		this.imgPath = imgPath;
		this.w = bgImg.getWidth(this);
		this.h = bgImg.getHeight(this);
		System.out.println("ImagePanel:: w = " + w + ", h = " + h);
	} 

}
