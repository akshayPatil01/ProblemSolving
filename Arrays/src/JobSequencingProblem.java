import java.util.Arrays;

public class JobSequencingProblem {
    public static void main(String[] args) {
        Job[] jobs = new Job[]{new Job(1, 4, 20), new Job(2, 1, 1), new Job(3, 1, 40), new Job(4, 1, 30)};

        JobSequencingProblem j = new JobSequencingProblem();
        int[] solutionArr = j.JobScheduling(jobs);

        System.out.printf("Max Jobs completed: %d \nTotal profit earned: %d", solutionArr[0], solutionArr[1]);
    }

    int[] JobScheduling(Job[] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o2.profit - o1.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        boolean[] timeline = new boolean[maxDeadline];
        int totalProfit = 0;
        int jobCount = 0;

        for (Job job : jobs) {
            for (int slot = Math.min(maxDeadline, job.deadline) - 1; slot >= 0; slot--) {
                if (!timeline[slot]) {

                    timeline[slot] = true;

                    totalProfit += job.profit;
                    jobCount++;
                    break;
                }
            }
        }

        return new int[]{jobCount, totalProfit};
    }
}

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
