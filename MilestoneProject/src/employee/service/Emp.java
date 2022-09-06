package employee.service;

import java.util.List;
import employee.entity.EmpDetails;
import employee.exception.EmpAlreadyExist;
import employee.exception.MissMatchException;


public interface Emp {
	public void Empid(List<EmpDetails> empi, int id) throws EmpAlreadyExist;
	public int searchId(List<EmpDetails> empi, int id);
	public int updateSalary(List<EmpDetails> empi, int id, int sal) throws MissMatchException;
}
