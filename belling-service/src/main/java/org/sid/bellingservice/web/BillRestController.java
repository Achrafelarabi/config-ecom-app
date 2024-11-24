package org.sid.bellingservice.web;

import org.sid.bellingservice.entities.Bill;
import org.sid.bellingservice.repository.BillRepository;
import org.sid.bellingservice.repository.ProductItemRepository;
import org.sid.bellingservice.services.CustomerRestClient;
import org.sid.bellingservice.services.ProductRsetClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRsetClient productRsetClient;
  @GetMapping("/fullBill/{id}")
    public Bill bill(@PathVariable Long id) {
      Bill bill=billRepository.findById(id).get();
      bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
      bill.getProductItems().forEach(pi->{
          pi.setProduct(productRsetClient.findProductById(pi.getProductId()));
      });
       return bill;
    }
}
