package treesetcollection;


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
        TreeSetCollection<Integer> treeSetCollection = new TreeSetCollection<>();
        Thread.sleep(3000);

        // treeSet collection Add
        cpu0 = treeSetCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        treeSetCollection.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = treeSetCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + treeSetCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + treeSetCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        treeSetCollection.writeToFile("treeSetCollectionAddTime.csv", treeSetCollection, treeSetCollection.estimatedTotalTime(start, end));
        treeSetCollection.writeToFile("treeSetCollectionAddCPU.csv", treeSetCollection, usedCPU);
        treeSetCollection.writeToFile("treeSetCollectionAddMemory.csv", treeSetCollection, treeSetCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // treeSet collection Contains
        cpu0 = treeSetCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        treeSetCollection.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = treeSetCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + treeSetCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + treeSetCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        treeSetCollection.writeToFile("treeSetCollectionSearchTime.csv", treeSetCollection, treeSetCollection.estimatedTotalTime(start, end));
        treeSetCollection.writeToFile("treeSetCollectionSearchCPU.csv", treeSetCollection, usedCPU);
        treeSetCollection.writeToFile("treeSetCollectionSearchMemory.csv", treeSetCollection, treeSetCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // treeSet collection Remove
        cpu0 = treeSetCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        treeSetCollection.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = treeSetCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + treeSetCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + treeSetCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        treeSetCollection.writeToFile("treeSetCollectionRemoveTime.csv", treeSetCollection, treeSetCollection.estimatedTotalTime(start, end));
        treeSetCollection.writeToFile("treeSetCollectionRemoveCPU.csv", treeSetCollection, usedCPU);
        treeSetCollection.writeToFile("treeSetCollectionRemoveMemory.csv", treeSetCollection, treeSetCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();
        
        System.exit(0);
    }
       
    }
    

