public class ThreadFirstClass implements Runnable{

    public final Object LOCK= new Object();

    @Override
    public void run() {
        synchronized (LOCK){
            for(int a: ThreadMainClass.list1  ) {
                increment(a);

            }
        }

    }

    public void increment(int i) {

        if (i%2==0) {
            System.out.println (Thread.currentThread().getThreadGroup().getName() + " : "+ i);
            ThreadMainClass.evenNumbers.add(i);
        }else {
            System.out.println (Thread.currentThread().getThreadGroup().getName() + " : "+ i);
            ThreadMainClass.oddNumbers.add(i);
        }

    }





}
