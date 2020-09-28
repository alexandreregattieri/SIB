package model.to;

import model.to.cabecalho.CabecalhoTo;
import model.to.epilogo.EpilogoTo;
import model.to.mensagem.MensagemTo;

public class MensagemSIBTo {
	
	private CabecalhoTo cabecalho;
	private MensagemTo mensagem;
	private EpilogoTo epilogo;
	
	public CabecalhoTo getCabecalho() {
		return cabecalho;
	}
	public void setCabecalho(CabecalhoTo cabecalho) {
		this.cabecalho = cabecalho;
	}
	public MensagemTo getMensagem() {
		return mensagem;
	}
	public void setMensagem(MensagemTo mensagem) {
		this.mensagem = mensagem;
	}
	public EpilogoTo getEpilogo() {
		return epilogo;
	}
	public void setEpilogo(EpilogoTo epilogo) {
		this.epilogo = epilogo;
	}	

}
