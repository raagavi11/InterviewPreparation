
package bill;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class customer{
	String c_name;
	long c_phno;	
	
	customer(String c_name,long c_phno){
		this.c_name=c_name;
		this.c_phno=c_phno;
		}
}
class product{
	int p_id;
	String p_name;
	int p_quantity;
	double price;
	product(int p_id,String p_name,double price){
		this.p_id=p_id;
		this.p_name=p_name;
		this.price=price;
	}
	void display()
	{
		System.out.print("\n"+p_id+"\tProducts "+ p_name +"-->Price "+price);
		
	}
	}
abstract class payment{
	double amount;
	abstract void paybill();
	abstract void fare();
	payment(double amount)
	{
		this.amount=amount;
	}
		

double getAmount() {
    return amount;
}}
class cash extends payment{
	cash(double amount)
	{
		super(amount);
	}
	void fare() {
		System.out.println("Rupees "+amount);
	}
	void paybill() {
		System.out.print(" Payed by cash !");
	}
}
class card extends payment{
	card(double amount){
		super(amount);
	}
	void fare() {
		amount=amount*1.01;
	}
	void paybill() {
		System.out.println("Rupees "+amount+" Payed by card !");
	}
}
class upi extends payment{
	upi(double amount){
		super(amount);
	}
	void fare() {
		amount=amount*1.03;
	}
	void paybill() {
		System.out.println("Rupees "+amount+" Payed with upi !");
	}
}

class bill {

    void display(customer c, product pr, int q, payment p) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("\n----------- BILL -----------");
        System.out.println("Date & Time : " + now.format(format));
        System.out.println("Customer    : " + c.c_name);
        System.out.println("Phone       : " + c.c_phno);
        System.out.println("Product     : " + pr.p_name);
        System.out.println("Price       : " + pr.price);
        System.out.println("Quantity    : " + q);
        System.out.println("Final Amount: " + p.getAmount());
        System.out.println("----------------------------");
    }
}
public class billl {
      public static void main(String[] args) {
    	  Scanner S=new Scanner(System.in);
    	  double quan=0;
    	  ArrayList<product> products = new ArrayList<>();
    	 System.out.print("Customer name :");
  		String c_name=S.next();
  		 System.out.print("Customer Phoneno :");
  		long c_phno=S.nextLong();
		customer c=new customer(c_name,c_phno);
		
		 System.out.print("-------Products Available-------\n");
		 products.add(new product(1, "Blue Lays", 5));
		 products.add(new product(2, "Hazelnut DairyMilk", 130));
		 products.add(new product(3, "Double chocolate Icecream", 60));
		 products.add(new product(4, "Lotus Biscoff Icecream", 150));
		 products.add(new product(5, "Snickers", 50));
		 for(product p:products)
		 {
			 p.display();
		 }
		 System.out.println("\nEnter your Choice :");
		 int choice=S.nextInt();
		 System.out.println("How Many :");
		 int q=S.nextInt();
			product selected=products.get(choice-1);
			quan=selected.price*q;
			System.out.println("price :"+quan);
			System.out.println("Payment Method:\n1.cash\n2.card\n3.upi" );
			int choose =S.nextInt();
			
			payment p;
			if(choose==1)
			{
				p=new cash(quan);
				p.fare();
				p.paybill();
			}
			else if(choose==2)
			{
				p=new card(quan);
				p.fare();
				p.paybill();
				
			}
			else
			{
				p=new upi(quan);
				p.fare();
				p.paybill();
			}
			 
			bill b = new bill();
			b.display(c, selected, q, p);
			
			 
      }}
		 

	


