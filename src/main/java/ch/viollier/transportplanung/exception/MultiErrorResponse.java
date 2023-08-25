package ch.viollier.transportplanung.exception;

import java.util.Map;
import java.util.Objects;

public class MultiErrorResponse extends ErrorResponse{
    private Map<String,String> message;

    public MultiErrorResponse() {
        super();
    }

    public MultiErrorResponse(Integer status, String error, String timestamp, String path, Map<String, String> message) {
        super(status, error, timestamp, path);
        this.message = message;
    }

    public Map<String, String> getMessage() {
        return message;
    }

    public void setMessage(Map<String, String> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MultiErrorResponse{" +
                "messages=" + message +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MultiErrorResponse that = (MultiErrorResponse) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), message);
    }
}
