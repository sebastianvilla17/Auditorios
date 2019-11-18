package ui;

import java.util.Scanner;
import model.University;
import model.Auditorium;
import java.time.*; 
import java.time.format.*; 

public class Main {
	
	private static Scanner reader;
	private static Scanner options;
	private static University icesi;
	private static Auditorium auditorium;
	
	/**Main
	*<p> desc:</p> This method is responsible for interacting with the user 
	*by presenting in the options menu and according to the option chosen to ask 
	*the necessary requirements. at the same time, it makes the necessary validations
	*and according to this it throws an error or takes it to the corresponding method
	*
	*/
		public static void main (String []args){
		
	
		reader= new Scanner(System.in);
		options= new Scanner(System.in);
		String reporte;
		String event;
		String starTime;
		String finalTime;
		String starDate;
		String finalDate;
		String auditorium;
		String nameEvent;
		String teacher;
		String faculty;
		int canPeople;
		int posX;
		int posY;
		String description;
		String defective;
		int option;
		int rows;
		int columns;
		boolean fine;
		String audiName;
		char statusAudi;
		icesi= new University ("icesi");
		int[] numberChairsByRow;
		init();
		do{
		System.out.println("Which action do you want to do \n"+"1 create auditorium\n"+ "2 report defective chair\n"+ 
		"3 create event\n"+ "4 percentage defective chairs\n"+ "5 report of the state of the chairs of an auditorium");
		option= options.nextInt();
		
		switch(option){
			
					case 1:
					
					do{
					System.out.println ("enter auditorium name");
					audiName= reader.next().toLowerCase();
					fine= icesi.onlyName(audiName);
					}while (fine== true);
					
					System.out.println ("enter the auditorium status, where 'B' is occupied and 'F' is free");
					statusAudi= reader.next().charAt(0);
						
					System.out.println ("Enter the number of rows of chairs you want");
					rows= reader.nextInt();
					
					numberChairsByRow = new int[rows];
					
					for (int r=0; r<rows; r++)
					{
						System.out.println ("Enter the number of chairs for the row: "+r);
						columns = reader.nextInt();
						numberChairsByRow[r] = columns;
					}
					
					String create= icesi.createAuditorium(audiName, statusAudi, numberChairsByRow);
					System.out.println(create);
					
					break;
					
					case 2:
					
					System.out.println ("Enter the name of the auditorium where the chair will be reported");
					auditorium= reader.next().toLowerCase();
					
					System.out.println ("enter the row in which the chair is");
					posX= reader.nextInt();
					
					System.out.println ("enter the column in which the chair is");
					posY= reader.nextInt();
					
					System.out.println ("enter the description of the damage");
					description= reader.next();
					
					defective= icesi.defectiveChairReportofAuditorium(auditorium, description, posX,  posY);
					
					System.out.println ("///////////");
					System.out.println (defective);
					break;
					
					case 3:
					do{
					System.out.println ("enter the name of the auditorium where the event is going to take place");
					auditorium= reader.next().toLowerCase();
					
					System.out.println ("Do you need another auditorium? \n "+" 1 no \n "+" 2 yes ");
					option= options.nextInt();
					}while (option== 2);
					
					System.out.println ("enter the name of the event to be performed");
					nameEvent= reader.next().toLowerCase();
					
					System.out.println ("enter the name of the teacher responsible for the event");
					teacher= reader.next().toLowerCase();
					
					System.out.println ("enter the name of the faculty responsible for the event");
					faculty= options.next().toLowerCase();
					
					System.out.println ("enter the event start date in yyyy-MM-dd formatand ");
					starDate= reader.next();
					
					System.out.println ("enter the event start time  without minutes(hh)");
					starTime= reader.next();
					LocalDateTime dateStar = LocalDateTime.parse(starDate+"T"+ starTime + ":00");
					
					System.out.println ("enter the event final date in yyyy-MM-dd format");
					finalDate= reader.next();
					
					System.out.println ("enter the event final without minutes( hh)");
					finalTime= reader.next();
					LocalDateTime dateFinal = LocalDateTime.parse(finalDate+"T"+ finalTime + ":00");
					
					System.out.println ("Enter the number of people attending the event ");
					canPeople= reader.nextInt();
					
					event= icesi.validations(auditorium, nameEvent, dateStar, dateFinal, teacher, faculty, canPeople);
					//event = icesi.createEvent(auditorium, nameEvent, dateStar, dateFinal, teacher, faculty, canPeople);
					
					System.out.println(event);
					break;
					
					case 4:
					int porcent=0;
					
					System.out.println ("enter the name of the auditorium for which you want the report");
					auditorium= reader.next().toLowerCase();
					
					porcent= icesi.porcentDefective(auditorium);
					
					System.out.println (porcent);
					
					break;
					
					case 5: 
					
					System.out.println ("enter the name of the auditorium for which you want the report");
					auditorium= reader.next().toLowerCase();
					
					reporte= icesi.reportChairsAudi(auditorium);
					
					System.out.println (reporte);
					break;
					
					}		
					System.out.println ("you want to return to the menu \n" + "1 yes\n" + "2 no");
					option= options.nextInt();
					}
					while (option==1);
					} 

	
	/** init
	*<p> desc:</p> This method contains the 
	*pre-determined information to be used in tests
	*
	*/
	public static void init(){
		int[] numberChairsByRow;
		String audiName= "manuelita";
		char statusAudi= 'F';
		int rows = 5;
		numberChairsByRow = new int[rows];
		numberChairsByRow[0] = 12;
		numberChairsByRow[1] = 7;
		numberChairsByRow[2] = 9;
		numberChairsByRow[3] = 8;
		numberChairsByRow[4] = 11;
		String create= icesi.createAuditorium(audiName, statusAudi, numberChairsByRow);
		
		String nameAudi= "manuelita";
		String name= "asus";
		String starDate= "2019-12-12";
		String starTime= "10";
		LocalDateTime dateStar = LocalDateTime.parse(starDate+"T"+ starTime + ":00");
		String finalDate= "2019-12-12";
		String finalTime= "15";
		LocalDateTime dateFinal = LocalDateTime.parse(finalDate+"T"+ finalTime + ":00");	
		String teacherName= "harold";
		String facultyName= "medicina";
		int cantPeople= 150;
		String event = icesi.createEvent(nameAudi, name, dateStar, dateFinal, teacherName, facultyName, cantPeople);
	}
	
	
	
}