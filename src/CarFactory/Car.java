package CarFactory;

/**
 * The Car class represents a car object with various properties.
 *
 * @author petitoa
 */
public class Car {
    private String carType;
    private int year;
    private String color;
    private int miles;

    /**
     * Constructs a new Car object with the specified attributes.
     *
     * @param carType The type of the car.
     * @param year    The year the car was manufactured.
     * @param color   The color of the car.
     * @param miles   The number of miles the car has.
     */
    public Car(String carType, int year, String color, int miles) {
        this.carType = carType;
        this.year = year;
        this.color = color;
        this.miles = miles;
    }

    /**
     * Gets the type of the car.
     *
     * @return The car's type.
     */
    public String getCarType() {
        return carType;
    }

    /**
     * Gets the year of the car.
     *
     * @return The car's year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the color of the car.
     *
     * @return The car's color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Gets the miles on the car.
     *
     * @return The car's miles.
     */
    public int getMiles() {
        return miles;
    }


}
