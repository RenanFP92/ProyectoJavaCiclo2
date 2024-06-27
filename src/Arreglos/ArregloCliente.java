package Arreglos;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Clases.Cliente;

public class ArregloCliente {
	//Campos y atributos 
	private ArrayList <Cliente> miLista;
	private String archivo = "Archivos txt/cliente.txt";  


	
	//Metodo constructor 
	public  ArregloCliente () {
		miLista =  new  ArrayList<>();	
	}
	
	//Metodos publicos 
	
	//Metodo tamaño 
	public int tamaño () {
		return miLista.size();
	}
	//Metodo  obtener 
	public Cliente obtener(int i) {
		return miLista.get(i);
	}
	//Metodo agregar 
	public void agregar(Cliente obj) {
		miLista.add(obj);
	}
	//Metodo modificar
	public void modificar(int  i ,Cliente obj) {
		miLista.set(i,obj);
	}
	//Metodo suprimir
	public void suprimir (int i) {
		miLista.remove(i);
	}
	//Metodo buscar
	public int buscar(int codigo) {
		for(int i = 0;i < tamaño();i++) 
			if (obtener(i).getCodigoCliente() == codigo) return i;
			return -1;
		}

	

	
	// Metodos para la gestión de archivos , el try y catch
		public void Grabar() {
			try {	// Crear un archivo en disco
				FileWriter escritor = new FileWriter(archivo);
			     for (int i = 0; i < tamaño(); i++)  
		                escritor.write(miLista.get(i).getCodigoCliente()+ ";" +
		                               miLista.get(i).getNombres()+ ";" +
		                               miLista.get(i).getApellidos() + ";" +
		                               miLista.get(i).getDireccion() + ";" +
		                               miLista.get(i).getTelefono() +  ";" +
		                               miLista.get(i).getDni() + "\n");
		            
		            // Cerrar el archivo
		            escritor.close();
		        } catch (IOException e) {
		            System.out.println("*** ERROR: " + e.getMessage());
		        }
			}
	
		
		//Metodo leer 
		public void Leer() {
			String registro, campos[];
			
			try {
					FileReader lector = new FileReader(archivo);
					BufferedReader lee = new BufferedReader(lector);
					while((registro = lee.readLine()) != null) {
						campos = registro.split(";");
						agregar(new Cliente(Integer.parseInt(campos[0]),
                                campos[1],
                                campos[2],
                                campos[3],
                                campos[4], 
                                campos[5]));
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
		
	

