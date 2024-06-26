// Ejercicio: Clase de problemas de ajedrez
// versión: 20240416
// autor: Carlos grasa lambea

public abstract class PosicionAjedrez {

    // atributos
    private String comentario; // comentario presentación del ejercicio
    private boolean esTurnoBlancas; // es o no turno de las blancas
    private String codigoFen; // posición del tablero
    private int cuantosMovimientos; // número de movimientos para alcanzar el objetivo
    private String objetivo; // meta a conseguir
    private String solucion; // movimento inical que resuelve el problema

    // métodos abstractos
    public abstract void pintarTablero(String codigoFen);
    public abstract boolean validarFen(String codigoFen);

    // constructor
    public PosicionAjedrez() {
        return;
    }
    public PosicionAjedrez(String comentario, String codigoFen, String objetivo, String solucion, int cuantosMovimientos, boolean esTurnoBlancas) {
        this.comentario=comentario;
        this.codigoFen=codigoFen;
        this.objetivo=objetivo;
        this.solucion=solucion;
        this.cuantosMovimientos=cuantosMovimientos;
        this.esTurnoBlancas=esTurnoBlancas;
        return;
    }
    public PosicionAjedrez(String codigoFen) {
        this.codigoFen=codigoFen;
        esTurnoBlancas=true;
        cuantosMovimientos=1;
        objetivo="ganan";
        comentario="Problema de ajedrez.";
        solucion="";
        return;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario=comentario;
        return;
    }
    public boolean getEsTurnoBlancas() {
        return esTurnoBlancas;
    }
    public void setEsTurnoBlancas(boolean esTurnoBlancas) {
        this.esTurnoBlancas=esTurnoBlancas;
        return;
    }
    public String getCodigoFen() {
        return codigoFen;
    }
    public void setCodigoFen(String codigoFen) {
        this.codigoFen=codigoFen;
        return;
    }

    public int getCuantosMovimientos() {
        return cuantosMovimientos;
    }
    public void setCuantosMovimientos(int cuantosMovimientos) {
        this.cuantosMovimientos=cuantosMovimientos;
        return;
    }

    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo=objetivo;
        return;
    }

    public String getSolucion() {
        return solucion;
    }
    public void setSolucion(String solucion) {
        this.solucion=solucion;
        return;
    }
}
