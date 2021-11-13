package br.com.mariojp.mobile.applicationbes.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servico {

    private static Servico instancia;


    private WebService service;
    private Servico() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/mariojp/tarefinhas/main/app/src/main/res/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(WebService.class);
    }

    public static Servico getInstacia(){
        if(instancia == null){
            instancia = new Servico();
        }
        return instancia;
    }

    public WebService getService() {
        return service;
    }


}
