package b4hive;

public class Livre extends RoomState {
    @Override
    public String getStateName() {
        return "Livre";
    }
    @Override 
    public boolean ocupar(Room room) {
        room.setState(RoomManagement.getOcupadoState());
        return true;
    }
    @Override 
    public boolean manutencao(Room room) {
        room.setState(RoomManagement.getManutencaoState());
        return true;
    }
}