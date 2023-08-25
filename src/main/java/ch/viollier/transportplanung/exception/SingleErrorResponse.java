package ch.viollier.transportplanung.exception;

import java.util.Map;
import java.util.Objects;

public class SingleErrorResponse extends ErrorResponse{

    private String message;

    public SingleErrorResponse(){
        super();
    }

    public SingleErrorResponse(Integer status, String error, String timestamp, String path, String message){
        super(status, error, timestamp, path);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SingleErrorResponse that = (SingleErrorResponse) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), message);
    }

    @Override
    public String toString() {
        return "SingleErrorResponse{" +
                "message='" + message + '\'' +
                "} " + super.toString();
    }
}
