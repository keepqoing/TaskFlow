package TF.model;

import java.sql.Date;

public class NoticeDO {
	private int nId;
	private String nName;
	private String nDescript;
	private String nWriter;
	private Date nDate;
	private int nFrom;
	
	public NoticeDO() {}
	
	public NoticeDO(int nId, String nName, String nDescript, String nWriter, Date nDate, int nFrom) {
		this.nId = nId;
		this.nName = nName;
		this.nDescript = nDescript;
		this.nWriter = nWriter;
		this.nDate = nDate;
		this.nFrom = nFrom;
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public String getnName() {
		return nName;
	}

	public void setnName(String nName) {
		this.nName = nName;
	}

	public String getnDescript() {
		return nDescript;
	}

	public void setnDescript(String nDescript) {
		this.nDescript = nDescript;
	}

	public String getnWriter() {
		return nWriter;
	}

	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public int getnFrom() {
		return nFrom;
	}

	public void setnFrom(int nFrom) {
		this.nFrom = nFrom;
	}


	
}
