// Ejercicio: Clase de problemas de ajedrez
// versión: 20240416
// autor: Carlos grasa lambea

public class Ejercicio extends PosicionAjedrez {
    @Override
    public void pintarTablero(String codigoFen) {
        K.escribir("- La funcionalidad de pintar tablero será implementada en un futuro.\n");
                return;
    }
    @Override
    public boolean validarFen(String codigoFen) {
        K.escribir("- La funcionalidad de validar tablero será implementada en un futuro.\n");
        return true;
    }
    public Ejercicio() {
        super();
        return;
    }
    public Ejercicio(String comentario, String codigoFen, String objetivo, String solucion, int cuantosMovimientos, boolean esTurnoBlancas) {
        super(comentario, codigoFen, objetivo, solucion, cuantosMovimientos, esTurnoBlancas);
        return;
    }
    public Ejercicio(String codigoFen) {
        super(codigoFen);
        return;
    }
}
