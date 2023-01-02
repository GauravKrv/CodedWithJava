package Patterns.state;

public class StateOne implements StateInterface {
    private final StateUser stateUser;
    public StateOne(StateUser stateUser) {
        this.stateUser = stateUser;
    }

    @Override
    public void currentState() {
        System.out.println("Current state is StateOne");
    }

    @Override
    public void changedState() {
        System.out.println("Changed the state to StateOne");
    }

    @Override
    public void changingState() {
        System.out.println("Changing the state from StateOne");
    }
}
