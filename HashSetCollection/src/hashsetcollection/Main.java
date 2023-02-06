
package hashsetcollection;


public class Main {
    
    public static void main(String [] args) throws InterruptedException{
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
        HashSetCollection<Integer> hashSetCollection = new HashSetCollection<>();
        Thread.sleep(3000);

        // hashSet collection Add
        cpu0 = hashSetCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        hashSetCollection.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = hashSetCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + hashSetCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + hashSetCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        hashSetCollection.writeToFile("hashSetCollectionAddTime.csv", hashSetCollection, hashSetCollection.estimatedTotalTime(start, end));
        hashSetCollection.writeToFile("hashSetCollectionAddCPU.csv", hashSetCollection, usedCPU);
        hashSetCollection.writeToFile("hashSetCollectionAddMemory.csv", hashSetCollection, hashSetCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // hashSet collection Contains
        cpu0 = hashSetCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        hashSetCollection.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = hashSetCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + hashSetCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + hashSetCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        hashSetCollection.writeToFile("hashSetCollectionSearchTime.csv", hashSetCollection, hashSetCollection.estimatedTotalTime(start, end));
        hashSetCollection.writeToFile("hashSetCollectionSearchCPU.csv", hashSetCollection, usedCPU);
        hashSetCollection.writeToFile("hashSetCollectionSearchMemory.csv", hashSetCollection, hashSetCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // hashSet collection Remove
        cpu0 = hashSetCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        hashSetCollection.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = hashSetCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + hashSetCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + hashSetCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        hashSetCollection.writeToFile("hashSetCollectionRemoveTime.csv", hashSetCollection, hashSetCollection.estimatedTotalTime(start, end));
        hashSetCollection.writeToFile("hashSetCollectionRemoveCPU.csv", hashSetCollection, usedCPU);
        hashSetCollection.writeToFile("hashSetCollectionRemoveMemory.csv", hashSetCollection, hashSetCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();
        

        System.exit(0);
    }
    }
    

