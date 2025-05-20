//Gabriel Bustamante
//DNI 35.077.617

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Articulo> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Menú de Artículos ---");
            System.out.println("1. Crear artículo");
            System.out.println("2. Listar artículos");
            System.out.println("3. Modificar artículo");
            System.out.println("4. Eliminar artículo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.print("Ingrese una opción válida (número): ");
                sc.nextLine();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> crearArticulo();
                case 2 -> listarArticulos();
                case 3 -> {
                    if (lista.isEmpty()) {
                        System.out.println("No hay artículos para modificar.");
                    } else {
                        modificarArticulo();
                    }
                }
                case 4 -> {
                    if (lista.isEmpty()) {
                        System.out.println("No hay artículos para eliminar.");
                    } else {
                        eliminarArticulo();
                    }
                }
                case 5 -> System.out.println("Gracias por usar el programa. ¡Hasta luego!");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }

    public static void crearArticulo() {
        int id;
        double precio;
        String nombre;

        while (true) {
            try {
                System.out.print("ID: ");
                id = Integer.parseInt(sc.nextLine());

                boolean idRepetido = false;
                for (Articulo a : lista) {
                    if (a.getId() == id) {
                        idRepetido = true;
                        break;
                    }
                }

                if (idRepetido) {
                    System.out.println("Ese ID ya existe. Ingrese uno diferente.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("El ID debe ser numérico.");
            }
        }

        System.out.print("Nombre: ");
        nombre = sc.nextLine();

        while (true) {
            try {
                System.out.print("Precio: ");
                precio = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("El precio debe ser numérico.");
            }
        }

        Articulo nuevo = new Articulo(id, nombre, precio);
        lista.add(nuevo);
        System.out.println("Artículo agregado.");
    }

    public static void listarArticulos() {
        if (lista.isEmpty()) {
            System.out.println("No hay artículos cargados.");
        } else {
            for (Articulo a : lista) {
                a.mostrar();
            }
        }
    }

    public static void modificarArticulo() {
        int id;
        double nuevoPrecio;
        String nuevoNombre;
        Articulo articulo = null;

        while (true) {
            try {
                System.out.print("ID del artículo a modificar: ");
                id = Integer.parseInt(sc.nextLine());
                for (Articulo a : lista) {
                    if (a.getId() == id) {
                        articulo = a;
                        break;
                    }
                }

                if (articulo == null) {
                    System.out.println("No existe un artículo con ese ID. Intente nuevamente.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("El ID debe ser numérico.");
            }
        }

        System.out.print("Nuevo nombre: ");
        nuevoNombre = sc.nextLine();
        articulo.setNombre(nuevoNombre);

        while (true) {
            try {
                System.out.print("Nuevo precio: ");
                nuevoPrecio = Double.parseDouble(sc.nextLine());
                articulo.setPrecio(nuevoPrecio);
                break;
            } catch (NumberFormatException e) {
                System.out.println("El precio debe ser numérico.");
            }
        }

        System.out.println("Artículo actualizado.");
    }

    public static void eliminarArticulo() {
        int id;

        while (true) {
            try {
                System.out.print("ID del artículo a eliminar: ");
                id = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }

        Articulo articuloAEliminar = null;
        for (Articulo a : lista) {
            if (a.getId() == id) {
                articuloAEliminar = a;
                break;
            }
        }

        if (articuloAEliminar != null) {
            lista.remove(articuloAEliminar);
            System.out.println("Artículo eliminado.");
        } else {
            System.out.println("No se encontró un artículo con ese ID.");
        }
    }
}
