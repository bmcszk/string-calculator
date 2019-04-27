package blazesoft;

public class NegativesNotAllowedException extends IllegalArgumentException {
    public NegativesNotAllowedException(String message) {
        super(message);
    }
}
