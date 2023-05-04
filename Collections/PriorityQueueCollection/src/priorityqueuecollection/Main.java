package priorityqueuecollection;

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
        PriorityQueueCollection<Integer> priorityQueue = new PriorityQueueCollection<>();
        Thread.sleep(3000);

        
        // number of available processors;
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        priorityQueue.add(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = priorityQueue.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        
        System.out.println("memoryConsumption: " + priorityQueue.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        
        priorityQueue.writeToFile("priorityQueueAddCPU.csv", priorityQueue, cpuPercent);
        priorityQueue.writeToFile("priorityQueueAddMemory.csv", priorityQueue, priorityQueue.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // priorityQueue collection Contains
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        priorityQueue.contains(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = priorityQueue.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
       
        System.out.println("memoryConsumption: " + priorityQueue.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
       
        priorityQueue.writeToFile("priorityQueueSearchCPU.csv", priorityQueue, cpuPercent);
        priorityQueue.writeToFile("priorityQueueSearchMemory.csv", priorityQueue, priorityQueue.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // priorityQueue collection Remove
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); 
        priorityQueue.remove(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = priorityQueue.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
   
        System.out.println("memoryConsumption: " + priorityQueue.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
       
        priorityQueue.writeToFile("priorityQueueRemoveCPU.csv", priorityQueue, cpuPercent);
        priorityQueue.writeToFile("priorityQueueRemoveMemory.csv", priorityQueue, priorityQueue.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        System.exit(0);
    }
        
    }
    

