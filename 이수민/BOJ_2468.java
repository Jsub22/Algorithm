import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2468 {
    static int n;
    static int[][] map; // ����

    // �ֺ� ������ ���Ǳ� ���� ��ǥ �迭
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        Set<Integer> height = new HashSet<>(); // �ߺ����� ������ ���̸� ��´�.
        height.add(0); // �� ���̰� 0�� ���
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                height.add(a);
            }
        }

        int max = 0;
        Iterator<Integer> iterator = height.iterator();
        while(iterator.hasNext()) { // ������ ���̸� ���� ���̷� �����Ͽ� ������ ������ ���Ѵ�.
            max = Math.max(max, findArea(iterator.next()));
        }

        System.out.println(max);

    }
    public static int findArea(int height) {
        int area = 0;
        boolean[][] isVisited = new boolean[n][n]; // �湮 Ȯ���� ���� �迭

        Queue<int[]> queue = new ArrayDeque<int[]>(); // ������ ������ ���� Ȯ��(bfs)�� ���� ť

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // �������� �����Ͽ�, �� ������ ������ �����̰� ���� �湮�� ���� ���ٸ� ť�� �ְ� ���ο� ������ ���۵��� ������
                if(map[i][j] > height && !isVisited[i][j]) {
                    queue.offer(new int[]{i, j});
                    area++;
                }

                // bfs - ���� ������ ������ ������ Ȯ��
                while(!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    isVisited[pos[0]][pos[1]] = true;
                    for (int k=0; k<4; k++) {
                        int tmpx = pos[0] + dx[k];
                        int tmpy = pos[1] + dy[k];
                        // �̵��� ������ �迭�� ���� ���̰�, ������ �����̰� ���� �湮�� ���� ���ٸ� ���� ������ ������ �� �ִ�.
                        if (tmpx>=0 && tmpx<n && tmpy>=0 && tmpy<n && map[tmpx][tmpy]>height && !isVisited[tmpx][tmpy]) {
                            queue.offer(new int[]{tmpx, tmpy});
                            isVisited[tmpx][tmpy] = true;
                        }
                    }
                }
            }
        }

        return area; // ���� �� ����(height)�� ���� ������ ������ ������ ��ȯ
    }
}
