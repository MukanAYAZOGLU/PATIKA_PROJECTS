import java.util.*;

public class Fixture {

    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();
    static int numOfTeams;

    static List<String> allTeams = new ArrayList<>();


/*
    public static void makeFixture() {
        int i = 0;
        String team;

        System.out.print("How many teams will be playing: ");

        while (true) {

            try {

                numOfTeams = scan.nextInt();
                scan.nextLine();

            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Unknown value entered. Make sure your input is Integer!");
                continue;

            }

            if (numOfTeams < 2 || numOfTeams > 10) {

                System.out.println("Please enter an integer value between 2 and 10.");
                System.out.print("Your Value: ");

            } else break;

        }

        if (numOfTeams % 2 == 1) {
            allTeams.add("Bay");
        }

        System.out.println("Enter names of Teams");


        while (true) {

            System.out.print(++i + "- ");

            if (scan.hasNextInt() || scan.hasNextByte() || scan.hasNextDouble() || scan.hasNextLong() || scan.hasNextFloat()) {

                scan.nextLine();
                System.out.println("Please enter a String value. Try Again.");
                --i;

                continue;

            } else {

                if (scan.hasNextLine()) {

                    team = scan.nextLine().toLowerCase().trim();

                    if (team.isEmpty()) {

                        System.out.println("Entered empty value. Try Again.");
                        --i;

                        continue;

                    } else {

                        if (allTeams.contains(team)) {

                            System.out.println("This team is already exists. Try Again.");
                            --i;

                            continue;

                        } else {
                            allTeams.add(team);

                        }
                    }


                }
            }

            if (numOfTeams % 2 == 0 && allTeams.size() == numOfTeams) break;
            else if (numOfTeams % 2 != 0 && allTeams.size() == numOfTeams + 1) break;


        }


        System.out.println("All teams are written on the fixture.");


    }


 */




    public static void printFixture() {

        allTeams.add("ankara");
        allTeams.add("ordu");
        allTeams.add("bursa");
        allTeams.add("edirne");

        Collections.shuffle(allTeams);

        List<String > temporary1=allTeams.subList(0, numOfTeams/2);
        List<String > temporary2=allTeams.subList(numOfTeams/2, numOfTeams);

        List<String > list1=new ArrayList<>();
        List<String > list2=new ArrayList<>();


        int round=(allTeams.size()*2)-1;


        String firsTeam;
        String secondTeam;


        for (int i = 0; i < numOfTeams/2; i++) {

            list1.add(temporary1.get(i));
            list2.add(temporary2.get(i));


        }








/*

        System.out.println ("---------------- "+(i)+" Round ---------------");

        System.out.println ("Ev Sahibi --------------------- Deplasman");

        System.out.println ("---------------------------");



 */






            }






}