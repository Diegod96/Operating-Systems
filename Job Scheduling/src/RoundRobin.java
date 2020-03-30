


class RoundRobin {
    public static void RR(String[] processes, int[] arrival_times,
                          int[] burst_times, int n)
    {
   
        int average_waiting_time = 0;
        int average_completion_time = 0;
        int length_processes = processes.length;
        int length_arrival_array = arrival_times.length;
        int length_burst_array = burst_times.length;
        
        
        int[] burst_times_copy = new int[length_burst_array];
        int[] arrival_times_copy = new int[length_arrival_array];

        for (int i = 0; i < burst_times_copy.length; i++) {
            burst_times_copy[i] = burst_times[i];
            arrival_times_copy[i] = arrival_times[i];
        }

        // critical time of system
        int t = 0;

        // for store the waiting time
        int[] waiting_times = new int[length_processes];

        // for store the Completion time
        int[] completion_times = new int[length_processes];

        while (true) {
            boolean flag = true;
            for (int i = 0; i < length_processes; i++) {

                // these condition for if
                // arrival is not on zero

                // check that if there come before qtime
                if (arrival_times_copy[i] <= t) {
                    if (arrival_times_copy[i] <= n) {
                        if (burst_times_copy[i] > 0) {
                            flag = false;
                            if (burst_times_copy[i] > n) {

                                // make decrease the b time
                                t = t + n;
                                burst_times_copy[i] = burst_times_copy[i] - n;
                                arrival_times_copy[i] = arrival_times_copy[i] + n;

                            }
                            else {

                                // for last time
                                t = t + burst_times_copy[i];

                                // store comp time
                                completion_times[i] = t - arrival_times[i];

                                // store wait time
                                waiting_times[i] = t - burst_times[i] - arrival_times[i];
                                burst_times_copy[i] = 0;


                            }
                        }
                    }
                    else if (arrival_times_copy[i] > n) {

                        // is any have less arrival time
                        // the coming process then execute them
                        for (int j = 0; j < length_processes; j++) {

                            // compare
                            if (arrival_times_copy[j] < arrival_times_copy[i]) {
                                if (burst_times_copy[j] > 0) {
                                    flag = false;
                                    if (burst_times_copy[j] > n) {
                                        t = t + n;
                                        burst_times_copy[j] = burst_times_copy[j] - n;
                                        arrival_times_copy[j] = arrival_times_copy[j] + n;
                                    }
                                    else {
                                        t = t + burst_times_copy[j];
                                        completion_times[j] = t - arrival_times[j];
                                        waiting_times[j] = t - burst_times[j] - arrival_times[j];
                                        burst_times_copy[j] = 0;

                                    }
                                }
                            }
                        }

                        // now the previous porcess according to
                        // ith is process
                        if (burst_times_copy[i] > 0) {
                            flag = false;

                            // Check for greaters
                            if (burst_times_copy[i] > n) {
                                t = t + n;
                                burst_times_copy[i] = burst_times_copy[i] - n;
                                arrival_times_copy[i] = arrival_times_copy[i] + n;
                            }
                            else {
                                t = t + burst_times_copy[i];
                                completion_times[i] = t - arrival_times[i];
                                waiting_times[i] = t - burst_times[i] - arrival_times[i];
                                burst_times_copy[i] = 0;

                            }
                        }
                    }
                }

                // if no process is come on thse critical
                else if (arrival_times_copy[i] > t) {
                    t++;
                    i--;
                }
            }
            // for exit the while loop
            if (flag) {
                break;
            }
        }

        System.out.println("name  ctime  wtime");
        for (int i = 0; i < length_processes; i++) {
            System.out.println(" " + processes[i] + "    " + completion_times[i]
                    + "    " + waiting_times[i]);

            average_waiting_time = average_waiting_time + waiting_times[i];
            average_completion_time = average_completion_time + completion_times[i];
        }

        System.out.println("Average waiting time is "
                + (float)average_waiting_time / length_processes);
        System.out.println("Average compilation  time is "
                + (float)average_completion_time / length_processes);

    }

    // Driver Code
    public static void main(String args[])
    {
        // name of the process
        String[] name = { "p1", "p2", "p3", "p4" };

        // arrival for every process
        int[] arrivaltime = { 0, 1, 2, 3 };

        // burst time for every process
        int[] bursttime = { 10, 4, 5, 3 };

        // quantum time of each process
        int q = 3;

        // cal the function for output
        RR(name, arrivaltime, bursttime, q);
    }
}
