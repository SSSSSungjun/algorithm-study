import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // Читаем N
        int L = Integer.parseInt(st.nextToken()); // Читаем L

        Deque<int[]> deque = new ArrayDeque<>(); // Дек для хранения минимального значения в окне

        st = new StringTokenizer(br.readLine()); // Читаем массив чисел
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());

            // Удаляем из дека все элементы, которые больше текущего числа
            while (!deque.isEmpty() && deque.peekLast()[0] > input) {
                deque.pollLast();
            }

            // Добавляем текущий элемент и его индекс в дек
            deque.offerLast(new int[]{input, i});

            // Если первый элемент дека выходит за границы окна, удаляем его
            if (deque.peekFirst()[1] <= i - L) {
                deque.pollFirst();
            }

            // Добавляем минимальный элемент текущего окна в результат
            sb.append(deque.peekFirst()[0]).append(" ");
        }
        System.out.println(sb);
    }
}
// Если Scanner не работает, а BufferedReader работает, это будет немного раздражать
// Но все равно попробуем!
