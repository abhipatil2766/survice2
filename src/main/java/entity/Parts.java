package entity;

public class Parts {
	private int id;
	private String name;
	private String discription;
	private double price;
	public Parts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parts(int id, String name, String discription, double price) {
		super();
		this.id = id;
		this.name = name;
		this.discription = discription;
		this.price = price;
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
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Parts [id=" + id + ", name=" + name + ", discription=" + discription + ", price=" + price + "]";
	}
	
	
}
