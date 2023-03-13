package linkedhashsetcollection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Random;


public class LinkedHashSetCollection<T> {

    private final Collection collection;
    private Random random;


    public LinkedHashSetCollection() {
        collection = new LinkedHashSet<>();
    }

    public void add(int seed, int number) {
        try {
            random = new Random(seed);
            while (collection.size() < number) {
                collection.add(random.nextInt());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void remove(int seed, int number) {
        try {
            random = new Random(seed);
            while (!collection.isEmpty()) {
                collection.remove(random.nextInt());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void contains(int seed, int number) {
        try {
            random = new Random(seed);
            int i = 0;

            while (i < number) {
                if (i > number * 0.9) {
                    collection.contains(random.nextInt() + 100);
                } else {
                    collection.contains(random.nextInt());
                }
                i++;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public double estimatedTotalTime(double start, double end) {
        return end - start;
    }

    public int calcCPU(long cpuStartTime, long elapsedStartTime, int cpuCount) {
        long end = System.nanoTime();
        long totalAvailCPUTime = cpuCount * (end - elapsedStartTime);
        long totalUsedCPUTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime() - cpuStartTime;
        float per = ((float) totalUsedCPUTime * 100) / (float) totalAvailCPUTime;
        return (int) per;
    }

    public double getUsedMemory(long mem0, long mem1) {
        return (mem1 - mem0) / (1024.0 * 1024.0);
    }

    public void writeToFile(String fileName, LinkedHashSetCollection<T> collection, double value) {
        try ( PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, true))) {
            pw.println(value);
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
