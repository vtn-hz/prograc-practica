package tp3_exercise6;

public class Main {
    public static void main(String[] args) {
        // Crear directorio raíz
        Directorio raiz = new Directorio("2024-01-01", "C:");
        
        // ===== ARCHIVOS EN LA RAÍZ =====
        
        // Crear archivos que serán referenciados por los enlaces
        Archivo dsc08910Original = new Archivo("2024-01-15", "DSC08910.JPG", "2024-01-15", 2000);
        Archivo saveMeOriginal = new Archivo("2024-02-01", "Save me.mp3", "2024-02-01", 4200);
        
        // Crear enlaces en la raíz
        Link linkDSC08910 = new Link("2024-03-01", "Acceso directo a DSC08910.JPG.lnk", dsc08910Original);
        Link linkSaveMe = new Link("2024-03-01", "Acceso directo a Save me.mp3.lnk", saveMeOriginal);
        
        // Archivo de texto en la raíz
        Archivo recordatorio = new Archivo("2024-02-15", "Recordatorio.txt", "2024-02-15", 5);
        
        // ===== CREAR SUBDIRECTORIOS =====
        
        // Directorio fotos
        Directorio fotos = new Directorio("2024-01-10", "fotos");
        fotos.addFile(new Archivo("2024-01-10", "CAM00053.jpg", "2024-01-10", 150))
             .addFile(new Archivo("2024-01-10", "CAM00054.jpg", "2024-01-10", 200))
             .addFile(new Archivo("2024-01-10", "CAM00055.jpg", "2024-01-10", 170))
             .addFile(new Archivo("2024-01-10", "CAM00056.jpg", "2024-01-10", 150))
             .addFile(new Archivo("2024-01-10", "CAM00057.jpg", "2024-01-10", 250));
        
        // Subdirectorio viaje dentro de fotos
        Directorio viaje = new Directorio("2024-01-20", "viaje");
        Link linkRaiz = new Link("2024-03-01", "Acceso directo a raiz.lnk", raiz);
        viaje.addFile(linkRaiz)
             .addFile(new Archivo("2024-01-20", "DSC08904.JPG", "2024-01-20", 1500))
             .addFile(new Archivo("2024-01-20", "DSC08909.JPG", "2024-01-20", 1000))
             .addFile(dsc08910Original) // El archivo original referenciado por el enlace
             .addFile(new Archivo("2024-01-20", "DSC08911.JPG", "2024-01-20", 2500));
        
        fotos.addSubdirectory(viaje);
        
        // Directorio mis documentos
        Directorio misDocumentos = new Directorio("2024-01-05", "mis documentos");
        misDocumentos.addFile(new Archivo("2024-01-05", "carta.doc", "2024-01-05", 30))
                    .addFile(new Archivo("2024-01-05", "curriculum.doc", "2024-01-05", 60))
                    .addFile(new Archivo("2024-01-05", "receta de cocina.doc", "2024-01-05", 80));
        
        // Directorio mp3
        Directorio mp3 = new Directorio("2024-02-01", "mp3");
        mp3.addFile(new Archivo("2024-02-01", "El choclo.mp3", "2024-02-01", 3500))
           .addFile(new Archivo("2024-02-01", "El dia que me quieras.Mp3", "2024-02-01", 4500))
           .addFile(new Archivo("2024-02-01", "Naranjo en flor.MP3", "2024-02-01", 5000));
        
        // Subdirectorio Queen dentro de mp3
        Directorio queen = new Directorio("2024-02-10", "Queen");
        queen.addFile(new Archivo("2024-02-10", "Bohemian Rhapsody.mp3", "2024-02-10", 5300))
             .addFile(saveMeOriginal); // El archivo original referenciado por el enlace
        
        mp3.addSubdirectory(queen);
        
        // ===== CREAR ARCHIVOS COMPRIMIDOS =====
        
        // Calcular tamaño total para determinar las tasas de compresión
        double tamanoQueen = queen.getTamano();
        double tamanoMisDocumentos = misDocumentos.getTamano();
        double tamanoTotal = raiz.getTamano() + fotos.getTamano() + misDocumentos.getTamano() + mp3.getTamano();
        
        // Queen.zip ocupa el 80% del contenido de Queen
        Comprimido queenZip = new Comprimido("2024-03-01", "Queen.zip", queen, 0.80);
        
        // Mis Documentos.zip ocupa el 30% del contenido de mis documentos  
        Comprimido misDocumentosZip = new Comprimido("2024-03-01", "Mis Documentos.zip", misDocumentos, 0.30);
        
        // ===== ENSAMBLAR ESTRUCTURA COMPLETA =====
        
        raiz.addFile(linkDSC08910)
            .addFile(linkSaveMe)
            .addFile(queenZip)
            .addFile(misDocumentosZip)
            .addFile(recordatorio)
            .addSubdirectory(fotos)
            .addSubdirectory(misDocumentos)
            .addSubdirectory(mp3);
        
        // ===== MOSTRAR RESULTADOS =====
        
        System.out.println("=== ESTRUCTURA DEL SISTEMA DE ARCHIVOS ===");
        raiz.print();
        
        System.out.println("\n\n=== INFORMACIÓN DE TAMAÑOS ===");
        System.out.printf("Tamaño total del directorio raíz: %.2f kb%n", raiz.getTamano());
        System.out.printf("Tamaño del directorio fotos: %.2f kb%n", fotos.getTamano());
        System.out.printf("Tamaño del directorio mis documentos: %.2f kb%n", misDocumentos.getTamano());
        System.out.printf("Tamaño del directorio mp3: %.2f kb%n", mp3.getTamano());
        System.out.printf("Tamaño del directorio Queen: %.2f kb%n", queen.getTamano());
        
        System.out.println("\n=== CONTENIDO DE ARCHIVOS COMPRIMIDOS ===");
        System.out.println("Contenido de Queen.zip:");
        queenZip.showContent();
        
        System.out.println("\nContenido de Mis Documentos.zip:");
        misDocumentosZip.showContent();
        
        System.out.println("\n=== VERIFICACIÓN DE ENLACES ===");
        System.out.println("El enlace 'Acceso directo a DSC08910.JPG.lnk' apunta a: " + 
                          linkDSC08910.getLinkedFile().getNombre());
        System.out.println("El enlace 'Acceso directo a Save me.mp3.lnk' apunta a: " + 
                          linkSaveMe.getLinkedFile().getNombre());
        System.out.println("El enlace 'Acceso directo a raiz.lnk' apunta a: " + 
                          linkRaiz.getLinkedFile().getNombre());
    }
}