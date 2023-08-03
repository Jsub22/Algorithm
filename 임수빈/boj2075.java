import java.io.*;
import java.util.*;

public class boj2075 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		
		// �켱���� ť (��������)
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i=0; i<n; i++) {
			// �Է� ���� ���ڸ� �ٷ� ť�� �ִ´�.
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<n; j++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int answer = 0;
		
		// n��° ū ���� ���� ������ ť���� ���� ������.
		for (int i=0; i<n; i++) {
			answer = queue.poll();
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}

}
