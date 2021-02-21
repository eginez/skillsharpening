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

}
