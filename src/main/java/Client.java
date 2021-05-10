import java.util.Objects;

public class Client {
    private int id;
    private int nif;
    private String name;
    private String surname;
    private int cp;

    public Client(int id, int nif, String name, String surname, int cp) {
        this.id = id;
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.cp = cp;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && nif == client.nif && cp == client.cp && Objects.equals(name, client.name) && Objects.equals(surname, client.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nif, name, surname, cp);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nif=" + nif +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cp=" + cp +
                '}';
    }
}
