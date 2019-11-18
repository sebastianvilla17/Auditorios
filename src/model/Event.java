package model;
import model.Auditorium;
import java.util.ArrayList;
import java.time.*; 
import java.time.format.*;

public class Event{
	
	private String name="";
	private LocalDateTime dateStar ;
	private LocalDateTime dateFinal;
	private String teacherName="";
	private String facultyName="";
	private int cantPeople;
	ArrayList<String> auditoriums= new ArrayList<String>();
	String audiTmp;
	
	/** Event
	*<p> desc:</p> This method serves to assign a value to
	*the attributes of the class
	*
	*@return this method has no return
	*/
	public Event(String nameAuditorium, String name, LocalDateTime dateStar, LocalDateTime dateFinal, String teacherName, String facultyName, int cantPeople){
		
		this.name= name;
		this.dateStar= dateStar;
		this.dateFinal= dateFinal;
		this.teacherName= teacherName;
		this.facultyName= facultyName;
		this.cantPeople= cantPeople;
		auditoriums.add(nameAuditorium);
		
	}
	
	/**getName
	*<p> desc:</p> This method allows access to the
	*name private attribute
	*
	*@return this method returns the 
	*attribute of type String
	*/
	public String getName(){
		
		return name;
	}
	
	
	/**dateStar
	*<p> desc:</p> This method allows access to the
	*name private attribute
	*
	*@return this method returns the 
	*attribute of type LocalDateTime
	*/
	public LocalDateTime getDateStar(){
		
		return dateStar;
	}
	
	/**dateFinal
	*<p> desc:</p> This method allows access to the
	*name private attribute
	*
	*@return this method returns the 
	*attribute of type LocalDateTime
	*/
	public LocalDateTime getDateFinal(){
		
		return dateFinal;
	}
	/**getTeacherName
	*<p> desc:</p> This method allows access to the
	*name private attribute
	*
	*@return this method returns the 
	*attribute of type String
	*/
	public String getTeacherName(){
		
		return teacherName;
	}
	
	/**getFacultyName
	*<p> desc:</p> This method allows access to the
	*name private attribute
	*
	*@return this method returns the 
	*attribute of type String
	*/
	public String getFacultyName(){
		
		return facultyName;
	}
	
	/**getCantPeople
	*<p> desc:</p> This method allows access to the
	*name private attribute
	*
	*@return this method returns the 
	*attribute of type int
	*/
	public int getCantPeople(){
		
		return cantPeople;
	}
	
	
}