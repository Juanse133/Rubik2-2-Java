/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mundo;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import controlador.Controlador;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

/**
 * @author giovanni-fajardo
 */
public class Execution extends Thread {
	private Controlador ctrl;
	private String lst;
	private Rubik rubik;
	private Hashtable hashRubik;
	private ArrayList<Actions> lstSolve;
	private boolean negState;

	// pruebas de memory /
	private long ta, fa, ua;
	private int idxChild = 0, child[];

	public Execution(Controlador ctrl, Rubik rubik, boolean negState) {
		this.ctrl = ctrl;
		this.lst = "";
		this.rubik = rubik;
		this.negState = negState;
		hashRubik = new Hashtable();
		lstSolve = new ArrayList();

		ta = fa = ua = 0; // Manejo de la memoria memoryRAM()
		child = new int[500000];
		// -----------------------------------------------------
		solve();
	}

	public void run() {
		for (int i = 0; i < lst.length(); i += 2) {
			if (lst.charAt(i) == 'H') {
				this.rubik.horizontal(Integer.parseInt(lst.charAt(i + 1) + ""));
				ctrl.setStep("H" + Integer.parseInt(lst.charAt(i + 1) + ""));
			} else if (lst.charAt(i) == 'V') {
				this.rubik.vertical(Integer.parseInt(lst.charAt(i + 1) + ""));
				ctrl.setStep("V" + Integer.parseInt(lst.charAt(i + 1) + ""));
			} else if (lst.charAt(i) == 'T') {
				this.rubik.transversal(Integer.parseInt(lst.charAt(i + 1) + ""));
				ctrl.setStep("T" + Integer.parseInt(lst.charAt(i + 1) + ""));
			} else if (lst.charAt(i) == '0') {
				if (lst.charAt(i + 1) == 'H') {
					this.rubik.horizontalN(0);
					ctrl.setStep("0H");
				} else if (lst.charAt(i + 1) == 'V') {
					this.rubik.verticalN(0);
					ctrl.setStep("0V");
				} else if (lst.charAt(i + 1) == 'T') {
					this.rubik.transversalN(0);
					ctrl.setStep("0T");
				}
			} else if (lst.charAt(i) == '1') {
				if (lst.charAt(i + 1) == 'H') {
					this.rubik.horizontalN(1);
					ctrl.setStep("1H");
				} else if (lst.charAt(i + 1) == 'V') {
					this.rubik.verticalN(1);
					ctrl.setStep("1V");
				} else if (lst.charAt(i + 1) == 'T') {
					this.rubik.transversalN(1);
					ctrl.setStep("1T");
				}
			}
			ctrl.visualizar(rubik);
			try {
				sleep(100);
			} catch (InterruptedException ex) {
			}
		}
		ctrl.setStep("");
	}

	private String state() {
		String state = "";

		try {
			state = state + face(0, 0, 0, "F") + face(0, 0, 0, "S") + face(0, 0, 0, "I");
			state = state + face(0, 1, 0, "F") + face(0, 1, 0, "S") + face(0, 1, 0, "D");

			state = state + face(1, 0, 0, "F") + face(1, 0, 0, "A") + face(1, 0, 0, "I");
			state = state + face(1, 1, 0, "F") + face(1, 1, 0, "A") + face(1, 1, 0, "D");

			state = state + face(0, 0, 1, "S") + face(0, 0, 1, "P") + face(0, 0, 1, "I");
			state = state + face(0, 1, 1, "S") + face(0, 1, 1, "P") + face(0, 1, 1, "D");

			state = state + face(1, 0, 1, "A") + face(1, 0, 1, "P") + face(1, 0, 1, "I");
			state = state + face(1, 1, 1, "A") + face(1, 1, 1, "P") + face(1, 1, 1, "D");
		} catch (OutOfMemoryError e) { // JOptionPane.showMessageDialog(null, "execution.state() ::
										// OutOfMemoryError....");
		} catch (NoClassDefFoundError e) { // JOptionPane.showMessageDialog(null, "execution.state() ::
											// NoClassDefFoundError....");
		}

		return state;
	}

