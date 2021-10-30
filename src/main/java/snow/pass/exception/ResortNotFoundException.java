package snow.pass.exception;

public class ResortNotFoundException extends RuntimeException {

  public ResortNotFoundException(String id) {
    super("Could not find resort " + id);
  }
}
