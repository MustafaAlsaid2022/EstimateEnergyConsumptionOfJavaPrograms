
package arraylistcollection;




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
        ArrayListCollection<Integer> arrayList = new ArrayListCollection<>();
        Thread.sleep(3000);
        
        // arrayList collection Add
        cpu0 = arrayList.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        arrayList.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 =  arrayList.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + arrayList.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + arrayList.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        arrayList.writeToFile("arrayListAddTime.csv", arrayList, arrayList.estimatedTotalTime(start, end));
        arrayList.writeToFile("arrayListAddCPU.csv", arrayList, usedCPU);
        arrayList.writeToFile("arrayListAddMemory.csv", arrayList, arrayList.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // arrayList collection Contains
        cpu0 = arrayList.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        arrayList.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 =  arrayList.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + arrayList.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + arrayList.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        arrayList.writeToFile("arrayListSearchTime.csv", arrayList, arrayList.estimatedTotalTime(start, end));
        arrayList.writeToFile("arrayListSearchCPU.csv", arrayList, usedCPU);
        arrayList.writeToFile("arrayListSearchMemory.csv", arrayList, arrayList.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // arrayList collection Remove
        cpu0 = arrayList.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        arrayList.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 =  arrayList.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + arrayList.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + arrayList.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        arrayList.writeToFile("arrayListRemoveTime.csv", arrayList, arrayList.estimatedTotalTime(start, end));
        arrayList.writeToFile("arrayListRemoveCPU.csv", arrayList, usedCPU);
        arrayList.writeToFile("arrayListRemoveMemory.csv", arrayList, arrayList.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();
        
        System.exit(0);
    }
}
