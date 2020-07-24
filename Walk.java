package JavaBooksEx.Project_summer;
import java.util.*;
import java.io.*;
public class Walk extends Field {
    Scanner inpt = new Scanner(System.in);
    public static int numberOfMoves;
    public static Info info;
    Walk(int n){
        this.numberOfMoves = n;
    }

    //String[][] field = new String[numberOfMoves][numberOfMoves];
    public  int shiprow = (int)(Math.random()*numberOfMoves);
    public  int shipcol = (int)(Math.random()*numberOfMoves);

    private static String w1;
    private static  int n1,n2;
    private static boolean playN = true;
    private static boolean randomN = true;
    ////////////Walk Player///////////////////////////////////////////////
    @Override
    public void walkPerson() {
        System.out.println();
        System.out.println("Ques row and column(PLEASE write without space,with by comma(Ex.-> 1,1)), NOTE: field coordinates start at 0 ");
        System.out.print("Your walk: ");
        w1 = inpt.nextLine();
        System.out.println();
        String[] q = w1.split(",");
        n1 = Integer.parseInt(q[0]);
        n2 = Integer.parseInt(q[1]);
        boardsP(n1,n2);
    }
    private static ArrayList<Integer> wlk= new ArrayList<>();
    int wlkn1,wlkn2;

    @Override
    public void walkRandom(){
        for(int i=0;i<numberOfMoves*2;i++){
            wlk.add((int)(Math.random()*numberOfMoves));
        }
        if(wlk!=null) {
            wlkn1 = wlk.get(0);
            wlk.remove(0);
            wlkn2 = wlk.get(0);
            wlk.remove(0);
            boardsR(wlkn1, wlkn2);
        }
    }
    //////////Check Board//////////////////////////////////////////////////////
    @Override
    public void boardsP(int n1,int n2) {
        if (shiprow != n1 && shipcol != n2) {
            if (fieal [n1][n2]!="*") {
                System.out.println("You walk");
                fieal[n1][n2] = "*";
                for (int i = 0; i < fieal.length; i++) {
                    for (int j = 0; j < fieal[i].length; j++) {
                        System.out.print(fieal[i][j] + " ");
                    }
                    System.out.println();
                }

            }else
                walkPerson();

        }
        else{
            fieal[n1][n2] = "#";
            for (int i = 0; i < fieal.length; i++) {
                for (int j = 0; j < fieal[i].length; j++) {
                    System.out.print(fieal[i][j] + " ");
                }
                System.out.println();
            }
            playN = false;
        }
    }

    @Override
    public void boardsR(int n1, int n2) {

        System.out.println("Walk Enemy");
        if (shiprow != n1 && shipcol != n2) {
            if (fieal [n1][n2]!="*") {

                fieal[n1][n2] = "*";
                for (int i = 0; i < fieal.length; i++) {
                    for (int j = 0; j < fieal[i].length; j++) {
                        System.out.print(fieal[i][j] + " ");
                    }
                    System.out.println();
                }

            }else
                walkRandom();

        }
        else if(shiprow == n1 && shipcol == n2){
            fieal[n1][n2] = "#";
            for (int i = 0; i < fieal.length; i++) {
                for (int j = 0; j < fieal[i].length; j++) {
                    System.out.print(fieal[i][j] + " ");
                }
                System.out.println();
            }
            randomN = false;
        }
    }
//////////////////////////////////////////////////////////////////////////////
    public boolean res() throws IOException{
        boolean qqwe ;
        if(playN != true){
            finishP();
            qqwe = playN;
            return qqwe;
        }else if(randomN !=true){
            finishR();
            qqwe = randomN;
            return qqwe;
        }
        else{
            return randomN;
        }

    }
    public void finishP() throws IOException{
        System.out.println("!!!!!!!YOU WIN!!!!!!!!!!");
        info = new Info(1);
        info.res();
    }
    public void finishR() throws IOException{
        System.out.println("!!!!!!YOU LOSE!!!!!!");
        info = new Info(0);
        info.res();
    }
}
