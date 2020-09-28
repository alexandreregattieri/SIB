package model.to.mensagem.operadoraParaANS.beneficiarios;

import java.util.List;

import model.to.mensagem.operadoraParaANS.beneficiarios.cancelamento.CancelamentoTo;
import model.to.mensagem.operadoraParaANS.beneficiarios.inclusao.InclusaoTo;

public class BeneficiariosTo {
	
	private List<InclusaoTo> inclusao;
	private List<CancelamentoTo> cancelamento;
	
	public List<InclusaoTo> getInclusao() {
		return inclusao;
	}
	public void setInclusao(List<InclusaoTo> inclusao) {
		this.inclusao = inclusao;
	}
	public List<CancelamentoTo> getCancelamento() {
		return cancelamento;
	}
	public void setCancelamento(List<CancelamentoTo> cancelamento) {
		this.cancelamento = cancelamento;
	}

}
