package programutvikling.datakomponentregister;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CPURegister implements Serializable {
    private static final long serialVersionUID = 1;

    private static transient ObservableList<CPU> pregister = FXCollections.observableArrayList();

    public List<CPU> getRegister() {
        return pregister;
    }

    public static void addCPU(CPU p) {
        pregister.add(p);
    }

    public void removeAll() {
        pregister.clear();
    }

    public static void attachTableView(TableView tv) {
        tv.setItems(pregister);
    }

    public CPU searchRegisterByName(String name) {
        Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);

        for(CPU p : pregister) {
            Matcher matcher = pattern.matcher(p.getCpu());

            if(matcher.find()) {
                return p;
            }
        }

        // Hvis vi kommer hit betyr det at vi ikke fant noen personer
        return null;
    }

    public ObservableList<CPU> filterByName(String name) {
        return pregister.stream().
                filter(p -> p.getCpu().toLowerCase().
                        matches(String.format("%s%s%s",".*", name.toLowerCase(), ".*"))).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
/**
    public ObservableList<CPU> filterByAge(int age) {
        return pregister.stream().
                filter(p -> p.getAge() == age).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<Person> filterByEmail(String email) {
        return pregister.stream().
                filter(p -> p.getEmail().
                        matches(String.format("%s%s%s",".*", email, ".*"))).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<Person> filterByPhone(String phone) {
        return pregister.stream().
                filter(p -> p.getPhone().
                        matches(String.format("%s%s%s",".*", phone, ".*"))).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
 **/

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(CPU p : pregister) {
            sb.append(p.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeObject(new ArrayList<>(pregister));
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        List<CPU> list = (List<CPU>) s.readObject();
        pregister = FXCollections.observableArrayList();
        pregister.addAll(list);
    }
}
