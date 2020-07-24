package JavaBooksEx.Project_summer;
import java.util.*;
import java.io.*;
public class Info {
    private String name;
    private String surname;
    private int result;
    private String reswinlose = "Game result: ";
    private String won = " won";
    private String lost = " lost";
    Info(String newName,String surname){
        this.name = newName;
        this.surname = surname;
    }
    Calendar calendar = Calendar.getInstance();

    Info(int result){
        this.result = result;
    }
    public void infoFile()throws IOException{
        try(PrintWriter output = new PrintWriter(new FileOutputStream("Player'sNames.txt",true));){
            output.println();
            output.print(name);
            output.print(" ");
            output.print(surname);
            output.println("       ");
            output.print("Start time: ");
            output.print(calendar.getTime());
            output.println("  ");
            output.print("End time: ");
            output.print(calendar.getTime());
            output.println("  ");
        }
    }
    public void res()throws IOException{
        try(PrintWriter output = new PrintWriter(new FileOutputStream("Player'sNames.txt",true));){
            output.print(reswinlose);
            if(result==1){
                output.print(won);
                output.println();
                output.println();
            }
            else{
                output.print(lost);
                output.println();
                output.println();
            }
        }
    }
}
