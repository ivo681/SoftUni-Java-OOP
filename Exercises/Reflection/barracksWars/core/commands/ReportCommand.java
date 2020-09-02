package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class ReportCommand extends Command {
    public ReportCommand(String[] data, UnitFactory factory, Repository repository) {
        super(data, factory, repository);
    }

    @Override
    public String execute() {
        return this.getRepository().getStatistics();
    }
}
