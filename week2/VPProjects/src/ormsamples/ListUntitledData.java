/**
 * Licensee: Institute of Technology Tallaght
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListUntitledData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Employee...");
		classes.Employee[] classesEmployees = classes.Employee.listEmployeeByQuery(null, null);
		int length = Math.min(classesEmployees.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(classesEmployees[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Employee by Criteria...");
		classes.EmployeeCriteria classesEmployeeCriteria = new classes.EmployeeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//classesEmployeeCriteria.id.eq();
		classesEmployeeCriteria.setMaxResults(ROW_COUNT);
		classes.Employee[] classesEmployees = classesEmployeeCriteria.listEmployee();
		int length =classesEmployees== null ? 0 : Math.min(classesEmployees.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(classesEmployees[i]);
		}
		System.out.println(length + " Employee record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListUntitledData listUntitledData = new ListUntitledData();
			try {
				listUntitledData.listTestData();
				//listUntitledData.listByCriteria();
			}
			finally {
				classes.UntitledPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
