import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = null;
        int T = Integer.parseInt(br.readLine());
        LinkedList<Character> list = null;
        ListIterator<Character> iterator = null; // ��������� ��ȸ�ϱ� ���� ListIterator ����

        for(int t=0; t<T; t++){
            list = new LinkedList<Character>();
            iterator = list.listIterator();
            sb = new StringBuilder();
            char[] input = br.readLine().toCharArray();
            for(char c : input){
                if (c == '<'){
                    // ���ʿ� ��Ұ� ���� ���, �������� �̵�
                    if (iterator.hasPrevious())
                        iterator.previous();
                }
                else if (c == '>'){
                    // �����ʿ� ��Ұ� ���� ���, ���������� �̵�
                    if(iterator.hasNext())
                        iterator.next();
                }
                else if (c == '-'){
                    // ��Ұ� ���� ���, �̵��Ͽ� �ش� ��� ����
                    if(iterator.hasPrevious()){
                        iterator.previous();
                        iterator.remove();
                    }
                }
                else{
                    // ��� �߰�
                    iterator.add(c);
                }
            }

            for(char c : list){
                // ���� ����Ʈ�� ��Ҹ� ���ڿ��� �����
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
