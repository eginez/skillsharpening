package org.eginez;

import java.util.*;

public class Problem3 {
    public static String longestSubSeq(String s1, String s2) {
        //1 for each char in s1 pick add it string
        //2 find the char in s2, mark the position
        //3 pick the next char on s1, if the char is found after the marked position added to the string
        //4 do this for all the chars  in s1 save the longest string.
        String response = "";
        Map<Character, List<Integer>> db = createDb(s2);
        System.out.println(db);
        for (int i = 0; i < s1.length(); i++) {
            StringBuilder acc = new StringBuilder();
            int start = 0;
            for (int j = i; j < s1.length(); j++) {
                char current = s1.charAt(j);
                //int fi = s2.indexOf(current, start);
                int fi = customIndexOf(db, current, start);
                if (fi >= 0) {
                    acc.append(current);
                    start = fi + 1;
                }
            }
            if (acc.length() > response.length()) {
                response = acc.toString();
            }
        }
        return response;
    }

    private static Map<Character, List<Integer>> createDb(String s2) {
        Map<Character, List<Integer>> db = new HashMap<>();
        for(int i = 0; i < s2.length(); i++) {
            List<Integer> positions;
            if (db.containsKey(s2.charAt(i))) {
               positions = db.get(s2.charAt(i));
           } else {
               positions = new ArrayList<>();
           }
            positions.add(i);
            db.put(s2.charAt(i), positions);
        }
        return db;
    }

    public static int customIndexOf(Map<Character, List<Integer>> letters, char c, int start) {
        if (letters.containsKey(c)) {
            List<Integer> positions = letters.get(c);
            Optional<Integer> first = positions.stream().filter(p -> p >= start).findFirst();
            return first.orElse(-1);
        }
        return -1;
    }
}
