package JavaBooksEx.Project_summer;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static Info info;
    static int sizeField;
    public static Walk walk;
    public static int answer;
    public static void main(String[]args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("   :-)    Hello!!!     :)");
        System.out.print("What is your name?: ");
        String plName= input.nextLine();
        System.out.print("What is your surname?: ");
        String pSurname = input.nextLine();
        System.out.println("Do you want to play a game (Battleship) " + plName+" ?");
        System.out.println("1-------YES            0--------NO");
        System.out.print("Your answer: ");
        answer = input.nextInt();
/////////////////////////////////////////////////////////////////////////////////////
        if( answer==1 ){
            info = new Info(plName,pSurname);
            info.infoFile();

            System.out.print("Size field(int): ");
            sizeField = input.nextInt();

            walk = new Walk(sizeField);

            System.out.println();
            System.out.println();
            System.out.println("BATTLESHIP on field " + sizeField + "x" + sizeField);
            System.out.println();

            Field.board(sizeField);
            boolean n=true;
            while(n!=false){

                walk.walkPerson();
                walk.walkRandom();
                n=walk.res();
            }


        }
        else if(answer==0){
            System.out.println("GOOD BYE! :(");
        }


    }
}
