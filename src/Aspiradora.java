
public class Aspiradora {
	Zona zona;
	
	public void mover(String direccion) {
		Ambiente ambiente = zona.getAmbiente();
		int fila 	= zona.getFila();
		int columna = zona.getColumna();
		int limiteFila = ambiente.getAncho();
		int limiteColumna = ambiente.getAlto();
		Zona nuevaZona;

		//Si la ubicacion no es inicial, se modifican limites
		if(limiteFila != 0) {
			limiteFila = limiteFila - 1;
		}

		if(limiteColumna != 0) {
			limiteColumna = limiteColumna - 1;
		}
		
		
		switch(direccion)
		{
		   case "ARRIBA" :
			   fila = fila - 1;
			   break;
		   case "ABAJO" :
			   fila = fila + 1;
			   break;
		   case "DERECHA" :
			   columna = columna + 1;
			   break;
		   case "IZQUIERDA" :
			   columna = columna - 1;
			   break;
		   default : 
		      // Declaraciones
		}
		
		//Se comprueba que la aspiradora no se exceda de los limites
		if(fila <= limiteFila && fila >= 0 && columna <= limiteColumna && columna >= 0) {
			//Se obtiene nueva zona
			nuevaZona = ambiente.getZona(fila,columna);
			
			//Se carga nueva zona
			this.zona = nuevaZona;
			System.out.print("Se movio aspiradora columna "+Integer.toString(columna)+" y fila " +Integer.toString(fila)+"\n"); 
		}else {
			System.out.print("Se excedio de los limites !\n"); 
		}
	}
	
	public void setZona(Zona zona) {
		this.zona = zona;
	}
}
