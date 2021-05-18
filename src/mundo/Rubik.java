/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Rubik.java,v 1.0 2007/04/14
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
import controlador.Controlador;
import mundo.*;

/**
 * Class Rubik define la abstraccion del cubo de Erno Rubik.
 *
 * @author Giovanni Fajardo Utria.
 * @version 1.0.0
 */
public class Rubik implements Serializable, Cloneable {

    // Atributos
    /**
     * Contenedor de 27 cubos basicos.
     */
    private Cube ernoRubik[][][];

    // Constructores
    /**
     * Constructor por defecto de un cubo de Erno Rubik. <br>
     * <b>post: </b> Crea un cubo de Erno Rubik.
     */
    public Rubik() {
        ernoRubik = new Cube[2][2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    ernoRubik[i][j][k] = new Cube();
                }
            }
        }
    }

    private Cube[][][] getErnoRubik() {
        return ernoRubik;
    }

    /**
     * Retorna el cubo referenciado.
     * <b>pre:  </b> i, j, k Valores: { 0, 1, 2 }
     *
     * @param i fila
     * @param j columna
     * @param k profundidad
     * @return Cube retorna un cubo.
     */
    public Cube cubo(int i, int j, int k) {
        return ernoRubik[i][j][k];
    }

    /**
     * Realiza un corrimiento de los colores de las caras, horizontalmente.
     * <b>pre: </b> El parametro disco debe tener uno de los siguientes valores:
     * { 0, 1, 2 }
     * <b>post: </b> Afecta los cubos del disco referenciado.
     *
     * @param disco disco sobre el cual se realizara el movimiento.
     */
    public void horizontal(int disco) {
        // Cubos basicos afectados girando horizontalmente  
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                ernoRubik[disco][j][k].horizontal();
            }
        }

        // Cubos basicos afectados cambiando de posicion
        Cube aux = ernoRubik[disco][0][0];
        ernoRubik[disco][0][0] = ernoRubik[disco][0][1];
        ernoRubik[disco][0][1] = ernoRubik[disco][1][1];
        ernoRubik[disco][1][1] = ernoRubik[disco][1][0];
        ernoRubik[disco][1][0] = aux;

    }

    /**
     * Realiza un corrimiento de los colores de las caras, verticalmente.
     * <b>pre: </b> El parametro disco debe tener uno de los siguientes valores:
     * { 0, 1, 2 }
     * <b>post: </b> Afecta los cubos del disco referenciado.
     *
     * @param disco disco sobre el cual se realizara el movimiento.
     */
    public void vertical(int disco) {
        // Cubos basicos afectados girando verticalmente  
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                ernoRubik[k][disco][j].vertical();
            }
        }

        //Cubos basicos afectados cambiando de posicion
        Cube aux = ernoRubik[0][disco][0];
        ernoRubik[0][disco][0] = ernoRubik[0][disco][1];
        ernoRubik[0][disco][1] = ernoRubik[1][disco][1];
        ernoRubik[1][disco][1] = ernoRubik[1][disco][0];
        ernoRubik[1][disco][0] = aux;

    }

    /**
     * Realiza un corrimiento de los colores de las caras, transversalmente.
     * <b>pre: </b> El parametro disco debe tener uno de los siguientes valores:
     * { 0, 1, 2 }
     * <b>post: </b> Afecta los cubos del disco referenciado.
     *
     * @param disco disco sobre el cual se realizara el movimiento.
     */
    public void transversal(int disco) {
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                ernoRubik[k][j][disco].transversal();
            }
        }

        // Cubos basicos afectados cambiando de posicion
        Cube aux = ernoRubik[0][0][disco];
        ernoRubik[0][0][disco] = ernoRubik[1][0][disco];
        ernoRubik[1][0][disco] = ernoRubik[1][1][disco];
        ernoRubik[1][1][disco] = ernoRubik[0][1][disco];
        ernoRubik[0][1][disco] = aux;

    }

    public Rubik clone() {
        Rubik clon;
        Cube ernoRubikClone[][][];

        clon = new Rubik();
        ernoRubikClone = clon.getErnoRubik();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    ernoRubikClone[i][j][k].setFrontal(ernoRubik[i][j][k].getFrontal());
                    ernoRubikClone[i][j][k].setDerecha(ernoRubik[i][j][k].getDerecha());
                    ernoRubikClone[i][j][k].setPosterior(ernoRubik[i][j][k].getPosterior());
                    ernoRubikClone[i][j][k].setIzquierda(ernoRubik[i][j][k].getIzquierda());
                    ernoRubikClone[i][j][k].setSuperior(ernoRubik[i][j][k].getSuperior());
                    ernoRubikClone[i][j][k].setInferior(ernoRubik[i][j][k].getInferior());
                }
            }
        }
        return clon;
    }

    /**
     * Movimientos negativos
     */
    public void horizontalN(int disco) {
        horizontal(disco);
        horizontal(disco);
        horizontal(disco);
    }

    public void verticalN(int disco) {
        vertical(disco);
        vertical(disco);
        vertical(disco);
    }

    public void transversalN(int disco) {
        transversal(disco);
        transversal(disco);
        transversal(disco);
    }

}
