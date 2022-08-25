/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ucaldas.taller_excepeciones;

import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

/**
 * Taller de Excepciones de Java - Ingenieria de Software 1
 *
 * @author Alejandro González Flórez - 1701913677
 * @author Monica Daniela Sepulveda - 1701321059
 */
public class Taller_Excepeciones {

    public static void main(String[] args) {
        
        /**
         * Los ejercicios 1, 2 y 3 fueron resueltos fuera del código
         * 
         * 1. Al declarar la clase instanciacion le falta extender throws IOExcepction, etc.
         * 
         * 2. Se debe lanzar una ecepción y esta excepción debe ser controlada puesto que se maneja con un TRY CATCH donde
         * se muestra un mensaje en el que la cantidad la boletas no esta en el rango establecido.
         * 
         * 3. Retorná una lista vacia porque al no tener materias inscritasm ka variable retorno sería un arreglo vacio
         */
        
        //ejercicio4("https://raw.githubusercontent.com/AlejoFlorez0/UcaldasProg3_aph/main/Src/BackEnd/.mocharc.json");
        System.out.println(ejercicio4());
        System.out.println(calcularIva());

    }

    /**
     * Se desea un programa que pida al usuario una URL y verifique si el
     * contenido (Content Type) es de tipo texto (text/plain). Si es de tipo
     * texto se debe mostrar este contenido. En caso contrario se muestra al
     * usuario de qué tipo es el contendido. Además, en caso de que la URL tenga
     * algún error o que no se pueda obtener el contenido se debe mostrar un
     * mensaje explicando cuál es el error.
     *
     * @return Mensaje con el tipo de contenido o mensaje de error
     */
    public static String ejercicio4() {

        String _return = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escriba una url");

        try {
            String url = scanner.next();
            URL request = new URL(url);

            URLConnection connection = (URLConnection) request.openConnection();
            connection.connect();
            String contentTypeRaw = connection.getContentType();
            String[] contentType = contentTypeRaw.split(";");

            System.out.println("Tipo de Contenido: " + contentType[0]);
            _return = contentType[0];

        } catch (UnknownHostException e) {
            _return = "No se reconoce la URL";
        } catch (Exception e) {
            _return = "No se puede obtener el contenido, el error es " + e.getMessage();
        }

        return _return;

    }

    /**
     * Escriba el código en Java de un método llamado “calcularIva”, que recibe
     * el precio de un producto (double) y el tipo de producto (String). Este
     * método calcula el valor del IVA de la siguiente forma: es el 19 % para la
     * mayoría de los productos, excepto para los de tipo básico, donde es el 10
     * % y los de tipo cultural, donde es 0 %. Realice algunas pruebas para
     * verificar el funcionamiento del método, y tenga en cuenta las posibles
     * validaciones que se deben realizar (considere si es pertinente o no usar
     * una excepción).
     */
    public static String calcularIva() {
        Scanner scanner = new Scanner(System.in);
        String _return;
        String tipoProducto;
        double precio = 0;
        double valorTotal = 0;

        try {
            do {
                System.out.println("Para salir escriba SALIR");
                System.out.println("Escriba la categoria del producto");
                tipoProducto = scanner.nextLine();
                if (!tipoProducto.toUpperCase().equals("SALIR")) {

                    System.out.println("Escriba el precio del producto");
                    precio = scanner.nextDouble();

                    if (precio > 0) {

                        switch (tipoProducto) {
                            case "Basico":
                                valorTotal += precio + (precio * 0.10);
                                break;
                            case "Cultural":
                                valorTotal += precio;
                                break;
                            default:
                                valorTotal += precio + (precio * 0.19);
                                System.out.println("La categoria ingresada no esta en la lista de categorias reconocidas");
                                break;
                        }
                    }
                }
            } while (!tipoProducto.toUpperCase().equals("SALIR"));

            _return = "El precio a pagar es " + valorTotal;
        } catch (NumberFormatException e) {
            _return = "El precio debe ser un número";
        } catch (NullPointerException e) {
            _return = "El dato ingresado no puede ser nulo o vacio";
        } catch (Exception e) {

            _return = "ERROR GENERAL \n" + e.getMessage();
        }
        return _return;
    }
}
