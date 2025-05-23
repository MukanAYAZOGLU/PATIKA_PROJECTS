import java.util.ArrayList;
import java.util.List;

public class ThreadMainClass {

    public static List<Integer> mainList =new ArrayList<>();
    public static List<Integer> list1;
    public static List<Integer> list2;
    public static List<Integer> list3;
    public static List<Integer> list4;
    public static List<Integer> evenNumbers=new ArrayList<>();
    public static List<Integer> oddNumbers= new ArrayList<>();


    public ThreadMainClass() {

        for (int i = 1; i <=1000 ; i++) {
            mainList.add(i);
        }

        list1=mainList.subList(0,250);
        list2=mainList.subList(250,500);
        list3=mainList.subList(500,750);
        list4=mainList.subList(750,1000);


    }




}