public class HeatMap {
    public static void main (String args[]){
        double total = 0;
        int max = 0;
        String maxc="";
        int min = 10;
        String minc="";
        double amt = 0;
        int row = 16;
        int col = 16;
        int heatmap[] [] = {{1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1,	2,	2,	2,	4,	5,	2,	2,	1,	1,	1,	1,	1,	2,	1,	1},
                {1,	2,	2,	3,	4,	3,	3,	1,	1,	1,	1,	1,	1,	1,	2,	1},
                {1,	1,	2,	3,	3,	2,	1,	1,	1,	1,	1,	1,	1,	3,	1,	1},
                {1,	1,	2,	2,	2,	2,	1,	1,	2,	1,	1,	1,	1,	1,	1,	1},
                {1,	1,	1,	2,	1,	1,	1,	1,	1,	2,	1,	1,	2,	1,	1,	1},
                {1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	2,	2,	1,	1,	1},
                {1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	3,	3,	3,	1,	2,	1},
                {1,	2,	2,	2,	1,	1,	1,	1,	3,	3,	4,	4,	4,	3,	2,	1},
                {1,	2,	2,	3,	5,	1,	1,	1,	3,	4,	6,	6,	4,	3,	1,	1},
                {1,	1,	2,	4,	5,	5,	1,	1,	3,	6,	7,	8,	5,	4,	2,	1},
                {1,	1,	3,	3,	5,	5,	3,	1,	1,	5,	6,	7,	5,	4,	2,	1},
                {1,	1,	1,	2,	3,	3,	1,	1,	3,	4,	4,	6,	5,	3,	2,	1},
                {1,	1,	1,	2,	3,	3,	1,	1,	3,	3,	4,	4,	4,	3,	2,	1},
                {1,	2,	1,	1,	2,	2,	1,	2,	1,	1,	3,	3,	1,	3,	1,	1},
                {1,	1,	1,	1,	1,	1,	1,	1,	1,	2,	1,	1,	1,	1,	1,	1}};
        for (int i = 0;i<row;i++){
            for (int e = 0;e<col;e++){
                System.out.print(heatmap[i][e]+"  ");
                total=total+heatmap[i][e];
                amt=amt+1;
                if (e==15)
                    System.out.println();
                if (heatmap[i][e]>max) {
                    max = heatmap[i][e];
                }
                if (heatmap[i][e]<min) {
                    min = heatmap[i][e];
                }
            }
        }
        System.out.println("Total:"+total);
        System.out.println("Average:"+total/amt);
        System.out.println("Min:"+min);
        System.out.println("Coordinate:\n");
        for (int i = 0;i<row;i++){
            for (int e = 0;e<col;e++) {
                if (heatmap[i][e]==min)
                    System.out.println("("+i+","+e+")");
            }
        }
        System.out.println("Max:"+max);
        System.out.println("Coordinate:\n");
        for (int i = 0;i<row;i++){
            for (int e = 0;e<col;e++) {
                if (heatmap[i][e]==max)
                    System.out.println("("+i+","+e+")");
            }
        }
    }
}
