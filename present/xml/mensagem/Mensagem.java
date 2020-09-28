package present.xml.mensagem;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.to.mensagem.MensagemTo;
import present.xml.mensagem.operadoraParaANS.OperadoraParaANS;

public class Mensagem {

	public Element getMensagem(Document doc, Element el, MensagemTo ms) {
		Element el1 = null;
		OperadoraParaANS op = null;
		try {
			op = new OperadoraParaANS();
			
			el = doc.createElement("mensagem");
			
			el1 = doc.createElement("operadoraParaANS");
			el1 = op.getOperadoraParaANS(doc, el1, ms.getOperadoraParaANS());
			el.appendChild(el1);
		} catch (Exception e) {
			System.out.println("present.xml.mensagem.Mensagem.getMensagem - e= " + e.toString());
		}
		return el;
	}
	
}
