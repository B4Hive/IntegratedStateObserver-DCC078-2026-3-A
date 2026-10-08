package b4hive;

import java.util.Observer;

@SuppressWarnings("deprecation")
public class RoomManagement implements Observer {
    private static RoomManagement instance = new RoomManagement();
    private RoomManagement() {}
    public static RoomManagement getInstance() {
        return instance;
    }

    private String lastUpdates = "";
    @Override
    public void update(java.util.Observable o, Object arg) {
        Room room;
        try{
            room = (Room) o;
        } catch (ClassCastException e) {
            return;
        }
        lastUpdates += "RoomManagement: Room " + room.getNumber() + " changed state to " + room.getState().getStateName() + "\n";
    }

    public void clearLastUpdates() {
        lastUpdates = "";
    }
    public String getLastUpdates() {
        String updates = lastUpdates;
        clearLastUpdates();
        return updates;
    }

    //#region States
    private Livre livreState;
    public static Livre getLivreState() {
        if (instance.livreState == null) instance.livreState = new Livre();
        return instance.livreState;
    }
    private Ocupado ocupadoState;
    public static Ocupado getOcupadoState() {
        if (instance.ocupadoState == null) instance.ocupadoState = new Ocupado();
        return instance.ocupadoState;
    }
    private Manutencao manutencaoState;
    public static Manutencao getManutencaoState() {
        if (instance.manutencaoState == null) instance.manutencaoState = new Manutencao();
        return instance.manutencaoState;
    }
    private Interditado interditadoState;
    public static Interditado getInterditadoState() {
        if (instance.interditadoState == null) instance.interditadoState = new Interditado();
        return instance.interditadoState;
    }
    //#endregion States
}
