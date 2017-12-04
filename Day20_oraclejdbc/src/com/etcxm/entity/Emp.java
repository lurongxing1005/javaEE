package com.etcxm.entity;

import java.math.BigDecimal;

public class Emp {
	private Long EMPNO;
	private String ENAME;
	private Double COMM;

	public Long getEMPNO() {
		return EMPNO;
	}

	public void setEMPNO(Long eMPNO) {
		EMPNO = eMPNO;
	}

	public String getENAME() {
		return ENAME;
	}

	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}

	public Double getCOMM() {
		return COMM;
	}

	public void setCOMM(Double cOMM) {
		COMM = cOMM;
	}

	public Emp(Long eMPNO, String eNAME, Double cOMM) {
		super();
		EMPNO = eMPNO;
		ENAME = eNAME;
		COMM = cOMM;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Emp [EMPNO=" + EMPNO + ", ENAME=" + ENAME + ", COMM=" + COMM
				+ "]";
	}

}
