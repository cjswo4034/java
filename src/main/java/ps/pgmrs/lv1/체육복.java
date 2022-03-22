package ps.pgmrs.lv1;

import ps.pgmrs.Solution;

public class 체육복 implements Solution<Integer> {
    private int answer = 0;

    @Override
    public Integer solution(Object... params) {
        return solution((int)params[0], (int[])params[1], (int[])params[2]);
    }

    public int solution(int n, int[] lost, int[] reserve) {
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) students[i] = new Student();
        for (int e: lost) students[e - 1].setHasCloth(false);
        for (int e: reserve){
            students[e - 1].setIsAbleToLend(students[e - 1].hasCloth());
            students[e - 1].setHasCloth(true);
        }

        int count = 0;
        for (Student student: students) {
            if (student.hasCloth()) count++;
        }

        solution(0, count, students);

        return answer;
    }

    void solution(int depth, int count, Student[] students) {
        if (students.length <= depth) {
            answer = Math.max(answer, count);
            return;
        }

        Student student = students[depth];

        if (!student.hasCloth()) {
            int left = depth - 1;
            int right = depth + 1;

            if (isAbleToLend(left, students)) {
                student.borrow(students[left]);
                solution(depth + 1, count + 1, students);
                student.back(students[left]);
            }

            if (isAbleToLend(right, students)) {
                student.borrow(students[right]);
                solution(depth + 2, count + 1, students);
                student.back(students[right]);
            }
        }

        solution(depth + 1, count, students);
    }

    boolean isAbleToLend(int index, Student[] students) {
        if (index < 0 || index >= students.length) return false;

        return students[index].hasCloth() && students[index].isAbleToLend();
    }

    class Student {
        private boolean hasCloth = true;
        private boolean isAbleToLend;

        public void borrow(Student student) {
            hasCloth = true;
            student.setIsAbleToLend(false);
        }

        public void back(Student student) {
            hasCloth = false;
            student.setIsAbleToLend(true);
        }

        public boolean hasCloth() {
            return hasCloth;
        }

        public void setHasCloth(boolean hasCloth) {
            this.hasCloth = hasCloth;
        }

        public boolean isAbleToLend() {
            return isAbleToLend;
        }

        public void setIsAbleToLend(boolean ableToLend) {
            this.isAbleToLend = ableToLend;
        }
    }
}
