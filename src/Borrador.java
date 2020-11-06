import java.io.IOException;

public class Borrador {

	
	
    public static void main(String args[]) throws IOException 
    { 
    	
    	//int[][] first = new int[2][2];
    	Zona[][] zonas = new Zona[2][2];
    	zonas[0][0] = new Zona();
        print2D(zonas); 
    }
    
	public static void print2D(Zona mat[][]) 
	{ 
	    // Loop through all rows 
	    for (int i = 0; i < mat.length; i++) 

	        // Loop through all elements of current row 
	        for (int j = 0; j < mat[i].length; j++) 
	            System.out.print(mat[i][j] + " "); 
	} 
}

