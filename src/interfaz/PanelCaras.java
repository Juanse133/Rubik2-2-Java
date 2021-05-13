package interfaz;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*; 
import javax.swing.border.*;
import controlador.*;
import mundo.*;

/**
 * Plantilla para instanciar las caras del cubo.
 * @author  Giovanni Fajardo Utria
 * @version 1.0.0.
 */
public class PanelCaras extends JPanel
{
 // Atributos de la clase 			
    private ArrayList  cara;    
    
 // Constructor 
 /**
  *  Constructor por defecto.
  */  
    public PanelCaras(  ) 
    {   	
    // ..............................................( T, L, B, R ).............................................
       setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
       setLayout(new GridLayout(2, 2));
	   
    // Instancia atributos de la clase
       cara = new ArrayList();        
       
       JTextField text;
       for ( int i=0; i<4; i++ )
    	     cara.add( new JTextField(  ) );

       for ( int i=0; i<4; i++ )
       {     text = ( JTextField )cara.get( i );
             text.setEnabled( false );
             add( text );
       }  
       // (( JTextField )cara.get(0)).setText("   X");
    } 

 // Retorna la cara del panel.
 /**
  *  Retorna la cara del panel invocado.
  */     
    public ArrayList getCara(  )
    { return this.cara;       
    }    
}