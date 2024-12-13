package ua.nure.knt.kpp.sw.manager.dao.MySQL;

import java.sql.Date;
import java.util.*;
import java.sql.*;

import ua.nure.knt.kpp.sw.manager.dao.DAOFactory;
import ua.nure.knt.kpp.sw.manager.dao.IDAO;
import ua.nure.knt.kpp.sw.manager.dao.TypeDAO;
import ua.nure.knt.kpp.sw.manager.comparators.*;
import ua.nure.knt.kpp.sw.manager.collection.*;
import ua.nure.knt.kpp.sw.manager.entities.objects.*;
import ua.nure.knt.kpp.sw.manager.entities.primary.PrimaryParameter;
import ua.nure.knt.kpp.sw.manager.form.CalculateForm;

public class MySQLDAO implements IDAO {

	private static String server = "localhost";
	private static String db = "SWManager";
	private static String login = "root";
	private static String pass = "";

	private static String SQL_ADD_STUD = "INSERT INTO Students VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static String SQL_ADD_PUBLIC = "INSERT INTO Publications VALUES (?, ?, ?, ?)";
	private static String SQL_ADD_WORK = "INSERT INTO ScientificWorks VALUES (?, ?, ?, ?, ?, ?)";
	private static String SQL_ADD_AUTHOR_WORK_CON = "INSERT INTO StudentWorks VALUES (?, ?, ?)";
	private static String SQL_ADD_CONF = "INSERT INTO Conferences VALUES (?, ?, ?, ?, ?, ?)";
	private static String SQL_ADD_ADVISOR = "INSERT INTO ResearchAdvisors VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static String SQL_ADD_GROUP = "INSERT INTO `groups` VALUES (?, ?, ?, ?)";
	private static String SQL_ADD_PUBLISHER = "INSERT INTO Publishers VALUES (?, ?, ?, ?)";

	private static String SQL_SELECT_WORK_CON_ID = "SELECT sw.id_work, stw.id_student_works FROM Publications p JOIN ScientificWorks sw ON sw.id_publication = ? JOIN StudentWorks stw ON stw.id_work = sw.id_work";

	private static final String SQL_DEFINE_WORK_TYPE = "SELECT sw.id_work_type FROM Students stud JOIN StudentWorks stw ON ? = stw.id_student JOIN ScientificWorks sw ON stw.id_work = sw.id_work";
	private static final String SQL_DEFINE_PUBLICATION_QUARTILE = "SELECT publish.id_quartile FROM Students stud JOIN StudentWorks stw ON ? = stw.id_student JOIN ScientificWorks sw ON stw.id_work = sw.id_work JOIN Publications public ON sw.id_publication = public.id_publication JOIN Publishers publish ON public.id_publisher = publish.id_publisher";

