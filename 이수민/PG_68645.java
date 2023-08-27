import java.util.Arrays;

public class PG_68645 {
    // ���α׷��ӽ� �ﰢ ������

    public static int[] solution(int n) {
        int max = 0;
        int[][] array = new int[n][];
        for(int i=0; i<n; i++){ 
            max += i+1; // ������ ���� �� ������ �� �ִ� �ִ�
            array[i] = new int[i+1]; // �ึ�� �迭 ĭ �� ����
        }

        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int direction = 0; // ����
        int x=0, y=0; // �ʱⰪ
        int current = 1; // �� ����
        array[x][y] = current;

        // ���� ���� ������ ��ü ���� �� �ִ񰪺��� ���� ��쿡 ����
        while(current < max){
            // �ӽ� ��ǥ
            int tmpx = x + dx[direction];
            int tmpy = y + dy[direction];
            
            // �ӽ� ��ǥ�� ���ǿ� �������� �ʴ´ٸ�, ������ �����Ͽ� �� �迭 ������ ã�´�.
            while(tmpx >= n || tmpx < 0 || tmpy < 0 || tmpy >= array[tmpx].length || array[tmpx][tmpy] != 0){
                direction = (direction+1)%3;
                tmpx = x + dx[direction];
                tmpy = y + dy[direction];
            }
            
            // �ӽ� ��ǥ�� ��� �����ϴٸ� ���� ��ǥ�� ����
            x = tmpx;
            y = tmpy;

            // ���� ��ǥ�� ���� �ִ´�
            array[x][y] = ++current;
        }

        // 2���� �迭 -> 1���� �迭
        int[] result = new int[max];
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                result[idx++] = array[i][j];
            }
        }
        return result;
    }
    
    // test ���� main �޼ҵ�
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(4)));
//    }
}
