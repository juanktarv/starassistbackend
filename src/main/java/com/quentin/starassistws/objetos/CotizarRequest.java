package com.quentin.starassistws.objetos;

public class CotizarRequest{

	private Integer tcodiusua;
	private Integer tcantviaj;
	private String  tnumetele;
	private Integer tcantdias;
	private String  tcorrviaj;
	private Integer tiddestin;
	private Integer ttipodest;
	private Integer tidorigen;
	private Integer thabimult;
	
	private String[] tlistpasa;
	
	private String fechainicio;
	private String fechafinal;
	
	public Integer getTcodiusua() {
		return tcodiusua;
	}
	public void setTcodiusua(Integer tcodiusua) {
		this.tcodiusua = tcodiusua;
	}
	public Integer getTcantviaj() {
		return tcantviaj;
	}
	public void setTcantviaj(Integer tcantviaj) {
		this.tcantviaj = tcantviaj;
	}
	public String getTnumetele() {
		return tnumetele;
	}
	public void setTnumetele(String tnumetele) {
		this.tnumetele = tnumetele;
	}
	public Integer getTcantdias() {
		return tcantdias;
	}
	public void setTcantdias(Integer tcantdias) {
		this.tcantdias = tcantdias;
	}
	public String getTcorrviaj() {
		return tcorrviaj;
	}
	public void setTcorrviaj(String tcorrviaj) {
		this.tcorrviaj = tcorrviaj;
	}
	public Integer getTiddestin() {
		return tiddestin;
	}
	public void setTiddestin(Integer tiddestin) {
		this.tiddestin = tiddestin;
	}
	public Integer getTidorigen() {
		return tidorigen;
	}
	public void setTidorigen(Integer tidorigen) {
		this.tidorigen = tidorigen;
	}
	public Integer getThabimult() {
		return thabimult;
	}
	public void setThabimult(Integer thabimult) {
		this.thabimult = thabimult;
	}
	
	public String getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}
	public String getFechafinal() {
		return fechafinal;
	}
	public void setFechafinal(String fechafinal) {
		this.fechafinal = fechafinal;
	}
	public Integer getTtipodest() {
		return ttipodest;
	}
	public void setTtipodest(Integer ttipodest) {
		this.ttipodest = ttipodest;
	}
	public String[] getTlistpasa() {
		return tlistpasa;
	}
	public void setTlistpasa(String[] tlistpasa) {
		this.tlistpasa = tlistpasa;
	}
	
	
}
