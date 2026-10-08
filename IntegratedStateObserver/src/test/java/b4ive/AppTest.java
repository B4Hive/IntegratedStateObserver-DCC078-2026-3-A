package b4ive;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import b4hive.Room;
import b4hive.RoomManagement;

public class AppTest {

    @Test
    public void testRoomShouldStartInLivreState() {
        Room room = new Room(1);
        assertEquals(RoomManagement.getLivreState(), room.getState());
    }

//#region Livre
    @Test 
    public void testRoomShouldNotChangeStateToLivre() {
        Room room = new Room(1);
        assertFalse(room.liberar());
    }

    @Test
    public void testRoomShouldChangeStateToOcupado() {
        Room room = new Room(1);
        room.ocupar();
        assertEquals(RoomManagement.getOcupadoState(), room.getState());
    }

    @Test
    public void testRoomShouldChangeStateToManutencao() {
        Room room = new Room(1);
        room.manutencao();
        assertEquals(RoomManagement.getManutencaoState(), room.getState());
    }

    @Test 
    public void testRoomShouldNotChangeStateToInterditado() {
        Room room = new Room(1);
        assertFalse(room.interditar());
    }
//#endregion Livre

//#region Ocupado
    @Test 
    public void testRoomShouldChangeStateToLivreFromOcupado() {
        Room room = new Room(1);
        room.ocupar();
        room.liberar();
        assertEquals(RoomManagement.getLivreState(), room.getState());
    }

    @Test
    public void testRoomShouldNotChangeStateToOcupadoFromOcupado() {
        Room room = new Room(1);
        room.ocupar();
        assertFalse(room.ocupar());
    }

    @Test 
    public void testRoomShouldNotChangeStateToManutencaoFromOcupado() {
        Room room = new Room(1);
        room.ocupar();
        assertFalse(room.manutencao());
    }

    @Test
    public void testRoomShouldNotChangeStateToInterditadoFromOcupado() {
        Room room = new Room(1);
        room.ocupar();
        assertFalse(room.interditar());
    }
//#endregion Ocupado

//#region Manutencao
    @Test 
    public void testRoomShouldChangeStateToLivreFromManutencao() {
        Room room = new Room(1);
        room.manutencao();
        room.liberar();
        assertEquals(RoomManagement.getLivreState(), room.getState());
    }

    @Test
    public void testRoomShouldNotChangeStateToOcupadoFromManutencao() {
        Room room = new Room(1);
        room.manutencao();
        assertFalse(room.ocupar());
    }

    @Test 
    public void testRoomShouldNotChangeStateToManutencaoFromManutencao() {
        Room room = new Room(1);
        room.manutencao();
        assertFalse(room.manutencao());
    }

    @Test
    public void testRoomShouldChangeStateToInterditadoFromManutencao() {
        Room room = new Room(1);
        room.manutencao();
        room.interditar();
        assertEquals(RoomManagement.getInterditadoState(), room.getState());
    }
//#endregion Manutencao

//#region Interditado
    @Test 
    public void testRoomShouldNotChangeStateToLivreFromInterditado() {
        Room room = new Room(1);
        room.manutencao();
        room.interditar();
        assertFalse(room.liberar());
    }

    @Test
    public void testRoomShouldNotChangeStateToOcupadoFromInterditado() {
        Room room = new Room(1);
        room.manutencao();
        room.interditar();
        assertFalse(room.ocupar());
    }

    @Test 
    public void testRoomShouldNotChangeStateToManutencaoFromInterditado() {
        Room room = new Room(1);
        room.manutencao();
        room.interditar();
        assertFalse(room.manutencao());
    }

    @Test
    public void testRoomShouldNotChangeStateToInterditadoFromInterditado() {
        Room room = new Room(1);
        room.manutencao();
        room.interditar();
        assertFalse(room.interditar());
    }
//#endregion Interditado

//#region RoomManagement
    @Test
    public void testRoomManagementShouldReceiveUpdates() {
        Room room = new Room(1);
        room.ocupar();
        String updates = RoomManagement.getInstance().getLastUpdates();
        assertTrue(updates.contains("Room 1 changed state to Ocupado"));
    }
    @Test 
    public void testRoomManagementShouldReceiveMultipleUpdates() {
        Room room = new Room(1);
        room.ocupar();
        room.liberar();
        String updates = RoomManagement.getInstance().getLastUpdates();
        assertTrue(updates.contains("Room 1 changed state to Ocupado"));
        assertTrue(updates.contains("Room 1 changed state to Livre"));
    }
    @Test
    public void testRoomManagementShouldClearUpdatesAfterGet() {
        Room room = new Room(1);
        room.ocupar();
        String updates = RoomManagement.getInstance().getLastUpdates();
        assertTrue(updates.contains("Room 1 changed state to Ocupado"));
        updates = RoomManagement.getInstance().getLastUpdates();
        assertEquals("", updates);
    }
    @Test 
    public void testRoomManagementShouldReceiveUpdatesFromMultipleRooms() {
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        room1.ocupar();
        room2.manutencao();
        String updates = RoomManagement.getInstance().getLastUpdates();
        assertTrue(updates.contains("Room 1 changed state to Ocupado"));
        assertTrue(updates.contains("Room 2 changed state to Manutencao"));
    }
//#endregion RoomManagement

}