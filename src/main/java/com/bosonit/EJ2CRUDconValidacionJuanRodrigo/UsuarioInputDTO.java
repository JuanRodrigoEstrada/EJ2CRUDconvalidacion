package com.bosonit.EJ2CRUDconValidacionJuanRodrigo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

    @Data
    public class UsuarioInputDTO implements Serializable {
        private Integer id_persona;
        private String usuario;
        private String password;
        private String name;
        private String surname;
        private String company_email;
        private String personal_email;
        private String city;
        private Boolean active;
        private Date created_date;
        private String imagen_url;
        private Date termination_date;
    }



