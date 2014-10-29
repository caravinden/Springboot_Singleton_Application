/**
 * 
 */
package com.aravind.employee.Empcontroller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.employee.bo.EmployeBO;
import com.aravind.employee.dataobject.Employee;

/**
 * @author aravind
 *
 */
@RestController
@RequestMapping("/emp/detail")
public class EmployeeController {

	private static final Logger LOG = Logger
			.getLogger(EmployeeController.class);

	/**
	 * default constructor
	 */
	public EmployeeController() {

	}

	/**
	 * To get employee details based on the requested employee id
	 * 
	 * @param empID
	 * @return {@link List}
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Employee> getEmployee(
			@RequestParam(value = "empID", required = false) String empID) {
		LOG.info("in controller= " + empID);
		return EmployeBO.getEmployee(empID);
	}

}