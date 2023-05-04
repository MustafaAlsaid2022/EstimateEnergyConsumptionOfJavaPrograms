package treesetcollection;

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
        TreeSetCollection<Integer> treeSet = new TreeSetCollection<>();
        Thread.sleep(3000);

        
        // number of available processors;
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        treeSet.add(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = treeSet.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
       
        System.out.println("memoryConsumption: " + treeSet.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        
        treeSet.writeToFile("treeSetAddCPU.csv", treeSet, cpuPercent);
        treeSet.writeToFile("treeSetAddMemory.csv", treeSet, treeSet.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // treeSet collection Contains
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        treeSet.contains(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = treeSet.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        
        System.out.println("memoryConsumption: " + treeSet.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
  
        treeSet.writeToFile("treeSetSearchCPU.csv", treeSet, cpuPercent);
        treeSet.writeToFile("treeSetSearchMemory.csv", treeSet, treeSet.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // treeSet collection Remove
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        treeSet.remove(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = treeSet.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
       
        System.out.println("memoryConsumption: " + treeSet.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
       
        treeSet.writeToFile("treeSetRemoveCPU.csv", treeSet, cpuPercent);
        treeSet.writeToFile("treeSetRemoveMemory.csv", treeSet, treeSet.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        System.exit(0);
    }
       
    }
    

