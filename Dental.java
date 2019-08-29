import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dental {
    private String name;
    private int time;

    public Dental(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int out;
        int n = sc.nextInt();
        Queue<Dental> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String time = sc.next();
            q.add(new Dental(name.substring(1, name.length()), Integer.parseInt(time.substring(5, time.length()))));
        }
        out = sc.nextInt();
        for (int i = 0; i < out; i++) {
            String org = sc.next();
            for (Dental j : q) {
                if (org.substring(1, org.length()).equals(j.name)) {
                    j.time = 0;
                }
                sum += j.time;
            }
        }
        //System.out.println(sum) ;
        int past = sc.nextInt();
        int total = sum - past;
        int count = 0;
        int k = 0 ;
        int i = 0;
        for (Dental j : q) {
            if (j.time - past < 0) {
                past -= j.time ;
                j.time = 0;
                i++ ;

            }
            else if(j.time - past > 0){
                past -= j.time ;
                if(i>=k){
                    j.time = 0 ;
                }
            }
            else if(j.time - past == 0){
                past -= j.time ;
                j.time = 0 ;
                i++ ;
            }
            k++;

        }

        for (Dental j : q) {
            if (j.time != 0) {
                System.out.println(j.name);
            }
        }
    }
}


