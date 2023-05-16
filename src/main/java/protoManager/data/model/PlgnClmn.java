package protoManager.data.model;

public class PlgnClmn {

	
	private String name;
	private String displayName;
	private String description;
	private String plgnLocale;
	
	public PlgnClmn() {
		
	}
	
	public PlgnClmn(String name,String displayName,String description,String plgnLocale) {
		this.name = name;
		this.displayName = displayName;
		this.description = description;
		this.plgnLocale = plgnLocale;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlgnLocale() {
		return plgnLocale;
	}

	public void setPlgnLocale(String plgnLocale) {
		this.plgnLocale = plgnLocale;
	}
}
