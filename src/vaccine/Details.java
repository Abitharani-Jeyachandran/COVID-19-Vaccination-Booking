package vaccine;

import java.util.List;
import java.util.Scanner;

public class Details
{
	static int numberOfVaccine = 0;
	public void getVaccineDetails(List<Vaccine> vaccines)
	{
		Scanner sc = new Scanner(System.in);
		//Get no of vaccines
		System.out.println("\nEnter Number Of Vaccines:");
		numberOfVaccine=sc.nextInt();
		for(int index = 1;index <= numberOfVaccine;index++)
		{
			Vaccine vaccine=new Vaccine();
			//Get type of vaccine
			System.out.println("Enter Type of Vaccine    1)Sinaform / 2)Delta / 3)PFizer");
			String type=sc.next();
			//Check whether vaccine type available
			vaccine.vaccineType=type;
			//Enter date when vaccine will available
			System.out.println("Enter the day in which Vaccine will be available");
			String day=sc.next();
			vaccine.vaccinationAvailableDay=day;
			//Enter number of time slots when vaccine will available
			System.out.println("Enter the number of slots,the Vaccine will be available");
			int slotNumber=sc.nextInt();
			for(int start = 1;start <= slotNumber;start++)
			{
				vaccine.availabilty.put(sc.next(),false);
			}
			vaccines.add(vaccine);
		}
	}
	public boolean getPatientDetails(List<Vaccine> vaccines,List<String> bookingHistory)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name:");
		//Get name who wants to take vaccinattion
		String patientName = sc.next();
        System.out.println("Enter the vaccine type:");
			//Get vaccinattion type
    	String vaccineType = sc.next();
	    System.out.println("Enter the date you wish to take vaccination: ");
			//Get vaccinattion date
 	    String day = sc.next();
	    System.out.println("Time of vaccination:");
			//Get vaccinattion time
	    String time = sc.next();
	    Vaccination appointment = new Vaccination();
			if(appointment.bookAppointemnt(vaccines,patientName,vaccineType,day,time,numberOfVaccine,bookingHistory))
	    	return true;
	    return false;
	}
}
