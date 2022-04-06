package asm2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.util.Scanner;

public class OperationToProduct {

	// Tim vi tri cua sp
	public int index(Product p, MyList list) {
		int count = 0;
		Node current = list.getHead();
		while (current != null) {
			if (current.getData() == p) {
				return count;
			}
			current = current.nextNode;
			count++;
		}
		return -1;
	}

	// Tao va tra lai 1 sp vs thong tin nhap tu ban phim
	public Product creatProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ID : ");
		String tenSP = sc.nextLine();
		System.out.println("Hay nhap ten san pham  : ");
		String id = sc.nextLine();
		System.out.println("So Luong : ");
		int soluong = sc.nextInt();
		System.out.println("Gia : ");
		double giaSP = sc.nextDouble();
		Product p = new Product(id, tenSP, soluong, giaSP);
		return p;

	}

	// Thêm sản phẩm vào cuoi danh sách, thông tin sản phẩm nhập từ bàn phím.
	public void addLast(MyList list) {
		list.addTail(creatProduct());
	}

	// Thêm sản phẩm vào dau danh sách, thông tin sản phẩm nhập từ bàn phím.
	public void addFirst(MyList list) {
		list.insertToHead(creatProduct());
	}

	// Hien thi tat ca sp
	public void displayData(MyList list) {
		list.print();
	}

	// Tim kiem san pham bang cach nhap ID tu ban phim
	public void searchBycode(MyList list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ID san pham ban muon tim : ");
		String iD = sc.nextLine();
		Node current = list.getHead();

		while (current != null) {
			if (current.getData().getId().equalsIgnoreCase(iD)) {
				current.printData();
				return;
			}
			current = current.nextNode;
		}
		System.out.println("-1");
	}

	// Xoa san pham dau tien co ID dau vao tu ban phim khoi danh sach
	public void deleteByCode(MyList list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ID san pham ban muon xoa : ");
		String deleteId = sc.nextLine();
		list.deleteElement(deleteId);
	}

	// Sap xep danh sach lien ket theo ID

	public void sortByCode(MyList list) {
		Node current = list.getHead();
		Node preNode = null;
		if (list.getHead() == null) {
			return;
		}
		while (current != null) {
			preNode = current.nextNode;
			while (preNode != null) {
				if (current.getData().getId().compareTo(preNode.getData().getId()) > 0) {
					Product temp = current.getData();
					current.setData(preNode.getData());
					preNode.setData(temp);
				}
				preNode = preNode.nextNode;
			}
			current = current.nextNode;

		}
	}

	// Xoa san pham theo vi tri mong muon
	public void deleteAtPosition(MyList list, int pos) {
		Node current = list.getHead();
		Node preNode = null;
		int count = 0;
		while (current != null) {
			if (count == pos) {
				preNode.nextNode = current.nextNode;
			}
			count++;
			preNode = current;
			current = current.nextNode;

		}
	}

	// Ghi du lieu vao file
	public void writeAllItemsToFile(String fileName, MyList list) {
		try {
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			Node current = list.getHead();
			while (current != null) {
				bw.write(current.getData().toString());
				bw.newLine();
				current = current.nextNode;
			}
			bw.close();
			System.out.println("Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Doc du lieu tu file va chen vao danh sach o duoi
	public void getAllItemFromFile(String fileName, MyList list) {
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				String[] values = line.split(" ");
				Product product = new Product(values[0], values[1], Integer.parseInt(values[2]),
						Double.parseDouble(values[3]));
				list.addTail(product);
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// chuyen doi 1 so thap phan ( so luong san pham) sang so nhi phan

	public void convertToBinary(int i) {
		MyList mlist = new MyList();
		if (i == 0) {
			return;
		} else {
			int r = i % 2;
			convertToBinary(i / 2);
			System.out.print(r);
		}
	}
}
