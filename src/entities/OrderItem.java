package entities;

public class OrderItem {
	
	private Integer quantity;
	private Double price;
	
	private ProductStock product;
	
	public OrderItem() {
		
	}
	
	public OrderItem(Integer quantity, Double price, ProductStock product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public ProductStock getProduct() {
		return product;
	}
	public void setProduct(ProductStock product) {
		this.product = product;
	}
	
	public Double subTotal() {
		return quantity * price;
	}
	@Override
	public String toString() {
		return getProduct().getName() + ", $" + String.format("%.2f", price)
		+ ", Quantity: " + quantity + ", Subtotal: $" + String.format("%.2f", subTotal());
				
	}

}
