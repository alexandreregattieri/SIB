package model.to.cabecalho;

public class CabecalhoTo {
	
	private IdentificacaoTransacaoTo identificacaoTransacao;
	private OrigemTo origem;
	private DestinoTo destino;
	private String versaoPadrao;
	private IdentificacaoSoftwareGeradorTo identificacaoSoftwareGerador;
	
	public IdentificacaoTransacaoTo getIdentificacaoTransacao() {
		return identificacaoTransacao;
	}
	public void setIdentificacaoTransacao(IdentificacaoTransacaoTo identificacaoTransacao) {
		this.identificacaoTransacao = identificacaoTransacao;
	}
	public OrigemTo getOrigem() {
		return origem;
	}
	public void setOrigem(OrigemTo origem) {
		this.origem = origem;
	}
	public DestinoTo getDestino() {
		return destino;
	}
	public void setDestino(DestinoTo destino) {
		this.destino = destino;
	}
	public String getVersaoPadrao() {
		return versaoPadrao;
	}
	public void setVersaoPadrao(String versaoPadrao) {
		this.versaoPadrao = versaoPadrao;
	}
	public IdentificacaoSoftwareGeradorTo getIdentificacaoSoftwareGerador() {
		return identificacaoSoftwareGerador;
	}
	public void setIdentificacaoSoftwareGerador(IdentificacaoSoftwareGeradorTo identificacaoSoftwareGerador) {
		this.identificacaoSoftwareGerador = identificacaoSoftwareGerador;
	}

}
