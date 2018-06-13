package spring.modelo.relacional.resource.exception;

public class StandardError {
	private Integer status;
	private String menssage;
	private long timestamp;

	public StandardError(Integer status, String menssage, long timestamp) {
		super();
		this.status = status;
		this.menssage = menssage;
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMenssage() {
		return menssage;
	}

	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
