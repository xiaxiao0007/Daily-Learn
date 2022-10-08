package Javase.Day2022110;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
* HashMap集合
*   1.HashMap集合底层是哈希表/散列表的数据结构
*   2.哈希表是怎样的数据结构?
*       哈希表是一个数组和单列表的结合体
*       数组:在查询方面效率很高，随机增删方面效率很低。
*       单向链表:在随机增删方面效率很高，在查询方面效率很低。
*       哈希表将以上的两种数据结构融合在一起，充分发挥他们各自的优点
*   3.最主要掌握的是:
*       map.put(k.v)
*       v = map.put
*       以上两个方法的实现原理，是必须掌握的
*   5.HashMap集合key的部分特点:无序，不可重复
*       为什么无序? 因为不一定挂到那个单链表上。
*       不可重复是怎么保证的呢? equals方法保证HashMap集合的key不可重复。如果key重复了，value会覆盖
*   6.放在HashMap集合key部分的元素其实就是放到HashSet集合中了，所以HashSet集合中的元素也需要同时重写
*     hashCode()+equals()方法
*   7.哈希表HashMap使用不当时无法发挥性能！
*       假设将所有的hashCode()方法返回值固定为某个值，那么会导致底层哈希表变成了纯单向链表。散列不均匀
*   8.hash值时底层调用k的hashCode()方法得出来的
* 【重点】放在HashMap集合key部分得元素，以及放在HashSet集合中的元素，需要同时重写hashCode()和equals()方法
*   9.HashMap集合的默认初始化容量是16，默认加载因子是0.75
*       这个默认加载因子是HashMap集合底层数组的容量到达75%的时候，数组开始扩容。
*       【重点】记住:HashMap集合初始化容量必须是2的倍数，这个是官方推荐的，这是因为达到了散列均匀的一个方式，
*                  为了提高HashMap集合的存取效率，所以必须的
* */
/*
注意：如果一个类的equals方法重写了，那么hashCode()方法必须重写，并且equals方法返回如果是true，hashCode()
     方法返回的值必须一样。
     equals方法返回true表示两个对象相同，在同一个单链表上比较，那么对于同一个单链表上的节点来说，他们的哈希值
     都是相同的，所哟hashCode()方法的返回值相同
hashCode()方法和equals()方法不用研究了，直接使用IDEA工具生成，但是这两个方法需要同时生成
终极结论：
    放在HashMap集合key部分得元素，以及放在HashSet集合中的元素，需要同时重写hashCode()和equals()方法
* */
/*
1.Hashtable集合中的中key和value中的值不可以为null，HashMap集合中的key和value中的值可以为空
2.Hashtable方法都带有synchronized:线程安全的。线程安全有其它的方案，这个Hashtable对线程处理导致
  效率较低，使用较少了。
3.Hashtable和HashMap一样，底层都是哈希表数据结构。Hashtable的初始化容量是11，默认加载因子是：0.75f
  Hashtable的扩容量是：原容量*2+1
* */
public class HashMapTest01 {
    public static void main(String[] args) {
        //测试HashMap集合key部分元素得特点
        //Integer是key，它的hashCode和equals都重写了
        /*Map<Integer,String> map = new HashMap<>();
        map.put(1111,"张三");
        map.put(2222,"李四");
        map.put(3333,"王二");
        map.put(2222,"麻子");

        System.out.println(map.size());

        //遍历集合
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        for (Map.Entry<Integer,String> node:set){
            System.out.println(node.getKey()+"="+node.getValue());
        }*/

        Student s1 = new Student("张三");
        Student s2 = new Student("张三");

        System.out.println(s1.equals(s2));

        Map<Integer,Student> map = new HashMap<>();
        map.put(1,s1);
        map.put(2,s2);
        System.out.println(map.size());

    }
}

class Student{
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}