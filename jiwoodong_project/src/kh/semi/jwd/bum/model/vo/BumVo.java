package kh.semi.jwd.bum.model.vo;

import oracle.sql.TIMESTAMP;

public class BumVo {
// 	B_MEMBER table
//	BU_NO          NOT NULL NUMBER         
//	BU_ID          NOT NULL VARCHAR2(20)   
//	BU_NUMBER      NOT NULL VARCHAR2(20)   
//	BU_PWD         NOT NULL VARCHAR2(40)   
//	BU_NAME        NOT NULL VARCHAR2(20)   
//	BU_BIRTH       NOT NULL VARCHAR2(20)   
//	BU_GENDER      NOT NULL VARCHAR2(1)    
//	BU_EMAIL       NOT NULL VARCHAR2(100)  
//	BU_TEL         NOT NULL VARCHAR2(20)   
//	BU_USEYN       NOT NULL VARCHAR2(1)    
//	BU_WRITE_DATE           TIMESTAMP(6)   
//	BU_UPDATE_DATE          TIMESTAMP(6)   
//	BU_OUT_DATE             TIMESTAMP(6)   
//	FL_GNO                  VARCHAR2(4000) 
		
	//우진
	private int buNo ;
	private String buId;
	private String buNumber;
	private String buPwd;
	private String buName;
	private String buBirth;
	private String buGender;
	private String buEmail;
	private String buTel;
	private String buUseYn;
	private TIMESTAMP buWriteDate;
	private TIMESTAMP buUpdateDate;
	private TIMESTAMP buOutDate;
	private String flGno;
	
	// TO_CHAR이용해서 담는 변수 : 손은진
	private String toCharbuWriteDate;
	private String toCharbuOutDate;
	
	// rownum용 변수 : 손은진
	private int rownum;
	
	// cpNo 변수 : 손은진
	private int cpNo;
	
	
	@Override
	public String toString() {
		return "BumVo [buNo=" + buNo + ", buId=" + buId + ", buNumber=" + buNumber + ", buPwd=" + buPwd + ", buName="
				+ buName + ", buBirth=" + buBirth + ", buGender=" + buGender + ", buEmail=" + buEmail + ", buTel="
				+ buTel + ", buUseYn=" + buUseYn + ", buWriteDate=" + buWriteDate + ", buUpdateDate=" + buUpdateDate
				+ ", buOutDate=" + buOutDate + ", flGno=" + flGno + "]";
	}
	
	
	// toCharbuWriteDate getter, setter : 손은진
	public String getToCharbuWriteDate() {
		return toCharbuWriteDate;
	}

	public void setToCharbuWriteDate(String toCharbuWriteDate) {
		this.toCharbuWriteDate = toCharbuWriteDate;
	}
	
	// toCharbuOutDate getter, setter : 손은진
	public String getToCharbuOutDate() {
		return toCharbuOutDate;
	}

	public void setToCharbuOutDate(String toCharbuOutDate) {
		this.toCharbuOutDate = toCharbuOutDate;
	}


	// rownum getter, setter : 손은진
	public int getRownum() {
		return rownum;
	}


	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	
	// cpNo getter, setter : 손은진
	public int getCpNo() {
		return cpNo;
	}


	public void setCpNo(int cpNo) {
		this.cpNo = cpNo;
	}


	public int getBuNo() {
		return buNo;
	}
	public void setBuNo(int buNo) {
		this.buNo = buNo;
	}

	public String getBuNumber() {
		return buNumber;
	}
	public void setBuNumber(String buNumber) {
		this.buNumber = buNumber;
	}
	public String getBuPwd() {
		return buPwd;
	}
	public void setBuPwd(String buPwd) {
		this.buPwd = buPwd;
	}
	public String getBuName() {
		return buName;
	}
	public void setBuName(String buName) {
		this.buName = buName;
	}
	public String getBuBirth() {
		return buBirth;
	}
	public void setBuBirth(String buBirth) {
		this.buBirth = buBirth;
	}
	public String getBuGender() {
		return buGender;
	}
	public void setBuGender(String buGender) {
		this.buGender = buGender;
	}
	public String getBuEmail() {
		return buEmail;
	}
	public void setBuEmail(String buEmail) {
		this.buEmail = buEmail;
	}
	
	
	public BumVo() {}
	public BumVo(int buNo, String buNumber, String buPwd, String buName, String buBirth, String buGender,
			String buEmail, String flGno) {
		super();
		this.buNo = buNo;
		this.buNumber = buNumber;
		this.buPwd = buPwd;
		this.buName = buName;
		this.buBirth = buBirth;
		this.buGender = buGender;
		this.buEmail = buEmail;
		this.flGno = flGno;
	}
	
	//승희
	public String getBuId() {
		return buId;
	}
	public void setBuId(String buId) {
		this.buId = buId;
	}
	public String getBuTel() {
		return buTel;
	}
	public void setBuTel(String buTel) {
		this.buTel = buTel;
	}
	public String getBuUseYn() {
		return buUseYn;
	}
	public void setBuUseYn(String buUseYn) {
		this.buUseYn = buUseYn;
	}
	
		public TIMESTAMP getBuWriteDate() {
		return buWriteDate;
	}


	public void setBuWriteDate(TIMESTAMP buWriteDate) {
		this.buWriteDate = buWriteDate;
	}


	public TIMESTAMP getBuUpdateDate() {
		return buUpdateDate;
	}


	public void setBuUpdateDate(TIMESTAMP buUpdateDate) {
		this.buUpdateDate = buUpdateDate;
	}


	public TIMESTAMP getBuOutDate() {
		return buOutDate;
	}


	public void setBuOutDate(TIMESTAMP buOutDate) {
		this.buOutDate = buOutDate;
	}


	public String getFlGno() {
		return flGno;
	}


	public void setFlGno(String flGno) {
		this.flGno = flGno;
	}

	public BumVo(int buNo, String buId, String buNumber, String buPwd, String buName, String buBirth, String buGender,
			String buEmail, String buTel, String buUseYn) {
		super();
		this.buNo = buNo;
		this.buId = buId;
		this.buNumber = buNumber;
		this.buPwd = buPwd;
		this.buName = buName;
		this.buBirth = buBirth;
		this.buGender = buGender;
		this.buEmail = buEmail;
		this.buTel = buTel;
		this.buUseYn = buUseYn;
	}
}
