public class Main {
    public static void main(String[] args) {

        String [] [] letterWithStars= new String [6][4];

        for(int i = 0; i <letterWithStars.length ; i++) {

            for(int j = 0; j <letterWithStars[i].length ; j++) {

                if (i==0 || i==2) {

                    letterWithStars[i][j]=" * ";

                }else if(j==0 || j==3){

                    letterWithStars[i][j]=" * ";

                } else letterWithStars[i][j]="   ";

            }

        }

    for (String [] j : letterWithStars ) {
            for (String m :j ) {
                System.out.print(m);

                }

            System.out.println();
        }

    System.out.println();
    System.out.println();
    System.out.println();


        //B LETTER WİTH STARS

        String [] [] letterWithStars2= new String [7][7];

        for(int i = 0; i < letterWithStars2.length; i++) {

            for(int j = 0; j <letterWithStars2[i].length ; j++) {

                if (i==0  ||i==3 ||  i==6) {

                    letterWithStars2[i][j]=" * ";

                }else if(j==0 || j==1 || j==6){
                    
                    letterWithStars2[i][j]=" * ";
                    
                } else letterWithStars2[i][j]="   ";

            }

        }
                    for ( String [] row :letterWithStars2 ) {
                        
                            for ( String col :row ) {

                                System.out.print(col);

                                }

                            System.out.println();
                        
                        }
                
                
                





    }
}