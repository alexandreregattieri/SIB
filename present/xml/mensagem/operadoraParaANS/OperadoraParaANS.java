package present.xml.mensagem.operadoraParaANS;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.to.mensagem.operadoraParaANS.OperadoraParaANSTo;
import present.xml.mensagem.operadoraParaANS.beneficiarios.Beneficiarios;

public class OperadoraParaANS {

	public Element getOperadoraParaANS(Document doc, Element el, OperadoraParaANSTo op) {
		Element el1 = null;
		Beneficiarios bn = null;
		try {
			bn = new Beneficiarios();
			el1 = doc.createElement("beneficiarios");
			el1 = bn.getBeneficiario(doc, el1, op.getBeneficiarios());
			el.appendChild(el1);
		} catch (Exception e) {
			System.out.println("present.xml.mensagem.operadoraParaANS.OperadoraParaANS.getOperadoraParaANS - e= " + e.toString());
		}
		return el;
	}
	
}
