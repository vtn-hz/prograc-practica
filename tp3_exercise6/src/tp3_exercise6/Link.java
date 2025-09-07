package tp3_exercise6;

public class Link extends Single {

	private FileSystemEntity linkedFile;
	
	public Link(String fecha_creacion, String nombre, FileSystemEntity linkedFile) {
		super(fecha_creacion, nombre);
		this.linkedFile = linkedFile;
	}

	@Override
	public double getTamano() {
		return 1;
	}

	public FileSystemEntity getLinkedFile() {
		return linkedFile;
	}
}
