import java.util.Scanner;
class Customer {
    int customerId;
    String name;
    String address;
void getDetails() {
        System.out.println("Customer ID: "+customerId);
        System.out.println("Name: "+name);
        System.out.println("Address: "+address);
}
}
class Account {
    int accNo;
    int balance=0;
void deposit(int amount) {
        balance = balance+amount;
        System.out.println("Amount Deposited:"+ amount);
    }
 void withdraw(int amount) {
        if (amount>balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance=balance-amount;
            System.out.println("Amount Withdrawn: "+amount);
             }
}
void showBalance() {
        System.out.println("Current Balance: "+balance);
      }
}

class Transaction {
    int transId;
    int amount;
void set(int id, int amt) {
        transId=id;
        amount=amt;
        }
void get() {
        System.out.println("Transaction ID: "+transId);
        System.out.println("Amount: "+amount);
        }
}
public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
         Customer c=new Customer();
        Account a=new Account();
        Transaction t=new Transaction();
        System.out.print("Enter Customer ID: ");
        c.customerId = sc.nextInt();
        sc.nextLine();
System.out.print("Enter Name: ");
        c.name = sc.nextLine();
System.out.print("Enter Address: ");
        c.address = sc.nextLine();
System.out.print("Enter Account Number: ");
        a.accNo = sc.nextInt();
int choice;
        int transCount = 0;
do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Customer Details");
            System.out.println("4. Balance");
            System.out.println("5. Exit");
System.out.print("Enter your choice: ");
            choice = sc.nextInt();
switch (choice) {
              case 1:
                    System.out.print("Enter amount to deposit: ");
                    int dep = sc.nextInt();
                    a.deposit(dep);

                    transCount++;
                    t.set(transCount, dep);
                    t.get();
                    break;
              case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int amt = sc.nextInt();
                    a.withdraw(amt);

                    transCount++;
                    t.set(transCount, amt);
                    t.get();
                    break;

                case 3:
                    c.getDetails();
                    break;

                case 4:
                    a.showBalance();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
    }

} while (choice != 5);
}
}