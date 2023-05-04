package arraylistcollection;

import java.lang.management.ManagementFactory;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int number = Integer.parseInt(args[0]);
        int seed = 200;
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
        arrayList.add(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = arrayList.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        
        System.out.println("memoryConsumption: " + arrayList.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        
        arrayList.writeToFile("arrayListAddCPU.csv", arrayList, cpuPercent);
        arrayList.writeToFile("arrayListAddMemory.csv", arrayList, arrayList.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // arrayList collection Contains
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        arrayList.contains(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = arrayList.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        
        System.out.println("memoryConsumption: " + arrayList.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
       
        arrayList.writeToFile("arrayListSearchCPU.csv", arrayList, cpuPercent);
        arrayList.writeToFile("arrayListSearchMemory.csv", arrayList, arrayList.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // arrayList collection Remove
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        arrayList.remove(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = arrayList.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
    
        System.out.println("memoryConsumption: " + arrayList.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        
        arrayList.writeToFile("arrayListRemoveCPU.csv", arrayList, cpuPercent);
        arrayList.writeToFile("arrayListRemoveMemory.csv", arrayList, arrayList.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        System.exit(0);
    }
}
