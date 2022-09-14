package wipro;

import java.util.*;

public class QIIBM {

    public static List<String> top_t_words(List<String> words, int t) {
        Map<String,Integer> hm=new HashMap<>();

        for(String x: words) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq=new
                PriorityQueue<>((a, b)->a.getValue()==b.getValue() ?
                a.getKey().compareTo(b.getKey()) :b.getValue()-a.getValue());

        for(Map.Entry<String,Integer> smap:hm.entrySet())
        {
            pq.add(smap);
        }
        ArrayList<String> list=new ArrayList<>();
        while(t-->0)
        {
            Map.Entry<String,Integer> smap=pq.poll();
            list.add(smap.getKey());
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("i");
        l.add("love");
        l.add("i");
        l.add("love");
        l.add("ibm");

        List<String> lres  = top_t_words(l,2);
        for (String s :
                lres) {
            System.out.println(s);
        }

    }

}
