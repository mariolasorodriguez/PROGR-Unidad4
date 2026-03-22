package plataformacursos;

import java.util.Scanner;

public class MainPlataforma {

    Scanner reader = new Scanner(System.in);
    ListaUsuarios listaUsuarios = new ListaUsuarios();
    ListaContenidos listaContenidos = new ListaContenidos();
    ListaVisualizaciones listaVisualizaciones = new ListaVisualizaciones();

    public static void main(String[] args) {
        MainPlataforma app = new MainPlataforma();
        int opcion;
        do {
            opcion = app.mostrarMenu();
            app.menu(opcion);
        } while (opcion != 7);
        System.out.println("Hasta pronto!");
    }

    int mostrarMenu() {
        System.out.println("\n= PLATAFORMA DE FORMACION =");
        System.out.println("1. Crear usuario");
        System.out.println("2. Crear contenido");
        System.out.println("3. Registrar visualizacion");
        System.out.println("4. Listar usuarios");
        System.out.println("5. Listar contenidos");
        System.out.println("6. Mostrar estadisticas");
        System.out.println("7. Salir");
        System.out.print("Opcion: ");
        int opcion = reader.nextInt();
        reader.nextLine();
        return opcion;
    }

    void menu(int opcion) {
        switch (opcion) {
            case 1: crearUsuario(); break;
            case 2: crearContenido(); break;
            case 3: registrarVisualizacion(); break;
            case 4: listaUsuarios.listarUsuarios(); break;
            case 5: listaContenidos.listarContenidos(); break;
            case 6: mostrarEstadisticas(); break;
            case 7: break;
            default: System.out.println("Opcion no valida."); break;
        }
    }

    void crearUsuario() {
        System.out.print("ID: ");
        String id = reader.nextLine();
        System.out.print("Nombre: ");
        String nombre = reader.nextLine();
        System.out.print("Email: ");
        String email = reader.nextLine();
        System.out.print("Tipo suscripcion (gratuito/mensual/anual): ");
        String tipo = reader.nextLine();

        Usuario usuario = new Usuario(id, nombre, email, tipo);
        boolean resultado = listaUsuarios.añadirUsuario(usuario);

        if (resultado) {
            System.out.println("Usuario añadido correctamente.");
        } else {
            System.out.println("Ya existe un usuario con ese ID.");
        }
    }

    void crearContenido() {
        System.out.print("Codigo: ");
        String codigo = reader.nextLine();
        System.out.print("Titulo: ");
        String titulo = reader.nextLine();
        System.out.print("Duracion (min): ");
        int duracion = reader.nextInt();
        reader.nextLine();
        System.out.print("Categoria: ");
        String categoria = reader.nextLine();
        System.out.print("Nivel (basico/intermedio/avanzado): ");
        String nivel = reader.nextLine();
        System.out.print("Tipo (curso/clase/masterclass): ");
        String tipo = reader.nextLine();
        System.out.print("¿Es premium? (s/n): ");
        boolean premium = reader.nextLine().equalsIgnoreCase("s");

        Contenido contenido = new Contenido(codigo, titulo, duracion, categoria, nivel, tipo, premium);
        boolean resultado = listaContenidos.añadirContenido(contenido);

        if (resultado) {
            System.out.println("Contenido añadido correctamente.");
        } else {
            System.out.println("Ya existe un contenido con ese codigo.");
        }
    }

    void registrarVisualizacion() {
        System.out.print("ID del usuario: ");
        String id = reader.nextLine();
        System.out.print("Codigo del contenido: ");
        String codigo = reader.nextLine();
        System.out.print("Tiempo de visualizacion (min): ");
        int tiempo = reader.nextInt();
        reader.nextLine();
        System.out.print("Fecha: ");
        String fecha = reader.nextLine();

        Usuario usuario = listaUsuarios.buscarPorId(id);
        Contenido contenido = listaContenidos.buscarPorCodigo(codigo);

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
        } else if (contenido == null) {
            System.out.println("Contenido no encontrado.");
        } else {
            boolean resultado = listaVisualizaciones.registrarVisualizacion(usuario, contenido, tiempo, fecha);
            if (resultado) {
                System.out.println("Visualizacion registrada correctamente.");
            } else {
                System.out.println("El usuario no tiene suscripcion para acceder a contenido premium.");
            }
        }
    }

    void mostrarEstadisticas() {
        System.out.println("\n== ESTADISTICAS ==");
        System.out.println("Ingresos totales: " + listaUsuarios.calcularIngresosTotales() + "€");
        System.out.println("Ingresos mensuales: " + listaUsuarios.calcularIngresosPorTipo("mensual") + "€");
        System.out.println("Ingresos anuales: " + listaUsuarios.calcularIngresosPorTipo("anual") + "€");

        Usuario mayorIngreso = listaUsuarios.usuarioMayorIngreso();
        if (mayorIngreso != null) {
            System.out.println("\nUsuario mayor ingreso: " + mayorIngreso.getNombre());
        }

        Usuario masActivo = listaVisualizaciones.usuarioMasActivo(listaUsuarios);
        if (masActivo != null) {
            System.out.println("Usuario mas activo: " + masActivo.getNombre());
        }

        Contenido masConsumido = listaVisualizaciones.contenidoMasConsumido(listaContenidos);
        if (masConsumido != null) {
            System.out.println("Contenido mas consumido: " + masConsumido.getTitulo());
        }
    }
}
