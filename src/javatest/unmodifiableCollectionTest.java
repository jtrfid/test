package javatest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class unmodifiableCollectionTest {
     
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();

		// 对s不能改变，只能通过改变c,引起s的改变
		Collection<String> s = Collections.unmodifiableCollection(c);

		c.add("str1"); c.add("str2");
		
		// 不能改变s
        // s.add("str3"); // at javatest.unmodifiableCollectionTest.main(unmodifiableCollectionTest.java:15)
		
        System.out.println(s);  // 对c的改变，引起s的改变, [str1, str2]
        System.out.println(c);  // 对c的改变，引起s的改变, [str1, str2]
        
        c.add("str3");
        c.remove("str2");  
        System.out.println(s);  // 对c的改变，引起s的改变, [str1,str3]
        System.out.println(c);  // 对c的改变，引起s的改变, [str1,str3]
        
	}

}
