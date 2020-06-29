package com.greenfoxacademy.library.controllers;

import com.greenfoxacademy.library.models.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

  private List<Book> books = new ArrayList<>();

  public BookController() {
    this.books.add(new Book("Cat's Cradle", "Kurt Vonnegut", 1963));
    this.books.add(new Book("Breakfast of Champions", "Kurt Vonnegut", 1973));
    this.books.add(new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1968));
  }


  @RequestMapping(path = "/books", method = RequestMethod.GET)
  public String showBooks(Model model, @RequestParam(name = "author", required = false) String author) {
    List<Book> queriedBooks;
    if (author != null) {
      queriedBooks = filterBooksByAuthor(author);
    } else {
      queriedBooks = books;
    }
    model.addAttribute("booksToList", queriedBooks);
    return "index";
  }

  private List<Book> filterBooksByAuthor(String author) {
    return books.stream()
        .filter(book -> book.getAuthor().equals(author))
        .collect(Collectors.toList());
  }

  @RequestMapping(path = "/books/{id}/details", method = RequestMethod.GET)
  public String getBookById(Model model, @PathVariable(name = "id") Integer id) {
    Book bookFound = null;

    for (Book book : books) {
      if (book.getId() == id) {
        bookFound = book;
      }
    }

    if (bookFound != null) {
      model.addAttribute("book", bookFound);
    } else {
      model.addAttribute("error", "No book found");
    }
    return "details";
  }

  @RequestMapping(path = "/books/add", method = RequestMethod.GET)
  public String addBookForm(Model model, @ModelAttribute(name = "book") Book book) {
    model.addAttribute("book", book);
    return "create";
  }

  @RequestMapping(path = "/books/add", method = RequestMethod.POST)
  public String addBook(@ModelAttribute(name = "book") Book book){
    books.add(book);
    return "redirect:/books";
  }

}
