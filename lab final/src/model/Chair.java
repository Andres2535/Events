package model;

public class Chair{
	private String id;
	private String Auditorium;
	private boolean estado;
	private String description;
	
	public Chair(String id, String Auditorium, boolean estado){
		this.id = id;
		this.Auditorium = Auditorium;
		this.estado = estado;
		this.description = "";
	}
	
	
	/*
	 * This method is to get a ID
	 * @pre: Object of Auditorium != null 
	 * @param: empty
	 * @return: a string with an ID for a chair
	 * @post: a chair gets an ID
	 */
	
	public String getId(){
		return id;
	}
	
	
	
	 /*
	 * This method is to get a auditorium
	 * @pre: Object of Auditorium != null 
	 * @param: empty
	 * @return: a string description with a description for a chair
	 * @post: a chair gets a description
	 */
	 
	public String getAuditorium(){
		return Auditorium;
	}
	
	
	
	
	
	/*
	 * This method is to set a state 
	 * @pre: Object of Auditorium != null 
	 * @param: String description
	 * @return: void
	 * @post: set a state to chair
	 */
	 
	public void setEstado(boolean estado){
		this.estado = estado;
	}
	
	
	/*
	 * This method is to get a state
	 * @pre: Object of Auditorium != null %% chair ! = null
	 * @param: empty
	 * @return: a boolean with a state 
	 * @post: a chair gets a state
	 */
	 
	public boolean getEstado(){
		return estado;
	}
		
	
	/*
	 * This method is to get a description
	 * @pre: Object of Auditorium != null 
	 * @param: empty
	 * @return: a string description with a description for a chair
	 * @post: a chair gets a description
	 */
	
	public String getDescription(){
		return description;
	}
	
	/*
	 * This method is to set a description 
	 * @pre: Object of Auditorium != null 
	 * @param: String description
	 * @return: void
	 * @post: set a description to a chair
	 */
	 
	public void setDescription(String description){
		this.description = description;
	}
}