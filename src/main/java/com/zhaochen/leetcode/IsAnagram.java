package com.zhaochen.leetcode;

import java.util.*;

public class IsAnagram {
    public static void main(String[] args) {
        String[]  strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Set<Integer> travled = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for(int i = 0;i<strs.length;i++){
            if(travled.contains(i)){
                continue;
            }
            travled.add(i);
            List<String> cur = new ArrayList<>();
            cur.add(strs[i]);
            for(int j = i+1;j < strs.length;j++){
                if(isAnagram(strs[i],strs[j])){
                    cur.add(strs[j]);
                    travled.add(j);
                }
            }
            res.add(cur);
        }
        return res;
    }

    public static boolean isAnagram(String s1,String s2){
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i = 0;i < s1.length();i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }
        for(int i = 0;i < s2.length();i++){
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
        }
        for(Character ch : map1.keySet()){
            if(map1.get(ch) != map2.get(ch)){
                return false;
            }
        }
        for(Character ch : map2.keySet()){
            if(map2.get(ch) != map1.get(ch)){
                return false;
            }
        }
        return true;
    }

}
