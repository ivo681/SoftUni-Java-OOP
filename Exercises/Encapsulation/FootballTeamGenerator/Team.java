package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name){
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name.trim();
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(String name){
        boolean deleted = false;
        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i).getName().matches(name)){
                this.players.remove(i);
                deleted = true;
                break;
            }
        }
        if (!deleted){
            throw new IllegalArgumentException("Player " + name + " is not in " + this.getName() + " team.");
        }
    }

    public double getRating(){
        return this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }
}
