package model;
import model.Chair;


public class Auditorium{
	
	private static Chair chair;
	private String  nameAuditorium="";
	private char statusAuditorium;
	public static char BUSY= 'B';
	public static char FREE= 'F';
	private int columns;
	private int rows;
	private static Chair[][] chairs;

	
	/** Auditorium
	*<p> desc:</p> This method serves to assign a value to
	*the attributes of the class
	*
	*@return this method has no return
	*/
	public Auditorium (String nameAuditorium, char statusAuditorium, int[] numberChairsByRow){
		int maxNumberChairs=0;
		int numberChairs=0;
		this.statusAuditorium= statusAuditorium;
		this.nameAuditorium= nameAuditorium;
		
		for(int r=0; r< numberChairsByRow.length; r++)
		{
			if (maxNumberChairs < numberChairsByRow[r]) maxNumberChairs = numberChairsByRow[r];
		}
		
		chairs = new Chair[numberChairsByRow.length][maxNumberChairs];
		
		for(int r=0; r< numberChairsByRow.length; r++)
		{
			numberChairs = numberChairsByRow[r];
			
			for(int c=0;c<numberChairs; c++)
			{
				chairs[r][c] = new Chair();
			}
		}
				
	}
	
	/**percentageofdefectivechairs
	*<p> desc:</p> This method runs through the matrix and takes from each
	*one the state in which it is found and for each damaged chair one is
	*added to the counter and also to the total of the chair to generate 
	*a percentage operation
	*
	*@return this method returns this method returns a data corresponding 
	*to the calculated percentage of type it*/
	public int percentageofdefectivechairs(){
		int porcent=0;
		int defective=0;
		int total=0;
		
		for(int i=0; i<chairs.length; i++){
			for(int j=0; j< chairs[i].length; j ++){
				if(chairs[i][j]!= null){
				if (chairs[i][j].getStatus()== 'O'){
					total+=1;
				}
				else if (chairs[i][j].getStatus()== 'D'){
					total+=1;
					defective+=1;
				}
				}
			}
		}
		porcent= total*defective/100;
		return porcent;
	}
	
	/**reportChairs
	*<p> desc:</p> this method goes through the matrix and takes
	*its status to generate a report
	*
	*@return a estring returns with the report of each chair*/
	public String reportChairs(){
		String report="";
		
		for(int i=0; i<chairs.length; i++){
			for(int j=0; j< chairs[i].length; j ++){
				if(chairs[i][j]!= null){
			report+= " Status  "+chairs[i][j].getStatus()+"--";
				}
			}
		}
		return report;
	}
	
	/**defectiveChairReport
	*<p> desc:</p> this method accesses the private attributes
	*of the chair and generates the report
	*
	*@param description, the description of the damage must be concrete 
	*and in lower case
	*
	*@return this method returns this method returns a message confirming 
	*that the report was created*/
	public String defectiveChairReport(String description, int posX, int posY){
		
		String message;
		chairs [posX][posY].setStatus('D');  
		chairs [posX][posY].setDescription(description);
		
		return message=("the damage was reported");
		
	}
	
	/** getNameAuditorium
	*<p> desc:</p> This method allows access to the
	*name private attribute
	*
	*@return this method returns the 
	*attribute of type String
	*/
	public String getNameAuditorium(){
		
		return nameAuditorium;
	}
	
	/**setStatusAuditorium
	*<p> desc:</p> This method allows you to 
	*modify one of the attributes of the class
	*
	*/
	public void setStatusAuditorium(char statusAuditorium){
		
		this.statusAuditorium= statusAuditorium;
	}
	
	/** getStatusAuditorium
	*<p> desc:</p> This method allows access to the
	*name private attribute
	*
	*@return this method returns the 
	*attribute of type String
	*/
	public char getStatusAuditorium(){
		
		return statusAuditorium;
	}
}