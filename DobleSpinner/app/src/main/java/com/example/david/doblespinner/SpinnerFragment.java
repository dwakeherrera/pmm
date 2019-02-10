package com.example.david.doblespinner;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class SpinnerFragment extends Fragment {

    Spinner studios = null;
    Spinner works = null;

    ArrayList<Studios> autores = new ArrayList<Studios>(
            Arrays.asList(
                    new Studios(0, "Pixar", "Emeryville, Estados Unidos", 1986, R.drawable.pixar, new ArrayList<Peliculas> (
                            Arrays.asList(
                                    new Peliculas(0, "Toy Story", 1995, R.drawable.toystory,
                                            "La historia sigue las aventuras de un grupo de juguetes vivientes, en particular del vaquero Woody y el guardián espacial Buzz Lightyear. Si bien al principio rivalizan entre sí, conforme transcurre la trama se van volviendo amigos."),
                                    new Peliculas(1, "Los increíbles", 2004, R.drawable.losincreibles,
                                            "La historia está ambientada en un universo basado en la década los 60, en el que los superhéroes son reconocidos y elogiados a nivel mundial por sus acciones heroicas, permitiéndoles llevar una vida cómoda. Mr. Increíble (Bob Parr), Elastigirl (Helen Parr) y Frozono (Lucius Best) son tres superhéroes que junto a muchos otros se dedican a luchar contra el crimen en el mundo."),
                                    new Peliculas(2, "Coco", 2017, R.drawable.coco,
                                            "En el pequeño pueblo de Santa Cecilia en México vive Miguel Rivera, un niño de 12 años que sueña con ser un músico como su famoso ídolo el difunto cantante Ernesto de la Cruz, un popular compositor/cantante y estrella de cine que murió cuando fue aplastado por una campana en una presentación en vivo.")
                            )
                    )),
                    new Studios(1, "20th Century Fox", "Los Ángeles, California, Estados Unidos", 1935, R.drawable.centuryfox, new ArrayList<Peliculas> (
                            Arrays.asList(
                                    new Peliculas(0,"Avatar", 2009, R.drawable.avatar,
                                            "Ambientada en el año 2154 los acontecimientos que narra se desarrollan en Pandora, una luna del planeta Polífemo habitada por una raza humanoide llamada na'vi, con la que los humanos se encuentran en conflicto debido a que uno de sus clanes está asentado alrededor de un gigantesco árbol que cubre una inmensa veta de un mineral muy cotizado y que supondría la solución a los problemas energéticos de la Tierra: el unobtainium."),
                                    new Peliculas(1, "Deadpool", 2016, R.drawable.deadpool,
                                            "Wade Wilson es un mercenario que pasaba su tiempo en la ciudad de Nueva York protegiendo a las adolescentes de los posibles acosadores y asistía a un bar en el que los ebrios solían organizar peleas denominadas Pozos de la Muerte. Una noche en el bar, Wade conoce a Vanessa Carlysle y se convierten en novios por casi un año, durante ese tiempo deciden celebrar su amor, teniendo relaciones sexuales en todas las festividades (excepto en la Pascua de Resurrección). Cuando estaban teniendo relaciones sexuales una noche de navidad, Wade le propone matrimonio a Vanessa, luego de repente se derrumba y es diagnosticado con cáncer terminal aligado a los pulmones, próstata y cerebro, lo que hace prácticamente imposible la operación. A pesar de que Vanessa decidió no rendirse y buscar soluciones, Wade sólo quiere aprovechar el poco tiempo que le queda."),
                                    new Peliculas(2, "El gran showman", 2017, R.drawable.granshowman,
                                            "P. T. Barnum, un inteligente y manipulador personaje. Es un padre de familia del siglo XIX que queda desempleado luego de que la empresa para la que trabaja cae en bancarrota. Con la ayuda de un préstamo bancario, y la de su esposa Charity, decide cambiar su vida adquiriendo un museo de figuras de cera, que tuvo por nombre \"El museo de curiosidades de Barnum\", sin embargo, su malicia y astucia hacen que el museo se convierta en un espectáculo de rarezas para atraer la atención de más espectadores con ansias de gastar su dinero en dicho show. ")
                            )
                    )),
                    new Studios(2, "Warner Bros Entertainment", "Burbank, California, Estados Unidos", 1923, R.drawable.warnerbros, new ArrayList<Peliculas> (
                            Arrays.asList(
                                    new Peliculas(0, "Blade", 1998, R.drawable.blade,
                                            "En el año 1987, una mujer embarazada es tratada en un hospital después de ser mordida por un vampiro, pero los médicos piensan que la herida es una mordedura de un animal. Ellos tratan de revivirla, pero ella muere después de entregar a su bebé. El niño hereda la fuerza, la sed de sangre y los sentidos mejorados de los vampiros, pero no sufre sus debilidades, como el ajo o la luz del sol. Él crece hasta convertirse en Blade, el cazador de vampiros.\n" +
                                                    "\n" +
                                                    "Varios años después, Blade localiza un club delirante de vampiros y mata a la mayoría de los presentes, entre ellos el vampiro Quinn, a quien lo quema. Cuando la policía y los bomberos llegan, Blade escapa y la policía toma el cuerpo de Quinn y lo lleva al depósito de cadáveres. Cuando la Dra. Karen Jenson lleva a cabo una autopsia con un compañero de trabajo, Quinn vuelve a la vida y los ataca. Al llegar unos policías armados, Blade rescata a Jenson de Quinn y huye a su base con ella, mientras que Quinn se escapa. Allí, Blade y su mentor y técnico de armas, Abraham Whistler intentan evitar que Jenson se convierta en vampiro."),
                                    new Peliculas(1, "Matrix", 1999, R.drawable.matrix,
                                            "Thomas A. Anderson (Keanu Reeves) es programador informático de día y un hacker llamado \"Neo\" de noche. Lleva toda su vida intuyendo que hay algo más, que hay algo que falla y esa duda se ve reafirmada con un mensaje recibido en su ordenador: «Matrix te posee». Así, Neo comienza la búsqueda desesperada de una persona de la que solo ha oído hablar: otro hacker llamado Morfeo (Laurence Fishburne), alguien que puede darle la respuesta a las preguntas que tanto le atormentan: ¿qué es Matrix? y ¿por qué lo posee?2\u200B Morfeo y su equipo, al darse cuenta de que sus enemigos están buscando a Neo, deciden entrar en contacto con él.\n" +
                                                    "\n" +
                                                    "La hacker Trinity (Carrie-Anne Moss), amiga de Morfeo, lo conduce hasta él y la respuesta que busca. Pero para obtenerla debe renunciar a su vida anterior y a todo lo que había conocido antes. El símbolo de dicho proceso es aceptar tomar una pastilla roja; en cambio, otra pastilla, la azul, podría devolverlo a su mundo actual sin que, aparentemente, nada de lo que está sucediendo hubiera pasado. Neo acepta tomar la pastilla roja, olvidar su vida y todo lo que conoce para descubrir «qué es Matrix». "),
                                    new Peliculas(2, "Escuadrón Suicida", 2016, R.drawable.escuadron,
                                            "Un nuevo día rutinario comienza en la penitenciaría Belle Reve. Floyd Lawton entrena con un saco de boxeo hasta que el capitán Griggs lo interrumpe para traerle comida en mal estado. Él se molesta y le promete a Griggs que cuando salga lo haría sufrir, pero el capitán retribuye su amenaza golpeándolo junto a sus compañeros. Luego Griggs visita la celda de Harley Quinn, quien al recibir una descarga eléctrica recuerda todas las torturas a las que el capitán la sometió desde que comenzó su encarcelamiento. 5 meses después de que Superman fuera asesinado por Doomsday. Amanda Waller llega a Washington D.C, para tratar un asunto de seguridad nacional.")
                            )
                    ))
            )
    );

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.fragment_spinner, container, false);
        studios = (Spinner) view.findViewById(R.id.studios);
        works = (Spinner) view.findViewById(R.id.works);

        studios.setAdapter(new StudioAdapter(getActivity(), autores));

        studios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                works.setAdapter(new WorkAdapter(getActivity(), autores.get(position).getPeliculas()));

                final ArrayList<Peliculas> obras = autores.get(position).getPeliculas();

                works.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                        Fragment desc = DescFragment.newInstance(obras.get(position));
                        FragmentTransaction ft = getFragmentManager().beginTransaction();

                        ft.replace(R.id.description, desc);
                        ft.addToBackStack(null);
                        ft.commit();
                    }

                    public void onNothingSelected(AdapterView<?> parent) {}
                });
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });
        return view;
    }
}

