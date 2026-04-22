package cab;
import java.util.Scanner;
class CustomerDetails{
	
	int c_id;
	String c_name;
	String c_address;
	long c_phno;
	CustomerDetails(int c_id, String c_name,String c_address,long c_phno){
		this.c_id=c_id;
		this.c_name=c_name;
		this.c_address=c_address;
		this.c_phno=c_phno;
	}
}
class DriverDetails{
	int d_id;
	String d_name;
	long d_phno;
	DriverDetails(int d_id,String d_name,long d_phno){
		this.d_id=d_id;
		this.d_name=d_name;
		this.d_phno=d_phno;
	}
}
class CabDetails{
	int cb_id;
	String cb_type;
	CabDetails(int cb_id,String cb_type){
		this.cb_id=cb_id;
		this.cb_type=cb_type;
	}
}
class trip{
	CustomerDetails customer;
    DriverDetails driver;
    CabDetails cab_Type;
	String pickup;
	String drop;
   
    double rate;
    trip(CustomerDetails customer,DriverDetails driver,CabDetails cab_Type,String pickup,String drop)
    {
    	this.customer=customer;
    	this.driver=driver;
    	this.cab_Type=cab_Type;
    	this.pickup=pickup;
    	this.drop=drop;
    
    
    }
    void display()
    {
    	System.out.println("-----Trip Details-----");
    	System.out.println("Customer :"+ customer.c_name);
    	System.out.println("Driver :"+ driver.d_name);
    	System.out.println("Type of the Cab :"+ cab_Type.cb_type);
    	System.out.println("Pickup :"+ pickup);
    	System.out.println("Drop :"+drop);
    	
    	
    
    	
    }
	
	
}
abstract class payment{
	abstract void paymenttype();
	int distance;
	int rateperkilo;
	int amount;
	payment(int distance,int rateperkilo)
	{
		this.distance=distance;
		this.rateperkilo=rateperkilo;
	}
	void fare()
	{
		amount=distance*rateperkilo;
	}
	void receipt() {
	System.out.println("distance :"+distance);
	
	System.out.println("rateperkilo :"+rateperkilo);
	System.out.println("amount :"+amount);
	}
}
class cash extends payment{
	
	cash(int distance,int rateperkilo)
	{
		super(distance,rateperkilo);
		
		}
	void paymenttype()
	{
		System.out.println("Payed by cash");
	}
}
class card extends payment{
	card(int distance,int rateperkilo)
	{
		super(distance,rateperkilo);
	}
	void fare()
	{
		super.fare();
		amount=(int) (amount*(1.02));
	}
	void paymenttype()
	{
		System.out.println("Payed by card");
	}
	
	
}
class upi extends payment{
	upi(int distance,int rateperkilo)
	{
		super(distance,rateperkilo);
	}
	void fare()
	{
		super.fare();
		amount=(int) (amount*(2.02));
	}
	void paymenttype()
	{
		System.out.println("Payed by upi");
	}
	
	
}


public class cabsys {
    
	public static void main(String[] args) {
		Scanner S=new Scanner(System.in);
		System.out.println("Enter Customer Id :");
		int c_id=S.nextInt();
		System.out.println("Enter Customer Name :");
		String c_name=S.next();
		System.out.println("Enter Customer address :");
		String c_address=S.next();
		System.out.println("Enter Customer Phoneno :");
		long c_phno=S.nextLong();
		CustomerDetails cd=new CustomerDetails(c_id,c_name,c_address,c_phno);
		
		System.out.println("Enter Driver Id :");
		int d_id=S.nextInt();
		System.out.println("Enter Driver Name :");
		String d_name=S.next();
		System.out.println("Enter Driver Phoneno :");
		long d_phno=S.nextLong();
		DriverDetails dd=new DriverDetails(d_id,d_name,d_phno);
		System.out.println("Enter Cab Id :");
		int cb_id=S.nextInt();
		System.out.println("Enter Cab Type :");
		String cb_type=S.next();
		CabDetails cbd=new CabDetails(cb_id,cb_type);
		System.out.println("where to pickup :");
		String pickup=S.next();
		System.out.println("where to drop :");
		String drop=S.next();
		
		
		
		
		int distance=55;
		int rateperkilo=2;
		System.out.println("Payment Method:\n 1.cash\n2.card\n3.upi" );
		int choice=S.nextInt();
		payment p;
		if(choice==1)
		{
			p=new cash(distance,rateperkilo);
			p.fare();
			p.receipt();
			p.paymenttype();
		}
		else if(choice==2)
		{
			p=new card(distance,rateperkilo);
			p.fare();
			p.receipt();
			p.paymenttype();
		}
		else {
		p=new upi(distance,rateperkilo);
		p.fare();
		p.receipt();
		p.paymenttype();
		}
		
		trip t=new trip(cd,dd,cbd,pickup,drop);
		t.display();
		
		
	}

}
