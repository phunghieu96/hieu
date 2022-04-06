package asm2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AS2_Main {

	public void showMenu() {
		System.out.println("Choose one of this options:");
		System.out.println("Product list:");
		System.out.println("1. Load data from file and display");
		System.out.println("2. Input & add to the end.");
		System.out.println("3. Display data");
		System.out.println("4. Save product list to file.");
		System.out.println("5. Search by ID");
		System.out.println("6. Delete by ID");
		System.out.println("7. Sort by ID.");
		System.out.println("8. Convert to Binary");
		System.out.println("9. Load to stack and display");
		System.out.println("10. Load to queue and display.");
		System.out.println("0. Exit");
	}

	public static void main(String[] args) throws IOException {
		AS2_Main main = new AS2_Main();
		OperationToProduct o = new OperationToProduct();
		MyList m = new MyList();
		MyStack s = new MyStack();
		MyQueue q = new MyQueue();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			main.showMenu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("ID |  Title   | Quantity | price");
				System.out.println("--------------------------------");
				o.getAllItemFromFile("data.txt", m);
				o.displayData(m);
				System.out.println("Successfully!");
				break;
			case 2:
				o.addLast(m);
				break;
			case 3:
				o.displayData(m);
				break;
			case 4:
				o.writeAllItemsToFile("data.txt", m);
				break;
			case 5:
				o.searchBycode(m);
				break;
			case 6:
				o.deleteByCode(m);
				System.out.println("Deleted!");
				break;
			case 7:
				o.sortByCode(m);
				System.out.println("Successfully!");
				break;
			case 8:
				o.convertToBinary(m.getHead().getData().getSoLuong());
				System.out.println();
				break;
			case 9:
				s.getAllItemFromFile("data.txt");
				s.printStack();
				break;
			case 10:
				q.getAllItemFromFile("data.txt");
				q.printQueue();
				break;
			case 0:
				break;
			}
		} while (choice != 0);
	}
}
