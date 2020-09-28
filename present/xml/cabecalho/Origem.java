package present.xml.cabecalho;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import model.to.cabecalho.OrigemTo;

public class Origem {

	public Element getOrigem(Document doc, Element el, OrigemTo or) {
		Element el1 = null;
		Text texto = null;
		try {
			el1 = doc.createElement("registroANS");
			texto = doc.createTextNode(or.getRegistroANS());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.cabecalho.Origem.getOrigem - e= " + e.toString());
		}
		return el;
	}
	
}
