
public class MyList <T> {

    private int capacity=10;

    private T [] myList= (T[])new Object[capacity];

    public MyList() {

        this.myList= (T []) new Object[this.capacity];
    }

    public MyList(int capacity) {

        this.capacity=capacity;



    }

    public int size () {

        int size=0;

        for(T a: myList ) {

            if (a!=null) {
                size++;
            }

        }



        return size;

    }

    public int getCapacity() {


           return this.myList.length;


    }

    public void add(T element) {

        if (this.size()==this.capacity) {

            this.capacity*=2;

            T [] spareList= (T[])new Object[capacity];

            for (int i = 0; i < myList.length ; i++) {

                spareList[i]=myList[i];

            }

            myList=spareList;

           myList[size()]=element;


        } else {

            myList[this.size()]=element;
        }

    }

    public T get(int index) {


        if (index>=myList.length) {

            return null;

        } else return myList[index];

    }

    public void remove (int index) {

        if (index<myList.length) {

            for (int i = index; i< myList.length ; i++) {

                if (i+1>= myList.length) {

                    this.capacity=i+1;
                    break;

                }else
                    myList[i]=myList[i+1];





            }



        } else System.out.println ("Null");


    }

    public void set (int index, T element) {

        if (index<myList.length) {

            myList[index]=element;

        }else System.out.println ("Null");



    }

    public String toString() {

        String str="[ ";

        for(T a: myList ) {

            if (a!=null) {

                str+=a+" ";
            }


            }

        str+="]";





        return str;
    }

    public int indexOf(T element) {

        for (int i = 0; i < myList.length ; i++) {

            if (myList[i]==element) {

                return i;

            }
        }

return -1;





    }

    public int lastIndexOf(T element) {

        for (int i = myList.length-1; i >=0 ; i--) {

            if (myList[i]==element) {

                return i;


            }
        }

return -1;


    }

    public boolean isEmpty() {

        int b=0;
            for(T a: myList ) {

                if (a==null) {

                    b++;

                }
            }

            if (b==myList.length) {

                return true;
            } else return false;


    }

    public T [] toArray() {

        T  [] newList;

        newList=myList;

        return newList;
    }

    public void clear() {

        for (int i = 0; i < myList.length ; i++) {

            myList[i]=null;

        }

    }

    public MyList <T> subList(int start, int end) {
        MyList <T>  newList = new MyList<>();

        for (int i = start; i <=end ; i++) {

             newList.myList[i]=myList[i];

        }

        return newList;

    }

    public boolean contains(T element) {
        for(T a: myList ) {
            if (a==element) {

                return true;
            }

        }
        return false;

        
    }



}
