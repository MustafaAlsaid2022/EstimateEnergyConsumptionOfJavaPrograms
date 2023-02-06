package stackcollection;


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
        StackCollection<Integer> stackCollection = new StackCollection<>();
        Thread.sleep(3000);

        // stack collection Add
        cpu0 = stackCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        stackCollection.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = stackCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + stackCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + stackCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        stackCollection.writeToFile("stackCollectionAddTime.csv", stackCollection, stackCollection.estimatedTotalTime(start, end));
        stackCollection.writeToFile("stackCollectionAddCPU.csv", stackCollection, usedCPU);
        stackCollection.writeToFile("stackCollectionAddMemory.csv", stackCollection, stackCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // stack collection Contains
        cpu0 = stackCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        stackCollection.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = stackCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + stackCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + stackCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        stackCollection.writeToFile("stackCollectionSearchTime.csv", stackCollection, stackCollection.estimatedTotalTime(start, end));
        stackCollection.writeToFile("stackCollectionSearchCPU.csv", stackCollection, usedCPU);
        stackCollection.writeToFile("stackCollectionSearchMemory.csv", stackCollection, stackCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // stack collection Remove
        cpu0 = stackCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        stackCollection.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = stackCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + stackCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + stackCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        stackCollection.writeToFile("stackCollectionRemoveTime.csv", stackCollection, stackCollection.estimatedTotalTime(start, end));
        stackCollection.writeToFile("stackCollectionRemoveCPU.csv", stackCollection, usedCPU);
        stackCollection.writeToFile("stackCollectionRemoveMemory.csv", stackCollection, stackCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();
        
        System.exit(0);
    }
    }
        
    
    

