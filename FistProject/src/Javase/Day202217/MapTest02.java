package Javase.Day202217;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
* 遍历Map集合
* */
/*
* Set<K> keySet() 获取Map集合所有的key(所有的键是一个set集合)
* Set<Map.Entry<K,V>> entrySet() 将Map集合转换成Set集合 将Map集合转换成Set集合
* */
public class MapTest02 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王二");
        map.put(4,"麻子");

        //第一种方式：获取所有的key，通过遍历key，来遍历value
        Set<Integer> keys = map.keySet();
        for(Integer s:keys){
            System.out.println(map.get(s));
        }

        //第二种方法：Set<Map.Entry<K,V>> entrySet() 将Map集合转换成Set集合
        Set<Map.Entry<Integer,String>> keyValue = map.entrySet();
        Iterator<Map.Entry<Integer,String>> it = keyValue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            Map.Entry<Integer,String> node = it.next();
            Integer key = node.getKey();
            String value = node.getValue();
            System.out.println(key + "="+value);
        }
        //foreach
        //这种方式效率较高，因为获取key和value都是直接从node对象中获取的属性值。
        //这种方式比较适合于大数据量
        for(Map.Entry<Integer,String> node: map.entrySet()){
            System.out.println(node.getKey()+"="+node.getValue());
        }
    }
}
