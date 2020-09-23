package FootballTeamGenerator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new LinkedHashMap<>();
        
        String command = scanner.nextLine();
        while (!command.matches("END")){
            String [] tokens = command.split(";");
            switch (tokens[0]){
                case "Team":
                    try {
                        teams.putIfAbsent(tokens[1], new Team(tokens[1]));
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add":
                    String Team = tokens[1];
                    if (teams.containsKey(Team)) {
                        try {
                            String name = tokens[2];
                            int endurance = Integer.parseInt(tokens[3]);
                            int sprint = Integer.parseInt(tokens[4]);
                            int dribble = Integer.parseInt(tokens[5]);
                            int passing = Integer.parseInt(tokens[6]);
                            int shooting = Integer.parseInt(tokens[7]);
                            teams.get(Team).addPlayer(new Player(name, endurance, sprint, dribble, passing, shooting));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Team " + Team + " does not exist.");
                    }
                    break;
                case "Remove":
                    Team = tokens[1];
                    if (teams.containsKey(Team)){
                        try {
                            String playerName = tokens[2];
                            teams.get(Team).removePlayer(playerName);
                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Team " + Team + " does not exist.");
                    }
                    break;
                case "Rating":
                    Team = tokens[1];
                    if (teams.containsKey(Team)){
                        System.out.printf("%s - %.0f%n",Team, teams.get(Team).getRating());
                    } else {
                        System.out.println("Team " + Team + " does not exist.");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
