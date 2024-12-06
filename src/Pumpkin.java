public class Pumpkin {
    public static void main (String args[]){
        int weight[] = {222,235,335,410,380,577,262,430,211,279,408,292};
        for (int i = 0;i<weight.length;i++){
            System.out.print(i+1+"."+weight[i]);
            System.out.print("  ");
        }
        int num = 0;
        for (int i = 0;i<weight.length;i++){
            num=num+weight[i];
        }
        System.out.print("Total:"+num);
    }
}
