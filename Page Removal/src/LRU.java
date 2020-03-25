import java.io.*;
import java.util.*;

public class LRU {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Declaring variables and data structures
        int frames;
        int pointer = 0;
        int numHits = 0;
        int numFaults = 0;
        int referenceLength;
        boolean isFull = false;
        int[] buffer;
        ArrayList<Integer> stack = new ArrayList<Integer>();
        int[] referenceString;
        int[][] mem_layout;


        // Request number of frames
        System.out.println("Please enter the number of Frames: ");
        frames = Integer.parseInt(br.readLine());

        // Request length of reference string
        System.out.println("Please enter the length of the Reference string: ");
        referenceLength = Integer.parseInt(br.readLine());

        // Set memory layout to the length of the reference string and # frames
        referenceString = new int[referenceLength];
        mem_layout = new int[referenceLength][frames];

        // Buffer that fills all slots in memory initially with -1
        buffer = new int[frames];
        for(int j = 0; j < frames; j++)
            buffer[j] = -1;

        // Request the reference string
        System.out.println("Please enter the reference string: ");
        for(int i = 0; i < referenceLength; i++) {
            referenceString[i] = Integer.parseInt(br.readLine());
        }

        System.out.println();
        for(int i = 0; i < referenceLength; i++) {

            if(stack.contains(referenceString[i])) {
                stack.remove((Integer) referenceString[i]);
            }

            stack.add(referenceString[i]);

            // Variable that is used to look for unused empty slots
            int search = -1;

            // For loop that loops through the frames and finds hits
            for(int j = 0; j < frames; j++) {
                if(buffer[j] == referenceString[i]) {
                    search = j;
                    numHits++;
                    break;
                }
            }

            // Searches for slots in memory that still have -1
            // Moves pointer
            if(search == -1) {
                if(isFull) {
                    int min_loc = referenceLength;
                    for(int j = 0; j < frames; j++)
                    {
                        if(stack.contains(buffer[j]))
                        {
                            int temp = stack.indexOf(buffer[j]);
                            if(temp < min_loc)
                            {
                                min_loc = temp;
                                pointer = j;
                            }
                        }
                    }
                }

                // If condition fails then add a fault and iterate pointer
                buffer[pointer] = referenceString[i];
                numFaults++;
                pointer++;

                // Hit the end of memory and finish LRU page replacement
                if(pointer == frames)
                {
                    pointer = 0;
                    isFull = true;
                }
            }
            System.arraycopy(buffer, 0, mem_layout[i], 0, frames);
        }

        // Print out end result of LRU page replacement
        for(int i = 0; i < frames; i++)
        {
            for(int j = 0; j < referenceLength; j++)
                System.out.printf("%3d ",mem_layout[j][i]);
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