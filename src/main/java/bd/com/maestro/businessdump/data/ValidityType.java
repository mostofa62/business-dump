package bd.com.maestro.businessdump.data;

public enum ValidityType {

	MONTH("M", "MONTH"),
	YEAR("Y", "YEAR");
	
	private String key;
	private String value;
	
	ValidityType(String key, String value){
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
}
