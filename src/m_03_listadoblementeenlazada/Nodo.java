package m_03_listadoblementeenlazada;

public class Nodo {
	//como en la lista enlazada, aqui creo primero la variable para el dato
	private int dato;
	//ahora ya no necesito un apuntador, sino que dos apuntadores, uno que apunte atras y otro adelante
	public Nodo atras,siguiente;
	
	//en el contructor le vamos a pasar los datos y los apuntadores
	public Nodo(int dato,Nodo atras,Nodo siguiente) {
		//indico al contructor que el dato que venga se vaya al elemento de este objeto
		this.dato = dato;
		this.siguiente = siguiente;
		this.atras = atras;
	}
	
	
	//genero los get y set para operar con los datos desde el otro lado
	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}


	public Nodo getAtras() {
		return atras;
	}


	public void setAtras(Nodo atras) {
		this.atras = atras;
	}


	public Nodo getSiguiente() {
		return siguiente;
	}


	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	

	

}
