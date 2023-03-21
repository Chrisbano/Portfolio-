package cs280a1.hw2;

import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

public class Memory{
    public static volatile int vol = 0;
    double avgVolTotal = 0.0;
    double avgTotal = 0.0;

    public static long noVol(int size, int experiments, int seed) {
        Integer runningTotal = 0;
        long start = System.nanoTime();
         
        for(int i = experiments; i > 0; i--) {
            for(int k = size; k > 0; k--) {
                if(k%2 == 0) runningTotal -= k;
                else runningTotal += k;
            }
        }
        long avgTotal = runningTotal/experiments;
        long end = System.nanoTime();
        System.out.printf("Regular: %.5f seconds\n", ((end-start)/1000000000.0));
        return avgTotal;
    }
    public static long vol(int size, int experiments, int seed) {
        Integer runningTotal = 0;
        long start = System.nanoTime();
        
         
        for(int i = experiments; i > 0; i--) {
            for(vol = size; vol > 0; vol--) {
                if(vol%2 == 0) runningTotal -= vol;
                else runningTotal += vol;
            }
        }
        long avgTotal = runningTotal/experiments;
        long end = System.nanoTime();
        System.out.printf("Volatile: %.5f seconds\n", ((end-start)/1000000000.0));
        return avgTotal;
        
    }

    public static void taskOne(String[] args){
        int size = Integer.parseInt(args[0]);
        int experiments = Integer.parseInt(args[1]);
        int seed = Integer.parseInt(args[2]);

        
        //vol(size, experiments, seed);
        //noVol(size, experiments, seed);
        System.out.println("Task 1");
        long avgTotal = noVol(size, experiments, seed);
        long avgVolTotal =  vol(size, experiments, seed);
        System.out.printf("Avg regular sum: %.2f\n",avgTotal * 1.0);
        System.out.printf("Avg volatile sum: %.2f\n", avgVolTotal * 1.0);
        //System.out.printf("Avg volatile sum: %.2f\n", avgVolTotal * 1.0);



        
    }

    public static void taskTwo(String[] args){
        Integer size = Integer.parseInt(args[0]);
        Integer experiments = Integer.parseInt(args[1]);
        Integer seed = Integer.parseInt(args[2]);
        Random rand = new Random(seed);
        long firstTenRunningTimeTotal = 0;
        Integer firstTenSum = 0;
        Integer lastTen = size - rand.nextInt(size / 10);
        double lastTenTime = 0;
        double sum = 0;

 
        Integer[] arr = new Integer[size];

        for(int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt();
        }
        

        for(Integer i = 0; i < experiments; i++){
            for(Integer j = 0; j <= (arr.length * .10); j++){
                long start = System.nanoTime();
                firstTenSum = firstTenSum + arr[j];
                long end = System.nanoTime();
                
                firstTenRunningTimeTotal = firstTenRunningTimeTotal + (end - start);

                
            }
            long laststart = System.nanoTime();
            Integer temp = arr[lastTen];
            long lastend = System.nanoTime();
            lastTenTime = lastTenTime + (lastend - laststart);
    
        }

        
    
        

        for(Integer i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        double avgSum = sum / arr.length;
        
        double firstTenTimeAVG = firstTenRunningTimeTotal / (arr.length*.10);
        double lastTenAVG = lastTenTime / experiments;

        //Ouputs//
        System.out.println("\nTask 2");
        System.out.printf("Avg time to access known element: %.2f nanoseconds\n", firstTenTimeAVG);
        System.out.printf("Avg time to access random element: %.2f nanoseconds\n", lastTenAVG);
        System.out.printf("Sum: %.2f", (avgSum));
    }

    public static void taskThree(String[] args){
        Integer size = Integer.parseInt(args[0]);
        Integer experiments = Integer.parseInt(args[1]);
        Integer seed = Integer.parseInt(args[2]);
        Random rand = new Random(100);
        long start, end;
        double llTime = 0.0;
        double tsTime = 0.0;
        double avgLLTime = 0.0;
        double avgTSTime = 0.0;


        LinkedList<Integer> ll = new LinkedList<Integer>();
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for(Integer i = 0; i < size; i++){
            ll.add(i);
            ts.add(i);
        }
        for(int i = 0; i < experiments; i++){
            start = System.nanoTime();
            ll.contains(rand.nextInt());
            end = System.nanoTime();
            llTime = llTime + (end - start);
        }

        for(int i = 0; i < experiments; i++){
            start = System.nanoTime();
            ts.contains(rand.nextInt());
            end = System.nanoTime();
            tsTime = tsTime + (end - start);
        }
        
        avgLLTime = llTime / 100;
        avgTSTime = tsTime / 100;

        System.out.println("\n\nTask 3");
        System.out.printf("Avg time to find in set: %.2f nanoseconds\n", avgTSTime);
        System.out.printf("Avg time to find in list: %.2f nanoseconds\n", avgLLTime);


    }

    


    public static void main(String[] args){
        taskOne(args);
        taskTwo(args);
        taskThree(args);
        taskOne(args);
        taskTwo(args);
        taskThree(args);
        
    }

}