class StudioAdapter extends ArrayAdapter {

    public StudioAdapter(Context context, ArrayList<Studios> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.linear_spinner_estudio, parent, false
            );
        }

        TextView name = convertView.findViewById(R.id.name);
        TextView country = convertView.findViewById(R.id.country);
        TextView founded = convertView.findViewById(R.id.founded);
        TextView moviesCount = convertView.findViewById(R.id.works_quantity);
        ImageView autor = convertView.findViewById(R.id.image);

        Studios currentItem = (Studios) getItem(position);

        if (currentItem != null) {
            name.setText("Nombre: " + currentItem.getNombre());
            country.setText("País: " + currentItem.getPais());
            founded.setText("Año fundado: " + currentItem.getAnyoFundacion());
            moviesCount.setText("Películas mostradas: " + currentItem.getPeliculas().size());
            autor.setImageResource(currentItem.getImagen());
        }

        return convertView;
    }
}

class WorkAdapter extends ArrayAdapter {

    public WorkAdapter(Context context, ArrayList<Peliculas> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.linear_spinner_peliculas, parent, false
            );
        }

        TextView name = convertView.findViewById(R.id.title);
        name.setSingleLine(false);
        TextView year = convertView.findViewById(R.id.year);
        ImageView poster = convertView.findViewById(R.id.image);

        Peliculas currentItem = (Peliculas) getItem(position);

        if (currentItem != null) {
            name.setText("Título: " + currentItem.getTitulo());
            year.setText("Año: " + currentItem.getAnyo());
            poster.setImageResource(currentItem.getImagen());
        }

        return convertView;
    }
}