package treesetcollection;

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
        TreeSetCollection<Integer> treeSet = new TreeSetCollection<>();
        Thread.sleep(3000);

        
        // number of available processors;
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        treeSet.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = treeSet.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + treeSet.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + treeSet.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        treeSet.writeToFile("treeSetAddTime.csv", treeSet, treeSet.estimatedTotalTime(start, end));
        treeSet.writeToFile("treeSetAddCPU.csv", treeSet, cpuPercent);
        treeSet.writeToFile("treeSetAddMemory.csv", treeSet, treeSet.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // treeSet collection Contains
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        treeSet.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = treeSet.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + treeSet.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + treeSet.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        treeSet.writeToFile("treeSetSearchTime.csv", treeSet, treeSet.estimatedTotalTime(start, end));
        treeSet.writeToFile("treeSetSearchCPU.csv", treeSet, cpuPercent);
        treeSet.writeToFile("treeSetSearchMemory.csv", treeSet, treeSet.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // treeSet collection Remove
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        treeSet.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = treeSet.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + treeSet.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + treeSet.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        treeSet.writeToFile("treeSetRemoveTime.csv", treeSet, treeSet.estimatedTotalTime(start, end));
        treeSet.writeToFile("treeSetRemoveCPU.csv", treeSet, cpuPercent);
        treeSet.writeToFile("treeSetRemoveMemory.csv", treeSet, treeSet.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        System.exit(0);
    }
       
    }
    