	private int face(int i, int j, int k, String face) {
		try {
			if (face.equals("F")) {
				if (((Cube) rubik.cubo(i, j, k)).getFrontal().equals(Color.BLUE))
					return 1;
				if (((Cube) rubik.cubo(i, j, k)).getFrontal().equals(Color.ORANGE))
					return 2;
				if (((Cube) rubik.cubo(i, j, k)).getFrontal().equals(Color.GREEN))
					return 3;
				if (((Cube) rubik.cubo(i, j, k)).getFrontal().equals(Color.RED))
					return 4;
				if (((Cube) rubik.cubo(i, j, k)).getFrontal().equals(Color.WHITE))
					return 5;
				if (((Cube) rubik.cubo(i, j, k)).getFrontal().equals(Color.YELLOW))
					return 6;
			} else if (face.equals("D")) {
				if (((Cube) rubik.cubo(i, j, k)).getDerecha().equals(Color.BLUE))
					return 1;
				if (((Cube) rubik.cubo(i, j, k)).getDerecha().equals(Color.ORANGE))
					return 2;
				if (((Cube) rubik.cubo(i, j, k)).getDerecha().equals(Color.GREEN))
					return 3;
				if (((Cube) rubik.cubo(i, j, k)).getDerecha().equals(Color.RED))
					return 4;
				if (((Cube) rubik.cubo(i, j, k)).getDerecha().equals(Color.WHITE))
					return 5;
				if (((Cube) rubik.cubo(i, j, k)).getDerecha().equals(Color.YELLOW))
					return 6;
			} else if (face.equals("P")) {
				if (((Cube) rubik.cubo(i, j, k)).getPosterior().equals(Color.BLUE))
					return 1;
				if (((Cube) rubik.cubo(i, j, k)).getPosterior().equals(Color.ORANGE))
					return 2;
				if (((Cube) rubik.cubo(i, j, k)).getPosterior().equals(Color.GREEN))
					return 3;
				if (((Cube) rubik.cubo(i, j, k)).getPosterior().equals(Color.RED))
					return 4;
				if (((Cube) rubik.cubo(i, j, k)).getPosterior().equals(Color.WHITE))
					return 5;
				if (((Cube) rubik.cubo(i, j, k)).getPosterior().equals(Color.YELLOW))
					return 6;
			} else if (face.equals("I")) {
				if (((Cube) rubik.cubo(i, j, k)).getIzquierda().equals(Color.BLUE))
					return 1;
				if (((Cube) rubik.cubo(i, j, k)).getIzquierda().equals(Color.ORANGE))
					return 2;
				if (((Cube) rubik.cubo(i, j, k)).getIzquierda().equals(Color.GREEN))
					return 3;
				if (((Cube) rubik.cubo(i, j, k)).getIzquierda().equals(Color.RED))
					return 4;
				if (((Cube) rubik.cubo(i, j, k)).getIzquierda().equals(Color.WHITE))
					return 5;
				if (((Cube) rubik.cubo(i, j, k)).getIzquierda().equals(Color.YELLOW))
					return 6;
			} else if (face.equals("S")) {
				if (((Cube) rubik.cubo(i, j, k)).getSuperior().equals(Color.BLUE))
					return 1;
				if (((Cube) rubik.cubo(i, j, k)).getSuperior().equals(Color.ORANGE))
					return 2;
				if (((Cube) rubik.cubo(i, j, k)).getSuperior().equals(Color.GREEN))
					return 3;
				if (((Cube) rubik.cubo(i, j, k)).getSuperior().equals(Color.RED))
					return 4;
				if (((Cube) rubik.cubo(i, j, k)).getSuperior().equals(Color.WHITE))
					return 5;
				if (((Cube) rubik.cubo(i, j, k)).getSuperior().equals(Color.YELLOW))
					return 6;
			} else if (face.equals("A")) {
				if (((Cube) rubik.cubo(i, j, k)).getInferior().equals(Color.BLUE))
					return 1;
				if (((Cube) rubik.cubo(i, j, k)).getInferior().equals(Color.ORANGE))
					return 2;
				if (((Cube) rubik.cubo(i, j, k)).getInferior().equals(Color.GREEN))
					return 3;
				if (((Cube) rubik.cubo(i, j, k)).getInferior().equals(Color.RED))
					return 4;
				if (((Cube) rubik.cubo(i, j, k)).getInferior().equals(Color.WHITE))
					return 5;
				if (((Cube) rubik.cubo(i, j, k)).getInferior().equals(Color.YELLOW))
					return 6;
			}
		} catch (OutOfMemoryError e) { // JOptionPane.showMessageDialog(null, "execution.face() ::
										// OutOfMemoryError....");
		} catch (NoClassDefFoundError e) { // JOptionPane.showMessageDialog(null, "execution.face() ::
											// NoClassDefFoundError....");
		}

		return 0;
	}

