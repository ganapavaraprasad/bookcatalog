package com.book.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.book.model.Books;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BookcatalogServiceApplication.class)
@WebAppConfiguration
public abstract class BookcatalogApplicationTests {
   protected MockMvc mvc;
   @Autowired
   WebApplicationContext webApplicationContext;

   protected void setUp() {
      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
   }
   protected String mapToJson(Object obj) throws JsonProcessingException {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.writeValueAsString(obj);
   }
   protected <T> T mapFromJson(String json, Class<T> clazz)
      throws JsonParseException, JsonMappingException, IOException {
      
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.readValue(json, clazz);
   }


@Test
public void createBook() throws Exception {
   String uri = "/books";
   Books book = new Boooks();
   
   book.setAuthor("varaprasad");
   book.setISBN(54345);
   book.setPublicationDate(02/07/2021);
   book.setTitle("java");
   
   String inputJson = super.mapToJson(book);
   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
   
   int status = mvcResult.getResponse().getStatus();
   assertEquals(201, status);
   String content = mvcResult.getResponse().getContentAsString();
   assertEquals(content, "books is created successfully");
}


@Test
public void updateBooktest() throws Exception {
   String uri = "/books";
   Books book1 = new Books();
   book1.setAuthor("vara");
   book1.setISBN(654565);
   book1.setPublicationDate(null);
   book1.setTitle("mysqlbook");
   
   String inputJson = super.mapToJson(book1);
   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
   
   int status = mvcResult.getResponse().getStatus();
   assertEquals(200, status);
   String content = mvcResult.getResponse().getContentAsString();
   assertEquals(content, "book is updated successsfully");
}


@Test
public void deleteBook() throws Exception {
   String uri = "/book/54345";
   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
   int status = mvcResult.getResponse().getStatus();
   assertEquals(200, status);
   String content = mvcResult.getResponse().getContentAsString();
   assertEquals(content, "book is deleted successsfully");
}


@Test
public void getProductsList() throws Exception {
   String uri = "/books";
   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
   
   int status = mvcResult.getResponse().getStatus();
   assertEquals(200, status);
   String content = mvcResult.getResponse().getContentAsString();
   Books[] productlist = super.mapFromJson(content, Books[].class);
   assertTrue(productlist.length > 0);
   
   
   
}
}