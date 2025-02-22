import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
       // task1();
        example2();
    }

    private static void example1() {
        ArrayList<Bus> buses = new ArrayList<>();
        buses.add(new Bus(1111));
        buses.add(new Bus(2222));

        Passenger p1 = new Passenger("Иванов", 50, 79);

        buses.get(0).load(p1);
        buses.get(1).load(p1);   //продублировали ссылку

    }

    private static void example2() {
        ArrayList<Bus> buses = new ArrayList<>();
        buses.add(new Bus(1111));
        buses.add(new Bus(2222));

        SmartPassenger sp = new SmartPassenger("Пупкин", 50, 90);

        sp.stepInto(buses.get(0));
        sp.stepInto(buses.get(1));
        System.out.println(buses);
        //пересадка:
        //sp.stepOut();
        //sp.stepInto(buses.get(1));
        sp.transitTo(buses.get(1));
        System.out.println(buses);

    }

    private static void task1() {
        ArrayList<Bus> buses = new ArrayList<>();
        buses.add(new Bus(1111));
        buses.add(new Bus(2222));

        buses.get(0).load(new Passenger("Вася", 22, 62));
        buses.get(0).load(new Passenger("Петя", 23, 50.5));
        buses.get(0).load(new Passenger("Алина", 19, 50));

        buses.get(1).load(new Passenger("Наташа", 24, 80));
        buses.get(1).load(new Passenger("Катя", 29, 47.4));
        buses.get(1).load(new Passenger("Юля", 46, 71.5));
        buses.get(1).load(new Passenger("Семен", 71, 59));

        buses.add(new Bus(3333));

        buses.sort(Comparator.comparingDouble(Bus::getTotalWeight));
//        System.out.println(buses);
        for (Bus b: buses ) {
            System.out.println(b);
            System.out.println(b.getTotalWeight());
        }

        System.out.println("-----------------------------");
        buses.sort(Comparator.comparingDouble(Bus::countMedianeWeightOfPas));
        for (Bus b: buses ) {
            System.out.println(b);
            System.out.println(b.countMedianeWeightOfPas());
        }
    }
}