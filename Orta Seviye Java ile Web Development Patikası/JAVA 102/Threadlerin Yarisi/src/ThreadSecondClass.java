public class ThreadSecondClass extends ThreadFirstClass{

    @Override
    public void run() {
        synchronized (LOCK){
            for(int a: ThreadMainClass.list2  ) {
                increment(a);

            }
        }
    }
}
