package JavaBooksEx.Project_summer;

public abstract class Field implements Moves{
    public static String[][] fieal;
    public static void board(int n){
        fieal = new String[n][n];
        for(int i=0;i<fieal.length;i++){
            for(int j=0;j<fieal[i].length;j++){
                fieal[i][j] = "0";
            }
        }
        for(int i=0;i<fieal.length;i++){
            for(int j=0;j<fieal[i].length;j++){
                System.out.print(fieal[i][j] + " ");
            }
            System.out.println();
        }

    }
    public abstract void boardsR(int n1,int n2);
    public abstract void boardsP(int n1,int n2);


}
