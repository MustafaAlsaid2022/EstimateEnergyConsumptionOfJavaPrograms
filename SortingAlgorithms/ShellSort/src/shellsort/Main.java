package shellsort;

import java.lang.management.ManagementFactory;
import java.util.Arrays;
public class Main {

    public static void main(String args[]) throws InterruptedException {
        //int[] arr = new int[400000]; //sorting 400000 random integers
        int [] arr = new int[Integer.parseInt(args[0])];
        long mem0;
        long mem1;
        int cpuCount;
        long startCPUTime;
        long startNS;
        double cpuPercent;

        Runtime runtime = Runtime.getRuntime();
        ShellSortAlgorithm obj = new ShellSortAlgorithm();
        obj.CreateRandoms(arr);
        Thread.sleep(3000);

        // number of available processors
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        //CPU start
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
        startNS = System.nanoTime();
        //memory start
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        //Sort Start
        obj.sort(arr);

        //Memory end
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        //CPU end
        cpuPercent = obj.calcCPU(startCPUTime, startNS, cpuCount)/100.0;

        System.out.println("memoryConsumption: " + obj.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);

        obj.writeToFile("shellSortCPU.csv", cpuPercent);
        obj.writeToFile("shellSortMemory.csv", obj.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        runtime.gc();

         /*
         //print sorted array
         System.out.println("Sorted array: " + Arrays.toString(arr));
          */

        System.exit(0);
    }
}