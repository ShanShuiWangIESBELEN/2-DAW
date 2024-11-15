package org.iesbelen.dto;

import org.iesbelen.model.Departamento;

public class DepartamentoDTO extends Departamento {

    private Integer countEmpleados;

    public int getCountEmpleados() {
        return countEmpleados;
    }

    public void setCountEmpleados(int countEmpleados) {
        this.countEmpleados = countEmpleados;
    }
}
