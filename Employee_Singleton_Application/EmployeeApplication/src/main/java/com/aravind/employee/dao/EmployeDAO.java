/**
 * 
 */
package com.aravind.employee.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aravind.employee.dataobject.Employee;


/**
 * Employee data access layer class for all database related operation
 * 
 * @author aravind
 * @date 30-09-2014
 *
 */
public final class EmployeDAO extends DAO{
	
	private static final EmployeDAO EMPLOYE_DAO = new EmployeDAO();
	private static final Logger LOG = Logger.getLogger(EmployeDAO.class);
	/**
	 * private constructor deny creation of class object
	 */
	private EmployeDAO(){
		super();
	}
	/**
	 * To create singleton object
	 * @return {@link Object}
	 */
	public static EmployeDAO getInstance(){
		return EMPLOYE_DAO;
	}
	/**
	 * test function
	 * @param employee
	 * @return {@link String}
	 */
	public String getDetail(Employee employee){
		return "test!!!";
	}
	
	/**
	 *  To get employee details based on employee id
	 * @param employee
	 * @return {@link List}
	 */
	public List<Employee> getEmployeeDetails(Employee employee){
		connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> employees = new ArrayList<Employee>();
		try {
			pstmt = connection.prepareStatement("SELECT ID,NAME,DESIGNATION,SALARY,DEPARTMENT FROM EMP.EMPLOYEE WHERE ID = ?");
			pstmt.setInt(1, employee.getEmpID());
			rs = pstmt.executeQuery();
			while(rs!=null && rs.next()){
				Employee employee2 = new Employee();
				employee2.setEmpID(rs.getInt(1));
				employee2.setEmpName(rs.getString(2));
				employee2.setDesignation(rs.getString(3));
				employee2.setSalary(rs.getDouble(4));
				employee2.setEmpDept(rs.getString(5));
				LOG.info("\n"+employee2.toString());
				employees.add(employee2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e);
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			disconnect();
		}
		return employees; 
	}

}
