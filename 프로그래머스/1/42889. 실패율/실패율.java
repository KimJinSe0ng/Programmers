import java.util.*;

class Solution {
    public static int[] solution(int N, int[] stages) {
        int[] stageUsers = new int[N + 2];
        int totalUsers = stages.length;

        for (int stage : stages) {
            stageUsers[stage]++;
        }

        List<Stage> failures = new ArrayList<>();

        int remainingUsers = totalUsers;
        for (int stage = 1; stage <= N; stage++) {
            if (remainingUsers == 0) {
                failures.add(new Stage(stage, 0));
            } else {
                double failure = (double) stageUsers[stage] / remainingUsers;
                failures.add(new Stage(stage, failure));
                remainingUsers -= stageUsers[stage]; 
            }
        }

        failures.sort((o1, o2) -> {
            if (Double.compare(o2.failure, o1.failure) != 0) {
                return Double.compare(o2.failure, o1.failure);
            }
            return o1.no - o2.no;
        });

        return failures.stream().mapToInt(stage -> stage.no).toArray();
    }

    private static class Stage {
        public int no;       
        public double failure; 

        public Stage(int no, double failure) {
            this.no = no;
            this.failure = failure;
        }
    }
}