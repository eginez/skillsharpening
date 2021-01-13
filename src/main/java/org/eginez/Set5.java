package org.eginez;

import java.util.*;

public class Set5 {
    public static String longPalindrome(String s) {
        HashMap<String, String> cache = new HashMap<>();
        // The dynamic p = P(i,j)  P(i+1, j -1) and S[i] == S[j]
        Set<String> res = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            res.add(longPalHelp(s.substring(i), cache));
        }
        return res.stream().max(Comparator.comparing(String::length)).get();
    }

    public static String longPalHelp(String s, Map<String,String> cache) {
        if (cache.containsKey(s)) {
            System.out.println("hitting cache");
            return cache.get(s);
        }

        if (s.length() == 1){
            return s;
        }

        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1))
                return s;
            else
                return "";
        }

        String pal = longPalHelp(s.substring(1, s.length() -1), cache);
        if (s.charAt(0) == s.charAt(s.length() - 1)){
             pal = s.charAt(0) + pal + s.charAt(0);
        }
        cache.put(s, pal);
        return pal;
    }
}
