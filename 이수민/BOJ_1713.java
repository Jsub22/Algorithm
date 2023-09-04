import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student>{
    int number; // �л� ��ȣ
    int recommended; // ��õ ���� ��
    int idx; // ����

    public Student(int number, int recommended, int idx) {
        super();
        this.number = number;
        this.recommended = recommended;
        this.idx = idx;
    }

    void setStudent(int recommended, int idx){
        this.recommended = recommended;
        this.idx = idx;
    }

    @Override
    public int compareTo(Student o) {
        if (this.recommended == o.recommended)
            return Integer.compare(this.idx, o.idx);
        else
            return Integer.compare(this.recommended, o.recommended);
    }
}

public class BOJ_1713 {
    static int N, number; // �л� ��ȣ number

    static List<Student> selected;
    static Student[] students;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        selected = new ArrayList<>();
        students = new Student[101];

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++) {
            number = Integer.parseInt(st.nextToken());

            // ù �Է��� �л��� ��� ��ü �Ҵ�
            if (students[number] == null)
                students[number] = new Student(number, 0, 0);

            if(students[number].recommended != 0){
                // �̹� ������ �Խõ� �л��� ���, ��õ���� Ƚ���� ���� ��Ŵ
                students[number].recommended++;
            }
            else {

                // �� ����Ʋ�� ���� ��� ������ ���ǿ� �°� ����Ʋ �ϳ��� ���� ���� ���� �� ����
                if(selected.size() == N){
                    Collections.sort(selected);
                    selected.get(0).recommended = 0;
                    selected.remove(0);
                }

                // �� ����Ʋ�� ���� �л��� ä���
                students[number].setStudent(1, m);
                selected.add(students[number]);
            }

        }

        Collections.sort(selected, (o1, o2) -> o1.number - o2.number);
        for(Student s : selected){
            sb.append(s.number).append(" ");
        }

        System.out.println(sb);
    }
}

