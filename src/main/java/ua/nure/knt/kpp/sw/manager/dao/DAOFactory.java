package ua.nure.knt.kpp.sw.manager.dao;

import ua.nure.knt.kpp.sw.manager.dao.MySQL.MySQLDAO;

public class DAOFactory {

	public static IDAO getDAOInstance(TypeDAO type) {
		IDAO dao = null;
		if (type == TypeDAO.MySQL) {

			dao = new MySQLDAO();

		}
		if (type == TypeDAO.COLLECTION) {

			dao = new CollectionLDAO();

		}

		return dao;
	}

}
