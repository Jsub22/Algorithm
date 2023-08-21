import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int n, m; // ����ũ�� ����ũ��
    static int pos[], mx, my; // �ӽ� ��ǥ��
    static char[][] map;
    static int[][] tmp; // ���� ������ ���� �迭
    static Queue<int[]> queue;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int bfs(char team) {
        tmp = new int[m][n];
        queue = new ArrayDeque<>();
        int sum, result=0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (tmp[i][j] == 0 && map[i][j] == team) { // �湮 �� �� ���, �Ʊ��� ��
                    queue.offer(new int[] {i, j}); // ť�� �ְ�,
                    tmp[i][j] = 1; // �Ʊ� ǥ��
                    sum = tmp[i][j];
                    // ť�� ��ȸ�ϸ鼭 �����ִ� �Ʊ��� ���� ����
                    while(!queue.isEmpty()) {
                        pos = queue.poll();
                        for(int k=0; k<4; k++) {
                            mx = pos[0] + dx[k];
                            my = pos[1] + dy[k];

                            // �������� ������ ���� �ʰ�, ���� �湮���� ���� �Ʊ��� ��
                            if (mx >= 0 && mx<m && my>=0 && my<n && tmp[mx][my] == 0 && map[mx][my] == team) {
                                tmp[mx][my] = sum++;
                                queue.offer(new int[] {mx, my});
                            }
                        }
                    }
                    // N���� �������� ���� N^2�� ����
                    result += Math.pow(sum, 2);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[m][n];
        // ������ �Է�
        for(int i=0; i<m; i++) {
            map[i] = br.readLine().toCharArray();
        }
        System.out.println(bfs('W') + " " + bfs('B'));
    }
}
