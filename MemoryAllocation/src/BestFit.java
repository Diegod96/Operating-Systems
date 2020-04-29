import java.util.Arrays;

public class BestFit {



    static void bestFit(int partitionSize[], int x, int jobSize[], int y) {

        int allocation[] = new int[y];

        int fragmentation[] = new int[y];

        int memorySize[] = new int[y];

        // Initially set all blocks as not assigned "-1"
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // Loop through jobs and see which jobs size is less than the current partition size selected
        for (int i=0; i<y; i++) {
            // Find the best fit block for current process
            int bestIndex = -1;
            for (int j=0; j<x; j++) {
                if (partitionSize[j] >= jobSize[i])
                {
                    if (bestIndex == -1)
                        bestIndex = j;
                    else if (partitionSize[bestIndex] > partitionSize[j])
                        bestIndex = j;
                }
            }

            // If we could find a block for current process
            if (bestIndex != -1) {

                allocation[i] = bestIndex;

                memorySize[i] = partitionSize[bestIndex];

                // Add difference of specific allocation to fragmentation array
                fragmentation[i] = partitionSize[bestIndex] -= jobSize[i];
            }
        }

        System.out.println(" Job #	    Job Size            Memory Size            Status              Fragmentation After Allocation");
        for (int i = 0; i < y; i++) {
            System.out.print(" " + (i+1) + "              " +
                    jobSize[i] + "             " + memorySize[i]);
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
        int partitionSize[] = {100, 300, 200, 300, 700};
        int jobSize[] = {212, 87, 112, 100};
        int x = partitionSize.length;
        int y = jobSize.length;

        bestFit(partitionSize, x, jobSize, y);
    }

}
