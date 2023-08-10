import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1080 {
    static char[][] a, b;

    // ��� ������
    static void reverseMatrix(int i, int j){
        for(int x=i; x<i+3; x++){
            for(int y=j; y<j+3; y++){
                a[x][y] = a[x][y] == '0' ? '1' : '0';
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        a = new char[n][m];// ��� A
        b = new char[n][m];// ��� B

        for(int i=0; i<n; i++){
            a[i] = br.readLine().toCharArray();
        }
        for(int i=0; i<n; i++){
            b[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for(int i=0; i<n-2; i++){
            for(int j=0; j<m-2; j++){
                if (a[i][j] != b[i][j]){ // ���� A����� ���Ұ� B����� ���ҿ� �ٸ� ��,
                    reverseMatrix(i, j);
                    cnt++; // ����� ������� �ϴ� ��츦 ī��Ʈ
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (a[i][j] != b[i][j]){ // A�� B�� �ٸ��ٸ� A�� B�� �ٲ� �� ���� ���
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);

    }
}
