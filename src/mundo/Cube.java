/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Cube.java,v 1.0 2007/04/14
 * Universidad Piloto de Colombia (Bogot� - Colombia)
 * Programa de Ingenieria de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Ejercicio: Erno Rubik
 * Autor:Giovanni Fajardo Utria - Abril 14, 2007
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package mundo;

import java.awt.Color;
import java.io.Serializable;

/**
 * Class Cube define la abstraccion de un cubo basico.
 *
 * @author Giovanni Fajardo Utria.
 * @version 1.0
 */
public class Cube implements Serializable {

    /**
     * Definicion de constantes de color.
     */
    private static final Color BLUE_COLOR = java.awt.Color.BLUE;
    private static final Color RED_COLOR = java.awt.Color.RED;
    private static final Color YELLOW_COLOR = java.awt.Color.YELLOW;
    private static final Color GREEN_COLOR = java.awt.Color.GREEN;
    private static final Color WHITE_COLOR = java.awt.Color.WHITE;
    private static final Color ORANGE_COLOR = java.awt.Color.ORANGE;

    // Atributos
    /**
     * Color default para la cara izquierda
     */
    private Color izquierda;

    /**
     * Color default para la cara frontal
     */
    private Color frontal;

    /**
     * Color default para la cara derecha
     */
    private Color derecha;

    /**
     * Color default para la cara posterior
     */
    private Color posterior;

    /**
     * Color default para la cara superior
     */
    private Color superior;

    /**
     * Color default para la cara inferior
     */
    private Color inferior;

    // Constructores  
    /**
     * Constructor por defecto de un cubo. <br>
     * <b>post: </b> Crea un cubo con sus datos b�sicos default.
     */
    public Cube() {
        this.frontal = BLUE_COLOR;
        this.derecha = ORANGE_COLOR;
        this.posterior = GREEN_COLOR;
        this.izquierda = RED_COLOR;
        this.superior = WHITE_COLOR;
        this.inferior = YELLOW_COLOR;
    }

    public Cube(Color fro, Color der, Color pos, Color izq, Color sup, Color inf) {
        this.frontal = fro;
        this.derecha = der;
        this.posterior = pos;
        this.izquierda = izq;
        this.superior = sup;
        this.inferior = inf;
    }

    // Metodos pulsadores   
    /**
     * Devuelve el color de la cara izquierda
     *
     * @return Color de la cara izquierda
     */
    public Color getIzquierda() {
        return this.izquierda;
    }

    /**
     * Cambia el color de la cara
     *
     * @param izq
     */
    public void setIzquierda(Color izq) {
        this.izquierda = izq;
    }

    /**
     * Devuelve el color de la cara frontal
     *
     * @return Color de la cara frontal
     */
    public Color getFrontal() {
        return this.frontal;
    }

    /**
     * Cambia el color de la cara
     *
     * @param fro
     */
    public void setFrontal(Color fro) {
        this.frontal = fro;
    }

    /**
     * Devuelve el color de la cara derecha
     *
     * @return Color de la cara derecha
     */
    public Color getDerecha() {
        return this.derecha;
    }

    /**
     * Cambia el color de la cara
     *
     * @param der
     */
    public void setDerecha(Color der) {
        this.derecha = der;
    }

    /**
     * Devuelve el color de la cara posterior
     *
     * @return Color de la cara posterior
     */
    public Color getPosterior() {
        return this.posterior;
    }

    /**
     * Cambia el color de la cara
     *
     * @param pos
     */
    public void setPosterior(Color pos) {
        this.posterior = pos;
    }

    /**
     * Devuelve el color de la cara superior
     *
     * @return Color de la cara superior
     */
    public Color getSuperior() {
        return this.superior;
    }

    /**
     * Cambia el color de la cara
     *
     * @param sup
     */
    public void setSuperior(Color sup) {
        this.superior = sup;
    }

    /**
     * Devuelve el color de la cara inferior
     *
     * @return Color de la cara inferior
     */
    public Color getInferior() {
        return this.inferior;
    }

    /**
     * Cambia el color de la cara
     *
     * @param inf
     */
    public void setInferior(Color inf) {
        this.inferior = inf;
    }

    // Metodos funcionales 
    /**
     * Realiza un corrimiento de los colores de las caras, horizontalmente. Las
     * caras afectadas son: Frontal, Izquierda, Posterior y Derecha. La cara
     * Inferior gira en su eje, como las manecillas del reloj. La cara Superior
     * gira en su eje, en forma contraria.
     */
    public void horizontal() {
        Color temp = getPosterior();
        setPosterior(getDerecha());
        setDerecha(getFrontal());
        setFrontal(getIzquierda());
        setIzquierda(temp);

    }

    /**
     * Realiza un corrimiento de los colores de las caras, verticalmente. Las
     * caras afectadas son: Frontal, Superior, Posterior e inferior. La cara
     * Izquierda gira en su eje, como las manecillas del reloj. La cara Derecha
     * gira en su eje, en forma contraria.
     */
    public void vertical() {
        Color temp = getPosterior();
        setPosterior(getInferior());
        setInferior(getFrontal());
        setFrontal(getSuperior());
        setSuperior(temp);

    }

    /**
     * Realiza un corrimiento de los colores de las caras, transversalmente. Las
     * caras afectadas son: Superior, Izquierda, Inferior y Derecha. La cara
     * Frontal gira en su eje, como las manecillas del reloj. La cara Posterior
     * gira en su eje, en forma contraria.
     */
    public void transversal() {
        Color temp = getSuperior();
        setSuperior(getIzquierda());
        setIzquierda(getInferior());
        setInferior(getDerecha());
        setDerecha(temp);
    }
}
