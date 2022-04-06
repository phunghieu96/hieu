package asm2;

public class Product {
	private String tenSP, id;
	private int soLuong;
	private double giaSP;
	

	public Product() {
	}

	public Product(String id, String tenSP, int soLuong, double giaSP) {
		this.id = id;
		this.giaSP = giaSP;
		this.soLuong = soLuong;
		this.tenSP = tenSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaSP() {
		return giaSP;
	}

	public void setGiaSP(double giaSP) {
		this.giaSP = giaSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void display() {
		System.out.println(id + " "+ tenSP + " " + soLuong + " " + giaSP  );
	}

	@Override
	public String toString() {
		return id + " " + tenSP + " " + soLuong + " " + giaSP ;
	}	
	
}
