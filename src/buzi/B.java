package buzi;

public class B extends A implements InterfaceA{

	private C c;
	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		System.out.println(c);
	}

	@Override
	public void methodB() {
		// TODO Auto-generated method stub
		
	}

	public B() {
		c = new C();     
	}

}
