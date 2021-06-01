package model;

public class Agenda {
	private int agendaPK;
	private String txnome;
	private String txtelefone;
	private String txendereco;
	
	// gets and setters
	public int getAgendaPK() {
		return agendaPK;
	}
	public void setAgendaPK(int agendaPK) {
		this.agendaPK = agendaPK;
	}
	public String getTxnome() {
		return txnome;
	}
	public void setTxnome(String txnome) {
		this.txnome = txnome;
	}
	public String getTxtelefone() {
		return txtelefone;
	}
	public void setTxtelefone(String txtelefone) {
		this.txtelefone = txtelefone;
	}
	public String getTxendereco() {
		return txendereco;
	}
	public void setTxendereco(String txendereco) {
		this.txendereco = txendereco;
	}
	/*
	@Override
	public String toString() {
		return "Contato [ID=" + agendaPK + ", Nome=" + txnome + ", Telefone=" + txtelefone + ", Endereço="
				+ txendereco + "]";
	}
	*/
	

	
}
