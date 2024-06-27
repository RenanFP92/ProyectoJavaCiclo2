package Arreglos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Clases.Producto;

public class ArregloProductos {
	//Campos o atributos
	private ArrayList<Producto> miLista;
	private String nombreArchivo = "Archivos txt/productos.txt";
	
	//Método constructor
	public ArregloProductos() {
		miLista = new ArrayList<>();
	}
	
	//Métodos públicos
	public int tamaño() {
		return miLista.size();
	}
	
	public Producto obtener(int i) {
		return miLista.get(i);
	}
	
	public void agregar(Producto ObjA) {
		miLista.add(ObjA);
	}
	
	public void modificar(int i, Producto ObjA) {
		miLista.set(i, ObjA);
	}
	
	public void Suprimir(int i) {
		miLista.remove(i);
	}
	
	public int buscar(int codigo) {
		for(int i = 0; i < tamaño(); i++)
			if(obtener(i).getCodigoProducto() == codigo)return i;
		return -1; 
	}
	
	//Métodos para la gestión de archivos
	public void Grabar() {
		try {	// Crear un archivo en disco
				FileWriter escritor = new FileWriter(nombreArchivo);
				// Grabar la información de la lista dinamica en el archivo
				for(int i = 0; i < tamaño(); i++)
					escritor.write(miLista.get(i).getCodigoProducto() + ";" +
								miLista.get(i).getNombre() + ";" +
								miLista.get(i).getPrecio() + ";" +
								miLista.get(i).getStockActual() + ";" +
								miLista.get(i).getStockMaximo() + ";" +
								miLista.get(i).getStockMinimo() + "\n");
				// Cerrar el archivo
				escritor.close();
		} catch (IOException e) {
				System.out.println("*** ERROR:" + e.getMessage());
		}
	}
	
	public void Leer() {
		String registro, campos[];
		
		try {
				FileReader lector = new FileReader(nombreArchivo);
				BufferedReader lee = new BufferedReader(lector);
				while((registro = lee.readLine()) != null) {
					campos = registro.split(";");
					agregar(new Producto(Integer.parseInt(campos[0]),
										campos[1],
										Double.parseDouble(campos[2]),
										Integer.parseInt(campos[3]), 
										Integer.parseInt(campos[4]),
										Integer.parseInt(campos[5])));
				}
				lee.close();
		} catch (IOException e) {
			System.out.println("*** ERROR:" + e.getMessage());
		}		
	}

	public void limpiar() {
		miLista.clear();		
	}
}
