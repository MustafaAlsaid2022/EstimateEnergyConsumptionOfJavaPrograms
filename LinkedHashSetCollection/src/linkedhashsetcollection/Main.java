package linkedhashsetcollection;

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
        LinkedHashSetCollection<Integer> linkedHashSetCollection = new LinkedHashSetCollection<>();
        Thread.sleep(3000);

        // linkedHashSet collection Add
        cpu0 = linkedHashSetCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        linkedHashSetCollection.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = linkedHashSetCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + linkedHashSetCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + linkedHashSetCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        linkedHashSetCollection.writeToFile("linkedHashSetCollectionAddTime.csv", linkedHashSetCollection, linkedHashSetCollection.estimatedTotalTime(start, end));
        linkedHashSetCollection.writeToFile("linkedHashSetCollectionAddCPU.csv", linkedHashSetCollection, usedCPU);
        linkedHashSetCollection.writeToFile("linkedHashSetCollectionAddMemory.csv", linkedHashSetCollection, linkedHashSetCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // linkedHashSet collection Contains
        cpu0 = linkedHashSetCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        linkedHashSetCollection.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = linkedHashSetCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + linkedHashSetCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + linkedHashSetCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        linkedHashSetCollection.writeToFile("linkedHashSetCollectionSearchTime.csv", linkedHashSetCollection, linkedHashSetCollection.estimatedTotalTime(start, end));
        linkedHashSetCollection.writeToFile("linkedHashSetCollectionSearchCPU.csv", linkedHashSetCollection, usedCPU);
        linkedHashSetCollection.writeToFile("linkedHashSetCollectionSearchMemory.csv", linkedHashSetCollection, linkedHashSetCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // linkedHashSet collection Remove
        cpu0 = linkedHashSetCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        linkedHashSetCollection.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = linkedHashSetCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + linkedHashSetCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + linkedHashSetCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        linkedHashSetCollection.writeToFile("linkedHashSetCollectionRemoveTime.csv", linkedHashSetCollection, linkedHashSetCollection.estimatedTotalTime(start, end));
        linkedHashSetCollection.writeToFile("linkedHashSetCollectionRemoveCPU.csv", linkedHashSetCollection, usedCPU);
        linkedHashSetCollection.writeToFile("linkedHashSetCollectionRemoveMemory.csv", linkedHashSetCollection, linkedHashSetCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();
        System.exit(0);
    }
        
    }
    
