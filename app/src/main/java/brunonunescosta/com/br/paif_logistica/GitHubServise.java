package brunonunescosta.com.br.paif_logistica;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by logonrm on 15/09/2017.
 */

public interface GitHubServise {
    @GET("/cep/{username}/")
    Call<Usuario> buscarCep(
            @Path(value = "username")String username);
}
