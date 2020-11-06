
public class Zona {
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
	

}
