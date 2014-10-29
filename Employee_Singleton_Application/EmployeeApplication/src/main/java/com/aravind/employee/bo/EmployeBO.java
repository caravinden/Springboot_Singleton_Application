/**
 * 
 */
package com.aravind.employee.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.aravind.employee.dao.EmployeDAO;
import com.aravind.employee.dataobject.Employee;

/**
 * Business layer class that helps to make all database call
 * 
 * @author aravind
 * @date 30-09-2014
 *
 */
public final class EmployeBO {

	private static final Logger LOG = Logger.getLogger(EmployeBO.class);

	/**
	 * Private constructor (as utility class)
	 */
	private EmployeBO() {

	}

	/**
	 * To get employee details based on employee id
	 * 
	 * @param empID
	 * @return {@link List}
	 */
	public static List<Employee> getEmployee(String empID) {
		Employee employee = null;
		try {
			employee = new Employee();
			employee.setEmpID(Integer.parseInt(empID));
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		return EmployeDAO.getInstance().getEmployeeDetails(employee);
	}
}
