package app.gui.modelo;

import java.util.List;

public class Horario {

	private List<String> LM;
	private List<String> LT;
	private List<String> MM;
	private List<String> MT;
	private List<String> XM;
	private List<String> XT;
	private List<String> JM;
	private List<String> JT;
	private List<String> VM;
	private List<String> VT;
	private List<String> SM;
	private List<String> ST;
	private List<String> DM;
	private List<String> DT;



	public Horario() {
//		this.LM=new ArrayList<>();
//		this.LT=new ArrayList<>();
//		this.MM=new ArrayList<>();
//		this.MT=new ArrayList<>();
//		this.XM=new ArrayList<>();
//		this.XT=new ArrayList<>();
//		this.JM=new ArrayList<>();
//		this.JT=new ArrayList<>();
//		this.VM=new ArrayList<>();
//		this.VT=new ArrayList<>();
//		this.SM=new ArrayList<>();
//		this.ST=new ArrayList<>();
//		this.DM=new ArrayList<>();
//		this.DT=new ArrayList<>();
		
	}
	



	public List<String> getLM() {
		return LM;
	}

	public void setLM(List<String> lM) {
		LM = lM;
	}

	public List<String> getLT() {
		return LT;
	}

	public void setLT(List<String> lT) {
		LT = lT;
	}

	public List<String> getMM() {
		return MM;
	}

	public void setMM(List<String> mM) {
		MM = mM;
	}

	public List<String> getMT() {
		return MT;
	}

	public void setMT(List<String> mT) {
		MT = mT;
	}

	public List<String> getXM() {
		return XM;
	}

	public void setXM(List<String> xM) {
		XM = xM;
	}

	public List<String> getXT() {
		return XT;
	}

	public void setXT(List<String> xT) {
		XT = xT;
	}

	public List<String> getJM() {
		return JM;
	}

	public void setJM(List<String> jM) {
		JM = jM;
	}

	public List<String> getJT() {
		return JT;
	}

	public void setJT(List<String> jT) {
		JT = jT;
	}

	public List<String> getVM() {
		return VM;
	}

	public void setVM(List<String> vM) {
		VM = vM;
	}

	public List<String> getVT() {
		return VT;
	}

	public void setVT(List<String> vT) {
		VT = vT;
	}

	public List<String> getSM() {
		return SM;
	}

	public void setSM(List<String> sM) {
		SM = sM;
	}

	public List<String> getST() {
		return ST;
	}

	public void setST(List<String> sT) {
		ST = sT;
	}

	public List<String> getDM() {
		return DM;
	}

	public void setDM(List<String> dM) {
		DM = dM;
	}

	public List<String> getDT() {
		return DT;
	}

	public void setDT(List<String> dT) {
		DT = dT;
	}

	@Override
	public String toString() {
		return "Horario [LM=" + LM + ", LT=" + LT + ", MM=" + MM + ", MT=" + MT + ", XM=" + XM + ", XT=" + XT + ", JM="
				+ JM + ", JT=" + JT + ", VM=" + VM + ", VT=" + VT + ", SM=" + SM + ", ST=" + ST + ", DM=" + DM + ", DT="
				+ DT +  "]";
	}

	
}
