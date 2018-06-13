package TF.model;

import java.sql.Date;

public class SubProjectDO {
	private int SubpId;
	private String SubpName;
	private String SubpDescript;
	private Date SubpStartDate;
	private Date SubpEndDate;
	private int SubpState;
	private int SubpFrom;
	
	public SubProjectDO() {}
	
	public SubProjectDO(int SubpId, String SubpName, String SubpDescript, Date SubpStartDate, Date SubpEndDate, int SubpState, int SubpFrom) {
		this.SubpId = SubpId;
		this.SubpName = SubpName;
		this.SubpDescript = SubpDescript;
		this.SubpStartDate = SubpStartDate;
		this.SubpEndDate = SubpEndDate;
		this.SubpState = SubpState;
		this.SubpFrom = SubpFrom;
	}
	
	public int getSubpId() {
		return SubpId;
	}

	public void setSubpId(int subpId) {
		SubpId = subpId;
	}

	public String getSubpName() {
		return SubpName;
	}

	public void setSubpName(String subpName) {
		SubpName = subpName;
	}

	public String getSubpDescript() {
		return SubpDescript;
	}

	public void setSubpDescript(String subpDescript) {
		SubpDescript = subpDescript;
	}

	public Date getSubpStartDate() {
		return SubpStartDate;
	}

	public void setSubpStartDate(Date subpStartDate) {
		SubpStartDate = subpStartDate;
	}

	public Date getSubpEndDate() {
		return SubpEndDate;
	}

	public void setSubpEndDate(Date subpEndDate) {
		SubpEndDate = subpEndDate;
	}

	public int getSubpState() {
		return SubpState;
	}

	public void setSubpState(int subpState) {
		SubpState = subpState;
	}

	public int getSubpFrom() {
		return SubpFrom;
	}

	public void setSubpFrom(int subpFrom) {
		SubpFrom = subpFrom;
	}
	
	

}

	