package org.eginez;

import java.util.*;

public class Problem2 {
    public static class Node {
        String word;
        List<Node> neighbors;

        public Node(String word) {
            this.word = word;
            neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node n) {
           if (Node.diffByOne(n.word, word)) {
               this.neighbors.add(n);
            }
        }

        public static boolean diffByOne(String s1, String s2) {
           if (s1.length() != s2.length()) return false;
           int numDiff = 0;
           for(int i=0; i < s1.length(); i++) {
               if (s1.charAt(i) != s2.charAt(i)) {
                   numDiff++;
               }
               if (numDiff > 1) {
                   return false;
               }
           }
           return true;
        }
    }

    public static class WordGraph {
        List<Node> graph = new ArrayList<>();

        public WordGraph(List<String> dictionary) {
            for (String s : dictionary) {
               graph.add(new Node(s));
            }
            //Link words
            for(int i = 0; i < graph.size(); i++){
                Node n1 = graph.get(i);
                for(int j = 0; j < graph.size(); j++) {
                    Node n2 = graph.get(j);
                    n1.addNeighbor(n2);
                }
            }
        }

        public boolean canXform(String start, String end) {
            boolean foundStart = false;
            Node startNode = null;
            for (Node node : graph) {
                if(Node.diffByOne(node.word, start)) {
                    foundStart = true;
                    startNode = node;
                    break;
                }
            }

            if (!foundStart) {
                return false;
            }
            return bfs(startNode, end);
        }

        private boolean bfs(Node startNode, String target) {
            if(startNode.word.equals(target)) {
                return true;
            }
            Queue<Node> toSearch = new LinkedList<>();
            Set<String> seen = new HashSet<>();
            toSearch.addAll(startNode.neighbors);
            while(!toSearch.isEmpty()) {
                Node current = toSearch.poll();
                if(seen.contains(current.word)) {
                    continue;
                }

                seen.add(current.word);
                if (Node.diffByOne(current.word, target)) {
                    return true;
                } else {
                    toSearch.addAll(current.neighbors);
                }
            }
            return false;
        }
    }

}
