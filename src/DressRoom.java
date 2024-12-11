public class DressRoom {
    public static void main (String args[]){
        int rooms[] = {100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114,
                115, 116, 117, 118, 119, 120, 121, 122, 123, 124};
        System.out.println("Room list");
        for (int i = 0;i<rooms.length;i++){
            System.out.println(rooms[i]);
        }
        System.out.println("\nLight replace list");
        for (int i = 0;i<rooms.length;i++){
            if (rooms[i]%2==0)
                System.out.println(rooms[i]);
        }
        System.out.println("\ncarpet clean list");
        int e=0;
        for (int i = 0;i<rooms.length;i++){
            e++;
            if (e%4==0)
                System.out.println(rooms[i]);
        }
    }
}
