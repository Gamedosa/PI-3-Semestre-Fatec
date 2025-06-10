package util;

import com.google.gson.Gson;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import model.Cliente;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Utilitario {

    public static Cliente buscarEndereco(String cep){
        
        //URL do via cep com o paramentro cep
        String url = "https://viacep.com.br/ws/"+cep+"/json";
        
        //Criando um cliente HTTP
        OkHttpClient client = new OkHttpClient();
        
        //Criando uma requisição GET
        Request request = new Request.Builder()
                .url(url)
                .build();
        
        try {
            
            Response response = client.newCall(request).execute();
            
            if(response.isSuccessful()){
                
                String responseBody = response.body().string();
                
                Gson gson = new Gson();
                
                Cliente cliente = gson.fromJson(responseBody, Cliente.class);
                
                if(cliente != null && cliente.getLocalidade() != null && cliente.getUf() != null && cliente.getBairro() != null){
                    
                    cliente.setLocalidade(cliente.getLocalidade());
                    cliente.setBairro(cliente.getBairro());
                    cliente.setUf(cliente.getUf());
                    
                }
                
                return cliente;
                
            }else{
                System.out.print("Erro ao fazer a requisição: "+response.code());
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
        
    }
    public static void adicionarIcone(JFrame frame){
        
        try {
            URL  urlIcone = Utilitario.class.getResource("/imagens/LogoWiseLiving.png");
            ImageIcon icon = new ImageIcon(urlIcone);
            
            frame.setIconImage(icon.getImage());
        
        }catch (Exception e){
            System.out.println("Erro ao carregar o icone"+e.getMessage());
        }
    }
    
    
}
