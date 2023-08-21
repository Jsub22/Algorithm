import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2841 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int N, P; // ���� ��, ������ ��
    static Stack[] stack = new Stack[7]; // ��Ÿ �� 6���� ����
    static int move; // �հ����� ������

    // �ٸ��� ������ �����ϴ� ������ �̿��Ͽ� �հ����� �������� ����
    public static void putToStack(int string, int fret) {
        if (stack[string].isEmpty()) { 
            // ���� �ٿ� ���� ���ÿ� ���� �ƹ��͵� ���ٸ�, ������ ���ÿ� �߰��ϰ� �����ӵ� �߰�
            move += 1;
            stack[string].add(fret);
            return;
        }

        // ���� �ٿ� ���� ������ �ֱ� ������ ����
        int peek = (int)stack[string].peek();
        
        if (peek < fret) { // ���� ���� ������ ���� �����Ϸ��� �������� ������, �� ���� �߰�
            move += 1;
            stack[string].add(fret);

        }
        else if (peek > fret) { // ���� ���� ������ ���� �����Ϸ��� �������� ũ�ٸ�, �ƴ� ������ ������
            while(!stack[string].isEmpty() && (int)stack[string].peek() > fret) {
                stack[string].pop();
                move += 1;
            }
            // ������ ������� �ʰ�, ���� ���� ������ ���� ������ ���� ���� �ʴٸ� ����
            // ���� ��쿡�� ������ ��ȭ��Ű�� �ʾƵ� �Ǿ�, ������ �ʿ䰡 ����.
            if (stack[string].isEmpty() || (int)stack[string].peek() != fret) {
                move += 1;
                stack[string].add(fret);
            }
        }
    }
    public static void main(String[] args) throws Exception {

        for(int i=1; i<=6; i++) {
            stack[i] = new Stack<Integer>();
        }

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // �� ����
            int p = Integer.parseInt(st.nextToken()); // ���� ����
            putToStack(s, p);

        }

        System.out.println(move);

    }
}
