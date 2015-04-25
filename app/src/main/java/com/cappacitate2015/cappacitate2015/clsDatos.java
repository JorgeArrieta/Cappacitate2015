package com.cappacitate2015.cappacitate2015;

import java.util.ArrayList;

/**
 * Created by JohnDelmar on 4/24/2015.
 */
public class clsDatos {
    public ArrayList<String> GetEspecialidades(){
        ArrayList<String> especialidades = new ArrayList<String>();

        especialidades.add("Odontología");
        especialidades.add("Pediatría");
        especialidades.add("Dermatología");
        especialidades.add("Oftalmología");
        especialidades.add("Neurología");
        especialidades.add("Optometría");
        especialidades.add("Ginecología");
        especialidades.add("Urología");
        especialidades.add("Cardiología");
        especialidades.add("Endocrinología");
        especialidades.add("Geriatría");

        return especialidades;
    }

    public ArrayList<clsEspecialista> GetEspecialistas(int pIndice){
        ArrayList<clsEspecialista> especialistas = new ArrayList<clsEspecialista>();
        clsEspecialista especialista;

        switch (pIndice){
            case 0:
                especialista = new clsEspecialista();
                especialista.Nombre="Dr. John Calderón";
                especialista.Direccion="Bocagrande, Cra 1 Calle 10, Ofic 555";
                especialista.Telefono="(5)660 44413 - Valor Consulta: $35.000";
                especialistas.add(especialista);

                especialista = new clsEspecialista();
                especialista.Nombre="Dr. Jorge Arrieta";
                especialista.Direccion="Bocagrande, Av San Martin Calle 9, #19-13";
                especialista.Telefono="(5)665 34265 - Valor Consulta: $40.000";
                especialistas.add(especialista);

                especialista = new clsEspecialista();
                especialista.Nombre="Odontología del Caribe";
                especialista.Direccion="Bocagrande, Cra 9 Calle 7";
                especialista.Telefono="(5)442 35435 - Valor Consulta: $38.000";
                especialistas.add(especialista);

                especialista = new clsEspecialista();
                especialista.Nombre="Sesivita Odontología";
                especialista.Direccion="Bocagrande, Cra 4 Calle 6B, Local 502";
                especialista.Telefono="(5)660 3214 - Valor Consulta: $30.000";
                especialistas.add(especialista);

                break;

            case 1:
                especialista = new clsEspecialista();
                especialista.Nombre="Getting Pediatría";
                especialista.Direccion="Bocagrande, Centro Comercial Bocagrande, local 207";
                especialista.Telefono="(5)660 44413 - Valor Consulta: $50.000";
                especialistas.add(especialista);

                especialista = new clsEspecialista();
                especialista.Nombre="Clínica Pediátrica de Alergia";
                especialista.Direccion="Bocagrande, Av San Martin";
                especialista.Telefono="(5)665 34265 - Valor Consulta: $60.000";
                especialistas.add(especialista);

                especialista = new clsEspecialista();
                especialista.Nombre="MedPedriatrica";
                especialista.Direccion="Bocagrande, Av Cordoba";
                especialista.Telefono="(5)442 35435 - Valor Consulta: $55.000";
                especialistas.add(especialista);

                especialista = new clsEspecialista();
                especialista.Nombre="Pediatría y Apego";
                especialista.Direccion="Bocagrande, Edificio Medicos SA, Local 202";
                especialista.Telefono="(5)660 3214 - Valor Consulta: $62.000";
                especialistas.add(especialista);

                break;
        }
        return especialistas;
    }
}
