package Lab5;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long addressBookID;


    @OneToMany
    private List<BuddyInfo> myBuddies;


    public AddressBook(){

        this.myBuddies = new ArrayList<>();
    }


    public void addBuddy(BuddyInfo buddy){

        this.myBuddies.add(buddy);

    }

    public void removeBuddy(int i){
        this.myBuddies.remove(i);
    }

    public List<BuddyInfo> getMyBuddies() {
        return myBuddies;
    }

    public long getAddressBookID() {
        return addressBookID;
    }

    public void setAddressBookID(long addressBookID) {
        this.addressBookID = addressBookID;
    }

    public BuddyInfo getBuddy(int i){
        return this.myBuddies.get(i);
    }




    @Override
    public String toString() {
        return "Lab4.AddressBook{" +
                "addressBookID=" + addressBookID +
                ", myBuddies=" + myBuddies +
                '}';
    }


}


