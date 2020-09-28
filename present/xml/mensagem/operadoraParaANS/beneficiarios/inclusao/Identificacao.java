package present.xml.mensagem.operadoraParaANS.beneficiarios.inclusao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import model.to.mensagem.operadoraParaANS.beneficiarios.inclusao.IdentificacaoTo;

public class Identificacao {

	public Element getIdentificacao(Document doc, Element el, IdentificacaoTo id) {
		Element el1 = null;
		Text texto = null;
		try {
			if (id.getCpf() != null && !"".equals(id.getCpf().trim())) {
				el1 = doc.createElement("cpf");
				texto = doc.createTextNode(id.getCpf());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			if (id.getCns() != null && !"".equals(id.getCns().trim())) {
				el1 = doc.createElement("cns");
				texto = doc.createTextNode(id.getCns());
				el1.appendChild(texto);
				el.appendChild(el1);
			}
			
			el1 = doc.createElement("nome");
			texto = doc.createTextNode(id.getNome());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("sexo");
			texto = doc.createTextNode(id.getSexo());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			el1 = doc.createElement("dataNascimento");
			texto = doc.createTextNode(id.getDataNascimento());
			el1.appendChild(texto);
			el.appendChild(el1);
		} catch (Exception e) {
			System.out.println("present.xml.mensagem.operadoraParaANS.beneficiarios.inclusao.Identificacao.getIdentificacao - e= " + e.toString());
		}
		return el;
	}
	
}
