package stackcollection;

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
        StackCollection<Integer> stack = new StackCollection<>();
        Thread.sleep(3000);

        
        // number of available processors;
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        stack.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = stack.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + stack.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + stack.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        stack.writeToFile("stackAddTime.csv", stack, stack.estimatedTotalTime(start, end));
        stack.writeToFile("stackAddCPU.csv", stack, cpuPercent);
        stack.writeToFile("stackAddMemory.csv", stack, stack.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // stack collection Contains
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        stack.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = stack.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + stack.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + stack.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        stack.writeToFile("stackSearchTime.csv", stack, stack.estimatedTotalTime(start, end));
        stack.writeToFile("stackSearchCPU.csv", stack, cpuPercent);
        stack.writeToFile("stackSearchMemory.csv", stack, stack.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // stack collection Remove
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        stack.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = stack.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        System.out.println("The estimated Time: " + stack.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + stack.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        stack.writeToFile("stackRemoveTime.csv", stack, stack.estimatedTotalTime(start, end));
        stack.writeToFile("stackRemoveCPU.csv", stack, cpuPercent);
        stack.writeToFile("stackRemoveMemory.csv", stack, stack.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        System.exit(0);
    }
    }
        
    
    

