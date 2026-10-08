package b4hive;

public abstract class RoomState {
    abstract String getStateName();
    public boolean liberar(Room room) { return false; }
    public boolean ocupar(Room room) { return false; }
    public boolean manutencao(Room room) { return false; }
    public boolean interditar(Room room) { return false; }
}