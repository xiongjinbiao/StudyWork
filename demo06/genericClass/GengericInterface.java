package demo06.genericClass;

// 范型接口
public class GengericInterface {
	public static void main(String[] args) {

	}
}

class AA implements IA{

	@Override
	public void v1(String s1, Double d1) {
		// TODO Auto-generated method stub
		
	}
}

class BB implements IUsb<Integer,Float>{

	@Override
	public void v1(Integer s1, Float d1) {
		// TODO Auto-generated method stub
		
	}
	
}

@SuppressWarnings("rawtypes")
class CC implements IUsb{

	@Override
	public void v1(Object s1, Object d1) {
		// TODO Auto-generated method stub
		
	}
	
}

interface IA extends IUsb<String, Double>{}

interface IUsb<S,D>{
	final static int n = 1;
	int m =2;
	//接口变量默认带有static
//F	S s = "";
	
	public void v1(S s1,D d1);
	
}