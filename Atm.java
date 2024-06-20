import java.util.Scanner;

public class Atm {
   
 
  static final int pin = 2913;

    public static void main(String[]args)
{  
    
    int choice=0;
   
  User user = new User();
  
  try (Scanner scan = new Scanner(System.in))
   { 
    System.out.println("Welcome to ATM services!...");
    System.out.println("Enter pin number: ");
 int pinno= scan.nextInt();


     do
    {
      if(pin == pinno )
      {
 System.out.println("Press 1 for CHECK BALANCE  ");
  System.out.println("Press 2 for  DEPOSIT ");
  System.out.println("Press 3 for WITHDRAW ");
  System.out.println("Press 4 for EXIT ");
 System.out.println("Enter your choices: ");  
 choice = scan.nextInt();
   
 
 
  switch (choice) 
  {

   case 1:
   
  user.checkbalance();
    break;
    case 2:
    user.Deposit();
   
   break;
    case 3:

    user.withdraw();

    break;
   default:
    System.out.println("Thank you for using ATM!..");
    break;
  
  }
}
else
   {
    System.out.println("Invalid pin number");
    System.exit(0);

   }
    }
    
while(choice!=4);


  }
   
  }
}
class User
{

Scanner scan = new Scanner(System.in);
    long balance = 1000,deposit,withdrawl;


   public void checkbalance ()
    {
      
       balance+= deposit - withdrawl;
        System.out.println("Balance amount: " +balance); 


    }
    
    public void withdraw()
    
    { 
        System.out.println("Enter amount to withdraw : ");
        withdrawl = scan.nextLong();
      
        if(balance<=1000 )
        { 
           System.out.println("Minimum balance should be <<<1000>>>!!!..");
            System.out.println("<<<Insufficient balance to withdraw amount>>>");
        }
        else
        {
           
        System.out.println("Withdrawl amount: " +withdrawl); 


    }
}
    public void Deposit()
    
    { 
        System.out.println("Enter amount to Deposit : ");
        deposit = scan.nextLong();
      
        System.out.println("Deposited amount: " +deposit); 


    }
  }
 