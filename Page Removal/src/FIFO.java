import java.io.*;
public class FIFO {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Declaring variables and data structures
        int frames;
        int pointer = 0;
        int numHits = 0;
        int numFaults = 0;
        int referenceLength;
        int[] buffer;
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

        // Iterate the length of the reference string and the buffer
        // Use search variable to find slots in memory unassigned
        for(int i = 0; i < referenceLength; i++)
        {
            int search = -1;
            for(int j = 0; j < frames; j++) {

                // If the spot in the buffer is in the reference string, record a hit
                if(buffer[j] == referenceString[i]) {
                    search = j;
                    numHits++;
                    break;
                }
            }

            // Else record a miss and iterate the pointer
            if(search == -1) {
                buffer[pointer] = referenceString[i];
                numFaults++;
                pointer++;
                if(pointer == frames)
                    pointer = 0;
            }
            System.arraycopy(buffer, 0, mem_layout[i], 0, frames);
        }

        // Print out end result of FIFO page replacement
        for(int i = 0; i < frames; i++) {
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