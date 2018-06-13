package TF.model;

public class SubProjectDO {
	private int subpId;
	private String subpName;
	private String subpDescript;
	private String subpStartDate;
	private String subpEndDate;
	private int subpState;
	private int subpFrom;
	
	public SubProjectDO() {}
	
	public SubProjectDO(int SubpId, String SubpName, String SubpDescript, String SubpStartDate, String SubpEndDate, int SubpState, int SubpFrom) {
		this.subpId = SubpId;
		this.subpName = SubpName;
		this.subpDescript = SubpDescript;
		this.subpStartDate = SubpStartDate;
		this.subpEndDate = SubpEndDate;
		this.subpState = SubpState;
		this.subpFrom = SubpFrom;
	}

	public int getSubpId() {
		return subpId;
	}

	public void setSubpId(int subpId) {
		this.subpId = subpId;
	}

	public String getSubpName() {
		return subpName;
	}

	public void setSubpName(String subpName) {
		this.subpName = subpName;
	}

	public String getSubpDescript() {
		return subpDescript;
	}

	public void setSubpDescript(String subpDescript) {
		this.subpDescript = subpDescript;
	}

	public String getSubpStartDate() {
		return subpStartDate;
	}

	public void setSubpStartDate(String subpStartDate) {
		this.subpStartDate = subpStartDate;
	}

	public String getSubpEndDate() {
		return subpEndDate;
	}

	public void setSubpEndDate(String subpEndDate) {
		this.subpEndDate = subpEndDate;
	}

	public int getSubpState() {
		return subpState;
	}

	public void setSubpState(int subpState) {
		this.subpState = subpState;
	}

	public int getSubpFrom() {
		return subpFrom;
	}

	public void setSubpFrom(int subpFrom) {
		this.subpFrom = subpFrom;
	}
	
	
	
	

}

	