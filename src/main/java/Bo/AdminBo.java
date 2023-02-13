package Bo;

import Bean.AdminBean;
import Dao.AdminDao;

public class AdminBo {
	AdminDao addao = new AdminDao();

	public AdminBean ktdn(String tendn, String mk) throws Exception {
		return addao.ktdn(tendn, mk);
	}
}
