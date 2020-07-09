package com.vti.academy.web.common;

public enum RestCode  {
	
	SUCCESS(1, "aaaaa"),
	ERROR(2, "aaaaa"),
	BAD_REQUEST(3, "aaaa"),
	PARAMETER_INVALID(4, "aaaa"),
	ACCESS_DENIED(5, "aaaa"),
	UNAUTHENTICATED(6, "aaaa"),
	NOT_FOUND(7, "aaaa"),
	ERROR_INTERNAL_SERVER(8, "aaaa"),
	NO_CONTENT(9, " aaaa"),
	VALIDATE_DELETE_TASK(10, "aaaa"),
	NOT_SUPPORT_ADMIN(11, "aaaa")
	;

    private final int code;
    private final String description;
    private ResponseType responseType;
    
    private RestCode(final int code, final String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
		return code;
	}
    
    public String getCodeString() {
		return String.valueOf(code);
	}

	public String getDescription() {
		return description;
	}

	public ResponseType getResponseType() {
		return responseType;
	}
}
