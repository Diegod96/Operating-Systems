import java.util.Arrays;

public class FirstFitAlgorithm {

    // Method to allocate memory to
    // blocks as per First fit algorithm
    static void firstFit(int blockSize[], int m,
                         int processSize[], int n)
    {
        // Stores block id of the
        // block allocated to a process
        int allocation[] = new int[n];

        int fragmentation[] = new int[n];

        int memorySize[] = new int[n];

        int memoryAddress[] = new int[n];



        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (blockSize[j] >= processSize[i])
                {
                    // allocate block j to p[i] process
                    allocation[i] = j;

                    memorySize[i] = blockSize[j];


                    // Reduce available memory in this block.
                    fragmentation[i] = blockSize[j] -= processSize[i];

                    break;
                }
            }
        }

        System.out.println(" Job #	    Job Size            Memory Size            Status              Fragmentation After Allocation");
        for (int i = 0; i < n; i++)
        {
            System.out.print(" " + (i+1) + "              " +
                    processSize[i] + "             " + memorySize[i]);
            if (allocation[i] != -1)
                System.out.print("                       Busy");
            else
                System.out.print("                       Free");
            System.out.println("                " + fragmentation[i]);
        }
        int sum = Arrays.stream(fragmentation).sum();
        System.out.println("Total Fragmentation: " + sum);
    }

    // Driver Code
    public static void main(String[] args)
    {
        int blockSize[] = {100, 500, 200, 300, 600};
        int processSize[] = {212, 417, 112, 426};
        int m = blockSize.length;
        int n = processSize.length;

        firstFit(blockSize, m, processSize, n);
    }
}




































