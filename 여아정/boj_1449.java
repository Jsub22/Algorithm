package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_1449 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(bf.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(st.nextToken());
		
		int[] input=new int[n];
		st=new StringTokenizer(bf.readLine()," ");
		int[]pi=new int[1001];//pi �迭 ����
		
		for(int i=0;i<n;i++) {
			pi[Integer.parseInt(st.nextToken())]=1;//�迭 ���۳� �κ� üũ
		}
		
		int result=0;
		for(int i=1;i<pi.length;) {//����for 
			if(pi[i]==1) {//���۳� �κп� ������
				i+=s;//������ ���̸�ŭ i �̵�
				result++;
			}else {
				i++;//���۳� �κоƴϸ� i�߰�
			}
		}
		System.out.println(result);//������ Ƚ�� ��� ���
	}
	
}
