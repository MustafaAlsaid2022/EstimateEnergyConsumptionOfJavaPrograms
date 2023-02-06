package linkedlistcollection;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int number = 400000;
        int seed = 200;
        double start;
        double end;
        long mem0;
        long mem1;
        double cpu0;
        double cpu1;
        double usedCPU;
        Runtime rt = Runtime.getRuntime();
        LinkedListCollection<Integer> linkedListCollection = new LinkedListCollection<>();
        Thread.sleep(3000);

        // linkedListCollection collection Add
        cpu0 = linkedListCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        linkedListCollection.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = linkedListCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + linkedListCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + linkedListCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        linkedListCollection.writeToFile("linkedListCollectionAddTime.csv", linkedListCollection, linkedListCollection.estimatedTotalTime(start, end));
        linkedListCollection.writeToFile("linkedListCollectionAddCPU.csv", linkedListCollection, usedCPU);
        linkedListCollection.writeToFile("linkedListCollectionAddMemory.csv", linkedListCollection, linkedListCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // linkedListCollection collection Contains
        cpu0 = linkedListCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        linkedListCollection.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = linkedListCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + linkedListCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + linkedListCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        linkedListCollection.writeToFile("linkedListCollectionSearchTime.csv", linkedListCollection, linkedListCollection.estimatedTotalTime(start, end));
        linkedListCollection.writeToFile("linkedListCollectionSearchCPU.csv", linkedListCollection, usedCPU);
        linkedListCollection.writeToFile("linkedListCollectionSearchMemory.csv", linkedListCollection, linkedListCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // linkedListCollection collection Remove
        cpu0 = linkedListCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        linkedListCollection.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = linkedListCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + linkedListCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + linkedListCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        linkedListCollection.writeToFile("linkedListCollectionRemoveTime.csv", linkedListCollection, linkedListCollection.estimatedTotalTime(start, end));
        linkedListCollection.writeToFile("linkedListCollectionRemoveCPU.csv", linkedListCollection, usedCPU);
        linkedListCollection.writeToFile("linkedListCollectionRemoveMemory.csv", linkedListCollection, linkedListCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        
        System.exit(0);
    }
}
