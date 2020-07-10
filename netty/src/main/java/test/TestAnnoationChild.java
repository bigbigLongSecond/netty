package test;

import annotation.TestA;

public class TestAnnoationChild extends TestAnnotation  implements  TextInt {
	
	private void getClassMethom1() {
	}
	
	public void getClassMethom1(int i) {
	}

	@TestA(methodName="getInfoMe" , paramInfo = { Double.class})
	public int getInfoMe( int a , Double d) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getInfo(int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInfo() {
		// TODO Auto-generated method stub
		return 0;
	}
}
