package model.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;

import model.to.MensagemSIBTo;
import model.to.cabecalho.CabecalhoTo;
import model.to.cabecalho.DestinoTo;
import model.to.cabecalho.IdentificacaoSoftwareGeradorTo;
import model.to.cabecalho.IdentificacaoTransacaoTo;
import model.to.cabecalho.OrigemTo;
import model.to.epilogo.EpilogoTo;
import model.to.mensagem.MensagemTo;
import model.to.mensagem.operadoraParaANS.OperadoraParaANSTo;
import model.to.mensagem.operadoraParaANS.beneficiarios.BeneficiariosTo;
import model.to.mensagem.operadoraParaANS.beneficiarios.cancelamento.CancelamentoTo;
import model.to.mensagem.operadoraParaANS.beneficiarios.inclusao.EnderecoTo;
import model.to.mensagem.operadoraParaANS.beneficiarios.inclusao.IdentificacaoTo;
import model.to.mensagem.operadoraParaANS.beneficiarios.inclusao.InclusaoTo;
import model.to.mensagem.operadoraParaANS.beneficiarios.inclusao.VinculoTo;

public class MensagemSIBDao {

	public MensagemSIBTo getMensagemSIB(String sq, String caminho, String data) {
		MensagemSIBTo to = null;
		CabecalhoTo cb = null;
		MensagemTo ms = null;
		EpilogoTo ep = null;
		try {
			to = new MensagemSIBTo();
			
			cb = new CabecalhoTo();
			cb = this.cabecalhoDao(sq, data);
			to.setCabecalho(cb);
			
			ms = new MensagemTo();
			ms = this.mensagemDao(caminho);
			to.setMensagem(ms);
			
			ep = new EpilogoTo();
			ep = this.epilogoDao("");
			to.setEpilogo(ep);
		} catch (Exception e) {
			System.out.println("model.dao.MensagemSIBDao.getMensagemSIB - e = " + e.toString());
		}
		return to;
	}
	
	private CabecalhoTo cabecalhoDao(String sq, String data) {
		CabecalhoTo to = null;
		IdentificacaoTransacaoTo it = null;
		OrigemTo o = null;
		DestinoTo d = null;
		IdentificacaoSoftwareGeradorTo isg = null;
		try {
			to = new CabecalhoTo();
			
			it = new IdentificacaoTransacaoTo();
			it.setTipoTransacao("ATUALIZAÇÃO SIB");
			it.setSequencialTransacao(sq);
			it.setDataHoraRegistroTransacao(data);
			to.setIdentificacaoTransacao(it);
			
			o = new OrigemTo();
			o.setRegistroANS("000000");
			to.setOrigem(o);
			
			d = new DestinoTo();
			d.setCnpj("00000000000000");
			to.setDestino(d);
			
			to.setVersaoPadrao("1.1");
			
			isg = new IdentificacaoSoftwareGeradorTo();
			isg.setNomeAplicativo("TESTE");
			isg.setVersaoAplicativo("1.1");
			isg.setFabricanteAplicativo("TESTE");
			to.setIdentificacaoSoftwareGerador(isg);
		} catch (Exception e) {
			System.out.println("model.dao.MensagemSIBDao.cabecalhoDao - e = " + e.toString());
		}
		return to;
	}
	
	private MensagemTo mensagemDao(String caminho) {
		MensagemTo to = null;
		OperadoraParaANSTo o = null;
		try {
			to = new MensagemTo();
			o = new OperadoraParaANSTo();
			o = this.operadoraParaANSDao(caminho);
			to.setOperadoraParaANS(o);
		} catch (Exception e) {
			System.out.println("model.dao.MensagemSIBDao.mensagemDao - e = " + e.toString());
		}
		return to;
	}
	
	private OperadoraParaANSTo operadoraParaANSDao(String caminho) {
		OperadoraParaANSTo to = null;
		BeneficiariosTo b = null;
		try {
			to = new OperadoraParaANSTo();
			b = new BeneficiariosTo();
			b = this.beneficiariosDao(caminho);
			to.setBeneficiarios(b);
		} catch (Exception e) {
			System.out.println("model.dao.MensagemSIBDao.mensagemDao - e = " + e.toString());
		}
		return to;
	}
	
	private BeneficiariosTo beneficiariosDao(String caminho) {
		BeneficiariosTo to = null;
		List<InclusaoTo> inclusao = null;
		List<CancelamentoTo> cancelamento = null;
		try {
			to = new BeneficiariosTo();
			
			inclusao = new ArrayList<InclusaoTo>();
			inclusao = this.inclusaoDao(caminho);
			to.setInclusao(inclusao);
			
			cancelamento = new ArrayList<CancelamentoTo>();
			cancelamento = this.cancelamentoDao(caminho);
			to.setCancelamento(cancelamento);
		} catch (Exception e) {
			System.out.println("model.dao.MensagemSIBDao.beneficiariosDao - e = " + e.toString());
		}
		return to;
	}
	
