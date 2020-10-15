import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;

public class EstadosSucesores implements SuccessorFunction {

    @Override
    public List getSuccessors(Object o) {
        ArrayList<Successor> sucesores = new ArrayList<>();
        Estado e = (Estado) o;

        for (int i = 0; i < e.getPaquetes().size(); ++i) {
            for (int j = 0; j < e.getOfertas().size(); ++j) {
                Estado e2 = new Estado(e);
                if (e2.moverPaquete(i, j))
                    sucesores.add(new Successor("paquete " + i + " movido a oferta " + j, e2));
            }

            for (int j = i + 1; j < e.getPaquetes().size() - 1; ++j) {
                Estado e2 = new Estado(e);
                if (e2.intercambiarPaquetes(i, j))
                    sucesores.add(new Successor("paquete " + i + " intercambiado con paquete " + j, e2));
            }
        }

        return sucesores;
    }
}
