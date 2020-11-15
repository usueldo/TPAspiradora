import java.io.IOException;

public class pruebaAspiradora {

	
    public static void main(String args[]) throws IOException 
    { 
    	//CASO 1: Muevo aspiradora sobre ambiente limpio
    	//Cuando la aspiradora se mueve, cambia de zona
    	casoMoverAspiradora();
    	
    	//CASO 2: muevo aspiradora sobre zona con obstaculo en la fila 0 y columna 1
    	//La aspiradora intentara moverse hacia arriba y luego hacia abajo
    	//casoMoverAspiradoraConObstaculo();

    	//CASO 3:muevo aspiradora sobre zonas con obstáculo y se apaga al no poder moverse
    	casoMoverAspiradoraConObstaculosSeApaga();
    	
    	//CASO 4: Se agrega aspiradora en el ambiente , se enciende y se limpia
    	//casoAspiradoraLimpiaZona1();
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
    	cocina.agregarZona(zona1);
    	cocina.agregarZona(zona2);
    	cocina.agregarZona(zona3);
    	cocina.agregarZona(zona4);
    	
    	//Si ningun elemento es nulo, no se agrega la zona y se manda excepcion de que no se puede agregar zona
    	cocina.agregarZona(zona4);
    	
    	aspiradora = new Aspiradora(cepilloIzquierdo, cepilloDerecho);
    	
    	cocina.agregarAspiradora(aspiradora);
    	
    	//Enciendo aspiradora
    	aspiradora.encender();
    	//Muevo aspiradora hacia la derecha
    	aspiradora.mover("DERECHA");
    	
    	aspiradora.mover("ABAJO");
    	aspiradora.mover("IZQUIERDA");
    	aspiradora.mover("ARRIBA");
    }
    private static void casoMoverAspiradoraConObstaculo() {
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
    	
    	//Agrego obstaculo a la zona
    	zona2.agregarObstaculo();
    	
    	cocina.agregarZona(zona1);
    	cocina.agregarZona(zona2);
    	cocina.agregarZona(zona3);
    	cocina.agregarZona(zona4);
    	
    	cocina.agregarZona(zona4);
    	
    	aspiradora = new Aspiradora(cepilloIzquierdo, cepilloDerecho);
    	
 	   	//Se agrega aspiradora en la posicion 0 0
    	cocina.agregarAspiradora(aspiradora);
    	
    	//Enciendo aspiradora
    	aspiradora.encender();
    	//Muevo aspiradora hacia la derecha
    	aspiradora.mover("DERECHA");
    	
    	if(aspiradora.estaEncendida()) {
    		System.out.print("La aspiradora esta encendida\n"); 
    	}else {
    		System.out.print("Se apago aspiradora\n"); 
    	}
    }
    private static void casoMoverAspiradoraConObstaculosSeApaga() {
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
    	
    	//Agrego obstaculo a la zona con fila 0 y columna 1
    	zona2.agregarObstaculo();
    	
    	//Agrego obstaculo a la zona con fila 1 y columna 0
    	zona3.agregarObstaculo();
    	
    	cocina.agregarZona(zona1);
    	cocina.agregarZona(zona2);
    	cocina.agregarZona(zona3);
    	cocina.agregarZona(zona4);
    	
    	cocina.agregarZona(zona4);
    	
    	aspiradora = new Aspiradora(cepilloIzquierdo, cepilloDerecho);
    	
 	   	//Se agrega aspiradora en la posicion 0 0
    	cocina.agregarAspiradora(aspiradora);
    	
    	//Enciendo aspiradora
    	aspiradora.encender();
    	//Muevo aspiradora hacia la derecha
    	aspiradora.mover("DERECHA");
    	
    	//Si  la aspiradora esta apagada, significa que encontro  ambos obstaculos
    	if(aspiradora.estaEncendida()) {
    		System.out.print("La aspiradora esta encendida\n"); 
    	}else {
    		System.out.print("Se apago aspiradora\n"); 
    	}
    }
    private static void casoAspiradoraLimpiaZona1() {
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
    	
    	//Se crea aspiradora
    	aspiradora = new Aspiradora(cepilloIzquierdo, cepilloDerecho);
    	
    	if(!zona1.estaLimpia()) {
    		System.out.print("No Se limpio zona\n"); 
    	}
    	
    	//Se agrega aspiradora en la posicion 0 0
    	cocina.agregarAspiradora(aspiradora);
    	
    	//Se enciende aspiradora y se empieza a limpiar
    	aspiradora.encender();
    	
    	if(zona1.estaLimpia()) {
    		System.out.print("Se limpio zona\n"); 
    	}
    	
    }
    
    
}