	private List<InclusaoTo> inclusaoDao(String caminho) {
		InclusaoTo to = null;
		List<InclusaoTo> lista = null;
		IdentificacaoTo id = null;
		EnderecoTo ed = null;
		VinculoTo vc = null;
		InputStream is = null;
		HSSFWorkbook work = null;
		HSSFSheet sheet = null;
		HSSFRow row = null;
		HSSFCell cel = null;
		String ret = null;
		int h = 0;
		int i = 0;
		try {
			lista = new ArrayList<InclusaoTo>();
			is = new FileInputStream(caminho);
			work = new HSSFWorkbook(is);
			sheet = work.getSheetAt(0);
			while (h == 0) {
				row = sheet.getRow(i);
				if (row != null) {
					cel = row.getCell(0);
					if (cel != null) {
						ret = this.pegaDadosCelula(cel);
						if ("I".equals(ret.toUpperCase().trim())) {
							to = new InclusaoTo();
							
							id = new IdentificacaoTo();
							cel = row.getCell(1);
							ret = this.pegaDadosCelula(cel);
							id.setCpf(ret);
							
							cel = row.getCell(2);
							ret = this.pegaDadosCelula(cel);
							id.setCns(ret);
							
							cel = row.getCell(3);
							ret = this.pegaDadosCelula(cel);
							id.setNome(ret);
							
							cel = row.getCell(4);
							ret = this.pegaDadosCelula(cel);
							id.setSexo(ret);
							
							cel = row.getCell(5);
							ret = this.pegaDadosCelula(cel);
							id.setDataNascimento(ret);
							to.setIdentificacao(id);
							
							ed = new EnderecoTo();
							cel = row.getCell(6);
							ret = this.pegaDadosCelula(cel);
							ed.setCodigoMunicipio(ret);
							to.setEndereco(ed);
							
							vc = new VinculoTo();
							cel = row.getCell(7);
							ret = this.pegaDadosCelula(cel);
							vc.setCodigoBeneficiario(ret);
							
							cel = row.getCell(8);
							ret = this.pegaDadosCelula(cel);
							vc.setRelacaoDependencia(ret);
							
							cel = row.getCell(9);
							ret = this.pegaDadosCelula(cel);
							vc.setCodigoBeneficiarioTitular(ret);
							
							cel = row.getCell(10);
							ret = this.pegaDadosCelula(cel);
							vc.setDataContratacao(ret);
							
							cel = row.getCell(11);
							ret = this.pegaDadosCelula(cel);
							vc.setNumeroPlanoOperadora(ret);
							to.setVinculo(vc);
							
							lista.add(to);
						}
						i++;
					} else {
						h = 1;
					}
				} else {
					h = 1;
				}
			}
		} catch (Exception e) {
			System.out.println("model.dao.MensagemSIBDao.inclusaoDao - e = " + e.toString());
		}
		return lista;
	}
	
	private List<CancelamentoTo> cancelamentoDao(String caminho) {
		CancelamentoTo to = null;
		List<CancelamentoTo> lista = null;
		InputStream is = null;
		HSSFWorkbook work = null;
		HSSFSheet sheet = null;
		HSSFRow row = null;
		HSSFCell cel = null;
		String ret = null;
		int h = 0;
		int i = 0;
		try {
			lista = new ArrayList<CancelamentoTo>();
			is = new FileInputStream(caminho);
			work = new HSSFWorkbook(is);
			sheet = work.getSheetAt(0);
			while (h == 0) {
				row = sheet.getRow(i);
				if (row != null) {
					cel = row.getCell(0);
					if (cel != null) {
						ret = this.pegaDadosCelula(cel);
						if ("C".equals(ret.toUpperCase().trim())) {
							to = new CancelamentoTo();
							
							cel = row.getCell(1);
							ret = this.pegaDadosCelula(cel);
							to.setCco(ret);
							
							cel = row.getCell(2);
							ret = this.pegaDadosCelula(cel);
							to.setDataCancelamento(ret);
							
							cel = row.getCell(3);
							ret = this.pegaDadosCelula(cel);
							to.setMotivoCancelamento(ret);
							
							lista.add(to);
						}
						i++;
					} else {
						h = 1;
					}
				} else {
					h = 1;
				}
			}
		} catch (Exception e) {
			System.out.println("model.dao.MensagemSIBDao.cancelamentoDao - e = " + e.toString());
		}
		return lista;
	}
	
