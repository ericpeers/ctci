package net.mtnboy.PrioQueue;
import java.util.Vector;


public class PriorityQueue<TPayloadType> {

    public enum Priority {
        LOW(1),
        MEDIUM(2),
        HIGH(10);
        int prio;
        Priority(int p) {
            prio = p;
        }
        public int getValue() {
            return prio;
        }
    }

    ;

    public class Tuple {
        Priority priority;
        TPayloadType payload;

        public Tuple(Priority priority, TPayloadType payload) {
            this.priority = priority;
            this.payload = payload;
        }
    }

    protected Vector<Tuple> queue;
    protected int maxEls;

    public PriorityQueue(int maxEls) {
        this.maxEls = maxEls;
        this.queue = new Vector<Tuple>(maxEls);
    }

    public boolean Insert(Priority p, TPayloadType pl) {
        if (queue.size() == maxEls) return false;
        Tuple t = new Tuple(p, pl);

        boolean inserted = false;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).priority.getValue() < p.getValue()) {
                queue.add(i, t);
                inserted = true;
                break;
            }
        }
        if (!inserted) queue.add(t);
        return true;
    }

    public TPayloadType getNext() {
        if (queue.size() == 0) return null;
        TPayloadType pl = queue.get(0).payload;
        queue.remove(0);
        return pl;
    }
}