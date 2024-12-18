public class HeatMapL {
    public static void main (String args[]){
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
                if (heatmap[i][e]==1)
                    System.out.print(" ");
                else if (heatmap[i][e]==2)
                    System.out.print(".");
                else if (heatmap[i][e]==3)
                    System.out.print(",");
                else if (heatmap[i][e]==4)
                    System.out.print(";");
                else if (heatmap[i][e]==5)
                    System.out.print("*");
                else if (heatmap[i][e]==6)
                    System.out.print("#");
                else if (heatmap[i][e]==7)
                    System.out.print("&");
                else if (heatmap[i][e]==8)
                    System.out.print("%");
                System.out.print(" ");
                if (e==15)
                    System.out.println("");
            }
        }
    }
}