	/**
	 * Genera la busqueda en anchura
	 */
	private void solve() {
		Rubik rubikClone;
		Rubik rubikInit;
		String state, stateGoal;
		boolean swGoal = false;
		int index = 0;

		// Instrucciones para generar la solucion -----------------------

		// Estado objetivo
		stateGoal = "154152164162534532634632";

		// Estado inicial
		rubikInit = rubik.clone();
		lstSolve.add(new Actions(index, "init", rubik));

		try {
			while (!swGoal) {
				rubikClone = ((Rubik) lstSolve.get(index).getRubik()).clone();
				rubik = ((Rubik) lstSolve.get(index).getRubik()).clone();

				// Movimientos positivos ...

				// rubik.movimientos H0, H1, V0, V1, T0, T1
				 rubik.horizontal(0);
				 if(search(rubik, state(), "H0", index, stateGoal))break;
				 rubik = rubikClone.clone();
				 
				 rubik.horizontal(1);
				 if(search(rubik, state(), "H1", index, stateGoal))break;
				 rubik = rubikClone.clone();
				 
				 rubik.vertical(0);
				 if(search(rubik, state(), "V0", index, stateGoal))break;
				 rubik = rubikClone.clone();
				 
				 rubik.vertical(1);
				 if(search(rubik, state(), "V1", index, stateGoal))break;
				 rubik = rubikClone.clone();
				 
				 rubik.transversal(0);
				 if(search(rubik, state(), "T0", index, stateGoal))break;
				 rubik = rubikClone.clone();
				 
				 rubik.transversal(1);
				 if(search(rubik, state(), "T1", index, stateGoal))break;
				 rubik = rubikClone.clone();
				 
				// state()); "154152146162534532634632"
				// search( .... );
				// rubikClone.clone();

				// Movimientos negativos
				if (negState) {
					rubik.horizontalN(0);
					 if(search(rubik, state(), "0H", index, stateGoal))break;
					 rubik = rubikClone.clone();
					 
					 rubik.horizontalN(1);
					 if(search(rubik, state(), "1H", index, stateGoal))break;
					 rubik = rubikClone.clone();
					 
					 rubik.verticalN(0);
					 if(search(rubik, state(), "0V", index, stateGoal))break;
					 rubik = rubikClone.clone();
					 
					 rubik.verticalN(1);
					 if(search(rubik, state(), "1V", index, stateGoal))break;
					 rubik = rubikClone.clone();
					 
					 rubik.transversalN(0);
					 if(search(rubik, state(), "0T", index, stateGoal))break;
					 rubik = rubikClone.clone();
					 
					 rubik.transversalN(1);
					 if(search(rubik, state(), "1T", index, stateGoal))break;
					 rubik = rubikClone.clone();

				}
				index++;
			}

			index = lstSolve.get(lstSolve.size() - 1).getPredecessor();
			lst = lstSolve.get(lstSolve.size() - 1).getAction() + lst;

			while (lstSolve.get(index).getAction() != "init") {
				lst = lstSolve.get(index).getAction() + lst;
				index = lstSolve.get(index).getPredecessor();
			}

		} catch (OutOfMemoryError e) { // JOptionPane.showMessageDialog(null, "execution.solve() ::
										// OutOfMemoryError....");
		} catch (NoClassDefFoundError e) { // JOptionPane.showMessageDialog(null, "execution.solve() ::
											// NoClassDefFoundError....");
		}

		rubik = rubikInit;
		ctrl.setSolve(lst);
		// --------------------------------------------------------------
	}

	private void memoryRAM() {
		int dataSize = 1024 * 1024;

		Runtime runtime = Runtime.getRuntime();

		/*
		 * System.out.println ("Memoria maxima: " + runtime.maxMemory() / dataSize +
		 * "MB"); System.out.println ("Memoria total : " + runtime.totalMemory() /
		 * dataSize + "MB"); System.out.println ("Memoria libre : " +
		 * runtime.freeMemory() / dataSize + "MB"); System.out.println
		 * ("Memoria usada : " + (runtime.totalMemory() - runtime.freeMemory()) /
		 * dataSize + "MB");
		 */

		long tn, fn, un;

		tn = runtime.totalMemory() / dataSize;
		fn = runtime.freeMemory() / dataSize;
		un = (runtime.totalMemory() - runtime.freeMemory()) / dataSize;

		if (tn != ta || fn != fa || un != ua) { // System.out.print (tn + " TMB : ");
												// System.out.print (fn + " FMB : ");
												// System.out.println (un + " UMB");
		}

		ta = tn;
		fa = fn;
		ua = un;
	}

	// H0,H1..
	private boolean search(Rubik rubik, String state, String action, int index, String stateGoal) {
		if (hashRubik.get(state) == null) {
			hashRubik.put(state, "");
			lstSolve.add(new Actions(index, action, rubik));

			if (idxChild == index)
				child[idxChild]++;
			else {
				idxChild = index;
				child[idxChild]++;
			}

			if (state.equals(stateGoal))
				return true;
		} else { // System.out.println("lstSolve.size() : " + lstSolve.size());

		}
		return false;
	}
}