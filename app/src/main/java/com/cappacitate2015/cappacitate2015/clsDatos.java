package com.cappacitate2015.cappacitate2015;

import java.util.ArrayList;

/**
 * Created by JohnDelmar on 4/24/2015.
 */
public class clsDatos {
    public ArrayList<String> GetEspecialidades(){
        ArrayList<String> especialidades = new ArrayList<String>();

        especialidades.add("Odontología");
        especialidades.add("Dermatología");
        especialidades.add("Oftalmología");
        especialidades.add("Neurología");
        especialidades.add("Optometría");
        especialidades.add("Ginecología");

        return especialidades;
    }

    public ArrayList<clsEspecialista> GetEspecialistas(int pIndice){
        ArrayList<clsEspecialista> especialistas = new ArrayList<clsEspecialista>();
        clsEspecialista especialista;

        switch (pIndice){
            case 0:
                especialista = new clsEspecialista();
                especialista.Nombre="Dr John";
                especialista.Direccion="Bosque";
                especialista.Telefono="1234567";
                especialistas.add(especialista);

                especialista = new clsEspecialista();
                especialista.Nombre="Dr Jorge";
                especialista.Direccion="Bosque";
                especialista.Telefono="1234568";
                especialistas.add(especialista);

                break;

            case 1:
                especialista = new clsEspecialista();
                especialista.Nombre="Dr Calderon";
                especialista.Direccion="Bosque";
                especialista.Telefono="1234567";
                especialistas.add(especialista);

                especialista = new clsEspecialista();
                especialista.Nombre="Dr Arrieta";
                especialista.Direccion="Bosque";
                especialista.Telefono="1234568";
                especialistas.add(especialista);

                break;
        }
        return especialistas;
    }
}
