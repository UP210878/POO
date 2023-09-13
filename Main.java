//ENTRADA DEL SISTEMA: Pedir a usuario Año, Mes, Dia de Nacimiento
//SALIDA DEL SISTEMA: Edad en formato: "La persona tiene (x) años, (y) meses y (z) dias de edad"
import java.util.*;
import java.time.LocalDate;


public class Main extends Exception
{
    private String errorText;
	
	public Main(String errorText){
	    this.errorText = errorText;
	}
	
	@Override
	public String getMessage()
	{
	    return "MyException: Exception type: " + errorText;
	}
	
	
	public static void main(String[] args) {
	    int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		Scanner input = new Scanner(System.in);
		int yearOfBirth=1;
		boolean continueCycle = true;
		boolean leapYear = false;
		int monthOfBirth=1;
		int dayOfBirth=1;
		//Year Input
		do{
		    LocalDate current_date = LocalDate.now();
            int current_Year = current_date.getYear();
		    try {
    		    System.out.print("Input the year of birth (YYYY)");
    		    yearOfBirth = input.nextInt();
    		    if (yearOfBirth > current_Year){
    		        throw new Main("Value must be before current year");
		    }
		    else
		        {
		            if(yearOfBirth % 4 == 0 || yearOfBirth % 400 == 0){
		                leapYear = true;
		            }
		            continueCycle = false;
		            
		        }
		    }
		    
    		catch(InputMismatchException ex){
    		    System.out.println("The value must be an integer");
    		    input.nextLine();
    		}
    		catch(Main ex){
    		    System.out.println(ex.getMessage());
    		}
		}while (continueCycle);
		//Month input
		continueCycle = true;
		do{
		    try {
    		    System.out.print("Input the month of birth (MM)");
    		    monthOfBirth = input.nextInt();
    		    if (monthOfBirth > 12 || monthOfBirth <= 0){
    		        throw new Main("Value must be between 1 and 12");
		    }
		    else
		        {
		            continueCycle = false;
		        }
		    }
    		catch(InputMismatchException ex){
    		    System.out.println("The value must be an integer");
    		    input.nextLine();
    		}
    		catch(Main ex){
    		    System.out.println(ex.getMessage());
    		}
		}while (continueCycle);
		//Day input
		continueCycle = true;
		int maximumDaysInMonth = daysInMonth[monthOfBirth-1];
		do{
		    try {
    		    System.out.print("Input the day of birth (DD)");
    		    dayOfBirth = input.nextInt();
    		    if (dayOfBirth > maximumDaysInMonth || dayOfBirth <= 0){
    		        throw new Main("Value must be between a valid day between 0 and " + maximumDaysInMonth);
		    }
		    else
		        {
		            continueCycle = false;
		        }
		    }
    		catch(InputMismatchException ex){
    		    System.out.println("The value must be an integer");
    		    input.nextLine();
    		}
    		catch(Main ex){
    		    System.out.println(ex.getMessage());
    		}
		}while (continueCycle);
		
	}
}
