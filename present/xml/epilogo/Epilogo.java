package present.xml.epilogo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import model.to.epilogo.EpilogoTo;

public class Epilogo {

	public Element getEpilogo(Document doc, Element el, EpilogoTo ep) {
		Element el1 = null;
		Text texto = null;
		try {
			el = doc.createElement("epilogo");
			
			el1 = doc.createElement("hash");
			texto = doc.createTextNode(ep.getHash());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			System.out.println("present.xml.epilogo.Epilogo.getEpilogo - e= " + e.toString());
		}
		return el;
	}
	
}
