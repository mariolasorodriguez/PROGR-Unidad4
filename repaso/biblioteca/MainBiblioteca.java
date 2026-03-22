package biblioteca;

import java.util.Scanner;

    public class MainBiblioteca {

        Scanner reader = new Scanner(System.in);
        ListaLibros listaLibros = new ListaLibros();
        ListaSocios listaSocios = new ListaSocios();
        ListaPrestamos listaPrestamos = new ListaPrestamos();

        public static void main(String[] args) {
            MainBiblioteca app = new MainBiblioteca();
            int opcion;
            do {
                opcion = app.mostrarMenu();
                app.menu(opcion);
            } while (opcion != 9);
            System.out.println("Hasta pronto!");
        }

        int mostrarMenu() {
            System.out.println("\n= BIBLIOTECA DIGITAL =");
            System.out.println("-- LIBROS --");
            System.out.println("1. Añadir libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro por ISBN");
            System.out.println("4. Modificar ejemplares");
            System.out.println("5. Eliminar libro");
            System.out.println("-- SOCIOS --");
            System.out.println("6. Añadir socio");
            System.out.println("7. Listar socios");
            System.out.println("8. Buscar socio por DNI");
            System.out.println("9. Modificar email");
            System.out.println("10. Eliminar socio");
            System.out.println("-- PRESTAMOS --");
            System.out.println("11. Registrar prestamo");
            System.out.println("12. Registrar devolucion");
            System.out.println("13. Listar prestamos");
            System.out.println("14. Listar prestamos activos");
            System.out.println("15. Listar libros disponibles");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            int opcion = reader.nextInt();
            reader.nextLine();
            return opcion;
        }

        void menu(int opcion) {
            switch (opcion) {
                case 1: añadirLibro(); break;
                case 2: listaLibros.listarLibros(); break;
                case 3: buscarLibro(); break;
                case 4: modificarEjemplares(); break;
                case 5: eliminarLibro(); break;
                case 6: añadirSocio(); break;
                case 7: listaSocios.listarSocios(); break;
                case 8: buscarSocio(); break;
                case 9: modificarEmail(); break;
                case 10: eliminarSocio(); break;
                case 11: registrarPrestamo(); break;
                case 12: registrarDevolucion(); break;
                case 13: listaPrestamos.listarPrestamos(); break;
                case 14: listaPrestamos.listarPrestamosActivos(); break;
                case 15: listaLibros.listarDisponibles(); break;
                case 0: break;
                default: System.out.println("Opcion no valida."); break;
            }
        }

        void añadirLibro() {
            System.out.print("ISBN: ");
            String isbn = reader.nextLine();
            System.out.print("Titulo: ");
            String titulo = reader.nextLine();
            System.out.print("Autor: ");
            String autor = reader.nextLine();
            System.out.print("Ejemplares disponibles: ");
            int ejemplares = reader.nextInt();
            reader.nextLine();

            Libro libro = new Libro(isbn, titulo, autor, ejemplares);
            boolean resultado = listaLibros.añadirLibro(libro);

            if (resultado) {
                System.out.println("Libro añadido correctamente.");
            } else {
                System.out.println("Ya existe un libro con ese ISBN.");
            }
        }

        void buscarLibro() {
            System.out.print("ISBN: ");
            String isbn = reader.nextLine();

            Libro encontrado = listaLibros.buscarLibro(isbn);

            if (encontrado != null) {
                System.out.println(encontrado);
            } else {
                System.out.println("Libro no encontrado.");
            }
        }

        void modificarEjemplares() {
            System.out.print("ISBN: ");
            String isbn = reader.nextLine();
            System.out.print("Nuevos ejemplares disponibles: ");
            int ejemplares = reader.nextInt();
            reader.nextLine();

            boolean resultado = listaLibros.modificarEjemplares(isbn, ejemplares);

            if (resultado) {
                System.out.println("Ejemplares modificados correctamente.");
            } else {
                System.out.println("Libro no encontrado.");
            }
        }

        void eliminarLibro() {
            System.out.print("ISBN: ");
            String isbn = reader.nextLine();

            Libro encontrado = listaLibros.buscarLibro(isbn);

            if (encontrado != null) {
                System.out.println("¿Esta segur@ de eliminar este libro? s/n");
                System.out.println(encontrado);
                String confirmacion = reader.nextLine();

                if (confirmacion.equalsIgnoreCase("s")) {
                    listaLibros.eliminarLibro(isbn);
                    System.out.println("Libro eliminado correctamente.");
                } else {
                    System.out.println("Operacion cancelada.");
                }
            } else {
                System.out.println("Libro no encontrado.");
            }
        }

        void añadirSocio() {
            System.out.print("DNI: ");
            String dni = reader.nextLine();
            System.out.print("Nombre: ");
            String nombre = reader.nextLine();
            System.out.print("Email: ");
            String email = reader.nextLine();

            Socio socio = new Socio(nombre, dni, email);
            boolean resultado = listaSocios.añadirSocio(socio);

            if (resultado) {
                System.out.println("Socio añadido correctamente.");
            } else {
                System.out.println("Ya existe un socio con ese DNI.");
            }
        }

        void buscarSocio() {
            System.out.print("DNI: ");
            String dni = reader.nextLine();

            Socio encontrado = listaSocios.buscarPorDni(dni);

            if (encontrado != null) {
                System.out.println(encontrado);
            } else {
                System.out.println("Socio no encontrado.");
            }
        }

        void modificarEmail() {
            System.out.print("DNI: ");
            String dni = reader.nextLine();
            System.out.print("Nuevo email: ");
            String email = reader.nextLine();

            boolean resultado = listaSocios.modificarEmail(dni, email);

            if (resultado) {
                System.out.println("Email modificado correctamente.");
            } else {
                System.out.println("Socio no encontrado.");
            }
        }

        void eliminarSocio() {
            System.out.print("DNI: ");
            String dni = reader.nextLine();

            Socio encontrado = listaSocios.buscarPorDni(dni);

            if (encontrado != null) {
                System.out.println("¿Esta segur@ de eliminar este socio? s/n");
                System.out.println(encontrado);
                String confirmacion = reader.nextLine();

                if (confirmacion.equalsIgnoreCase("s")) {
                    listaSocios.eliminarPorDni(dni);
                    System.out.println("Socio eliminado correctamente.");
                } else {
                    System.out.println("Operacion cancelada.");
                }
            } else {
                System.out.println("Socio no encontrado.");
            }
        }

        void registrarPrestamo() {
            System.out.print("DNI del socio: ");
            String dni = reader.nextLine();
            System.out.print("ISBN del libro: ");
            String isbn = reader.nextLine();
            System.out.print("Fecha del prestamo: ");
            String fecha = reader.nextLine();

            Socio socio = listaSocios.buscarPorDni(dni);
            Libro libro = listaLibros.buscarLibro(isbn);

            if (socio == null) {
                System.out.println("Socio no encontrado.");
            } else if (libro == null) {
                System.out.println("Libro no encontrado.");
            } else {
                boolean resultado = listaPrestamos.registrarPrestamo(socio, libro, fecha);
                if (resultado) {
                    System.out.println("Prestamo registrado correctamente.");
                } else {
                    System.out.println("No se pudo registrar el prestamo. Comprueba disponibilidad o limite de prestamos del socio.");
                }
            }
        }

        void registrarDevolucion() {
            System.out.print("DNI del socio: ");
            String dni = reader.nextLine();
            System.out.print("ISBN del libro: ");
            String isbn = reader.nextLine();
            System.out.print("Fecha de devolucion: ");
            String fecha = reader.nextLine();

            boolean resultado = listaPrestamos.registrarDevolucion(dni, isbn, fecha);

            if (resultado) {
                System.out.println("Devolucion registrada correctamente.");
            } else {
                System.out.println("No se encontro el prestamo activo.");
            }
        }
    }
