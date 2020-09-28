package present.xml.mensagem.operadoraParaANS.beneficiarios.inclusao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.to.mensagem.operadoraParaANS.beneficiarios.inclusao.InclusaoTo;

public class Inclusao {

	public Element getInclusao(Document doc, Element el, InclusaoTo ic) {
		Element el1 = null;
		Identificacao id = null;
		Endereco ed = null;
		Vinculo vc = null;
		try {
			id = new Identificacao();
			el1 = doc.createElement("identificacao");
			el1 = id.getIdentificacao(doc, el1, ic.getIdentificacao());
			el.appendChild(el1);
			
			ed = new Endereco();
			el1 = doc.createElement("endereco");
			el1 = ed.getEndereco(doc, el1, ic.getEndereco());
			el.appendChild(el1);
			
			vc = new Vinculo();
			el1 = doc.createElement("vinculo");
			el1 = vc.getVinculo(doc, el1, ic.getVinculo());
			el.appendChild(el1);
		} catch (Exception e) {
			System.out.println("present.xml.mensagem.operadoraParaANS.beneficiarios.inclusao.Inclusao.getInclusao - e= " + e.toString());
		}
		return el;
	}
	
}
