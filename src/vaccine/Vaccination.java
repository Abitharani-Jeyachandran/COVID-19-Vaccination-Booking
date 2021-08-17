package vaccine;

import java.util.List;
import java.util.Map;

public class Vaccination
{
	public boolean bookAppointemnt(List<Vaccine> vaccines,String patientName,String doctorType,String day,String time,int numberOfDoctors,List<String> bookingHistory)
	{
		if(checkAvailability(vaccines,patientName,doctorType,day,time,numberOfDoctors,bookingHistory))
			return true;
		return false;
	}
	
	public boolean checkAvailability(List<Vaccine> doctors,String patientName,String doctorType,String day,String time,int numberOfDoctors,List<String> bookingHistory)
	{
		int flag=0;
		OUTER:for(int index = 0;index < numberOfDoctors;index++) 
		{
			 Vaccine doc=doctors.get(index);
		     if(doc.vaccinationAvailableDay.equalsIgnoreCase(day)&&doc.vaccineType.equalsIgnoreCase(doctorType)) 
		     {
				 for(Map.Entry<String, Boolean> m:doc.availabilty.entrySet())
			     {
					 if(time.equalsIgnoreCase(m.getKey())&&(m.getValue()==false)) 
					 {
						doc.availabilty.put(m.getKey(),true);
						String s="Vaccine is Booked for vaccination on "+day+" at "+time+" PM";
						bookingHistory.add(s);
						System.out.println(s);
						flag=1;
						break OUTER;
					 }
				 }
			  }			
		   }
		   if(flag==0)
		   {
		       System.out.println("Vaccination is not available at that time.Kindly check for another slot");
		       return false;
		   }
		   return true;
	}
}
