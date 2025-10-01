package com.mycompany.Listadoble_24_09_25;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Marco miMarco = new Marco();
        miMarco.setTitle("OPERACIONES CON ARREGLOS");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static class Marco extends JFrame {
        public Marco() {
            setBounds(200, 200, 800, 400);
            Lamina miLamina = new Lamina();
            add(miLamina);
            setVisible(true);
        }
    }

    static class Lamina extends JPanel {
        int x;
        ListaDOble objeto;
        JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9;

        public Lamina() {


            setLayout(new AdminComponentes());
            objeto = new ListaDOble();
            boton1 = new JButton("ingresar ordenado");
            boton2 = new JButton("Mostrar lista");
            boton3 = new JButton("Suma de todos los elementos");
            boton4 = new JButton("Contar mayores que");
            boton5 = new JButton("sumar pares de lista");
            boton6 = new JButton("sumar Impares de Lista");
            boton7 = new JButton("contar Mayores que un numero");
            boton8 = new JButton("Eliminar elemento");
            boton9 = new JButton("ingrese un numero para que los mayores que se sumen");

            boton1.addActionListener(new GestionEventos());
            boton2.addActionListener(new GestionEventos());
            boton3.addActionListener(new GestionEventos());
            boton4.addActionListener(new GestionEventos());
            boton5.addActionListener(new GestionEventos());
            boton6.addActionListener(new GestionEventos());
            boton7.addActionListener(new GestionEventos());
            boton8.addActionListener(new GestionEventos());
            boton9.addActionListener(new GestionEventos());

            add(boton1);
            add(boton2);
            add(boton3);
            add(boton4);
            add(boton5);
            /*
            add(boton6);
            add(boton7);
            add(boton8);
            add(boton9);
*/

        }

        private class GestionEventos implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == boton1) {
                    x = Integer.parseInt(JOptionPane.showInputDialog("ingrese numeros para que se ordenen"));
                    objeto.ingresarDatos(x);
                    JOptionPane.showMessageDialog(null, "Lista: " + objeto.mostrarLista());
                } else if (e.getSource() == boton2) {
                    JOptionPane.showMessageDialog(null, "Lista: " + objeto.mostrarLista());
                } else if (e.getSource() == boton3) {
                    JOptionPane.showMessageDialog(null, "Lista: \n" + objeto.mostrarLista() + "\n La suma de los elementos es : " + objeto.SumarElementos());
                } else if (e.getSource() == boton4) {
                    x = Integer.parseInt(JOptionPane.showInputDialog("ingrese un numero de referencia"));
                    JOptionPane.showMessageDialog(null, "Lista: \n" + objeto.mostrarLista() + "\n La cantidad de numeros mayores que " + x + " es: " +  objeto.ContarMayores(x));
                }else if (e.getSource()== boton5) {
                    JOptionPane.showMessageDialog(null, "Lista: \n" + objeto.mostrarLista() + "\n La suma de los elementos pares es: " + objeto.SumarPares());
                }
            }
        }

        class AdminComponentes implements LayoutManager {
            int x, y = 20;

            @Override
            public void addLayoutComponent(String name, Component comp) {
                // No implementado
            }

            @Override
            public void removeLayoutComponent(Component comp) {
                // No implementado
            }

            @Override
            public Dimension preferredLayoutSize(Container parent) {
                return new Dimension(800, 400);
            }

            @Override
            public Dimension minimumLayoutSize(Container parent) {
                return new Dimension(800, 400);
            }

            @Override
            public void layoutContainer(Container miContenedor) {
                int d = miContenedor.getWidth();
                x = d / 2;
                int contador = 0;
                int n = miContenedor.getComponentCount();

                for (int i = 0; i < n; i++) {
                    contador++;
                    Component c = miContenedor.getComponent(i);
                    c.setBounds(x - 280, y, 170, 35);
                    x += 200;

                    if (contador % 3 == 0) {
                        x = d / 2;
                        y += 65;
                    }
                }
            }
        }
    }
}
