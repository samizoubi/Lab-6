package Lab5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

@Entity(name = "Lab4.BuddyInfo")
public class BuddyInfo {

    private String phoneNumber = null;

    @Id
    @GeneratedValue
    private long ID;

    private String name = null;



    public BuddyInfo() {
    }

    public BuddyInfo(String name, String phoneNumber){

        this.phoneNumber = phoneNumber;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Lab4.BuddyInfo{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuddyInfo buddyInfo = (BuddyInfo) o;
        return name != null && Objects.equals(name, buddyInfo.name);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
