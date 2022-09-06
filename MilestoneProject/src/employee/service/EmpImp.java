package employee.service;

import java.util.List;
import employee.entity.EmpDetails;
import employee.exception.EmpAlreadyExist;
import employee.exception.MissMatchException;


public class EmpImp implements Emp {

	@Override
	public int searchId(List<EmpDetails> empi, int id) {
		// TODO Auto-generated method stub
		for(int i =0; i<empi.size(); i++) {
			if(id==empi.get(i).getId()) {
				return i;
			}
		}
		return -1;
		
	}

	@Override
	public int updateSalary(List<EmpDetails> empi, int id, int sal) throws MissMatchException {
		// TODO Auto-generated method stub
		int index = searchId(empi,id);
		if(index != -1) {
			int s = empi.get(index).getSal();
			empi.get(index).setSal(s+sal);
			return empi.get(index).getSal();
		}
		else {
			throw new MissMatchException("Acc mismatched!");
		}
	}

	
	@Override
	public void Empid(List<EmpDetails> empi, int id) throws EmpAlreadyExist {
		// TODO Auto-generated method stub
		for(int i =0; i<empi.size(); i++) {
			if(id==empi.get(i).getId()) {
				throw new EmpAlreadyExist("Employee exist");
			}
		}
	}
}

	
