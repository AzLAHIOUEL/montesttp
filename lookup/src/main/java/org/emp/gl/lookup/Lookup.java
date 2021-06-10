package org.emp.gl.lookup;

import java.util.HashMap;
import java.util.Map;

public class Lookup {
    Map<Class, Object> services = new HashMap<>() ; 
        
    private Lookup() {
    }
    
    public static Lookup getInstance() {
        return NewSingletonHolder.INSTANCE;
    }
    
    private static class NewSingletonHolder {

        private static final Lookup INSTANCE = new Lookup();
    }
    
     public <T> void register (Class<? super T> service, T instance){
        services.put(service, instance) ;
    }
    
    public <T> T getService (Class<T> service){
        T instance = (T) services.get(service) ;
        return  instance ; 
    }
    
    
}
