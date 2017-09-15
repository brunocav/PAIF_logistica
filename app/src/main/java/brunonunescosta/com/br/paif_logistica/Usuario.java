package brunonunescosta.com.br.paif_logistica;

import com.google.gson.annotations.SerializedName;

/**
 * Created by logonrm on 15/09/2017.
 */

public class Usuario {
    @SerializedName(value = "cep")
    private  String cepCid;

    public String getCepCid() {
        return cepCid;
    }

    public void setCepCid(String cepCid) {
        this.cepCid = cepCid;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @SerializedName(value = "tipoLogradouro")
    private  String tipo;
    @SerializedName(value = "bairro")
    private  String regiao;
    @SerializedName(value = "localidade")
    private  String cidade;
    @SerializedName(value = "uf")
    private  String estado;

}
