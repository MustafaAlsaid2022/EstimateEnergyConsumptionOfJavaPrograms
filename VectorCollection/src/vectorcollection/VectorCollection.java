package vectorcollection;

import com.sun.management.OperatingSystemMXBean;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.util.Collection;
import java.util.Random;
import java.util.Vector;


public class VectorCollection <T> {

    private final Collection collection;
    private  Random random;
   
    OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    
    public VectorCollection() {
        collection = new Vector<>();
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
       public double getUsedCPU() {
    	return operatingSystemMXBean.getProcessCpuLoad();
    }
    
    public double getUsedMemory(long mem0, long mem1) {
        return (mem1 - mem0)/(1024.0*1024.0);
    }
    
    public void writeToFile(String fileName,VectorCollection<T> collection, double value) {
               try (PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, true))) {
                pw.println(value);
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
