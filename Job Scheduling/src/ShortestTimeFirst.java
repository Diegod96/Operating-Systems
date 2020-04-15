import java.util.List;


public class ShortestRemainingTime extends AllocationStrategy {

    public ShortestRemainingTime(List;Job; jobs) {
        super(jobs);
    }

    public void run() {

    }

    public void run(List<Job>; jobList) {

        float avgTurnArroundTime = 0;
        float avgWaitigTime = 0;
        int n;
        n = jobList.size();
        int p[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int bt2[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];
        int count = 0;
        double tempWT=0;
        for (Job job:jobList) {
            p[count] = count;
            at[count] = job.getArrivalTime();
            bt[count] = job.getCpuTime();
            bt2[count] = bt[count];
            count++;
        }
        int tbt = 0;
        for (int i = 0; i < n; i++) {
            tbt = tbt + bt[i];
        }
        int time[] = new int[tbt];
        int k = 0;
        int q2 = 0;

        System.out.println("============================================ ");
        System.out.println("Process ID | Turnaround time | Waiting time ");
        System.out.println("============================================ ");
        int counter=1;
        for (int i = 0; i < tbt; i++) {

            int q = Min(bt, at, tbt, i, n);

            if (q != q2) {
                time[k++] = i;

                wt[q] = i;
                tat[q] = i + bt[q];
                counter++;
                tempWT+=wt[q];
            }
            avgWaitigTime+= wt[q];
            avgTurnArroundTime+=tat[q];
            bt[q] = bt[q] - 1;
            q2 = q;

            System.out.println( (p[q]+1) +"\t|"+tat[q]+"\t|\t"+wt[q]);
            System.out.println("----------------------------------------");

        }
        time[k] = tbt;
        System.out.println();
        System.out.print("0\t");

        for (int i = 0; i <= k; i++) {
            System.out.print(time[i] + "\t");
        }
        System.out.println("\n============================================ ");
        System.out.println("Avg WT||TAT::"+tempWT/counter+"|"+avgTurnArroundTime/counter);
        System.out.println("============================================ ");

    }

    public int Min(int b[], int a[], int tbt, int r, int n) {
        int j = 0;
        int min = tbt;
        for (int i = n - 1; i ;= 0; i--) {
            if (b[i] < min && b[i] ; 0 && r ;= a[i]) {
                min = b[i];
                j = i;
            }
        }
        return j;
    }

}

AllocationStrategy.java


        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.Iterator;
        import java.util.List;
        import java.util.Queue;

/* implement this class for all three strategies */

public abstract class AllocationStrategy {
    protected List<Job> Jobs;
    protected ArrayList<Job> Queue;

    public AllocationStrategy(List<Job> jobs) {
        super();
        Jobs = jobs;
    }

    public abstract void run();
    // update current job by 1 tick
    // check if the job queue might need to be changed.
    // check for jobs to add to the queue
}

Job.java



public class Job {
    private int id, submitTime, CPUTime, CPUTimeLeft;

    private int startTime = 0, endTime = 0;


    public int ProcessCompletionTime;
    public int processArrivalTime;
    public int waitingTime;
    public int turnAroundTime;
    private JobFinishEvent evt;

    private int arrivalTime,cpuTime,processId;

    public Job(int id, int submitTime, int CPUTime, JobFinishEvent evt) {
        super();
        this.id = id;
        this.submitTime = submitTime;
        this.CPUTime = CPUTime;
        this.CPUTimeLeft = CPUTime;
        this.evt = evt;
    }

    public Job(int processId, int arrivalTime, int cpuTime) {

        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.cpuTime = cpuTime;

    }

    public void start(int sysTime) {
        startTime = sysTime;
    }

    public void tick(int sysTime) {
        CPUTimeLeft --;
        if (CPUTimeLeft <= 0){
            endTime = sysTime;
            evt.onFinish(this);
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(int submitTime) {
        this.submitTime = submitTime;
    }

    public int getCPUTime() {
        return CPUTime;
    }

    public void setCPUTime(int cPUTime) {
        CPUTime = cPUTime;
    }

    public int getCPUTimeLeft() {
        return CPUTimeLeft;
    }

    public void setCPUTimeLeft(int cPUTimeLeft) {
        CPUTimeLeft = cPUTimeLeft;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }


}




JobFinishEvent.java


public interface JobFinishEvent {
    public void onFinish(Job j);
}



Question1.java


        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;


public class Question1 {

    public static void main(String[] args) {
        // Process command line arguments
        // read the file


        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);


        String filename ;
        String allocationStrategy;
        int quantum=20;

        /*filename = args[0];
        allocationStrategy = args[1];*/

        filename = "testing.txt";
        allocationStrategy = "FCFS";


        //filename = sc.nextLine();

        if(args.length==3){
            quantum = new Integer(args[2]);
        }

        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("C://Users/Arnav/Desktop/"+filename));
            //System.out.println("processId  arrivalTime  cpuTime");

            List<Job> jobList = new ArrayList<Job>();
            while ((sCurrentLine = br.readLine()) != null) {

                String a[] = sCurrentLine.split(",");
                int processId = new Integer(a[0]);
                int arrivalTime = new Integer(a[1]);
                int cpuTime = new Integer(a[2]);

                Job job = new Job(processId,arrivalTime,cpuTime);

                jobList.add(job);

                //System.out.println(processId+" "+ arrivalTime+" " + cpuTime);
            }

            if("FCFS".equalsIgnoreCase(allocationStrategy)){

                FirstComeFirstServed firstComeFirstServed = new FirstComeFirstServed(jobList);
                firstComeFirstServed.run(jobList);

            }else if("SRT".equalsIgnoreCase(allocationStrategy)){

                ShortestRemainingTime shortestRemainingTime = new ShortestRemainingTime(jobList);
                shortestRemainingTime.run(jobList);

            }else if("RR".equalsIgnoreCase(allocationStrategy)){

                RoundRobin roundRobin = new RoundRobin();
                roundRobin.run(jobList,quantum);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        JobFinishEvent callback = new JobFinishEvent() {
            @Override
            public void onFinish(Job j) {
                // this will be called when a job is finished.
            }
        };


        /*// example job addition:
        ArrayList jobs = new ArrayList();
        jobs.add(new Job(1, 0, 2, callback));
        jobs.add(new Job(2, 1, 3, callback));
        ShortestRemainingTime srt = new ShortestRemainingTime(jobs);
        srt.run();
        */
    }

}