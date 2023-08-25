import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int N;
    static int[][] map;
    static long[][] result;

    public static void dp(int x, int y) {

        int v = map[x][y]; // ���� �ʿ��� ������ �� �ִ� �Ÿ�
        if (v == 0) return; // �̵��� �� ���ٸ� ����

        if (x+v < N) { // �Ʒ��� ������ �� �ִٸ�
            result[x+v][y] += result[x][y]; // ���� ��ġ���� ���� ����� ���� ������ ��ġ�� �����ش�.
        }

        if (y+v < N) { // ���������� ������ �� �ִٸ�
            result[x][y+v] += result[x][y]; // ���� ��ġ���� ���� ����� ���� ������ ��ġ�� �����ش�.
        }

    }
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = new long[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result[0][0] = 1; // 0, 0�� ������ �� �ִ� ����� ���� 1�� ����.

        // ���� ��ȸ�ϸ鼭 �ش� ������ ������ �� �ִ� ����� ���� �������ش�.
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                dp(i, j);
            }
        }

        System.out.println(result[N-1][N-1]);

    }
}
