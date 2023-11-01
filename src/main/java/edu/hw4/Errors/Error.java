package edu.hw4.Errors;

public class Error {
    private String message;


    public String getMessage() {
        return message;
    }

    protected void setMessage(String message) {
        this.message = message;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Error error = (Error) o;

        return message != null ? message.equals(error.message) : error.message == null;
    }

    @Override
    public int hashCode() {
        return message != null ? message.hashCode() : 0;
    }
}
