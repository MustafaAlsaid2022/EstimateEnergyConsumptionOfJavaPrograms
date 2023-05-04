package linkedlistcollection;

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
        LinkedListCollection<Integer> linkedList = new LinkedListCollection<>();
        Thread.sleep(3000);

        
        // number of available processors;
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        linkedList.add(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = linkedList.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
       
        System.out.println("memoryConsumption: " + linkedList.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        
        linkedList.writeToFile("linkedListAddCPU.csv", linkedList, cpuPercent);
        linkedList.writeToFile("linkedListAddMemory.csv", linkedList, linkedList.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // linkedList collection Contains
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        linkedList.contains(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = linkedList.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        
        System.out.println("memoryConsumption: " + linkedList.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
       
        linkedList.writeToFile("linkedListSearchCPU.csv", linkedList, cpuPercent);
        linkedList.writeToFile("linkedListSearchMemory.csv", linkedList, linkedList.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // linkedList collection Remove
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        linkedList.remove(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = linkedList.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        
        System.out.println("memoryConsumption: " + linkedList.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        
        linkedList.writeToFile("linkedListRemoveCPU.csv", linkedList, cpuPercent);
        linkedList.writeToFile("linkedListRemoveMemory.csv", linkedList, linkedList.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        System.exit(0);

    }
}
