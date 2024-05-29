package m_03_listadoblementeenlazada;

public class Listadoblenlace {
	//creo las variables con las que voy a trabajar
	protected Nodo inicio;
	protected Nodo fin;
	
	//le digo a la cabeza que por defecto al principio tendra nulo
	public Listadoblenlace() {
		this.inicio = null;
		this.fin = null;
	}
	
	//creo la funcion con la que voy agregar elementos en la cabeza
	public void agregarinicio(int dato) {
		//comprobamos si la lista esta vacia
		if(inicio==null) {
			//creamos un nodo y alli almacenamos, por defecto la cabeza y la cola estan nulas asi que les paso igual
			Nodo nodo = new Nodo(dato,inicio,fin);
			//le almaceno el valor del nodo tando en la cabeza como cola porque ambos son iguales al principio
			inicio = nodo;
			fin = inicio;
		}else {
			//creo el nuevo nodo con el dato, el puntero a la izquierda en nulo, y el de derecha con los datos que ya contiene
			//cuando fue creado previamente
			Nodo nodo = new Nodo(dato,null,inicio);
			//el puntero de inicio le digo que cambie de posicion y a la izquierda hacia el nuevo creado
			inicio.atras=nodo;
			//le paso el puntero nodo a la parte nodo con eso ya se ha movido la posicion del inicio un espacio mas a izq
			inicio = nodo;
		}
	}
	
	//creo la funcion con la que voy agregar elementos en el final
	public void agregarfinal(int dato) {
		//comprobamos si la lista esta vacia
		if(inicio==null) {
			//creamos un nodo y alli almacenamos, por defecto la cabeza y la cola estan nulas asi que les paso igual
			Nodo nodo = new Nodo(dato,inicio,fin);
			//le almaceno el valor del nodo tando en la cabeza como cola porque ambos son iguales al principio
			inicio = nodo;
			fin = inicio;
		}else {
			//creo un nuevo nodo co el dato, el puntero a izquierda con los datos que ya tiene, y el null porque a la derecha
			//debe apuntar por defecto a null
			Nodo nodo = new Nodo(dato,fin,null);
			//el puntero de fin le digo que apunte hacia el nodo, es decir coloque alli el dato y el null
			fin.siguiente=nodo;
			//luego muevo totalmente la punta izquierda de fin a ese nodo creado
			fin = nodo;
		}
	}
	
	//funcion para poder ingresar un numero despues de un cierto numero
	public void colarluegode(int numero,int dato) {
		//creo un nuevo nodo con los datos y los punteros null, porque aun no se a quien apuntara
		Nodo nodo = new Nodo(dato, null, null);
		//cargo los datos de la lista en el auxiliar
		Nodo auxiliar1 = inicio;
		//compruebo que no este vacia la lista
		if(auxiliar1==null) {
			System.out.println("No hay datos en la lista, esta vacia");
		}else {
			//analizo que el dato a buscar si este en la lista
			if(busqueda(numero)==1) {
				//recorro la lista hasta encontrar el dato
				while(auxiliar1!=null) {
					if(auxiliar1.getDato()==numero) {
						if(auxiliar1==fin) {
							//si en caso el elemento esta al final le reutilizo la funcion de ingresar al final
							agregarfinal(dato);
							return;
						}
						//si cumple la condicion al nuevo nodo le digo que si siguiente apunte a siguiente de auxiliar
						//null<--11--><--12--><--13--><--14-->null
						//es decir si el nuevo nodo quiero luego de 12  quiero colocar el 23 
						//el nodo viene (23,atras=null,siguiente=null)
						//entonces le digo que 23.siguiente apunte a 12.siguiente que es el 13
						nodo.siguiente=auxiliar1.siguiente;
						//y 23.atras apunte a auxiliar1 que es 12
						nodo.atras=auxiliar1;
						//luego le digo a 12.siguiente que apunte al nuevo nodo osea 23
						auxiliar1.siguiente=nodo;
						//retorno el valor porque ya no quiero que siga si el trabajo esta realizado
						return;
					}
					//sigo recorriendo el puntero
					auxiliar1=auxiliar1.siguiente;
				}
			}
		}
	}
	
	//contar cuantos elementos contiene la lista
	public int tamaniolista() {
		//cargo los nodos en un auxiliar
		Nodo auxiliar = inicio;
		//compruebo si esta vacio
		if(auxiliar == null) {
			return 0;
		}else {
			//inicio la variable en 0 por lo que tomara los valores en si solo de los nodos con dato
			//no me mostrara haciendo cuenta a los null de ambos lados
			int contado=0;
			while(auxiliar!=null) {
				auxiliar=auxiliar.siguiente;
				contado++;
			}
			return contado;
		}
	}
	
