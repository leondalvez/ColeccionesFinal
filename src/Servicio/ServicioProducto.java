/*
Se necesita una aplicación para una tienda en la cual queremos almacenar los 
distintos productos que venderemos y el precio que tendrán. Además, se necesita 
que la aplicación cuente con las funciones básicas.
Estas las realizaremos en el servicio. Como, introducir un elemento, modificar 
su precio, eliminar un producto y mostrar los productos que tenemos con su 
precio (Utilizar Hashmap). El HashMap tendrá de llave el nombre del producto y 
de valor el precio. Realizar un menú para lograr todas las acciones previamente 
mencionadas.
 */
package Servicio;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class ServicioProducto {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Scanner leer2 = new Scanner(System.in);
    
    ///Generamos el método que añade productos con su correspondiente precio.
    ///El string en el HashMap será la llave para después modificar precios o
    ///eliminar el producto, el Double al no ser la llave se puede repetir 
    ///permitiendonos tener productos con el mismo precio.
    public void añadirProducto(HashMap<String, Double> p) {
        String opc;
        do {
            System.out.println("Ingrese el nombre del producto");
            String nombre = leer.next();
            System.out.println("Ingrese el precio del producto");
            Double precio = leer2.nextDouble();

            p.put(nombre, precio);

            System.out.println("Desea añadir otro producto?S/N");
            opc = leer.next();

        } while (opc.equalsIgnoreCase("S"));
    }
    
    ///Generamos el método que modifica el precio.
    public void modificarPrecio(HashMap<String, Double> productos) {
        System.out.println("Por favor ingrese el nombre del producto al que "
                + "desea modificar el precio");
        String nombre = leer.next();
        
        ///Si el HashMap contiene la llave nos permite remover el precio del 
        ///producto y modificarlo, de lo conrario notificara al usuario que el
        ///producto no se encuentra en la lista de productos.
        if (productos.containsKey(nombre)) {
            productos.remove(nombre);
            System.out.println("Por favor ingrese el nuevo precio");
            productos.put(nombre, leer.nextDouble());
        } else {
            System.out.println("El producto que ingresó no se encuentra en el "
                    + "registro de productos.");
        }

    }
    
    ///Generamos el método que elimina el producto de la lista.
    public void eliminarProducto(HashMap<String, Double> productos) {
        System.out.println("Por favor ingrese el nombre del producto que desea"
                + " eliminar del registro de productos");
        String nombre = leer.next();
        if (productos.containsKey(nombre)) {
            productos.remove(nombre);
        } else {
            System.out.println("El producto ingresado no se encuentra en el "
                    + "registro.");
        }
    }
    
    ///Generamos el método que nos muestra la lista de productos.
    public void mostrarProductos(HashMap<String, Double> productos) {
        productos.entrySet().forEach((entry) -> {
            System.out.println("Producto: " + entry.getKey() + ". Precio: " 
                    + entry.getValue() + ". ");
        });
    }
    
}
