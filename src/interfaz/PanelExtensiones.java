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
public class PanelExtensiones extends JPanel implements ActionListener
{
 // Atributos de la clase 		
    private Controlador ctrl;
    private JButton btnExtension1, btnExtension2, btnExtension3;
    private Checkbox chkNegativos;
    
 // Constructor
 /**
  *  @param ctrlControlador		referencia del controlador.
  */      
    public PanelExtensiones( Controlador ctrl ) 
    {   	
    // ..............................................( T, L, B, R ).............................................
       setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( " Extensiones " ) ) );
       setLayout( new FlowLayout(  ) );
	
    // Integra el controlador
       this.ctrl = ctrl;          
    
    // Identificar el panel activo   
       
    // Instancia atributos de la clase   
       btnExtension1 = new JButton( "Cargar" );
       btnExtension2 = new JButton( "Guardar" );
       btnExtension3 = new JButton( "Solucionar" );
       chkNegativos  = new Checkbox("Negativos");
       
       btnExtension1.addActionListener( this );
       btnExtension2.addActionListener( this );
       btnExtension3.addActionListener( this );
      
    // Agrega los atributos al panel   
       add( btnExtension1 ); add( btnExtension2 ); add( btnExtension3 ); add( chkNegativos );
       
    } 
    
 // Metodos de la clase            
    public void  actionPerformed(ActionEvent e)
    {   if (e.getActionCommand().equals( "Cargar" ))
    	{   try
            { ctrl.load();
            }
            catch (IOException ex)
            { }
            catch (ClassNotFoundException ex)
            { }
    	}
        else
       	if (e.getActionCommand().equals( "Guardar" ))
    	{   try
            { ctrl.save();
            }
            catch (IOException ex)
            { }
    	}
        else
        {   ctrl.solve(chkNegativos.getState()); // Solucionar                
        }            
    }    

}