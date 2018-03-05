package league.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Team {

    private final String name;
    private final Set<Player> players = new HashSet<>();

    public Team(String name) {
        this.name = checkNotNull(name,"Team's name was not given");
    }

    public String getName() {
        return name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void addPlayer (Player player) {
        checkNotNull(player, "Player cannot be null");
        checkArgument(!players.contains(player), "Player " + player + " already plays in " + this);
        players.add(player);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Player p : players) {
            sb.append(p + "\n");
        }
        return "Team "+ name + ":" + "\n" + sb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return name != null ? name.equals(team.name) : team.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

}
