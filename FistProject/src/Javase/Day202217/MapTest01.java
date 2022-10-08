package Javase.Day202217;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
java,util.Map接口中常用的方法
    1.Map和Collection没有继承关系
    2.Map集合以Key和Value的方式存储数据：键值对
        key和value都是引用数据类型。
        key和value都是存储对象的内存地址
        key起到主导地位，value是key的一个附属品
    3.Map接口中常用的类型
        V put(k key,V value) 向Map集合中添加键值对
        V get(Object key) 通过key获取value
        void clear() 清空Map集合
        boolean containsKey(Object key) 判断Map中是否包含某个key
        boolean containsValue(Object value) 判断Map中是否包含某个value
        boolean isEmpty() 判断Map集合中元素个数是否为0
        Set<K> keySet() 获取Map集合所有的key(所有的键是一个set集合)
        V remove(Object key) 通过key删除键对应的值
        int size() 获取Map集合中键值对的个数
        Collection<V> values() 获取Map集合中所以的value，返回一个Collection
        Set<Map.Entry<K,V>> entrySet() 将Map集合转换成Set集合
* */
public class MapTest01 {
    public static void main(String[] args) {
        //创建Map集合
        Map<Integer,String> map = new HashMap<>();
        //向Map集合添加键值对
        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王二");
        //通过key获取value
        String value = map.get(1);
        System.out.println(value);
        //获取键值对的数量
        System.out.println(map.size());
        //通过key删除key的value
        map.remove(1);
        System.out.println(map.size());
        //判断是否包含某个key
        //contains()方法底层调用的都是equals进行对比，所以自定义的类型要重写equals方法
        System.out.println(map.containsKey(1));
        //判断是否包含某个value
        System.out.println(map.containsValue("李四"));
        //获取所有value
        Collection<String> values = map.values();
        for (String s:values){
            System.out.println(s);
        }
        //清空map集合
        map.clear();
        System.out.println(map.size());

    }
}
