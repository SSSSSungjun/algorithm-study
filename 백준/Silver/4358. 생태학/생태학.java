
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> hm = new HashMap<>();
		PriorityQueue<String> pq = new PriorityQueue<>();
		int cnt = 0;

		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			if (input.isEmpty())
				break;
			if (hm.containsKey(input))
				hm.put(input, hm.get(input) + 1);
			else {
				pq.add(input);
				hm.put(input, 1);
			}
			cnt++;

		}

		while (!pq.isEmpty()) {
			String key = pq.poll();
			System.out.println(key + " " + String.format("%.4f", hm.get(key) * 100 / (double) cnt));
		}

	}
}
