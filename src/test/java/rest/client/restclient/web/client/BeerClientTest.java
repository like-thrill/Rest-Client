package rest.client.restclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rest.client.restclient.web.model.BeerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientTest {


    @Autowired
    BeerClient beerClient;
    @Test
    void getBeerById() {
        BeerDto beerDto = beerClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer(){
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).build();
       URI uri = beerClient.saveNewBeer(beerDto);
       assertNotNull(uri);
       System.out.println(uri.toString());
    }

    @Test
    void updateBeer(){
        BeerDto beerDto = BeerDto.builder().build();
        beerClient.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void deleteBeer(){
        beerClient.deleteBeer(UUID.randomUUID());
    }
}