package Entity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Product {
	private int id;
	private String name;
	private String image;
	private double price;
	private String title;
	private String description;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, String image, double price, String title, String description) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.title = title;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", title=" + title
				+ ", description=" + description + "]";
	}
	
	public String getFormattedPrice() {
        // Tạo một đối tượng NumberFormat cho loại tiền tệ của Việt Nam
		DecimalFormat format = (DecimalFormat) NumberFormat.getInstance(new Locale("vi", "VN"));

        // Đặt mẫu định dạng không bao gồm ký hiệu tiền tệ
        format.applyPattern("#,###");

        // Định dạng giá tiền với định dạng không bao gồm ký hiệu tiền tệ
        return format.format(price);
    }
    
}
	