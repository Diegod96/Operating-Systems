import java.io.*;
import java.util.*;

public class LRU {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Declaring variables and data structures
        int numFrames = 0;
        int pointer = 0;
        int numHits = 0;
        int numFaults = 0;
        int referenceLength = 0;
        boolean isDone = false;
        int[] bufferArray;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int[] referenceString;
        int[][] memoryLayout;



        // Check if number of frames is a number
        // If not, let user know and restart program
        try {
            // Request number of frames
            System.out.println("Please enter the number of Frames: ");
            numFrames = Integer.parseInt(reader.readLine());
        }
        catch (NumberFormatException e){
            System.out.println("User input is not a number!");
            System.exit(0);
        }


        // Check if number if length of the reference string is a number
        // If not, let user know and restart program
        try {
            // Request length of reference string
            System.out.println("Please enter the length of the reference string: ");
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


        // Check if reference strings are a number
        // If not, let user know and restart program
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
        for(int i = 0; i < referenceLength; i++) {

            if(arrayList.contains(referenceString[i])) {
                arrayList.remove((Integer) referenceString[i]);
            }

            arrayList.add(referenceString[i]);

            // Variable that is used to look for unused empty slots
            int searchIndex = -1;

            // For loop that loops through the frames and finds hits
            for(int j = 0; j < numFrames; j++) {
                if(bufferArray[j] == referenceString[i]) {
                    searchIndex = j;
                    numHits++;
                    break;
                }
            }

            // Searches for slots in memory that still have -1
            // Moves pointer
            if(searchIndex == -1) {
                if(isDone) {
                    int memoryLocation = referenceLength;
                    for(int j = 0; j < numFrames; j++) {
                        if(arrayList.contains(bufferArray[j])) {
                            int temporaryIndex = arrayList.indexOf(bufferArray[j]);
                            if(temporaryIndex < memoryLocation) {
                                memoryLocation = temporaryIndex;
                                pointer = j;
                            }
                        }
                    }
                }

                // If condition fails then add a fault and iterate pointer
                bufferArray[pointer] = referenceString[i];
                numFaults++;
                pointer++;

                // Hit the end of memory and finish LRU page removal
                if(pointer == numFrames) {
                    pointer = 0;
                    isDone = true;
                }
            }
            System.arraycopy(bufferArray, 0, memoryLayout[i], 0, numFrames);
        }

        // Print out end result of LRU page replacement
        for(int i = 0; i < numFrames; i++)
        {
            for(int j = 0; j < referenceLength; j++)
                System.out.printf("%3d",memoryLayout[j][i]);
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