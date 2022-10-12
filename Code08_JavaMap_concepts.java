import java.util.HashMap;
import java.util.TreeMap;

/**
 * 哈希表（HashMap）与有序表（TreeMap）的一些基本概念
 * 哈希表：里面的key可以是基本类型也可以是自定义的类型，key是传递的是值而不是地址引用，时间复杂度是O(1)；
 * 有序表：里面的key（是有序的）可以是基本类型也可以是自定义的类型，但使用自定义类型时需进行改造(要在创建的时候指定比较的方法)，
 * 不能直接使用，时间复杂度是O(logN)；
 */

public class Code08_JavaMap_concepts {
    public static void main(String[] args) {
        // 哈希表（HashMap）
        HashMap<String, String> hashMap1 = new HashMap<>();

        hashMap1.put("001", "我的值是001");
        hashMap1.put("002", "我的值是002");

        System.out.println(hashMap1.containsKey("001"));
        System.out.println(hashMap1.get("001"));

        HashMap<Integer, String> hashMap2 = new HashMap<>();
        hashMap2.put(1, "我的值是001");
        hashMap2.put(2, "我的值是002");

        System.out.println(hashMap2.containsKey(1));
        System.out.println(hashMap2.get(1));

        // 有序表（TreeMap）
        TreeMap<String, String> treeMap1 = new TreeMap<>();
        treeMap1.put("001", "我的值是001");
        treeMap1.put("002", "我的值是002");
        treeMap1.put("003", "我的值是003");
        treeMap1.put("006", "我的值是006");
        treeMap1.put("009", "我的值是009");
        treeMap1.put("010", "我的值是010");
        System.out.println(treeMap1.containsKey("001"));
        System.out.println(treeMap1.get("001"));

        // 返回有序表中和第一个key的值
        System.out.println(treeMap1.firstKey());
        // 返回有序表中和最后一个key的值
        System.out.println(treeMap1.lastKey());
        // 返回<="003"的离它最近的值，
        System.out.println(treeMap1.floorKey("003"));
        // 返回>="005"的离它最近的值，
        System.out.println(treeMap1.ceilingKey("005"));

    }
}
