package asm2;

public class MyList {
	private Node head, tail;
	private int size;

	public MyList() {
		head = tail = null;
		this.size = 0;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public void clear() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	// Ham them 1 ptu vao dau danh sach
	public void insertToHead(Product data) {
		Node newNode = new Node(data);
		newNode.nextNode = this.head;
		this.head = newNode;
		this.size++;
	}

	// them ptu vao tail
	public void addTail(Product product) {
		Node newNode = new Node(product);
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}
		this.tail.nextNode = newNode;
		this.tail = newNode;

	}

	// Ham them 1 ptu vao vi tri nhat dinh
	public void insertAfterPosition(int position, Product data) {
		Node newNode = new Node(data);
		if (position < 1 || this.size == 0) {
			newNode.nextNode = this.head;
			this.head = newNode;
			if (this.tail == null) {
				this.tail = newNode;
			}
			this.size++;
			return;
		}
		if (position >= this.size) {
			if (this.tail != null) {
				this.tail.nextNode = newNode;
				this.tail = newNode;
			}
			this.size++;
			return;
		}
		Node preNode = null;
		Node current = this.head;
		int count = 0;

		while (current != null) {
			if (count < position) {
				count++;
				preNode = current;
				current = current.nextNode;
			}
			newNode.nextNode = current;
			preNode.nextNode = newNode;
			this.size++;
			return;
		}
	}

	// Xoa ptu o cuoi ds
	public void deleteTail() {
		if (this.head == null) {
			this.tail = null;
		}
		Node current = this.head;
		while (current != null) {
			if (current.nextNode == this.tail) {
				current.nextNode = null;
				this.tail = current;
				this.size--;
				return;
			}
			current = current.nextNode;
		}
	}

	// xoa ptu o giua
	public void deleteElement(String productID) {
		Node preNode = null;
		Node current = this.head;
		int count = 0;
		while (current != null) {
			if (current.getData().getId().equalsIgnoreCase(productID)) {
				if (count == 0) {
					this.head = this.head.nextNode;
					if (this.head == null) {
						this.tail = null;
					}
				} else if (count == this.size - 1) {
					preNode.nextNode = null;
					this.tail = preNode;
				} else {
					preNode.nextNode = current.nextNode;
				}
			}
			count++;
			preNode = current;
			current = current.nextNode;

		}
	}

	// trao doi giua 2 node

	public void swap(Node firstNode, Node secondNode) {
		Product temp = firstNode.getData();
		firstNode.setData(secondNode.getData());
		secondNode.setData(temp);
	}
	
	// In ra man hinh
	public void print() {
		Node current  = this.head;
		while(current != null) {
			current.printData();
			current = current.nextNode;
		}
	}
}
