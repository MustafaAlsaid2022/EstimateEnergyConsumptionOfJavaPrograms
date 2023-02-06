
package priorityqueuecollection;


public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        int number = Integer.parseInt(args[0]);
        int seed = 200;
        double start;
        double end;
        long mem0;
        long mem1;
        double cpu0;
        double cpu1;
        double usedCPU;
        Runtime rt = Runtime.getRuntime();
        PriorityQueueCollection<Integer> priorityQueueCollection = new PriorityQueueCollection<>();
        Thread.sleep(3000);

        // priorityQueue collection Add
        cpu0 = priorityQueueCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        priorityQueueCollection.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = priorityQueueCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + priorityQueueCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + priorityQueueCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        priorityQueueCollection.writeToFile("priorityQueueCollectionAddTime.csv", priorityQueueCollection, priorityQueueCollection.estimatedTotalTime(start, end));
        priorityQueueCollection.writeToFile("priorityQueueCollectionAddCPU.csv", priorityQueueCollection, usedCPU);
        priorityQueueCollection.writeToFile("priorityQueueCollectionAddMemory.csv", priorityQueueCollection, priorityQueueCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // priorityQueue collection Contains
        cpu0 = priorityQueueCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        priorityQueueCollection.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = priorityQueueCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + priorityQueueCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + priorityQueueCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        priorityQueueCollection.writeToFile("priorityQueueCollectionSearchTime.csv", priorityQueueCollection, priorityQueueCollection.estimatedTotalTime(start, end));
        priorityQueueCollection.writeToFile("priorityQueueCollectionSearchCPU.csv", priorityQueueCollection, usedCPU);
        priorityQueueCollection.writeToFile("priorityQueueCollectionSearchMemory.csv", priorityQueueCollection, priorityQueueCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // priorityQueue collection Remove
        cpu0 = priorityQueueCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        priorityQueueCollection.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = priorityQueueCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + priorityQueueCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + priorityQueueCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        priorityQueueCollection.writeToFile("priorityQueueCollectionRemoveTime.csv", priorityQueueCollection, priorityQueueCollection.estimatedTotalTime(start, end));
        priorityQueueCollection.writeToFile("priorityQueueCollectionRemoveCPU.csv", priorityQueueCollection, usedCPU);
        priorityQueueCollection.writeToFile("priorityQueueCollectionRemoveMemory.csv", priorityQueueCollection, priorityQueueCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();
        System.exit(0);
    }
        
    }
    

