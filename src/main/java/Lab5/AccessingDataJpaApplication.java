package Lab5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    /**

    @Bean
    public CommandLineRunner demo(AddressBookRepository addressBookRep, BuddyInfoRepository buddyInfoRep){
        return(args)->{

            BuddyInfo buddy1 = new BuddyInfo("Sam","61372902");
            BuddyInfo buddy2 = new BuddyInfo("Ruby","61373972");
            BuddyInfo buddy3 = new BuddyInfo("Dan","613487329");
            BuddyInfo buddy4 = new BuddyInfo("Ahmed","61390387");

            AddressBook addressBook = new AddressBook();
            addressBook.addBuddy(buddy1);
            addressBook.addBuddy(buddy2);
            addressBook.addBuddy(buddy3);
            addressBook.addBuddy(buddy4);

            buddyInfoRep.save(buddy1);
            buddyInfoRep.save(buddy2);
            buddyInfoRep.save(buddy3);
            buddyInfoRep.save(buddy4);



            addressBookRep.save(addressBook);


        };


    }
    */
}
