package present.xml.cabecalho;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import model.to.cabecalho.IdentificacaoTransacaoTo;

public class IdentificacaoTransacao {

	public Element getIdentificacaoTransacao(Document doc, Element el, IdentificacaoTransacaoTo it) {
		Element el1 = null;
		Text texto = null;
		try {
			el1 = doc.createElement("tipoTransacao");
			texto = doc.createTextNode(it.getTipoTransacao());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("sequencialTransacao");
			texto = doc.createTextNode(it.getSequencialTransacao());
			el1.appendChild(texto);
			el.appendChild(el1);
			el1 = doc.createElement("dataHoraRegistroTransacao");
			texto = doc.createTextNode(it.getDataHoraRegistroTransacao());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("present.xml.cabecalho.IdentificacaoTransacao.getIdentificacaoTransacao - e= " + e.toString());
		}
		return el;
	}
	
}
