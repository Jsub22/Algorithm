package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_1213 {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str=br.readLine();
		String[] change=str.split("");
		
		int[] alpha=new int[26];//���ĺ� �� �迭 ����
		for(int i=0;i<change.length;i++) {
			alpha[change[i].charAt(0)-'A']++;//���Ĺ� �� ���� üũ
		}
		
		
		//�� 3�κ����� ������ �ϼ�
		//�պκ� +�߰��κ�+������ �κ�
		
		int one=0;
		for(int i=0;i<alpha.length;i++) {
			if(alpha[i]%2!=0) {//���Ĺ� Ȧ���� ��찡 2�� �̻����� üũ
				one++;
			}
		}
		
		String result="";
		
		if(one>1) {
			System.out.println("I'm Sorry Hansoo");//Ȧ�� ���� ���ĺ��� 2�� �̻��̸� �Ӹ������ ���� �� ����
		}else {
			StringBuilder sb=new StringBuilder();//stringbuilder �̿�
			for(int i=0;i<alpha.length;i++) {
				for(int j=0;j<alpha[i]/2;j++) {//�պκ��� ��� ¦������ ���Ĺ��� �ݸ� ����
					sb.append((char)(i+'A'));
				}
			}
			
			result+=sb.toString();//�պκ� �߰�
			String end=sb.reverse().toString();//�� �κ��� �պκ��� ������ �迭 ���
			
			sb=new StringBuilder();//���ο� stringbuildler ����
			for(int i=0;i<alpha.length;i++) {
				if(alpha[i]%2==1) {//�̹��� Ȧ�� ���� ���ĺ��� �߰���
					sb.append((char)(i+'A'));
				}
			}
			
			result+=sb.toString()+end;//�� �κ� ���� result�� ������ �߰� �κа� �� �κ��� ������ �ش�
			System.out.println(result);//��� ���
			
		}
		
	}

}
