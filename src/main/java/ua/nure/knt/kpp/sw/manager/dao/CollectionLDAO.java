package ua.nure.knt.kpp.sw.manager.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.sql.Date;

import ua.nure.knt.kpp.sw.manager.entities.objects.*;
import ua.nure.knt.kpp.sw.manager.entities.primary.PrimaryParameter;
import ua.nure.knt.kpp.sw.manager.form.CalculateForm;

public class CollectionLDAO implements IDAO{

	private static List<Student> students = new ArrayList<Student>();
	private static List<Conference> conferences = new ArrayList<Conference>();
	private static List<Publication> publications = new ArrayList<Publication>();
	private static List<Abstract> abstracts = new ArrayList<Abstract>();
	private static List<ResearchAdvisor> researchAdvisors = new ArrayList<ResearchAdvisor>();
	private static List<Group> groups = new ArrayList<Group>();
	private static List<Publisher> publishers = new ArrayList<Publisher>();

	private static List<PrimaryParameter> faculties = new ArrayList<PrimaryParameter>();
	private static List<PrimaryParameter> conferenceTypes = new ArrayList<PrimaryParameter>();
	private static List<PrimaryParameter> conferenceStates = new ArrayList<PrimaryParameter>();
	private static List<PrimaryParameter> educationalPrograms = new ArrayList<PrimaryParameter>();
	private static List<PrimaryParameter> countries = new ArrayList<PrimaryParameter>();
	private static List<PrimaryParameter> quartiles = new ArrayList<PrimaryParameter>();
	private static List<PrimaryParameter> workTypes = new ArrayList<PrimaryParameter>();

