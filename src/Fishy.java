//Name:Fishy
//Author:Thomas
//Date:Dec.10
//Purpose:Print the info of fish

public class Fishy {
    public static void main (String[] args){
        int weight[] = {226, 305, 233, 244, 224, 235, 238, 244, 222,
                239, 233,243, 221, 230, 237, 240, 309, 230
        };
        for (int i = 0;i<weight.length;i++){
            System.out.println(i+1+":"+weight[i]);
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
        System.out.println("Biggest:"+max+"\n");
        int min=0;
        for (int i = 0;i< weight.length;i++){
            if (weight[i]>min)
                min=weight[i];
        }
        System.out.println("Smallest:"+min+"\n");
        System.out.println("Weight larger then 240 ");
        for (int i = 0;i< weight.length;i++){
            if (weight[i]>240)
                System.out.print(weight[i]+" ");
        }
    }
}