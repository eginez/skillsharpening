package org.eginez;
import java.util.*;

public class Set8 {
    public static class Range {
        int max;
        int min;

        public Range(int min, int max) {
            this.max = max;
            this.min = min;
        }

        public boolean overlaps(Range other) {
            return min < other.max;
        }

        public String toString() {
            return String.format("(%d, %d)", min, max);
        }
    }

    public static List<Range> rangeWorkout(List<Range> list) {
        list.sort(Comparator.comparingInt((Range r) -> r.min).thenComparingInt((Range r) -> r.max));
        List<Range> sol = new ArrayList<>();
        for(Range r : list) {
            if(sol.size() <= 0) {
                sol.add(r);
                continue;
            }

            Range last = sol.get(sol.size() - 1);
            if(r.overlaps(last)){
                sol.remove(sol.size() - 1);
                Range merged = new Range(Math.min(r.min, last.min), Math.max(r.max, last.max));
                sol.add(merged);
            } else {
                sol.add(r);
            }
        }
        return sol;
    }


    public static int eraseOverlapIntervals(int[][] intervals) {
        List<Range> all = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            all.add(new Range(intervals[i][0], intervals[i][1]));
        }

        all.sort(Comparator
                .comparingInt((Range r) -> r.min)
                .thenComparingInt((Range r) -> r.max));

        List<Range> sol = new ArrayList<>();
        for(Range r : all) {
            if (sol.size() == 0) {
                sol.add(r);
                continue;
            }
            Range last = sol.get(sol.size() - 1);
            if (r.overlaps(last)) {
                //remove the one with the lesser max
                if (r.max < last.max) {
                    sol.remove(sol.size() - 1);
                    sol.add(r);
                }
            } else {
                sol.add(r);
            }
        }
        return all.size() - sol.size();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //re-orders elements from linked list alternating the top and the tail
    public void reorderList(ListNode head) {
        //validate input
        if(head == null) {
            return;
        }
        ListNode node = head;
        Stack<ListNode> stack = new Stack<>();
        int size = 0;
        while( node != null) {
            stack.push(node);
            node = node.next;
            size++;
        }

        if(size <= 1) {
            return;
        }

        int count = 0;
        ListNode top = head;
        node = null;

        while (count < size) {
            if (count == 0) {
                node = head;
                top = head.next;
                count++;
                continue;
            }

            if (count % 2 == 0) {
                node.next = top;
                top = top.next;
            } else {
                node.next = stack.pop();
            }
            count++;
            node = node.next;
        }
        node.next= null;
    }

    public static List<Integer> shuffle(List<Integer> list) {
        List<Integer> shuffled = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(list);
        int rIndex = 0;
        Random rand = new Random();
        while(!temp.isEmpty()) {
            rIndex = rand.nextInt(temp.size()) ;
            Integer picked = temp.remove(rIndex);
            shuffled.add(picked);
        }
        return shuffled;
    }


    public static class LRUNode {
        LRUNode next;
        LRUNode previous;
        int val;
        int key;

        LRUNode(int key, int val) {
            this.val = val;
            this.key = val;
        }
    }

    public static class LRUList {
        private LRUNode head;
        private LRUNode tail;

        public LRUList() { }

        public void push(LRUNode node) {
            assert node != null;
           node.next = head;
           node.previous = null;

           if (head == null) {
               tail = node;
           } else {
               head.previous = node;
           }
           head = node;
        }

        public LRUNode delete(LRUNode node) {
            assert node != null;
            LRUNode next = node.next;
            LRUNode prev = node.previous;

            if (prev != null)
                prev.next = next;
            else {
                //the head
                head = next;
                if (head != null) {
                    head.previous = null;
                }
            }
            if (next != null)
                next.previous = prev;
            else {
                //the tail
                tail = prev;
                if (tail != null) {
                    tail.next = null;
                }
            }

            return node;
        }

        public LRUNode popTail() {
            return delete(tail);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(LRUNode node = head; node != null; node = node.next) {
                sb.append(node.val);
                sb.append("->");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static class Cache {
        private final LRUList list;
        private final Map<Integer, LRUNode> map;
        private final int capacity;

        public Cache(int capacity) {
            this.capacity = capacity;
            list = new LRUList();
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            if(!map.containsKey(key)) {
                throw new IllegalArgumentException("cache miss on" + key);
            }

            LRUNode node = map.get(key);
            list.delete(node);
            list.push(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (map.size() >= capacity)  {
               LRUNode evicted = list.popTail();
               map.remove(evicted.key);
            }

            LRUNode newNode = new LRUNode(key, value);
            map.put(key, newNode);
            list.push(newNode);
        }

        public boolean containsKey(int key) {
            return map.containsKey(key);
        }

        public String toString() {
            return "Map = " + map + "\n" +
                    "List=" + list;
        }
    }

}