	static
	{
		students.add(new Student(1L, "Mike","Tyson", "KNT-23-4","+381234567890","qwerty@gmail.com", 3));
		students.add(new Student(2L, "Jeff","Fury", "KNT-23-2","+381234567890","qwerty@gmail.com", 1));
		students.add(new Student(3L, "Dart","Vader", "KNT-23-1","+381234567890","qwerty@gmail.com", 1));
		students.add(new Student(4L, "Obi","Van", "KNTу-24-1","+381234567890","qwerty@gmail.com", 2));
		students.add(new Student(5L, "Andriy","Shevchenko", "KNT-23-3","+381234567890","qwerty@gmail.com", 3));
		conferences.add(new Conference(1L, "Robotics", "International", "Online", new Date(2024,12,12), new Date(2024,12,12)));
		conferences.add(new Conference(2L, "Science", "Local", "Offline", new Date(2024,12,12), new Date(2024,12,12)));
		conferences.add(new Conference(3L, "Electronics", "Local", "Offline", new Date(2024,12,12), new Date(2024,12,12)));
		conferences.add(new Conference(4L, "Technologies", "International", "Offline", new Date(2024,12,12), new Date(2024,12,12)));
		conferences.add(new Conference(5L, "Artificial Intelligence", "Local", "Online", new Date(2024,12,12), new Date(2024,12,12)));
		publications.add(new Publication(1L, "Electronics", "Mike Tyson", "2024.04.34522", "Scopus", new Date(2024,12,12)));
		publications.add(new Publication(2L, "Robotics", "Jeff Fury", "2024.05.25332", "NURE Newspaper", new Date(2024,10,22)));
		publications.add(new Publication(3L, "Spaceships", "Mike Tyson", "2024.07.23533", "Researcher", new Date(2023,4,30)));
		publications.add(new Publication(4L, "Science", "Obi Van", "2024.12.45735", "A-BA-BA-GA-LA-MA-GA", new Date(2024,1,25)));
		publications.add(new Publication(5L, "Technologies", "Andriy Shevchenko", "2024.01.21442", "NURE Newspaper", new Date(2024,12,10)));
		abstracts.add(new Abstract(1L, "Robotics", "Dart Vader", "Technologies"));
		abstracts.add(new Abstract(2L, "Science", "Andriy Shevchenko", "Science"));
		abstracts.add(new Abstract(3L, "Electronics", "Andriy Shevchenko", "Technologies"));
		abstracts.add(new Abstract(4L, "Technologies", "Mike Tyson", "Electronics"));
		abstracts.add(new Abstract(5L, "Artificial Intelligence", "Obi Van", "Artificial Intelligence"));
		researchAdvisors.add(new ResearchAdvisor(1L, "Saul", "Goodman", "+381234567890", "saul.goodman@nure.ua", "Computer Science", 0));
		researchAdvisors.add(new ResearchAdvisor(2L, "Walter", "White", "+381234567890", "walter.white@nure.ua", "Computer Engineering and Control", 4));
		researchAdvisors.add(new ResearchAdvisor(3L, "James", "McGill", "+381234567890", "james.mcgill@nure.ua", "Computer Science", 2));
		researchAdvisors.add(new ResearchAdvisor(4L, "Luk", "Skywalker", "+381234567890", "luk.skywalker@nure.ua", "Computer Engineering and Control", 1));
		researchAdvisors.add(new ResearchAdvisor(5L, "Bilbo", "Baggings", "+381234567890", "bilbo.baggings@nure.ua", "Computer Science", 3));
		groups.add(new Group(1L, "KNT-23-4", "Computer Science and Technologies", "Computer Science", "Computer Science","Master"));
		groups.add(new Group(2L, "KNT-23-3", "Computer Science and Technologies", "Computer Science", "Computer Science","Bachelor"));
		groups.add(new Group(3L, "KNT-23-2", "Cyber security and information protection", "Computer Engineering and Control", "Cyber security and information protection","Master"));
		groups.add(new Group(4L, "KNT-23-1", "Cyber security and information protection", "Computer Engineering and Control", "Cyber security and information protection","Bachelor"));
		groups.add(new Group(5L, "KNTу-24-1", "Computer Science and Technologies", "Computer Science", "Computer Science","Bachelor"));
		publishers.add(new Publisher(1L, "Scopus", "Q1", "United States of America"));
		publishers.add(new Publisher(2L, "NURE Newspaper", "Q2", "Ukraine"));
		publishers.add(new Publisher(3L, "Researcher", "Q1", "France"));
		publishers.add(new Publisher(4L, "A-BA-BA-GA-LA-MA-GA", "Q3", "Ukraine"));
		faculties.add(new PrimaryParameter(1L, "Computer Science"));
		faculties.add(new PrimaryParameter(2L, "Computer Engineering and Control"));
		conferenceTypes.add(new PrimaryParameter(1L,"International"));
		conferenceTypes.add(new PrimaryParameter(2L,"Local"));
		conferenceStates.add(new PrimaryParameter(1L, "Online"));
		conferenceStates.add(new PrimaryParameter(2L, "Offline"));
		educationalPrograms.add(new PrimaryParameter(1L, "Computer Science and Technologies"));
		educationalPrograms.add(new PrimaryParameter(2L, "Cyber security and information protection"));
		countries.add(new PrimaryParameter(1L,"United States of America"));
		countries.add(new PrimaryParameter(2L,"Ukraine"));
		countries.add(new PrimaryParameter(3L,"France"));
		quartiles.add(new PrimaryParameter(1L, "Q1"));
		quartiles.add(new PrimaryParameter(2L, "Q2"));
		quartiles.add(new PrimaryParameter(3L, "Q3"));
		quartiles.add(new PrimaryParameter(4L, "Q4"));
		workTypes.add(new PrimaryParameter(1L, "Publication"));
		workTypes.add(new PrimaryParameter(2L, "Abstract"));
	}
			
			
	@Override
	public void addStud(Student stud, Long groupID) {
		for (Group group : groups) {
			if (group.getId().equals(groupID)) {
				stud.setGroup(group.getNumber());
                students.add(stud);
                break;
            }
		}
	}

	@Override
	public void addPublication(Publication publication, Long workUniqueID, Long publisherID, Long authorID, Long advisorID, Long conUniqueID) {
		for (Student stud : students) {
            if (stud.getId().equals(authorID)) {
				publication.setAuthor(stud.getName() + ' ' + stud.getSurname());
				stud.setNumberOfWorks(stud.getNumberOfWorks() + 1);
				for(ResearchAdvisor advisor: researchAdvisors){
					if(advisor.getId().equals(advisorID)){
						advisor.setNumberOfWorks(advisor.getNumberOfWorks() + 1);
						for(Publisher publisher: publishers){
							if(publisher.getId().equals(publisherID)){
								publication.setPublisher(publisher.getName());
								publications.add(publication);
								break;
							}
						}
					}
				}
            }
        }
	}

