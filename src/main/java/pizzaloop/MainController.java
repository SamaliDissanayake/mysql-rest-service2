package pizzaloop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private PizzaRepository pizzaRepository;
    private static final String SUCCESS= "Saved";


    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private paymentRepository paymentRepositoryy;
    @Autowired
    private  OrderRepository orderRepository;



    //URI to access this: http://localhost:8080/demo/all

    @GetMapping(path="/all")
    public @ResponseBody Iterable<PizzaDetails> getPizzaDetails() {
        return pizzaRepository.findAll();
    }


    @GetMapping(path="/findByPizzaId")
    public @ResponseBody List<PizzaDetails> getPizzaById(@RequestParam Integer id) {
        return pizzaRepository.findByPizzaId(id);
    }


    // URI to access this: http://localhost:8080/demo/add?name=VegiPizza&description=VegiSupreme&price=2500.75

    @GetMapping(path="/add")
    public @ResponseBody String addNewPizza(@RequestParam String name, @RequestParam String description, @RequestParam Double price) {
        PizzaDetails pizzaDetails = new PizzaDetails();
        pizzaDetails.setName(name);
        pizzaDetails.setDescription(description);
        pizzaDetails.setPrice(price);
        pizzaRepository.save(pizzaDetails);
        return SUCCESS;
    }
    @GetMapping(path="/addorder")//http://localhost:8080/demo/addorder?name=sadfda&quantity=1&price=1500
    public @ResponseBody String addNewOrder(@RequestParam String name,@RequestParam Integer quantity,@RequestParam Double price) {
       OrderDetails orderDetails=new OrderDetails();
       orderDetails.setName(name);
       orderDetails.setQuantity(quantity);
       orderDetails.setPrice(price);
       orderRepository.save(orderDetails);
       return  SUCCESS;
    }

    @GetMapping(path="/adduser")//http://localhost:8080/demo/adduser?name=samali&usName=sam123&password=1234
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String usName, @RequestParam String password) {
       UserDetails userDetails = new UserDetails();
       userDetails.setName(name);
       userDetails.setUsName(usName);
       userDetails.setPassword(password);
       userRepository.save(userDetails);
        return SUCCESS;
    }

    @GetMapping(path="/addpayment")
    public @ResponseBody String addNewpayment(@RequestParam String Experid_Date,@RequestParam String card_number) {
     paymentDetails paymentDetailss=new paymentDetails();
     paymentDetailss.setCard_number(card_number);
     paymentDetailss.setExperid_Date(Experid_Date);
     //paymentRepositoryy.save(paymentDetailss);
    return  SUCCESS;
    }


    @GetMapping(path="/deleteByPizzaId")
    public @ResponseBody List<PizzaDetails> deletePizzaById(@RequestParam Integer id) {
        return pizzaRepository.deleteByPizzaId(id);
    }


    @GetMapping(path="/update")
    public @ResponseBody List<PizzaDetails> updatePizzaDetails(@RequestParam Integer id, @RequestParam String name, @RequestParam String description, @RequestParam Double price) {

        List<PizzaDetails> pizzaDetailsList = pizzaRepository.findByPizzaId(id);
        if(!pizzaDetailsList.isEmpty()) {

            for(PizzaDetails pizzaDetails: pizzaDetailsList) {

                pizzaDetails.setName(name);
                pizzaDetails.setDescription(description);
                pizzaDetails.setPrice(price);

                pizzaRepository.save(pizzaDetails);
            }
        }
        return pizzaRepository.findByPizzaId(id);
    }
}
