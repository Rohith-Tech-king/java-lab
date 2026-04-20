public class CountThreads { 
    public static void main(String[] args) { 
        System.out.println("--- Starting Concurrent Count ---\n"); 
 
        Thread t1 = new Thread(new ILoop()); 
        Thread t2 = new Thread(new JLoop()); 
 
        t1.start(); 
        t2.start(); 
 
        try { 
            t1.join(); 
            t2.join(); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
 
        System.out.println("\n--- Both threads finished counting! ---"); 
    } 
} 
 
 
