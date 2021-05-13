package interfaz;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;
import controlador.Controlador;

/**
 * Panel para invocar futuros requerimientos.
 * @author  Giovanni Fajardo Utria
 * @version 1.0.0.
 */
public class PanelSolucion extends JPanel
{
 // Atributos de la clase 		
    //private Controlador ctrl;
    private JLabel lblSolve;
    
   /**
    *  Constructor
    */      
    public PanelSolucion( ) 
    {   	
    // ..............................................( T, L, B, R ).............................................
       setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( " Solución " ) ) );
       setLayout( new FlowLayout(  ) );
	
    // Integra el controlador
       //this.ctrl = ctrl;          
    
    // Instancia atributos de la clase   
       lblSolve = new JLabel( "" );
       lblSolve.setFont( new Font("myFont", Font.BOLD, 20) );
       
    // Agrega los atributos al panel   
       add( lblSolve );
       
    } 
    
 // Metodos de la clase     
    public void setSolve(String solve)
    { if (!solve.equals("")) lblSolve.setText(solve);        
      else lblSolve.setText("Soluci�n no encontrada...");
    }        

}