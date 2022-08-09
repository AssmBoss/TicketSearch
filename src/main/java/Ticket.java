public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String takeOff;
    protected String landing;
    protected int flightTime;

    public Ticket(int id, int price, String takeOff, String landing, int flightTime) {
        this.id = id;
        this.price = price;
        this.takeOff = takeOff;
        this.landing = landing;
        this.flightTime = flightTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(String takeOff) {
        this.takeOff = takeOff;
    }

    public String getLanding() {
        return landing;
    }

    public void setLanding(String landing) {
        this.landing = landing;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public int compareTo(Ticket tckt) {
        if (this.price < tckt.price) {
            return -1;
        } else if (this.price > tckt.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
