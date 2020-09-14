/**
 * Example of how your graded labs are expected to be formatted
 *
 * Modularity             : Atleast 1 helper method to abstract the logic/functionality
 * PrePost Conditions     : Atleast 1 pre & post condition for all your helper methods
 * Meaningful Comments    : Describe code chunks, do not explain each line
 * Meaningful Identifiers : Do not name variables "n", "arr", give meaningful names
 * Indentation            : Alignment + make sure your tabs are not actually spaces
 */

import java.util.*;

public class Jobs {
    public long workDuration = Long.MAX_VALUE;
    public int numJobs;
    public int[] jobs;

    /**
    * Tries all possible ways to split the job
    * Pre Cond  : For initial call to method, all arguments to be 0
    * Post Cond : workDuration will be the mininum time
    */
    public void splitJob(int i, long w1, long w2, long w3) {
        if (i == numJobs) {
            long max = Math.max(w1, Math.max(w2, w3));
            workDuration = Math.min(workDuration, max);
            return;
        }

        // try all 3 ways i can split the jobs
        splitJob(i + 1, w1 + jobs[i], w2, w3);
        splitJob(i + 1, w1, w2 + jobs[i], w3);
        splitJob(i + 1, w1, w2, w3 + jobs[i]);
    }

    private void run() {
        Scanner sc = new Scanner(System.in); 

        // scanning input
        numJobs = sc.nextInt(); 
        jobs = new int[numJobs];
        for (int i = 0; i < numJobs; i++) {
            jobs[i] = sc.nextInt(); 
        }

        // try all cases
        splitJob(0, 0, 0, 0);

        // output ans
        System.out.println(workDuration);
    }

    public static void main(String args[]) {
        Jobs jobs = new Jobs();
        jobs.run();
    }
}
