/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class CuentaCorriente extends Cuenta {

    private double cupoSobregiro;

    public CuentaCorriente(String numero, String dueno, Fecha fechaApertura, double cupoSobregiro) {
        super(numero, dueno, fechaApertura);
        this.cupoSobregiro = cupoSobregiro;
    }

    public CuentaCorriente(String numero, String dueno, Fecha fechaApertura, double saldo, double cupoSobregiro) {
        super(numero, dueno, fechaApertura, saldo);
        this.cupoSobregiro = cupoSobregiro;
    }

    @Override
    public boolean retirar(double valor) {
        if (valor <= 0) {
            return false;
        }
        if (valor <= saldo) {
            saldo = saldo - valor;
            return true;
        } else {
            if (valor <= saldo + cupoSobregiro) {
                saldo = saldo - valor; // el saldo queda negativo
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String mostrarDatos() {
        return "Tipo: Cuenta Corriente\n" + super.mostrarDatos()
                + "\nCupo sobregiro: " + cupoSobregiro;
    }
}