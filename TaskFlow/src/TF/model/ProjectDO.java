package TF.model;

public class ProjectDO {
	private int pCode;
	private String pName;
	private String pDescript;
	private String pManager; 
	private String pMember;
	
	public ProjectDO() {}
	public ProjectDO(int pCode, String pName, String pDescript, String pManager, String pMember) {
		this.pCode = pCode;
		this.pName = pName;
		this.pDescript = pDescript;
		this.pManager = pManager;
		this.pMember = pMember;
	}
	
	public int getpCode() {
		return pCode;
	}
	public void setpCode(int pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDescript() {
		return pDescript;
	}
	public void setpDescript(String pDescript) {
		this.pDescript = pDescript;
	}
	public String getpManager() {
		return pManager;
	}
	public void setpManager(String pManager) {
		this.pManager = pManager;
	}
	public String getpMember() {
		return pMember;
	}
	public void setpMember(String pMember) {
		this.pMember = pMember;
	}
}
