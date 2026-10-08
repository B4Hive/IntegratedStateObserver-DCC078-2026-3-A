package b4hive;

public class Manutencao extends RoomState {
    @Override 
    public String getStateName() {
        return "Manutencao";
    }
    @Override 
    public boolean liberar(Room room) {
        room.setState(RoomManagement.getLivreState());
        return true;
    }
    @Override 
    public boolean interditar(Room room) {
        room.setState(RoomManagement.getInterditadoState());
        return true;
    }
}
