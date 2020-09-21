package com.gf.rest.controllers;

import com.gf.rest.models.dto.GeneralError;
import com.gf.rest.models.entities.ArrayHandler;
import com.gf.rest.models.entities.ArrayHandlerResult;
import com.gf.rest.models.entities.ArrayHandlerResultArray;
import com.gf.rest.models.entities.DoUntil;
import com.gf.rest.models.entities.DoUntilExeption;
import com.gf.rest.models.entities.Log;
import com.gf.rest.models.entities.Sith;
import com.gf.rest.models.entities.SithText;
import com.gf.rest.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  @Autowired
  ExerciseService exerciseService;

  @GetMapping("/")
  public String main() {
    return "index";
  }

  @GetMapping("/doubling")
  @ResponseBody
  public Object doubling(@RequestParam(required = false) String input) {
    if (input == null) {
      return new GeneralError("Please provide an input!");
    }
    exerciseService.saveLogEntry("/doubling", "input=" + input);
    return exerciseService.doubling(input);
  }

//  @GetMapping("/doubling")
//  @ResponseBody
//  public ResponseEntity<?> doubling(@RequestParam(required = false) String input) {
//    if (input == null) {
//      return ResponseEntity.ok().body(new GeneralError("Please provide an input!"));
//    }
//    return ResponseEntity.ok()
//        .body(exerciseService.doubling(input));
//  }

  @GetMapping("/greeter")
  @ResponseBody
  public ResponseEntity<?> greeter(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String title) {
    if (name == null && title == null) {
      return new ResponseEntity<>(new GeneralError("Please provide a name and a title!"),
          HttpStatus.valueOf(400));
    }
    if (name == null) {
      return new ResponseEntity<>(new GeneralError("Please provide a name!"),
          HttpStatus.valueOf(400));
    }
    if (title == null) {
      return new ResponseEntity<>(new GeneralError("Please provide a title!"),
          HttpStatus.valueOf(400));
    }
    return ResponseEntity.ok().body(exerciseService.greet(name, title));
  }

  @GetMapping("/appenda/{appendable}")
  public ResponseEntity<?> appendA(@PathVariable String appendable) {

    return ResponseEntity.ok().body(exerciseService.appendA(appendable));
  }

  @PostMapping("/dountil/{action}")
  public ResponseEntity<?> doUntil(@RequestBody DoUntil doUntil,
                                   @PathVariable String action) {
    try {
      exerciseService.saveLogEntry("/dountil", "input=" + action);
      return ResponseEntity.ok().body(exerciseService.doUntil(doUntil, action));
    } catch (DoUntilExeption doUntilExeption) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new GeneralError("Please provide a number!"));
    }
  }

  @PostMapping("/arrays")
  public ResponseEntity<?> arrayHandler(@RequestBody(required = false) ArrayHandler arrayHandler) {
    try {
      if (arrayHandler.getWhat().equals("sum") || arrayHandler.getWhat().equals("multiply")) {
        return ResponseEntity.ok().body(new ArrayHandlerResult(exerciseService.arrayHandlerResult(arrayHandler)));
      } else if (arrayHandler.getWhat().equals("double")) {
        return ResponseEntity.ok().body(new ArrayHandlerResultArray(exerciseService.arrayHandlerResultArray(arrayHandler)));
      }
    } catch (DoUntilExeption doUntilExeption) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError("Please provide what to do with the numbers!"));
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError("Please provide what to do with the numbers!"));
  }

  @GetMapping("/log")
  public ResponseEntity<Log> logs() {
    return ResponseEntity.ok().body(exerciseService.getLog());
  }

  @PostMapping("/sith")
  public ResponseEntity<SithText> sith(@RequestBody Sith sith) {
    return ResponseEntity.ok().body(exerciseService.sithText(sith));
  }

//  @PostMapping("/translate")
//  public ResponseEntity<TranslatedText> translateText(@RequestBody TranslateText translateText) {
//    String translated = exerciseService.translateText(translateText.getText());
//    return ResponseEntity.ok().body(new TranslatedText(translated, "teve"));
//  }


}
