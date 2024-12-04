//Author:Thomas
//Name:Array Zoo
//Date:dec.4
//Purpose:Print the species of zoo

public class ArrayZoo {
    public static void main(String[] args) {
        String animan [] = {"HoneyBudger", "Zorse", "Bangolin", "Bilby",
        "Hoatzin"};
        for (int i = 0;i<=animan.length;i++){
            System.out.println(animan[i]);
        }
        System.out.println();
        for (int i = 0;i<=animan.length;i++){
            System.out.print(animan[i]);
        }
        System.out.println();
        for (int i = 0;i<=animan.length;i++){
            System.out.println(animan[i]+" ");
        }
        System.out.println();
        for (int i = 0;i<=animan.length;i++){
            System.out.println(i+1+" "+animan[i]+"\n");
            System.out.println(animan[i]);
        }
    }
}