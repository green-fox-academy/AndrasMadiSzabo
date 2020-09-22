package com.gfa.greenbay.dtos;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginResponseDTO implements Serializable {
  private String status;
  private int greenBayDollarsAccount;
  private String token;

}
