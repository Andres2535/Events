package ui;
import model.*;
import java.util.*;
public class Main{
	
	public static void main(String args[]){
		
		
		//Attributtes
		
		Scanner owo = new Scanner(System.in);
		Scanner uwu = new Scanner(System.in);
		int onMenu = 0;
		int  position;
		
		//Relations
		
		Collage u = new Collage();
		
		while(onMenu!=9){
			
			System.out.println("************************************************");
			System.out.println("OwO");
			System.out.println("1: Show information of all auditoriums");  
			System.out.println("2: Create an event");                  
			System.out.println("3: Remove an event");	
			System.out.println("4: Event information");
			System.out.println("5: Update chair status");						 
			System.out.println("6: Upcoming events. (5 days from the date entered) ");      
			System.out.println("9: Exit");
			System.out.println("************************************************");
			System.out.println("");
			System.out.println("");
			onMenu = uwu.nextInt();
			
			switch(onMenu){
				
								
				case 1:
					for(int i = 0; i < 8; i++){
						
						System.out.println("Auditorium name: "+u.getAuditoriumName(i));
						System.out.println("ID: "+u.getAuditoriumId(i));
						if(u.getAuditoriumEstado(i))
							System.out.println("Estado:  Available");
						else
							System.out.println("Estado:  Not available");
						System.out.println("Free chairs: "+u.getAuditoriumSillasDisp(i));
						System.out.println("percentage of defective charis: "+(-u.getPorcSillasFunc(i)+100)+"%");
						System.out.println("Events:");
						System.out.println(u.getEventosAuditorium(i));
					}
				break;
				
				
				
				
				case 2:
					
					System.out.println("Name of the event: ");
					String aName = owo.nextLine();
					System.out.println("Event date");
					System.out.println("Day: ");
					int aDay = uwu.nextInt();
					System.out.println("Month (number): ");
					int aMonth = uwu.nextInt();
					System.out.println("Year: ");
					int aYear = uwu.nextInt();
					System.out.println("Encargado del evento ");
					String aEncargado = owo.nextLine();
					System.out.println("Start time (0000-2400): ");
					int asTime = uwu.nextInt();
					System.out.println("End time (0000-2400): ");
					int eHoraFin = uwu.nextInt();
					System.out.println("auditorium (1-8): ");
					for(int i = 0; i < 8; i++){
						System.out.println(">"+(i+1)+": "+u.getAuditoriumName(i));
					}
					boolean adding = true;
					ArrayList<Auditorium> eAuditoriums = new ArrayList<Auditorium>();
					while(adding){
						System.out.println("Choose the auditorium (1-8): ");
						int numAud = uwu.nextInt();
						numAud--;
						eAuditoriums.add(u.getAuditorium(numAud));
						System.out.println("Do you want to add another?: 1.) Yes    2.) No");
						int agre = uwu.nextInt();
						if(agre==2)
							break;
					}
					
					System.out.println(u.createevent(aName, aDay, aMonth, aYear, aEncargado, asTime, eHoraFin, eAuditoriums));
					
				break;
				
				
				
				
				case 3:
					
					System.out.println(""+u.displayEventos());
					System.out.println("1.): Remove event     2.): Exit");
					if(uwu.nextInt()==2){
						break;
					}
					System.out.println("Select the event");
					int aBorrar = uwu.nextInt();
					aBorrar = aBorrar-1;
					System.out.println(u.deleteEvent(aBorrar));
				break;
				
				
				
				
				
				case 4:
					System.out.println(u.displayInfoEventos());
				break;
				
				
				case 5:
					
					for(int i = 0; i < 8; i++){
						System.out.println(u.getAuditoriumSillasNotFunc(i));
					}
					
					System.out.println(">Estado de silla: 1/Funcional  2/Presenta problemas 3/Salir");
					boolean estado = false;
					int option = uwu.nextInt();
					if(option==1)
						estado = true;
					else if(option==3)
						break;
					System.out.println(">Auditorium: 1 al 8");
					position = (uwu.nextInt());
					position--;
					System.out.println(">Fila de la silla: ");
					int row = uwu.nextInt();
					System.out.println(">Columna de la silla: ");
					int column = uwu.nextInt();
					System.out.println(">Descripcion del problema: ");
					String description = owo.nextLine();
					System.out.println(u.updatestatechair(position, row, column, description, estado));
				break;
				
				
				
				
				
				case 6:
					System.out.println("Ingrese la date");
					System.out.println("Dia: ");
					int day = uwu.nextInt();
					System.out.println("Mes: ");
					int month = uwu.nextInt();
					System.out.println("Anio: ");
					int year = uwu.nextInt();
					System.out.println(u.eventosfivedays(year, month, day));
				break;
				case 9: 
				onMenu = 9;
				break;
			}
			
		}
	}
}