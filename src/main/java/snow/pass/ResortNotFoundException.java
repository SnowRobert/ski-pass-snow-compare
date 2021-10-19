package snow.pass;

class ResortNotFoundException extends RuntimeException {

  ResortNotFoundException(String id) {
    super("Could not find resort " + id);
  }
}
