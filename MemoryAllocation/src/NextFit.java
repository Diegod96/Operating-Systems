import java.util.Arrays;

public class NextFit {

    // Function to allocate memory to blocks as per Next fit
// algorithm
    static void NextFit(int blockSize[], int m, int processSize[], int n) {
        // Stores block id of the block allocated to a
        // process
        int allocation[] = new int[n], j = 0;

        int fragmentation[] = new int[n];

        int memorySize[] = new int[n];

        // Initially no block is assigned to any process
        Arrays.fill(allocation, -1);

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < n; i++) {

            // Do not start from beginning
            while (j < m) {

                if (blockSize[j] >= processSize[i]) {

                    // allocate block j to p[i] process
                    allocation[i] = j;
                    memorySize[i] = blockSize[j];

                    // Reduce available memory in this block.
                    fragmentation[i] = blockSize[j] -= processSize[i];

                    break;
                }

                // mod m will help in traversing the blocks from
                // starting block after we reach the end.
                j = (j + 1) % m;
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


    // Driver program
    static public void main(String[] args) {
        int blockSize[] = {5, 10, 20};
        int processSize[] = {10, 20, 5};
        int m = blockSize.length;
        int n = processSize.length;
        NextFit(blockSize, m, processSize, n);
    }

}
