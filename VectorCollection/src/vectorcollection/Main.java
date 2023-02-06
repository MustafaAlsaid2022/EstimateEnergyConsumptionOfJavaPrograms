/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vectorcollection;


public class Main {
    
    public static void main (String[] args) throws InterruptedException{
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
        VectorCollection<Integer> vectorCollection = new VectorCollection<>();
        Thread.sleep(3000);

        // vector collection Add
        cpu0 = vectorCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        vectorCollection.add(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = vectorCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + vectorCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + vectorCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        vectorCollection.writeToFile("vectorCollectionAddTime.csv", vectorCollection, vectorCollection.estimatedTotalTime(start, end));
        vectorCollection.writeToFile("vectorCollectionAddCPU.csv", vectorCollection, usedCPU);
        vectorCollection.writeToFile("vectorCollectionAddMemory.csv", vectorCollection, vectorCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // vector collection Contains
        cpu0 = vectorCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        vectorCollection.contains(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = vectorCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + vectorCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + vectorCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        vectorCollection.writeToFile("vectorCollectionSearchTime.csv", vectorCollection, vectorCollection.estimatedTotalTime(start, end));
        vectorCollection.writeToFile("vectorCollectionSearchCPU.csv", vectorCollection, usedCPU);
        vectorCollection.writeToFile("vectorCollectionSearchMemory.csv", vectorCollection, vectorCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();

        // vector collection Remove
        cpu0 = vectorCollection.getUsedCPU();
        mem0 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        start = System.currentTimeMillis();
        vectorCollection.remove(seed, number);
        end = System.currentTimeMillis();
        mem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        cpu1 = vectorCollection.getUsedCPU();
        usedCPU = cpu1 - cpu0;
        System.out.println("The estimated Time: " + vectorCollection.estimatedTotalTime(start, end));
        System.out.println("memoryConsumption: " + vectorCollection.getUsedMemory(mem0, mem1));
        System.out.println("CPUConsumption: " + usedCPU);
        vectorCollection.writeToFile("vectorCollectionRemoveTime.csv", vectorCollection, vectorCollection.estimatedTotalTime(start, end));
        vectorCollection.writeToFile("vectorCollectionRemoveCPU.csv", vectorCollection, usedCPU);
        vectorCollection.writeToFile("vectorCollectionRemoveMemory.csv", vectorCollection, vectorCollection.getUsedMemory(mem0, mem1));
        Thread.sleep(3000);
        rt.gc();
        
        System.exit(0);
    }
    }
    

