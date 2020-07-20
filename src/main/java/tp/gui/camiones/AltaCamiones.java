package tp.gui.camiones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import tp.controller.CamionController;
import tp.gui.util.ControllerException;
import tp.gui.util.DatosObligatoriosException;
import tp.gui.util.FormatoNumeroException;

public class AltaCamiones extends JPanel{
	
	//Titulos
	private JLabel lblTitulo = new JLabel("Administracion de camiones:");
	private JLabel lblSubtitulo = new JLabel("Agregar Camion:");
	
	//Campos
	private JLabel lblPatente = new JLabel("Patente:");
	private JTextField txtPatente;
	private JLabel lblModelo = new JLabel("Modelo:");
	private JTextField txtModelo;
	private JLabel lblMarca = new JLabel("Marca:");
	private JTextField txtMarca;
	private JLabel lblFecha = new JLabel("Fecha de Compra: \n (mm/dd/yyyy)");
	private DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	private JFormattedTextField txtFechaCompra = new JFormattedTextField(df);	
	private JLabel lblKm = new JLabel("Km Recorridos:");
	private JTextField txtKm;
	private JLabel lblCostoKm = new JLabel("Costo por KM: ");
	private JTextField txtCostoKm;
	private JLabel lblCostoHs = new JLabel("Costo por Hora: ");
	private JTextField txtCostoHs;
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	//Otros
	private CamionController controller;
	private CamionTableModel modeloTablaCamion;
	
	public AltaCamiones(CamionTableModel tabla) {
		super();
		this.armarPanel();
		this.modeloTablaCamion = tabla;
		
	}
	
