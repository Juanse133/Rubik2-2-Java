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
public class PanelPasos extends JPanel
{
 // Atributos de la clase 		
    private JLabel lblStep;
    
   /**
    *  Constructor
    */      
    public PanelPasos( ) 
    {   	
    // ..............................................( T, L, B, R ).............................................
       //setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
       setLayout( new FlowLayout(  ) );
	
    // Instancia atributos de la clase   
       lblStep = new JLabel( "" );
       lblStep.setFont( new Font("myFont", Font.BOLD, 40) );
       
    // Agrega los atributos al panel   
       add( lblStep );
       
    } 
    
 // Metodos de la clase     
    public void setStep(String step)
    { lblStep.setText(step); 
    }        

}