import java.util.*;

public class TASK2
{
public static void main(String[] args)
{
tas he= new tas();
he.getdata();
}
}

class tas
{
    
    String name;
    int n,i;
    Double a[] = new Double[10];
    Double total =0.0;
    Double avg;
    
    public void getdata()
    { 
    
    try (Scanner scan = new Scanner(System.in)) {
        System.out.println("Enter  Name : ");
            name = scan.next();
            System.out.println("Name:"+name);
            System.out.println("Number of subjects: ");
            n = scan.nextInt();
            for(i=0;i<n;i++)
            {
            System.out.println("Enter mark: ");
            a[i]=scan.nextDouble();
            total= total +a[i];
            }
    }
    

    System.out.println("Total Marks:"+total);
    avg = total/n;
    System.out.print("Avergae percentage: " +avg);
    System.out.println(" %"); 
    if(avg<=100 && avg>96.67)
    {
         System.out.println("Grade: A+");
    }
    else if(avg<=96.67 && avg>=93.33) 
    {
        System.out.println("Grade: A");
    
    }
    else if(avg<=93.33 && avg>90.0) 
    {
        System.out.println("Grade: A-");
    
    }
    else if(avg<=90.0 && avg>86.67) 
    {
        System.out.println("Grade: B+");
    
    }
    else if(avg<=86.67 && avg>83.33) 
    {
        System.out.println("Grade: B");
    
    }
    else if(avg<=83.33 && avg>80.0) 
    {
        System.out.println("Grade: B-");
    
    }
    else if(avg<=80.0 && avg>76.67) 
    {
        System.out.println("Grade: C+");
    
    }
    else if(avg<=76.67 && avg>70.0) 
    {
        System.out.println("Grade: C");
    
    }
    else if(avg<=70.0 && avg>60.0) 
    {
        System.out.println("Grade: D");
    
    }
    else  
    {
        System.out.println("Grade: F");
    
    }

}
}
