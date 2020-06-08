package kemia_gyak;

public class Elem {
	private String ev;
	private String elem;
	private String vegyjel;
	private Integer rendszam;
	private String felfedezo;
	public String getEv() {
		return ev;
	}
	public void setEv(String ev) {
		this.ev = ev;
	}
	public String getElem() {
		return elem;
	}
	public void setElem(String elem) {
		this.elem = elem;
	}
	public String getVegyjel() {
		return vegyjel;
	}
	public void setVegyjel(String vegyjel) {
		this.vegyjel = vegyjel;
	}
	public Integer getRendszam() {
		return rendszam;
	}
	public void setRendszam(Integer rendszam) {
		this.rendszam = rendszam;
	}
	public String getFelfedezo() {
		return felfedezo;
	}
	public void setFelfedezo(String felfedezo) {
		this.felfedezo = felfedezo;
	}
	public Elem(String ev, String elem, String vegyjel, Integer rendszam, String felfedezo) {
		super();
		this.ev = ev;
		this.elem = elem;
		this.vegyjel = vegyjel;
		this.rendszam = rendszam;
		this.felfedezo = felfedezo;
	}
	@Override
	public String toString() {
		return "Elem [ev=" + ev + ", elem=" + elem + ", vegyjel=" + vegyjel + ", rendszam=" + rendszam + ", felfedezo="
				+ felfedezo + "]";
	}
	
	
	
}
