package model;
import java.util.*;


public class Collage{
	
	public Auditorium Auditoriums[] = new Auditorium[8];
	public ArrayList<Event> eventos = new ArrayList<Event>();
	

	public Collage(){
		int[] sillas1 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] sillas2 = new int[]{15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		int[] sillas3 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] sillas4 = new int[]{15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		int[] sillas5 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] sillas6 = new int[]{15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		int[] sillas7 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] sillas8 = new int[]{15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
	
		Auditoriums[0] = new Auditorium("Argos", "A1", sillas1, true);
		Auditoriums[1] = new Auditorium("Manuelita", "A2", sillas2, true);
		Auditoriums[2] = new Auditorium("Pepito", "A3", sillas3, true);
		Auditoriums[3] = new Auditorium("OwO", "A4", sillas4, true);
		Auditoriums[4] = new Auditorium("UwU", "A5", sillas5, true);
		Auditoriums[5] = new Auditorium("Lulu", "A6", sillas6, true);
		Auditoriums[6] = new Auditorium("Hercules", "A7", sillas7, true);
		Auditoriums[7] = new Auditorium("Meg", "A8", sillas8, true);
	}
	
	
	public String getAuditoriumName(int pos){
		String name = Auditoriums[pos].getName();
		return name;
	}
	
	public String getAuditoriumId(int pos){
		String id = Auditoriums[pos].getId();
		return id;
	}

	public int getAuditoriumSillasDisp(int pos){
		int sillasDisp = Auditoriums[pos].getSillasDisp();
		return sillasDisp;
	}
	
	public boolean getAuditoriumEstado(int pos){
		boolean estado = Auditoriums[pos].getEstado();
		return estado;
	}
	
	
	public String updateEstadoSilla(int Auditorium, int row, int column, String description, boolean estado){
		String msg = "Silla no existe";
		if(Auditoriums[Auditorium]!=null && Auditoriums[Auditorium].checkNullSilla(row,column)){
			Auditoriums[Auditorium].cambiarEstadoSilla(row, column, estado);
			Auditoriums[Auditorium].cambiarDescriptionSilla(row, column, description);
			Auditoriums[Auditorium].updateSillas();
			Auditoriums[Auditorium].updatePorcFuncSillas();
			msg = "Estado de silla actualizado";
		}
		return msg;
	}
	
	
	
	public String crearEvento(String name, int day, int month, int year, String encargado, int sTime, int horaFin, ArrayList<Auditorium> Auditorium){
		Event evento = new Event(name, day, month, year, encargado, sTime, horaFin, Auditorium);
		String msg = "";
		for(int i = 0; i < Auditorium.size(); i++){
			if(evento.getAuditorium(i)!=null && !evento.getAuditorium(i).checkDispoHora(day, month, year, sTime, horaFin)){
				msg = "Horas no disponibles";
			}
			else{
				eventos.add(evento);
				msg = "Evento creado: "+name;
			}
		}
		return msg;
	}
	
	
	public String displayEvento(int pos){
		String msg = "Posicion invalida";
		if(eventos.get(pos)!=null){
			msg = (eventos.get(pos)).getName();
		}
		return msg;
	}
	
	
	public String displayEventos(){
		String msg = "";
		for(int i = 0; i < eventos.size(); i++){
			msg += (i+1)+":"+eventos.get(i).getName()+"\n";
		}
		return msg;
	}
	
		
	public String borrarEvento(int pos){
		String msg = "Evento no se pudo borrar";
		if(eventos.get(pos)!=null){
			eventos.remove(pos);
			msg = "Evento borrado";
		}
		return msg;
	}
	
	
	public String getEventosAuditorium(int pos){
		String msg = "";
		for(int i = 0; i < eventos.size(); i++){
			for(int k = 0; k < eventos.get(i).getAuditoriums().size(); k++){
				if(eventos.get(i)!=null && (eventos.get(i).getAuditorium(k).getId()).equalsIgnoreCase(Auditoriums[pos].getId())){
					msg += eventos.get(i).getName()+"\n";
				}
			}
		}
		return msg;
	}
	
	
	public Auditorium getAuditorium(int pos){
		return Auditoriums[pos];
	}
	
	
	public String displayInfoEventos(){
		String msg = "";
		for(int i = 0; i < eventos.size(); i++){
			msg+= "--------------------\n";
			msg+= "	Name: "+eventos.get(i).getName()+"\n";
			msg+= "Date: "+eventos.get(i).getdate()+"\n";
			msg+= "Place: "+eventos.get(i).getNameAuditoriums()+"\n";
			msg+= "Encargado: "+eventos.get(i).getencargado()+"\n";
			msg+= "Start time: "+eventos.get(i).getsTime()+"\n";
			msg+= "End time: "+eventos.get(i).getHoraFin()+"\n";
		}
		return msg;
	}
	
	
	public void updateHorasAuditorium(boolean estado, int year, int month, int day, int sTime, int horaFin, int pos){
		int in = (int)Math.floor(sTime/1000);
		int fin = (int)Math.ceil(horaFin/1000);
		
		if(in < 7)
			in = 7;
		if(fin > 20)
			fin = 20;
		
		int dur = in-fin;
		
		for(int i = in; i < dur; i++){
			Auditoriums[pos].setHora(estado, year, month, day, i);
		}
	}
	
	
	public String eventos5days(int year, int month, int day){
		String msg = "";
		int yearD;
		int monthD;
		int daysD;
		int daysmonth;
		int daysInt;
		daysmonth = checkdaysmonth(month);
		for(int i = 0; i < eventos.size(); i ++){
			yearD = eventos.get(i).getYear() - year;
			monthD = eventos.get(i).getmonth() - month;
			if(yearD>1){
				monthD = (12 - month) + eventos.get(i).getmonth();
			}
			daysD = (checkdaysmonth(month) - day) +eventos.get(i).getday();
			
			if(monthD>1 || month<0){
				continue;
			}
			
			if(monthD==0)
				daysD = eventos.get(i).getday() - day;
			if(daysD<=5 && daysD>=0){
				msg += "----------\n";
				msg += ">"+eventos.get(i).getName()+"\n";
			}
		}
		return msg;
		
	}
	
	
	public int checkdaysmonth(int month){
		int days;
		if(month==1 && month<=7){
			if(month%2==0)
				days = 30;
			else
				days = 31;
		}else{
			if(month%2==0)
				days = 31;
			else
				days = 30;
		}
		if(month==2)
			days = 28;
		return days;
	}
	
	
	public double getPorcSillasFunc(int pos){
		double sillasFunc = Auditoriums[pos].getPorcFuncSillas();
		return sillasFunc;
	}
	
	
	public String getAuditoriumSillasNotFunc(int pos){
		String msg = Auditoriums[pos].getSillasNotFunc();
		return msg;
	}
	
}
	