	private String pegaDadosCelula(HSSFCell cel) {
		SimpleDateFormat sdf = null;
		String resp = null;
		try {
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			if (cel.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				 resp = "" + cel.getStringCellValue();
				 if ("NULL".equals(resp)) {
					 resp = null;
				 }
			} else if (cel.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				if (DateUtil.isCellDateFormatted(cel)) {
					resp = sdf.format(cel.getDateCellValue());
				} else {
					if (cel.getNumericCellValue() >= 0) {
						resp = "" + (int)cel.getNumericCellValue();
						if (resp.contains("E")) {
							String tam = resp.substring((resp.indexOf("E") + 1), resp.length());
							Long tam2 = Long.parseLong(tam);
							String tam3 = resp.substring(resp.indexOf("."), resp.indexOf("E"));
							Long tam4 = (long)tam3.length();
							Long num = (tam4 - tam2 - 1);
							
							resp = resp.substring(0, resp.indexOf("E")).replace(".", "");
							
							if (num < 0) {
								num = (num * (-1));
								for(int k = 0; k <= 10; k++){
						        	if(k < num){
						        		resp = resp.concat("0");
						           	} else {
						        		break;
						        	}
						        }
							}
							
							for(int k = 1; k <= 11; k++){
				        		if(resp.length() < 11){
				        			resp = "0".concat(resp);
				            	} else {
				        			break;
				        		}
				        	}
						}
					} else {
						resp = "" + (cel.getNumericCellValue()*(-1));
					}
				}
			} else if (cel.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
				resp = "" + cel.getBooleanCellValue();
			} else if (cel.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
				resp = "" + cel.getCellFormula();
			} else if (cel.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
				resp = "";
			} else if (cel.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
				resp = ""; 
			} else {
				resp = "";
			}
		} catch (Exception e) {
			System.out.println("model.dao.MensagemSIBDao.pegaDadosCelula - e= " + e.toString());
		}
		return resp;
	}
	
	private EpilogoTo epilogoDao(String hash) {
		EpilogoTo to = null;
		try {
			to = new EpilogoTo();
			to.setHash(hash);
		} catch (Exception e) {
			System.out.println("model.dao.MensagemSIBDao.epilogoDao - e = " + e.toString());
		}
		return to;
	}
	
	public String getHash(MensagemSIBTo msb) {
		String msg = "";
		String hash = "";
		try {
			msg = "http://www.ans.gov.br/padroes/sib/schemas http://www.ans.gov.br/padroes/sib/schemas/sib.xsd";
			msg = msg + msb.getCabecalho().getIdentificacaoTransacao().getTipoTransacao();
			msg = msg + msb.getCabecalho().getIdentificacaoTransacao().getSequencialTransacao();
			msg = msg + msb.getCabecalho().getIdentificacaoTransacao().getDataHoraRegistroTransacao();
			msg = msg + msb.getCabecalho().getOrigem().getRegistroANS();
			msg = msg + msb.getCabecalho().getDestino().getCnpj();
			msg = msg + msb.getCabecalho().getVersaoPadrao();
			msg = msg + msb.getCabecalho().getIdentificacaoSoftwareGerador().getNomeAplicativo();
			msg = msg + msb.getCabecalho().getIdentificacaoSoftwareGerador().getVersaoAplicativo();
			msg = msg + msb.getCabecalho().getIdentificacaoSoftwareGerador().getFabricanteAplicativo();
			
			for (InclusaoTo to : msb.getMensagem().getOperadoraParaANS().getBeneficiarios().getInclusao()) {
				if (to.getIdentificacao().getCpf() != null && !"".equals(to.getIdentificacao().getCpf())) {
					msg = msg + to.getIdentificacao().getCpf();
				}
				if (to.getIdentificacao().getCns() != null && !"".equals(to.getIdentificacao().getCns())) {
					msg = msg + to.getIdentificacao().getCns();
				}
				msg = msg + to.getIdentificacao().getNome();
				msg = msg + to.getIdentificacao().getSexo();
				msg = msg + to.getIdentificacao().getDataNascimento();
				msg = msg + to.getEndereco().getCodigoMunicipio();
				msg = msg + to.getVinculo().getCodigoBeneficiario();
				msg = msg + to.getVinculo().getRelacaoDependencia();
				if (to.getVinculo().getCodigoBeneficiarioTitular() != null && !"".equals(to.getVinculo().getCodigoBeneficiarioTitular())) {
					msg = msg + to.getVinculo().getCodigoBeneficiarioTitular();
				}
				msg = msg + to.getVinculo().getDataContratacao();
				msg = msg + to.getVinculo().getNumeroPlanoOperadora();
			}
			
			for (CancelamentoTo to : msb.getMensagem().getOperadoraParaANS().getBeneficiarios().getCancelamento()) {
				msg = msg + to.getCco();
				msg = msg + to.getDataCancelamento();
				msg = msg + to.getMotivoCancelamento();
			}
			
			hash = this.stringHexa(this.gerarHash(msg, "MD5"));
		} catch (Exception e) {
			System.out.println("model.dao.MensagemSIBDao.getHash - e= " + e.toString());
		}
		return hash;
	}
	
	private String stringHexa(byte[] bytes) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
			int parteBaixa = bytes[i] & 0xf;
			if (parteAlta == 0) s.append('0');
			s.append(Integer.toHexString(parteAlta | parteBaixa));
		}
		return s.toString();
	}

	private byte[] gerarHash(String frase, String algoritmo) {
		try {
			MessageDigest md = MessageDigest.getInstance(algoritmo);
			md.update(frase.getBytes());
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
}
