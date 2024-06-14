import java.util.*;
public class randomg
{
  
public static void main(String[]args)
{ 
  Game game = new Game();
  try (Scanner scan = new Scanner(System.in)) { 
    int choice=0;
    do
    {
  System.out.println("welcome to the random number generation game!!.....");
  System.out.println("you have an three levels to play....");
  System.out.println("Press 1 for Easy level");
  System.out.println("Press 2 for Medium level");
  System.out.println("Press 3 for Difficult level");
  System.out.println("Press 4 for Quit the game ");
 choice = scan.nextInt();

  switch (choice) 
  {
   case 1:
  game. getdata();
  System.out.println("You have an 10 chances to play a game.... ");
  game.geteasy();
    break;
    case 2:
    game. getdata();
    System.out.println("You have an 5 chances to play a game.... ");
    game.getmedium();
    break;
    case 3:
    game. getdata();
    System.out.println("You have an 3 chances to play a game.... ");
    game.getdifficult();
    break;
    case 4:
    break;
    default :
    System.out.println("Invalid output");
  
  }

  }
while(choice!=5);
  }
  }
}

class Game
{
  int s=100;
 int t=1;
 int user;
int sra;

public void geteasy()
{  
  try (Scanner scan = new Scanner(System.in)) {
    System.out.println("Enter the random number : ");
    int choicesleft = 10;
  for(int i=0;i<=10;i++)
  {
  user = scan.nextInt();
  if(sra>user)
  {
    System.out.println(" Guessed number is too high");
  }
   else if(sra<user) 
   {
    System.out.println(" Guessed number is too low");
  
   }
   else if(sra==user)
   {
    System.out.println(" Guessed number is correct, <<<YOU WIN THE GAME>>>");
  
   }
   
  choicesleft--;
  if(choicesleft==0)
  {
    System.out.println("you lose the choices,play the game again to win");
  }
  }
}
}
public void getmedium()
{
  try (Scanner scan = new Scanner(System.in)) {
    System.out.println("Enter the random number : ");
    int choicesleft = 5;
  for(int i=0;i<=5;i++)
  {
  user = scan.nextInt();
  if(sra>user)
  {
    System.out.println(" Guessed number is too high");
   
  
  }
   else if(sra<user) 
   {
    System.out.println(" Guessed number is too low");
  
   }
   else if(sra==user)
   {
    System.out.println(" Guessed number is correct <<<YOU WIN THE GAME>>>");
  
   }
   
   choicesleft--;
   if(choicesleft==0)
   {
     System.out.println("you lose the choices,play the game again to win");
   }
}
}
}
  public void getdifficult()
{
  try (Scanner scan = new Scanner(System.in)) {
    System.out.println("Enter the random number : ");
    int choicesleft = 10;
  for(int i=0;i<=10;i++)
  {
  user = scan.nextInt();
  if(sra>user)
  {
    System.out.println(" Guessed number is too high");
    
  }
  else if(sra==user)
  {
   System.out.println(" Guessed number is correct <<<YOU WIN THE GAME>>>");
   
  }
  choicesleft--;
  if(choicesleft==0)
  {
    System.out.println("you lose the choices,play the game again to win");
  }
}
}
}
public void getdata()
{
  Random rd = new Random();
  sra = rd.nextInt(s-t+1)+t;

}
}


