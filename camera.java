package Main_CR;

public class camera {
	int camera_ID;
	String brand;
	String model;
	double price;
	String status;
	camera(){}
	camera(int camera_ID, String brand, String model, double price, String status){
		this.camera_ID=camera_ID;
		this.brand=brand;
		this.model=model;
		this.price=price;
		this.status=status;
	}
	public void display() {
		System.out.println(camera_ID+" "+brand+" "+model+" "+price+" "+status);
	}

}
