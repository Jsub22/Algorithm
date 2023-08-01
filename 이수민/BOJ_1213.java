import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray(); // ���� ���ڿ�
        int arrLen = str.length; // ���ڿ��� ����
        char[] result = new char[arrLen]; // ��� �Ӹ���� ���ڿ�
        int[] alphabet = new int[26]; // ���ĺ� ����

        for (char c:str){ // ���� ���ڿ����� �����ϴ� ���ĺ� �� ����
            alphabet[c-'A'] += 1;
        }

        int idx = 0; // ���ڿ��� ��� ä���� ���ϴ� �ε���
        for(int i=0; i<26; i++){

            if (alphabet[i] == 0) // ������ ���� ���ĺ��̸� ���� ����
                continue;

            if (alphabet[i]%2!=0){
                // ���� ���ĺ��� ������ Ȧ���ε�, �̹� �߰����� ���� �� -> �Ӹ���� �ȵ�
                if (result[arrLen/2] != 0) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                } else { // Ȧ�� + ���� �߰����� ���� ��� -> ���� ���ĺ��� �߰�������
                    // ���� ���ĺ��� �ϳ� ����Ͽ� ��� �迭�� ����
                    alphabet[i] -= 1;
                    result[arrLen/2] = (char)(i+'A');
                }
            }

            while(alphabet[i] > 0){ // ����� �� �ִ� ���ĺ� ���� ���� ����
                // ���� ��ġ�鿡 ���� ���ĺ��� �ִ´�.
                result[idx] = (char)(i+'A');
                result[arrLen-idx-1] = (char)(i+'A');
                alphabet[i] -= 2; // �ΰ� ��������Ƿ� -2.
                idx += 1; // ��ġ ����
            }
        }

        Arrays.asList(result).forEach(c -> System.out.print(c));

    }
}
