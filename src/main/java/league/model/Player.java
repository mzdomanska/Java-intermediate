package league.model;

import static com.google.common.base.Preconditions.checkNotNull;

public class Player {

    private final String firstName;
    private final String lastName;
    private final Team team;

    public Player(String firstName, String lastName, Team team) {
        this.firstName = checkNotNull(firstName,"Player's first name was not given");
        this.lastName = checkNotNull(lastName,"Player's last name was not given");
        this.team = checkNotNull(team,"Player's team was not given");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (firstName != null ? !firstName.equals(player.firstName) : player.firstName != null) return false;
        return lastName != null ? lastName.equals(player.lastName) : player.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
