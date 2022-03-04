package Lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AddressBookController {
    private AddressBookRepository addressBookRepository;


    @Autowired
    public AddressBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @RequestMapping(value = "/addressBook", method = RequestMethod.POST)
    public AddressBook createAddressBook(){
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);
        return addressBook;
    }



    @RequestMapping(value = "/addressBook", method = RequestMethod.GET)
    public Optional<AddressBook> getAddressBook(@RequestParam("id") Long id){
        return addressBookRepository.findById(id);
    }
}
