import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501 {
	static long stock[];
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽� ��
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine()); // ���� ��
			StringTokenizer st = new StringTokenizer(br.readLine());
			stock = new long[N]; // �ֽ� �迭
			long max = 0; // �ֽ� �迭 �� ���� ū ��
			int maxIdx = -1; // ���� ū ���� �ε��� ��
			for (int j = 0; j < N; j++) { // �켱 ��ü �ε������� ���� ū ���� �ش� ���� �ε����� ���մϴ�
				stock[j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, stock[j]);
				if (max == stock[j])
					maxIdx = j;
			}
			long sum = profit(0, maxIdx, 0, 0); // ���� ū ���� �̿��Ͽ� �ֽ��� �ִ� �������� ����ø� �� �ִ� �Լ��� ����մϴ�
			sb.append(sum).append("\n"); // �׽�Ʈ ���̽� ���� ��� ���� �����մϴ�
		}
		System.out.println(sb); // ��� ���� ����մϴ�
	}

	static long profit(int startIdx, int maxIdx, long sum, int cnt) {
		if(cnt==N) // ������ �ֽı��� ������ ���, ���� �ִ� ���� ���� ����մϴ�
			return sum;
		for(int i=startIdx; i<maxIdx;i++) { // �켱 ù ���� �ε�������, �ִ� ���� ���� �ε�������
			sum+=stock[maxIdx]-stock[i]; // �ִ밪���� ���� ��� �����ݴϴ�
		}
		startIdx = maxIdx+1; // ���� �ִ밪 ������ �ε����� �ٽ� ù ���� �ε����� ������ְ�
		long max = 0;
		for(int i=startIdx;i<N;i++) { // �� ������ �ִ��� ���� �����ݴϴ�
			max=Math.max(max, stock[i]);
			if(max==stock[i])
				maxIdx=i;
		}
		return profit(startIdx, maxIdx, sum, startIdx); // ���� ���� ������ ��ͷ� �ݺ����ָ� ���������� �ִ� ���Ͱ��� ����˴ϴ�
	}
}
