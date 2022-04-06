package asm2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyStack {
	private Node head;
	private int size;

	public MyStack() {
		this.head = null;
		this.size = 0;
	}

	public boolean isEmpty() {
		return (this.head == null);
	}

	// Them vao stack vao dau stack
	public void push(Product product) {
		Node newNode = new Node(product);
		newNode.nextNode = this.head;
		this.head = newNode;
	}

	// Xoa 1 ptu o dau stack
	public void pop() {
		if (this.isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		this.head = this.head.nextNode;
	}
	
	//Hien thi data
	public void printStack() {
		Node current = this.head;
		while(current != null) {
			current.printData();
			current = current.nextNode;
		}
	}
	
	//Doc file 
		public void getAllItemFromFile(String fileName) {
			String line = "";
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				while ((line = br.readLine()) != null) {
					String[] values = line.split(" ");
					Product product = new Product(values[0], values[1], Integer.parseInt(values[2]),
							Double.parseDouble(values[3]));
					push(product);
				}

				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
