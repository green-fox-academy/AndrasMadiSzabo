package com.gf.rest.services;

import com.gf.rest.models.entities.AppendA;
import com.gf.rest.models.entities.ArrayHandler;
import com.gf.rest.models.entities.DoUntil;
import com.gf.rest.models.entities.DoUntilExeption;
import com.gf.rest.models.entities.DoUntilResult;
import com.gf.rest.models.entities.DoublingResult;
import com.gf.rest.models.entities.Greeter;
import com.gf.rest.models.entities.Log;
import com.gf.rest.models.entities.LogEntry;
import com.gf.rest.models.entities.Sith;
import com.gf.rest.models.entities.SithText;
import com.gf.rest.repositories.LogEntryRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor

@Service
public class ExerciseService {

  LogEntryRepository logEntryRepository;

  @Autowired
  public ExerciseService(LogEntryRepository logEntryRepository) {
    this.logEntryRepository = logEntryRepository;
  }

  ///////////////////////////////////////////////////////////////////////////
  public DoublingResult doubling(String input) {
    int received = Integer.parseInt(input);
    int result = received * 2;
    return new DoublingResult(received, result);
  }

  ///////////////////////////////////////////////////////////////////////////
  public Greeter greet(String name, String title) {
    return new Greeter("Oh, hi there " + name + ", my dear " + title + "!");
  }

  ///////////////////////////////////////////////////////////////////////////
  public AppendA appendA(String text) {
    return new AppendA(text + "a");
  }

  ///////////////////////////////////////////////////////////////////////////
  public DoUntilResult doUntil(DoUntil doUntil, String action) throws DoUntilExeption {
    if (action.equals("sum")) {
      int result = 0;
      for (int i = 1; i <= doUntil.getUntil(); i++) {
        result += i;
      }
      return new DoUntilResult(result);
    } else if (action.equals("factor")) {
      int result = 1;
      for (int i = 1; i <= doUntil.getUntil(); i++) {
        result *= i;
      }
      return new DoUntilResult(result);
    } else {
      throw new DoUntilExeption();
    }
  }

  ///////////////////////////////////////////////////////////////////////////
  public int arrayHandlerResult(ArrayHandler arrayHandler) throws DoUntilExeption {
    if (arrayHandler.getWhat().equals("sum")) {
      int result = 0;
      for (int i = 0; i < arrayHandler.getNumbers().length; i++) {
        result += arrayHandler.getNumbers()[i];
      }
      return result;
    } else if (arrayHandler.getWhat().equals("multiply")) {
      int result = 1;
      for (int i = 0; i < arrayHandler.getNumbers().length; i++) {
        result *= arrayHandler.getNumbers()[i];
      }
      return result;
    } else {
      throw new DoUntilExeption();
    }

  }

  public int[] arrayHandlerResultArray(ArrayHandler arrayHandler) throws DoUntilExeption {
    if (arrayHandler.getWhat().equals("double")) {
      int[] result = new int[arrayHandler.getNumbers().length];
      for (int i = 0; i < arrayHandler.getNumbers().length; i++) {
        result[i] = arrayHandler.getNumbers()[i] * 2;
      }
      return result;
    } else {
      throw new DoUntilExeption();
    }
  }

  ///////////////////////////////////////////////////////////////////////////
  public void saveLogEntry(String endpoint, String data) {
    LogEntry logEntry = new LogEntry(endpoint, data);
    logEntryRepository.save(logEntry);
  }

  public Log getLog() {
    return new Log(logEntryRepository.findAllByIdGreaterThanEqual(1), logEntryRepository.countLogEntriesByIdGreaterThan(1));
  }


  ///////////////////////////////////////////////////////////////////////////

  //  public Sith sith(Sith sith){
//    String text = sith.getText();
//    StringBuilder sithText = new StringBuilder();
//    String[] sentences = text.split(".");
//    for (int i = 0; i < sentences.length; i++) {
//      String[] words = sentences[i].split(" ");
//      for (int j = 0; j < words.length/2; j+=2) {
//        String tempword = words[j];
//        words[j]=words[j+1];
//        if (j==0){
//          words[j]=words[j].substring(0, 1).toUpperCase() + words[j].substring(1);
//        }
//        sithText.append(words[j]);
//        words[j+1]=tempword;
//        if (j+1==1){
//          words[j+1]=words[j+1].substring(0, 1).toLowerCase() + words[j+1].substring(1);
//        }
//        sithText.append(words[j + 1]);
//      }
//      sithText.append(". ");
//    }
//    sith.setSith_text(sithText.toString());
//    return sith;
//  }
  public SithText sithText(Sith sith) {
    Random random = new Random();
    List<String> randomSentences = Arrays.asList("Arrgh.", "Uhmm.", "Err..err.err.");
    String text = sith.getText();
    StringBuilder sithText = new StringBuilder();
    List<String> sentences = Arrays.asList(text.split("\\."));

    for (int i = 0; i < sentences.size(); i++) {
      sentences.set(i, sentences.get(i).trim());
      List<String> words = Arrays.asList(sentences.get(i).split(" "));

      ///////////////////////////////// ????????????????????
      words.set(0, words.get(0).substring(0, 1).toUpperCase() + words.get(0).substring(1));
      words.set(1, words.get(1).substring(0, 1).toLowerCase() + words.get(1).substring(1));
      ///////////////////////////////// ????????????????????

      for (int j = 0; j < words.size() - 1; j += 2) {
        String tempword = words.get(j);
        words.set(j, words.get(j + 1));
        sithText.append(words.get(j)).append(" ");
        words.set(j + 1, tempword);
        sithText.append(words.get(j + 1)).append(" ");
      }

      if (words.size() % 2 != 0) {
        sithText.append(words.get(words.size() - 1));
      }

      if (i == sentences.size() - 1) {
        sithText.append(".");
      } else {
        sithText.append(". ");
      }

      if (i == sentences.size() - 1) {
        sithText.append(" ").append(randomSentences.get(random.nextInt(3)));
      } else {
        sithText.append(randomSentences.get(random.nextInt(3))).append(" ");
      }

    }

    return new SithText(sithText.toString());
  }

  public String sithMethod() {
    StringBuilder sithText = new StringBuilder();
    String text = "This is my example sentence. Just for fun.";
    List<String> sentences = Arrays.asList(text.split("\\."));

    String otput = "";
    for (int i = 0; i < sentences.size(); i++) {
      List<String> words = Arrays.asList(sentences.get(i).split(" "));
      for (int j = 0; j < words.size(); j++) {
        if (j == words.size() - 1) {
          otput = otput + words.get(j);
        } else {
          otput = otput + words.get(j) + " ";
        }

      }
      otput = otput + ".";
    }
    return otput;
//    return sentences.get(0) + "." + sentences.get(1) + ".";
  }

//  public String sithCaseSwapMethod(List<String> words) {
//
//  }

  ///////////////////////////////////////////////////////////////////////////
//  public String translateText(String translateText) {
//    List<Character> vowels = Arrays.asList('a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'ö', 'ő', 'u', 'ú', 'ü', 'ű');
//    String translatedText = "";
//    char[] translateTextCharacters = translateText.toCharArray();
//    if (vowels.contains())
//
//    return null;
//  }


}

//    for (int i = 0; i < t.length; i++) {
//    switch (t[i]) {
//    case 'a':
//    t[i] = t[i] +
//    }
//    }