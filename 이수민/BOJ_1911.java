import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ������ ������ �����ϱ� ���� Ŭ����
class Puddle implements Comparable<Puddle> {
    int start;
    int end;
    Puddle(int start, int end){
        this.start = start;
        this.end = end;
    }

    // ������ ���������� �������� ����
    @Override
    public int compareTo(Puddle p) {
        return this.start - p.start;
    }
}
public class BOJ_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Puddle[] puddles = new Puddle[n]; // �����̵�
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            puddles[i] = new Puddle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // ������ ���������� �������� ����
        Arrays.sort(puddles);

        int pos = 0; // ���� ���� �ִ� ��ġ
        int board = 0; // ����� �κ��� ��

        // �����̵� �κ����� ����
        for(Puddle p : puddles){
            // �κ��� ������ ���ϱ�
            pos = pos < p.start ? p.start : pos;

            // �����̰� ������ ���� ������ ��� �κ����� �߰��Ͽ� ���´�.
            while(pos < p.end){
                pos += l;
                board++;
            }
        }

        System.out.println(board);

    }
}
