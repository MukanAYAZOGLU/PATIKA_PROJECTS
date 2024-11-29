import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        String  userWord;
        String reflectionWord = "";

        System.out.print("Kelimenizi giriniz: ");
        userWord=inp.next();

        userWord=userWord.toLowerCase();


        for(int i = userWord.length()-1; i>=0; i--) {

            reflectionWord+=userWord.charAt(i);

        }

        System.out.println("Girilen kelime: "+userWord);
        System.out.println("Girilen kelimenin tersi: "+reflectionWord);


        if (userWord.equals(reflectionWord)) {

            System.out.println(userWord+" kelimesi, palindromik bir kelimedir.");

        }else
            System.out.println(userWord+" kelimesi, palindromik bir kelime değildir.");








    }
}