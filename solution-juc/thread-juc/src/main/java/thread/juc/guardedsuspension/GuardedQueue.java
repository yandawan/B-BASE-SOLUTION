package thread.juc.guardedsuspension;

import jdk.internal.org.objectweb.asm.TypeReference;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class GuardedQueue {

    private final Queue<Integer> sourceList;

    public GuardedQueue(){
        this.sourceList = new LinkedBlockingDeque<>();
    }

    public synchronized Integer get(){
        while (sourceList.isEmpty()){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return sourceList.peek();
    }

    public synchronized void put(Integer e){
        sourceList.add(e);
        notifyAll();
    }
}
