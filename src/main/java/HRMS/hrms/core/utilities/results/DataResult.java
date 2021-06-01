package HRMS.hrms.core.utilities.results;

public class DataResult<T> extends Result{

	T data;
	
	public DataResult(boolean success) {
		super(success);
	}
	
	public DataResult(boolean success, String message) {
		super(success, message);
	}
	
	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}
	
	public DataResult(T data, boolean success, String message) {
		super(success, message);
		this.data = data;
	}

	
}
