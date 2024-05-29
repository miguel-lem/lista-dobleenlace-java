package m_03_listadoblementeenlazada;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		Listadoblenlace listadoblenlace = new Listadoblenlace();
		int opcion,paso;
		do {
			System.out.println("------Opciones------");
			System.out.println("1 para poder ingresar elementos en inicio de lista");
			System.out.println("2 para poder ingresar elementos en final de lista");
			System.out.println("3 para poder ingresar dato despues de un numero");
			System.out.println("4 para poder editar un nodo de la lista");
			System.out.println("5 para eliminar la cabeza de la lista");
			System.out.println("6 para eliminar la cola de la lista");
			System.out.println("7 para eliminar por posicion dentro de la lista");
			System.out.println("8 para eliminar un elemento");
			System.out.println("9 para mostrar lecturas de tanto izquierda como derecha");
			System.out.println("0 si desea salir del programa");
			opcion=teclado.nextInt();
			switch (opcion) {
			case 1: 
				do {
					System.out.println("Ingrese el valor que desea agregar al inicio de la lista");
					int numero = teclado.nextInt();
					listadoblenlace.agregarinicio(numero);
					System.out.println("");
					listadoblenlace.leernodos();
					System.out.println("");
					System.out.println("1 si desea continuar, 0 si desea salir");
					paso = teclado.nextInt();
				} while (paso!=0);
				break;
			case 2: 
				do {
					System.out.println("Ingrese el valor que desea agregar al final de la lista");
					int numero = teclado.nextInt();
					listadoblenlace.agregarfinal(numero);
					System.out.println("");
					listadoblenlace.leernodos();
					System.out.println("");
					System.out.println("1 si desea continuar, 0 si desea salir");
					paso = teclado.nextInt();
				} while (paso!=0);
				break;
			case 3: 
				do {
					System.out.println("Ingrese el numero detras del cual quiere colocar un nuevo nodo");
					int numero = teclado.nextInt();
					System.out.println("Ingrese el dato");
					int dato = teclado.nextInt();
					listadoblenlace.colarluegode(numero, dato);
					System.out.println("");
					listadoblenlace.leernodos();
					System.out.println("");
					System.out.println("1 si desea continuar, 0 si desea salir");
					paso = teclado.nextInt();
				} while (paso!=0);
				break;
			case 4: 
				do {
					System.out.println("Ingrese el numero que quiere editar");
					int numero = teclado.nextInt();
					System.out.println("Ingrese el nuevo numero");
					int dato = teclado.nextInt();
					listadoblenlace.editar(numero, dato);
					System.out.println("");
					listadoblenlace.leernodos();
					System.out.println("");
					System.out.println("1 si desea continuar, 0 si desea salir");
					paso = teclado.nextInt();
				} while (paso!=0);
				break;
			case 5: 
				do {
					System.out.println("Elimando elemento de cabeza de lista");
					listadoblenlace.eliminarcabeza();
					System.out.println("");
					listadoblenlace.leernodos();
					System.out.println("");
					System.out.println("1 si desea continuar, 0 si desea salir");
					paso = teclado.nextInt();
				} while (paso!=0);
				break;
			case 6: 
				do {
					System.out.println("Elimando elemento de cola de la lista");
					listadoblenlace.eliminarcola();
					System.out.println("");
					listadoblenlace.leernodos();
					System.out.println("");
					System.out.println("1 si desea continuar, 0 si desea salir");
					paso = teclado.nextInt();
				} while (paso!=0);
				break;
			case 7: 
				do {
					System.out.println("Ingrese la posicion que desea borrar de la lista");
					int numero = teclado.nextInt();
					listadoblenlace.elimnarposicion(numero);
					System.out.println("");
					listadoblenlace.leernodos();
					System.out.println("");
					System.out.println("1 si desea continuar, 0 si desea salir");
					paso = teclado.nextInt();
				} while (paso!=0);
				break;
			case 8: 
				do {
					System.out.println("Ingrese el valor que desea borrar de la lista");
					int numero = teclado.nextInt();
					listadoblenlace.eliminarporbusqueda(numero);
					System.out.println("");
					listadoblenlace.leernodos();
					System.out.println("");
					System.out.println("1 si desea continuar, 0 si desea salir");
					paso = teclado.nextInt();
				} while (paso!=0);
				break;
			case 9: 
				do {
					System.out.println("Datos leidos de izquierda a derecha");
					listadoblenlace.leerdesdeinicio();
					System.out.println("");
					System.out.println("Datos leidos de derecha a izquierda");
					listadoblenlace.leerdesdefinal();
					System.out.println("");
					System.out.println("1 si desea continuar, 0 si desea salir");
					paso = teclado.nextInt();
				} while (paso!=0);
				break;
			}
			System.out.println("-----Tamaño actual de la lista: "+listadoblenlace.tamaniolista()+" nodos ----");
		} while (opcion!=0);
	}

}
