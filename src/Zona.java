
public class Zona {
	int fila;
	int columna;
	Ambiente ambiente;
	boolean zonaLimpia;
	boolean zonaConObstaculo;
	


	@Override
	public String toString() {
		return "soy_una_Zona";
	}
	
	public void limpiar(){
		this.zonaLimpia = true;
	}
	
	public void ensuciar(){
		this.zonaLimpia = false;		
	}
	
	public boolean estaLimpia() {
		return zonaLimpia;
	}

	public void agregarObstaculo(){
		this.zonaConObstaculo = true;		
	}
	
	public boolean tieneObstaculo(){
		return this.zonaConObstaculo;
	}
	
	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getFila() {
		return this.fila;
	}

	public int getColumna() {
		return this.columna;
	}

	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}
}
