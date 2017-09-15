package brunonunescosta.com.br.paif_logistica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText etCep;
    private TextView tvTipo;
    private TextView tvBairro;
    private TextView tvCidade;
    private TextView tvEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCep = (EditText)findViewById(R.id.etCep);
        tvTipo = (TextView) findViewById(R.id.tvTipo);
        tvBairro = (TextView) findViewById(R.id.tvBairro);
        tvCidade = (TextView) findViewById(R.id.tvCidade);
        tvEstado = (TextView) findViewById(R.id.tvEstado);
    }


    public  void pesquisar(View v){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://correiosapi.apphb.com/").
                addConverterFactory(GsonConverterFactory.create()).build();

        GitHubServise servise = retrofit.create(GitHubServise.class);
        servise.buscarCep(etCep.getText().toString()).enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                tvTipo.setText(response.body().getTipo());
                tvEstado.setText(response.body().getRegiao());
                tvCidade.setText(response.body().getCidade());
                tvEstado.setText(response.body().getEstado());
                Toast.makeText(MainActivity.this,
                        "deu certo",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                "Ocorreu um erro na requisicao",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
