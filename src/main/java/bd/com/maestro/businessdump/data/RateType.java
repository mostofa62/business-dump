package bd.com.maestro.businessdump.data;

public enum RateType {

	
	BUY((byte)0,"BUY"),
	SELL((byte)1,"SELL");
	
	private byte key;
	private String value;
	
	
	
	
	RateType(byte key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public byte getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
}
