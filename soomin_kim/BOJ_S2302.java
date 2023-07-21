import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_S2302 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// �¼� ����
		int n = Integer.parseInt(br.readLine());
		// ����� ���� ������ �迭
		int[] dp = new int[n + 1];

		//vip�� ����
		int vip_n = Integer.parseInt(br.readLine());
		int[] vip = new int[vip_n];
		
		//vip�� �¼� ��ȣ �Է�
		for (int i = 0; i < vip_n; i++) {
			vip[i] = Integer.parseInt(br.readLine());
		}
		
		//����� �� ���ϱ�
		dp[0] = 1; //�¼��� 0���� ��� ����� ���� 1����
		dp[1] = 1; //�¼��� 1���� ��� ����� ���� 1����
		for (int i = 2; i <= n; i++) {
			//��ȭ�� 
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int count = 0; //���ӵǴ� �¼� ������ ������ ����
		int result = 1; //�� ����� ���� ������ ����
		int index = 0; //vip[] �迭�� Ž���ϱ� ���� �ε���
		
		// �¼� ������ŭ �ݺ����� ���鼭 �� ����� ���� ���Ѵ�.
		// 0~vip[0] * vip[0]~vip[1]
		for (int i = 1; i <= n; i++) {
			if (index < vip_n) { // index�� �迭�� ������ ����� ��츦 ����
				if (i == vip[index]) { 
					result *= dp[count]; //vip���� ������ ���ӵǴ� �¼��� ����� ������ ���Ѵ�.(���ÿ� �Ͼ�ϱ� ���Ѵ�.)
					count = 0; //���ӵǴ� �¼� ���� �ʱ�ȭ
					index++;
				}
				else
					count++;
			} else
				count++;
		}
		//* vip[1]~n
		result *= dp[count];

		System.out.println(result);
	}
}
