/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class CuentaAhorros extends Cuenta {

    public CuentaAhorros(String numero, String dueno, Fecha fechaApertura) {
        super(numero, dueno, fechaApertura);
    }

    public CuentaAhorros(String numero, String dueno, Fecha fechaApertura, double saldo) {
        super(numero, dueno, fechaApertura, saldo);
    }

    @Override
    public boolean retirar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo = saldo - valor;
            return true;
        }
        return false;
    }

    @Override
    public String mostrarDatos() {
        return "Tipo: Cuenta de Ahorros\n" + super.mostrarDatos();
    }
}