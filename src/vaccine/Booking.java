package vaccine;

import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;

public class Booking
{
	static int count = 0;
	static Vaccination vaccination = new Vaccination();
	static Details details = new Details();
	static List<Vaccine> vaccines=new LinkedList<>();
	static List<String> bookingHistory = new ArrayList<>();
	static Map<String,Integer> vaccinationTimiSlot = new HashMap<>();
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		//Welcome statement
		System.out.println("Welcome to Online Booking Portal.. Have a healthy Life !!! ");
		OUTER:while(true)
		{
		//Options available in the system
		System.out.println("Choose Your Option: A)Admin B)People C)BookingHistory");
		char adminOrPatient = sc.next().charAt(0);
		switch(adminOrPatient)
		{
		//Admin login
		case 'A':
		{
			System.out.println("Enter Admin ID:");
			//Get admin id
			String adminId = sc.next();
			System.out.println("Enter Admin Password:");
			//Get admin password
			String adminPassword = sc.next();
			Admin admin=new Admin(adminId,adminPassword);
			//check whether admin id and password is correct
			if(admin.validateAdmin(adminId,adminPassword))
			{
				//If admin validated successfully this message will be printed
				System.out.println("Admin Validated Successfully");

				//If admin loggedin successfully this message will be printed
				System.out.println("Please Enter the Details of Vaccines Available!!!");
				//Get vaccine details
				details.getVaccineDetails(vaccines);
			}
			else
			  //If admin is not validated successfully this message will be printed
				System.out.println("Admin Credentials are not valid");
		}
		case 'B':
		{
			INNER:while(true)
			{
				  //Ask whether want to book a vaccine or not
			    System.out.println("Do you want to book a vaccine? Y / N");
					char entryOption = sc.next().charAt(0);
			    count = 0;
			    if(entryOption == 'y'||entryOption == 'Y')
			    {
						//If yes get vaccine booking count
			    	System.out.println("\nEnter number of Bookings to be done: ");
			    	int numberofBookings = sc.nextInt();
			    	while(numberofBookings-- > 0)
			    	{
			    		System.out.println("Booking Number: "+(count+1));
			    		if(addBooking(sc)==false)
			    		continue INNER;
			    		count++;
			    	}
			    }
					//If no throw a message
			    else if(entryOption == 'N'||entryOption == 'n')
			    {
				    System.out.println("Thanks for your service!!!. Get vaccine soon..");
						//Print vaccination booking history
				    System.out.println("Your Booking History is Listed Below\n");
						//Call booking history function
				    BookingHistory();
				    break INNER;
			    }
			    else
					//If user inserted a invalid option this error message will occur
			    {
			        System.out.println("Your Option is INVALID, Please Enter a valid Option!!!");
			        continue INNER;
			    }
			}
			break OUTER;
		}
		case 'C':
		{
			//Call booking history function
			BookingHistory();
			break OUTER;
		}
		default:
		{
			//If user inserted a invalid option this error message will occur
			System.out.println("Your Option is INVALID, Please Enter a valid Option!!!");
			continue OUTER;
		}
		}
		}
	}

	public static boolean addBooking(Scanner sc)
	{
		if(details.getPatientDetails(vaccines,bookingHistory))
			return true;
		return false;
	}

  //Booking history function
	public static void BookingHistory()
	{
		count = 0;
		for(String history:bookingHistory)
		{
			System.out.println("Booking "+(count+1)+": "+history);
			count++;
		}
	}
}
