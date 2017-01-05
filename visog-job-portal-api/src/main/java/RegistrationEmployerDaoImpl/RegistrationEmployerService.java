package RegistrationEmployerDaoImpl;

import java.util.List;

import com.visog.jobportal.req.transaction.UsersReq;
import com.visog.jobportal.res.transaction.UsersRes;

public interface RegistrationEmployerService {

	
	public void saveRegistrationEmployerDetails(UsersReq req);

	public void updateEmployerDetails(UsersReq req, String employerDetailsId);

	public List<UsersRes> getEmployerDetails();

	public UsersRes getEmployerDetails(String employerDetailsId);

	public Boolean deleteAddress(String id);

}
