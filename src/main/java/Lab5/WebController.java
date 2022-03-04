package Lab5;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class WebController {

    private AddressBookRepository addressBookRepository;
    private BuddyInfoRepository buddyInfoRepository;

    @Autowired
    public WebController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("addressBook", new AddressBook());
        return "greeting";
    }

    @RequestMapping(value = "/createAddressBook", method = RequestMethod.POST)
    public String createAddressBook( @ModelAttribute("addressBook") AddressBook addressBook, Model model){ // addressBook is the object we populated and created in /greeting
        addressBookRepository.save(addressBook);
        model.addAttribute("addressBook", addressBook);
        return "display";
    }

    //GET : to get the form
    //POST/DELETE : to submit the form and return result
    //GET: if you want to view something without a form too
    //wHEN YOU post

    @GetMapping("/buddyForm")
    public String buddyForm(Model model, @RequestParam("addressBookID") long ID) {
        model.addAttribute("buddyInfo", new BuddyInfo());
        model.addAttribute("id", ID);
        return "buddyForm";
    }


    @PostMapping("/result/{id}")
    // does it not recognize the addressBook I created??
    public String buddySubmit(@ModelAttribute("buddy") BuddyInfo buddyInfo, @PathVariable("id") long id, Model model) { // buddy is the object that we created a new one in the form and populated it
        // address book is the same one we created in the form above

        Optional<AddressBook> addressBook1 = addressBookRepository.findById(id); // maybe something wrong here
        //System.out.println(addressBook.getAddressBookID());

        if(addressBook1.isPresent()) {
            AddressBook realAddressBook = addressBook1.get();
            realAddressBook.addBuddy(buddyInfo);
            buddyInfoRepository.save(buddyInfo);
            addressBookRepository.save(realAddressBook);
            model.addAttribute("book", realAddressBook);
            model.addAttribute("buddyInfo", buddyInfo);
            return "result";
        }
        else{
            return "error";
        }
    }

    /**

    //@PostMapping("/result")
    public String buddySubmit(@ModelAttribute AddressBook addressBook, Model model) {
        model.addAttribute("addressBook", addressBook);
        return "result";
    }
     */


    @GetMapping("/display") // post modifies database (create add new rename remove) // get finding or displaying // Never save in Get methods
    public String addressBookSubmit(Model model, @RequestParam("bookId") Long id){
        //if (addressBookRepository.findById(id) == null){
          //  addressBookRepository.save(new AddressBook());
        //}
        Optional<AddressBook> addressBook = addressBookRepository.findById(id);
        AddressBook realAddressBook = addressBook.get();
        model.addAttribute("addressBook", realAddressBook);
        return "addressBook";
    }




}
