package org.ksoft.matriculas.servicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateException;
import net.sf.jooreports.templates.DocumentTemplateFactory;

import org.odftoolkit.odfdom.converter.pdf.PdfConverter;
import org.odftoolkit.odfdom.converter.pdf.PdfOptions;
import org.odftoolkit.odfdom.doc.OdfTextDocument;
import org.odftoolkit.odfdom.dom.element.office.OfficeTextElement;
import org.odftoolkit.odfdom.dom.style.OdfStyleFamily;
import org.odftoolkit.odfdom.dom.style.props.OdfParagraphProperties;
import org.odftoolkit.odfdom.dom.style.props.OdfTextProperties;
import org.odftoolkit.odfdom.incubator.doc.office.OdfOfficeStyles;
import org.odftoolkit.odfdom.incubator.doc.style.OdfStyle;
import org.odftoolkit.odfdom.incubator.doc.text.OdfTextHeading;
import org.odftoolkit.odfdom.pkg.OdfFileDom;
import org.springframework.stereotype.Service;

import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

@SuppressWarnings("deprecation")
@Service
public class OdtService {
	
	public void generarPlantilla( String rutaPlantillasOdt) throws Exception {
		//Aqui se crea el Objeto de nuestro ODT
		 //newTextDocument() --> Será un documento de Texto
		 OdfTextDocument odt = OdfTextDocument.newTextDocument();
		 
		 //addText("") --> Con esto se añade una linea de texto con el formato predeterminado.
		 odt.addText("EJEMPLO GENERANDO UN ARCHIVO ODT USANDO LA BIBLIOTECA 'ODF TOOLKIT' - 'ODFDOOM'");
		 
		 //newParagraph() --> Saltamos de Línea, iniciando un nuevo párrafo.
		 odt.newParagraph();
		 
		 //A partir de aquí aplicaremos un estilo simple pero y si queremos
		 //formatear el texto con negrita, cursiva, cambio del tamaño de letra?????
		 //veamos como hacerlo
		 
		 //1.- Creamos un objeto la clase que nos permitirá crear Estilos
		 OdfOfficeStyles estilosOpenOffice = odt.getOrCreateDocumentStyles();
		 
		 //2.- Agregamos las propieades que deseamos
		 //Indico que lo que se formateará es una nuevo Párrafo
		 OdfStyle estiloARC = estilosOpenOffice.newStyle("estilo01", OdfStyleFamily.Paragraph);
		 //Agrego los estilos
		 estiloARC.setProperty(OdfTextProperties.FontStyle, "italic"); //Cursiva
		 estiloARC.setProperty(OdfTextProperties.FontWeight, "bold"); // Negrita
		 estiloARC.setProperty(OdfTextProperties.TextUnderlineStyle, "solid"); //Subrayado
		 estiloARC.setProperty(OdfTextProperties.FontSize, "20pt"); //Tamaño de Letra
		 estiloARC.setProperty(OdfTextProperties.Color, "#ff0000"); // Color de Fuente Rojo
		 estiloARC.setProperty(OdfTextProperties.TextUnderlineColor, "#11ff66"); //Color de Subrayado
		 
		 //--- y si queremos centrarlo???? fácil usamos
		 estiloARC.setProperty(OdfParagraphProperties.TextAlign,"center");
		 
		 //3.- Ahora debemos vincular nuestro estilo al Nodo (parrafo) para aplicarlo
		 //Obtenemos el inicio de nuestro parrafo
		 OfficeTextElement nodoFormateado = odt.getContentRoot();
		 //Creamos el objeto que almacenará nuestro Conetenido.
		 OdfFileDom textoAFormatear = odt.getContentDom();
		 nodoFormateado.appendChild(new OdfTextHeading(textoAFormatear, "estilo01", "PRUEBA ESTILOS"));
		 nodoFormateado.appendChild(new OdfTextHeading(textoAFormatear, "estilo01", "SEGUNDA LINEA FORMATEADA"));
		 
		 //Esto es una prueba de campo para modificar
		 odt.addText("${nombre_contribuyente}");
		 
		 odt.newParagraph();
		 //Nuevamente una linea con el estilo predeterminado
		 odt.addText("ESTO ES TODO POR AHORA");
		 
		 // Guarda el documento en el Disco Duro
		 odt.save(rutaPlantillasOdt+"/pruebaODT.odt"); ///home/cajima/apldes/pruebas
	}

