public class ThreadThirdClass extends ThreadFirstClass{

    @Override
    public void run() {
               synchronized (LOCK){
            for(int a: ThreadMainClass.list3  ) {
                increment(a);

            }
        }
    }
}
