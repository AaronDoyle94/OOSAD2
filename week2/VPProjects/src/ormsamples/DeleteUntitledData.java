/**
 * Licensee: Institute of Technology Tallaght
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteUntitledData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = classes.UntitledPersistentManager.instance().getSession().beginTransaction();
		try {
			classes.Employee classesEmployee = classes.Employee.loadEmployeeByQuery(null, null);
			classesEmployee.delete();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteUntitledData deleteUntitledData = new DeleteUntitledData();
			try {
				deleteUntitledData.deleteTestData();
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
