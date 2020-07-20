package tp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import tp.entidades.Camion;
import tp.gui.camiones.AltaCamiones;
import tp.gui.camiones.PanelCamiones;
import tp.gui.util.ControllerException;
import tp.gui.util.DatosObligatoriosException;
import tp.gui.util.FormatoNumeroException;
import tp.servicios.CamionService;

public class CamionController {
	
	private CamionService camionService;
	private Camion c;
	private List<Camion> lista;
	
	//Alta de Camiones para actualizar la tabla cuando se agregue un nuevo camion
	private PanelCamiones panel;
	
	public CamionController(PanelCamiones p) {
		this.camionService = new CamionService();
		this.lista = new ArrayList<Camion>();
		this.panel = p;
		c = new Camion();
	}
	
	//Actualiza tabla si se da de alta un camión
	public void actualizarModelo(AltaCamiones alta) throws DatosObligatoriosException,FormatoNumeroException,ControllerException {
		try {
			if(alta.getTxtPatente()!=null) {
				c.setPatente(alta.getTxtPatente().getText()); 
			} else {
				throw new DatosObligatoriosException("Patente", "La patente es obligatoria");
			}
			if(alta.getTxtModelo()!=null) c.setModelo(alta.getTxtModelo().getText()); 
			if(alta.getTxtMarca()!=null) c.setMarca(alta.getTxtMarca().getText()); 
			if(alta.getTxtKm()!=null) c.setKm(Integer.valueOf(alta.getTxtKm().getText())); 
			//if(alta.getTxtFechaCompra()!=null) c.setPatente(alta.getFechaCompra.getText()); 
		} catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			throw new FormatoNumeroException("Kilometros", "Debe ingresar un valor numerico");
		} catch(Exception e) {
			e.printStackTrace();
			throw new ControllerException("Error:"+e.getLocalizedMessage());
		}
	}
	
	public Camion guardar(AltaCamiones alta) throws DatosObligatoriosException, FormatoNumeroException, ControllerException {
		this.actualizarModelo(alta);
		System.out.println("ACTUALIZADO "+c.toString());
		camionService.crearCamion(c);
		this.lista.clear();
		this.lista.addAll(camionService.buscarTodos()); 
		return null;
	}
	
	
	public List<Camion> listarTodos(){
		this.lista.clear();
		this.lista.addAll(camionService.buscarTodos()); 
		System.out.println("Resultado res   "+lista);
		return this.lista;
	}

}
