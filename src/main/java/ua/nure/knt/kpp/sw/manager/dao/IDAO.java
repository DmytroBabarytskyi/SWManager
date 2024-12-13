package ua.nure.knt.kpp.sw.manager.dao;

import java.util.List;

import ua.nure.knt.kpp.sw.manager.entities.objects.*;
import ua.nure.knt.kpp.sw.manager.entities.primary.PrimaryParameter;
import ua.nure.knt.kpp.sw.manager.form.CalculateForm;

public interface IDAO {
	void addStud(Student stud, Long groupID);
	void addPublication(Publication publication, Long workUniqueID, Long publisherID, Long authorID, Long advisorID, Long conUniqueID);
	void addAbstract(Abstract anAbstract, Long authorID, Long advisorID, Long conferenceID, Long conUniqueID);
	void addConference(Conference conference, long typeID, long stateID);
	void addAdvisor(ResearchAdvisor advisor, Long facultyID);
	void addGroup(Group group, Long facultyID, Long programID);
	void addPublisher(Publisher publisher, Long quartileID, Long countryID);

	void deleteObject(String tableName, String paramName, long ID);

	void countWorks(CalculateForm calculateForm);

	List<Student> getAllStudents();
	List<Conference> getAllConferences();
	List<Publication> getAllPublications();
	List<Abstract> getAllAbstracts();
	List<ResearchAdvisor> getAllResearchAdvisors();
	List<Group> getAllGroups();
	List<Publisher> getAllPublishers();
	List<PrimaryParameter> getPrimaryParameter(String tableName, String paramName);

	Long getUniqueID(String tableName, String paramName);
}
