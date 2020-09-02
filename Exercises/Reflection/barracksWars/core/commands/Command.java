package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String [] data;
    private UnitFactory factory;
    private Repository repository;

    protected Command(String [] data, UnitFactory factory, Repository repository){
        this.data = data;
        this.factory = factory;
        this.repository = repository;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getFactory() {
        return factory;
    }

    protected String[] getData() {
        return data;
    }
}
