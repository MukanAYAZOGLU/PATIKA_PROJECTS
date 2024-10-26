import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {


    int row, column;
    int targetRow;
    int targetColumn;
    int numberOfMines, originOfMines;
    String mine = "*";
    String emty="-";
    int roundMines;
    int round;

    String[][] gameField;
    String[][] mineField;


    Scanner inp = new Scanner(System.in);
    Random rdm = new Random();



    public MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;

        this.gameField=new String [this.row][this.column];
        this.mineField=new String [this.row][this.column];


    }


    void matrixRangeControl() {


        while (this.row < 2 || this.column < 2) {

            System.out.println();

            System.out.println("Mayın tarlanız en az 2*2 boyutunda olmalıdır. Boyutu tekrar giriniz.");

            System.out.println();

            System.out.print("Satır Sayısı: ");
            this.row = inp.nextInt();


            System.out.print("Sütun Sayısı: ");
            this.column = inp.nextInt();

        }


    }


    private void organizingFields() {

        for (String[] strings : gameField) {

            Arrays.fill(strings, emty);
        }

        for (String[] strings : mineField) {

            Arrays.fill(strings, emty);

        }

    }


    void plantingMine() {

        numberOfMines = (this.row * this.column) / 4;

        do {

            originOfMines = 0;


            mineField[rdm.nextInt(0,this.row)][rdm.nextInt(0,this.column)] = mine;

            for (String[] a : mineField) {

                for (String b : a) {

                    if (Objects.equals(b, "*")) {

                        originOfMines++;

                    }

                }

            }


        } while (originOfMines != numberOfMines);


    }


    void printMineField() {

        System.out.println("Mayınların Konumu:");


            for (String [] a  : mineField) {

                    for (String b  :a) {

                        System.out.print(b);

                        }

                    System.out.println();
                }

    }


    void requestingTargetIndex() {


        System.out.print("Hedef satır numarası: ");
        targetRow = inp.nextInt();


        System.out.print("Hedef sütun numarası: ");
        targetColumn = inp.nextInt();

    }


    void lenghtControl() {


        while (targetRow > row-1 || targetColumn > column -1 || targetRow < 0 || targetColumn < 0) {

            System.out.println("Seçilen nokta, mayın tarlası dışındadır. Koordinatları tekrar giriniz.");


            System.out.print("Hedef satır numarası: ");
            targetRow = inp.nextInt();


            System.out.print("Hedef sütun numarası: ");
            targetColumn = inp.nextInt();

        }


    }


    void repeatingIndexControl() {


        while (!gameField[targetRow][targetColumn].equals("-")) {

            System.out.println("Bu koordinat daha önce seçildi, başka bir koordinat girin.");

            requestingTargetIndex();


            lenghtControl();

        }

    }


    void lastStep() {


        roundMines = 0;

        for (int i = (targetRow - 1); i <= (targetRow + 1); i++) {

            for (int j = (targetColumn - 1); j <= (targetColumn + 1); j++) {

                if (i >= 0 && j >= 0 && i  < row && j < column) {

                    if (Objects.equals(mineField[i][j],"*")) {

                        roundMines++;

                    }


                }

            }


            if (roundMines == 0) {

                gameField[targetRow][targetColumn] = "0";


            } else {

                gameField[targetRow][targetColumn] = "" + roundMines;

            }

            gameField[targetRow][targetColumn] = "" + roundMines;

        }
    }


    void writingGameField() {

        for (String [] a  : gameField) {

            for (String b  :a ) {

                System.out.print(b);

            }

            System.out.println();

        }
        System.out.println("###############");

    }


    boolean loserControl() {

        if (Objects.equals(mineField[targetRow][targetColumn],"*")) {

            gameField[targetRow][targetColumn]="X";

            return true;

        }

        return false;
    }



    boolean winnerControl(){

        return round == 0;
    }



    void run1() {

        matrixRangeControl();

        organizingFields();

        plantingMine();

        printMineField();

        round=(this.row*this.column)-numberOfMines;

    }


    void run2() {

        do{


            requestingTargetIndex();

            lenghtControl();

            repeatingIndexControl();

            round--;



            if (loserControl()) {

                writingGameField();

                System.out.println("Mayına bastınız.\nOyunu kaybettiniz.");

                break;

            }else if (winnerControl()) {

                lastStep();

                for(int i = 0; i <gameField.length; i++) {

                    System.arraycopy(gameField[i], 0, mineField[i], 0, gameField[i].length);

                }

                for(int i = 0; i <gameField.length; i++) {

                    for(int j = 0; j <gameField[i].length ; j++) {

                        if (Objects.equals(mineField[i][j],"-")) {

                            mineField[i][j]="*";

                        }

                    }

                }


                printMineField();

                System.out.println("Tebrikler. Kazandınız.");

                break;


            } else {

                lastStep();

                writingGameField();

                run2();

            }

        }while(!loserControl() && !winnerControl());


    }








}
