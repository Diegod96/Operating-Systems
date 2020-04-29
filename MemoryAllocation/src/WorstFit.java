import java.util.Arrays;

public class WorstFit {


    static void worstFit(int blockSize[], int m, int processSize[], int n) {

        int allocation[] = new int[n];

        int fragmentation[] = new int[n];

        int memorySize[] = new int[n];

        // Initially set all blocks as not assigned "-1"
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // Loop through jobs and see which jobs size is less than the current partition size selected
        for (int i=0; i<n; i++) {
            // Find worst index
            int wstIdx = -1;
            for (int j=0; j<m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (wstIdx == -1)
                        wstIdx = j;
                    else if (blockSize[wstIdx] < blockSize[j])
                        wstIdx = j;
                }
            }

            // If we could find a block for current process
            if (wstIdx != -1) {

                allocation[i] = wstIdx;
                memorySize[i] = blockSize[wstIdx];

                // Add difference of specific allocation to fragmentation array
                fragmentation[i] = blockSize[wstIdx] -= processSize[i];
            }
        }

        System.out.println(" Job #	    Job Size            Memory Size            Status              Fragmentation After Allocation");
        for (int i = 0; i < n; i++) {
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

    public static void main(String[] args) {
        int memorySize[] = {100, 500, 200, 300, 600};
        int jobSize[] = {212, 417, 112, 426};
        int x = memorySize.length;
        int y = jobSize.length;

        worstFit(memorySize, x, jobSize, y);
    }
}

