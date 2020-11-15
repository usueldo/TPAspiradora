import java.io.IOException;

public class pruebaAspiradora {

	
    public static void main(String args[]) throws IOException 
    { 
    	//CASO 1: Muevo aspiradora sobre ambiente limpio
    	//Cuando la aspiradora se mueve, cambia de zona
    	//casoMoverAspiradora();
    	
    	//CASO 2: muevo aspiradora sobre zona con obstaculo en la fila 0 y columna 1
    	//La aspiradora intentara moverse hacia arriba y luego hacia abajo
    	//casoMoverAspiradoraConObstaculo();

    	//CASO 3:muevo aspiradora sobre zonas con obstáculo y se apaga al no poder moverse
    	//casoMoverAspiradoraConObstaculosSeApaga();
    	
    	//CASO 4: Se agrega aspiradora en el ambiente , se enciende y se limpia
    	//casoAspiradoraLimpiaZona1();
    
    	//CASO 5:La aspiradora se apaga por que los cepillos se ensuciaron
    	//casoAspiradoraSeApagaCepilloSucio();
    	
    	//CASO 6: La aspiradora se apaga por que limpio todo el ambiente
    	//casoAspiradoraLimpiaAmbienteSeApaga();
    	
    	//CASO 7: La aspiradora esta encendida por que no limpio la columna 0 fila 1 del ambiente cocina
    	//El ambiente cocina es una matriz 2x2
    	//casoAspiradoraPrendidaNoLimpioTodoElAmbiente();
    	
    	//CASO 8: Cepillos se ensucian,  se apaga aspiradora y se limpian manualmente
    	//La aspiradora se apaga, se limpian cepillos y se vuelve a encender
    	casoAspiradoraSeLimpiaCepilloManual();
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

    	
    	//Se ensucian las zonas
    	zona1.ensuciar();
    	zona2.ensuciar();
    	zona3.ensuciar();
    	zona4.ensuciar();
    	
    	//Si ningun elemento es nulo, no se agrega la zona y se manda excepcion de que no se puede agregar zona
//    	cocina.agregarZona(zona4);
    	
    	aspiradora = new Aspiradora(cepilloIzquierdo, cepilloDerecho);
    	
    	cocina.agregarAspiradora(aspiradora);
    	
    	//Enciendo aspiradora
    	aspiradora.encender();
    	//Muevo aspiradora hacia la derecha
    	aspiradora.mover("DERECHA");
    	aspiradora.mover("ABAJO");
    	aspiradora.mover("IZQUIERDA");
    	
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
    		System.out.print("La aspiradora esta encendida por que se pudo mover con obstaculo\n"); 
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
    	
    	//cocina.agregarZona(zona4);
    	
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
    		System.out.print("Se apago aspiradora por que encontro varios obstaculos\n"); 
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
 
    
    private static void casoAspiradoraLimpiaAmbienteSeApaga() {
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
    	
    	
    	//Se ensucian las zonas
    	zona1.ensuciar();
    	zona2.ensuciar();
    	zona3.ensuciar();
    	zona4.ensuciar();
    	
    	//Agrega una zona si no se agrego anteriormente
    	//El metodo agregar zona loppea la matriz zonas dentro del ambiente  preguntando si algun elemento es nulo
    	//Si algun elemento es nulo, agrega la zona, 
    	cocina.agregarZona(zona1);
    	cocina.agregarZona(zona2);
    	cocina.agregarZona(zona3);
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
    	
    	//Se apago aspiradora por que limpio todas las zonas
    	if(aspiradora.estaEncendida()) {
    		System.out.print("La aspiradora esta encendida\n"); 
    	}else {
    		System.out.print("Se apago aspiradora por limpiar todo el ambiente\n"); 
    	}
    }

    private static void casoAspiradoraPrendidaNoLimpioTodoElAmbiente() {
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
    	
    	
    	//Se ensucian las zonas
    	zona1.ensuciar();
    	zona2.ensuciar();
    	zona3.ensuciar();
    	zona4.ensuciar();
    	
    	//Agrega una zona si no se agrego anteriormente
    	//El metodo agregar zona loppea la matriz zonas dentro del ambiente  preguntando si algun elemento es nulo
    	//Si algun elemento es nulo, agrega la zona, 
    	cocina.agregarZona(zona1);
    	cocina.agregarZona(zona2);
    	cocina.agregarZona(zona3);
    	cocina.agregarZona(zona4);
    	

    	
    	aspiradora = new Aspiradora(cepilloIzquierdo, cepilloDerecho);
    	
    	cocina.agregarAspiradora(aspiradora);
    	
    	//Enciendo aspiradora
    	aspiradora.encender();
    	//Muevo aspiradora hacia la derecha
    	aspiradora.mover("DERECHA");
    	aspiradora.mover("ABAJO");
    	
    	//La aspiradora esta encendida por que no limpio la columna 0 fila 1
    	if(aspiradora.estaEncendida()) {
    		System.out.print("La aspiradora esta encendida por no limpiar todo el ambiente\n"); 
    	}else {
    		System.out.print("Se apago aspiradora\n"); 
    	}
    } 
    private static void casoAspiradoraSeApagaCepilloSucio() {
    	Ambiente cocina;
    	Zona	 zona1 = new Zona();
    	Zona	 zona2 = new Zona();
    	Zona	 zona3 = new Zona();
    	Zona	 zona4 = new Zona();
    	Zona	 zona5 = new Zona();
    	Zona	 zona6 = new Zona();
    	Zona	 zona7 = new Zona();
    	Zona	 zona8 = new Zona();
    	Zona	 zona9 = new Zona();
    	Zona	 zona10 = new Zona();
    	Aspiradora aspiradora;
    	Cepillo	cepilloIzquierdo = new Cepillo();
    	Cepillo	cepilloDerecho	= new Cepillo();
    	int ancho;
    	int alto;
    	
    	//Crear ambiente 2x5
    	//Cuando se crea ambiente, que es una matriz,  se debe decir el tamaño del ambiente.
    	//Cada elemento de la matriz tiene adentro una zona.
    	ancho = 2;
    	alto = 5;
    	
    	//Se crea cocina
    	cocina = new Ambiente("cocina", ancho, alto);
    	
    	
    	//Se ensucian las zonas
    	zona1.ensuciar();
    	zona2.ensuciar();
    	zona3.ensuciar();
    	zona4.ensuciar();
    	zona5.ensuciar();
    	zona6.ensuciar();
    	zona7.ensuciar();
    	zona8.ensuciar();    
    	zona9.ensuciar();
    	zona10.ensuciar();
    	
    	//Agrega una zona si no se agrego anteriormente
    	//El metodo agregar zona loppea la matriz zonas dentro del ambiente  preguntando si algun elemento es nulo
    	//Si algun elemento es nulo, agrega la zona, 
    	cocina.agregarZona(zona1);
    	cocina.agregarZona(zona2);
    	cocina.agregarZona(zona3);
    	cocina.agregarZona(zona4);
    	cocina.agregarZona(zona5);
    	cocina.agregarZona(zona6);
    	cocina.agregarZona(zona7);
    	cocina.agregarZona(zona8);
    	cocina.agregarZona(zona9);
    	cocina.agregarZona(zona10);
    	

    	
    	aspiradora = new Aspiradora(cepilloIzquierdo, cepilloDerecho);
    	
    	cocina.agregarAspiradora(aspiradora);
    	
    	//Enciendo aspiradora, cuando se enciende, se comienza a limpiar en la zona 0 0
    	aspiradora.encender(); 					//Barridos 1
    	//Muevo aspiradora hacia la derecha
    	aspiradora.mover("DERECHA");			//Barridos 2
    	aspiradora.mover("DERECHA");			//Barridos 3
    	aspiradora.mover("DERECHA");			//Barridos 4
    	aspiradora.mover("DERECHA");			//Barridos 5
    	aspiradora.mover("DERECHA");			//Barridos 6 
    	

    	
    	//La aspiradora se apago por que el cepillo se ensucio al realizar mas de 5 barridos
    	if(aspiradora.estaEncendida()) {
    		System.out.print("La aspiradora esta encendida\n"); 
    	}else {
    		System.out.print("Se apago aspiradora por cepillos sucios\n"); 
    	}
    }
    private static void casoAspiradoraSeLimpiaCepilloManual(){
    	Ambiente cocina;
    	Zona	 zona1 = new Zona();
    	Zona	 zona2 = new Zona();
    	Zona	 zona3 = new Zona();
    	Zona	 zona4 = new Zona();
    	Zona	 zona5 = new Zona();
    	Zona	 zona6 = new Zona();
    	Zona	 zona7 = new Zona();
    	Zona	 zona8 = new Zona();
    	Zona	 zona9 = new Zona();
    	Zona	 zona10 = new Zona();
    	Aspiradora aspiradora;
    	Cepillo	cepilloIzquierdo = new Cepillo();
    	Cepillo	cepilloDerecho	= new Cepillo();
    	int ancho;
    	int alto;
    	
    	//Crear ambiente 2x5
    	//Cuando se crea ambiente, que es una matriz,  se debe decir el tamaño del ambiente.
    	//Cada elemento de la matriz tiene adentro una zona.
    	ancho = 2;
    	alto = 5;
    	
    	//Se crea cocina
    	cocina = new Ambiente("cocina", ancho, alto);
    	
    	
    	//Se ensucian las zonas
    	zona1.ensuciar();
    	zona2.ensuciar();
    	zona3.ensuciar();
    	zona4.ensuciar();
    	zona5.ensuciar();
    	zona6.ensuciar();
    	zona7.ensuciar();
    	zona8.ensuciar();    
    	zona9.ensuciar();
    	zona10.ensuciar();
    	
    	//Agrega una zona si no se agrego anteriormente
    	//El metodo agregar zona loppea la matriz zonas dentro del ambiente  preguntando si algun elemento es nulo
    	//Si algun elemento es nulo, agrega la zona, 
    	cocina.agregarZona(zona1);
    	cocina.agregarZona(zona2);
    	cocina.agregarZona(zona3);
    	cocina.agregarZona(zona4);
    	cocina.agregarZona(zona5);
    	cocina.agregarZona(zona6);
    	cocina.agregarZona(zona7);
    	cocina.agregarZona(zona8);
    	cocina.agregarZona(zona9);
    	cocina.agregarZona(zona10);
    	

    	
    	aspiradora = new Aspiradora(cepilloIzquierdo, cepilloDerecho);
    	
    	cocina.agregarAspiradora(aspiradora);
    	
    	//Enciendo aspiradora, cuando se enciende, se comienza a limpiar en la zona 0 0
    	aspiradora.encender(); 					//Barridos 1
    	//Muevo aspiradora hacia la derecha
    	aspiradora.mover("DERECHA");			//Barridos 2
    	aspiradora.mover("DERECHA");			//Barridos 3
    	aspiradora.mover("DERECHA");			//Barridos 4
    	aspiradora.mover("DERECHA");			//Barridos 5
    	aspiradora.mover("DERECHA");			//Barridos 6 
    	

    	
    	//La aspiradora se apago por que el cepillo se ensucio al realizar mas de 5 barridos
    	if(aspiradora.estaEncendida()) {
    		System.out.print("La aspiradora esta encendida\n"); 
    	}else {
    		System.out.print("Se apago aspiradora por cepillos sucios\n"); 
    	}
    	
    	//Se limpia aspiradora
    	aspiradora.limpiarCepillosManualmente();
    	//Se enciende aspiradora
    	aspiradora.encender();
    	
    	//Se mueve aspiradora esta encendida por que estan los cepillos limpios
    	aspiradora.mover("DERECHA");			//Barridos 6 
    	if(aspiradora.estaEncendida()) {
    		System.out.print("La aspiradora esta encendida por limpieza manual\n"); 
    	}else {
    		System.out.print("Se apago aspiradora\n"); 
    	}
    }
}