	private static String SQL_GET_ALL_STUD = "SELECT s.id_student, s.first_name, s.last_name, s.phone_number, s.email, s.number_of_works, g.group_number FROM Students s JOIN `groups` g ON s.id_group = g.id_group";
	private static String SQL_GET_ALL_CONF = "SELECT c.id_conference, c.conference_name, ct.conference_type_name, cs.state_name, c.conference_start_date, c.conference_end_date FROM Conferences c JOIN ConferenceTypes ct ON c.id_conference_type = ct.id_conference_type JOIN ConferenceStates cs ON c.id_state = cs.id_state";
	private static String SQL_GET_ALL_PUBLIC = "SELECT p.id_publication, sw.work_topic, wt.work_type_name, stud.first_name, stud.last_name, p.publication_number, pb.publisher_name, p.publication_date FROM Publications p JOIN ScientificWorks sw ON sw.id_publication = p.id_publication JOIN StudentWorks studw ON sw.id_work = studw.id_work  JOIN Students stud ON stud.id_student = studw.id_student JOIN WorkTypes wt ON sw.id_work_type = wt.id_work_type JOIN Publishers pb ON pb.id_publisher = p.id_publisher";
	private static String SQL_GET_ALL_ABSTRACT = "SELECT sw.id_work, sw.work_topic, wt.work_type_name, stud.first_name, stud.last_name, c.conference_name FROM ScientificWorks sw JOIN StudentWorks studw ON sw.id_work = studw.id_work  JOIN Students stud ON stud.id_student = studw.id_student JOIN WorkTypes wt ON sw.id_work_type = wt.id_work_type JOIN Conferences c ON sw.id_conference = c.id_conference";
	private static String SQL_GET_ALL_RESEARCH = "SELECT ra.id_advisor, ra.first_name, ra.last_name, ra.phone_number, ra.email, f.faculty_name, ra.number_of_works FROM ResearchAdvisors ra JOIN Faculties f ON ra.id_faculty = f.id_faculty";
	private static String SQL_GET_ALL_GROUPS = "SELECT g.id_group, g.group_number, ep.educational_program_name, f.faculty_name, sp.specialty_name, hel.level_name FROM `groups` g JOIN Faculties f ON g.id_faculty = f.id_faculty JOIN EducationalPrograms ep ON g.id_educational_program = ep.id_educational_program JOIN HigherEducationLevels hel ON ep.id_level = hel.id_level JOIN Specialties sp ON ep.id_specialty = sp.id_specialty";
	private static String SQL_GET_ALL_PUBLISHERS = "SELECT p.id_publisher, p.publisher_name, q.quartile_name, c.country_name FROM Publishers p JOIN Quartiles q ON p.id_quartile = q.id_quartile JOIN Countries c ON p.id_country = c.id_country";



