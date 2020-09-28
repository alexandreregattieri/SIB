package present.xml.mensagem.operadoraParaANS.beneficiarios.cancelamento;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import model.to.mensagem.operadoraParaANS.beneficiarios.cancelamento.CancelamentoTo;

public class Cancelamento {

	public Element getCancelamento(Document doc, Element el, CancelamentoTo ct) {
		Element el1 = null;
		Text texto = null;
		try {
			el1 = doc.createElement("cco");
			texto = doc.createTextNode(ct.getCco());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("dataCancelamento");
			texto = doc.createTextNode(ct.getDataCancelamento());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("motivoCancelamento");
			texto = doc.createTextNode(ct.getMotivoCancelamento());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			System.out.println("present.xml.mensagem.operadoraParaANS.beneficiarios.cancelamento.Cancelamento.getCancelamento - e= " + e.toString());
		}
		return el;
	}
	
}
