package purchasable;

public class Purchasable {
	private double purchasePrice;
	private double sellPrice;
	private String discription;
	
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
	
}
