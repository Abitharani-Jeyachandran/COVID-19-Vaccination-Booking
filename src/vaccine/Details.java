package vaccine;

import java.util.List;
import java.util.Scanner;

public class Details {
	static int numberOfVaccine = 0;

	public void getVaccineDetails(List<Vaccine> vaccines) {
		Scanner sc = new Scanner(System.in);
		// Get no of vaccines
		System.out.println("\nEnter Number Of Vaccines:");
		numberOfVaccine = sc.nextInt();
		for (int index = 1; index <= numberOfVaccine; index++) {
			Vaccine vaccine = new Vaccine();
			// Get type of vaccine
			System.out.println("Enter Type of Vaccine    1)Sinaform / 2)PFizer");
			String type = sc.next();
			// Check whether vaccine type available
			vaccine.vaccineType = type;
			// Enter date when vaccine will available
			System.out.println("Enter the day(DD/MM/YYYY) in which Vaccine will be available");
			String day = sc.next();
			vaccine.vaccinationAvailableDay = day;
			// Enter number of time slots when vaccine will available
			System.out.println("Enter the number of slots,the Vaccine will be available at [H:mm]");
			int slotNumber = sc.nextInt();
			for (int start = 1; start <= slotNumber; start++) {
				vaccine.availabilty.put(sc.next(), false);
			}
			vaccines.add(vaccine);
		}

	}

	public boolean getPatientDetails(List<Vaccine> vaccines, List<String> bookingHistory) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name:");
		// Get name who wants to take vaccinattion
		String personName = sc.next();
		String personAge = "0";
		// Geting correct age for vaccination
		redo: while (true) {
			System.out.println("Enter the Age:");
			// Get person age
			personAge = sc.next();
			String vacType = "";
			// Define the PFizer vaccine for age between 1-18
			if (Integer.parseInt(personAge) <= 18 && Integer.parseInt(personAge) >= 10) {
				System.out.println("Vaccine type:PFizer");
				vacType = "2";
				// Define the Sinaform vaccine for age between 10-100
			} else if (Integer.parseInt(personAge) > 18 && Integer.parseInt(personAge) <= 100) {
				System.out.println("Vaccine type:Sinaform");
				vacType = "1";

				// Enterd age is less than 10 statement will redo
			} else {
				System.out.println("Age between 10 to 100");
				continue redo;
			}

			// System.out.println("Enter the vaccine type:");
			// // Get vaccinattion type
			String vaccineType = vacType;
			System.out.println("Enter the date you wish to take vaccination: ");
			// Get vaccinattion date
			String day = sc.next();
			System.out.println("Time of vaccination:");
			// Get vaccinattion time
			String time = sc.next();
			Vaccination appointment = new Vaccination();

			if (appointment.bookAppointemnt(vaccines, personName, personAge, vaccineType, day, time, numberOfVaccine,
					bookingHistory))
				return true;
			return false;
		}
	}
}
