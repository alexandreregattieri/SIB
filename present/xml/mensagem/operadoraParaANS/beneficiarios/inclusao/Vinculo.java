package present.xml.mensagem.operadoraParaANS.beneficiarios.inclusao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import model.to.mensagem.operadoraParaANS.beneficiarios.inclusao.VinculoTo;

public class Vinculo {

	public Element getVinculo(Document doc, Element el, VinculoTo vc) {
		Element el1 = null;
		Text texto = null;
		try {
			el1 = doc.createElement("codigoBeneficiario");
			texto = doc.createTextNode(vc.getCodigoBeneficiario());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("relacaoDependencia");
			texto = doc.createTextNode(vc.getRelacaoDependencia());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			if (vc.getCodigoBeneficiarioTitular() != null && !"".equals(vc.getCodigoBeneficiarioTitular().trim())) {
				el1 = doc.createElement("codigoBeneficiarioTitular");
				texto = doc.createTextNode(vc.getCodigoBeneficiarioTitular());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			el1 = doc.createElement("dataContratacao");
			texto = doc.createTextNode(vc.getDataContratacao());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("numeroPlanoOperadora");
			texto = doc.createTextNode(vc.getNumeroPlanoOperadora());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			System.out.println("present.xml.mensagem.operadoraParaANS.beneficiarios.inclusao.Vinculo.getVinculo - e= " + e.toString());
		}
		return el;
	}
	
}
