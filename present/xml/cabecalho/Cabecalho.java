package present.xml.cabecalho;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import model.to.cabecalho.CabecalhoTo;

public class Cabecalho {

	public Element getCabecalho(Document doc, Element el, CabecalhoTo cb) {
		Element el1 = null;
		Text texto = null;
		IdentificacaoTransacao it = null;
		Origem or = null;
		Destino dt = null;
		IdentificacaoSoftwareGerador is = null;
		try {
			el = doc.createElement("cabecalho");
			
			it = new IdentificacaoTransacao();
			el1 = doc.createElement("identificacaoTransacao");
			el1 = it.getIdentificacaoTransacao(doc, el1, cb.getIdentificacaoTransacao());
			el.appendChild(el1);
			
			or = new Origem();
			el1 = doc.createElement("origem");
			el1 = or.getOrigem(doc, el1, cb.getOrigem());
			el.appendChild(el1);
			
			dt = new Destino();
			el1 = doc.createElement("destino");
			el1 = dt.getDestino(doc, el1, cb.getDestino());
			el.appendChild(el1);
			
			el1 = doc.createElement("versaoPadrao");
			texto = doc.createTextNode(cb.getVersaoPadrao());
			el1.appendChild(texto);
			el.appendChild(el1);
			
			is = new IdentificacaoSoftwareGerador();
			el1 = doc.createElement("identificacaoSoftwareGerador");
			el1 = is.getIdentificacaoSoftwareGerador(doc, el1, cb.getIdentificacaoSoftwareGerador());
			el.appendChild(el1);
		} catch (Exception e) {
			System.out.println("present.xml.cabecalho.Cabecalho.getCabecalho - e= " + e.toString());
		}
		return el;
	}
	
}
