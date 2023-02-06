package arraydequecollection;

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
        ArrayDequeCollection<Integer> arrayDequeCollection = new ArrayDequeCollection<>();
        Thread.sleep(3000);

        // arrayDequeCollection collection Add
        cpu0 = arrayDequeCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        arrayDequeCollection.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = arrayDequeCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + arrayDequeCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + arrayDequeCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        arrayDequeCollection.writeToFile("arrayDequeCollectionAddTime.csv", arrayDequeCollection, arrayDequeCollection.estimatedTotalTime(start, end));
        arrayDequeCollection.writeToFile("arrayDequeCollectionAddCPU.csv", arrayDequeCollection, usedCPU);
        arrayDequeCollection.writeToFile("arrayDequeCollectionAddMemory.csv", arrayDequeCollection, arrayDequeCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // arrayDequeCollection collection Contains
        cpu0 = arrayDequeCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        arrayDequeCollection.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = arrayDequeCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + arrayDequeCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + arrayDequeCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        arrayDequeCollection.writeToFile("arrayDequeCollectionSearchTime.csv", arrayDequeCollection, arrayDequeCollection.estimatedTotalTime(start, end));
        arrayDequeCollection.writeToFile("arrayDequeCollectionSearchCPU.csv", arrayDequeCollection, usedCPU);
        arrayDequeCollection.writeToFile("arrayDequeCollectionSearchMemory.csv", arrayDequeCollection, arrayDequeCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // arrayDequeCollection collection Remove
        cpu0 = arrayDequeCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        arrayDequeCollection.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = arrayDequeCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + arrayDequeCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + arrayDequeCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        arrayDequeCollection.writeToFile("arrayDequeCollectionRemoveTime.csv", arrayDequeCollection, arrayDequeCollection.estimatedTotalTime(start, end));
        arrayDequeCollection.writeToFile("arrayDequeCollectionRemoveCPU.csv", arrayDequeCollection, usedCPU);
        arrayDequeCollection.writeToFile("arrayDequeCollectionRemoveMemory.csv", arrayDequeCollection, arrayDequeCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();
        
        System.exit(0);
    }
}
