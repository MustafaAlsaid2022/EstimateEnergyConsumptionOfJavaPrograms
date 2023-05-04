package linkedhashsetcollection;

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
        LinkedHashSetCollection<Integer> linkedHashSet = new LinkedHashSetCollection<>();
        Thread.sleep(3000);

        
        // number of available processors;
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        linkedHashSet.add(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = linkedHashSet.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
       
        System.out.println("memoryConsumption: " + linkedHashSet.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
    
        linkedHashSet.writeToFile("linkedHashSetAddCPU.csv", linkedHashSet, cpuPercent);
        linkedHashSet.writeToFile("linkedHashSetAddMemory.csv", linkedHashSet, linkedHashSet.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // linkedHashSet collection Contains
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        linkedHashSet.contains(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = linkedHashSet.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        
        System.out.println("memoryConsumption: " + linkedHashSet.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
     
        linkedHashSet.writeToFile("linkedHashSetSearchCPU.csv", linkedHashSet, cpuPercent);
        linkedHashSet.writeToFile("linkedHashSetSearchMemory.csv", linkedHashSet, linkedHashSet.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // linkedHashSet collection Remove
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        linkedHashSet.remove(seed, number); 
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = linkedHashSet.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
      
        System.out.println("memoryConsumption: " + linkedHashSet.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
      
        linkedHashSet.writeToFile("linkedHashSetRemoveCPU.csv", linkedHashSet, cpuPercent);
        linkedHashSet.writeToFile("linkedHashSetRemoveMemory.csv", linkedHashSet, linkedHashSet.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        System.exit(0);
    }
        
    }
    
