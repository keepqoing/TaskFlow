package TF.model;

public class SubmissionDO {
	private int smId;
	private String pCode;
	private String spCode;
	private String writer;
	private String sDate;
	private String comment;
	private String filename;
	
	public SubmissionDO() {}
	public SubmissionDO(int smId, String pCode, String spCode, String writer, String sDate, String comment, String filename) {
		this.smId = smId;
		this.pCode = pCode;
		this.spCode = spCode;
		this.writer = writer;
		this.sDate = sDate;
		this.comment = comment;
		this.filename = filename;
	}
	
	
	
	public int getSmId() {
		return smId;
	}
	public void setSmId(int smId) {
		this.smId = smId;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getSpCode() {
		return spCode;
	}
	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}
	

	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
