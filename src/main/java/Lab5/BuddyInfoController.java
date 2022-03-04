package Lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BuddyInfoController {

    private BuddyInfoRepository buddyInfoRepository;
    private  AddressBookRepository addressBookRepository;

    @Autowired
    public BuddyInfoController(BuddyInfoRepository buddyInfoRepository, AddressBookRepository addressBookRepository) {
        this.buddyInfoRepository = buddyInfoRepository;
        this.addressBookRepository = addressBookRepository;
    }

    // i DON'T HAVE A METHOD THAT CREATES A NEW BODY

    @RequestMapping(value = "/buddy", method = RequestMethod.GET)
    public BuddyInfo getBuddy(@RequestParam("bookId") Long id, @RequestParam("buddyId") Integer buddyId){
        Optional<AddressBook> addressBook = addressBookRepository.findById(id);
        AddressBook realAddressBook = addressBook.get();
        return realAddressBook.getBuddy(buddyId);
    }

    @RequestMapping(value = "/buddy", method = RequestMethod.POST)
    public BuddyInfo addBuddy(@RequestBody() BuddyInfo buddyInfo, @RequestParam("bookId") Long id){
        Optional<AddressBook> addressBook = addressBookRepository.findById(id);
        AddressBook realAddressBook = addressBook.get();
        realAddressBook.addBuddy(buddyInfo);
        buddyInfoRepository.save(buddyInfo);
        addressBookRepository.save(realAddressBook);
        return buddyInfo;
    }

    @RequestMapping(value = "/buddy", method = RequestMethod.DELETE)
    public BuddyInfo removeBuddy(@RequestParam("bookId") Long id, @RequestParam("buddyId") Integer buddyId){
        Optional<AddressBook> addressBook = addressBookRepository.findById(id);
        AddressBook realAddressBook = addressBook.get();
        BuddyInfo buddyInfo = realAddressBook.getBuddy(buddyId);
        realAddressBook.removeBuddy(buddyId);
        addressBookRepository.save(realAddressBook);
        buddyInfoRepository.delete(buddyInfo);
        return buddyInfo;
    }
}
