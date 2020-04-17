package com.greenfoxacademy.basicwebshop.controllers;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

  @GetMapping(value = "/webshop")

  public String shopGreeting(Model model){
model.addAttribute("name", "Hello Andris");
return "thyme";
  }

  private List<Map> shopItems = new List<Map>() {
    @Override
    public int size() {
      return 0;
    }

    @Override
    public boolean isEmpty() {
      return false;
    }

    @Override
    public boolean contains(Object o) {
      return false;
    }

    @Override
    public Iterator<Map> iterator() {
      return null;
    }

    @Override
    public Object[] toArray() {
      return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
      return null;
    }

    @Override
    public boolean add(Map map) {
      return false;
    }

    @Override
    public boolean remove(Object o) {
      return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
      return false;
    }

    @Override
    public boolean addAll(Collection<? extends Map> c) {
      return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Map> c) {
      return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
      return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
      return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Map get(int index) {
      return null;
    }

    @Override
    public Map set(int index, Map element) {
      return null;
    }

    @Override
    public void add(int index, Map element) {

    }

    @Override
    public Map remove(int index) {
      return null;
    }

    @Override
    public int indexOf(Object o) {
      return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
      return 0;
    }

    @Override
    public ListIterator<Map> listIterator() {
      return null;
    }

    @Override
    public ListIterator<Map> listIterator(int index) {
      return null;
    }

    @Override
    public List<Map> subList(int fromIndex, int toIndex) {
      return null;
    }
  };

}
