public class Mocap{

    public static void main (String args[]){

        new Mocap();
    }

    public Mocap (){

        int x[] = {234, 345, 348, 456, 567, 765, 654, 544, 587, 578};
        int y[] = {456, 456, 345, 347, 346, 467, 562, 562, 532, 576};
        int z[] = {345, 324, 312, 317, 304, 305, 307, 308, 309, 298};
        for (int i =0;i<x.length;i++){
            System.out.println("("+x[i]+", "+y[i]+", "+z[i]+")");
        }
        System.out.println();
        for (int i =0;i<x.length;i++){
            if (x[i]<550)
                System.out.println("("+x[i]+", "+y[i]+", "+z[i]+")");
        }
    }
}
