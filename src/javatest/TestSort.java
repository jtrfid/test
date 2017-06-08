package javatest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class TestSort {
	
	public class SortTest {
		private String name;
		public String getName() {return name;}
		
		public SortTest(String name) { this.name = name; }
		
		@Override
		public String toString() {
			return name;
		}
	}
	public class MyComparator implements Comparator<SortTest> {
		@Override
		public int compare(SortTest o1, SortTest o2) {
			String s1 = o1.getName();
			String s2 = o2.getName();
			int i1 = toInt(s1);
			int i2 = toInt(s2);
			if (i1 == 0 || i2 == 0) return s1.compareTo(s2);  // 按照字符串比较
			else return Integer.compare(i1, i2); // 按照字符串中的数字比较
		}
		
		/**
		 * '['以前的字符串转int，例如："p20[20]" ==> 20 
		 * @param s
		 * @return
		 */
		private int toInt(String s) {
			char c;
			StringBuilder str = new StringBuilder(); 
	        for(int i = 0; i<s.length(); i++){
	        	c = s.charAt(i);
	        	if (c == '[') break;
	        	if (c >= '0' && c <= '9') str.append(c);
	        }
	        try {
				return Integer.parseInt(str.toString());
			} catch (NumberFormatException e) {
				//e.printStackTrace();
				return 0;
			}
		}
	}
	
	@Test
	public void test1() {
		System.out.println("test1()=========");
		Collection<SortTest> sorts = new HashSet<>();
        sorts.add(new SortTest("p1"));
        sorts.add(new SortTest("p10"));
        sorts.add(new SortTest("p2"));
        System.out.println("随机序列: " + sorts);  // sorts: [p10, p1, p2]
	}
	
	@Test
	public void test2() {
		System.out.println("test2()=========");
		Collection<SortTest> sorts = new HashSet<>();
        sorts.add(new SortTest("p1"));
        sorts.add(new SortTest("p10"));
        sorts.add(new SortTest("p2"));
        System.out.println("随机序列: " + sorts);  // sorts: [p10, p1, p2]
        
        List<SortTest> list = new ArrayList<>(sorts);
        Collections.sort(list, new Comparator<SortTest>(){
			@Override
			public int compare(SortTest o1, SortTest o2) {
				String s1 = o1.getName();
				String s2 = o2.getName();
				return s1.compareTo(s2);
			}
        	
        });
        System.out.println("【不合理】字符串比较排序1： " + list);  //字符串比较排序1： [p1, p10, p2]
	}
	
	@Test
	public void test22() {
		System.out.println("test22()=========");
		Collection<SortTest> sorts = new HashSet<>();
        sorts.add(new SortTest("p1"));
        sorts.add(new SortTest("p10"));
        sorts.add(new SortTest("p2"));
        System.out.println("随机序列: " + sorts);  // sorts: [p10, p1, p2]
        
        List<SortTest> list = new ArrayList<>(sorts);
        Collections.sort(list, new Comparator<SortTest>(){
			@Override
			public int compare(SortTest o1, SortTest o2) {
				String s1 = o1.getName();
				String s2 = o2.getName();
				return s2.compareTo(s1);  // 反序
			}
        	
        });
        System.out.println("【不合理】字符串比较排序2： " + list);  //字符串比较排序2： [p2, p10, p1]
	}
	
	@Test
	public void test3() {
		System.out.println("test3()=========");
		Collection<SortTest> sorts = new HashSet<>();
        sorts.add(new SortTest("p1"));
        sorts.add(new SortTest("p10"));
        sorts.add(new SortTest("p2"));
        System.out.println("随机序列: " + sorts);  // sorts: [p10, p1, p2]
        
        List<SortTest> list1 = new ArrayList<>(sorts);
        Collections.sort(list1, new MyComparator());
        System.out.println("自定义比较规则: " + list1);  // 自定义比较规则: [p1, p2, p10]
	}
	
	@Test
	public void test4() {
		System.out.println("test4()=========");
		Collection<SortTest> sorts = new HashSet<>();
        sorts.add(new SortTest("p1"));
        sorts.add(new SortTest("abc"));
        sorts.add(new SortTest("p2"));
        sorts.add(new SortTest("235"));
        System.out.println("随机序列: " + sorts);  
        
        List<SortTest> list1 = new ArrayList<>(sorts);
        Collections.sort(list1, new MyComparator());
        System.out.println("自定义比较规则: " + list1);  //自定义比较规则: [abc, p1, p2, 235]
	}

}
