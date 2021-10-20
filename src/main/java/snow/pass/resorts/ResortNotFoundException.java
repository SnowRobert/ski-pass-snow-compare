package snow.pass.resorts;

class ResortNotFoundException extends RuntimeException {

  ResortNotFoundException(String id) {
    super("Could not find resort " + id);
  }
}
