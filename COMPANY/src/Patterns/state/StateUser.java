package Patterns.state;

public class StateUser {

    private StateInterface currStateStateInterface;
    public StateUser(){
        currStateStateInterface = new StateOne(this);
    }

    public void useOtherState() {
        if (currStateStateInterface.getClass().equals(StateOne.class)) {
            changeStateTo(new StateTwo(this));
        } else {
            changeStateTo(new StateOne(this));
        }
    }

    private void changeStateTo(StateInterface newState) {
        this.currStateStateInterface.changingState();
        this.currStateStateInterface = newState;
        this.currStateStateInterface.changedState();
    }

    @Override
    public String toString() {
        return "The state user ";
    }

    public void observeCurrentState() {
        this.currStateStateInterface.currentState();
    }

    public static void main(String[] args) {
        StateUser stateUser = new StateUser();
        stateUser.observeCurrentState();
        stateUser.useOtherState();
        stateUser.observeCurrentState();
        stateUser.useOtherState();
        stateUser.observeCurrentState();

    }

}
