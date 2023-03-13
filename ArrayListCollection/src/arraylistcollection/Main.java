package arraylistcollection;

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
        ArrayListCollection<Integer> arrayList = new ArrayListCollection<>();
        Thread.sleep(3000);

        
        // number of available processors;
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        arrayList.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = arrayList.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + arrayList.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + arrayList.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        arrayList.writeToFile("arrayListAddTime.csv", arrayList, arrayList.estimatedTotalTime(start, end));
        arrayList.writeToFile("arrayListAddCPU.csv", arrayList, cpuPercent);
        arrayList.writeToFile("arrayListAddMemory.csv", arrayList, arrayList.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // arrayList collection Contains
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        arrayList.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = arrayList.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + arrayList.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + arrayList.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        arrayList.writeToFile("arrayListSearchTime.csv", arrayList, arrayList.estimatedTotalTime(start, end));
        arrayList.writeToFile("arrayListSearchCPU.csv", arrayList, cpuPercent);
        arrayList.writeToFile("arrayListSearchMemory.csv", arrayList, arrayList.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // arrayList collection Remove
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        arrayList.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = arrayList.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + arrayList.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + arrayList.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        arrayList.writeToFile("arrayListRemoveTime.csv", arrayList, arrayList.estimatedTotalTime(start, end));
        arrayList.writeToFile("arrayListRemoveCPU.csv", arrayList, cpuPercent);
        arrayList.writeToFile("arrayListRemoveMemory.csv", arrayList, arrayList.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        System.exit(0);
    }
}
