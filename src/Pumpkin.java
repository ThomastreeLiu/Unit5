//Name:Pumpkin
//Author:Thomas
//Date:Dec.10
//Purpose:Print the info of pumpkin

public class Pumpkin {
    public static void main (String args[]){
        int weight[] = {222,235,335,410,380,577,262,430,211,279,408,292};
        for (int i = 0;i<weight.length;i++){
            System.out.print(i+1+":"+weight[i]);
            System.out.print("  ");
        }
        int avg = 0;
        for (int i = 0;i<weight.length;i++){
            avg=avg+weight[i];
        }
        avg=avg/ weight.length+1;
        System.out.println("\nAverage:"+avg);
        int max=0;
        for (int i = 0;i< weight.length;i++){
            if (weight[i]>max)
                max=weight[i];
        }
        System.out.println("Biggest:"+max);
    }
}