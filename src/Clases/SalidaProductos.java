package Clases;

public class SalidaProductos {
	    public static void main(String[] args) {
	//nombre de la clase + nombre asignado + []=  new + nombre clase  + [ dimension];

	 // 1:la creacion de nuestro Array Objectos
	        Productos[] listadoProducto  =  new Productos[5];

	 // 1:la introduccion de datos de los objectos ya creados de los argumentos creados metodo constructor 
	        listadoProducto [0] = new Productos ("Flor de Loto",26.0, 34, 33, 45);
	        listadoProducto [1] = new Productos ("Geraneo",19.0, 34, 35 , 56);
	        listadoProducto [2] = new Productos ("Palto",23.0, 35, 60 , 70);
	        listadoProducto [3] = new Productos ("Rosal",23.0, 35, 60 , 70);
	        listadoProducto [4] = new Productos ("Girasol",23.0, 35, 60 , 70);

	    //3: recorrer  el array de objectos atraves de un bucle
	        for (Productos productos : listadoProducto) {
	            System.out.println(productos);


	        }
	    }
}
