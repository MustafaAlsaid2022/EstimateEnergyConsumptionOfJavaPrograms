package selectionsort;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.util.Random;


public class SelectionSortAlgorithm {
    private  Random random;
    public void sort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    public void CreateRandoms(int arr[]){
        random = new Random(200);
        for (int i = 0; i < arr.length; i++) {
            // Add 400000 random integers to an array
            arr[i] = random.nextInt(2000001) - 1000000;
        }
    }

    public int calcCPU(long cpuStartTime, long elapsedStartTime, int cpuCount){
        long end = System.nanoTime();
        long totalAvailCPUTime = cpuCount * (end-elapsedStartTime);
        long totalUsedCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime()-cpuStartTime;
        float per = ((float)totalUsedCPUTime*100)/(float)totalAvailCPUTime;
        return (int)per;

    }
    public double getUsedMemory(long mem0, long mem1) {
        return (mem1 - mem0)/(1024.0*1024.0);
    }
    public void writeToFile(String fileName, double value) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, true))) {
            pw.println(value);
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
