package demo03.polyParameter;

public class PolyParameter {
	public static void main(String[] args) {
		
		Worker worker = new Worker("tom",3000);
		Manager manager = new Manager("malia",5000,10000);
		
		showEmpAnnual(worker);
		showEmpAnnual(manager);
		
		working(worker);
		working(manager);
		
	}
	
	public static void showEmpAnnual(Employee e) {
		System.out.println(e.getName()+" "+e.getAnnual());
	}
	
	public static void working(Employee e) {
		if(e instanceof Worker) {
			((Worker)e).work();
		} else if(e instanceof Manager) {
			((Manager)e).manage();
		}else {
			System.out.println("input type is worry");
		}
	}
		
}