	//funcion para eliminar la cabeza
	public void eliminarcabeza() {
		//compruebo si esta vacia la lista
		if(inicio==null) {
			System.out.println("la lista esta vacia no hay que eliminar");
		}else {
			//compruebo si la lista tiene un solo elemento no le permito eliminar
			if(tamaniolista()==1) {
				System.out.println("¡solo hay un elemento en la lista no seas loco!");
				inicio=null;
				fin=null;
			}else {
				//sino un nodo recorro y me quedo en esa referencia
				inicio=inicio.siguiente;
				//y este nuevo atras le apunto a nulo
				inicio.atras=null;
			}
		}
	}
	
	//funcion para eliminar la cola de la lista
	public void eliminarcola() {
		if(inicio==null) {
			System.out.println("la lista esta vacia no hay dato para eliminar");
		}else {
			if(tamaniolista()==1) {
				System.out.println("¡solo hay un elemento en la lista no seas loco!");
				fin=null;
				inicio=null;
			}else {
				//aqui recorro un espacio a la izquierda
				fin=fin.atras;
				//luego desde ese punto le digo a siguiente que apunte a nulo
				fin.siguiente=null;
			}
		}
	}
	
	//funcion para buscar numero dentro de los nodos
	public int busqueda(int numero) {
		//paso el nodo a auxiliar
		Nodo auxiliar = inicio;
		if(inicio==null) {
			return 0;
		}else {
			//recorro los nodos
			while(auxiliar!=null) {
				//comparo el valor de cada nodo con el numero de la busqueda
				if(auxiliar.getDato()==numero) {
					//si se cumple termino el recorrido y le paso el valor
					return 1;
				}
				//sigo avanzando hacia adelante
				auxiliar=auxiliar.siguiente;
			}
			//si ningun valor a coincidido entonces no hay en la lista y le retorno 0
			return 0;
		}
 	}
	
	//funcion para eliminar un elemento por busqueda
	public void eliminarporbusqueda(int numero) {
		if(inicio==null) {
			System.out.println("La lista esta vacia no hay algo para eliminar");
		}else {
			//control para segurarme si esta o no presente el numero dentro de la lista
			if(busqueda(numero)==1) {
				//creo los dos auxiliares para poder mover los punteros
				//aqui cargo los datos completos de inicio
				Nodo auxiliar1 = inicio;
				//aqui creo el nodo que servira para ir moviendo las posiciones del puntero
				Nodo auxiliar2 = null;
				//recorro el nodo para ir comparando los datos internos con el valor de la busqueda
				while (auxiliar1!=null) {
					if(auxiliar1==fin) {
						//este sirve cuando ya se aya llegado al final de la cola y se parezca entonces reutilizo el metodo 
						//de aliminar cola
						eliminarcola();
						return;
					}else {
						if(auxiliar1.getDato()==numero&&auxiliar1.getDato()==inicio.getDato()) {
							//esto es en caso que el dato buscado este al principio reutilizo el metodo de eliminar la cabeza
							eliminarcabeza();
							return;
						}else {
							//si por algun motivo esta el dato en la parte interna y lo encuentro con el recorrido
							//es decir ya a dado mas de una vuelta para llegar a este condicional
							if(auxiliar1.getDato()==numero) {
								//si entreso por interno se parece
								//el auxiliar2 almacena el valor al que apunta el nodo auxiliar 1 en su apuntador siguiente
								//es decir si habia 13<-->14<-->15
								//13 ya estaba capturado en auxiliar2 pero ahora queremos que este apuntador vaya hacia 15
								//y deje de apuntar al 14
								auxiliar2.siguiente=auxiliar1.siguiente;
								//luego le digo que el auxiliar1 desde el 14 (aque es su valor) apunta a 15 pero este 15 
								//que apunta atras
								//ahora debe apuntar a 13 porque auxiliar2 recordemos que viene por causa del giro con valor 13
								auxiliar1.siguiente.atras=auxiliar2;
								//una vez aya terminado su trabajo le pedimos que retorne porque no hay que mas hacer
								return;
							}
						}
					}
					//aqui es, si no a estado ni en la cabeza ni la cola entonces es forzado a dar una vuelta mas
					//el auxiliar 2 captura la posiciones del auxiliar 1
					//es decir null<--13<-->14<-->15-->null
					//el 13 y sus apuntadores se almacenan en auxiliar 2
					auxiliar2=auxiliar1;
					//luego en el auxiliar 1 le almaceno el 14 y sus apuntadores
					auxiliar1 = auxiliar1.siguiente;
				}
			}else {
				System.out.println("No existe ese numero dentro de la lista doblemente enlazada");
			}
		}
	}
	
