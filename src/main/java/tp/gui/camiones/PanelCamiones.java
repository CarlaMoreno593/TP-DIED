package tp.gui.camiones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import tp.controller.CamionController;
import tp.gui.util.ControllerException;
import tp.gui.util.DatosObligatoriosException;
import tp.gui.util.FormatoNumeroException;

public class PanelCamiones extends JPanel{
	
	
	private JPanel altaCamiones;
	private JPanel busquedaCamiones;
	private JTable tablaCamiones;
	private CamionTableModel modeloTablaCamion; 
	private CamionController controller;
	
	public PanelCamiones(){
		super();
		this.controller= new CamionController(this);
		this.armarPanel();
	}
	
	private void armarPanel() {
		
		//El panel consta de tres partes: Alta de camion, busqueda de camion, tabla de camion con sus dos botones
		
		//Creo el GridBagLayout que tendrá las restricciones
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints constraints = new GridBagConstraints();

		//Alta de Camion:
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth = 8;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.altaCamiones = new AltaCamiones(this.modeloTablaCamion);
		this.add(altaCamiones, constraints);
	
		
		//Busqueda de Camiones:
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth = 8;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.altaCamiones = new BusquedaCamiones(this.modeloTablaCamion);
		this.add(altaCamiones, constraints);
		
		//Tabla de Camiones:
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.gridwidth = 8;
		constraints.weightx=0;
		constraints.insets = new Insets(0, 0, 0, 0);
		modeloTablaCamion = new CamionTableModel(controller.listarTodos());
		tablaCamiones = new JTable();
		tablaCamiones.setModel(modeloTablaCamion);
		JScrollPane scrollPane = new JScrollPane(tablaCamiones);
		tablaCamiones.setFillsViewportHeight(true);
		constraints.gridx = 0;
		constraints.gridy = 3;		
		constraints.gridwidth = 8;
		constraints.weighty=1;
		constraints.weightx=2;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.NORTH;
		this.add(scrollPane,constraints);
		
	}
	
	

	public CamionController getController() {
		return controller;
	}

	public void setController(CamionController controller) {
		this.controller = controller;
	}


	public void mostrarError(String titulo,String detalle) {
		JFrame padre= (JFrame) SwingUtilities.getWindowAncestor(this);
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.ERROR_MESSAGE);
	}

	public JPanel getAltaCamiones() {
		return altaCamiones;
	}

	public void setAltaCamiones(JPanel altaCamiones) {
		this.altaCamiones = altaCamiones;
	}
	
	
	
}
