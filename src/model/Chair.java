package model; 

public class Chair{
	
	private char status = 'O';
	public static char OPERABLE= 'O';
	public static char DEFECTIVE= 'D';
	private String description="no damage on the chair";
	
	/** Chair
	*<p> desc:</p> This method serves to assign a value to
	*the attributes of the class
	*
	*@return this method has no return
	*/
	public Chair (){
		
		this.status= 'O';
		this.description= description;
	}
	
	/**getStatus
	*<p> desc:</p> This method allows access to the
	*name private attribute
	*
	*@return this method returns the 
	*attribute of type char
	*/
	public char getStatus(){
		
		return status;
	}
	
	/**setStatus
	*<p> desc:</p> This method allows you to 
	*modify one of the attributes of the class
	*
	*/
	public void setStatus(char status){
		
		this.status= status;
	}
	
	/** getStatus
	*<p> desc:</p> This method allows access to the
	*name private attribute
	*
	*@return this method returns the 
	*attribute of type String
	*/
	public String getDescription(){
		
		return description;
	}
	
	/**setDescription
	*<p> desc:</p> This method allows you to 
	*modify one of the attributes of the class
	*
	*/
	public void setDescription(String description){
		
		this.description= description;
	}

	}