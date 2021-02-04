package home.production.msscbreweryclient.client;

import home.production.msscbreweryclient.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

  @Autowired
  BreweryClient client;

  @Test
  void getBeerById() {
    BeerDto beerDto = client.getBeerById(UUID.randomUUID());

    assertNotNull(beerDto);
  }

  @Test
  void saveNewBeer() {
    BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

    URI uri = client.saveNewBeer(beerDto);

    assertNotNull(uri);
  }

  @Test
  void updateBeer() {
    BeerDto beerDto = BeerDto.builder().beerName("New beer").build();

    client.updateBeer(UUID.randomUUID(), beerDto);
  }

  @Test
  void deleteBeer() {
    client.deleteBeer(UUID.randomUUID());
  }

}