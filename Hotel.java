package ua.lviv.iot.algo.part1.lab1;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Hotel {
    private String name;
    private int totalRooms;
    private int availableRooms;
    private int rating;
    private int bookedRoomsCount = 0;
    private static Hotel defaultHotel = new Hotel();

    public Hotel(String name, int totalRooms, int rating) {
        this.name = name;
        this.totalRooms = totalRooms;
        this.availableRooms = totalRooms;
        this.rating = rating;
    }

    public void bookRoom() {
        if (availableRooms > 0) {
            availableRooms--;
            bookedRoomsCount++;
            System.out.println("Your number is ready");
        } else {
            System.out.println("All numbers are busy");
        }
    }

    public void releaseRoom() {
        if (bookedRoomsCount > 0) {
            availableRooms++;
            bookedRoomsCount--;
        } else {
            System.out.println("All rooms are free");
        }
    }
    public static Hotel getInstance() {
        return defaultHotel;
    }

    @Override
    public String toString() {
        return "Hotel{" + "name=" + name + '\'' + ", totalRooms='" + totalRooms + '\'' + ", rating=" + rating + '\'' + '}';
    }

    public static void main(String[] args) {
        System.out.println("Welcome to our hotel!");
        Hotel hotel = new Hotel("Eurohotel", 50, 4);
        System.out.println("Free rooms:" + hotel.getAvailableRooms());
        System.out.println("Booked rooms:" + hotel.getBookedRoomsCount());
        hotel.bookRoom();
        hotel.bookRoom();
        hotel.releaseRoom();
        System.out.println("Free rooms:" + hotel.getAvailableRooms());
        System.out.println("Booked rooms:" + hotel.getBookedRoomsCount());
        //////////////////////////////////////////////////////////////////
        Hotel[] hotels = new Hotel[4];
        hotels[0] = new Hotel();
        hotels[1] = new Hotel("Eurohotel", 50, 4);
        hotels[2] = Hotel.getInstance();
        hotels[3] = Hotel.getInstance();

        for (Hotel h : hotels) {
            System.out.println(h.toString());
        }
    }
}