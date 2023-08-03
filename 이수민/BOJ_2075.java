import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder()); // ���� ������������ �����ϴ� �켱���� ť
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                queue.add(Integer.parseInt(st.nextToken())); // ���� �ϳ��ϳ� ť�� ����
            }
        }
        for (int i=1; i<n; i++) {
            queue.poll(); // n-1��ŭ �տ� �ִ� ���� �����ϰ�,
        }
        System.out.println(queue.peek()); // n��° ���� ����Ѵ�.

    }
}