	@Override
	public void addAbstract(Abstract anAbstract, Long authorID, Long advisorID, Long conferenceID, Long conUniqueID) {
		for(Student stud: students){
			if(stud.getId().equals(authorID)){
                anAbstract.setAuthor(stud.getName() + ' ' + stud.getSurname());
				stud.setNumberOfWorks(stud.getNumberOfWorks() + 1);
				for(ResearchAdvisor advisor: researchAdvisors){
					if(advisor.getId().equals(advisorID)){
                        advisor.setNumberOfWorks(advisor.getNumberOfWorks() + 1);
						for(Conference conference: conferences){
							if(conference.getId().equals(conferenceID)){
								anAbstract.setConferenceName(conference.getName());
								abstracts.add(anAbstract);
								break;
							}
						}
                    }
				}
            }
		}
	}

	@Override
	public void addConference(Conference conference, long typeID, long stateID) {
		for(PrimaryParameter type: conferenceTypes){
			if(type.getId().equals(typeID)){
				conference.setType(type.getName());
				for(PrimaryParameter state: conferenceStates){
					if(state.getId().equals(stateID)){
                        conference.setState(state.getName());
                        conferences.add(conference);
                        break;
                    }
				}
			}
		}
	}

	@Override
	public void addAdvisor(ResearchAdvisor advisor, Long facultyID) {
		for(PrimaryParameter faculty: faculties){
            if(faculty.getId().equals(facultyID)){
                advisor.setFaculty(faculty.getName());
                researchAdvisors.add(advisor);
                break;
            }
        }
	}

	@Override
	public void addGroup(Group group, Long facultyID, Long programID) {
		for(PrimaryParameter faculty: faculties){
            if(faculty.getId().equals(facultyID)){
                group.setFaculty(faculty.getName());
                for(PrimaryParameter program: educationalPrograms){
                    if(program.getId().equals(programID)){
                        group.setEducationalProgram(program.getName());
                        groups.add(group);
                        break;
                    }
                }
            }
        }
	}

	@Override
	public void addPublisher(Publisher publisher, Long quartileID, Long countryID) {
		for(PrimaryParameter quartile: quartiles){
            if(quartile.getId().equals(quartileID)){
                publisher.setQuartile(quartile.getName());
                for(PrimaryParameter country: countries){
                    if(country.getId().equals(countryID)){
                        publisher.setCountry(country.getName());
                        publishers.add(publisher);
                        break;
                    }
                }
            }
        }
	}

	@Override
	public void deleteObject(String tableName, String paramName, long ID) {
		switch (tableName) {
			case "Students": {
				students = students.stream()
						.filter(stud -> stud.getId() != ID)
						.collect(Collectors.toList());
				break;
			}
			case "Publications": {
				publications = publications.stream()
						.filter(pub -> pub.getId() != ID)
						.collect(Collectors.toList());
				break;
			}
			case "ScientificWorks": {
				abstracts = abstracts.stream()
						.filter(work -> work.getId() != ID)
						.collect(Collectors.toList());
				break;
			}
			case "Conferences": {
				conferences = conferences.stream()
						.filter(conference -> conference.getId() != ID)
						.collect(Collectors.toList());
				break;
			}
			case "ResearchAdvisors": {
				researchAdvisors = researchAdvisors.stream()
						.filter(advisor -> advisor.getId() != ID)
						.collect(Collectors.toList());
				break;
			}
			case "`groups`": {
				groups = groups.stream()
						.filter(group -> group.getId() != ID)
						.collect(Collectors.toList());
				break;
			}
			case "Publishers": {
				publishers = publishers.stream()
						.filter(publisher -> publisher.getId() != ID)
						.collect(Collectors.toList());
				break;
			}
			default: {
				System.out.println("Table not found: " + tableName);
				break;
			}
		}
	}

