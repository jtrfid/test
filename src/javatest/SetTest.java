package javatest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import de.uni.freiburg.iig.telematik.sepia.petrinet.abstr.AbstractPNNode;
import de.uni.freiburg.iig.telematik.sepia.petrinet.pt.PTPlace;
import edu.xidian.petrinet.S2PR;
import edu.xidian.petrinet.S3PR;

public class SetTest {
	// List允许有重复元素，Set中元素唯一
	//@Test
	public void test1() {
		List<Integer> list1 = new ArrayList<Integer>(); // 允许有重复元素
		List<Integer> list2 = new ArrayList<Integer>();

		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(2);
		list2.add(1);
		list2.add(2);
		list2.add(4);
		list2.add(5);
		System.out.println("list1: " + list1); // list1: [1, 2, 3, 2]
		System.out.println("list2: " + list2); // list2: [1, 2, 4, 5]

		System.out.println("并集");
		// 并集, list2追加到list1的末尾，
		// Appends all of the elements in the specified collection to the end of
		// this list, in the order that they are returned by the specified
		// collection's iterator (optional operation).
		list1.addAll(list2);
		System.out.println("list1（并集）: " + list1); // list1（并集）: [1, 2, 3, 2, 1,
													// 2, 4, 5]
		System.out.println("list2: " + list2); // list2: [1, 2, 4, 5]

		// 包含关系
		System.out.println("list1包含整数2：" + list1.contains(2)); // true
		System.out.println("list1包含整数6：" + list1.contains(6)); // false
		System.out.println("list1包含整数list2：" + list1.containsAll(list2)); // true

		System.out.println("remove(Object o), remove(int index)：");
		// remove(Object o), remove(int index)
		Integer r = 2;
		list1.remove(r); // remove(Object o), remove第一次碰到的元素
		System.out.println("list1: " + list1); // list1: [1, 3, 2, 1, 2, 4, 5]
		list1.remove(3); // remove(int index),remove下标为3的元素
		System.out.println("list1: " + list1); // list1: [1, 3, 2, 2, 4, 5]

		// 交集
		System.out.println("交集");
		list1.clear();
		list2.clear();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(2);
		list2.add(1);
		list2.add(2);
		list2.add(4);
		list2.add(5);
		System.out.println("list1: " + list1); // list1: [1, 2, 3, 2]
		System.out.println("list2: " + list2); // list2: [1, 2, 4, 5]
		list1.retainAll(list2);
		System.out.println("list1: " + list1); // list1: [1, 2, 2]
		System.out.println("list2: " + list2); // list2: [1, 2, 4, 5]

		// 差集
		System.out.println("差集");
		list1.clear();
		list2.clear();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(2);
		list2.add(1);
		list2.add(2);
		list2.add(4);
		list2.add(5);
		System.out.println("list1: " + list1); // list1: [1, 2, 3, 2]
		System.out.println("list2: " + list2); // list2: [1, 2, 4, 5]
		list1.removeAll(list2); // list1中减去list1和list2的交集部分，保留仅属于list1，而不属于list2的元素
		System.out.println("list1: " + list1); // list1: [3], 3属于list1,不属于list2
		System.out.println("list2: " + list2); // list2: [1, 2, 4, 5]

		// java.util.Collections
		// This class consists exclusively of static methods that operate on or
		// return collections.
		// It contains polymorphic algorithms that operate on collections,
		// "wrappers",
		// which return a new collection backed by a specified collection, and a
		// few other odds and ends.
		Collections.reverse(list2);
		System.out.println("reverse list2: " + list2); // reverse list2: [5, 4,
														// 2, 1]

		///////////////// Set中无重复元素,重复元素添加不进去，但是List中可以有重复元素
		// Clollection是集合类的根interface，尽量用它说明集合的类型，如函数参数，或变量
		Collection<String> c1 = new HashSet<>(); // 集合变量类型是Collection，实例化可以是ArrayList，HashSet
		// Set<String> c1 = new HashSet<>(); // 等效，Collection is the root
		// interface in the collection hierarchy
		System.out.println("add(\"a\"): " + c1.add("a")); // true
		System.out.println("add(\"b\"): " + c1.add("b")); // true
		System.out.println("add(\"a\"): " + c1.add("a")); // false
		System.out.println("collection: " + c1); // collection: [a, b]

		// 排序Collections需要List<>参数，另：举例比较函数
		List<String> l = new ArrayList<>(c1);
		Collections.sort(l, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareToIgnoreCase(o1); // 相当于反序比较
			}
		});
		System.out.println("sort: " + l); // sort: [b, a]
	}
	
	////////////////////// Error retainAll()
	//@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setTest1() {
		S2PR s2pr = new S2PR("s2pr_test",2,1,4);
		System.out.println(s2pr);
		
		Collection<AbstractPNNode> temp1 = new HashSet<>();
		Collection<AbstractPNNode> temp2 = new HashSet<>();
		System.out.println("PR:"+s2pr.getPR());
		for (PTPlace p : s2pr.getPA()) {
			for (AbstractPNNode t1 : p.getParents()) {
					temp1.clear(); temp2.clear();
					temp1.addAll(t1.getParents());
					System.out.println("---temp1:"+temp1);
					// temp2.addAll(s2pr.getPR());
					// temp1.retainAll(temp2); // 正确        // temp1和temp2元素类型必须相同
					temp1.retainAll(s2pr.getPR()); // 错误，temp1与s2pr.getPR()元素类型不同
					System.out.println("---temp1:"+temp1);
			}
		}
	}
	
    //////////////////////OK retainAll()
	// 集合运算，temp1.retainAll(temp2); temp1和temp2元素类型必须相同
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setTest2() {
		S2PR s2pr = new S2PR("s2pr_test",2,1,4);
		System.out.println(s2pr);
		
		Collection<AbstractPNNode> temp1 = new HashSet<>();
		Collection<AbstractPNNode> temp2 = new HashSet<>();
		System.out.println("PR:"+s2pr.getPR());
		for (PTPlace p : s2pr.getPA()) {
			for (AbstractPNNode t1 : p.getParents()) {
				temp1.clear();
				temp2.clear();
				temp1.addAll(t1.getParents());
				System.out.println("---temp1:" + temp1);

				temp2.addAll(s2pr.getPR());
				temp1.retainAll(temp2); // 正确 // temp1和temp2元素类型必须相同
				/// temp1.retainAll(s2pr.getPR()); //
				/// 错误，temp1与s2pr.getPR()元素类型不同
				System.out.println("---temp1:" + temp1);
			}
		}
		
		System.out.println("---------------");
		System.out.println("PA"+s2pr.getPA());
		System.out.println("PR:"+s2pr.getPR());
		temp1.clear(); temp2.clear();
		temp1.addAll(s2pr.getPA());
		temp1.add(s2pr.getPlace("p4"));
		System.out.println("---temp1:"+temp1);
		temp1.retainAll(s2pr.getPR()); // 交集, 错误
		System.out.println("---temp1:"+temp1);
		
		System.out.println("---------------");
		temp1.clear(); temp2.clear();
		temp1.addAll(s2pr.getPA());
		temp1.add(s2pr.getPlace("p4"));
		System.out.println("---temp1:"+temp1);
		temp2.addAll(s2pr.getPR());
		temp1.retainAll(temp2);  // 正确
		//temp1.retainAll(s2pr.getPR()); // 交集, 错误
		System.out.println("---temp1:"+temp1);
		
		System.out.println("==============");
		temp1.clear(); temp2.clear();
		temp1.addAll(s2pr.getPA());
		temp1.add(s2pr.getPlace("p4"));
		System.out.println("---temp1:"+temp1);
		temp2.addAll(s2pr.getPR());
		//temp1.removeAll(temp2);  // 正确
		temp1.removeAll(s2pr.getPR()); // 差集, 结果也是正确的，似乎差集集合元素的类型可以不一致
		System.out.println("---temp1:"+temp1);
	}
	
	/**
	 * test set, ==, equals
	 * Set中集合运算的基础：equals判断是否两个元素相同，不是通过"=="判断的
	 */
	@SuppressWarnings("rawtypes")
	//@Test
	public void testSet() {
		S2PR s2pr = new S2PR();
		s2pr.addPlace("p1");
		s2pr.addPlace("p2");
		s2pr.addPlace("p3");
		S3PR s3pr = new S3PR();
		s3pr.addPlace("p3");
		s3pr.addPlace("p4");
		
		Collection<PTPlace> places = new HashSet<>();
		// places.add(s3pr.getPlace("p3")))失败，
		// 因为在此之前,有places.add(s2pr.getPlace("p3")),
		// places通过equals判断，已经有"p3"对应的place，因此不用增加了。
		System.out.println("add ok = " + 
		        places.add(s2pr.getPlace("p1")) + "," +
				places.add(s2pr.getPlace("p3")) + "," + 
		        places.add(s3pr.getPlace("p3"))); // add ok = true,true,false
		System.out.println("places: " + places);  // places: [p1[p1], p3[p3]]
		boolean b1 = (s2pr.getPlace("p3") == s3pr.getPlace("p3")); // flase
		boolean b2 = (s2pr.getPlace("p3").equals(s3pr.getPlace("p3"))); // true
		System.out.println("两个p3  ！==,但是equals： " + b1 + "," + b2);
		
		Collection<PTPlace> ps1 = new HashSet<>();
		Collection<PTPlace> ps2 = new HashSet<>();
		s2pr.setName("net1");
		s3pr.setName("net2");
		ps1.add(s2pr.getPlace("p3"));
		ps2.add(s3pr.getPlace("p3"));
		ps1.retainAll(ps2); 
		System.out.println("虽然不是同一个place,但是他们的交集相同，因为equals相等，ps1=" + ps1);
		
		//Collection<AbstractPNNode> ps11 = new HashSet<>();
		//Collection<PTPlace> ps22 = new HashSet<>();
		Set<AbstractPNNode> ps11 = new HashSet<>();
		Set<PTPlace> ps22 = new HashSet<>();
		ps11.add(s2pr.getPlace("p3"));
		ps22.add(s3pr.getPlace("p3"));
		ps11.retainAll(ps22); 
		System.out.println("虽然不是同一个place,但是他们的交集相同，因为equals相等，ps11=" + ps11);
	}
}
