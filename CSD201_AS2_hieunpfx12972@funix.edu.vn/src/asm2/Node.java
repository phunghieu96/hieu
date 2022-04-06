package asm2;

public class Node {
	private Product data;
	public Node nextNode;

	public Node(Product data) {
		this.data = data;
		this.nextNode = null;
	}

	public Node(Product data, Node nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	}
	
	public Product getData() {
		return data;
	}

	public void setData(Product data) {
		this.data = data;
	}

	public void printData() {
		data.display();
	}
	
	public boolean hasProduct(String productID) {
		return (this.data.getId() == productID);
	}
}
