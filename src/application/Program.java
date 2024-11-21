package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrderItem;
import entities.OrderStock;
import entities.ProductStock;
import entities.enums.OrderStatus;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    
	    System.out.println("Enter client data: ");
	    System.out.print("Name: ");
	    String name = sc.nextLine();
	    System.out.print("Email: ");
	    String email = sc.next();
	    System.out.print("Birth date (DD/MM/YYYY): ");
	    Date birthDate = sdf.parse(sc.next());
	    
	    Client client = new Client(name, email, birthDate);
	    
	    System.out.println("Enter order data:");
	    System.out.print("Status: ");
	    OrderStatus status = OrderStatus.valueOf(sc.next());
	    
	    OrderStock order = new OrderStock(new Date(), status, client);
	    
	    System.out.print("How many items to this order? ");
	    int n = sc.nextInt();
	    for (int i = 0; i < n; i++) {
	    	System.out.println("Enter #" + (i+1) + " item data: ");
	    	System.out.print("Product name: ");
	    	sc.nextLine();
	    	String nameProduct = sc.next();
	    	System.out.print("Product price: ");
	    	Double productPrice = sc.nextDouble();
	    	System.out.print("Product quantity: ");
	    	int productQuantity = sc.nextInt();
	    	
	    	ProductStock product  = new ProductStock(nameProduct, productPrice);
	    	OrderItem it = new OrderItem(productQuantity, productPrice, product);
	    	order.addItem(it);
	    }
	    System.out.println();
	    System.out.println(order);
	    
		sc.close();
	}

}
