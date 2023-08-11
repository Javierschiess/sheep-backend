package com.prix.enums;

public enum Departamentos {

    ALTA_VERAPAZ, ESCUINTLA;

    public static boolean departamento(String departamento){
        Departamentos [] departamentos = Departamentos.values();
        for (Departamentos dep : departamentos)
            if (dep.name().equals(departamento))
                return true;
        return false;
    }
}
