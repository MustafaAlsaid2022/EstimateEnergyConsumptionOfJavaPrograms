package heapsort;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.util.Random;

/*https://www.programiz.com/dsa/heap-sort
  https://java2blog.com/sorting-algorithms-java/#4_Heap_sort */
public class HeapSortAlgorithm {
    private Random random;

    public void sort(int arr[])
    {

        int N = arr.length;
        // Build max heap
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // Heap sort
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public void heapify(int arr[], int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1 node
        int r = 2 * i + 2; // right = 2*i + 2 node

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than root
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
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
        return ( mem0- mem1)/(1024.0*1024.0);
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


