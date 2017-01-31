/**
 * Licensee: Institute of Technology Tallaght
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateUntitledData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = classes.UntitledPersistentManager.instance().getSession().beginTransaction();
		try {
			classes.Employee classesEmployee = classes.Employee.createEmployee();
			// Initialize the properties of the persistent object here
			classesEmployee.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateUntitledData createUntitledData = new CreateUntitledData();
			try {
				createUntitledData.createTestData();
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
