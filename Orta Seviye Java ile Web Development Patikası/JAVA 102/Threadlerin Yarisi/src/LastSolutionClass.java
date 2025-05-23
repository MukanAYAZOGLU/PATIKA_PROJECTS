import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LastSolutionClass {

    public static void main(String[] args) {

        new ThreadMainClass();
        ThreadFirstClass threadFirstClass= new ThreadFirstClass();
        ThreadSecondClass threadSecondClass= new ThreadSecondClass();
        ThreadThirdClass threadThirdClass= new ThreadThirdClass();
        ThreadForthClass threadForthClass= new ThreadForthClass();

        threadFirstClass.run();
        threadSecondClass.run();
        threadThirdClass.run();
        threadForthClass.run();

        /*
        ExecutorService executorService= Executors.newFixedThreadPool(16);

        for (int i = 0; i <16 ; i++) {

            executorService.execute(threadFirstClass);
            executorService.execute(threadSecondClass);
            executorService.execute(threadThirdClass);
            executorService.execute(threadForthClass);

        }

        executorService.close();


         */


        System.out.println("First status for event array : "+ ThreadMainClass.evenNumbers.toString());
        System.out.println ();
        System.out.println ();
        System.out.println("Last status for event array : "+ ThreadMainClass.oddNumbers.toString());






    }



}
