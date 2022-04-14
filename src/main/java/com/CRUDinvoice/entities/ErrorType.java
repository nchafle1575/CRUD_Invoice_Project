package com.CRUDinvoice.entities;

import java.util.Objects;

public class ErrorType {
	
	private String time;
	private String status;
	private String message;
	public ErrorType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorType(String time, String status, String message) {
		super();
		this.time = time;
		this.status = status;
		this.message = message;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ErrorType [time=" + time + ", status=" + status + ", message=" + message + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(message, status, time);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorType other = (ErrorType) obj;
		return Objects.equals(message, other.message) && Objects.equals(status, other.status)
				&& Objects.equals(time, other.time);
	}
	
	
}
