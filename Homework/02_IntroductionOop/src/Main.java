public class Main {
    public static void main(String[] args) {

        Radio[] radios = new Radio[]{
                new Radio(),
                new Radio(true, 0.7f, "190"),
                new Radio(false, 0.2f)
        };

        House house = new House(radios);

        house.getRadios()[1].volumeUp();
        house.getRadios()[1].setFrequency("102.8");
        house.getRadios()[1].volumeUp();
        house.getRadios()[1].volumeUp();

        System.out.println(house.getRadios()[1]);
    }
}
