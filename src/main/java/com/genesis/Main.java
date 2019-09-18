package com.genesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.genesis.beans.Address;
import com.genesis.beans.Employee;
import com.genesis.beans.Laptop;
import com.genesis.beans.Vehicle;

import com.genesis.beans.Project;
import com.genesis.cruds.EmployeeCRUD;
import com.genesis.cruds.LaptopCRUD;
import com.genesis.cruds.ProjectCRUD;
import com.genesis.cruds.VehicleCRUD;
import com.genesis.util.Util;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		while(true) {
			
			System.out.println("Operate :\n"
					+ "1.Employee\n"
					+ "2.Laptop\n"
					+ "3.Vehicle\n"
					+ "4.Project\n"
					+ "5.Exit\n");
			switch(sc.nextInt()) {
			case 1:{
				EmployeeCRUD ec=new EmployeeCRUD(new Util());
				
				w:
					while(true) {
						System.out.println("Employee :\n"
						+ "1.Add\n"
						+ "2.Delete\n"
						+ "3.View\n"
						+ "4.Go Back\n");
				
					e:
					switch(sc.nextInt()) {
					case 1:{
						Employee e=new Employee();
						Address a=new Address();
						sc.nextLine();
						System.out.println("Enter name");
						e.setEname(sc.nextLine());
						System.out.println("Enter Salary");
						e.setEsal(sc.nextInt());
						System.out.println("Enter House no");
						a.setHno(sc.nextInt());sc.nextLine();
						System.out.println("Enter Street");
						a.setStreet(sc.nextLine());
						System.out.println("Enter City");
						a.setCity(sc.nextLine());
						
						e.setAdd(a);
						System.out.println("Enter Laptop id");
						e.setLap(new Laptop(sc.nextInt()));
						System.out.println("Enter no. of Projects ");
						int n=sc.nextInt();
						System.out.println("Enter ids. of Projects ");
						List<Project> l=new ArrayList<Project>();
						for(int i=0;i<n;i++) {
							l.add(new Project(sc.nextInt()));
						}
						e.setProjects(l);
						
						System.out.println("employee id="+ec.addEmployee(e));
						break e;
					}
					case 2:{
						System.out.println("Enter employee id");sc.nextLine();
						ec.deleteEmployee(new Employee(sc.nextInt()));
						break e;
					}
					case 3:{
						ec.viewAllEmployee();
						break e;
					}
						
					
					case 4:
						break w;
					
					default:
						System.out.println("Invalid Option");
					}
				
				}	
				break;
				
			}
			case 2:{
				LaptopCRUD lc=new LaptopCRUD(new Util());
				w:
				while(true) {
					System.out.println("Laptop :\n"
							+ "1.Add\n"
							+ "2.Delete\n"
							+ "3.View\n"
							+ "4.Go Back\n");
				
				f:
					switch(sc.nextInt()) {
					case 1:{
						Laptop lap=new Laptop();
						
						System.out.println("Enter Laptop id");
						lap.setCode(sc.nextInt());
						sc.nextLine();
						System.out.println("Enter name");
						lap.setName(sc.nextLine());
						System.out.println("Enter price");
						lap.setPrice(sc.nextInt());
						
						lc.addLaptop(lap);
						break f;
					}
					case 2:{
						System.out.println("Enter Laptop id");sc.nextLine();
						lc.deleteLaptop(new Laptop(sc.nextInt()));
						break f;
					}
					case 3:{
						lc.viewAllLaptop();
						break f;
					}
					case 4:
						break w;
					
					default:
						System.out.println("Invalid Option");
					}
				
				}	
				break;
				
			}
			case 3:{
				VehicleCRUD vc=new VehicleCRUD(new Util());
				w:
					while(true) {
					System.out.println("Vehicle :\n"
							+ "1.Add\n"
							+ "2.Delete\n"
							+ "3.View\n"
							+ "4.Go Back\n");
				
				g:
					switch(sc.nextInt()) {
					case 1:{
						Vehicle veh=new Vehicle();
						sc.nextLine();
						System.out.println("Enter Vehicle regno");
						veh.setRegno(sc.nextLine());
						System.out.println("Enter Brand ");
						veh.setBrand(sc.nextLine());
						System.out.println("Enter Model ");
						veh.setModel(sc.nextLine());
						System.out.println("Enter Employee id ");
						veh.setEmployee(new Employee(sc.nextInt()));
						vc.addVehicle(veh);
						break g;
					}
					case 2:{
						System.out.println("Enter regno");sc.nextLine();
						vc.deleteVehicle(new Vehicle(sc.nextLine()));
						break g;
					}
					case 3:{
						vc.viewAllVehicle();
						break g;
					}
					case 4:
						break w;
					
					default:
						System.out.println("Invalid Option");
					}
				
				}	
				break;
				
			}
			case 4:{
				ProjectCRUD pc=new ProjectCRUD(new Util());
				w:
					while(true) {
						System.out.println("Project :\n"
								+ "1.Add\n"
								+ "2.Delete\n"
								+ "3.View\n"
								+ "4.Go Back\n");
				
				h:
					switch(sc.nextInt()) {
					case 1:{
						Project e=new Project();
						
						System.out.println("Enter Project Code");
						e.setCode(sc.nextInt());sc.nextLine();
						System.out.println("Enter Title");
						e.setTitle(sc.nextLine());
						System.out.println("Enter Company");
						e.setCompany(sc.nextLine());
						
						pc.addProject(e);
						break h;
					}
					case 2:{
						System.out.println("Enter Project id");sc.nextLine();
						pc.deleteProject(new Project(sc.nextInt()));
						break h;
					}
					case 3:{
						pc.viewAllProject();
						break h;
						
					}
						
					
					case 4:
						break w;
					
					default:
						System.out.println("Invalid Option");
					}
				
				}	
				break;
				
			}
			case 5:{
				sc.close();
				System.exit(0);
				break;
			}
			default:
				System.out.println("Invalid Option");
			}
		}
		
	}

}
