import java.io.*;
import java.util.*;

// ���� 2468: ���� ����
public class boj2468 {

	static int n;
	static int[][] area;
	static boolean[][] visited;
	static boolean[][] temp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		area = new int[n][n];
		visited = new boolean[n][n];
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int h = 0;
		int answer = 0;
		int cnt;
		
		while (h <= 100) {
			sink(h); // ���� ���� ���� ǥ��
	
			cnt = 0;
			temp = cloneArray(); // visited ����
			
			// ������ ���� ã��
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (!temp[i][j]) {
						findSafeArea(i, j);
						cnt++;
					}
				}
			}
			
			// �ִ� ����
			answer = Math.max(answer, cnt);
			
			// ���� ���� ���� �߰�
			h++;	
		}
		
		System.out.println(answer);
		
	}
	
	static void sink(int h) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (area[i][j] == h) {
					visited[i][j] = true;
				}
			}
		}
	}
	
	static boolean[][] cloneArray() {
		boolean[][] temp = new boolean[n][n];
		
		for (int i=0; i<n; i++) {
			System.arraycopy(visited[i], 0, temp[i], 0, n);
		}
		
		return temp;
	}
	
	static void findSafeArea(int x, int y) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		int mx, my;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			x = q[0];
			y = q[1];
			
			for (int i=0; i<4; i++) {
				// ��ǥ �̵�
				mx = x + dx[i];
				my = y + dy[i];
				
				// ������ ��� ���
				if (mx < 0 || mx >= n || my < 0 || my >= n) {
					continue;
				}
				
				// �̹� ���� ��� �����̰ų� �湮�� �� �ִ� ������ ���
				if (temp[mx][my]) {
					continue;
				}
				
				// �湮 üũ
				temp[mx][my] = true;
				queue.add(new int[] {mx, my});
			}
		}
		
	}
	

}
