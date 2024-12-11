public class MoviePosters{

    public static void main (String args[]){

        new MoviePosters();
    }

    public MoviePosters(){
        System.out.println("Avatar starring.... \n");
        String first[] = {"Sam", "Zoe", "Sigourney", "Stephen", "Kate", "Cliff", "Joel", "CCH", "Edie", "Brendan", "Jemaine"};
        String last[] = {"Worthington", "Saldana", "Weaver", "Lang", "Winslet", "Curtis", "Moore", "Pounder", "Falco", "Cowell", "Clement"};
        for (int i =0;i<first.length;i++){
            System.out.println(first[i]+" "+last[i]);
        }
    }
}