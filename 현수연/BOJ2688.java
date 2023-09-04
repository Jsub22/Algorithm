import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2688 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			long[] pre = new long[10]; // ���� �ڸ����� �پ���� �ʴ� ����
			long[] cur = new long[10]; // ���� �ڸ����� �پ���� �ʴ� ����
			for(int i=0;i<10;i++) // 1�ڸ����� ��� 0~9�� 1�� �ʱ�ȭ �صӴϴ�
				pre[i]=1;
			for(int i=1;i<n;i++) { // 2�ڸ������� n�ڸ������� �����մϴ�!
				// i��° �ڸ����� 0���� 9���� �� j��� ���� ���� ���� �پ���� �ʴ� ������
				// i-1��° �ڸ��� j���� ū ���� ���� ���� �پ���� �ʴ� ������ ��� ������ ���� �����ϴ�.
				// �� ������ Ǯ���ϸ� �Ʒ��� �����ϴ�.
				long sum=0; // ���� �ڸ����� �پ���� �ʴ� �������� ��ĥ sum���Դϴ�
				for(int j=9;j>=0;j--) { //9���� 0����
					sum+=pre[j]; // ���� �ڸ����� �پ���� �ʴ� ������ sum�� �����ְ�
					cur[j]=sum; // ���� �ڸ����� �پ���� �ʴ� ������ sum�� �����մϴ�.
				}
				for(int j=0;j<10;j++) // ������ ������ ���� �ڸ��� ������ ���� ���� �ڸ����� ���� �ڸ��� ������ �־��ݴϴ�.
					pre[j]=cur[j];
			}
			long ans=0;
			for(int i=0;i<10;i++)
				ans+=pre[i]; // ������ �� ���� �� n�ڸ��� 0���� 9���� ���� ���� �پ���� �ʴ� ������ ��� ���մϴ�
			System.out.println(ans);
		}
	}
}
