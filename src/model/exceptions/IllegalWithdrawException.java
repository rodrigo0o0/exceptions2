package model.exceptions;

public class IllegalWithdrawException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public IllegalWithdrawException(String msg) {
		super(msg);
	}
}
