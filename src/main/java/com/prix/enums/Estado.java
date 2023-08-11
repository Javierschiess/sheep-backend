package com.prix.enums;

public enum Estado {

    NUEVO, USADO;

    public static boolean estado(String nombreEstado) {
        Estado[] estados = Estado.values();
        for (Estado estado : estados)
            if (estado.name().equals(nombreEstado))
                return true;
        return false;
    }
}
