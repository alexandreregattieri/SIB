package model.to.cabecalho;

public class IdentificacaoTransacaoTo {

	private String tipoTransacao;
	private String sequencialTransacao;
	private String dataHoraRegistroTransacao;
	
	public String getTipoTransacao() {
		return tipoTransacao;
	}
	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	public String getSequencialTransacao() {
		return sequencialTransacao;
	}
	public void setSequencialTransacao(String sequencialTransacao) {
		this.sequencialTransacao = sequencialTransacao;
	}
	public String getDataHoraRegistroTransacao() {
		return dataHoraRegistroTransacao;
	}
	public void setDataHoraRegistroTransacao(String dataHoraRegistroTransacao) {
		this.dataHoraRegistroTransacao = dataHoraRegistroTransacao;
	}
	
}
