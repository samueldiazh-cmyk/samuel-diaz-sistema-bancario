/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Cuenta;
import modelo.CuentaAhorros;
import modelo.CuentaCorriente;
import modelo.Fecha;

public class ControladorBanco {

    private ArrayList<Cuenta> cuentas = new ArrayList<>();

    public Cuenta buscarCuenta(String numero) {
        for (Cuenta c : cuentas) {
            if (c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    public String crearCuentaAhorros(String numero, String dueno, int dia, int mes, int anio, double saldo) {
        if (buscarCuenta(numero) != null) {
            return "Ya existe una cuenta con ese numero";
        }
        Cuenta c = new CuentaAhorros(numero, dueno, new Fecha(dia, mes, anio), saldo);
        cuentas.add(c);
        return "Cuenta creada:\n" + c.mostrarDatos();
    }

    public String crearCuentaCorriente(String numero, String dueno, int dia, int mes, int anio, double saldo, double cupo) {
        if (buscarCuenta(numero) != null) {
            return "Ya existe una cuenta con ese numero";
        }
        Cuenta c = new CuentaCorriente(numero, dueno, new Fecha(dia, mes, anio), saldo, cupo);
        cuentas.add(c);
        return "Cuenta creada:\n" + c.mostrarDatos();
    }
    public String consignar(String numero, double valor) {
        Cuenta c = buscarCuenta(numero);
        if (c == null) {
            return "Cuenta no encontrada";
        }
        if (c.consignar(valor)) {
            return "Consignacion exitosa\n" + c.mostrarDatos(true);
        }
        return "El valor debe ser mayor que cero";
    }
}