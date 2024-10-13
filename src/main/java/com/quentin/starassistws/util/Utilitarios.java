package com.quentin.starassistws.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Utilitarios {
		
    //GET IP DEL CLIENTE
    public static String getClientIp(HttpServletRequest request) {
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }
    
    private static String getServerIp() {
		//GET IP DEL SERVIDOR
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			String ipAddress = addr.getHostAddress();	        
	        //Hostname
	        String hostname = addr.getHostName();
	    	return ipAddress ;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "";
    }
    
    public static File stream2file (InputStream in, String ContentType) throws IOException {
    	
    	 String PREFIX = "stream2file";
    	 String SUFFIX = ".tmp";
    	 
    	 if(ContentType.contentEquals("text/xml")) {
    		 SUFFIX=".xml";
    	 }
    	    
        final File tempFile = File.createTempFile(PREFIX, SUFFIX);
        tempFile.deleteOnExit();
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(in, out);
        }
        return tempFile;
    }
    
    public static File getTempFile(MultipartFile multipartFile) throws IOException
    {
    	
    	
    	File file=null;
    	String absPath =null;
        CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) multipartFile;
        FileItem fileItem = commonsMultipartFile.getFileItem();
        if(fileItem!=null) {
        	DiskFileItem diskFileItem = (DiskFileItem) fileItem;
        	if(diskFileItem!=null) {
        		if(diskFileItem.getStoreLocation()!=null) {
        			absPath = diskFileItem.getStoreLocation().getAbsolutePath();
        		}
        		
        	}
        	
        	if(absPath!=null) {
        		file = new File(absPath);
           	 //trick to implicitly save on disk small files (<10240 bytes by default)
               if (!file.exists()) {
                   file.createNewFile();
                   multipartFile.transferTo(file);
               }
        	}else {
        		file=stream2file(multipartFile.getInputStream(), multipartFile.getContentType());
        		
        	}
        	
        	
        }
        
        return file;
    }
    
  

    public static String getTextValue(String def, Element doc, String tag) {
        String value = def;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
          value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }
    
    public static String getPath(String ruta, HttpServletRequest request){
    	String path="";
    	try {
//    		ServletContext servletContext = (ServletContext) (FacesContext.getCurrentInstance().getExternalContext().getContext());
    		ServletContext servletContext = request.getServletContext();
        	path = servletContext.getRealPath(ruta);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	return path;
    }
    
    public static byte[] exportPdf(String jasperFile, Map<String, Object> parameters, List<?> dataList) throws Exception {
        
    	JasperReport report = JasperCompileManager.compileReport(jasperFile);
    	JasperPrint jasperPrint=null;
    	if(dataList!=null) {
    		 jasperPrint = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(dataList));
    	}else {
    		 jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
    	}
        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JRPdfExporter jRPdfExporter = new JRPdfExporter();
        jRPdfExporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
        jRPdfExporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
        jRPdfExporter.exportReport();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        jRPdfExporter = null;
        return bytes;
    }
   
    
  
   
    
    public static String renombrarArchivo(String nombreArchivo){
        String nombre="";
        nombre=nombreArchivo.replaceAll("\"", "")
	                         .replaceAll("amp;", "")
	                         .replaceAll(":", "_")
	                         .replaceAll("\'", "")
	                         .replaceAll("\\?", "")
	                         .replaceAll("\\=", "")
	                         .replaceAll(" ", "_")
	                         .replaceAll("	", "")
	                         .replaceAll("	", "")
	                         .replaceAll("_-_", "")
	                         .replaceAll("___", "")
	                         .replaceAll("___ ", "")
	                         .replaceAll(" ___", "")
	                         .replaceAll(" s.a.", "")
        					 .replaceAll(".-", "");
        
        SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyyhhmmss");
        nombre=sdf.format(new Date())+"_"+nombre;
        
        return nombre;
    }
    
    public static String generarNombreAleatorio(String tcoduprov) {
    	String nombre="";
    	SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyyhhmmss");
    	int numero = (int)(Math.random()*1000000000+1);
        nombre=numero+"_"+sdf.format(new Date())+"_"+tcoduprov;
    	return nombre;
    }
    
    public static String combinacion131And141(String nombre) {
    	String resultado="";
    	
    	return resultado;
    }
    
    public static String depurarNombreArchivoFactElec(String nombreArchivo) {
    	String nombre="";
    	nombreArchivo=nombreArchivo.replaceAll("Â", "").replaceAll("Ã", "").replaceAll("ª", "")+"";
    	char [] lista=nombreArchivo.toCharArray();
    	int pos1311=0, pos1312=0;
    	int cant=0;
    	boolean existe13and1147=false;
    	int possolo147=0;
    	
    	for( int i=0; i<lista.length; i++) {
    		int ascii = (int)lista[i];
//    		System.out.println(" a => "+lista[i]+"-ascii: "+ascii);
    		if(ascii==131 ) {
    			if(cant==0) {
    				pos1311=i;
        			cant++;
    			}else {
    				pos1312=i;
        			cant++;
    			}    			
    		}else if(ascii==147) {
    			possolo147=i;
    		}
    	}
    	
    	if(pos1311<lista.length-1 && pos1311>0) {
    		int val141=lista[pos1311+1];
    		if(val141==147) {
    			existe13and1147=true;
    		}
    	}
    	
//    	System.out.println(" existe13and1147=>"+existe13and1147+" cant=>"+cant);
    	
    	if(cant==1) {
    		if(existe13and1147) {
    			for( int i=0; i<lista.length; i++) {
        			if(i<pos1311) {
        				nombre=nombre+lista[i];
        			}else if(i==pos1311) {
        				nombre=nombre+"Ã";
        			}else if(i==pos1311+1) {
        				
        			}else {
        				nombre=nombre+lista[i];
        			}
        		}
    		}
    	}else if(possolo147>0) {
    		for( int i=0; i<lista.length; i++) {
    			
    			int val147=lista[i];
    			
    			if(val147==147) {
    				nombre=nombre+"Ó";
    			}else {
    				nombre=nombre+lista[i];
    			}
    		}
    	}else {
    		nombre=nombreArchivo;
    	}
    	
    	return nombre;
    }
    
    public static String depurarNombreArchivoGuia(String nombreArchivo) {
    	
    	nombreArchivo=nombreArchivo.replaceAll("Â", "").replaceAll("Ã", "").replaceAll("ª", "")+"";
    	String nombre="";
    	char [] lista=nombreArchivo.toCharArray();
    	int pos1311=0, pos1312=0, possolo147=0;
    	int cant=0;
    	boolean existe13and1141=false, existe13and1147=false;
    	
    	/*buscar 131 - 141*/
    	for( int i=0; i<lista.length; i++) {
    		int ascii = (int)lista[i];
    		
    		if(ascii==131 ) {
    			if(cant==0) {
    				pos1311=i;
        			cant++;
    			}else {
    				pos1312=i;
        			cant++;
    			}    			
    		}else if(ascii==147) {
    			possolo147=i;
    		}
    	}
    	

    	
    	if(pos1311<lista.length-1 && pos1311>0) {
    		int val141=lista[pos1311+1];
    		if(val141==141) {
    			existe13and1141=true;
    		}
    	}
    	
    	if(pos1312<lista.length-1 && pos1312>0) {
    		int val147=lista[pos1312+1];
    		if(val147==147) {
    			existe13and1147=true;
    		}
    	}
    	
//    	System.out.println(" pos1311 =>"+pos1311+" pos1312=>"+pos1312);
    	
    	/*buscar 131 - 141*/ /* 131 - 147*/
    	
    	if(existe13and1141 && existe13and1147) {
    		for( int i=0; i<lista.length; i++) {
        		
        		if(i<pos1311) {
        			nombre=nombre+lista[i];
        		}else if(i==pos1311) {
        			nombre=nombre+"Ã�?";
//        			nombre=nombre+"";
        		}else if(i==pos1311+1) {
//        			nombre=nombre+"";
//        		}else if(i==pos1311+2) {
//        			nombre=nombre+"";
        		}else if(i==pos1312) {
        			nombre=nombre+"Ã";
        		}else if(i==pos1312+1) {
//        			nombre=nombre+"";
//        		}else if(i==pos1312+2) {
//        			nombre=nombre+"";
        		}
        		else {
        			nombre=nombre+lista[i];
        		}
//        		System.out.println("posicion: "+i+" nombre=>"+nombre);
        	}
    	}else if(existe13and1141==false && existe13and1147==true) {
    		for( int i=0; i<lista.length; i++) {
    			if(i<pos1311) {
    				nombre=nombre+lista[i];
    			}else if(i==pos1311) {
    				nombre=nombre+"Ã";
    			}else if(i==pos1311+1) {
    				
    			}else if(i==pos1312) {
    				nombre=nombre+"Ã";
    			}else if(i==pos1312+1) {
    				
    			}else {
    				nombre=nombre+lista[i];
    			}
    		}
    	}else if(possolo147>0) {
    		for( int i=0; i<lista.length; i++) {
    			
    			int val147=lista[i];
    			
    			if(val147==147) {
    				nombre=nombre+"Ó";
    			}else {
    				nombre=nombre+lista[i];
    			}
    		}
    	}else {
    		nombre=nombreArchivo;
    	}
    	

    	return nombre;
    }
    
    public static String depurarNombreArchivo(String nombreArchivo) {
    	String nombre="";
    	String nuevonombre=nombreArchivo.replaceAll("Â", "").replaceAll("Ã", "").replaceAll("ª", "")+"";
    	
    	if(nuevonombre.contains("DE_REMISI")) {
    		return depurarNombreArchivoGuia(nombreArchivo);
    	}else if(nuevonombre.contains("FACTURA_ELECTR")) {
    		return depurarNombreArchivoFactElec(nombreArchivo);
    	}
    	
    	for(char a : nuevonombre.toCharArray()) {
    		int ascii = (int)a;
//    		System.out.println(" a => "+a+"-ascii: "+ascii);
    		
    		
 
    			if( !String.valueOf(ascii).equalsIgnoreCase("158") && !String.valueOf(ascii).equalsIgnoreCase("129")) {
//    				System.out.println(" =========>nombre: "+nombre);
    				
    				if(String.valueOf(ascii).equalsIgnoreCase("131") && !nombre.contains("Ã") ) {
        				
        				nombre=nombre+"Ã";
        				
        			}else if(String.valueOf(ascii).equalsIgnoreCase("137")) {
        				nombre=nombre+"ê"; 
        			}else if(String.valueOf(ascii).equalsIgnoreCase("140")) {

        				nombre=nombre+"Ì�?";
        			}else if(String.valueOf(ascii).equalsIgnoreCase("147") && !nombre.contains("Ã")) {
        				nombre=nombre+"Ó";
        			}else if(String.valueOf(ascii).equalsIgnoreCase("147") && nombre.contains("Ã")) {

        			}else if(String.valueOf(ascii).equalsIgnoreCase("130")){
        				nombre=nombre+"Â";
        			}else if(String.valueOf(ascii).equalsIgnoreCase("141") && !nombre.contains("Ã")){
        				nombre=nombre+"�?";
        			}
        			else {
        				nombre=nombre+a;
        			}
        		
        		}else  {
        			//System.out.println("ENCONTRO**************"+a);
        		}
    		
    		
    		
    	
    	}
    	
    	String otro=nombre;
    	nombre="";
    	for(char a : otro.toCharArray()) {
    		int ascii = (int)a;
//    		System.out.println(" b => "+a+"-ascii: "+ascii);
    		if(String.valueOf(ascii).equalsIgnoreCase("131")) {
    			nombre=nombre+"Ã";
    			
    		}else {
    			nombre=nombre+a;
    		}
    	}
    	
    	//System.out.println("nombre => "+nombre);
    	return nombre;
    }
}
