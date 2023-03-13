package vectorcollection;

import java.lang.management.ManagementFactory;


public class Main {
    
    public static void main (String[] args) throws InterruptedException{
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
        VectorCollection<Integer> vector = new VectorCollection<>();
        Thread.sleep(3000);

        
        // number of available processors;
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        vector.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = vector.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + vector.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + vector.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        vector.writeToFile("vectorAddTime.csv", vector, vector.estimatedTotalTime(start, end));
        vector.writeToFile("vectorAddCPU.csv", vector, cpuPercent);
        vector.writeToFile("vectorAddMemory.csv", vector, vector.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // vector collection Contains
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        vector.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = vector.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + vector.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + vector.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        vector.writeToFile("vectorSearchTime.csv", vector, vector.estimatedTotalTime(start, end));
        vector.writeToFile("vectorSearchCPU.csv", vector, cpuPercent);
        vector.writeToFile("vectorSearchMemory.csv", vector, vector.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // vector collection Remove
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        vector.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = vector.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + vector.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + vector.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        vector.writeToFile("vectorRemoveTime.csv", vector, vector.estimatedTotalTime(start, end));
        vector.writeToFile("vectorRemoveCPU.csv", vector, cpuPercent);
        vector.writeToFile("vectorRemoveMemory.csv", vector, vector.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        System.exit(0);
    }
    }
    

