import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // ������ ũ�⿡ ���� ���� ������ ���� compare �޼ҵ� ������
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int tmp = Math.abs(o1) - Math.abs(o2);
                if (tmp == 0) // ������ ���� ���, �� ���� ���� �켱 �� �� �ֵ��� ��
                    return o1 - o2;
                else
                    return tmp; // ������ ���� ���� �켱��
            }
        });

        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if (x!=0){ // ���� x�� 0�� �ƴ� ���, ť�� ���� ����
                queue.add(x);
            }
            else { // ���� x�� 0�� ���, ť�� ���� ���� ��� ���� ����
                System.out.println(queue.isEmpty()? 0: queue.poll());
            }
        }

    }
}
