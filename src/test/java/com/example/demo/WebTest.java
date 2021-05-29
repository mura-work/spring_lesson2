package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.BookController;
import com.example.demo.repository.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest // 毎回テストを行うたびに自動的にサーバを起動してくれる
public class WebTest {
	private MockMvc mockmvc;	// Webサーバに似たような振る舞いをする
	
	@Autowired
	BookController book;	// テストを行うコントローラを定義
	
	@Before
	public void setup() {
		mockmvc = MockMvcBuilders.standaloneSetup(book).build();
	}
	
	@Test
	public void isStatusTest() throws Exception {
		mockmvc.perform(get("/books/new")).andExpect(status().isOk()); // '/books/new'にアクセス可能か
	}
	
	@MockBean
	private BookRepository repository;
	
	@Test
	public void isModelTest() throws Exception {
		// modelにセットされているのかのテスト
//		when(repository.getById(1)).
	}
	
}
