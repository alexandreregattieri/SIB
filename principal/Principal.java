package principal;

import present.GeraXml;

public class Principal {

	public static void main(String[] args) {
		GeraXml gx = null;
		String sq = "99990004";
		String cam = "D:/InclusaoSIB.xls";
		try {
			System.out.println(">>>> Processo Iniciado! <<<<");
			gx = new GeraXml();
			gx.getMnesagemSIB(sq, cam);
			System.out.println(">>>> Processo Finalizado! <<<<");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
