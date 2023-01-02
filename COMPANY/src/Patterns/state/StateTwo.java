package Patterns.state;

public class StateTwo implements StateInterface {

    private final StateUser stateUser;
    public StateTwo(StateUser stateUser) {
        this.stateUser = stateUser;
    }

    @Override
    public void currentState() {
        System.out.println("Current state is StateTwo");
    }

    @Override
    public void changedState() {
        System.out.println("Changed the state to StateTwo");
    }

    @Override
    public void changingState() {
        System.out.println("Changing the state from StateTwo");
    }
}