	private void armarPanel() {
		
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		
		
		GridBagConstraints constraints = new GridBagConstraints();
	
		//Titulo
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.VERTICAL;
		constraints.anchor = GridBagConstraints.CENTER;
		//constraints.weightx=1.0;
		//constraints.weighty=(double)(1/16);
		constraints.gridwidth=8;
		constraints.insets = new Insets(0, 0, 15, 0);
		lblTitulo.setFont(new Font("System", Font.BOLD, 20));
		lblTitulo.setForeground(Color.BLACK);
		this.add(lblTitulo,constraints);

		
		//Subtitulo:
		constraints.gridx = 0; //Columna 0 
		constraints.gridy = 1; //Fila 2
		constraints.gridwidth=8;
		constraints.weightx=1.0; //Estira a lo largo, es decir, estira en columnas una misma fila 
		constraints.weighty=(double)(1/16);
		constraints.insets = new Insets(0, 0, 20, 0);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		lblSubtitulo.setFont(new Font("Calibri", Font.BOLD, 15));
		lblSubtitulo.setForeground(Color.BLACK);
		this.add(lblSubtitulo,constraints);
		
		
		//Campos:
		constraints.gridwidth = 1;
		constraints.weightx=0.12; //
		//constraints.weighty=(double)(1/16); 
		constraints.weighty=0;
		constraints.gridheight=1;
		constraints.insets = new Insets(5, 5, 5, 0); //-> Este determina la separación entre objetos.
		constraints.ipadx = 5;
		constraints.ipady=5;
		
		
		//Label Patente
		constraints.gridx = 1;
		constraints.gridy = 2;	
		constraints.fill = GridBagConstraints.NONE; 
		constraints.anchor = GridBagConstraints.LINE_END;
		lblPatente.setPreferredSize(new Dimension(55, 17));
		lblPatente.setFont(new Font("System", Font.PLAIN, 13));
		this.add(lblPatente,constraints);

		
		//TextField Patente
		constraints.gridx = 2; //Va al lado del Label
		constraints.gridy = 2;	
		constraints.fill = GridBagConstraints.HORIZONTAL; 
		constraints.anchor = GridBagConstraints.LINE_START;
		this.txtPatente = new JTextField(0);
		this.txtPatente.setPreferredSize(new Dimension(140, 25));
		this.add(txtPatente,constraints);
		
		//Label Modelo
		constraints.gridx = 3;
		constraints.gridy = 2;	
		constraints.fill = GridBagConstraints.NONE; 
		constraints.anchor = GridBagConstraints.LINE_END;
		this.lblModelo.setPreferredSize(new Dimension(55, 17));
		this.lblModelo.setFont(new Font("System", Font.PLAIN, 13));
		this.add(lblModelo,constraints);
		
		//TextField Modelo
		constraints.gridx = 4; //Va al lado del Label
		constraints.gridy = 2;	
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.fill = GridBagConstraints.HORIZONTAL; 
		this.txtModelo = new JTextField(0);
		this.txtModelo.setPreferredSize(new Dimension(140, 25));			
		this.add(txtModelo,constraints);
		
		//Label Marca
		constraints.gridx = 5;
		constraints.gridy = 2;	
		constraints.fill = GridBagConstraints.NONE; 
		constraints.anchor = GridBagConstraints.LINE_END;
		this.lblMarca.setPreferredSize(new Dimension(55, 17));
		this.lblMarca.setFont(new Font("System", Font.PLAIN, 13));
		this.add(lblMarca,constraints);
		
		//TextField Marca
		constraints.gridx = 6; //Va al lado del Label
		constraints.gridy = 2;	
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.fill = GridBagConstraints.HORIZONTAL; 
		this.txtMarca = new JTextField(0);
		this.txtMarca.setPreferredSize(new Dimension(140, 25));		
		this.add(txtMarca,constraints);
		
		//Label Km Recorridos
		constraints.gridx = 7;
		constraints.gridy = 2;	
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.fill = GridBagConstraints.NONE; 
		this.lblKm.setPreferredSize(new Dimension(100, 17));
		this.lblKm.setFont(new Font("System", Font.PLAIN, 13));
		this.add(lblKm,constraints);
		
		//TextField Km Recorridos
		constraints.gridx = 8;
		constraints.gridy = 2;		
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.fill = GridBagConstraints.HORIZONTAL; 
		this.txtKm = new JTextField(0);	
		this.txtKm.setPreferredSize(new Dimension(100, 25));	
		this.add(txtKm,constraints);	
		
		//Label Fecha de Compra
		constraints.gridx = 1;
		constraints.gridy = 3;		
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.lblFecha.setPreferredSize(new Dimension(200, 17));
		this.lblFecha.setFont(new Font("System", Font.PLAIN, 13));
		this.add(lblFecha,constraints);
		
		//TextField Fecha de Compra:
		constraints.gridx = 2;
		constraints.gridy = 3;	
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.txtFechaCompra = new JFormattedTextField();
		this.txtFechaCompra.setPreferredSize(new Dimension(236, 25));	
		this.add(txtFechaCompra,constraints);
		
		//Label Costo por Km:
		constraints.gridx = 3;
		constraints.gridy = 3;		
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.fill = GridBagConstraints.NONE; 
		this.lblCostoKm.setPreferredSize(new Dimension(77, 17));
		this.lblCostoKm.setFont(new Font("System", Font.PLAIN, 12));
		this.add(lblCostoKm,constraints);
		
		//TextField Costo por Km:
		constraints.gridx = 4;
		constraints.gridy = 3;	
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.txtCostoKm = new JTextField(0);
		this.txtCostoKm.setPreferredSize(new Dimension(236, 25));	
		this.add(txtCostoKm,constraints);
		
		//Label Costo por Hora:
		constraints.gridx = 5;
		constraints.gridy = 3;	
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.fill = GridBagConstraints.NONE;
		this.lblCostoHs.setPreferredSize(new Dimension(86, 17));
		this.lblCostoHs.setFont(new Font("System", Font.PLAIN, 12));
		this.add(lblCostoHs,constraints);
		
		//TextField Costo por Hora:
		constraints.gridx = 6;
		constraints.gridy = 3;		
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.txtCostoHs = new JTextField(0);
		this.txtCostoHs.setPreferredSize(new Dimension(236, 25));	
		this.add(txtCostoHs,constraints);
		
		//Botones
		constraints.fill = GridBagConstraints.NONE;
		
		//Botón Agregar
		constraints.gridx = 7;
		constraints.gridy = 4;	
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.insets = new Insets(20, 15, 15, 0);
		
		this.btnGuardar = new JButton("Agregar");
		this.btnGuardar.setPreferredSize(new Dimension(80,25));
		this.btnGuardar.addActionListener( e ->
			{
				try {
					controller.guardar(this);
				} catch (DatosObligatoriosException | FormatoNumeroException | ControllerException e1) {
					this.mostrarError("Error al guardar", e1.getMessage());
				}
				this.limpiarFormulario();
				modeloTablaCamion.fireTableDataChanged();
				
			}
		);
		this.add(btnGuardar,constraints);
		
		//Botón Cancelar
		constraints.gridx = 8;
		constraints.gridy = 4;	
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.insets = new Insets(20, 15, 15, 0);
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setPreferredSize(new Dimension(80,25));
		this.add(btnCancelar,constraints);
		
		
	}
	
	public void mostrarError(String titulo,String detalle) {
		JFrame padre= (JFrame) SwingUtilities.getWindowAncestor(this);
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.ERROR_MESSAGE);
	}
	
	private void limpiarFormulario() {
		this.txtPatente.setText("");
		this.txtModelo.setText("");
		this.txtMarca.setText("");
		this.txtKm.setText("");
		this.txtFechaCompra.setText("");
	}

	
	//Getters para el Controller a la hora de ejecutar el save o guardar
	public JTextField getTxtPatente() {
		return txtPatente;
	}

	public JTextField getTxtModelo() {
		return txtModelo;
	}

	public JTextField getTxtMarca() {
		return txtMarca;
	}

	public DateFormat getDf() {
		return df;
	}

	public JFormattedTextField getTxtFechaCompra() {
		return txtFechaCompra;
	}

	public JTextField getTxtKm() {
		return txtKm;
	}

	public JLabel getLblCostoKm() {
		return lblCostoKm;
	}

	public JTextField getTxtCostoKm() {
		return txtCostoKm;
	}

	public JLabel getLblCostoHs() {
		return lblCostoHs;
	}

	public JTextField getTxtCostoHs() {
		return txtCostoHs;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public CamionController getController() {
		return controller;
	}
	
	
}
