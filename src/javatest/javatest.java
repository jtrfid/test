package javatest;

public class javatest {

	/**
	 * 1.对象就是传引用
       2.原始类型就是传值
       3.String，Integer, Double等immutable类型因为没有提供自身修改的函数，每次操作都是新生成一个对象，所以要特殊对待。可以认为是传值。
Integer 和 String 一样。保存value的类变量是Final属性，无法被修改，只能被重新赋值／生成新的对象。
 当Integer 做为方法参数传递进方法内时，对其的赋值都会导致 原Integer 的引用被 指向了方法内的栈地址，失去了对原类变量地址的指向。对赋值后的Integer对象做得任何操作，都不会影响原来对象。
	 */
	void methodA(int a) {
		a=5;
	}
	
	void methodB(Integer a) {
		a=15;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javatest test = new javatest();
        int a=10;
        Integer b=20;
        
        test.methodA(a);
        test.methodA(b);
        System.out.println("a=" + a + ",b=" + b); // 10,20
        
        a= 10; b= 20;
        test.methodB(a);
        test.methodB(b);
        System.out.println("a=" + a + ",b=" + b);  // 10,20
        
	}

}
