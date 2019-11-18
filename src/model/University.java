package model; 

import java.util.ArrayList;
import java.time.*; 
import java.time.format.*; 
import model.Event;

public class University{
	
	private String nameU;
	String message;
	
	
	/** University
	*<p> desc:</p> This method serves to assign a value to
	*the attributes of the class
	*
	*@return this method has no return
	*/
	public University(String nameU){
		
		this.nameU= nameU;
	}
	
	ArrayList<Auditorium> auditoriums = new ArrayList<Auditorium>();
	Auditorium audiTmp;
	
	ArrayList<Event> events = new ArrayList<Event>();
	Event eventTmp;
	
	/**createAuditorium
	*<p> desc:</p> This method is responsible for taking the data 
	*entered by the user, creating an object and adding a list
	*
	*@param statusAuditorium, only one uppercase character must be entered
	*
	*@return this method returns this method returns a message confirming 
	*that the object was created*/
	public String createAuditorium (String nameAuditorium, char statusAuditorium, int[] numberChairsByRow){
		
		String message;
		
		audiTmp= new Auditorium(nameAuditorium,statusAuditorium, numberChairsByRow);
		auditoriums.add (audiTmp);
		 
		return message="the Auditorium was created";
	}
	
	public String reportChairsAudi(String name){
		String reporte="";
		
		for(int i=0; i< auditoriums.size(); i++){
			if(auditoriums.get(i).getNameAuditorium().equals(name)){
			reporte= auditoriums.get(i).reportChairs();
			}
		}
		return reporte;
	}
	
	/**defectiveChairReportofAuditorium
	*<p> desc:</p> This method verifies that the name of the created
	*auditorium is valid and sends the information to another method 
	*to generate the report of a damaged chair.
	*
	*@param description, the description of the damage must be concrete 
	*and in lower case
	*
	*@return this method returns this method returns a message confirming 
	*that the report was created*/
	public String defectiveChairReportofAuditorium(String auditorium, String description, int posX, int posY){
		
		for(int i = 0; i<auditoriums.size(); i++)
		{
			String NameAudi = auditoriums.get(i).getNameAuditorium();
			if(NameAudi.equals(auditorium)){
				
				message= auditoriums.get(i).defectiveChairReport(description, posX, posY);
			}	
			else{
				message= "not found auditorium";
			}
		}
		return message;
	}
	
	/**validations
	*<p> desc:</p> This method validates that in the auditorium entered 
	*there is no other event scheduled, comparing the dates and times of
	*these
	*
	*
	*@return this method returns a message if the event was created or not*/
	public String validations(String nameAuditorium, String name, LocalDateTime dateStar, LocalDateTime dateFinal, String teacherName, String facultyName, int cantPeople){
		String message="";
		
		for (int i=0; i<events.size(); i++){
			if (events.get(i).getDateStar().compareTo(dateStar)==0 || events.get(i).getDateFinal().compareTo(dateFinal)==0){
				message="event not created";
			}
			else{
				for(int j=0; j<auditoriums.size(); j++){
					if(auditoriums.get(j).getNameAuditorium().equals(nameAuditorium)){
						
						auditoriums.get(j).setStatusAuditorium('B');
					}
				}
				message= createEvent(nameAuditorium, name, dateStar, dateFinal, teacherName, facultyName, cantPeople);
			}
		}
		
		return message;
	}
	
	/**createEvent
	*<p> desc:</p> This method is responsible for taking the data 
	*entered by the user, creating an object and adding a list
	*
	*@return  returns this method returns a message confirming 
	*that the object was created*/
	public String createEvent(String nameAuditorium, String name, LocalDateTime dateStar, LocalDateTime dateFinal, String teacherName, String facultyName, int cantPeople){
		
		String event="the event was created";
		
		eventTmp= new Event(nameAuditorium, name, dateStar, dateFinal, teacherName, facultyName, cantPeople);
		events.add(eventTmp);
		
		return event= "the event was created";
	}
	
	/**porcentDefective
	*<p> desc:</p> This method confirms that the name of the auditorium 
	*belongs to an existing one and at the same time sends the information 
	*to a method that performs the validation
	*
	*@returnthis method refills an int type value that refers to the 
	*percentage of damaged chairs*/
	public int porcentDefective(String nameAudi){
		int porcent=0;
		for(int i=0; i< auditoriums.size(); i++){
			if(auditoriums.get(i).getNameAuditorium().equals(nameAudi)){
			porcent= auditoriums.get(i).percentageofdefectivechairs();
			} 
		}
		return porcent;
	}
	
	/**onlyName
	*<p> desc:</p> This method receives a name entered with
	*the user to validate that it is not on the list and otherwise
	*request the name again. All this is done after a tour of the 
	*list comparing the existing names with the one entered
	*
	*@return the method returns a boolean that confirms 
	*whether the name was repeated or not
	*/
	public boolean onlyName(String nameAuditorium){
			boolean correctN= false;
			
			for(int i = 0; i<auditoriums.size(); i++)
		{
			String NameAudi = auditoriums.get(i).getNameAuditorium();
			if(NameAudi.equals(nameAuditorium)){
				 
				correctN= true;
				
				return correctN;
			}
			else {
				correctN= false;
				return correctN;
			}
		
		}
			return correctN;
	}
}