	@Override
	public void countWorks(CalculateForm calculateForm) {
		if (calculateForm == null) {
			throw new IllegalArgumentException("CalculateForm cannot be null");
		}

		String studentFullName = null;
		List<String> publisherNames = new ArrayList<>();

		// Find the student full name
		for (Student student : students) {
			if (student.getId().equals(calculateForm.getStudentID())) {
				studentFullName = student.getName() + " " + student.getSurname();
				break;
			}
		}

		if (studentFullName == null) {
			throw new IllegalArgumentException("Student with the given ID not found");
		}

		// Count abstracts authored by the student
		for (Abstract abstractStudent : abstracts) {
			if (abstractStudent.getAuthor().equals(studentFullName)) {
				calculateForm.setNumberOfAbstracts(calculateForm.getNumberOfAbstracts() + 1);
			}
		}

		// Collect publishers from publications authored by the student
		for (Publication publication : publications) {
			if (publication.getAuthor().equals(studentFullName)) {
				publisherNames.add(publication.getPublisher());
			}
		}

		// Count publications by quartile
		for (Publisher publisher : publishers) {
			if (publisherNames.contains(publisher.getName())) {
				switch (publisher.getQuartile()) {
					case "Q1":
						calculateForm.setNumberOfQ1(calculateForm.getNumberOfQ1() + 1);
						break;
					case "Q2":
						calculateForm.setNumberOfQ2(calculateForm.getNumberOfQ2() + 1);
						break;
					case "Q3":
						calculateForm.setNumberOfQ3(calculateForm.getNumberOfQ3() + 1);
						break;
					case "Q4":
						calculateForm.setNumberOfQ4(calculateForm.getNumberOfQ4() + 1);
						break;
					default:
						throw new IllegalArgumentException("Unknown quartile: " + publisher.getQuartile());
				}
			}
		}
	}


	@Override
	public List<Student> getAllStudents() { return students; }

	@Override
	public List<Conference> getAllConferences() {
		return conferences;
	}

	@Override
	public List<Publication> getAllPublications() {
		return publications;
	}

	@Override
	public List<Abstract> getAllAbstracts() {
		return abstracts;
	}

	@Override
	public List<ResearchAdvisor> getAllResearchAdvisors() {
		return researchAdvisors;
	}

	@Override
	public List<Group> getAllGroups() {
		return groups;
	}

	@Override
	public List<Publisher> getAllPublishers() {
		return publishers;
	}

	@Override
	public List<PrimaryParameter> getPrimaryParameter(String tableName, String paramName) {
		switch (tableName) {
			case "Faculties":
                return faculties;
            case "ConferenceTypes":
                return conferenceTypes;
            case "ConferenceStates":
                return conferenceStates;
            case "EducationalPrograms":
                return educationalPrograms;
            case "Countries":
                return countries;
            case "Quartiles":
                return quartiles;
            case "WorkTypes":
                return workTypes;
            default:
                return null;
		}
	}


	@Override
	public Long getUniqueID(String tableName, String paramName) {
		AtomicLong uniqueID = new AtomicLong(1);

		while (true) {
			boolean idExists;

			switch (tableName) {
				case "Students": {
					idExists = students.stream().anyMatch(student -> Objects.equals(student.getId(), uniqueID.get()));
					break;
				}
				case "Publications": {
					idExists = publications.stream().anyMatch(publication -> Objects.equals(publication.getId(), uniqueID.get()));
					break;
				}
				case "ScientificWorks": {
					idExists = abstracts.stream().anyMatch(work -> Objects.equals(work.getId(), uniqueID.get()));
					break;
				}
				case "Conferences": {
					idExists = conferences.stream().anyMatch(conference -> Objects.equals(conference.getId(), uniqueID.get()));
					break;
				}
				case "ResearchAdvisors": {
					idExists = researchAdvisors.stream().anyMatch(advisor -> Objects.equals(advisor.getId(), uniqueID.get()));
					break;
				}
				case "`groups`": {
					idExists = groups.stream().anyMatch(group -> Objects.equals(group.getId(), uniqueID.get()));
					break;
				}
				case "Publishers": {
					idExists = publishers.stream().anyMatch(publisher -> Objects.equals(publisher.getId(), uniqueID.get()));
					break;
				}
				default: {
					System.out.println("Table not found: " + tableName);
					return uniqueID.get();
				}
			}

			if (!idExists) {
				return uniqueID.get(); // Found a unique ID
			}

			uniqueID.incrementAndGet(); // Increment and check the next ID
		}
	}
}
