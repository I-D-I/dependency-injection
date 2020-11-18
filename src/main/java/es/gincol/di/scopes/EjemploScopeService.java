package es.gincol.di.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype") //singleton por defecto
public class EjemploScopeService {

}
