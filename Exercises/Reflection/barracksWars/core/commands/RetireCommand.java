package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class RetireCommand extends Command {
    public RetireCommand(String[] data, UnitFactory factory, Repository repository) {
        super(data, factory, repository);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        try {
            this.getRepository().removeUnit(unitType);
            return unitType + " retired!";
        } catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }
}
