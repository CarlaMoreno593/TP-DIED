package tp.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import tp.gui.ayuda.PanelAyuda;
import tp.gui.camiones.PanelCamiones;

// extiende de una ventana en el S.O
public class App extends JFrame {

	//Barra de menú
	JMenuBar menuBar;
	
	
	JMenu menuArchivo;
	JMenu menuEntidades;
	JMenu menuAyuda;
	JMenuItem menuItemAyuda;
	JMenuItem menuItemCamion;
	JMenuItem menuItemSalir;
	
	
	//Constructor por defecto.
	private App() {
	}

	private void armarApp() {
		
	}
}
