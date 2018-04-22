import java.awt.*;

public class Blank {
    public static void main(String[] args){
        int[] x = {1,3,5};
        int[] y = {0,0,0};
        y = x;
        Object amir = new Object(new Rectangle(0,0,0,0), true);
        System.out.println(amir.getFaggot());
    }
}