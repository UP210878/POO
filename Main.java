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
        LocalDate currentDate = LocalDate.now();
		int currentMonth=currentDate.getMonthValue();
		int currentDay=currentDate.getDayOfMonth();
        int currentYear = currentDate.getYear();
		int monthOfBirth=1;
		int dayOfBirth=1;
        int ageInMonth=0;
        int ageInDays=0;
        int ageInYears=0;
		//Year Input
		do{
		    try {
    		    System.out.print("Input the year of birth (YYYY)");
    		    yearOfBirth = input.nextInt();
    		    if (yearOfBirth > currentYear){
    		        throw new Main("Value must be before current year");
		    }
		    else
		        {
		            if(yearOfBirth % 4 == 0 && yearOfBirth % 100 != 0){
		                daysInMonth[1] = 29; 
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
		    }else if (monthOfBirth>currentMonth && yearOfBirth == currentYear){
		        throw new Main("Value can't be above current month while the year of birth is the same as the current year");
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
		int maximumDaysInPreviousMonth = 1;
		if (monthOfBirth>=2){
		    maximumDaysInPreviousMonth = daysInMonth[monthOfBirth-2];
		}else {
		    maximumDaysInPreviousMonth = daysInMonth[11];
		}
		
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
		
        ageInYears = currentYear - yearOfBirth;
		if (monthOfBirth > currentMonth){
			ageInYears = ageInYears -1;
			ageInMonth = 12 + (currentMonth - monthOfBirth);
		}
		else if (monthOfBirth < currentMonth) {
			ageInMonth = currentMonth - monthOfBirth;
		}
		if (dayOfBirth > currentDay){
			ageInDays = maximumDaysInPreviousMonth - (dayOfBirth - currentDay);
			ageInMonth = ageInMonth-1;
		} else if (dayOfBirth <= currentDay){
			ageInDays = currentDay - dayOfBirth;
		}
		if (monthOfBirth==currentMonth) {
			if (dayOfBirth>currentDay) {
				ageInMonth = 11;
				ageInYears = ageInYears-1;
			}
			else if (dayOfBirth<=currentDay) {
				ageInMonth = 0;
			}
		}
		System.out.println("Days: " + ageInDays + "\nMonth: "+ ageInMonth + "\nYear:" + ageInYears);
        input.close();
	}
}
