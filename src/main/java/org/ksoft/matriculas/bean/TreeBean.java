package org.ksoft.matriculas.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.sf.jooreports.templates.DocumentTemplateException;

import org.ksoft.matriculas.servicio.OdtService;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import fr.opensagres.xdocreport.core.XDocReportException;

@ManagedBean
@ViewScoped
public class TreeBean implements Serializable {

	private static final long serialVersionUID = 382459061437328731L;

    private TreeNode root;
    
    private TreeNode selectedNode;

    private String contribuyente  = "contribuyente";
    private String documento = "documento";
    private String actuacion = "actuacion";
    
    @ManagedProperty("#{odtService}")
    private OdtService odtServicio;
    
    @PostConstruct
    public void init() {
        root = new DefaultTreeNode("Root", null);
        TreeNode node0 = new DefaultTreeNode(contribuyente,"Contribuyente 1", root);
        TreeNode node00 = new DefaultTreeNode(documento,"Carta de Pago IRPF", node0);
    	TreeNode node000 = new DefaultTreeNode(actuacion,"Cargo de Imposición", node00);
    	TreeNode node001 = new DefaultTreeNode(actuacion,"Devolución del cargo", node00);
        	
        TreeNode node01 = new DefaultTreeNode(documento,"Impuesto I.B.I", node0);
	    TreeNode node010 = new DefaultTreeNode(actuacion,"Cargo de Imposición", node01);
    }
    
    public void plantilla() {
    	try {
			//odtServicio.montarPlantillaxDoxConverter("", "");
			odtServicio.montarPlantillaxDox("/home/cajima/apldes/pruebas/documentos/", "/home/cajima/apldes/pruebas/templates/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentTemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XDocReportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    public TreeNode getRoot() {
        return root;
    }

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public String getContribuyente() {
		return contribuyente;
	}

	public String getDocumento() {
		return documento;
	}

	public String getActuacion() {
		return actuacion;
	}

	public void setOdtServicio(OdtService odtServicio) {
		this.odtServicio = odtServicio;
	}
    
    

}
