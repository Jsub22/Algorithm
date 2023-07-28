import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // ���� ���� ���� ����
        int l = Integer.parseInt(st.nextToken()); // �������� ����

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(); // ���� ���� ���� ��ġ���� ������ ť
        while(st.hasMoreTokens()){
            queue.add(Integer.parseInt(st.nextToken())); // ���� ���� ���� ��ġ�� ����� ������ ������� �����
        }

        int cnt = 1; // �ʿ��� �������� ����
        int cur = queue.poll(); // ���� ���� ���� ��ġ
        while(!queue.isEmpty()){
            if (cur+l > queue.peek()){ // ���� ���� ���� ��ġ�� ���� ���� ���� ��ġ�� �������� ������ �պ��� �۴ٸ�, ���� �������� ���� ���� �� �ִ�.
                queue.poll();
            } else { // �ƴ϶�� �� ��ġ���� ���� ���ο� �������� ����Ѵ�.
                cur = queue.poll();
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
