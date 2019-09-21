package tk.solidays.algorithm.leetcode;

import java.util.*;

public class LeetCode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            if (!map.containsKey(equation.get(0))) {
                map.put(equation.get(0), new HashMap<>());
            }
            map.get(equation.get(0)).put(equation.get(1), values[i]);
            if (!map.containsKey(equation.get(1))) {
                map.put(equation.get(1), new HashMap<>());
            }
            map.get(equation.get(1)).put(equation.get(0), 1 / values[i]);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (map.containsKey(query.get(0)) && map.containsKey(query.get(1))) {
                Set<String> set = new HashSet<>();
                set.add(query.get(0));
                boolean flag = true;
                while (flag){
                    Iterator<String> iterator = set.iterator();
                    while (iterator.hasNext()){
                        String s = iterator.next();
                        if(map.containsKey(s)){

                        }
                    }
                }
            } else ans[i] = -1.0;
        }
        return ans;
    }
}
