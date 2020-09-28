package present.xml.mensagem.operadoraParaANS.beneficiarios.inclusao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import model.to.mensagem.operadoraParaANS.beneficiarios.inclusao.EnderecoTo;

public class Endereco {

	public Element getEndereco(Document doc, Element el, EnderecoTo ed) {
		Element el1 = null;
		Text texto = null;
		try {
			el1 = doc.createElement("codigoMunicipio");
			texto = doc.createTextNode(ed.getCodigoMunicipio());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			System.out.println("present.xml.mensagem.operadoraParaANS.beneficiarios.inclusao.Endereco.getEndereco - e= " + e.toString());
		}
		return el;
	}
	
}
