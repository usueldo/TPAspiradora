import java.io.IOException;

public class pruebaAspiradora {

	
    public static void main(String args[]) throws IOException 
    { 
    	//CASO 1 muevo aspiradora sobre ambiente limpio
    	//Cuando la aspiradora se mueve, cambia de zona
    	casoMoverAspiradora();
    }
    private static void casoMoverAspiradora() {
    	Ambiente cocina;
    	Zona	 zona1 = new Zona();
    	Zona	 zona2 = new Zona();
    	Zona	 zona3 = new Zona();
    	Zona	 zona4 = new Zona();
    	Aspiradora aspiradora;
    	Cepillo	cepilloIzquierdo = new Cepillo();
    	Cepillo	cepilloDerecho	= new Cepillo();
    	int ancho;
    	int alto;
    	
    	//Crear ambiente 2x2
    	//Cuando se crea ambiente, que es una matriz,  se debe decir el tamaño del ambiente.
    	//Cada elemento de la matriz tiene adentro una zona.
    	ancho = 2;
    	alto = 2;
    	
    	//Se crea cocina
    	cocina = new Ambiente("cocina", ancho, alto);
    	
    	//Agrega una zona si no se agrego anteriormente
    	//El metodo agregar zona loppea la matriz zonas dentro del ambiente  preguntando si algun elemento es nulo
    	//Si algun elemento es nulo, agrega la zona, 
    	//Si ningun elemento es nulo, no se agrega la zona y se manda excepcion de que no se puede agregar zona
    	//Ensucio la zona
    	zona1.ensuciar();
    	cocina.agregarZona(zona1);
    	cocina.agregarZona(zona2);
    	cocina.agregarZona(zona3);
    	cocina.agregarZona(zona4);
    	
    	cocina.agregarZona(zona4);
    	
    	aspiradora = new Aspiradora(cepilloIzquierdo, cepilloDerecho);
    	
    	/*if(!zona1.estaLimpia()) {
    		System.out.print("No Se limpio zona\n"); 
    	}*/
    	aspiradora.cambiarModoVelocidad("RAPIDO");
    	//Se agrega aspiradora en la posicion 0 0
    	cocina.agregarAspiradora(aspiradora);
    	
    	/*if(zona1.estaLimpia()) {
    		System.out.print("Se limpio zona\n"); 
    	}*/
    	//Enciendo aspiradora
    	aspiradora.encender();
    	//Muevo aspiradora hacia la derecha
    	aspiradora.mover("DERECHA");
    	aspiradora.mover("ABAJO");
    	aspiradora.mover("IZQUIERDA");
    	aspiradora.mover("ARRIBA");
    	aspiradora.mover("IZQUIERDA"); //Se excedio de los limites
    }
}

