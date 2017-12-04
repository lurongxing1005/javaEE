package com.etcxm.entity;

import java.math.BigDecimal;

public class Dept {
	private BigDecimal DEPTNO;
	private String DNAME;
	private String LOC;
	public BigDecimal getDEPTNO() {
		return DEPTNO;
	}
	public void setDEPTNO(BigDecimal dEPTNO) {
		DEPTNO = dEPTNO;
	}
	public String getDNAME() {
		return DNAME;
	}
	public void setDNAME(String dNAME) {
		DNAME = dNAME;
	}
	public String getLOC() {
		return LOC;
	}
	public void setLOC(String lOC) {
		LOC = lOC;
	}
	public Dept(BigDecimal dEPTNO, String dNAME, String lOC) {
		super();
		DEPTNO = dEPTNO;
		DNAME = dNAME;
		LOC = lOC;
	}
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dept [DEPTNO=" + DEPTNO + ", DNAME=" + DNAME + ", LOC=" + LOC
				+ "]\n";
	}
	
	

}