	public MySQLDAO() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addStud(Student stud, Long groupID) {

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement(SQL_ADD_STUD);
			ps.setLong(1,stud.getId());
			ps.setString(2, stud.getName());
			ps.setString(3, stud.getSurname());
			ps.setString(4, stud.getPhoneNumber());
			ps.setString(5, stud.getEmail());
			ps.setLong(6, groupID);
			ps.setInt(7, stud.getNumberOfWorks());

			ps.executeUpdate();

			con.commit();
			con.setAutoCommit(true);

			ps.close();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addPublication(Publication publication, Long workUniqueID, Long publisherID, Long authorID, Long advisorID, Long conUniqueID) {

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			con.setAutoCommit(false);

			PreparedStatement ps1 = con.prepareStatement(SQL_ADD_PUBLIC);
			ps1.setLong(1,publication.getId());
			ps1.setLong(2, publisherID);
			ps1.setString(3, publication.getPublicationNumber());
			ps1.setDate(4, publication.getPublicationDate());

			ps1.executeUpdate();
			ps1.close();

			PreparedStatement ps2 = con.prepareStatement(SQL_ADD_WORK);
			ps2.setLong(1, workUniqueID);
			ps2.setLong(2, advisorID);
			ps2.setLong(3, 1);
			ps2.setString(4, publication.getTopic());
			ps2.setNull(5, 0);
			ps2.setLong(6, publication.getId());

			ps2.executeUpdate();
			ps2.close();

			PreparedStatement ps3 = con.prepareStatement(SQL_ADD_AUTHOR_WORK_CON);
			ps3.setLong(1, conUniqueID);
			ps3.setLong(2, authorID);
			ps3.setLong(3, workUniqueID);

			ps3.executeUpdate();
			ps3.close();

			con.commit();
			con.setAutoCommit(true);

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addAbstract(Abstract anAbstract, Long authorID, Long advisorID, Long conferenceID, Long conUniqueID){
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			con.setAutoCommit(false);

			PreparedStatement ps1 = con.prepareStatement(SQL_ADD_WORK);
			ps1.setLong(1, anAbstract.getId());
			ps1.setLong(2, advisorID);
			ps1.setLong(3, 2);
			ps1.setString(4, anAbstract.getTopic());
			ps1.setLong(5, conferenceID);
			ps1.setNull(6, 0);

			ps1.executeUpdate();
			ps1.close();

			PreparedStatement ps2 = con.prepareStatement(SQL_ADD_AUTHOR_WORK_CON);
			ps2.setLong(1, conUniqueID);
			ps2.setLong(2, authorID);
			ps2.setLong(3, anAbstract.getId());

			ps2.executeUpdate();
			ps2.close();

			con.commit();
			con.setAutoCommit(true);

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addConference(Conference conference, long typeID, long stateID){
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement(SQL_ADD_CONF);
			ps.setLong(1, conference.getId());
			ps.setString(2, conference.getName());
			ps.setDate(3, conference.getStartDate());
			ps.setDate(4, conference.getEndDate());
			ps.setLong(5, stateID);
			ps.setLong(6, typeID);

			ps.executeUpdate();
			ps.close();

			con.commit();
			con.setAutoCommit(true);

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addAdvisor(ResearchAdvisor advisor, Long facultyID) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement(SQL_ADD_ADVISOR);
			ps.setLong(1,advisor.getId());
			ps.setString(2, advisor.getName());
			ps.setString(3, advisor.getSurname());
			ps.setString(4, advisor.getPhoneNumber());
			ps.setString(5, advisor.getEmail());
			ps.setLong(6, facultyID);
			ps.setInt(7, advisor.getNumberOfWorks());

			ps.executeUpdate();

			con.commit();
			con.setAutoCommit(true);

			ps.close();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addGroup(Group group, Long facultyID, Long programID) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement(SQL_ADD_GROUP);
			ps.setLong(1,group.getId());
			ps.setString(2, group.getNumber());
			ps.setLong(3, facultyID);
			ps.setLong(4, programID);

			ps.executeUpdate();

			con.commit();
			con.setAutoCommit(true);

			ps.close();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addPublisher(Publisher publisher, Long quartileID, Long countryID) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement(SQL_ADD_PUBLISHER);
			ps.setLong(1,publisher.getId());
			ps.setString(2, publisher.getName());
			ps.setLong(3, quartileID);
			ps.setLong(4, countryID);

			ps.executeUpdate();

			con.commit();
			con.setAutoCommit(true);

			ps.close();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteObject(String tableName, String paramName, long ID) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);
			con.setAutoCommit(false);  // Disable auto-commit

			if ("Publications".equals(tableName)) {
				PreparedStatement ps1 = con.prepareStatement(SQL_SELECT_WORK_CON_ID);
				ps1.setLong(1, ID);
				ResultSet res = ps1.executeQuery();

				long workID = 0;
				long conID = 0;

				if (res.next()) {
					workID = res.getLong("id_work");
					conID = res.getLong("id_student_works");
				}
				res.close();
				ps1.close();

				if (workID > 0 && conID > 0) {
					// Delete from StudentWorks
					String deleteStudentWorks = "DELETE FROM StudentWorks WHERE id_student_works = ?";
					PreparedStatement ps2 = con.prepareStatement(deleteStudentWorks);
					ps2.setLong(1, conID);
					ps2.executeUpdate();
					ps2.close();

					// Delete from ScientificWorks
					String deleteScientificWorks = "DELETE FROM ScientificWorks WHERE id_work = ?";
					PreparedStatement ps3 = con.prepareStatement(deleteScientificWorks);
					ps3.setLong(1, workID);
					ps3.executeUpdate();
					ps3.close();
				}

				// Delete from Publications
				String deletePublications = "DELETE FROM Publications WHERE id_publication = ?";
				PreparedStatement ps4 = con.prepareStatement(deletePublications);
				ps4.setLong(1, ID);
				ps4.executeUpdate();
				ps4.close();

			} else {
				String deleteQuery = "DELETE FROM " + tableName + " WHERE id_" + paramName + " = ?";
				PreparedStatement ps = con.prepareStatement(deleteQuery);
				ps.setLong(1, ID);
				ps.executeUpdate();
				ps.close();
			}

			con.commit();  // Commit if everything succeeds
		} catch (SQLException e) {
			if (con != null) {
				try {
					con.rollback();  // Rollback in case of failure
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}


	@Override
	public List<Student> getAllStudents() {
		Connection con = null;
		List<Student> list = null;
		try {
			// Підключення до бази даних
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			// Виконання запиту для отримання всіх студентів
			PreparedStatement ps2 = con.prepareStatement(SQL_GET_ALL_STUD);
			ResultSet res2 = ps2.executeQuery();

			list = new LinkedList<Student>();

			// Обробка результатів запиту
			while (res2.next()) {
				Student student = new Student();
				student.setId(res2.getLong("id_student"));
				student.setName(res2.getString("first_name"));
				student.setSurname(res2.getString("last_name"));
				student.setPhoneNumber(res2.getString("phone_number"));
				student.setEmail(res2.getString("email"));
				student.setNumberOfWorks(res2.getInt("number_of_works"));
				student.setGroup(res2.getString("group_number"));

				list.add(student);
			}

			// Закриття ресурсів
			res2.close();
			ps2.close();
			con.close();
		} catch (SQLException e) {
			// Обробка помилки
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Conference> getAllConferences() {
		Connection con = null;
		List<Conference> list = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			PreparedStatement ps2 = con.prepareStatement(SQL_GET_ALL_CONF);
			ResultSet res2 = ps2.executeQuery();

			list = new LinkedList<Conference>();
			while (res2.next()) {

				Conference conference = new Conference();
				conference.setId(res2.getLong("id_conference"));
				conference.setName(res2.getString("conference_name"));
				conference.setType(res2.getString("conference_type_name"));
				conference.setState(res2.getString("state_name"));
				conference.setStartDate(res2.getDate("conference_start_date"));
				conference.setEndDate(res2.getDate("conference_end_date"));

				list.add(conference);
			}
			res2.close();
			ps2.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Publication> getAllPublications() {
		Connection con = null;
		List<Publication> list = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			PreparedStatement ps2 = con.prepareStatement(SQL_GET_ALL_PUBLIC);
			ResultSet res2 = ps2.executeQuery();

			list = new LinkedList<Publication>();
			while (res2.next()) {

				Publication publication = new Publication();
				publication.setId(res2.getLong("id_publication"));
				publication.setTopic(res2.getString("work_topic"));
				publication.setType(res2.getString("work_type_name"));
				publication.setAuthor(res2.getString("first_name") + " " + res2.getString("last_name"));
				publication.setPublicationNumber(res2.getString("publication_number"));
				publication.setPublisher(res2.getString("publisher_name"));
				publication.setPublicationDate(res2.getDate("publication_date"));

				list.add(publication);
			}
			res2.close();
			ps2.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Abstract> getAllAbstracts() {
		Connection con = null;
		List<Abstract> list = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			PreparedStatement ps2 = con.prepareStatement(SQL_GET_ALL_ABSTRACT);
			ResultSet res2 = ps2.executeQuery();

			list = new LinkedList<Abstract>();
			while (res2.next()) {

				Abstract anAbstract = new Abstract();
				anAbstract.setId(res2.getLong("id_work"));
				anAbstract.setTopic(res2.getString("work_topic"));
				anAbstract.setType(res2.getString("work_type_name"));
				anAbstract.setAuthor(res2.getString("first_name") + " " + res2.getString("last_name"));
				anAbstract.setConferenceName(res2.getString("conference_name"));

				list.add(anAbstract);
			}
			res2.close();
			ps2.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ResearchAdvisor> getAllResearchAdvisors() {
		Connection con = null;
		List<ResearchAdvisor> list = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			PreparedStatement ps2 = con.prepareStatement(SQL_GET_ALL_RESEARCH);
			ResultSet res2 = ps2.executeQuery();

			list = new LinkedList<ResearchAdvisor>();
			while (res2.next()) {

				ResearchAdvisor researchAdvisor = new ResearchAdvisor();
				researchAdvisor.setId(res2.getLong("id_advisor"));
				researchAdvisor.setName(res2.getString("first_name"));
				researchAdvisor.setSurname(res2.getString("last_name"));
				researchAdvisor.setPhoneNumber(res2.getString("phone_number"));
				researchAdvisor.setEmail(res2.getString("email"));
				researchAdvisor.setFaculty(res2.getString("faculty_name"));
				researchAdvisor.setNumberOfWorks(res2.getInt("number_of_works"));

				list.add(researchAdvisor);
			}
			res2.close();
			ps2.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Group> getAllGroups() {
		Connection con = null;
		List<Group> list = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			PreparedStatement ps2 = con.prepareStatement(SQL_GET_ALL_GROUPS);
			ResultSet res2 = ps2.executeQuery();

			list = new LinkedList<Group>();
			while (res2.next()) {

				Group group = new Group();
				group.setId(res2.getLong("id_group"));
				group.setNumber(res2.getString("group_number"));
				group.setEducationalProgram(res2.getString("educational_program_name"));
				group.setFaculty(res2.getString("faculty_name"));
				group.setSpecialty(res2.getString("specialty_name"));
				group.setLevel(res2.getString("level_name"));

				list.add(group);
			}
			res2.close();
			ps2.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Publisher> getAllPublishers() {
		Connection con = null;
		List<Publisher> list = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			PreparedStatement ps2 = con.prepareStatement(SQL_GET_ALL_PUBLISHERS);
			ResultSet res2 = ps2.executeQuery();

			list = new LinkedList<Publisher>();
			while (res2.next()) {

				Publisher publisher = new Publisher();
				publisher.setId(res2.getLong("id_publisher"));
				publisher.setName(res2.getString("publisher_name"));
				publisher.setQuartile(res2.getString("quartile_name"));
				publisher.setCountry(res2.getString("country_name"));

				list.add(publisher);
			}
			res2.close();
			ps2.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<PrimaryParameter> getPrimaryParameter(String tableName, String paramName){
		Connection con = null;
		List<PrimaryParameter> list = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + tableName);
			ResultSet res = ps.executeQuery();

			list = new LinkedList<PrimaryParameter>();
			while (res.next()) {

				PrimaryParameter primaryParameter = new PrimaryParameter();
				primaryParameter.setId(res.getLong("id_" + paramName));
				primaryParameter.setName(res.getString(paramName + "_name"));

				list.add(primaryParameter);
			}
			res.close();
			ps.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Long getUniqueID(String tableName, String paramName) {
		Connection con = null;
		long uniqueID = 1;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);

			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + tableName);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				long id = res.getLong("id_" + paramName);
				if(uniqueID != id){
					break;
				}
				else {
					uniqueID++;
					continue;
				}
			}
			res.close();
			ps.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return uniqueID;
	}

	@Override
	public void countWorks(CalculateForm calculateForm) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://" + server + ":3306/" + db, login, pass);
			 PreparedStatement psWorkType = con.prepareStatement(SQL_DEFINE_WORK_TYPE);
			 PreparedStatement psPublicationQuartile = con.prepareStatement(SQL_DEFINE_PUBLICATION_QUARTILE)) {

			// Встановлення ID студента для запиту
			psWorkType.setLong(1, calculateForm.getStudentID());
			try (ResultSet resWorkType = psWorkType.executeQuery()) {
				while (resWorkType.next()) {
					long workType = resWorkType.getLong("id_work_type");

					if (workType == 1) { // Якщо робота є науковою
						psPublicationQuartile.setLong(1, calculateForm.getStudentID());
						try (ResultSet resPublicationQuartile = psPublicationQuartile.executeQuery()) {
							if (resPublicationQuartile.next()) {
								int quartile = resPublicationQuartile.getInt("id_quartile");
								switch (quartile) {
									case 1: {
										calculateForm.setNumberOfQ1(calculateForm.getNumberOfQ1() + 1);
										break;
									}
									case 2: {
										calculateForm.setNumberOfQ2(calculateForm.getNumberOfQ2() + 1);
										break;
									}
									case 3: {
										calculateForm.setNumberOfQ3(calculateForm.getNumberOfQ3() + 1);
										break;
									}
									default: {
										calculateForm.setNumberOfQ4(calculateForm.getNumberOfQ4() + 1);
									}
								}
							}
						}
					} else { // Якщо робота є тезою
						calculateForm.setNumberOfAbstracts(calculateForm.getNumberOfAbstracts() + 1);
					}
				}
			}
		} catch (SQLException e) {
			// Обробка помилки
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int choice = 1;
		while(choice != 0){
			System.out.println("Enter:\n1 - Comparators and comparable TEST\n2 - Own Collection TEST\n0 - EXIT");
			choice = scanner.nextInt();
			switch (choice){
				case 0: {
					System.out.println("Buy!");
					break;
				}
				case 1:
					// Тестирування компаратора та Comparable
					Student[] students = {
							// Ініціалізація масиву студентів
							new Student(1L,"John",  "Doe", "123456789","+3801234567890", "john@example.com", 2),
							new Student(2L,"Jane","Smith", "987654321", "+3801234567890", "jane@example.com", 1),
							new Student(3L,"Bob",  "Johnson", "321654987", "+3801234567890", "bob@example.com", 3),
							new Student(4L,"Alice","Williams", "789123456", "+3801234567890", "alice@example.com", 2),
							new Student(5L,"David","Brown", "567981234", "+3801234567890", "david@example.com", 1)
					};

					// Виведення списку студентів
					System.out.println("Список студентів:");
					for (Student student : students) {
						System.out.println(student.toString());
					}
					System.out.println('\n');

					// Сортування за іменем (за замовчуванням)
					System.out.println("Список, відсортований за прізвищами (за замовчуванням):");
					Arrays.sort(students);
					for (Student student : students) {
						System.out.println(student.toString());
					}
					System.out.println('\n');

					// Сортування за іменем за допомогою компаратора
					System.out.println("Список, відсортований за іменами (NameComparator):");
					Arrays.sort(students, new NameComparator());
					for (Student student : students) {
						System.out.println(student.toString());
					}
					System.out.println('\n');

					// Сортування за ID за допомогою компаратора
					System.out.println("Список, відсортований за ID (IdComparator):");
					Arrays.sort(students, new IdComparator());
					for (Student student : students) {
						System.out.println(student.toString());
					}
					break;
				case 2:{
					// Тестирування власного коллекці
					Student student1 = new Student(1L,"Tom",  "Doe", "KNT-23-4","+3801234567890", "tom@example.com", 1);
					Student student2 = new Student(2L,"Anna",  "Summer", "KNT-23-3","+3801234567890", "anna@example.com", 3);

					ScientificWork work1 = new Publication(1L, "Robotics", "Tom Doe", "2024.12.23423", "Scopus", new Date(2024, 12, 23));
					ScientificWork work2 = new Abstract(2L, "Life on other planets is reality", "Anna Summer", "Summer Council");

					StudentResearchMap studentResearchMap = new StudentResearchMap();

					// Додати студентів та їхні роботи
					studentResearchMap.add(student1, work1);
					studentResearchMap.add(student2, work2);

					// Вивести всю колекцію
					System.out.println("Вся колекція:");
					System.out.println(studentResearchMap);

					// Отримати роботу студента
					System.out.println("Робота першого студента:");
					System.out.println(studentResearchMap.get(student1));

					// Видалити студента
					studentResearchMap.remove(student2);
					System.out.println("Колекція після видалення другого студента:");
					System.out.println(studentResearchMap);
					break;
				}
				default: {
					System.out.println("| Unexpected input. Enter one of the options below |");
					break;
				}
			}
		}
	}
}


