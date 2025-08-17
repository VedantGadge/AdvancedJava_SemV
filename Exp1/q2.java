import java.util.*;
interface Payment {
 void processPayment(double amount);
}
class CreditCardPayment implements Payment {

 @Override
 public void processPayment(double amount) {
 System.out.println("Processing credit card payment of: $" + amount);
 }
}
class DebitCardPayment implements Payment {
 @Override
 public void processPayment(double amount) {
 System.out.println("Processing debit card payment of: $" + amount);
 }
}
class UpiPayment implements Payment {
 @Override
 public void processPayment(double amount) {
 System.out.println("Processing Upi payment of: $" + amount);
 }
} 

public class q2 {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter amount for credit card payment: ");
 double creditAmount = sc.nextDouble();
 Payment creditPayment = new CreditCardPayment();
 creditPayment.processPayment(creditAmount);
 System.out.print("Enter amount for debit card payment: ");
 double debitAmount = sc.nextDouble();
 Payment debitPayment = new DebitCardPayment();
 debitPayment.processPayment(debitAmount);
 System.out.print("Enter amount for UPI payment: ");
 double upiAmount = sc.nextDouble();
 Payment upiPayment = new UpiPayment();
 upiPayment.processPayment(upiAmount);

 sc.close();
 }
}
