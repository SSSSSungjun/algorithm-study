import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static int m;
    static int tn;
    static ArrayList<Integer>[] party;
    static ArrayList<Integer> al;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        party = new ArrayList[m];
        visited = new boolean[m];

        for(int i=0; i<m; i++) party[i] = new ArrayList<>();

        tn = sc.nextInt();
        al = new ArrayList<>();
        for(int j=0; j<tn; j++) al.add(sc.nextInt());

        for(int i=0; i<m; i++) {
            int pn = sc.nextInt();

            for(int j=0; j<pn; j++) {
                party[i].add(sc.nextInt());
            }
        }

        recursive();

        int count = 0;
        for(boolean b : visited) {
            if(!b) count++;
        }

        System.out.println(count);

    }

    private static void recursive() {
        for(int i=0; i<m; i++) {
            if(visited[i]) continue;
            for(int j=0; j<party[i].size(); j++) {
                if(al.contains(party[i].get(j))) {
                    al.addAll(party[i]);
                    visited[i] = true;
                    recursive();
                    return;
                }    
            }
        }
    }
}