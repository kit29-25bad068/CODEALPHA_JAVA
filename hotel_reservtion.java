public class Room {
    int roomNo;
    String type;
    double price;
    boolean isAvailable;

    public Room(int roomNo, String type, double price, boolean isAvailable) {
        this.roomNo = roomNo;
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getRoomNo() {
        return roomNo;
    }
    public String getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
public class Reservation {
    String guestName;
    Room room;
    String checkIn;
    String checkOut;
    public Reservation(String guestName, Room room, String checkIn, String checkOut){
        this.guestName = guestName;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;  
    }
    public String getGuestName() {
        return guestName;
    }
    public Room getRoom() {
        return room;
    }
    public String getCheckIn() {
        return checkIn;
    }
    public String getCheckOut() {
        return checkOut;
    }
    
}
import java.util.*;
public class Hotel {
    ArrayList<Room> rooms;
    ArrayList<Reservation> reservations;
    public Hotel(){
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }
    public void addRoom(Room room){
        rooms.add(room);
    }
    public void getAvailableRooms(){
        System.out.println("Available Rooms:");
        for(Room r : rooms){
            if(r.isAvailable()){
                System.out.println("Room No: " + r.getRoomNo() + ", Type: " + r.getType() + ", Price: $" + r.getPrice());
            }
        }
    }
    public void showRoomStatus(){
        System.out.println("\n--- Room Status ---");
        for(Room r : rooms){
            if(r.isAvailable()){
                System.out.println("Room No: " + r.getRoomNo() + " | Type: " + r.getType() + " | Price: $" + r.getPrice() + " | Status: AVAILABLE");
            } else {
                for(Reservation res : reservations){
                    if(res.getRoom().getRoomNo() == r.getRoomNo()){
                        System.out.println("Room No: " + r.getRoomNo() + " | Type: " + r.getType() + " | Price: $" + r.getPrice() + " | Status: BOOKED (" + res.getCheckIn() + " to " + res.getCheckOut() + ")");
                    }
                }
            }
        } 
    }
    public void bookRoom(String guestName, int roomNo, String checkIn, String checkOut){
        for(Room r : rooms){
            if(r.getRoomNo() == roomNo && r.isAvailable()){
                r.setAvailable(false);
                Reservation res = new Reservation(guestName, r, checkIn, checkOut);
                reservations.add(res);
                System.out.println("Room " + roomNo + " booked successfully for " + guestName + " from " + checkIn + " to " + checkOut);
                return;
            }
        }
        System.out.println("Sorry, Room " + roomNo + " is not available.");
    }
    public void cancelReservation(String guestName, int roomNo){
        Iterator<Reservation> it = reservations.iterator();
        while(it.hasNext()){
            Reservation res = it.next();
            if(res.getGuestName().equalsIgnoreCase(guestName) && res.getRoom().getRoomNo() == roomNo){
                res.getRoom().setAvailable(true);
                it.remove(); 
                System.out.println("Reservation cancelled successfully!");
                return;
            }
        }
        System.out.println("No reservation found for " + guestName + " in Room " + roomNo);
    }
    public void viewReservations(String guestName){
        System.out.println("Current Reservations:");
        for(Reservation res : reservations){
            if(res.getGuestName().equalsIgnoreCase(guestName)){
                System.out.println("Guest: " + res.getGuestName() + ", Room No: " + res.getRoom().getRoomNo() + ", Check-In: " + res.getCheckIn() + ", Check-Out: " + res.getCheckOut());
            }
        }
    }
    public void viewAllReservations(){
        System.out.println("All Reservations:");
        for(Reservation res : reservations){
            System.out.println("Guest: " + res.getGuestName() + ", Room No: " + res.getRoom().getRoomNo() + ", Check-In: " + res.getCheckIn() + ", Check-Out: " + res.getCheckOut());
        }
    }
}
import java.util.*;
public class Hotel_main {
    public static void main(String[] args){
        Hotel hotel = new Hotel();
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("\nWelcome to the Hotel Management System!");
            System.out.println("1. Add Room");
            System.out.println("2. View Available Rooms");
            System.out.println("3. Book Room");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. View My Reservations");
            System.out.println("6. View All Reservations");
            System.out.println("7. Exit");
            int choice = s.nextInt();
            s.nextLine();
            switch(choice){
                case 1:
                    System.out.print("Enter Room No: ");
                    int roomNo = s.nextInt();
                    s.nextLine();
                    System.out.print("Enter Room Type(Suite, Delux, Standard): ");
                    String type = s.nextLine();
                    System.out.print("Enter Room Price: ");
                    double price = s.nextDouble();
                    s.nextLine();
                    hotel.addRoom(new Room(roomNo, type, price, true));
                    break;
                case 2:
                    hotel.getAvailableRooms();
                    break;
                case 3:
                    hotel.showRoomStatus();
                    System.out.print("Enter Guest Name: ");
                    String guestName = s.nextLine();
                    System.out.print("Enter Room No to Book: ");
                    int bookRoomNo = s.nextInt();
                    s.nextLine();
                    System.out.print("Enter Check-In Date (YYYY-MM-DD): ");
                    String checkIn = s.nextLine();
                    System.out.print("Enter Check-Out Date (YYYY-MM-DD): ");
                    String checkOut = s.nextLine();
                    hotel.bookRoom(guestName, bookRoomNo, checkIn, checkOut);
                    break;
                case 4:
                    System.out.print("Enter Guest Name: ");
                    String cancelGuestName = s.nextLine();
                    System.out.print("Enter Room No to Cancel: ");
                    int cancelRoomNo = s.nextInt();
                    s.nextLine();
                    hotel.cancelReservation(cancelGuestName, cancelRoomNo);
                    break;
                case 5:
                    System.out.print("Enter Guest Name: ");
                    String viewGuestName = s.nextLine();
                    hotel.viewReservations(viewGuestName);
                    break;
                case 6:
                    hotel.viewAllReservations();
                    break;
                case 7:
                    System.out.println("Thank you for using the Hotel Management System! Goodbye!");
                    s.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
