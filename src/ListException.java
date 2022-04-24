public class ListException extends Exception {
	private String error;
	
	public ListException(String error) {
		this.error=error;
	}

	@Override
	public String toString() {
		return error;
	}
}
