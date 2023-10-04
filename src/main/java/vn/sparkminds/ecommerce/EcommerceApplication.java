package vn.sparkminds.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import vn.sparkminds.ecommerce.entities.Inventory;
import vn.sparkminds.ecommerce.repositories.InventoryRepository;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
//    @Async
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphone13");
            inventory.setQuantity(3);


            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("iphone14");
            inventory1.setQuantity(2);

            Inventory inventory2 = new Inventory();
            inventory2.setSkuCode("iphone15");
            inventory2.setQuantity(0);
            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory2);
        };
    }


}
