package com.personapp.personapi.dtos.request;


import com.personapp.personapi.entity.Phone;
import com.personapp.personapi.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Long id;
    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;
    @CPF
    @NotEmpty
    private String cpf;
    private LocalDate birthDate;
    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;


}
