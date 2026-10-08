package b4hive;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Room extends Observable {

    private RoomState state;
    private int number;

    public Room(int number) {
        this.number = number;
        this.state = RoomManagement.getLivreState();
        this.addObserver(RoomManagement.getInstance());
    }

    public RoomState getState() {
        return state;
    }
    public void setState(RoomState state) {
        this.state = state;
        setChanged();
        notifyObservers();
    }

    public int getNumber() { return number; }

    public boolean liberar() { return state.liberar(this); }
    public boolean ocupar() { return state.ocupar(this); }
    public boolean manutencao() { return state.manutencao(this); }
    public boolean interditar() { return state.interditar(this); }

}
