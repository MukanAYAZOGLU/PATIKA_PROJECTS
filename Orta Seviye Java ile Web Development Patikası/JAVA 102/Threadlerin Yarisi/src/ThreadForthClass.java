public class ThreadForthClass extends ThreadFirstClass{

    @Override
    public void run() {
                synchronized (LOCK){
            for(int a: ThreadMainClass.list4  ) {
                increment(a);

            }
        }
    }
}
