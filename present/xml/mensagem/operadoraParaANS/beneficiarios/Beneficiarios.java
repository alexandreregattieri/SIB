package present.xml.mensagem.operadoraParaANS.beneficiarios;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.to.mensagem.operadoraParaANS.beneficiarios.BeneficiariosTo;
import model.to.mensagem.operadoraParaANS.beneficiarios.cancelamento.CancelamentoTo;
import model.to.mensagem.operadoraParaANS.beneficiarios.inclusao.InclusaoTo;
import present.xml.mensagem.operadoraParaANS.beneficiarios.cancelamento.Cancelamento;
import present.xml.mensagem.operadoraParaANS.beneficiarios.inclusao.Inclusao;

public class Beneficiarios {
	
	public Element getBeneficiario(Document doc, Element el, BeneficiariosTo bn) {
		Element el1 = null;
		Inclusao ic = null;
		Cancelamento cl = null;
		try {
			ic = new Inclusao();
			cl = new Cancelamento();
			
			for (InclusaoTo to : bn.getInclusao()) {
				el1 = doc.createElement("inclusao");
				el1 = ic.getInclusao(doc, el1, to);
				el.appendChild(el1);
			}
			
			for (CancelamentoTo to : bn.getCancelamento()) {
				el1 = doc.createElement("cancelamento");
				el1 = cl.getCancelamento(doc, el1, to);
				el.appendChild(el1);
			}
		} catch (Exception e) {
			System.out.println("present.xml.mensagem.operadoraParaANS.beneficiarios.Beneficiarios.getBeneficiario - e= " + e.toString());
		}
		return el;
	}

}
