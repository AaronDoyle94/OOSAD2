/**
 * Licensee: Institute of Technology Tallaght
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateUntitledData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = classes.UntitledPersistentManager.instance().getSession().beginTransaction();
		try {
			classes.Employee classesEmployee = classes.Employee.loadEmployeeByQuery(null, null);
			// Update the properties of the persistent object
			classesEmployee.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Employee by EmployeeCriteria");
		classes.EmployeeCriteria classesEmployeeCriteria = new classes.EmployeeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//classesEmployeeCriteria.id.eq();
		System.out.println(classesEmployeeCriteria.uniqueEmployee());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateUntitledData retrieveAndUpdateUntitledData = new RetrieveAndUpdateUntitledData();
			try {
				retrieveAndUpdateUntitledData.retrieveAndUpdateTestData();
				//retrieveAndUpdateUntitledData.retrieveByCriteria();
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
