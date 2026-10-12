/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public abstract class Cuenta {

    protected String numero;
    protected String dueno;
    protected Fecha fechaApertura;
    protected double saldo;

    
    public Cuenta(String numero, String dueno, Fecha fechaApertura) {
        this.numero = numero;
        this.dueno = dueno;
        this.fechaApertura = fechaApertura;
        this.saldo = 0;
    }

    
    public Cuenta(String numero, String dueno, Fecha fechaApertura, double saldo) {
        this.numero = numero;
        this.dueno = dueno;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }

    public String getNumero() { return numero; }
    public double getSaldo() { return saldo; }

    public boolean consignar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            return true;
        }
        return false;
    }

    public abstract boolean retirar(double valor);

    
    public String mostrarDatos() {
        return "Numero: " + numero + "\nDueno: " + dueno
                + "\nFecha apertura: " + fechaApertura + "\nSaldo: " + saldo;
    }

   
    public String mostrarDatos(boolean soloSaldo) {
        if (soloSaldo) {
            return "Saldo de la cuenta " + numero + ": " + saldo;
        }
        return mostrarDatos();
    }
}
