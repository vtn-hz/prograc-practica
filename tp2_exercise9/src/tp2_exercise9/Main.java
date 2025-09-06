package tp2_exercise9;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        // --- Crear jugadores ---
        Player p1 = new Player("Juan");
        Player p2 = new Player("Ana");
        Player p3 = new Player("Carlos");
        Player p4 = new Player("Lucia");
        Player p5 = new Player("Marta");
        Player p6 = new Player("Diego");
        Player p7 = new Player("Sofia");
        Player p8 = new Player("Luis");

        // --- Crear equipos ---
        Team teamA = new Team();
        teamA.addPlayer(p1);
        teamA.addPlayer(p2);
        teamA.addPlayer(p3);
        teamA.addPlayer(p4);

        Team teamB = new Team();
        teamB.addPlayer(p5);
        teamB.addPlayer(p6);
        teamB.addPlayer(p7);
        teamB.addPlayer(p8);

        // --- Crear torneo ---
        Tornament torneo = new Tornament();

        // --- Crear partido ---
        GregorianCalendar date1 = new GregorianCalendar(2025, 8, 6); // 6 Septiembre 2025
        Match match1 = new Match(new Team[]{teamA, teamB}, date1);

        // --- Registrar ganador ---
        match1.setWinner(teamA); // gana teamA
        match1.updateTeamsStats(); 

        // --- Agregar partido al torneo ---
        torneo.addMatch(match1);

        // --- Mostrar puntajes de cada jugador ---
        System.out.println("=== Puntajes jugadores ===");
        for (Player p : teamA.getPlayers()) {
            System.out.println(p.getName() + ": " + p.getPoints() + " puntos");
        }
        for (Player p : teamB.getPlayers()) {
            System.out.println(p.getName() + ": " + p.getPoints() + " puntos");
        }

        // --- Mostrar puntajes de equipos ---
        System.out.println("\n=== Puntajes equipos ===");
        System.out.println("Team A: " + teamA.getPoints() + " puntos");
        System.out.println("Team B: " + teamB.getPoints() + " puntos");

        // --- Crear otro partido con empate ---
        GregorianCalendar date2 = new GregorianCalendar(2025, 8, 7);
        Match match2 = new Match(new Team[]{teamA, teamB}, date2);
        match2.setWinner(null); // empate
        match2.updateTeamsStats();
        torneo.addMatch(match2);

        // --- Mostrar historial ---
        System.out.println("\n=== Historial de partidos ===");
        for (Match m : torneo.getMatches()) {
        	String winnerName = m.wasDraw() ? "Empate" 
                    : "Ganador: " + (m.getTeam(0).getPoints() > m.getTeam(1).getPoints() ? "Team A" : "Team B");
            System.out.println("Fecha: " + m.getDate().getTime() + " - " + winnerName);
        }

        // --- Estadísticas de jugadores ---
        System.out.println("\n=== Estadísticas individuales ===");
        System.out.println(p1.getName() + " - Puntos: " + p1.getPoints() + " Ganados: " + p1.getWonCant()  + " Perdidos: " + p1.getLoseCant() + " Empates: " + p1.getDrawCant());
        System.out.println(p5.getName() + " - Puntos: " + p5.getPoints() + " Ganados: " + p5.getWonCant() + " Perdidos: " + p5.getLoseCant() + " Empates: " + p5.getDrawCant());

        // --- Consultar partidos entre dos jugadores ---
        int sameTeam = torneo.countSameTeam(p1, p2);
        int against = torneo.countAgainst(p1, p5);
        System.out.println("\nP1 y P2 jugaron juntos: " + sameTeam + " veces");
        System.out.println("P1 y P5 jugaron enfrentados: " + against + " veces");
    }
}
