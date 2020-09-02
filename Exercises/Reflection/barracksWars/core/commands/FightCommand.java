package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class FightCommand extends Command {
    public FightCommand(String[] data, UnitFactory factory, Repository repository) {
        super(data, factory, repository);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
