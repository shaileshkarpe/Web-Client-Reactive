package com.reactiveresttemplate.webclient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest extends PatientResponse {
    private String firstName;
    private String lastName;
}
