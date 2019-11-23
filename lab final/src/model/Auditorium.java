package model;

public class Auditorium{
	private String name;
	private String id;
	private boolean horas[][][][] = new boolean[2][12][31][13];
	public Chair Chairs[][];
	private int availablechairs;
	private boolean state;
	private int aRow;
	private int sCol;
	public char abc[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public int maxChair;
	public double wearablechair;
	
	public Auditorium(String name, String id, int[] sillas, boolean estado){
		this.name = name;
		this.id = id;
		this.Chairs = initiatecharis(sillas);
		fillHoras();
		this.availablechairs = calculateavailablechairs();
		this.state = estado;
		this.maxChair = calcmaxChair(); 
		this.wearablechair = porcFuncChairs(maxChair, availablechairs);
	}
	
	
	
	
	public void changechairstatus(int row, int column, boolean estado){
		Chairs[row][column].setEstado(estado);
	}
	
	
	public void changechairdescription(int row, int column, String description){
		Chairs[row][column].setDescription(description);
	}
	
	
	public void fillHoras(){
		for(int i = 0; i < 2; i++){
			for(int k = 0; k < 12; k++){
				for(int j = 0; j < 31; j++){
					for(int y = 0; y < 13; y++){
						this.horas[i][k][j][y] = true;
					}
				}
			}
		}
	}
	
	
	public Chair[][] initiatecharis(int sillas[]){
		int maxr = 0;
		for(int i = 0; i < sillas.length; i++){
			if(sillas[i]>maxr){
				maxr = sillas[i];
			}
		}
		Chair sillaz[][] = new Chair[sillas.length][maxr];
		
		for(int i = 0; i < sillas.length; i++){
			for(int k = 0; k < sillas[i]; k++){
				sillaz[i][k] = new Chair((abc[i]+""+k),this.name,true);
			}
		}
		this.sCol = sillas.length;
		this.aRow = maxr;
		return sillaz;
	}
	
	
	public int  calculateavailablechairs(){
		int sillasDisp = 0;
		for(int i = 0; i < sCol; i++){
			for(int k = 0; k < aRow; k++){
				if(this.Chairs[i][k]!=null && Chairs[i][k].getEstado()){
					sillasDisp++;
				}
			}
		}
		return sillasDisp;
	}
	
	
	public int calcmaxChair(){
		int sillasMax = 0;
		for(int i = 0; i < sCol; i++){
			for(int k = 0; k < aRow; k++){
				if(this.Chairs[i][k]!=null){
					sillasMax++;
				}
			}
		}
		return sillasMax;
	}
	
	
	public double porcFuncChairs(int total, int func){
		
		double dTotal = (double)total;
		double dFunc = (double)func;

		double funcional = (double)((dFunc/dTotal)*100);
		
		return funcional;
	}
	
	
	public void updatePorcFuncChairs(){
		int total = getmaxChair();

		int disp = getSillasDisp();

		this.wearablechair = porcFuncChairs(total, disp);
	}
	
	
	public String getSillasNotFunc(){
		String mensaje = "";
		for(int i = 0; i < sCol; i++){
			for(int k = 0; k < aRow; k++){
				if(this.Chairs[i][k]!=null && !(Chairs[i][k].getEstado())){
					mensaje += "---------"+"\n";
					mensaje += Chairs[i][k].getAuditorium()+"\n";
					mensaje += Chairs[i][k].getId()+"\n";
					mensaje += Chairs[i][k].getDescription()+"\n";
					mensaje += "pos: ("+i+","+k+")";
				}
			}
		}
		return mensaje;
	}
	
	
	public void updateChair(){
		this.availablechairs = calculateavailablechairs();
	}
	
	
	public String getName(){
		return name;
	}
	
	
	public String getId(){
		return id;
	}
	
	
	public int getSillasDisp(){
		return availablechairs;
	}
	
	
	public boolean getEstado(){
		return state;
	}
	
	
	public double getPorcFuncSillas(){
		return wearablechair;
	}
	
	
	public int getmaxChair(){
		return maxChair;
	}
	

	public boolean checkchairs(int row, int column){
		boolean check = true;
		if(Chairs[row][column]==null)
			check = false;
		return check;
	}
	
	
	public void setHora(boolean estado, int year, int month, int day, int hora){
		horas[year][month][day][hora] = estado;
	}
	
	
	public boolean checkDispoHours(int day, int month, int year, int in, int out){
		boolean disp = true;
		in = in/1000;
		out = out/1000;
		for(int i = 0; i > in && i < out; i++){
			if(!horas[year][month][day][i]){
				disp = false;
			}
		}
		return disp;
	}
	

}