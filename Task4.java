import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class Task4
{ 
    public static void main(String[]args)
    {
       System.out.println("Welcome to the quiz");
    ArrayList<Quiz> quiz = new ArrayList<Quiz>();
    
   quiz.add(new Quiz("1.Who is author of java ?",List.of("1.Dennis M.Ritchie, 2.James rowling, 3.charles Babbage, 4.Bjrane stroustrup"),2));
   quiz.add(new Quiz("2.What is symbol of java ?",List.of("1.Tree, 2.coffee cup, 3.Dolphin, 4.feather"),2));
    quiz.add(new Quiz("3.Which year java is established ?",List.of("1.1990, 2.1890, 3.1997, 4.1995"),4));
    quiz.add(new Quiz("4.What is current version of java ?",List.of("1.21, 2.19, 3.22, 4.24"),3));
    quiz.add(new Quiz("5.Which year java ring in invented?",List.of("1.1990, 2.1997, 3.1995, 4.1998"),4));
Scanner scanner = new Scanner(System.in);
int score = 0;
    for (Quiz q :quiz )
{
    System.out.println(q.getquestion());
    for(String option : q.getoption())
    {
System.out.println(option);
    }
ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            Callable<Integer> inputTask = () -> {
                System.out.print("Choose the option: ");
                return scanner.nextInt();
            };
            Future<Integer> future = executor.submit(inputTask);

            try {
                int answer = future.get(10, TimeUnit.SECONDS);
                if (answer == q.getcorrectoption()) {
                    score++;
                }
            } catch (TimeoutException e) {
                System.out.println("Time's up! Moving to the next question.");
                future.cancel(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            executor.shutdown();
        }

        System.out.println("Quiz over! Your final score is: " + score + " out of " + quiz.size());
        scanner.close();
    }
}
class Quiz{
    
    private String question;
    private List<String>option;
    private  int correctoption;
    Quiz(String question,List<String>option,int correctoption)
    {
        this.question = question;
        this.option = option;
        this.correctoption = correctoption;

    }

public String getquestion()
{
return question;
}
public List<String> getoption()
{
return option;

}
public int getcorrectoption()
{
    return correctoption;
}

}