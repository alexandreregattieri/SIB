package present.xml.cabecalho;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import model.to.cabecalho.IdentificacaoSoftwareGeradorTo;

public class IdentificacaoSoftwareGerador {

	public Element getIdentificacaoSoftwareGerador(Document doc, Element el, IdentificacaoSoftwareGeradorTo is) {
		Element el1 = null;
		Text texto = null;
		try {
			el1 = doc.createElement("nomeAplicativo");
			texto = doc.createTextNode(is.getNomeAplicativo());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("versaoAplicativo");
			texto = doc.createTextNode(is.getVersaoAplicativo());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("fabricanteAplicativo");
			texto = doc.createTextNode(is.getFabricanteAplicativo());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.cabecalho.IdentificacaoSoftwareGerador.getIdentificacaoSoftwareGerador - e= " + e.toString());
		}
		return el;
	}
	
}
