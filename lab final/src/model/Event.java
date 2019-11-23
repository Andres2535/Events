package model;
import java.util.*;

public class Event{

	private String name;
	private int day;
	private int month;
	private int year;
	
	private String encargado;
	private int sTime;
	private int eTime;
	private ArrayList<Auditorium> Auditoriums = new ArrayList<Auditorium>();
	
	public Event(String name, int day, int month, int year, String encargado, int sTime, int horaFin, ArrayList<Auditorium> Auditoriumz){
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
		this.encargado = encargado;
		this.sTime = sTime;
		this.eTime = horaFin;
		for(int i = 0; i < Auditoriumz.size(); i++){
			Auditorium aud = Auditoriumz.get(i);
			this.Auditoriums.add(aud);
		}
	}
	
		public String getName(){
		return name;
	}
	
	
	public String getdate(){
		String date = day+"/"+month+"/"+year;
		return date;
	}
	
	
	public int getday(){
		return day;
	}
	
	
	public int getmonth(){
		return month;
	}
	
	
	public int getYear(){
		return year;
	}
	
	
	public String getencargado(){
		return encargado;
	}
	
	
	public int getsTime(){
		return sTime;
	}
	
	
	public int geteTime(){
		return eTime;
	}
	
	
	public Auditorium getAuditorium(int pos){
		return Auditoriums.get(pos);
	}
	
	
	public ArrayList getAuditoriums(){
		return Auditoriums;
	}
	
	
	public String getNameAuditoriums(){
		String mensaje = "";
		for(int i = 0; i < Auditoriums.size(); i++){
			mensaje += Auditoriums.get(i).getName()+"/";
		}
		return mensaje;
	}
}