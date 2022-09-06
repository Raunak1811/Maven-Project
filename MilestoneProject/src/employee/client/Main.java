package employee.client;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import employee.entity.EmpDetails;
import employee.service.EmpImp;


public class Main {
	public static void main(String[] args) {
		EmpDetails empdet = new EmpDetails();
		EmpImp empIm= new EmpImp();
		List<EmpDetails> alist = new ArrayList<EmpDetails>();
		Scanner sc = new Scanner(System.in);
		
		int choice;
		
		try {
			do {
				System.out.println("Please enter employee detais:");
				System.out.println("Enter ID:");
				int id = sc.nextInt();
				empIm.Empid(alist, id);
				System.out.println("Enter name:");
				String name = sc.next();
				
				System.out.println("Enter age:");
				int age = sc.nextInt();
				
				System.out.println("Enter sal:");
				int sal = sc.nextInt();
				alist.add(new EmpDetails(id, name, age, sal));
				
				System.out.println("Press 0 to Add more into list");
				System.out.println("Press any number between 1 to 4 for other options");
				choice = sc.nextInt();
				
			}
			while(choice==0);
		}
		catch(Exception exc) {
			System.out.println(exc);
			System.out.println("Try with diff emp id");
		}
		finally {
			System.out.println("Employee details were updated ");
		}
		
		
			try {
				String option= "";
				String con ="";
				do {
					System.out.println("Select from the options below:");
					System.out.println("1.Show Employee Details");
					System.out.println("2.Employee Name in Descending Order");
					System.out.println("3. Update Salary");
					System.out.println("4. Exit");

					
					option = sc.next();
					switch(option)
					{
					case "1":
					{
						System.out.println("-----------------------Employee Details---------------------");
						
						System.out.println("Employee Id:               Employee Name:              Employee Age:              Employee Salary:");

						for(EmpDetails em:alist) {
							

							System.out.println(em.getId()+"       "+em.getName()+"       "+em.getAge()+"       "+em.getSal());
						
						}
						break;

						}
					
					case "2":
					{
						Collections.sort(alist, new Comparator<EmpDetails>() {
								@Override
								public int compare(EmpDetails o1, EmpDetails o2) {
									return o2.getName().compareTo(o1.getName());
						}
						});
						
						for(EmpDetails em1:alist) {
								System.out.println(em1.getId()+"     "+em1.getName()+"      "+em1.getAge()+"        "+em1.getSal());
						}
						break;
					}
				
					case "3":
					{
						System.out.println("Enter Employee ID:");
						int id =sc.nextInt();
						System.out.println("Enter the Salary to be updated:");
						int sal =sc.nextInt();
						double newsal = empIm.updateSalary(alist, id, sal);
						System.out.println("Congrats! Successfully updated the Salary..");
						int allid = empIm.searchId(alist, id);
						System.out.println(alist.get(allid).getId()+ " "+alist.get(allid).getName()+ " "+alist.get(allid).getAge()+ " " +alist.get(allid).getSal());
						break;

					}

				
					case "4":
						System.out.println("Exited");
						System.out.println(("Thank you"));
						System.exit(0);
						break;
						
					default:
						break;
				}
				
				System.out.println("Do you want to continue? (yes/no)");
				con=sc.next();
			}
			while(con.equalsIgnoreCase("Yes"));
	}
	catch(Exception ex) {
		System.out.println(ex);
		
}
	finally {
		System.out.println("Thank you");
	}
}
	
}
	
	
			
