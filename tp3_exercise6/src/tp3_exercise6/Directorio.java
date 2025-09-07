package tp3_exercise6;

import java.util.ArrayList;

public class Directorio extends FileSystemEntity {
	private ArrayList<Directorio> subdir;
	
	private ArrayList<Single> files;

	public Directorio(String fecha_creacion, String nombre) {
		super(fecha_creacion, nombre);
		this.subdir =  new ArrayList<Directorio>();
		this.files = new ArrayList<Single>();
	}
	
	public double getTamano() {
		double tam = 0;
		
		for(Single file: this.files) {
			tam += file.getTamano();
		}
		
		for(Directorio directory: this.subdir) {
			tam += directory.getTamano();
		}
		
		return tam;
	}
	
	 public void print() {
		 print(0);
	 }
    
    // Nuevo método print con parámetro de nivel de indentación
    public void print(int nivel) {
        // Crear la indentación basada en el nivel
        String indentacion = "";
        for (int i = 0; i < nivel; i++) {
            indentacion += "│   ";  // 4 espacios con línea vertical
        }
        
        // Imprimir el nombre del directorio con la indentación apropiada
        if (nivel == 0) {
            System.out.println(this.getNombre());
        } else {
            System.out.println(indentacion + "├───" + this.getNombre());
        }
        
        // Imprimir archivos con indentación adicional
        for(Single file: this.files) {
            System.out.print(indentacion + "│   ");
            file.print();
            System.out.println(); // Salto de línea después de cada archivo
        }
        
        // Imprimir subdirectorios con nivel incrementado
        for(int i = 0; i < this.subdir.size(); i++) {
            Directorio directory = this.subdir.get(i);
            directory.print(nivel + 1);
        }
        
        // Agregar línea vacía después del último subdirectorio (solo en nivel 0)
        if (nivel == 0 && !this.subdir.isEmpty()) {
            System.out.println();
        }
    }
	
	public Directorio addSubdirectory( Directorio dir) {
		this.subdir.add(dir);
		return this;
	}
	
	public Directorio addFile( Single archivo) {
		this.files.add(archivo);
		return this;
	}

	public ArrayList<Directorio> getSubdir() {
		return subdir;
	}

	public ArrayList<Single> getFiles() {
		return files;
	}
}
