// ChessTest: aplicación para mantener archivo de problemas de ajedrez
// versión: 20240416
// autor: Carlos grasa lambea

import java.util.SortedMap;
import java.util.TreeMap;

public class ChessTest {

    // atributos
    private SortedMap<String, Ejercicio> ejercicios;
    final char opcionSalir='*';

    public static void main(String[] args) {
        try {
            ChessTest app = new ChessTest();
            app.ejecutarMenu();
        } catch (Exception exc) {
            K.escribir("- Errores en ejecución. Abortando programa.\n");
            K.escribir(exc.getMessage());
            System.exit(1);
        }
        K.escribir("- Programa terminado normalmente.\n");
        return;
    }
    public void ejecutarMenu() {
        ejercicios=new TreeMap<String, Ejercicio>();
        char opcion;
        do {
            presentarMenu();
            opcion=pedirOpcionMenu();
            ejecutarComando(opcion);
        } while (opcion!=opcionSalir);
        K.escribir("\n- Finalizando programa. ");
        pausar();
        return;
    }
    public void presentarMenu() {
        limpiarPantalla();
        K.escribir("---------------------------------------------\n");
        K.escribir("ChessTest - colección de problemas de ajedrez\n");
        K.escribir("Seleccione opción (letra resaltada, "+opcionSalir+" fin)\n");
        K.escribir("---------------------------------------------\n");
        K.escribir("- Cargar los ejercicios guardados\n");
        K.escribir("- Salvar los ejercicios presentes\n");
        K.escribir("- Listar claves de ejercicios\n");
        K.escribir("- Visualizar un ejercicio\n");
        K.escribir("- Generar un nuevo ejercicio\n");
        K.escribir("- Actualizar un ejercicio existente\n");
        K.escribir("- Eliminar un ejercicio existente\n");
        K.escribir("- "+opcionSalir+" (salir)\n");
        K.escribir("---------------------------------------------\n");
        return;
    }
    public char pedirOpcionMenu() {
        return K.preguntarChar("elija su opción", "cslvgae"+opcionSalir);
    }
    public void ejecutarComando(char opcion) {
        switch (opcion) {
            case 'c' -> cargarEjercicios();
            case 's' -> salvarEjercicios();
            case 'l' -> listarEjercicios();
            case 'v' -> visualizarEjercicio();
            case 'g' -> generarEjercicio();
            case 'a' -> actualizarEjercicio();
            case 'e' -> eliminarEjercicio();
            default -> {
                if (opcion!=opcionSalir) K.escribir("\n- Error seleccionando comando de menú.\n");
            }
        }
        return;
    }
    public void cargarEjercicios() {
        limpiarPantalla();
        K.escribir("---------------------------------------------\n");
        K.escribir("Cargando ejercicios en memoria...\n");
        ejercicios.clear();
        ejercicios.put("200", new Ejercicio("Kasparov-Kuijpers (Dortmund, 1980)", "r5k1/1pn1q2p/p2Nbr2/2p2pNQ/P1Bn4/8/1P4PP/4RRK1 w - - 0 1", "juegan y ganan", "Nxf5", 1, true));
        ejercicios.put("199", new Ejercicio("C. lópez - Guedes (Cuba, 1997)", "r1bqr1k1/1p1n1pb1/p1p1p2p/2PpP1p1/1P1P4/2N1P1B1/P1Q1B1PP/3R1RK1 w - - 0 1", "juegan y ganan", "Rxf7", 1, true));
        ejercicios.put("198", new Ejercicio("Mermagen-Kühne (jugada por correspondencia en 1966)", "r3r3/2qn1Qbk/b2p2pp/1npP4/1p6/3NB1NP/1P1R2P1/1B2R1K1 w - - 0 1", "juegan y ganan", "Qxg6", 1, true));
        ejercicios.put("197", new Ejercicio("A. Maric-Stefanova", "1k1r3r/5ppp/2Bb4/p3q3/PnR5/1Q2B3/1P3P1P/1KR5 w - - 0 1", "juegan y ganan", "Nxf5", 1, true));
        ejercicios.put("196", new Ejercicio("Razuvalev-I. Farago (1979)", "r2qr1k1/p3bppN/1p2p2p/n2b3Q/3P3P/2PB4/P4PP1/R1B1R1K1 w - - 0 1", "juegan y ganan", "Bxh6", 1, true));
        ejercicios.put("195", new Ejercicio("C.Hansen-Ki.Georgiez (1984)", "2rq1rk1/pb2np2/1p2pbp1/6Np/3P3P/B1PB2Q1/P4PP1/R3R1K1 w - - 0 11", "juegan y ganan", "Nxe6", 1, true));
        ejercicios.put("194", new Ejercicio("Bordonada-Sanz (Olimpiada de Niza, 1974)", "r1br2k1/2q1bpp1/p2ppB1p/2n3PQ/4P3/1Bp4R/PPP2P1P/2KR4 w - - 0 1", "juegan y ganan", "Qxh6", 1, true));
        ejercicios.put("193", new Ejercicio("Velimirovic-Strikovic (Arandjelovac, 1991)", "r1br2k1/Bpq2ppp/p1P1p3/3n4/4B3/PQ6/1P3PPP/2RR2K1 w - - 0 1", "juegan y ganan", "Bb6", 1, true));
        ejercicios.put("192", new Ejercicio("Bednarski-Korchnoi, tema: doble amenaza.", "r4r2/pp4kp/4Q1n1/2p1n1qP/2Pp4/3P1p2/PP6/R1NN1KR1 b - - 0 0", "juegan y ganan", "... Qg2+", 1, false));
        ejercicios.put("191", new Ejercicio("Gablianskas-Bagaturov (URSS, 1989)", "3r3k/p1r4p/1p3N2/3n3R/3P4/PQq5/6PP/5RK1 w - - 0 0", "juegan y ganan", "Rxd5", 1, true));
        ejercicios.put("a1", new Ejercicio("anónimo", "8/8/1k6/1P4Rp/5PP1/2rn4/6KP/8 b - - 0 37", "juegan y ganan", "... nxf4+, Kf1 rc1+, Kf2 nh3+", 3, false));
        ejercicios.put("m2.1", new Ejercicio("anónimo", "4N3/3p4/Bpp1P1bR/1r1k1p2/nP2RP2/2p5/K1PPN3/7Q w - - 0 0", "juegan ydan mate en 2", "Qb1", 2, true));
        ejercicios.put("m3.1", new Ejercicio("William A Shinkman (1901)", "2R5/3K2k1/8/p7/3P4/8/6p1/1Q6 w - - 0 1", "juegan ydan mate en 3", "Rc2", 3, true));
        ejercicios.put("m1.1", new Ejercicio("anónimo", "6r1/2Q2P2/5k2/5P2/5K2/8/8/8 w - - 0 1", "juegan ydan mate en 1", "fxc8=N#", 1, true));
        ejercicios.put("m2.2", new Ejercicio("Adolf Anderssen - Lionel Kieseritzky (Londres, 1851)", "r1bk2nr/p2p1pNp/n2B4/1p1NP2P/6P1/3P1Q2/P1P1K3/q5b1 w - - 0 1", "juegan y dan mate en 2", "Qf6+ Nxf6, Be7#", 1, true));
        K.escribir("Cargados "+ejercicios.size()+" ejercicios de ajedrez.\n");
        pausar();
        return;
    }
    public void salvarEjercicios() {
        limpiarPantalla();
        K.escribir("---------------------------------------------\n");
        K.escribir("Esta funcionalidad será implementada próximamente.\n");
        pausar();
        return;
    }
    public void visualizarEjercicio() {
        String clave;
        limpiarPantalla();
        K.escribir("---------------------------------------------\n");
        K.escribir("visualizar ejercicio existente:\n");
        if (ejercicios.isEmpty())
            K.escribir("Actualmente no hay ejercicios cargados.\n");
        else {
            clave=K.preguntar("Introduzca la clave del ejercicio");
            if (ejercicios.containsKey(clave))
                mostrarEjercicioEnPantalla(clave);
            else
                K.escribir("Clave de ejercicio no encontrada.\n");
        }
        pausar();
        return;
    }
    public void generarEjercicio() {
        String clave;
        limpiarPantalla();
        K.escribir("---------------------------------------------\n");
        K.escribir("generar nuevo ejercicio:\n");
        clave=K.preguntar("Introduzca clave del ejercicio a generar");
        if (ejercicios.containsKey(clave))
            K.escribir("La clave \'"+clave+"\' ya existe.\n");
        else {
            Ejercicio ejercicio=new Ejercicio();
            pedirDatosEjercicio(ejercicio);
            if (ejercicios.containsValue(ejercicio))
                K.escribir("Ese ejercicio está repetido. Anexión cancelada.\n");
            else {
                ejercicios.put(clave, ejercicio);
                K.escribir("Ejercicio de clave \'"+clave+"\' anexado.\n");
                K.escribir("Actualmente hay "+ejercicios.size()+" ejercicios.\n");
            }
        }
        pausar();
        return;
    }
    public void actualizarEjercicio() {
        String clave;
        Ejercicio ejercicio;
        limpiarPantalla();
        K.escribir("---------------------------------------------\n");
        K.escribir("actualizando ejercicio existente:\n");
        if (ejercicios.isEmpty())
            K.escribir("Actualmente no hay ejercicios cargados.\n");
        else {
            clave=K.preguntar("Introduzca la clave del ejercicio");
            if (ejercicios.containsKey(clave)) {
                ejercicio=ejercicios.get(clave);
                K.escribir("Comentario actual: "+ejercicio.getComentario()+"\n");
                K.escribir("Código FEN actual: "+ejercicio.getCodigoFen()+"\n");
                K.escribir("Objetivo actual: "+ejercicio.getObjetivo()+"\n");
                K.escribir("Solución actual: "+ejercicio.getSolucion()+"\n");
                K.escribir("Número actual de movimientos: "+ejercicio.getCuantosMovimientos()+"\n");
                K.escribir("Turno actual de juego: "+ejercicio.getEsTurnoBlancas()+"\n");
                pedirDatosEjercicio(ejercicio);
                K.escribir("Ejercicio de clave \'"+clave+"\' actualizado.\n");
            } else
                K.escribir("Clave de ejercicio no encontrada.\n");
        }
        pausar();
        return;
    }
    public void eliminarEjercicio() {
        String clave;
        limpiarPantalla();
        K.escribir("---------------------------------------------\n");
        K.escribir("eliminar ejercicio existente:\n");
        if (ejercicios.isEmpty())
            K.escribir("Actualmente no hay ejercicios cargados.\n");
        else {
            clave=K.preguntar("Introduzca clave del ejercicio a eliminar");
            if (ejercicios.containsKey(clave)) {
                ejercicios.remove(clave);
                K.escribir("Eliminado ejercicio de clave \'"+clave+"\'.\n");
            } else
                K.escribir("Clave de ejercicio no encontrada.\n");
        }
        pausar();
        return;
    }
    public void listarEjercicios() {
        Object clave;
        limpiarPantalla();
        K.escribir("---------------------------------------------\n");
        K.escribir("listado de claves de ejercicios presentes:\n");
        if (ejercicios.isEmpty())
            K.escribir("Actualmente no hay ejercicios cargados.\n");
        else {
            clave=ejercicios.firstKey();
            while (clave!=null) {
                K.escribir("\tclave: " + clave + "\n");
                clave=siguienteClave(clave);
            }
            K.escribir("Hay " + ejercicios.size() + " ejercicios.\n");
        }
        pausar();
        return;
    }
    public Object siguienteClave(Object obj) {
        return ((TreeMap) ejercicios).higherKey(obj);
    }
    public void mostrarEjercicioEnPantalla(String clave) {
        Ejercicio ejercicio=ejercicios.get(clave);
        limpiarPantalla();
        K.escribir("---------------------------------------------\n");
        K.escribir("mostrando ejercicio de clave \'"+clave+"\':\n");
        K.escribir(ejercicio.getComentario()+"\n");
        K.escribir("código FEN: "+ejercicio.getCodigoFen()+"\n");
        K.escribir((ejercicio.getEsTurnoBlancas() ? "Blancas " : "Negras ")+ejercicio.getObjetivo()+"\n");
        if (ejercicio.getCuantosMovimientos()>0)
            K.escribir("(Considerar "+ejercicio.getCuantosMovimientos()+(ejercicio.getCuantosMovimientos()==1 ? " movimiento" : " movimientos")+")\n");
        K.preguntar("Pulse INTRO para ver la solución...");
        K.escribir("solución: "+ejercicio.getSolucion()+"\n");
        return;
    }
    public void pedirDatosEjercicio(Ejercicio ejercicio) {
        K.escribir("---------------------------------------------\n");
        K.escribir("introduzca los nuevos datos del ejercicio:\n");
        ejercicio.setComentario(K.preguntar("Introduzca el comentario"));
        ejercicio.setCodigoFen(K.preguntar("Introduzca el código FEN"));
        ejercicio.setObjetivo(K.preguntar("Introduzca el objetivo"));
        ejercicio.setSolucion(K.preguntar("Introduzca la solución"));
        ejercicio.setCuantosMovimientos((int) K.preguntarLong("Introduzca el número de movimientos", 0));
        ejercicio.setEsTurnoBlancas(K.preguntarChar("¿Es turno de las blancas?", "sn")=='s');
        return;
    }
    public void limpiarPantalla() {
        K.escribir("\n".repeat(40));
        return;
    }
    public void pausar() {
        K.preguntar("- Pulse INTRO para continuar...");
        return;
    }
}
