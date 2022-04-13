package purchasable;

import javax.swing.ImageIcon;

import purchasable.monsters.Monster;

public class Purchasable {
	private double purchasePrice;
	private double sellPrice;
	private String discription;
	private String imgPath;
	private ImageIcon img;
	
	public void buy() {
		
	}
	
	public void sell() {
		
	}
	
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	public double getSellPrice() {
		return sellPrice;
	}
	
	public String getDiscription() {
		return discription;
	}
	
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	public void setPurchasePrice(double buyPrice) {
		purchasePrice = buyPrice;
	}
	
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	public ImageIcon getImg() {
		return img;
	}
	
	public void setImg() {
		this.img = new ImageIcon(Monster.class.getResource(imgPath));
	}
	
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
}
