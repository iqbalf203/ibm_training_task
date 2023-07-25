

import java.util.Random;	
import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ibm.model.Order;
import com.ibm.service.OrderService;

public class App {
	public static void main(String[] args) {
			ApplicationContext context = new AnnotationConfigApplicationContext(com.ibm.config.SpringConfig.class);	
			SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class);
			Order order = context.getBean("order",Order.class);
			OrderService orderService = context.getBean("service",OrderService.class);
			Scanner sc = new Scanner(System.in);
			int choice=0;
			boolean loop = true;
			while(loop) {
				Random rand = new Random();
				System.out.println("Main Menu");
				System.out.println("1. Place Order");
				System.out.println("2. Order Summary");
				System.out.println("3. Exit");
				try {
					choice = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Enter a Numeric Value");
				}
			switch(choice) {
				case 1:
					String action=null;
					String stock=null;
					int price=0;
					int quantity=0;
					double commission=0;
					System.out.println("Which Stock would you like to order");
					System.out.println("1. LNT        1451");
					System.out.println("2. Reliance   923");
					System.out.println("3. Tata Steel 435");
					
					int choice2 = sc.nextInt();
					if 		(choice2==1) {stock="LNT";price=1451;}
					else if (choice2==2) {stock="Reliance";price=923;}
					else if (choice2==3) {stock="Tata Steel";price=435;}
					System.out.println("Buy or Sell");
					System.out.println("1. Buy");
					System.out.println("2. Sell");
					
					int choice3 = sc.nextInt();
					if     (choice3==1) 	{action = "Buy";commission=0.005;}
					else if(choice3==2) 	{action="Sell";commission=0.01;}
					System.out.println("Enter quantity:");
					
					quantity = sc.nextInt();
					if (quantity<1) {System.out.println("Quantity cannot be less than 1");
					while(quantity<1) {
						System.out.println("Enter Quantity Again: ");
						quantity = sc.nextInt();
					}}
					int randNo = rand.nextInt(10000);
					order.setOrderNo(randNo);
					order.setStock(stock);
					order.setAction(action);
					order.setQunatity(quantity);
					order.setAmount(price*quantity);
					order.setCommission(commission*quantity*price);
					int orderTemp = orderService.placeOrder(order,sessionFactory);
					System.out.println("Order Id is: "+orderTemp);
					break;
					
					
				case 2:
					System.out.println("Enter Order Number:");
					int no=sc.nextInt();
					orderService.getOrder(no,sessionFactory);
					break;
					
					
				case 3:{
					sc.close();
					System.out.println("Thank You for using the App.");
					loop=false;}
			}
			}
	}
}
		
