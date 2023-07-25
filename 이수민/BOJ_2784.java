import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BOJ_2784 {
    static final int NumOfWords = 6; // 6���� �ܾ�
    static final int puzzleSize = 3; // ���� �ʿ��� ����/���� ������
    static String[] words = new String[NumOfWords];
    static void dfs(String[] currentWords, boolean[] visited, int cnt){
        if (cnt == puzzleSize){
            check(currentWords); // puzzle ���� ���� Ȯ��
            return;
        }

        for(int i=0; i<NumOfWords; i++){
            if (!visited[i]){
                visited[i] = true;
                currentWords[cnt] = words[i];
                dfs(currentWords, visited, cnt+1);
                visited[i] = false;
            }
        }
    }

    static void check(String[] currentWords){
        List<String> leftWords = new LinkedList<>();
        leftWords.addAll(Arrays.asList(words));
        for (String word : currentWords)
            leftWords.remove(word); // ���õ� �ܾ�� �����ϱ�

        char[] charArr = new char[puzzleSize];
        for(int i=0; i<puzzleSize; i++){
            int idx = 0;

            // ���õ� �ܾ ������� �ӽ� �ܾ� �����
            for(String word: currentWords){
                charArr[idx++] = word.charAt(i);
            }
            String tmpWord = String.copyValueOf(charArr);

            // ���� �ܾ�� �� �ӽ� �ܾ �ִ��� Ȯ��
            if(leftWords.contains(tmpWord))
                leftWords.remove(tmpWord);

            if(leftWords.isEmpty())
                print(currentWords);
        }
    }

    static void print(String[] currentWords){
        // ��� ���
        for(String word: currentWords)
            System.out.println(word);
        System.exit(0);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<NumOfWords; i++)
           words[i] = br.readLine();

        boolean[] visited = new boolean[NumOfWords]; // dfs()���� �湮�ߴ��� ���θ� �˱� ����
        String[] currentWords = new String[puzzleSize];
        dfs(currentWords, visited, 0);
        System.out.println(0);
    }
}
