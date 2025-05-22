import java.util.*;

public class Main {

    public static void main(String[] args) {




        Scanner scanner = new Scanner(System.in);
        ArrayList<String> teams = new ArrayList<>();

        int maxTeams = 8;
        int numberOfTeams = 0;

        while (true){
            System.out.print("Kaç takım gireceksiniz ? (En fazla " + maxTeams + " olabilir) : ");
            try{
                numberOfTeams = scanner.nextInt();
                if (numberOfTeams >= 2 && numberOfTeams <= 8){
                    break;
                }else {
                    System.out.println("Lütfen 2 ile " + maxTeams + " arasında bir değer giriniz!");
                }
            }catch(Exception e){
                System.out.println("Geçersiz giriş! Lütfen geçerli bir sayı girin.");
                scanner.next();
            }
        }


        for (int i = 0; i < numberOfTeams; i++){
            System.out.print((i+1) + ". takım ismini giriniz: ");
            String teamName = scanner.next();
            teams.add(teamName);
        }

        System.out.println("------------------------------------------------");

        if (teams.size() % 2 != 0 ){
            teams.add("Bay");
        }

        int numOfRounds = (teams.size() -1 ) * 2;
        int matchesPerRound = teams.size() / 2;

        ArrayList<String> tempTeams = new ArrayList<>(teams);
        for (int round = 1; round <= numOfRounds/2; round++){
            System.out.println("#################################");
            System.out.println("Round " + round);
            System.out.println("#################################");

            for (int i = 0; i < matchesPerRound; i++){
                String home = tempTeams.get(i);
                String away = tempTeams.get(tempTeams.size() - i - 1);
                System.out.printf("%-15s %-4s %-15s\n",home, "vs", away);
            }

            Collections.rotate(tempTeams.subList(1, tempTeams.size()), 1);
            System.out.println();
        }

        for (int round = numOfRounds/2 + 1; round <= numOfRounds; round++){

            System.out.println("#################################");
            System.out.println("Round " + round);
            System.out.println("#################################");

            for (int i = 0; i < matchesPerRound; i++){
                String home = tempTeams.get(tempTeams.size() - i - 1);
                String away = tempTeams.get(i);
                System.out.printf("%-15s %-4s %-15s\n",home, "vs", away);
            }

            Collections.rotate(tempTeams.subList(1, tempTeams.size()), 1);
            System.out.println();
        }


    }
}