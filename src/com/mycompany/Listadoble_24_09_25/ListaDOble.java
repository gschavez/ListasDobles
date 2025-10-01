package com.mycompany.Listadoble_24_09_25;

public class ListaDOble {
    Nodo lista;

    public ListaDOble() {
        lista = null;
    }

    void ingresarDatos(int x) {
        Nodo nuevo = new Nodo(x);

        if (lista == null) {
            lista = nuevo;
            lista.sig = lista.ant = lista;
        } else if (x < lista.info) {
            // Verificar si es duplicado del primer elemento
            if (x == lista.info) {
                System.out.println("El dato " + x + " ya existe en la lista");
                return;
            }
            nuevo.sig = lista;
            nuevo.ant = lista.ant;
            lista.ant.sig = nuevo;
            lista.ant = nuevo;
            lista = nuevo;
        } else {
            Nodo p = lista.sig;
            while (p != lista && x > p.info) {
                p = p.sig;
            }

            // Verificar si encontramos un duplicado
            if (p != lista && x == p.info) {
                System.out.println("El dato " + x + " ya existe en la lista");
                return;
            }

            nuevo.sig = p;
            nuevo.ant = p.ant;
            p.ant.sig = nuevo;
            p.ant = nuevo;
        }
    }

    String mostrarLista() {
        String salida = "";
        if (lista != null) {
            salida += lista.info + " ";
            Nodo p = lista.sig;
            while (p != lista) {
                salida += p.info + " ";
                p = p.sig;
            }
        }
        return salida;
    }

    int SumarElementos() {
        int suma = 0;
        if (lista != null) {
            suma += lista.info;
            Nodo p = lista.sig;
            while (p != lista) {
                suma += p.info;
                p = p.sig;
            }
        }
        return suma;
    }

    int ContarMayores(int x) {
        int cont = 0;
        if (lista != null) {
            if (lista.info > x) {
                cont++;
            }

            // Verificar los demás nodos
            Nodo p = lista.sig;
            while (p != lista) {
                if (p.info > x) {
                    cont++;
                }
                p = p.sig;
            }
        }
        return cont;
    }

    int SumarPares() {
        int suma = 0;
        if (lista != null) {
            // Verificar el primer nodo
            if (lista.info % 2 == 0) {
                suma += lista.info;
            }

            // Verificar los demás nodos
            Nodo p = lista.sig;
            while (p != lista) {
                if (p.info % 2 == 0) {
                    suma += p.info;
                }
                p = p.sig; // Esta línea debe ejecutarse SIEMPRE
            }
        }
        return suma;
    }
}
