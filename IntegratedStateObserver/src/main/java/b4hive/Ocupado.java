package b4hive;

public class Ocupado extends RoomState {
    @Override 
    public String getStateName() {
        return "Ocupado";
    }
    @Override
    public boolean liberar(Room room) {
        room.setState(RoomManagement.getLivreState());
        return true;
    }
}
