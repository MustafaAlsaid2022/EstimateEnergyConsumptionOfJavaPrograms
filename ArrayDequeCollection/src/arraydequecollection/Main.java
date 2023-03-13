package arraydequecollection;

import java.lang.management.ManagementFactory;

public class Main {

    public static void main(String[] args) throws InterruptedException {
      int number = Integer.parseInt(args[0]);
        int seed = 200;
        double start;
        double end;
        long mem0;
        long mem1;
        int cpuCount;
        long startCPUTime;
        long startNanoTime;
        double cpuPercent;
        Runtime rt = Runtime.getRuntime();
        ArrayDequeCollection<Integer> arrayDeque = new ArrayDequeCollection<>();
        Thread.sleep(3000);

        
        // number of available processors;
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        arrayDeque.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = arrayDeque.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + arrayDeque.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + arrayDeque.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        arrayDeque.writeToFile("arrayDequeAddTime.csv", arrayDeque, arrayDeque.estimatedTotalTime(start, end));
        arrayDeque.writeToFile("arrayDequeAddCPU.csv", arrayDeque, cpuPercent);
        arrayDeque.writeToFile("arrayDequeAddMemory.csv", arrayDeque, arrayDeque.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // arrayDeque collection Contains
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        arrayDeque.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = arrayDeque.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + arrayDeque.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + arrayDeque.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        arrayDeque.writeToFile("arrayDequeSearchTime.csv", arrayDeque, arrayDeque.estimatedTotalTime(start, end));
        arrayDeque.writeToFile("arrayDequeSearchCPU.csv", arrayDeque, cpuPercent);
        arrayDeque.writeToFile("arrayDequeSearchMemory.csv", arrayDeque, arrayDeque.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // arrayDeque collection Remove
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        arrayDeque.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = arrayDeque.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + arrayDeque.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + arrayDeque.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        arrayDeque.writeToFile("arrayDequeRemoveTime.csv", arrayDeque, arrayDeque.estimatedTotalTime(start, end));
        arrayDeque.writeToFile("arrayDequeRemoveCPU.csv", arrayDeque, cpuPercent);
        arrayDeque.writeToFile("arrayDequeRemoveMemory.csv", arrayDeque, arrayDeque.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        System.exit(0);
    }
}
