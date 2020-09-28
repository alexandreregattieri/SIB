package present;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.dao.MensagemSIBDao;
import model.to.MensagemSIBTo;
import present.xml.cabecalho.Cabecalho;
import present.xml.epilogo.Epilogo;
import present.xml.mensagem.Mensagem;

public class GeraXml {
	
	public void getMnesagemSIB(String sq, String caminho) {
		ByteArrayInputStream xml = null;
		DocumentBuilderFactory dbfac = null;
		DocumentBuilder docBuilder = null;
		Document doc = null;
		TransformerFactory transfac = null;
		Transformer trans = null;
		StreamResult result = null;
		DOMSource source = null;
		Element el = null;
		Element el1 = null;
		Element el2 = null;
		Element el3 = null;
		String header = null;
		MensagemSIBDao dao = null;
		MensagemSIBTo to = null;
		Cabecalho cabx = null;
		Mensagem msgx = null;
		Epilogo eplx = null;
		String aux = null;
		Locale l = null;
		GregorianCalendar c = null;
		SimpleDateFormat sdf1 = null;
		SimpleDateFormat sdf2 = null;
		SimpleDateFormat sdf3 = null;
		String data = null;
		try {
			// Criando o arquivo
			header = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>";
			header = header + "\n<mensagemSIB>\n</mensagemSIB>";
			xml = new ByteArrayInputStream(new String(header.getBytes(), "ISO-8859-1").getBytes());
			dbfac = DocumentBuilderFactory.newInstance();
			docBuilder = dbfac.newDocumentBuilder();
			doc = docBuilder.parse(xml);
						
			//Criando a Mensagem
			el = doc.getDocumentElement();
			el.setAttribute("xmlns:ansSIB", "http://www.ans.gov.br/padroes/sib/schemas");
			el.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			el.setAttribute("xsi:schemaLocation", "http://www.ans.gov.br/padroes/sib/schemas http://www.ans.gov.br/padroes/sib/schemas/sib.xsd");
			
			//Pegando os dados (Cabecalho, Mensagem e Epilogo)
			l = new Locale("pt","BR");
			c = new GregorianCalendar();
			sdf1 = new SimpleDateFormat("yyyy-MM-dd",l);
			sdf2 = new SimpleDateFormat("HH:mm:ss",l);
			sdf3 = new SimpleDateFormat("yyyyMMddHHmmss",l);
			data = sdf1.format(c.getTime()) + "T" + sdf2.format(c.getTime());
			aux = "392405" + sdf3.format(c.getTime());
			
			to = new MensagemSIBTo();
			dao = new MensagemSIBDao();
			to = dao.getMensagemSIB(sq, caminho, data);
			to.getEpilogo().setHash(dao.getHash(to));
			
			//Estruturando a mensagem (Cabecalho, Mensagem e Epilogo)
			cabx = new Cabecalho();
			msgx = new Mensagem();
			eplx = new Epilogo();
			//
			el1 = cabx.getCabecalho(doc, el, to.getCabecalho());
			el.appendChild(el1);
			
			el2 = msgx.getMensagem(doc, el, to.getMensagem());
			el.appendChild(el2);
			
			el3 = eplx.getEpilogo(doc, el, to.getEpilogo());
			el.appendChild(el3);
			
			
			//Atribuindo os parâmetros ao documento
	        transfac = TransformerFactory.newInstance();
            trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "no");
            
            //Salvando o documento
            result = new StreamResult(new FileOutputStream("D:/" + aux + ".SBX"));
            source = new DOMSource(doc);
            trans.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.GeraXml.getMnesagemSIB - e= " + e.toString());
		}
	}

}
