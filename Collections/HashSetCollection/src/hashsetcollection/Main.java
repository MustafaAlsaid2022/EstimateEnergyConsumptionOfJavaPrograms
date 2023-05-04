
package hashsetcollection;

import java.lang.management.ManagementFactory;


public class Main {
    
    public static void main(String [] args) throws InterruptedException{
        int number = Integer.parseInt(args[0]);
        int seed = 200;
        long mem0;
        long mem1;
        int cpuCount;
        long startCPUTime;
        long startNanoTime;
        double cpuPercent;
        Runtime rt = Runtime.getRuntime();
        HashSetCollection<Integer> hashSet = new HashSetCollection<>();
        Thread.sleep(3000);

        
        // number of available processors;
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        hashSet.add(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = hashSet.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
        
        System.out.println("memoryConsumption: " + hashSet.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
       
        hashSet.writeToFile("hashSetAddCPU.csv", hashSet, cpuPercent);
        hashSet.writeToFile("hashSetAddMemory.csv", hashSet, hashSet.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // hashSet collection Contains
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        hashSet.contains(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = hashSet.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
       
        System.out.println("memoryConsumption: " + hashSet.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        
        hashSet.writeToFile("hashSetSearchCPU.csv", hashSet, cpuPercent);
        hashSet.writeToFile("hashSetSearchMemory.csv", hashSet, hashSet.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // hashSet collection Remove
        cpuCount = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        startCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	startNanoTime = System.nanoTime();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        hashSet.remove(seed, number);
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpuPercent = hashSet.calcCPU(startCPUTime, startNanoTime, cpuCount)/100.0;
       
        System.out.println("memoryConsumption: " + hashSet.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + cpuPercent);
        
        hashSet.writeToFile("hashSetRemoveCPU.csv", hashSet, cpuPercent);
        hashSet.writeToFile("hashSetRemoveMemory.csv", hashSet, hashSet.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        System.exit(0);
    }
    }
    

