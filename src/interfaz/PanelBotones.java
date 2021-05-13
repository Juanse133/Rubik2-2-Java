package interfaz;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import controlador.*;

/**
 * Plantilla para instanciar los paneles de botones de movimiento.
 * @author  Giovanni Fajardo Utria
 * @version 1.0.0.
 */
public class PanelBotones extends JPanel implements ActionListener
{
 // Atributos de la clase 		
    private Controlador ctrlControlador;
    private JButton btnDisco0, btnDisco1;
    
 // Constructor 
 /**
  *  Crea un panel con tres botones para realizar los movimientos por discos.
  *  Los parametros row y col se utilizan para visualizar el panel en forma 
  *  horizontal o vertical.
  *  @param ctrlControlador		referencia del controlador.
  *  @param row                         define las filas del esquema GridLayout.
  *  @param col				define la columnas del esquema GridLayout. 
  */  
    public PanelBotones( Controlador ctrlControlador, int row, int col ) 
    {   	
    // ..............................................( T, L, B, R ).............................................
       setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
       setLayout( new GridLayout( row, col ) );
	
    // Integra el controlador
       this.ctrlControlador = ctrlControlador;          
           
    // Instancia atributos de la clase   
       btnDisco0 = new JButton( ".." );
       btnDisco1 = new JButton( ".." );
       
       btnDisco0.addActionListener( this );
       btnDisco1.addActionListener( this );
       
       btnDisco0.setToolTipText("Disco 0");
       btnDisco1.setToolTipText("Disco 1");
           
    // Agrega los atributos al panel   
       add( btnDisco0 ); add( btnDisco1 );
    } 
    
 // Metodos de la clase.         
    public void  actionPerformed( ActionEvent e )
    { 
      if (e.getSource().equals(btnDisco0))  
      {	  ctrlControlador.movimiento( this, 0 );
      }
      else
      {   ctrlControlador.movimiento( this, 1 );
      }    
    }

}