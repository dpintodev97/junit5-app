package com.dpintodev.junit5app.ejemplos.models;

import java.math.BigDecimal;

public class Cuenta {
    private String persona;
    private BigDecimal saldo;

    //CONSTRUCTOR DE Cuenta Y LE PASAMOS persona y saldo:
    public Cuenta(String persona, BigDecimal saldo) {
        this.saldo = saldo;
        this.persona = persona;
    }

    //GETTERS AND SETTERS:
    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    /**
     * Sobrescribir MET.equals (para la comparación por valor de atributos (persona,saldo) en Test):
     * @param obj --> objeto con el cual comparamos, lo CASTEAMOS a tipo Cuenta
     * Condicion atributos: validar que persona y (OR ||) saldo sea distinto null y luego comparar con equals
     * @return saldo AND (&&) persona deben SÍ o SÍ ser true
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Cuenta)){
            return false;
        }
        Cuenta c = (Cuenta) obj;
        //además, con el IF, si este obj pasado por ref.en el metodo, sea instancia de Cuenta, no solo que sea null

        //Comparar atributos de la clase, asegurandonos que no sea null
        if(this.persona == null || this.saldo == null){
                return false;
        }
        return this.persona.equals(c.getPersona()) && this.saldo.equals(c.getSaldo());
    }


}
