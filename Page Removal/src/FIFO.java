import java.io.*;
public class FIFO {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        // Declaring variables and data structures
        int numFrames = 0;
        int pointer = 0;
        int numHits = 0;
        int numFaults = 0;
        int referenceLength = 0;
        int[] bufferArray;
        int[] referenceString;
        int[][] memoryLayout;



        try {
            // Request number of frames
            System.out.println("Please enter the number of Frames: ");
            numFrames = Integer.parseInt(reader.readLine());
        }
        catch (NumberFormatException e){
            System.out.println("User input is not a number!");
            System.exit(0);
        }


        try {
            // Request length of reference string
            System.out.println("Please enter the length of the Reference string: ");
            referenceLength = Integer.parseInt(reader.readLine());
        }
        catch (NumberFormatException e){
            System.out.println("User input is not a number!");
            System.exit(0);
        }


        // Set memory layout to the length of the reference string and # frames
        referenceString = new int[referenceLength];
        memoryLayout = new int[referenceLength][numFrames];

        // Buffer that fills all slots in memory initially with -1
        bufferArray = new int[numFrames];
        for(int j = 0; j < numFrames; j++)
            bufferArray[j] = -1;


        try {
            // Request the reference string
            System.out.println("Please enter the reference string: ");
            for (int i = 0; i < referenceLength; i++) {
                referenceString[i] = Integer.parseInt(reader.readLine());
            }
        }
        catch (NumberFormatException e){
            System.out.println("User input is not a number!");
            System.exit(0);
        }

        System.out.println();

        // Iterate the length of the reference string and the buffer
        // Use search variable to find slots in memory unassigned
        for(int i = 0; i < referenceLength; i++) {
            int searchIndex = -1;
            for(int j = 0; j < numFrames; j++) {

                // A match is found, record a hit
                if(bufferArray[j] == referenceString[i]) {
                    searchIndex = j;
                    numHits++;
                    break;
                }
            }

            // Else record a miss and iterate the pointer
            if(searchIndex == -1) {
                bufferArray[pointer] = referenceString[i];
                numFaults++;
                pointer++;
                if(pointer == numFrames)
                    pointer = 0;
            }
            System.arraycopy(bufferArray, 0, memoryLayout[i], 0, numFrames);
        }

        // Print out end result of FIFO page removal
        for(int i = 0; i < numFrames; i++) {
            for(int j = 0; j < referenceLength; j++)
                System.out.printf("%3d" ,memoryLayout[j][i]);
            System.out.println();
        }



        // Calculate hit ratio and miss ratio
        float hitRatio = (float)numHits/(float)referenceLength;
        float missRatio = (float)1 - hitRatio;


        System.out.println("The number of Hits: " + numHits);
        System.out.println("The number of Faults: " + numFaults);
        System.out.println("Hit Ratio: " + hitRatio);
        System.out.println("Miss ratio: " + missRatio);
    }

}