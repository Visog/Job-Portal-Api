package RegistrationEmployerDaoImpl;

import java.util.List;

import com.visog.jobportal.req.transaction.UsersReq;
import com.visog.jobportal.res.transaction.UsersRes;

public interface RegistrationEmployerService {

	
	public boolean saveRegistrationEmployerDetails(UsersReq req);

	public boolean updateEmployerDetails(UsersReq req, String regemployerId);

	public List<UsersRes> getEmployerDetails();

	public UsersRes getEmployerDetails(String employerDetailsId);

	public Boolean deleteEmployerDetails(String id);

}
