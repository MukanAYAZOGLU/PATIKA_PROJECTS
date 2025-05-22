import java.util.*;

public class MatchFixtur {

    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();

    static int numOfTeams;

    static List<String> teams = new ArrayList<>();


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
                makeFixture();

            }

            if (numOfTeams < 2 || numOfTeams > 10) {

                System.out.println("Please enter an integer value between 2 and 10.");
                System.out.print("Your Value: ");

            } else break;

        }

        if (numOfTeams % 2 == 1) {
            teams.add("Bay");
        }

        System.out.println("Enter names of Teams");


        while (true) {

            System.out.print(++i + "- ");

            if (scan.hasNextInt() || scan.hasNextByte() || scan.hasNextDouble() || scan.hasNextLong() || scan.hasNextFloat()) {

                scan.nextLine();
                System.out.println("Please enter a String value. Try Again.");
                --i;

            } else {

                if (scan.hasNextLine()) {

                    team = scan.nextLine().toLowerCase().trim();

                    if (team.isEmpty()) {

                        System.out.println("Entered empty value. Try Again.");
                        --i;

                    } else {

                        if (teams.contains(team)) {

                            System.out.println("This team is already exists. Try Again.");
                            --i;

                        } else {
                            teams.add(team);

                        }
                    }


                }
            }

            if (numOfTeams % 2 == 0 && teams.size() == numOfTeams) break;
            else if (numOfTeams % 2 != 0 && teams.size() == numOfTeams + 1) break;


        }


        System.out.println("All teams are written on the fixture.");


    }


    public static void printFixture() {


        HashMap<String,String> matchingTeams = new HashMap<>();
        List<String> fixture1=new ArrayList<>();
        List<String> fixture2=new ArrayList<>();


        String firstTeam;
        String secondTeam;

        int rounds=(teams.size()-1)*2;

        for (int i = 1; i <=rounds ; i++) {


            System.out.println ("---------------- "+(i)+" Round ---------------");
            System.out.println ("Ev Sahibi --------------------- Deplasman");



            do {

                firstTeam=teams.get(random.nextInt(teams.size()));
                secondTeam=teams.get(random.nextInt(teams.size()));

            }while(firstTeam.equals(secondTeam) && (fixture1.indexOf(firstTeam)==fixture2.indexOf(secondTeam)));


            System.out.println (firstTeam + "           vs           " + secondTeam);
            System.out.println (secondTeam + "           vs           " + firstTeam);



            fixture1.add(firstTeam);
            fixture2.add(secondTeam);











            }




























    }

}