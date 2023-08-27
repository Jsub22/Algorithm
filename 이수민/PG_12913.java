public class PG_12913 {
    int solution(int[][] land) {
        int answer = 0;

        int N = land.length;

        // ���� ���� �ִ� �� ������
        for(int i=1; i<N; i++){
            // ���� ���� ���� ���� ���� ���� �ε����� ���� �ʾƾ� �ϹǷ� �ִ밪 �������� ����
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        // ������ �� �� �ִ��� �� ������ ��
        for (int i=0; i<4; i++){
            answer = Math.max(land[N-1][i], answer);
        }

        return answer;
    }
}