	//funcion eliminar por posicion
	public void elimnarposicion(int posicion) {
		//paso los datos al auxiliar
		Nodo auxiliarNodo = inicio;
		//control de que no este nulo o que el tamaño este en cero
		if(inicio==null || tamaniolista()==0) {
			System.out.println("La lista esta vacia no hay algo para eliminar");
		}else {
			//control para datos que envia el user no quiero valores fuera de los valores legales
			if(posicion<0  || posicion>tamaniolista()) {
				System.out.println("No existe esa posicion dentro de la lista");
			}else {
				//si la posicion es la ultima reutilizo la de eliminar la cola
				if(tamaniolista()==posicion) {
					eliminarcola();
					return;
				}else {
					//si me envia la primera posicion asi que alimino la cabeza
					if(posicion==1) {
						eliminarcabeza();
						return;
					}else {
						//el contador empieza en 1 porque en el bucle controla datos fijos entre el 2 y el max-1
						//recordando que el 1 y el fin son controlados mas arriba
						int contador=1;
						//si es una posicion a partir de la 2 entonces debo operarlos
						while(auxiliarNodo!=null) {
							//recorro la lista en busca de la posicion
							//si la condicion se cumple ingreso a trabajar en las posiciones
							if(contador==posicion){
								//almaceno el siguiente valor en el auxiliar 2 es decir si
								//null<--1--><--2--><--3--><--4--><--null
								//y el user me envio la tercer posicion que es el 3, entonces el puntero de este a siguiente
								//lo almaceno en auxiliar2 osea el 4
								Nodo auxiliar2=auxiliarNodo.siguiente;
								//entonces  este valor ahora le guardo en el apuntador del anterior del 3 osea el 2
								//ahora el 2 esta apuntando a 4
								auxiliarNodo.atras.siguiente=auxiliar2;
								//por seguridad le hago basiar el auxiliar 2
								auxiliar2=null;
								//retorno la funcion poruqe no quiero que haga mas cosas degana si ya iso el trabajo
								return;
							}
							//aqui sigo recorriendo con base al while
							auxiliarNodo=auxiliarNodo.siguiente;
							//el contador debe ir aumentando para poder evaluar la igualdad que esta mas arriba
							contador++;
						}
					}
				}
			}
		}
	}
	
	//funcion para poder editar un dato
	public void editar(int numero,int dato) {
		//creo le nuevo nodo que voy a utilizar
		Nodo nodo = new Nodo(dato, null, null);
		//cargo le nodo para poder utilizarlo
		Nodo auxiliar1 = inicio;
		//compruebo que no este vacio
		if(auxiliar1==null) {
			System.out.println("No hay datos en la lista para poder editar");
		}else {
			//compruebo que ese numero este dentro de la lista
			if(busqueda(numero)==1) {
				//recorro la lista en busca del valor
				while(auxiliar1!=null) {
					if(auxiliar1.getDato()==numero) {
						//el momento que lo encuentre le reemplazo con el uso del set 
						auxiliar1.setDato(nodo.getDato());
						return;
					}
					//hago que siga recorriendo el nodo
					auxiliar1=auxiliar1.siguiente;
				}
			}
		}
	}
	
	//funcion para poder leer los datos almacenados	
	public void leernodos() {
		//creo le nodo auxiliar para pasarle los datos
		Nodo auxiliar = inicio;
		if(auxiliar==null) {
			System.out.println("la lista esta vacia");
		}else {
			System.out.print("null");
			//recorro el nodo con sus elementos para imprimirlos
			while (auxiliar!=null) {
				System.out.print("<--"+"["+auxiliar.getDato()+"]"+"-->");
				//el puntero para movimiento cambia de posicion en base al apuntador a la derecha
				auxiliar=auxiliar.siguiente;
			}
			System.out.print("null");
		}
	}
	
	//funcion para poder leer los datos almacenados	de izquiera a derecha
	public void leerdesdeinicio() {
		//creo un nodo auxiliar para cargarle los datos
		Nodo auxiliar = inicio;
		//compruebo que no este vacio
		if(auxiliar==null) {
			System.out.println("la lista esta vacia");
		}else {
			System.out.print("null");
			//recorro el nodo con sus elemento para imprimirlos
			while (auxiliar!=null) {
				System.out.print("<--"+"["+auxiliar.getDato()+"]"+"-->");
				//como el recorrido es hacia la derecha le digo que vaya acia ese apuntador
				auxiliar=auxiliar.siguiente;
			}
			System.out.print("null");
		}
	}
	
	//funcion para poder leer los datos almacenados de derecha a izquierda	
		public void leerdesdefinal() {
			//cargo el nodo final para que desde alli se recorra hacia la izquierda
			Nodo auxiliar = fin;
			if(auxiliar==null) {
				System.out.println("la lista esta vacia");
			}else {
				System.out.print("null");
				//recorro el nodo con sus datos mientras no sea nulo
				while (auxiliar!=null) {
					System.out.print("<--"+"["+auxiliar.getDato()+"]"+"-->");
					//aqui cambia que el apuntador debe correr hacia la izquierda
					auxiliar=auxiliar.atras;
				}
				System.out.print("null");
			}
		}
}
