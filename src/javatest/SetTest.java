package javatest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class SetTest {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();  // 允许有重复元素
		List<Integer> list2 = new ArrayList<Integer>();
		
        list1.add(1); list1.add(2); list1.add(3); list1.add(2);
        list2.add(1); list2.add(2); list2.add(4); list2.add(5);
        System.out.println("list1: "+list1);  // list1: [1, 2, 3, 2]
        System.out.println("list2: "+list2);  // list2: [1, 2, 4, 5]
        
        System.out.println("并集");
        // 并集, list2追加到list1的末尾，
        // Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator (optional operation). 
        list1.addAll(list2); 
        System.out.println("list1（并集）: "+list1); // list1（并集）: [1, 2, 3, 2, 1, 2, 4, 5]
        System.out.println("list2: "+list2);      // list2: [1, 2, 4, 5]
        
        // 包含关系
        System.out.println("list1包含整数2："+list1.contains(2));  // true
        System.out.println("list1包含整数6："+list1.contains(6));  // false
        System.out.println("list1包含整数list2："+list1.containsAll(list2)); // true
        
        System.out.println("remove(Object o), remove(int index)：");
        // remove(Object o), remove(int index)
        Integer r = 2;
        list1.remove(r);  // remove(Object o), remove第一次碰到的元素 
        System.out.println("list1: "+list1); // list1: [1, 3, 2, 1, 2, 4, 5]
        list1.remove(3); // remove(int index),remove下标为3的元素
        System.out.println("list1: "+list1); // list1: [1, 3, 2, 2, 4, 5]
        
        // 交集
        System.out.println("交集");
        list1.clear(); list2.clear();
        list1.add(1); list1.add(2); list1.add(3); list1.add(2);
        list2.add(1); list2.add(2); list2.add(4); list2.add(5);
        System.out.println("list1: "+list1);  // list1: [1, 2, 3, 2]
        System.out.println("list2: "+list2);  // list2: [1, 2, 4, 5]
        list1.retainAll(list2);
        System.out.println("list1: "+list1);  // list1: [1, 2, 2]
        System.out.println("list2: "+list2);  // list2: [1, 2, 4, 5]
        
        // 差集
        System.out.println("差集");
        list1.clear(); list2.clear();
        list1.add(1); list1.add(2); list1.add(3); list1.add(2);
        list2.add(1); list2.add(2); list2.add(4); list2.add(5);
        System.out.println("list1: "+list1);  // list1: [1, 2, 3, 2]
        System.out.println("list2: "+list2);  // list2: [1, 2, 4, 5]
        list1.removeAll(list2); // list1中减去list1和list2的交集部分，保留仅属于list1，而不属于list2的元素
        System.out.println("list1: "+list1);  // list1: [3], 3属于list1,不属于list2
        System.out.println("list2: "+list2);  // list2: [1, 2, 4, 5]
        

        // java.util.Collections
        // This class consists exclusively of static methods that operate on or return collections. 
        // It contains polymorphic algorithms that operate on collections, "wrappers", 
        // which return a new collection backed by a specified collection, and a few other odds and ends. 
        Collections.reverse(list2);
        System.out.println("reverse list2: "+ list2);  // reverse list2: [5, 4, 2, 1]
        
        
        ///////////////// Set中无重复元素,重复元素添加不进去，但是List中可以有重复元素
        // Clollection是集合类的根interface，尽量用它说明集合的类型，如函数参数，或变量
        Collection<String> c1 = new HashSet<>(); // 集合变量类型是Collection，实例化可以是ArrayList，HashSet
        // Set<String> c1 = new HashSet<>();  // 等效，Collection is the root interface in the collection hierarchy
        System.out.println("add(\"a\"): " + c1.add("a")); // true
        System.out.println("add(\"b\"): " + c1.add("b")); // true
        System.out.println("add(\"a\"): " + c1.add("a")); // false
        System.out.println("collection: " + c1); // collection: [a, b]
        
        // 排序Collections需要List<>参数，另：举例比较函数
        List<String> l = new ArrayList<>(c1);
        Collections.sort(l, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o2.compareToIgnoreCase(o1);  // 相当于反序比较
			}});
        System.out.println("sort: " + l); // sort: [b, a]

	}

}
