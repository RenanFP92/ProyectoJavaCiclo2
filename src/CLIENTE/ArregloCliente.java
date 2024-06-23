package CLIENTE;
import java.util.ArrayList;
import Clases.Cliente;

public class ArregloCliente {
	//Campos y atributos 
	private ArrayList <Cliente> miLista;
	private String clienteArchivo = "cliente.txt";  
	
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
	public Cliente obtener() {
		return  miLista.get(i);
		
	}
	//Metodo 
	
	

}
