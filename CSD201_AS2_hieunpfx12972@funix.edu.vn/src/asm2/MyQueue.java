package asm2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyQueue {
	private Node head, tail;
	private int size;

	public MyQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	// them phan tu vao duoi
	public void enqueue(Product product) {
		Node newNode = new Node(product);
		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
			this.size++;
		}
		this.tail.nextNode = newNode;
		this.tail = newNode;
		this.size++;
	}

	// xoa ptu o dau
	public void dequeue() {
		if (this.isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		this.head = this.head.nextNode;
		this.size--;
	}

	// Hien thi data
	public void printQueue() {
		Node current = this.head;
		while (current != null) {
			current.printData();
			current = current.nextNode;
		}
	}
	
	// doc file
		public void getAllItemFromFile(String fileName) {
			String line = "";
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				while ((line = br.readLine()) != null) {
					String[] values = line.split(" ");
					Product product = new Product(values[0], values[1], Integer.parseInt(values[2]),
							Double.parseDouble(values[3]));
					enqueue(product);
				}

				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}
