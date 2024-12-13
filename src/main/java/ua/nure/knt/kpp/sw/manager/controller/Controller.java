package ua.nure.knt.kpp.sw.manager.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ua.nure.knt.kpp.sw.manager.dao.DAOFactory;
import ua.nure.knt.kpp.sw.manager.dao.IDAO;
import ua.nure.knt.kpp.sw.manager.dao.TypeDAO;
import ua.nure.knt.kpp.sw.manager.entities.objects.*;
import ua.nure.knt.kpp.sw.manager.entities.primary.PrimaryParameter;
import ua.nure.knt.kpp.sw.manager.form.add.*;
import ua.nure.knt.kpp.sw.manager.form.*;

@org.springframework.stereotype.Controller
public class Controller {

	//private IDAO dao = DAOFactory.getDAOInstance(TypeDAO.MySQL);
	private IDAO dao = DAOFactory.getDAOInstance(TypeDAO.COLLECTION);

	@RequestMapping(value = {"/", "/home"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String showHomePage(Model model) {
		return "homePage";
	}

	@RequestMapping(value = {"/search"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String showAll(Model model) {
		List<Student> studentsList = dao.getAllStudents();
		List<Conference> conferencesList = dao.getAllConferences();
		List<Publication> publicationsList = dao.getAllPublications();
		List<Abstract> abstractsList = dao.getAllAbstracts();
		List<ResearchAdvisor> researchAdvisorsList = dao.getAllResearchAdvisors();
		List<Group> groupsList = dao.getAllGroups();
		List<Publisher> publisherList = dao.getAllPublishers();

		model.addAttribute("allStudents", studentsList);
		model.addAttribute("allConferences", conferencesList);
		model.addAttribute("allPublications", publicationsList);
		model.addAttribute("allAbstracts", abstractsList);
		model.addAttribute("allResearchAdvisors", researchAdvisorsList);
		model.addAttribute("allGroups", groupsList);
		model.addAttribute("allPublishers", publisherList);

		return "searchPage";
	}

	@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
	public String showAddView(Model model) {

		List<Group> groupsList = dao.getAllGroups();
		List<Publisher> publisherList = dao.getAllPublishers();
		List<Student> studentsList = dao.getAllStudents();
		List<Conference> conferencesList = dao.getAllConferences();
		List<ResearchAdvisor> researchAdvisorsList = dao.getAllResearchAdvisors();
		List<PrimaryParameter> facultiesList = dao.getPrimaryParameter("Faculties", "faculty");
		List<PrimaryParameter> programsList = dao.getPrimaryParameter("EducationalPrograms", "educational_program");
		List<PrimaryParameter> specialtiesList = dao.getPrimaryParameter("Specialties", "specialty");
		List<PrimaryParameter> levelsList = dao.getPrimaryParameter("HigherEducationLevels", "level");
		List<PrimaryParameter> workTypesList = dao.getPrimaryParameter("WorkTypes", "work_type");
		List<PrimaryParameter> conferenceTypesList = dao.getPrimaryParameter("ConferenceTypes", "conference_type");
		List<PrimaryParameter> conferenceStatesList = dao.getPrimaryParameter("ConferenceStates", "state");
		List<PrimaryParameter> countriesList = dao.getPrimaryParameter("Countries", "country");
		List<PrimaryParameter> quartilesList = dao.getPrimaryParameter("Quartiles", "quartile");

		model.addAttribute("allGroups", groupsList);
		model.addAttribute("allPublishers", publisherList);
		model.addAttribute("allStudents", studentsList);
		model.addAttribute("allConferences", conferencesList);
		model.addAttribute("allResearchAdvisors", researchAdvisorsList);
		model.addAttribute("facultiesList", facultiesList);
		model.addAttribute("programsList", programsList);
		model.addAttribute("workTypesList", workTypesList);
		model.addAttribute("conferenceTypesList", conferenceTypesList);
		model.addAttribute("conferenceStatesList", conferenceStatesList);
		model.addAttribute("countriesList", countriesList);
		model.addAttribute("quartilesList", quartilesList);

		AddStudentForm addStudentForm = new AddStudentForm();
		AddPublicationForm addPublicationForm = new AddPublicationForm();
		AddAbstractForm addAbstractForm = new AddAbstractForm();
		AddConferenceForm addConferenceForm = new AddConferenceForm();
		AddResearchForm addResearchForm = new AddResearchForm();
		AddGroupForm addGroupForm = new AddGroupForm();
		AddPublisherForm addPublisherForm = new AddPublisherForm();

		model.addAttribute("addStudentForm", addStudentForm);
		model.addAttribute("addPublicationForm", addPublicationForm);
		model.addAttribute("addAbstractForm", addAbstractForm);
		model.addAttribute("addConferenceForm", addConferenceForm);
		model.addAttribute("addResearchForm", addResearchForm);
		model.addAttribute("addGroupForm", addGroupForm);
		model.addAttribute("addPublisherForm", addPublisherForm);

		return "addPage";
	}

	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public String addStudent(@RequestParam String dataType,
							 @ModelAttribute AddStudentForm addStudentForm,
							 @ModelAttribute AddPublicationForm addPublicationForm,
							 @ModelAttribute AddAbstractForm addAbstractForm,
							 @ModelAttribute AddConferenceForm addConferenceForm,
							 @ModelAttribute AddResearchForm addResearchForm,
							 @ModelAttribute AddGroupForm addGroupForm,
							 @ModelAttribute AddPublisherForm addPublisherForm) {
		if ("students".equals(dataType)) {
			dao.addStud(
					new Student(
							dao.getUniqueID("Students", "student"),
							addStudentForm.getName(),
							addStudentForm.getSurname(),
							"",
							addStudentForm.getPhoneNumber(),
							addStudentForm.getEmail(),
							addStudentForm.getNumberOfWorks()
					),
					addStudentForm.getGroup()
			);
		} else if ("publications".equals(dataType)) {
			dao.addPublication(
					new Publication(
							dao.getUniqueID("Publications", "publication"),
							addPublicationForm.getTopic(),
							"",
							addPublicationForm.getPublicationNumber(),
							"",
							addPublicationForm.getPublicationDate()
					),
					dao.getUniqueID("ScientificWorks", "work"),
					addPublicationForm.getPublisher(),
					addPublicationForm.getAuthor(),
					addPublicationForm.getAdvisor(),
					dao.getUniqueID("StudentWorks", "student_works")
			);
		} else if ("abstracts".equals(dataType)){
			dao.addAbstract(
                    new Abstract(
                            dao.getUniqueID("ScientificWorks", "work"),
                            addAbstractForm.getTopic(),
							"",
							""
                    ),
					addAbstractForm.getAuthor(),
					addAbstractForm.getAdvisor(),
					addAbstractForm.getConference(),
					dao.getUniqueID("StudentWorks", "student_works")
            );
		} else if ("conferences".equals(dataType)){
			dao.addConference(
					new Conference(
							dao.getUniqueID("Conferences", "conference"),
							addConferenceForm.getName(),
							"",
							"",
							addConferenceForm.getStartDate(),
							addConferenceForm.getEndDate()
					),
					addConferenceForm.getType(),
					addConferenceForm.getState()
			);
		} else if ("advisers".equals(dataType)){
			dao.addAdvisor(
					new ResearchAdvisor(
							dao.getUniqueID("ResearchAdvisors", "advisor"),
							addStudentForm.getName(),
							addStudentForm.getSurname(),
							addStudentForm.getPhoneNumber(),
							addStudentForm.getEmail(),
							"",
							addStudentForm.getNumberOfWorks()
					),
					addResearchForm.getFaculty()
			);
		} else if ("groups".equals(dataType)){
			dao.addGroup(
					new Group(
							dao.getUniqueID("`groups`", "group"),
							addGroupForm.getNumber(),
							"", "", "", ""
					),
					addGroupForm.getFaculty(), addGroupForm.getProgram()
			);
		} else if ("publishers".equals(dataType)){
			dao.addPublisher(
					new Publisher(
							dao.getUniqueID("Publishers", "publisher"),
							addPublisherForm.getName(),
							"", ""
					),
					addPublisherForm.getQuartile(), addPublisherForm.getCountry()
			);
		}

		return "redirect:/search";
	}


	@RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
	public String showDeleteView(Model model) {
		List<Student> studentsList = dao.getAllStudents();
		List<Conference> conferencesList = dao.getAllConferences();
		List<Publication> publicationsList = dao.getAllPublications();
		List<Abstract> abstractsList = dao.getAllAbstracts();
		List<ResearchAdvisor> researchAdvisorsList = dao.getAllResearchAdvisors();
		List<Group> groupsList = dao.getAllGroups();
		List<Publisher> publisherList = dao.getAllPublishers();

		model.addAttribute("allStudents", studentsList);
		model.addAttribute("allConferences", conferencesList);
		model.addAttribute("allPublications", publicationsList);
		model.addAttribute("allAbstracts", abstractsList);
		model.addAttribute("allResearchAdvisors", researchAdvisorsList);
		model.addAttribute("allGroups", groupsList);
		model.addAttribute("allPublishers", publisherList);

		DeleteForm deleteForm = new DeleteForm();
		model.addAttribute("deleteForm", deleteForm);

		return "deletePage";
	}

	@RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
	public String delete(Model model,
						 @RequestParam String dataType,
						 @ModelAttribute DeleteForm deleteForm) {

		if ("students".equals(dataType)) {
			dao.deleteObject(
					"Students",
					"student",
					deleteForm.getID()
			);
		} else if ("publications".equals(dataType)) {
			dao.deleteObject(
					"Publications",	//!!!!!!!! ALSO Delete ScientificWork and StudentWork
					"publication",
					deleteForm.getID()
			);
		} else if ("abstracts".equals(dataType)){
			dao.deleteObject(
					"ScientificWorks",
					"work",
					deleteForm.getID()
			);
		} else if ("conferences".equals(dataType)){
			dao.deleteObject(
					"Conferences",
					"conference",
					deleteForm.getID()
			);
		} else if ("advisers".equals(dataType)){
			dao.deleteObject(
					"ResearchAdvisors",
					"advisor",
					deleteForm.getID()
			);
		} else if ("groups".equals(dataType)){
			dao.deleteObject(
					"`groups`",
					"group",
					deleteForm.getID()
			);
		} else if ("publishers".equals(dataType)){
			dao.deleteObject(
					"Publishers",
					"publisher",
					deleteForm.getID()
			);
		}

		return "redirect:/search";
	}


	@RequestMapping(value = {"/calculate"}, method = RequestMethod.GET)
	public String s(Model model) {
		List<Student> studentsList = dao.getAllStudents();
		model.addAttribute("allStudents", studentsList);

		CalculateForm calculateForm = new CalculateForm();
		model.addAttribute("calculateForm", calculateForm);

		return "calculatePage";
	}

	@RequestMapping(value = {"/calculate"}, method = RequestMethod.POST)
	@ResponseBody
	public String addStudent(Model model, @ModelAttribute CalculateForm calculateForm) {
		dao.countWorks(calculateForm);

		int result = calculateForm.getNumberOfQ1() * calculateForm.getQ1() +
				calculateForm.getNumberOfQ2() * calculateForm.getQ2() +
                calculateForm.getNumberOfQ3() * calculateForm.getQ3() +
                calculateForm.getNumberOfQ4() * calculateForm.getQ4() +
				calculateForm.getNumberOfAbstracts() * calculateForm.getAnAbstract();

		if(result > calculateForm.getMaxExtraPoints()){
			result = calculateForm.getMaxExtraPoints();
		}

		return String.valueOf(result);
	}
}
