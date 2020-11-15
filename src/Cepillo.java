public class Cepillo {
	boolean estaSucio=false;
	int cantidadDeBarridos=0;
	
	
	public boolean estaSucio() {
		boolean estado=false;
		if (cantidadDeBarridos==20){
			
			estado=true;
		}
		return estado;
	}


	public void limpiarZona(Zona zona) {
		
		if (this.estaSucio()) {
			System.out.print("El cepillo esta sucio\n");
			
			
		} else {
			zona.limpiar();
			this.cantidadDeBarridos+=1;//Limpia zona y aumenta el cepillo en cantidad de barrido
		}
	}
	
		
	public void limpiarManualmente(){
		this.estaSucio=false;//pone el cepillo sucio en false
		this.cantidadDeBarridos=0;//resetea la cantidad de barridos
		
		}
	
};
