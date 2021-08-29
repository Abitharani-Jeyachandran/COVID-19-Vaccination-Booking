package vaccine;

import java.util.List;
import java.util.Map;

public class Vaccination
{
	public boolean bookAppointemnt(List<Vaccine> vaccines,String personName,String doctorType,String day,String time,int numberOfVaccine,List<String> bookingHistory)
	{
		if(checkAvailability(vaccines,personName,vaccineType,day,time,numberOfVaccine,bookingHistory))
			return true;
		return false;
	}
	//Check availability
	public boolean checkAvailability(List<Vaccine> vaccines,String personName,String doctorType,String day,String time,int numberOfVaccine,List<String> bookingHistory)
	{
		int flag=0;
		OUTER:for(int index = 0;index < numberOfVaccine;index++)
		{
			 Vaccine doc=vaccines.get(index);
		     if(doc.vaccinationAvailableDay.equalsIgnoreCase(day)&&doc.vaccineType.equalsIgnoreCase(doctorType))
		     {
				 for(Map.Entry<String, Boolean> m:doc.availabilty.entrySet())
			     {
					 if(time.equalsIgnoreCase(m.getKey())&&(m.getValue()==false))
					 {
						doc.availabilty.put(m.getKey(),true);
						String s="Vaccine is booked for vaccination on "+day+" at "+time+" ";
						//Add details to booking history
						bookingHistory.add(s);
						System.out.println(s);
						flag=1;
						break OUTER;
					 }
				 }
			  }
		   }
		   if(flag==0)
			 //Vaccine not available validation
		   {
		       System.out.println("Vaccination is not available at that time.Kindly check for another slot");
		       return false;
		   }
		   return true;
	}
}
