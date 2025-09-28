
package tp6_exercise6;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear un Motor2Tiempos
            Motor2Tiempos motorOriginal = new Motor2Tiempos("Yamaha", "YZ250", 48.5, 120);

            // Crear un Automovil con ese motor
            Automovil autoOriginal = new Automovil("Yamaha", "Cross", motorOriginal, "ABC123");

            // Clonar el Automovil
            Automovil autoClonado = (Automovil) autoOriginal.clone();

            // Mostrar datos
            System.out.println("Automóvil original -> Motor: " + autoOriginal.getMotor());
            System.out.println("Automóvil clonado  -> Motor: " + autoClonado.getMotor());
            
            // clona mal porque le colocaste el new, entonces ASUME que es Motor normal?? 
            // y no motor a 2 tiempos
            System.out.println( autoClonado.getMotor() );
            
            // Verificar si los objetos son distintos
            System.out.println("¿Es el mismo motor en memoria? " + (autoOriginal.getMotor() == autoClonado.getMotor()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