	public void montarPlantilla (String rutaDocumentosOdt, String rutaPlantillasOdt) throws IOException, DocumentTemplateException {
		
		DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
		 
		@SuppressWarnings("unused")
		DocumentTemplate template = documentTemplateFactory.getTemplate(new File(rutaPlantillasOdt+"RUSTICA_ESTIMADO.odt"));
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("flora", "2016-4207");
		data.put("core", "CORE-2016-00001822");
		data.put("nombre_contribuyente", "OSUNA DOMINGUEZ FELIX");
		data.put("nif_contribuyente", "30000000L");
		data.put("representacion_contribuyente", "SOLDEVILLA GÜELL FRANCESC, en representación de");
		data.put("referencia_rusticas", "0050009465237, ILA7971884 e ILO7623349");
		data.put("periodo_deuda", "2006 a 2015");
		data.put("importe_deuda", "3304,38");
		data.put("fecha_solicitud", "25/02/16");
		
//		ImageSource imagen = new RenderedImageSource(ImageIO.read(new File(rutaImagen)));
//		
//		data.put("imagen", imagen);

	    try {

	            OdfTextDocument document = OdfTextDocument.loadDocument( new FileInputStream(rutaDocumentosOdt+"pruebaODT2.odt"));
	            OutputStream out = new FileOutputStream( rutaDocumentosOdt+"pruebaODT2.pdf" );
	            PdfOptions options=PdfOptions.create();

	            PdfConverter.getInstance().convert( document, out, options );
	           } catch (Exception e) {
	            //
	       }
	}
	
	public void montarPlantillaxDox (String rutaDocumentosOdt, String rutaPlantillasOdt) throws IOException, DocumentTemplateException, XDocReportException {
		 final InputStream in = new FileInputStream(new File(rutaPlantillasOdt+"RUSTICA_ESTIMADO.odt"));
		 final IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

		// 2) Create context Java model and add model
		 final IContext data = report.createContext();
			data.put("flora", "2016-4207");
			data.put("core", "CORE-2016-00001822");
			data.put("nombre_contribuyente", "OSUNA DOMINGUEZ FELIX");
			data.put("nif_contribuyente", "30000000L");
			data.put("representacion_contribuyente", "SOLDEVILLA GÜELL FRANCESC, en representación de");
			data.put("referencia_rusticas", "0050009465237, ILA7971884 e ILO7623349");
			data.put("periodo_deuda", "2006 a 2015");
			data.put("importe_deuda", "3304,38");
			data.put("fecha_solicitud", "25/02/16");

		// 3) Generate report by merging Java model with the ODT,
		 // and then converting to PDF
		 final OutputStream out = new FileOutputStream(new File(rutaDocumentosOdt+"pruebaODT5.pdf"));
		 final Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
		 report.convert(data, options, out);
	}
	
	public void montarPlantillaxDoxConverter (String rutaDocumentosOdt, String rutaPlantillasOdt) throws IOException, DocumentTemplateException, XDocReportException {
        long startTime = System.currentTimeMillis();

        try
        {
            // 1) Load odt with ODFDOM
        	InputStream file = new FileInputStream("/home/cajima/apldes/pruebas/templates/"+"RUSTICA_ESTIMADO.odt");
            OdfTextDocument document = OdfTextDocument.loadDocument( file );

            // 2) Convert ODFDOM OdfTextDocument 2 PDF with iText
            File outFile = new File( "/home/cajima/apldes/pruebas/documentos/"+"pruebaODT4.pdf" );
            outFile.getParentFile().mkdirs();

            OutputStream out = new FileOutputStream( outFile );
            PdfOptions options = PdfOptions.create();// PDFViaITextOptions.create().fontEncoding( "windows-1250" );
            PdfConverter.getInstance().convert( document, out, options );
        }
        catch ( Throwable e )
        {
            e.printStackTrace();
        }

        System.out.println( "Generate ODTResume.pdf with " + ( System.currentTimeMillis() - startTime ) + " ms." );
		
	}
}
