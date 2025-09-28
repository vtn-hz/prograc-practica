package tp6_exercise4;

public class Main {
    public static void main(String[] args) {
        try {
            // Creo el conjunto original con espacio para 10 elementos
            ConjuntoNumeros original = new ConjuntoNumeros("Original", 10);

            // Cargo 10 elementos usando un for
            for (int i = 0; i < original.getLargo(); i++) {
                original.addNumero(new Numero((i + 1) * 10));
            }
            
            ConjuntoNumeros copia = (ConjuntoNumeros) original.clone();

            copia.getCelda()[0].setDato(11);
            copia.getCelda()[1].setDato(12);
            copia.getCelda()[2].setDato(13);
         
            System.out.println("Elementos del conjunto original:");
            for (Numero n : original.getCelda()) {
                System.out.print(n + " ");
            }
            System.out.println();

            System.out.println("\nElementos del conjunto copiado:");
            for (Numero n : copia.getCelda()) {
                System.out.print(n + " ");
            }
            System.out.println();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
