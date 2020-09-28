package present.xml.cabecalho;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import model.to.cabecalho.DestinoTo;

public class Destino {

	public Element getDestino(Document doc, Element el, DestinoTo dt) {
		Element el1 = null;
		Text texto = null;
		try {
			el1 = doc.createElement("cnpj");
			texto = doc.createTextNode(dt.getCnpj());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.cabecalho.Destino.getDestino - e= " + e.toString());
		}
		return el;
	}
	
}
