package FirstProject;

import javax.swing.ImageIcon;

public class menuDTO {
	String pname;
	String price;
	int number;
	String image;
	String kind;
	
	

	@Override
	public String toString() {
		return "menuDTO [pname=" + pname + ", price=" + price + ", number=" + number + ", image=" + image + ", kind="
				+ kind + "]";
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public menuDTO() {
		
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
