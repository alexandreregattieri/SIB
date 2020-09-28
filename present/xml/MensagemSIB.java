package present.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.to.MensagemSIBTo;
import present.xml.cabecalho.Cabecalho;
import present.xml.epilogo.Epilogo;
import present.xml.mensagem.Mensagem;

public class MensagemSIB {

	public Element getMensagemSIB(Document doc, Element el, MensagemSIBTo msb) {
		Element el1 = null;
		Element el2 = null;
		Element el3 = null;
		Cabecalho cab = null;
		Mensagem msg = null;
		Epilogo epl = null;
		try {
			cab = new Cabecalho();
			msg = new Mensagem();
			epl = new Epilogo();
			
			el1 = cab.getCabecalho(doc, el, msb.getCabecalho());
			el.appendChild(el1);
			
			el2 = msg.getMensagem(doc, el, msb.getMensagem());
			el.appendChild(el2);
			
			el3 = epl.getEpilogo(doc, el, msb.getEpilogo());
			el.appendChild(el3);
			
		} catch (Exception e) {
			System.out.println("present.xml.MensagemSIB.getMensagemSIB - e= " + e.toString());
		}
		return el;
	}
	
}
