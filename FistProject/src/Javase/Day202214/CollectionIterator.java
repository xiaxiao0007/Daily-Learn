package Javase.Day202214;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
* 关于集合遍历/迭代专题【很重要】，是在Collection接口中重要的方法
* 注意：迭代器ite最初并没有指向第一个元素，它是存在元素之间
* 注意：集合结构只要发生改变，迭代器必须重新获取
* 当集合结构发生了改变，迭代器没有重新获取时，调用next()方法时：java.util.ConcurrentModificationException
* 重点：在迭代集合元素的过程中，不能调用集合对象的remove方法，删除元素：会出现异常
* */
public class CollectionIterator {
    public static void main(String[] args) {
        /*
        * 注意：以下讲解的遍历方式/迭代方式，是所有Collection通用的一种方式
        * 在Map集合中不能用，在所有Collection以及子类中使用*/
        //创建对象
        Collection c = new HashSet();//后面是的元素无所谓，主要看前面的Collection接口
        c.add(1);
        c.add(2);
        c.add("name");
        c.add(new Object());
        //对集合Collection进行迭代
        //第一步：获取集合对象的迭代器对象Iterator
        Iterator ite = c.iterator();//没有明确迭代器的泛型参数
        //第二步：通过以上获取的迭代器对象开是迭代/遍历
        /*
        * 以下两个方法是迭代器对象Iterator中的方法
        * boolean hasNext() 如果仍有元素可以迭代，则返回true
        * Object next() 返回迭代的下一个元素
        * void remove() 删除上次访问。这个方法必须紧跟在访问一个元素之后执行。
        * */
        boolean hasnext = ite.hasNext();
        if(hasnext){
            //不管你当初存进什么，取出来统一都是Object
            Object obj = ite.next();//如果明确了迭代器的泛型参数，取出来的元素类型就是泛型参数类型
            //c.remove(2);调用集合c中的remove()方法
            ite.remove();//调用迭代器remove()方法,迭代器去删除时，会自动更新迭代器，并且更新集合(删除集合中的元素)
            System.out.println(obj);
        }
    }
}
